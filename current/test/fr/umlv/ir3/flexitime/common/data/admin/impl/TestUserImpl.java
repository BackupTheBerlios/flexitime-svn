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
        UserImpl user = new UserImpl("name","toto");
        if(!user.getPassword().equals("toto"))fail("error password");
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
        UserImpl user = new UserImpl("name");
        user.setPassword("toto");
        if(!user.getPassword().equals("toto"))fail("error password");
    }

   
}
