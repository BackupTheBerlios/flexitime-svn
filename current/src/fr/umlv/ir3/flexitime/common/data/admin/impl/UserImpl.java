/*
 * Created on 13 janv. 2005
 * by Famille
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.admin.impl;

import fr.umlv.ir3.flexitime.common.data.admin.IPreferences;
import fr.umlv.ir3.flexitime.common.data.admin.IUser;
import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;


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
public class UserImpl extends DataImpl implements IUser
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4049641187222499896L;
    //===========//
	//  Champs	 //
	//===========//
    String password;
   IPreferences preferences;
   boolean ldap;
    

    //=============//
	//Constructeurs//
    //=============//
    protected UserImpl(){}
    
    public UserImpl(String name)
    {
        super(name);
    }
    public UserImpl(String name,String password,IPreferences preferences,boolean ldap)
    {
        super(name);
        this.password = password ;
        this.preferences = preferences ;
        this.ldap =ldap;
    }
    
    public UserImpl(String name,IPreferences preferences,boolean ldap)
    {
        super(name);
        this.preferences = preferences ;
        this.ldap =ldap;
    }
    
    public UserImpl(String name,String password,boolean ldap)
    {
        super(name);
        this.password = password ;
        this.ldap =ldap;
    }
    
    //===========//
    // Méthodes  //
	//===========//
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IUser#getPassword()
     * @author   FlexiTeam - Famille
     */
    public String getPassword()
    {
        return password;
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param password 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IUser#setPassword(java.lang.String)
     * @author   FlexiTeam - Famille
     */
    public void setPassword(String password)
    {
    	this.password = password;

    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IUser#getPreference()
     * @author   FlexiTeam - Famille
     */
    public IPreferences getPreferences()
    {
        return preferences;
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param preferences 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IUser#setPreference(fr.umlv.ir3.flexitime.common.data.admin.IPreferences)
     * @author   FlexiTeam - Famille
     */
    public void setPreferences(IPreferences preferences)
    {
        this.preferences = preferences;

    }
    
    /**
     * Return DOCME
     * @return Returns the ldap.
     */
    public boolean isLdap()
    {
        return ldap;
    }
    /**
     * Set DOCME
     * @param ldap The ldap to set.
     */
    public void setLdap(boolean ldap)
    {
        this.ldap = ldap;
    }
}

