/*
 * Created on 13 janv. 2005
 * by Famille
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.admin;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.IData;


/**
 * IPreferences
 * represents the interface of a Preference
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IPreferences extends IData
{
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

