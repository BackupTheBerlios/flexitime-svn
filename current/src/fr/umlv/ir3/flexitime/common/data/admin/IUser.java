/*
 * Created on 13 janv. 2005
 * by Famille
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.admin;

import fr.umlv.ir3.flexitime.common.data.IData;


/**
 * IUser
 * represents the interface of a User
 * 
 * @version 201
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IUser extends IData
{ 
    /**
     * returns the Password of a user

     * @return the Password of a user
     */
    public String getPassword();
    
    /**
     * returns the Password of a user
     *
     *  @param pass the Password of a user
     */
    public void setPassword(String pass);
    
    /**
     * returns the preference of a user
     *
     * @return the preference of a user
     */
    public IPreferences getPreferences();
    
    /**
     * set the preference of a user
     * 
     * @param pref
     *            the preference of a user
     */
    public void setPreferences(IPreferences pref);
    
    /**
     * DOCME
     * 
     * @return a boolean 
     */
    public boolean isLdap();
   
    /**
    * DOCME
    *
    * @param ldap 
    */
    public void setLdap(boolean ldap);
}

