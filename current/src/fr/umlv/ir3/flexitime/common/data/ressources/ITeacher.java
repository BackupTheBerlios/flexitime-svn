/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.ressources;

/**
 * Represents a teacher
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface ITeacher extends IResource
{

    /**
     * Returns the surname of the teacher.
     * 
     * @return the surname of the teacher.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    String getSurName();

    /**
     * Changes the surname of the teacher.
     * 
     * @param surName the new surname.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setSurName(String surName);

    /**
     * Returns the email of the teacher.
     * 
     * @return the email of the teacher.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    String getEmail();

    /**
     * Changes the email of the teacher.
     * 
     * @param email the new email.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setEmail(String email);

}
