/*
 * Created on 13 janv. 2005
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.admin;

import java.io.Serializable;
import java.util.List;

/**
 * Represents the interface of a Preference
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
	 * getListOfColors
	 * Returns the list of  
	 * 
	 * @return the list of Color
	 *
	 */
	public List getListOfColors();
	
	/**
	 * @param listOfColors
	 */
	public void setListOfColors(List listOfColors);
}

