/*
 * Created on 13 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.io.storage;



import java.util.List;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;


/**
  * Class that has the responsibility to persist ICourse in database
 * 
 * @version 0.1

 * 
 * @author FlexiTeam - Prâsad
 */
public class CourseStorage
{
    /**
     *  Saves a course in database
     * 
     * @param course ICourse to save 
     */
    public static void save(ICourse course)
    {
        
    }
    
    /**
     *  
     * Method to get all the courses
     * @return List of ICourse
     * 
     */
    public static List get()
    {
        return null;
    }
    
    /**
     *  
     * Updates a course in database
     * @param course ICourse to update
     * 
     */
    public static void update(ICourse course)
    {
        
    }
    
    /**
     *  
     * Deletes a course from the database
     *
     * @param course ICourse to delete
     * 
     */
    public static void delete(ICourse course)
    {
        
    }
}

