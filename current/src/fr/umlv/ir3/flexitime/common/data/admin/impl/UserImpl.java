/*
 * Created on 13 janv. 2005
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.admin.impl;

import fr.umlv.ir3.flexitime.common.data.admin.IPreferences;
import fr.umlv.ir3.flexitime.common.data.admin.IUser;
import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;

/**
 * DOCME
 * 
 * @version 201
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public class UserImpl extends DataImpl implements IUser
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4049641187222499896L;
    // ===========//
    // Champs //
    // ===========//
    String                    password;
    IPreferences              preferences;
    boolean                   ldap;

    // =============//
    // Constructeurs//
    // =============//
    protected UserImpl()
    {}

    /**
     * 
     * DOCME
     * 
     * @param name
     */
    public UserImpl(String name)
    {
        super(name);
    }

    /**
     * 
     * DOCME
     * 
     * @param name
     * @param password
     * @param preferences
     * @param ldap
     */
    public UserImpl(String name, String password, IPreferences preferences,
            boolean ldap)
    {
        super(name);
        this.password = password;
        this.preferences = preferences;
        this.ldap = ldap;
    }

    /**
     * 
     * DOCME
     * 
     * @param name
     * @param preferences
     * @param ldap
     */
    public UserImpl(String name, IPreferences preferences, boolean ldap)
    {
        super(name);
        this.preferences = preferences;
        this.ldap = ldap;
    }

    /**
     * 
     * DOCME
     * 
     * @param name
     * @param password
     * @param ldap
     */
    public UserImpl(String name, String password, boolean ldap)
    {
        super(name);
        this.password = password;
        this.ldap = ldap;
    }

    // ===========//
    // Méthodes //
    // ===========//
    /**
     * DOCME
     * 
     * @return user password
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IUser#getPassword()
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * DOCME
     * 
     * @param password
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IUser#setPassword(java.lang.String)
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * DOCME
     * 
     * @return user preferences
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IUser#getPreferences()
     */
    public IPreferences getPreferences()
    {
        return preferences;
    }

    /**
     * DOCME
     * 
     * @param preferences
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IUser#setPreferences(fr.umlv.ir3.flexitime.common.data.admin.IPreferences)
     */
    public void setPreferences(IPreferences preferences)
    {
        this.preferences = preferences;

    }

    /**
     * Return DOCME
     * 
     * @return Returns the ldap.
     */
    public boolean isLdap()
    {
        return ldap;
    }

    /**
     * Set DOCME
     * 
     * @param ldap
     *            The ldap to set.
     */
    public void setLdap(boolean ldap)
    {
        this.ldap = ldap;
    }
    
    /** 
     * Test the equality of two users.
     *
     * @param obj other user to compare with
     * @return <code>true</code> if this object is the same as the obj
     *          argument; <code>false</code> otherwise.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        if(!(obj instanceof UserImpl))
            return false;
        UserImpl other = (UserImpl)obj;
        return this.getName().equals(other.getName());
    }
}
