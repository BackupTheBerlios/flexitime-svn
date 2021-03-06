/*
 * Created on 12 d�c. 2004
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
}
