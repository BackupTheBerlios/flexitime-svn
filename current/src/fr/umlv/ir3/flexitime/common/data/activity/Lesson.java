/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.ressources.Resource;

/**
 * A lesson is an unavailabilities with different resources as teachers, devices and groups
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Lesson extends Busy
{

    /**
     * Returns the list of resources of a Lesson
     * 
     * @return the list of resources of a Lesson
     * @author FlexiTeam - Guillaume GUERRIN
     */
    List getLstResource();

    /**
     * Changes the list of resources of a Lesson
     * 
     * @param lstResource the new list of resources of a Lesson
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setLstResource(List lstResource);

    /**
     * Add a Resource in a lesson .
     * 
     * @param resource the new Resource in a lesson.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void addResource(Resource resource);

    /**
     * Remove Resource in a lesson.
     * 
     * @param resource the new Resource in a lesson
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void removeResource(Resource resource);

}
