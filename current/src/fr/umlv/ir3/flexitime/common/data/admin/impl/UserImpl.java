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
 * Defines un user in the BDD<br>
 * Implements the interface IUser
 * 
 * @version 260
 * 
 * @author FlexiTeam - Jérôme GUERS
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
    
    private int privilege;

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
     * @param rigths 
     */
    public UserImpl(String name, int rigths)
    {
        this(name, null, rigths, DataFactory.createPreferences());
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
     * @param pass
     * @param rigths 
     */
    public UserImpl(String name, String pass, int rigths)
    {
        this(name, pass, rigths, DataFactory.createPreferences());
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
     * @param rigths 
     * @param pref
     */
    public UserImpl(String name, int rigths, IPreferences pref)
    {
        this(name, null, rigths, pref);
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
    
    /**
     * 
     * DOCME
     * 
     * @param name
     * @param pass
     * @param rigths 
     * @param pref
     */
    public UserImpl(String name, String pass, int rigths, IPreferences pref)
    {
        super(name);
        password = pass;
        preferences = pref;
        privilege = rigths;
    }

    // ======== //
    // Méthodes //
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
    
    
    /** 
     * @return privilege fot this user 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IUser#getPrivilege()
     */
    public int getPrivilege()
    {
        return privilege;
    }
    
    
    /** 
     * @param newPrivilege 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IUser#setPrivilege(int)
     */
    public void setPrivilege(int newPrivilege)
    {
        privilege = newPrivilege;
    }
}
