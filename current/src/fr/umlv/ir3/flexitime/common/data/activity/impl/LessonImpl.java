/*
 * Created on 5 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.activity.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.ressources.IResource;


/**
 * Defines an unavailibility for a course in the TimeTable.
 * Contains a list of associated resources, a start and an end date and a name.
 * 
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class LessonImpl extends BusyImpl implements ILesson
{
    //===========//
	//  Champs	 //
	//===========//
    private List listOfResources; 
    
    //=============//
	//Constructeurs//
    //=============//
	/**
	 * Default constructor for a lesson's unavailibility. 
	 */
	public LessonImpl()
	{}
    
    /**
     * Constructs an unavailibility for a course. 
     * 
     * @param strName a string.
     * @param daStart the start date of the unavailibility.
     * @param daEnd the end date of the unavailibility.
     * 
     */
    public LessonImpl(String strName, Date daStart, Date daEnd)
    {
        super(strName,daStart,daEnd);
        listOfResources = new ArrayList();
    }
    
    
    
    
    //===========//
    // Méthodes  //
	//===========//
    /** 
     * Returns the list of resources contained by the lesson.
     * <code>List list = getLstResource()</code>
     *
     * @return the list of resources contained by the lesson.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getLstResource()
     */
    public List getLstResource()
    {
        return listOfResources;
    }

    /** 
     * Creates a new arrayList based on the list given in parameter.
     * <code>setLstResource(lstResource)</code>
     *
     * @param lstResource the original list of resources contained by the lesson.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setLstResource(java.util.List)
     */
    public void setLstResource(List lstResource)
    {
        listOfResources = new ArrayList(lstResource);
    }

    /** 
     * Adds a resource to the list of resources contained by the lesson.
     * <code>addResource(resource)</code>
     *
     * @param resource resource to add to the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#addResource(fr.umlv.ir3.flexitime.common.data.ressources.IResource)
     */
    public void addResource(IResource resource)
    {
        listOfResources.add(resource);
    }

    /** 
     * Removes a resource of the list of resources contained by the lesson.
     * <code>removeResource(resource)</code>
     *
     * @param resource resource to remove of the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#removeResource(fr.umlv.ir3.flexitime.common.data.ressources.IResource)
     */
    public void removeResource(IResource resource)
    {
        listOfResources.remove(resource);
    }

    
}

