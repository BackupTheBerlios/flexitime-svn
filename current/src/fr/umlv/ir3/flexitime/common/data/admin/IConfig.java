/*
 * Created on 13 janv. 2005
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.admin;

import java.io.Serializable;

/**
 * Represents the interface of a Configuration of the server
 * 
 * @version 240
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public interface IConfig extends Serializable
{
    /**
     *  getServerLDAP
     * returns the address of the server
     *
     * @return the address of the server
     * 
     * @author   FlexiTeam - Guillaume GUERRIN
     */
    public String getUriServerLDAP();
    
    /**
     *  setServerLDAP
     * set the address of the server
     *
     * @param address the address of the server
     * 
     * @author   FlexiTeam - Guillaume GUERRIN
     */
    public void setUriServerLDAP(String address);
    
    /**
     * Return DOCME
     * @return Returns the pathGroupLDAP.
     */
    public String getPathGroupLDAP();
    /**
     * Set DOCME
     * @param pathGroupLDAP The pathGroupLDAP to set.
     */
    public void setPathGroupLDAP(String pathGroupLDAP);
    /**
     * Return DOCME
     * @return Returns the pathUserLDAP.
     */
    public String getPathUserLDAP();
    /**
     * Set DOCME
     * @param pathUserLDAP The pathUserLDAP to set.
     */
    public void setPathUserLDAP(String pathUserLDAP);
    /**
     * Return DOCME
     * @return Returns the portLDAP.
     */
    public int getPortLDAP();
    /**
     * Set DOCME
     * @param portLDAP The portLDAP to set.
     */
    public void setPortLDAP(int portLDAP);
    
    /**
     * Return uriSMTPserver
     * 
     * @return Returns the uriSMTPserver.
     */
    public String getUriSMTPserver();

    /**
     * Set uriSMTPserver
     * 
     * @param uriSMTPserver
     *            The uriSMTPserver to set.
     */
    public void setUriSMTPserver(String uriSMTPserver);
    
    /**
     * Return nameBase
     * @return Returns the nameBase.
     */
    public String getNameBase();
    
    /**
     * Set nameBase
     * @param nameBase The nameBase to set.
     */
    public void setNameBase(String nameBase);
    
    /**
     * Return passBDD
     * @return Returns the passBDD.
     */
    public String getPassBDD();
    
    /**
     * Set passBDD
     * @param passBDD The passBDD to set.
     */
    public void setPassBDD(String passBDD);
    
    /**
     * Return uriServerData
     * @return Returns the uriServerData.
     */
    public String getUriServerData();

    /**
     * Set uriServerData
     * @param uriServerData The uriServerData to set.
     */
    public void setUriServerData(String uriServerData);

    /**
     * Return userBDD
     * @return Returns the userBDD.
     */
    public String getUserBDD();
    
    /**
     * Set userBDD
     * @param userBDD The userBDD to set.
     */
    public void setUserBDD(String userBDD);
}

