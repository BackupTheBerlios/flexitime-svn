/*
 * Created on 13 d�c. 2004
 * by Val�re FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi.admin;

import java.rmi.Remote;


/**
 * Users - Implements the interface Users
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Val�re FOREL
 */
public interface IUserManager extends Remote{
   
    /** 
     * checkUser - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param passwd 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public void checkUser(String name, String passwd);

}
