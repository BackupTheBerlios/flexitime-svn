/*
 * Created on 13 janv. 2005
 * by Famille
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi.admin;

import java.rmi.Remote;

import fr.umlv.ir3.flexitime.common.data.admin.IUser;
import fr.umlv.ir3.flexitime.common.rmi.IDataManager;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Famille
 */
public interface IUserManager extends Remote
{
    public boolean ConnectToRich(String name, String password);
    public boolean ConnectToLight(String name, String password);
    public IUser get(String name);
    public void save(String name, String password);
    public void removeUser(String name);
    public void changeLocalPasswd(String name,String newPassword);
}


