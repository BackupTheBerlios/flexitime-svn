/*
 * Created on 13 janv. 2005
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.admin.impl;

import junit.framework.TestCase;
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
public class TestUserImpl extends TestCase
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
    protected TestUserImpl()
    {}

    
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
    public void testGetPassword()
    {
    }

    /**
     * DOCME
     * 
     * @param password
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IUser#setPassword(java.lang.String)
     */
    public void testSetPassword()
    {
    }

    /**
     * DOCME
     * 
     * @return user preferences
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IUser#getPreferences()
     */
    public void testGetPreferences()
    {
    }

    /**
     * DOCME
     * 
     * @param preferences
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IUser#setPreferences(fr.umlv.ir3.flexitime.common.data.admin.IPreferences)
     */
    public void testSetPreferences()
    {
    }
    
    /**
     * @return Returns the ldap.
     */
    public void testIsLdap()
    {
    }
    
    
    /** 
     * @return privilege fot this user 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IUser#getPrivilege()
     */
    public void testGetPrivilege()
    {
    }
    
    
    /** 
     * @param newPrivilege 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IUser#setPrivilege(int)
     */
    public void testSetPrivilege()
    {
    }
}
