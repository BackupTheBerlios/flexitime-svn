/*
 * Created on 26 déc. 2004
 * by Valère
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core.admin;

import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.admin.IConfig;
import fr.umlv.ir3.flexitime.common.data.admin.IUser;
import fr.umlv.ir3.flexitime.common.data.admin.impl.PreferencesImpl;
import fr.umlv.ir3.flexitime.common.data.admin.impl.UserImpl;
import fr.umlv.ir3.flexitime.common.rmi.admin.IUserManager;
import fr.umlv.ir3.flexitime.server.io.FlexiLDAP;

/**
 * UserManagerImpl - DOCME Description explication supplémentaire si nécessaire
 * in english please... Que fait cette classe, qu'est-ce qu'elle représente, ...
 * 
 * @version Verion ou révision SVN
 * @author FlexiTeam - Valère
 */
public class UserManager implements IUserManager
{
    FlexiLDAP ldap;
    List ConnectedUser;
    
    public UserManager(IConfig config)
    {
        //On se connecte au server ldap en utilisant la config
        ldap = new FlexiLDAP(config.getServerLDAP(),config.getPortLDAP() ,config.getPathUserLDAP(), config.getPathGroupLDAP());
        ConnectedUser = new ArrayList();
    }
    
    public boolean ConnectToRich(String name, String passwd)
    {
        if(!ConnectedUser.contains(name))
        {
            if(checkUser(name,passwd))
            {
                ConnectedUser.add(name);
                return true;
            }
            System.out.println("User doesn't exist");
        }
        else
        {
            System.out.println("User already connected");
        }
        return false;     
    }
    
    public boolean ConnectToLight(String name, String passwd)
    {
        if(checkUser(name,passwd))return true;
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
    public boolean checkUser(String name, String passwd)
    {
       //TODO (Gestion des exeptions si on ne peut pas joindre soit le LDAP soit la base de données)
        //On verifie que le User ne soit pas déja connecté
            //On vérifie d'abord si l'utilisateur se trouve dans le LDAP
            //TODO Il faudrait lire les informations concernant la config du LDAP dans la base.
            // On construit par défaut pour le moment
            if(ldap.createConnection(name,passwd))
            {
                return true;
            }
                //Si on ne l'a pas trouvé dans le LDAP on regarde si c'est un utilisateur local à l'appli    
            if(name == null)//<- a modifier pour test sur la base
            /*ICI il faut retrouver tous les utilisateurs de l'appli dans la base.
                 Ensuite il faut parcourir la liste, voir si l'on trouve l'utilisateur et vérifier son password
                 Si on le trouve on renvoit true sinon false.*/
                return true;
            //Sinon si il n'est ni dans le ldap ni dans la base alors false
                return false;
    }
    /**
     *  getUser
     * allows to take a user in the BDD
     *
     * @param name
     * @return 
     * 
     * @author   FlexiTeam - Famille
     */
    public IUser get(String name)
    {
        //TODO ligne de dessous à retirer
        IUser user = new UserImpl(name);    
        //On recupere le user dans la base
        //User user = UserStorage.get(name);
        
        //s'il existe, on le retourne
        return user;
        //sinon on retourne null
    }
    
    /**
     * addUser 
     * allows to add a user in the BDD
     *
     * @param name
     * @param password 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin
     * @author   FlexiTeam - Famille
     */
    public void save(String name, String password)
    {
        //Un user de ldap ou non?
        //On verifie si il est dans le ldap
        List list = ldap.getAttribute("uid",FlexiLDAP.TYPE_USER,name);
        if( ((String)list.get(0)).compareTo(name)!= 0 )
        {
            //Si l'utilisateur est dans le ldap
            //On lui cree un user avec une preference mais sans mot de passe
            IUser user = new UserImpl(name,new PreferencesImpl(),true);
            //Puis on l'ajoute a la base de données
            //UserStorage.add(user);
        }
        else
        {
            //Si 'utilisteur n'est pas dans le ldap
            //On cree un user avec les preferences et le mot de passe local a l'appli
            IUser user = new UserImpl(name,password,new PreferencesImpl(),false);
            //Puis on l'ajoute a la base de données
            //UserStorage.add(user);
        }
        
    }
    
    /**
     * removeUser 
     * allows to remove a user in the BDD
     *
     * @param name
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin
     * @author   FlexiTeam - Famille
     */
    public void removeUser(String name)
    {
            //On cree un user
            IUser user = new UserImpl(name);
            //Puis le retire de la base de données
            //UserStorage.delete(user);
    }
    
    /**
     * changeLocalPasswd
     * allows to change the Password of a local user
     *
     * @param name
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin
     * @author   FlexiTeam - Famille
     */
    public void changeLocalPasswd(String name,String newPassword)
    {
        //Un user de ldap ou non?
        //On verifie si il est dans le ldap
        List list = ldap.getAttribute("uid",FlexiLDAP.TYPE_USER,name);
        if( ((String)list.get(0)).compareTo(name)!= 0 )
        {
            	//Message Impossible de modifier le mot de passe
            	//Utilisateur dans le ldap
        }
        else
        {
            //Si 'utilisteur n'est pas dans le ldap
            //On recupere le user dans la base
            //User user = UserStorage.get(name);
            
            //On modifie le mot de passe
            //user.setPassword(newPassword);
            
            //On met a jour la base
            //UserStorage.update(user);
        }
        
    }

}