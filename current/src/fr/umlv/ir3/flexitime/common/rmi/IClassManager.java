/*
 * Created on 4 janv. 2005
 * by Pr�sad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;
import java.util.List;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;


/**
 * Interface for all Data managers
 * extends Remote to be called remotely
 * 
 * @version 1.0
 * @see java.rmi.Remote
 * 
 * @author FlexiTeam - Pr�sad
 */
public interface IClassManager extends Remote
{
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param _class 
     * 
     * @return 
     */
    public boolean save(IClass _class);
    
    /**
     *  
     * get all datas managed by this manager
     * @param track 
     * 
     * @return all datas
     */
    public List get(ITrack track); 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param _class 
     * 
     * @return 
     */
    public boolean delete(IClass _class);
    /**
     *  
     * updates a data
     * have to store the object and informs clients
     * @param _class 
     *
     * @return 
     */
    public boolean update(IClass _class);
    
}

