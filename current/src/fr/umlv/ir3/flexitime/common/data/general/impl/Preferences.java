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
	private int iThickLine;
	private List listOfColors;
	
	
	//==================//
	//   Constructeurs  //
	//==================//
    /**
     * Default constructor for a Preferences object.
     */
    public Preferences()
    {}

	/**
	 * Default constructor for a Preferences object.
	 */
	public Preferences(int heightGap, int lengthGap, int thickLine, List listColors)
	{
		this.iHeightGap = heightGap;
		this.iLengthGap = lengthGap;
		this.iThickLine = thickLine;
		this.listOfColors = new ArrayList(listColors);		
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

    }

    /**
     * This method saves all the user's preferences in database.
     */
    void save()
    {

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
	 * @return
	 */
	public int getLengthGap()
	{
		return iLengthGap;
	}

	/**
	 * @param lengthGap
	 */
	public void setLengthGap(int lengthGap)
	{
		this.iLengthGap = lengthGap;
	}

	/**
	 * @return
	 */
	public int getThickLine()
	{
		return iThickLine;
	}

	/**
	 * @param thickLine
	 */
	public void setThickLine(int thickLine)
	{
		this.iThickLine = thickLine;
	}

	/**
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
