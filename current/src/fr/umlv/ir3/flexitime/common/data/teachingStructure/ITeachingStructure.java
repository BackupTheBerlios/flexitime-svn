/*
 * Created on 20 déc. 2004
 * by Famille
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.teachingStructure;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.IData;

/**
 * Represents a list of SubjectsGroups defined for a Class
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface ITeachingStructure extends IData
{

    /**
     * Returns the list of SubjectsGroups.
     * 
     * @return the list of SubjectsGroups.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    List getLstSubjectsGroup();

    /**
     * Changes the list of SubjectsGroup of a
     * teachingStructure.
     * 
     * @param lst the new list of SubjectsGroups.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setLstSubjectsGroup(List lst);

    /**
     * Add a SubjectsGroup in a TeachingStructure .
     * 
     * @param subjectsGroup the new SubjectsGroup
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void addSubject(ISubjectsGroup subjectsGroup);

    /**
     * Remove a SubjectsGroup of a TeachingStructure.
     * 
     * @param subjectsGroup the new SubjectsGroup
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void removeSubject(ISubjectsGroup subjectsGroup);
}
