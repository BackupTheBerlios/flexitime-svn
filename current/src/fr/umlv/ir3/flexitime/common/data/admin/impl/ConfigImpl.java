/*
 * Created on 13 janv. 2005
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.admin.impl;

import fr.umlv.ir3.flexitime.common.data.admin.IConfig;
import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;

/**
 * DOCME
 * 
 * @version 201
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public class ConfigImpl extends DataImpl implements IConfig
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3258408452245172793L;
    // ===========//
    // Champs //
    // ===========//
    /** URI of the storage server */
    private String            uriServerData    = null;
    /** Name of database to store datas */
    private String            nameBase         = null;
    /** User who will be use to connect to the database */
    private String            userBDD          = null;
    /** Password who will be use to connect to the database */
    private String            passBDD          = null;
    /** URI of the directory */ 
    private String            uriServerLDAP;
    /** LDAP port */
    private int               portLDAP         = -1;
    /** LDAP path to user */
    private String            pathUserLDAP     = null;
    /** LDAP path to groups */
    private String            pathGroupLDAP    = null;
    /** URI of the mail sender server */
    private String            uriSMTPserver    = null;

    // ==================//
    // Constructeurs //
    // ==================//
    /**
     * Construct an empty configuration object
     */
    public ConfigImpl()
    {}

    // =============//
    // M�thodes //
    // =============//
    /**
     * DOCME
     * 
     * @return the URI of the LDAP server
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IConfig#getUriServerLDAP()
     */
    public String getUriServerLDAP()
    {
        return uriServerLDAP;
    }

    /**
     * DOCME
     * 
     * @param serverLDAP
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IConfig#setUriServerLDAP(java.lang.String)
     */
    public void setUriServerLDAP(String serverLDAP)
    {
        this.uriServerLDAP = serverLDAP;
    }

    /**
     * Return DOCME
     * 
     * @return Returns the pathGroupLDAP.
     */
    public String getPathGroupLDAP()
    {
        return pathGroupLDAP;
    }

    /**
     * Set DOCME
     * 
     * @param pathGroupLDAP
     *            The pathGroupLDAP to set.
     */
    public void setPathGroupLDAP(String pathGroupLDAP)
    {
        this.pathGroupLDAP = pathGroupLDAP;
    }

    /**
     * Return DOCME
     * 
     * @return Returns the pathUserLDAP.
     */
    public String getPathUserLDAP()
    {
        return pathUserLDAP;
    }

    /**
     * Set DOCME
     * 
     * @param pathUserLDAP
     *            The pathUserLDAP to set.
     */
    public void setPathUserLDAP(String pathUserLDAP)
    {
        this.pathUserLDAP = pathUserLDAP;
    }

    /**
     * Return DOCME
     * 
     * @return Returns the portLDAP.
     */
    public int getPortLDAP()
    {
        return portLDAP;
    }

    /**
     * Set DOCME
     * 
     * @param portLDAP
     *            The portLDAP to set.
     */
    public void setPortLDAP(int portLDAP)
    {
        this.portLDAP = portLDAP;
    }

    /**
     * Return uriSMTPserver
     * 
     * @return Returns the uriSMTPserver.
     */
    public String getUriSMTPserver()
    {
        return uriSMTPserver;
    }

    /**
     * Set uriSMTPserver
     * 
     * @param uriSMTPserver
     *            The uriSMTPserver to set.
     */
    public void setUriSMTPserver(String uriSMTPserver)
    {
        this.uriSMTPserver = uriSMTPserver;
    }
    
    /**
     * Return nameBase
     * @return Returns the nameBase.
     */
    public String getNameBase()
    {
        return nameBase;
    }
    
    /**
     * Set nameBase
     * @param nameBase The nameBase to set.
     */
    public void setNameBase(String nameBase)
    {
        this.nameBase = nameBase;
    }
    
    /**
     * Return passBDD
     * @return Returns the passBDD.
     */
    public String getPassBDD()
    {
        return passBDD;
    }
    
    /**
     * Set passBDD
     * @param passBDD The passBDD to set.
     */
    public void setPassBDD(String passBDD)
    {
        this.passBDD = passBDD;
    }
    
    /**
     * Return uriServerData
     * @return Returns the uriServerData.
     */
    public String getUriServerData()
    {
        return uriServerData;
    }

    /**
     * Set uriServerData
     * @param uriServerData The uriServerData to set.
     */
    public void setUriServerData(String uriServerData)
    {
        this.uriServerData = uriServerData;
    }

    /**
     * Return userBDD
     * @return Returns the userBDD.
     */
    public String getUserBDD()
    {
        return userBDD;
    }
    
    /**
     * Set userBDD
     * @param userBDD The userBDD to set.
     */
    public void setUserBDD(String userBDD)
    {
        this.userBDD = userBDD;
    }
}
