/*
 * Créé le 18 nov. 2004
 * http://java.sun.com/products/jndi/tutorial/ldap/connect/create.html
 */

package fr.umlv.ir3.flexitime.server.io;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.NamingException;

/**
 * @author Valère FOREL
 */
public class FlexiLDAP
{

    //Type de conteneur (GROUP ou USER)
    /**
     * Comment for <code>TYPE_USER</code>
     */
    public static final int    TYPE_USER  = 1;
    /**
     * Comment for <code>TYPE_GROUP</code>
     */
    public static final int    TYPE_GROUP = 2;
    //Context LDAP
    private InitialLdapContext ctx        = null;
    //Host du serveur LDAP
    private String             serverLdap = null;
    //Port de communication LDAP
    private int                port       = -1;
    //Chemin d'accèe aux utilisateurs
    private String             pathUser   = null;
    //Chemin d'accès aux groupes
    private String             pathGroup  = null;
    //Utilisateurs loggé courant
    private String             loginAs    = null;

    /**
     * Constructeur par défaut Initialise les attributs selon les paramètres de
     * l'UMLV
     */
    public FlexiLDAP()
    {
        serverLdap = "ldapetud.univ-mlv.fr"; //$NON-NLS-1$
        port = 389;
        pathUser = "ou=Users,ou=Etudiant,dc=univ-mlv,dc=fr"; //$NON-NLS-1$
        pathGroup = "ou=Groups,ou=Etudiant,dc=univ-mlv,dc=fr"; //$NON-NLS-1$
    }

    /**
     * Constructeur avec arguments
     * 
     * @param serverLdap le hostname du serveur LDAP
     * @param port le port LDAP
     * @param pathUser le chemin d'accèe aux utilisateurs
     * @param pathGroup le chemin d'accès aux groupes
     */
    public FlexiLDAP(String serverLdap, int port, String pathUser,
            String pathGroup)
    {
        this.serverLdap = serverLdap;
        this.port = port;
        this.pathUser = pathUser;
        this.pathGroup = pathGroup;
    }

    /**
     * Test la connexion d'un utilisateur
     * 
     * @param name le login de l'utilisateur
     * @param passwd le mot de passe de l'utilisateur
     * @return true si la connexion à réussi, false sinon
     */
    public boolean createConnection(String name, String passwd)
    {
        // Si l'utilisateur est déjà loggé
        if (loginAs != null && loginAs.equals(name) && ctx != null)
                return true;
        closeConnection();
        Hashtable env = new Hashtable();
        //	Creation du Context Ldap
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory"); //$NON-NLS-1$
        env
                .put(Context.PROVIDER_URL,
                        "ldap://" + serverLdap + ":" + port + "/"); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
        env.put(Context.SECURITY_AUTHENTICATION, "simple"); //$NON-NLS-1$
        env.put(Context.SECURITY_PRINCIPAL, "uid=" + name + "," + pathUser); //$NON-NLS-1$//$NON-NLS-2$
        env.put(Context.SECURITY_CREDENTIALS, passwd);

        try
        {
            //	Connexion au LDAP
            ctx = new InitialLdapContext(env, null);
            loginAs = name;
            return true;
            // Erreur de connexion
        }
        catch (NamingException e)
        {
            ctx = null;
            return false;
        }
    }

    /**
     * Retire les valeurs d'un attribut pour une ressource donnée
     * 
     * @param component l'attribut
     * @param type le type de ressource (utilisateur ou groupe)
     * @param name le login ou nom de groupe
     * @return une liste de valeurs correspondant à l'attribut demandé
     */
    public ArrayList getAttribute(String component, int type, String name)
    {
        // Si on est pas connecté
        if (ctx == null) return null;
        ArrayList l = null;
        String str = ""; //$NON-NLS-1$
        try
        {
            // Si c'est un utilisateur
            if (type == TYPE_USER)
                str = "uid=" + name + "," + pathUser; //$NON-NLS-1$//$NON-NLS-2$
            // Si c'est un groupe
            else if (type == TYPE_GROUP)
                str = "cn=" + name + "," + pathGroup; //$NON-NLS-1$ //$NON-NLS-2$
            else
                return null;
            // Récupération des attributs de la ressource
            Attributes attrs = ctx.getAttributes(str);
            Enumeration enumer = attrs.getAll();
            // On recherche l'attribut donné
            while (enumer.hasMoreElements())
            {
                Attribute attr = (Attribute) enumer.nextElement();
                // Si on a trouvé l'attribut
                if (attr.getID().equals(component))
                {
                    l = new ArrayList();
                    Enumeration enum2 = attr.getAll();
                    // On sauvegarde les valeurs de l'attribut dans une liste
                    while (enum2.hasMoreElements())
                    {
                        l.add(enum2.nextElement());
                    }
                    return l;
                }
            }
        }
        catch (NamingException e)
        {
            l = null;
        }
        return l;
    }

    /**
     * Fermeture de connexion avec la base LDAP
     */
    public void closeConnection()
    {
        ctx = null;
        loginAs = null;
    }

    /**
     * Test si l'utilisateur est déjà connecté
     * 
     * @param name le login de l'utilisateur
     * @return true s'il est déjà connecté, false sinon
     */
    public boolean isConnected(String name)
    {
        if ( (name.equals(loginAs)) && (ctx != null)) return true;
        return false;
    }

    /**
     * @param pathGroup le chemin d'accès aux groupes
     */
    public void setPathGroup(String pathGroup)
    {
        this.pathGroup = pathGroup;
    }

    /**
     * @param pathUser le chemin d'accès aux utilisateurs
     */
    public void setPathUser(String pathUser)
    {
        this.pathUser = pathUser;
    }
}