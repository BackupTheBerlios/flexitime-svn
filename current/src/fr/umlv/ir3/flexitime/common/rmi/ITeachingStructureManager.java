/*
 * Created on 4 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;


/**
 * Interface for all Data managers
 * extends Remote to be called remotely
 * 
 * @version 1.0
 * @see java.rmi.Remote
 * 
 * @author FlexiTeam - Prâsad
 */
public interface ITeachingStructureManager extends Remote
{
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param teachingStructure 
     * @return 
     */
    public boolean save(ITeachingStructure teachingStructure);
    
    /**
     *  
     * get all datas managed by this manager
     * @param _class 
     * @return all datas
     */
    public List get(IClass _class); 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param teachingStructure 
     * @return 
     */
    public boolean delete(ITeachingStructure teachingStructure);
    /**
     *  
     * updates a data
     * have to store the object and informs clients
     * @param teachingStructure 
     * @return 
     */
    public boolean update(ITeachingStructure teachingStructure);
    
}