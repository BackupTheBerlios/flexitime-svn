/*
 * Created on 11 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.admin.impl;

import java.awt.Color;

import fr.umlv.ir3.flexitime.common.data.admin.IPreferences;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;

/**
 * Defines all the preferences that can set a user.
 * 
 * @version 240
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class PreferencesImpl implements IPreferences
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
    public PreferencesImpl()
    {
        heightGap = 20;
        widthGap = 75;
        lengthGap = 15;
        cWeekHeader = Color.decode("#483d8b");
        cDayHeader = Color.decode("#483d8b");
        cGapHeader = Color.decode("#4682b4");
    }

    /**
     * Default constructor for a Preferences object.
     * 
     * @param heightGap
     * @param widthGap 
     * @param lengthGap
     * @param week
     * @param day
     * @param gap
     */
    public PreferencesImpl(int heightGap, int widthGap,  int lengthGap, Color week, Color day,
            Color gap)
    {
        this.heightGap = heightGap;
        this.lengthGap = lengthGap;
        this.widthGap = widthGap;
        cWeekHeader = week;
        cDayHeader = day;
        cGapHeader = gap;
    }

    // =============//
    // Méthodes //
    // =============//
    /**
     * Getter for idPref
     * 
     * @return id of the preference
     */
    public Long getIdPref()
    {
        return idPref;
    }

    /**
     * Setter fo idPref
     * 
     * @param idPref
     *            id to set
     * 
     */
    public void setIdPref(Long idPref)
    {
        this.idPref = idPref;
    }

    /**
     * Returns the height of a gap.
     * 
     * @return the height of a gap.
     */
    public int getHeightGap()
    {
        return heightGap;
    }

    /**
     * Sets the height of a gap.
     * 
     * @param heightGap
     *            the height of a gap.
     */
    public void setHeightGap(int heightGap)
    {
        this.heightGap = heightGap;
    }

    /**
     * Returns the length of a gap.
     * 
     * @return the length of a gap.
     */
    public int getLengthGap()
    {
        return lengthGap;
    }

    /**
     * Sets the length of a gap.
     * 
     * @param lengthGap
     *            the length of a gap.
     */
    public void setLengthGap(int lengthGap)
    {
        this.lengthGap = lengthGap;
    }
    
    /**
     * Return widthGap
     * 
     * @return Returns the widthGap.
     */
    public int getWidthGap()
    {
        return widthGap;
    }

    /**
     * Set widthGap
     * 
     * @param widthGap
     *            The widthGap to set.
     */
    public void setWidthGap(int widthGap)
    {
        this.widthGap = widthGap;
    }

    /**
     * Return defaultTrack
     * 
     * @return Returns the defaultTrack.
     */
    public ITrack getDefaultTrack()
    {
        return defaultTrack;
    }

    /**
     * Set defaultTrack
     * 
     * @param defaultTrack
     *            The defaultTrack to set.
     */
    public void setDefaultTrack(ITrack defaultTrack)
    {
        this.defaultTrack = defaultTrack;
    }

    /**
     * Return cDayHeader
     * 
     * @return Returns the cDayHeader.
     */
    public Color getCDayHeader()
    {
        return cDayHeader;
    }

    /**
     * Set cDayHeader
     * 
     * @param dayHeader
     *            The cDayHeader to set.
     */
    public void setCDayHeader(Color dayHeader)
    {
        cDayHeader = dayHeader;
    }

    /**
     * Return cGapHeader
     * 
     * @return Returns the cGapHeader.
     */
    public Color getCGapHeader()
    {
        return cGapHeader;
    }

    /**
     * Set cGapHeader
     * 
     * @param gapHeader
     *            The cGapHeader to set.
     */
    public void setCGapHeader(Color gapHeader)
    {
        cGapHeader = gapHeader;
    }

    /**
     * Return cWeekHeader
     * 
     * @return Returns the cWeekHeader.
     */
    public Color getCWeekHeader()
    {
        return cWeekHeader;
    }

    /**
     * Set cWeekHeader
     * 
     * @param weekHeader
     *            The cWeekHeader to set.
     */
    public void setCWeekHeader(Color weekHeader)
    {
        cWeekHeader = weekHeader;
    }

    /**
     * Test the equality of two preferences.
     * <ul>
     * <li>The two objects must be instance of IPreferences</li>
     * <li>If one preference has an ID, the other must have one, else there are
     * not equals.</li>
     * <li>If any data has an ID, they are seen as different.</li>
     * <li>Else, they must have the same ID.</li>
     * </ul>
     * 
     * @param obj
     *            other preferences to compare with
     * @return <code>true</code> if this object is the same as the obj
     *         argument; <code>false</code> otherwise.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        if (! ( obj instanceof IPreferences )) return false;
        if ( ( ( (IPreferences) obj ).getIdPref() == null )
                || ( idPref == null )) return false;
        return ( idPref == ( (IPreferences) obj ).getIdPref() );
    }
}
