/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.teachingStructure.impl;

import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;


/**
 * Defines a subjects' group, it contains subjects.
 * 
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class SubjectsGroupImpl implements ISubjectsGroup
{
    //===========//
	//  Champs	 //
	//===========//
    private String strName;
    private List listOfSubjects;
    
    
	//=============//
	//Constructeurs//
    //=============//
    /**
     * Constructs a subjects' group.
     * 
     * @param name a string.
     * @param listSubjects a list of subjects.
     * 
     */
    public SubjectsGroupImpl(String name, List listSubjects)
    {
        this.strName = name;
        this.listOfSubjects = new ArrayList(listSubjects);
    }

    
    //===========//
    // Méthodes  //
	//===========//
    /** 
     * Returns the list of subjects.
     * <code>List l = group.getLstSubject()</code>
     *
     * @return the list of subjects.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#getLstSubject()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public List getLstSubject()
    {
        return listOfSubjects;
    }

    /** 
     * Sets the list of subjects.
     * <code>group.setLstSubject(lst)</code>
     *
     * @param lstSubject the list of subjects. 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#setLstSubject(java.util.List)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setLstSubject(List lstSubject)
    {
        this.listOfSubjects = new ArrayList(lstSubject);
    }

    /** 
     * Adds a subject to the list.
     * <code>group.addSubject(subject)</code>
     *
     * @param subject a subject to add to the list. 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#addSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void addSubject(ISubject subject)
    {
        listOfSubjects.add(subject);
    }

    /** 
     * Removes a subject of the list.
     * <code>group.removeSubject(subject)</code>
     *
     * @param subject a subject to remove of the list. 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#removeSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void removeSubject(ISubject subject)
    {
        listOfSubjects.remove(subject);
    }

    /** 
     * Returns the name of the subjects' group.
     * <code>String n = group.getName()</code>
     *
     * @return the name of the subjects' group.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#getName()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public String getName()
    {
        return strName;
    }

    /** 
     * Sets the name of the subjects' group.
     * <code>group.setName(name)</code>
     *
     * @param name the name of the subjects' group. 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#setName(java.lang.String)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setName(String name)
    {
        this.strName = name;
    }

}

