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
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IUser extends IData
{ 
    /**
     *  getPassword
     * returns the Password of a user
     * 
     *
     *  @return the Password of a user
     * 
     * @author   FlexiTeam - Guillaume GUERRIN
     */
    public String getPassword();
    
    /**
     *  setPassword
     * returns the Password of a user
     * 
     *
     *  @param pass the Password of a user
     * 
     * @author   FlexiTeam - Guillaume GUERRIN
     */
    public void setPassword(String pass);
    
    /**
     *  getPreference
     * returns the preference of a user
     * 
     *
     *  @return the preference of a user
     * 
     * @author   FlexiTeam - Guillaume GUERRIN
     */
    public IPreferences getPreferences();
    
    /**
     *  setPreference
     * set the preference of a user
     * 
     *
     *  @param pref the preference of a user
     * 
     * @author   FlexiTeam - Guillaume GUERRIN
     */
    public void setPreferences(IPreferences pref);
    
    /**
     *  
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @author   FlexiTeam - Famille
     */
    public boolean isLdap();
   
    /**
    *  
    * DOCME Description
    * Quel service est rendu par cette méthode
    * <code>exemple d'appel de la methode</code>
    *
    * @param ldap 
    * 
    * @see (si nécessaire)
    * @author   FlexiTeam - Famille
    */
    public void setLdap(boolean ldap);
}

