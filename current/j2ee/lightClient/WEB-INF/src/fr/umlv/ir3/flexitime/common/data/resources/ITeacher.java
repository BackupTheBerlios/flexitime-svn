/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.resources;

/**
 * Represents a teacher
 * 
 * @version 0.2
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface ITeacher extends IResource
{

    /**
     * Returns the firstname of the teacher.
     * 
     * @return the firstname of the teacher.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    String getFirstName();

    /**
     * Changes the firstname of the teacher.
     * 
     * @param firstName the new firstname.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setFirstName(String firstName);

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
