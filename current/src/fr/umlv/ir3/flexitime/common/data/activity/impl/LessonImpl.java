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
public class LessonImpl implements ILesson
{

    private List listOfResources; 
    private Date startDate;
    private Date endDate;
    private String name;
    
    /**
     * Constructs an unavailibility for a course. 
     * 
     * @param sName a string.
     * @param startD the start date of the unavailibility.
     * @param endD the end date of the unavailibility.
     * 
     */
    public LessonImpl(String sName, Date startD, Date endD)
    {
        startDate = startD;
        endDate = endD;
        name = sName;        
    }
    
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

    /** 
     * Returns the start date of the lesson.
     * <code>Date date = getStartDate()</code>
     *
     * @return the start date of the lesson.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#getStartDate()
     */
    public Date getStartDate()
    {
        return startDate;
    }

    /** 
     * Sets the start date of the lesson.
     * <code>setStartDate(daBusy)</code>
     *
     * @param daBusy a date.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#setStartDate(java.util.Date)
     */
    public void setStartDate(Date daBusy)
    {
        startDate = daBusy;
    }

    /** 
     * Returns the end date of the lesson.
     * <code>Date date = getEndDate()</code>
     *
     * @return the end date of the lesson.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#getEndDate()
     */
    public Date getEndDate()
    {
        return endDate;
    }

    /** 
     * Sets the end date of the lesson.
     * <code>setEndDate(daBusy)</code>
     *
     * @param daBusy a date.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#setEndDate(java.util.Date)
     */
    public void setEndDate(Date daBusy)
    {
        endDate = daBusy;
    }

    /** 
     * Returns the name of the lesson.
     * <code>String name = getName()</code>
     *
     * @return the name of the lesson.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#getName()
     */
    public String getName()
    {
        return name;
    }

    /** 
     * Sets the name of the lesson.
     * <code>setName(name)</code>
     *
     * @param name a string.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#setName(java.lang.String)
     */
    public void setName(String name)
    {
        this.name = name;
    }

}

