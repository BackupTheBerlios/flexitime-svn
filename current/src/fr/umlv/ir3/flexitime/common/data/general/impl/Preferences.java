/*
 * Created on 11 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.general.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines all the preferences that can set a user.
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class Preferences
{
	//===========//
	//   Champs  //
	//===========// 
	private int iHeightGap;
	private int iLengthGap;
	private List listOfColors;
	
	
	//==================//
	//   Constructeurs  //
	//==================//
    /**
     * Default constructor for a Preferences object.
     */
	protected Preferences()
    {}

	/**
	 * Default constructor for a Preferences object.
	 */
	public Preferences(int heightGap, int lengthGap, List listColors)
	{
		this.iHeightGap = heightGap;
		this.iLengthGap = lengthGap;
		this.listOfColors = listColors;		
	}
	

	//=============//
	//   Méthodes  //
	//=============//
    /**
     * This method loads the user's preferences in memory and apply them to the
     * client's GUI.
     */
    void load()
    {
    	//connex rmi
    	//recup prefManager
    	//prefmanager.get attributes
    }

    /**
     * This method saves all the user's preferences in database.
     */
    void save()
    {
    	//connex rmi
    	//recup PrefManager
    	//prefManager.set attributes
    }
    
	/**
	 * Returns the height of a gap.
	 * 
	 * @return the height of a gap.
	 */
	public int getHeightGap()
	{
		return iHeightGap;
	}

	/**
	 * Sets the height of a gap.
	 * 
	 * @param heightGap the height of a gap.
	 */
	public void setHeightGap(int heightGap)
	{
		this.iHeightGap = heightGap;
	}

	/**
	 * Returns the length of a gap.
	 * 
	 * @return the length of a gap.
	 */
	public int getLengthGap()
	{
		return iLengthGap;
	}

	/**
	 * Sets the length of a gap.
	 * 
	 * @param lengthGap the length of a gap.
	 */
	public void setLengthGap(int lengthGap)
	{
		this.iLengthGap = lengthGap;
	}

	/**
	 * Returns the list of  
	 * 
	 * @return
	 */
	public List getListOfColors()
	{
		return listOfColors;
	}

	/**
	 * @param listOfColors
	 */
	public void setListOfColors(List listOfColors)
	{
		this.listOfColors = listOfColors;
	}
    
}
