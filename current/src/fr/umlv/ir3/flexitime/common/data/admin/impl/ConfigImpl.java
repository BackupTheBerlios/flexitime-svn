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
    private String            serverData;
    private String            serverLDAP;
    // Port de communication LDAP
    private int               portLDAP         = -1;
    // Chemin d'accèe aux utilisateurs
    private String            pathUserLDAP     = null;
    // Chemin d'accès aux groupes
    private String            pathGroupLDAP    = null;

    // ==================//
    // Constructeurs //
    // ==================//
    protected ConfigImpl()
    {}

    /**
     * DOCME
     * 
     * @param serverData
     * @param serverLDAP
     * @param portLDAP
     * @param pathUserLDAP
     * @param pathGroupLDAP
     */
    public ConfigImpl(String serverData, String serverLDAP, int portLDAP,
            String pathUserLDAP, String pathGroupLDAP)
    {
        this.serverData = serverData;
        this.serverLDAP = serverLDAP;
        this.portLDAP = portLDAP;
        this.pathUserLDAP = pathUserLDAP;
        this.pathGroupLDAP = pathGroupLDAP;
    }

    // =============//
    // Méthodes //
    // =============//
    /**
     * DOCME
     * 
     * @return the URI of server data
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IConfig#getServerData()
     */
    public String getServerData()
    {
        return ( serverData );
    }

    /**
     * DOCME
     * 
     * @param serverData
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IConfig#setServerData(java.lang.String)
     */
    public void setServerData(String serverData)
    {
        this.serverData = serverData;

    }

    /**
     * DOCME
     * 
     * @return the URI of the LDAP server
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IConfig#getServerLDAP()
     */
    public String getServerLDAP()
    {
        return serverLDAP;
    }

    /**
     * DOCME
     * 
     * @param serverLDAP
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IConfig#setServerLDAP(java.lang.String)
     */
    public void setServerLDAP(String serverLDAP)
    {
        this.serverLDAP = serverLDAP;
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
}
