/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity;

import java.io.Serializable;
import java.util.Date;



import fr.umlv.ir3.flexitime.common.tools.Gap;

/**
 * Represents the unavailabilities
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IBusy extends Serializable, Comparable
{

    /**
     * Returns the date of the beginning of the busy.
     * <code>Date date = lesson.getDate()</code>
     * 
     * @return the date of the beginning of the busy.
     */ 
    Date getStartDate();

    /**
     * Changes the date of the beginning of the busy. <code>	
     * 		Date date = new Date();
     * 		lesson.setDate(date);
     * </code>
     * 
     * @param daBusy
     *            the date of the beginning of the busy.
     */
    void setStartDate(Date daBusy);

    /**
     * Returns the date of the end of the busy.
     * <code>Date date = busy.getDate()</code>
     * 
     * @return the date of the end of the busy.
     */
    Date getEndDate();

    /**
     * Changes the date of the end of the busy. <code>	
     *		Date date = new Date();
     * 		busy.setDate(date);
     * 	</code>
     * 
     * @param daBusy
     *            the date of the end of the busy.
     */
    void setEndDate(Date daBusy);

    /**
     * Get Gap for this Busy
     * 
     * @return Gap
     * 
     */
    public Gap getGap();
    
    /**
     * Set Gap for this Busy
     * 
     * @param newGap 
     * 
     */
    public void setGap(Gap newGap);

    /**
     * Getter for id of the Busy
     * 
     * @return id of the busy
     * 
     */
    public Long getIdBusy();

    /**
     * Setter of id
     * 
     * @param idBusy
     *            id to set
     */
    public void setIdBusy(Long idBusy);
    
    /**
     * Return comment
     * @return Returns the comment.
     */
    public String getComment();
    
    /**
     * Set comment
     * @param comment The comment to set.
     */
    public void setComment(String comment);
    
    /**
     * Compare two Busy.
     * Only the start of the unavaibilities are compared.
     * 
     * @param o
     *            the second busy to compare
     * @return a negative integer, zero, or a positive integer as this object is
     *         less than, equal to, or greater than the specified object.
     * 
     * @throws ClassCastException
     *             if the specified object's type prevents it from being
     *             compared to this Object.
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Object o);
}
