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
public interface IBusy extends Serializable
{

    /**
     * Returns the date of the beginning of the busy.
     * <code>Date date = lesson.getDate()</code>
     * 
     * @return the date of the beginning of the busy.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    Date getStartDate();

    /**
     * Changes the date of the beginning of the busy.
     * <code>	
     * 		Date date = new Date();
     * 		lesson.setDate(date);
     * </code>
     * 
     * @param daBusy the date of the beginning of the busy.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setStartDate(Date daBusy);

    /**
     * Returns the date of the end of the busy.
     * <code>Date date = busy.getDate()</code>
     * 
     * @return the date of the end of the busy.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    Date getEndDate();

    /**
     * Changes the date of the end of the busy.
     * <code>	
     *		Date date = new Date();
     * 		busy.setDate(date);
     * 	</code>
     * 
     * @param daBusy the date of the end of the busy.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setEndDate(Date daBusy);

    /**
     *  
     *Get Gap for this Busy
     *
     * @return Gap
     * 
     */
    public Gap getGap();
}
