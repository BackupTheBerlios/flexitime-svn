/*
 * Created on 11 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.admin.impl;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.admin.IPreferences;

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
	// Champs   //
	// ======== // 
    private Long idPref;
	private int iHeightGap;
	private int iLengthGap;
	private List listOfColors;
	
	
	// ============= //
	// Constructeurs //
	// ============= //
    /**
     * Default constructor for a Preferences object.
     */
	public PreferencesImpl()
    {
	    this.iHeightGap = 1;
		this.iLengthGap = 1;
		this.listOfColors = new ArrayList();
	}

	/**
	 * Default constructor for a Preferences object.
	 * @param heightGap
	 * @param lengthGap
	 * @param listColors
	 */
	public PreferencesImpl(int heightGap, int lengthGap, List<Color> listColors)
	{
		this.iHeightGap = heightGap;
		this.iLengthGap = lengthGap;
		this.listOfColors = new ArrayList<Color>(listColors);		
	}
	

	//=============//
	//   Méthodes  //
	//=============//
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
     * @param idPref id to set
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
	 * @return the prefered color of the user
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
