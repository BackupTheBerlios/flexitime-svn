/*
 * Created on 13 janv. 2005
 * by Famille
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.admin.impl;

import fr.umlv.ir3.flexitime.common.data.admin.IConfig;
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
public class ConfigImpl extends DataImpl implements IConfig
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3258408452245172793L;
    //===========//
	//  Champs	 //
	//===========//
    private String serverData;
    private String serverLDAP;
    //  Port de communication LDAP
    private int                portLDAP       = -1;
    //Chemin d'accèe aux utilisateurs
    private String             pathUserLDAP   = null;
    //Chemin d'accès aux groupes
    private String             pathGroupLDAP  = null;
    
	//==================//
	//   Constructeurs  //
	//==================//
    protected ConfigImpl(){}
    
    /**
     * 
     * DOCME
     * @param serverData
     * @param serverLDAP
     * @param portLDAP
     * @param pathUserLDAP
     * @param pathGroupLDAP
     */
    public ConfigImpl(String serverData,String serverLDAP,int portLDAP, String pathUserLDAP, String pathGroupLDAP)
    {
        this.serverData = serverData ;
        this.serverLDAP = serverLDAP ;
        this.portLDAP = portLDAP ;
        this.pathUserLDAP = pathUserLDAP ;
        this.pathGroupLDAP = pathGroupLDAP ;
    }
    
    
    //  =============//
	//   Méthodes  //
	//=============//
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IConfig#getServerData()
     * @author   FlexiTeam - Famille
     */
    public String getServerData()
    {
        	return(serverData );
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param address 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IConfig#setServerData(java.lang.String)
     * @author   FlexiTeam - Famille
     */
    public void setServerData(String serverData)
    {
        this.serverData = serverData ;

    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IConfig#getServerLDAP()
     * @author   FlexiTeam - Famille
     */
    public String getServerLDAP()
    {
        	return serverLDAP ;
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param address 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.admin.IConfig#setServerLDAP(java.lang.String)
     * @author   FlexiTeam - Famille
     */
    public void setServerLDAP(String serverLDAP)
    {
        this.serverLDAP = serverLDAP ; 
    }

    /**
     * Return DOCME
     * @return Returns the pathGroupLDAP.
     */
    public String getPathGroupLDAP()
    {
        return pathGroupLDAP;
    }
    /**
     * Set DOCME
     * @param pathGroupLDAP The pathGroupLDAP to set.
     */
    public void setPathGroupLDAP(String pathGroupLDAP)
    {
        this.pathGroupLDAP = pathGroupLDAP;
    }
    /**
     * Return DOCME
     * @return Returns the pathUserLDAP.
     */
    public String getPathUserLDAP()
    {
        return pathUserLDAP;
    }
    /**
     * Set DOCME
     * @param pathUserLDAP The pathUserLDAP to set.
     */
    public void setPathUserLDAP(String pathUserLDAP)
    {
        this.pathUserLDAP = pathUserLDAP;
    }
    /**
     * Return DOCME
     * @return Returns the portLDAP.
     */
    public int getPortLDAP()
    {
        return portLDAP;
    }
    /**
     * Set DOCME
     * @param portLDAP The portLDAP to set.
     */
    public void setPortLDAP(int portLDAP)
    {
        this.portLDAP = portLDAP;
    }
}

