/*
 * Created on 6 janv. 2005
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.common.tools.Gap;

/**
 * Implements all methods of IBusy
 * 
 * @version 220
 * @author FlexiTeam - Jérôme GUERS
 */
public abstract class TestBusyImpl extends TestCase
{

    // ===========//
    // Champs //
    // ===========//
    private Timestamp                 daStart;
    private Timestamp                 daEnd;
    protected Long               idBusy;
    private String               comment;


    // ======== //
    // Méthodes //
    // ======== //
    /**
     * Returns the start date of the unavailibility.
     * <code>Date date = getStartDate()</code>
     * 
     * @return the start date of the unavailibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#getStartDate()
     */
    public void testGetStartDate()
    {
    }

    /**
     * Sets the start date of the unavailibility.
     * <code>setStartDate(daBusy)</code>
     * 
     * @param daStart
     *            a date.
     * 
     * @author FlexiTeam - Adrien BOUVET
     */
    public void testSetStartDate()
    {
    }

    /**
     * Returns the end date of the unavailibility.
     * <code>Date date = getEndDate()</code>
     * 
     * @return the end date of the unavailibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#getEndDate()
     */
    public void testGetEndDate()
    {
    }

    /**
     * Sets the end date of the unavailibility. <code>setEndDate(daBusy)</code>
     * 
     * @param daEnd
     *            a date.
     * 
     */
    public void testSetEndDate()
    {
    }

    /**
     * Return a gap between the start date of the busy and the end date
     * 
     * @return the gap of the busy
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#getGap()
     */
    public void testGetGap()
    {
    }
    
    /** 
     * Set a new gap to the busy
     *
     * @param newGap to set
     * 
     */
    public void testSetGap()
    {
    }

    /**
     * Getter for id of the Busy
     * 
     * @return id of the busy
     */
    public void testGetIdBusy()
    {
    }

    /**
     * Setter of id
     * 
     * @param idBusy
     *            id to set
     * 
     */
    public void testSetIdBusy()
    {
    }

    /**
     * Return comment
     * 
     * @return Returns the comment.
     */
    public void testGetComment()
    {
    }

    /**
     * Set comment
     * 
     * @param comment
     *            The comment to set.
     */
    public void testSetComment()
    {
    }


}
