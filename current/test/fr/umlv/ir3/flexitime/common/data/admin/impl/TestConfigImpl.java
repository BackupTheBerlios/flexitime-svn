/*
 * Created on 13 janv. 2005
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.admin.impl;

import junit.framework.TestCase;
import fr.umlv.ir3.flexitime.common.data.admin.IConfig;

/**
 * Defines the configuration of the server<br>
 * Implements the interface IConfig
 * 
 * @version 240
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestConfigImpl extends TestCase
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3258408452245172793L;
    // ===========//
    // Champs //
    // ===========//
    /** URI of the storage server */
    private String            uriServerData ;
    /** Name of database to store datas */
    private String            nameBase;
    /** User who will be use to connect to the database */
    private String            userBDD;
    /** Password who will be use to connect to the database */
    private String            passBDD;
    /** URI of the directory */ 
    private String            uriServerLDAP;
    /** LDAP port */
    private int               portLDAP         = -1;
    /** LDAP path to user */
    private String            pathUserLDAP;
    /** LDAP path to groups */
    private String            pathGroupLDAP;
    /** URI of the mail sender server */
    private String            uriSMTPserver;

    // ==================//
    // Constructeurs //
    // ==================//
    /**
     * Construct an empty configuration object
     */
    public TestConfigImpl()
    {}

    // ======== //
    // Méthodes //
    // ======== //
    /**
     * DOCME
     * 
     * @return the URI of the LDAP server
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IConfig#getUriServerLDAP()
     */
    public void testGetUriServerLDAP()
    {
    }

    /**
     * DOCME
     * 
     * @param serverLDAP
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IConfig#setUriServerLDAP(java.lang.String)
     */
    public void testSetUriServerLDAP()
    {
    }

    /**
     * Return DOCME
     * 
     * @return Returns the pathGroupLDAP.
     */
    public void testGetPathGroupLDAP()
    {
    }

    /**
     * Set DOCME
     * 
     * @param pathGroupLDAP
     *            The pathGroupLDAP to set.
     */
    public void testSetPathGroupLDAP()
    {
    }

    /**
     * Return DOCME
     * 
     * @return Returns the pathUserLDAP.
     */
    public void testGetPathUserLDAP()
    {
    }

    /**
     * Set DOCME
     * 
     * @param pathUserLDAP
     *            The pathUserLDAP to set.
     */
    public void testSetPathUserLDAP()
    {
    }

    /**
     * Return DOCME
     * 
     * @return Returns the portLDAP.
     */
    public void testGetPortLDAP()
    {
    }

    /**
     * Set DOCME
     * 
     * @param portLDAP
     *            The portLDAP to set.
     */
    public void testSetPortLDAP()
    {
    }

    /**
     * Return uriSMTPserver
     * 
     * @return Returns the uriSMTPserver.
     */
    public void testGetUriSMTPserver()
    {
    }

    /**
     * Set uriSMTPserver
     * 
     * @param uriSMTPserver
     *            The uriSMTPserver to set.
     */
    public void testSetUriSMTPserver()
    {
    }
    
    /**
     * Return nameBase
     * @return Returns the nameBase.
     */
    public void testGetNameBase()
    {
    }
    
    /**
     * Set nameBase
     * @param nameBase The nameBase to set.
     */
    public void testSetNameBase()
    {
    }
    
    /**
     * Return passBDD
     * @return Returns the passBDD.
     */
    public void testGetPassBDD()
    {
    }
    
    /**
     * Set passBDD
     * @param passBDD The passBDD to set.
     */
    public void testSetPassBDD()
    {
    }
    
    /**
     * Return uriServerData
     * @return Returns the uriServerData.
     */
    public void testGetUriServerData()
    {
    }

    /**
     * Set uriServerData
     * @param uriServerData The uriServerData to set.
     */
    public void testSetUriServerData()
    {
    }

    /**
     * Return userBDD
     * @return Returns the userBDD.
     */
    public void testGetUserBDD()
    {
    }
    
    /**
     * Set userBDD
     * @param userBDD The userBDD to set.
     */
    public void testSetUserBDD()
    {
    }
}
