/*
 * Created on 13 janv. 2005
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.admin;

import java.awt.Color;
import java.io.Serializable;

import fr.umlv.ir3.flexitime.common.data.general.ITrack;

/**
 * Represents the interface of a Preference of a user
 * 
 * @version 240
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public interface IPreferences extends Serializable
{
    /**
     * Returns id of the Preference
     *
     * @return id
     * 
     */
    Long getIdPref();

    /**
     * Setter for the id
     * 
     * @param id Id to set 
     * 
     */
    void setIdPref(Long id);
    
    /**
	 * Returns the height of a gap.
	 * 
	 * @return the height of a gap.
	 */
	public int getHeightGap();
	
	/**
	 * Sets the height of a gap.
	 * 
	 * @param heightGap the height of a gap.
	 */
	public void setHeightGap(int heightGap);
	
	/**
	 * Returns the length of a gap.
	 * 
	 * @return the length of a gap.
	 */
	public int getLengthGap();
	
	/**
	 * Sets the length of a gap.
	 * 
	 * @param lengthGap the length of a gap.
	 */
	public void setLengthGap(int lengthGap);
    
    /**
     * Return widthGap
     * @return Returns the widthGap.
     */
    public int getWidthGap();
    
    /**
     * Set widthGap
     * @param widthGap The widthGap to set.
     */
    public void setWidthGap(int widthGap);
    
    /**
     * Return cDayHeader
     * 
     * @return Returns the cDayHeader.
     */
    public Color getCDayHeader();

    /**
     * Set cDayHeader
     * 
     * @param dayHeader
     *            The cDayHeader to set.
     */
    public void setCDayHeader(Color dayHeader);

    /**
     * Return cGapHeader
     * 
     * @return Returns the cGapHeader.
     */
    public Color getCGapHeader();

    /**
     * Set cGapHeader
     * 
     * @param gapHeader
     *            The cGapHeader to set.
     */
    public void setCGapHeader(Color gapHeader);

    /**
     * Return cWeekHeader
     * 
     * @return Returns the cWeekHeader.
     */
    public Color getCWeekHeader();

    /**
     * Set cWeekHeader
     * 
     * @param weekHeader
     *            The cWeekHeader to set.
     */
    public void setCWeekHeader(Color weekHeader);
	
    /**
     * Return defaultTrack
     * @return Returns the defaultTrack.
     */
    public ITrack getDefaultTrack();

    /**
     * Set defaultTrack
     * @param defaultTrack The defaultTrack to set.
     */
    public void setDefaultTrack(ITrack defaultTrack);
}

