/*
 * Created on 13 janv. 2005
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.admin.impl;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.admin.*;
import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;

/**
 * DOCME
 * 
 * @version 260
 * 
 * @author FlexiTeam - J�r�me GUERS
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
        this(name, null, DataFactory.createPreferences());
    }

    /**
     * 
     * DOCME
     * 
     * @param name
     * @param pass
     */
    public UserImpl(String name, String pass)
    {
        this(name, pass, DataFactory.createPreferences());
    }

    /**
     * 
     * DOCME
     * 
     * @param name
     * @param pref
     */
    public UserImpl(String name, IPreferences pref)
    {
        this(name, null, pref);
    }

    /**
     * 
     * DOCME
     * 
     * @param name
     * @param pass
     * @param pref
     */
    public UserImpl(String name, String pass, IPreferences pref)
    {
        super(name);
        password = pass;
        preferences = pref;
    }

    // ======== //
    // M�thodes //
    // ======== //
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
     * @return Returns the ldap.
     */
    public boolean isLdap()
    {
        return (password == null);
    }
}
