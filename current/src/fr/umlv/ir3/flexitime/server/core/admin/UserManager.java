/*
 * Created on 26 déc. 2004
 * by Valère
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core.admin;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.sf.hibernate.HibernateException;
import fr.umlv.ir3.flexitime.common.data.admin.IUser;
import fr.umlv.ir3.flexitime.common.rmi.admin.IUserListener;
import fr.umlv.ir3.flexitime.common.rmi.admin.IUserManager;
import fr.umlv.ir3.flexitime.server.io.FlexiLDAP;
import fr.umlv.ir3.flexitime.server.io.storage.admin.UserStorage;

/**
 * UserManagerImpl - DOCME Description explication supplémentaire si nécessaire
 * in english please... Que fait cette classe, qu'est-ce qu'elle représente, ...
 * 
 * @version Verion ou révision SVN
 * @author FlexiTeam - Valère
 */
public class UserManager extends UnicastRemoteObject implements IUserManager
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long         serialVersionUID = 3689353204265400632L;
    private FlexiLDAP                 ldap;
    private Map<IUser, IUserListener> UsertoListener;
    // private Set<IUser> ConnectedUser;
    // private Set<IUserListener> listenerList;
    private Thread                    pollClientThread = new PollClientThread();
    
    private boolean doesThreadRun;

    public UserManager() throws RemoteException
    {
        // On se connecte au server ldap en utilisant la config
        ldap = new FlexiLDAP();
        // ConnectedUser = new CopyOnWriteArraySet<IUser>();
        // listenerList = new CopyOnWriteArraySet<IUserListener>();
        UsertoListener = new ConcurrentHashMap<IUser, IUserListener>();
        pollClientThread.start();
    }

    public boolean ConnectToRich(String name, String passwd)
            throws RemoteException
    {
        IUser user = checkUser(name, passwd);
        if (user == null)
        {
            System.out.println("User doesn't exist, or login/pass invalid");
            return false;
        }

        if (!UsertoListener.containsKey(user))
        {
            // UsertoListener.put(user, null);
            return true;
        }
        System.out.println("User already connected");
        return false;
    }

    public boolean ConnectToLight(String name, String passwd)
            throws RemoteException
    {
        if (ldap.createConnection(name, passwd)) return true;
        return false;
    }

    /**
     * checkUser - DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param name
     * @param passwd
     * @see fr.umlv.ir3.flexitime.common.rmi.admin.IUserListener#checkUser(java.lang.String,
     *      java.lang.String)
     * @author FlexiTeam - Valère
     * @date 26 déc. 2004
     */
    private IUser checkUser(String name, String passwd) throws RemoteException
    {
        // //TODO (Gestion des exeptions si on ne peut pas joindre soit le LDAP
        // soit la base de données)
        // // On verifie que le User ne soit pas déja connecté
        //        
        // // On vérifie d'abord si l'utilisateur se trouve dans le LDAP
        //        
        // if(ldap.createConnection(name,passwd)) return UserStorage.get(name);
        // // Si on ne l'a pas trouvé dans le LDAP on regarde si c'est un
        // utilisateur local à l'appli
        // IUser user = null;
        // try
        // {
        // user = UserStorage.get(name);
        // }
        // catch (HibernateException e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        //        
        // if(user==null)
        // return false;
        //        
        // if(passwd.compareTo(user.getPassword())==0)
        // return true;
        //
        // // Sinon si il n'est ni dans le ldap ni dans la base alors false
        // return false;

        IUser user = null;
        // Chargement du user depuis la BDD
        try
        {
            user = UserStorage.get(name);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Si pas présent, retourne null
        if (user == null) return user;

        // Si user LDAP, vérif login/pass
        // Si OK, retourne user
        if (ldap.createConnection(name, passwd)) return user;

        // Si pas dans LDAP, vérif login/paas de la BDD
        // Si OK, retopurne user
        if (passwd.compareTo(user.getPassword()) == 0) return user;

        // Si login/pass invalide, retourne null
        return null;
    }

    /**
     * getUser allows to take a user in the BDD
     * 
     * @param name
     * @return
     * @author FlexiTeam - Famille
     */
    public IUser get(String name) throws RemoteException
    {

        // On recupere le user dans la base
        IUser user = null;
        try
        {
            user = UserStorage.get(name);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return user;
    }

    /**
     * addUser allows to add a user in the BDD
     * 
     * @param user
     * @see fr.umlv.ir3.flexitime.common.data.admin
     * @author FlexiTeam - Famille
     */
    public IUser save(IUser user) throws RemoteException
    {
        // Un user de ldap ou non?
        // On verifie si il est dans le ldap
        List list = ldap.getAttribute("uid", FlexiLDAP.TYPE_USER, user
                .getName());
        if (list != null
                && ( (String) list.get(0) ).compareTo(user.getName()) != 0)
        {
            // Si l'utilisateur est dans le ldap
            // On lui cree un user avec une preference mais sans mot de passe
            // IUser user = new UserImpl(name,new PreferencesImpl(),true);
            // Puis on l'ajoute a la base de données
            // UserStorage.add(user);
        }
        else
        {
            // Si 'utilisteur n'est pas dans le ldap
            // On cree un user avec les preferences et le mot de passe local a
            // l'appli
            try
            {
                // Puis on l'ajoute a la base de données
                UserStorage.save(user);
            }
            catch (HibernateException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return user;
    }

    /**
     * removeUser allows to remove a user in the BDD
     * 
     * @param user
     * @see fr.umlv.ir3.flexitime.common.data.admin
     * @author FlexiTeam - Famille
     */
    public void removeUser(IUser user) throws RemoteException
    {
        try
        {
            // Puis le retire de la base de données
            UserStorage.delete(user);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * changeLocalPasswd allows to change the Password of a local user
     * 
     * @param name
     * @see fr.umlv.ir3.flexitime.common.data.admin
     * @author FlexiTeam - Famille
     */
    public void changeLocalPasswd(String name, String newPassword)
            throws RemoteException
    {
        // Un user de ldap ou non?
        // On verifie si il est dans le ldap
        List list = ldap.getAttribute("uid", FlexiLDAP.TYPE_USER, name);
        if ( ( (String) list.get(0) ).compareTo(name) != 0)
        {
            // Message Impossible de modifier le mot de passe
            // Utilisateur dans le ldap
        }
        else
        {
            // Si 'utilisteur n'est pas dans le ldap
            // On recupere le user dans la base
            // User user = UserStorage.get(name);

            // On modifie le mot de passe
            // user.setPassword(newPassword);

            // On met a jour la base
            // UserStorage.update(user);
        }

    }

    public String getLongName(String login) throws RemoteException
    {
        // TODO gecos par le bon identifiant
        ArrayList list = ldap.getAttribute("gecos", FlexiLDAP.TYPE_USER, login);
        if (list == null) return "";
        Iterator it = list.iterator();
        if (it.hasNext()) return (String) it.next();
        return "";

    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param user
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.admin.IUserManager#disconnect(fr.umlv.ir3.flexitime.common.data.admin.IUser)
     */
    public void disconnect(IUser user) throws RemoteException
    {
        if (UsertoListener.containsKey(user))
        {
            removeUserListener(user);
        }

    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param u
     * @param l
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.admin.IUserManager#addUserListener(fr.umlv.ir3.flexitime.common.data.admin.IUser,
     *      fr.umlv.ir3.flexitime.common.rmi.admin.IUserListener)
     */
    public void addUserListener(IUser u, IUserListener l)
            throws RemoteException
    {
        // if(UsertoListener.containsKey(u))
        // {
        UsertoListener.put(u, l);
        // }

        if (UsertoListener.size() > 0)
        {
            doesThreadRun = true;
        }

    }
    

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param u
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.admin.IUserManager#removeUserListener(fr.umlv.ir3.flexitime.common.data.admin.IUser)
     */
    public void removeUserListener(IUser u) throws RemoteException
    {
        if (UsertoListener.containsKey(u))
        {
            UsertoListener.remove(u);
        }

        if (UsertoListener.size() == 0) 
            doesThreadRun = false;

    }

    private class PollClientThread extends Thread
    {

        /**
         * DOCME Description Quel service est rendu par cette méthode
         * <code>exemple d'appel de la methode</code>
         * 
         * @see java.lang.Thread#run()
         */
        public void run()
        {
            System.err.println("UserManager: starting thread");
            while (true)
            {
                try {
                    sleep(2000);

                    synchronized(this) {
                        while (!doesThreadRun)
                        {}
                    }
                } catch (InterruptedException e){
                }

                for (Map.Entry<IUser, IUserListener> s : UsertoListener
                        .entrySet())
                {
                    try
                    {
                        System.out.println("UserManager: polling " + s.getValue().getUser().getName());
                        s.getValue().getUser();
                    }
                    catch (RemoteException e)
                    {
                        try
                        {
                            System.err.println(s.getKey().getName() + " s'est déconnecté sauvagement, c'est mal!!!");
                            disconnect(s.getKey());
                        }
                        catch (RemoteException e1)
                        {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
