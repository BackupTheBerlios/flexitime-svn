/*
 * Created on 4 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;


/**
 * Interface for all Data managers
 * extends Remote to be called remotely
 * 
 * @version 1.0
 * @see java.rmi.Remote
 * 
 * @author FlexiTeam - Prâsad
 */
public interface IFloorManager extends Remote
{
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param floor 
     * @return 
     */
    public boolean save(IFloor floor);
    
    /**
     *  
     * get all datas managed by this manager
     * @param building 
     * @return all datas
     */
    public List get(IBuilding building); 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param floor 
     * @return 
     */
    public boolean delete(IFloor floor);
    /**
     *  
     * updates a data
     * have to store the object and informs clients
     * @param floor 
     * @return 
     */
    public boolean update(IFloor floor);
    
}

