/*
 * Created on 12 d�c. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.teachingStructure;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.IData;

/**
 * Represents a SubjectsGroup which belong to a TeachingStructure
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface ISubjectsGroup extends IData
{

    /**
     * Returns the list of Subject of SubjectsGroups .
     * 
     * @return the list of Subject of SubjectsGroups.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    List getLstSubject();

    /**
     * setLstSubject changes the list of Subject of blocs.
     * 
     * @param lstSubject the list of Subject of blocs.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setLstSubject(List lstSubject);

    /**
     * Add a Subject in a SubjectsGroup .
     * 
     * @param Subject the new Subject
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void addSubject(ISubject Subject);

    /**
     * Remove a Subject of a SubjectsGroup.
     * 
     * @param subject the new Subject
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void removeSubject(ISubject subject);

}