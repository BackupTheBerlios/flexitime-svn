/*
 * Created on 11 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.admin.impl;

import java.awt.Color;

import junit.framework.TestCase;

import fr.umlv.ir3.flexitime.common.data.admin.IPreferences;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;

/**
 * Defines all the preferences that can set a user.<br>
 * Implements the interface IPreferences
 * 
 * @version 240
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestPreferencesImpl extends TestCase
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3904961949799100468L;
    // ======== //
    // Champs //
    // ======== //
    private Long              idPref;
    private int               heightGap;
    private int               widthGap;
    private int               lengthGap;
    private Color             cWeekHeader;
    private Color             cDayHeader;
    private Color             cGapHeader;
    private ITrack            defaultTrack;

    // ============= //
    // Constructeurs //
    // ============= //
    /**
     * Default constructor for a Preferences object.
     */
    public TestPreferencesImpl()
    {
        heightGap = 20;
        widthGap = 75;
        lengthGap = 15;
        cWeekHeader = Color.decode("#483d8b");
        cDayHeader = Color.decode("#483d8b");
        cGapHeader = Color.decode("#4682b4");
    }

    

    // =============//
    // Méthodes //
    // =============//
    /**
     * Getter for idPref
     * 
     * @return id of the preference
     */
    public void testGetIdPref()
    {
    }

    /**
     * Setter fo idPref
     * 
     * @param idPref
     *            id to set
     * 
     */
    public void testSetIdPref()
    {    }

    /**
     * Returns the height of a gap.
     * 
     * @return the height of a gap.
     */
    public void testGetHeightGap()
    {
    }

    /**
     * Sets the height of a gap.
     * 
     * @param heightGap
     *            the height of a gap.
     */
    public void testSetHeightGap()
    {
    }

    /**
     * Returns the length of a gap.
     * 
     * @return the length of a gap.
     */
    public void testGetLengthGap()
    {
    }

    /**
     * Sets the length of a gap.
     * 
     * @param lengthGap
     *            the length of a gap.
     */
    public void testSetLengthGap()
    {
    }
    
    /**
     * Return widthGap
     * 
     * @return Returns the widthGap.
     */
    public void testGetWidthGap()
    {
    }

    /**
     * Set widthGap
     * 
     * @param widthGap
     *            The widthGap to set.
     */
    public void testSetWidthGap()
    {
    }

    /**
     * Return defaultTrack
     * 
     * @return Returns the defaultTrack.
     */
    public void testGetDefaultTrack()
    {
    }

    /**
     * Set defaultTrack
     * 
     * @param defaultTrack
     *            The defaultTrack to set.
     */
    public void testSetDefaultTrack()
    {
    }

    /**
     * Return cDayHeader
     * 
     * @return Returns the cDayHeader.
     */
    public void testGetCDayHeader()
    {
    }

    /**
     * Set cDayHeader
     * 
     * @param dayHeader
     *            The cDayHeader to set.
     */
    public void testSetCDayHeader()
    {
    }

    /**
     * Return cGapHeader
     * 
     * @return Returns the cGapHeader.
     */
    public void testGetCGapHeader()
    {
    }

    /**
     * Set cGapHeader
     * 
     * @param gapHeader
     *            The cGapHeader to set.
     */
    public void testSetCGapHeader()
    {
    }

    /**
     * Return cWeekHeader
     * 
     * @return Returns the cWeekHeader.
     */
    public void testGetCWeekHeader()
    {
    }

    /**
     * Set cWeekHeader
     * 
     * @param weekHeader
     *            The cWeekHeader to set.
     */
    public void testSetCWeekHeader()
    {
    }
}
