/*
 * Created on 4 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;
import java.util.List;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;


/**
 * Interface for all Data managers
 * extends Remote to be called remotely
 * 
 * @version 1.0
 * @see java.rmi.Remote
 * 
 * @author FlexiTeam - Prâsad
 */
public interface ICourseManager extends Remote
{
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param course 
     * @return 
     */
    public boolean save(ICourse course);
    
    /**
     *  
     * get all datas managed by this manager
     * @param subject 
     * @return all datas
     */
    public List get(ISubject subject); 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param course 
     * @return 
     */
    public boolean delete(ICourse course);
    /**
     *  
     * updates a data
     * have to store the object and informs clients
     * @param course 
     * @return 
     */
    public boolean update(ICourse course);
    
}

