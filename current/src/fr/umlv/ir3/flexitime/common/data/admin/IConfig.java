/*
 * Created on 13 janv. 2005
 * by Famille
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.admin;

import fr.umlv.ir3.flexitime.common.data.IData;


/**
 * IConfig
 * represents the interface of a Configuration
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IConfig extends IData
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
}

