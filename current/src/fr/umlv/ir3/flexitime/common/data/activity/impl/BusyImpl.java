/*
 * Created on 6 janv. 2005
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.activity.impl;

import java.util.Calendar;
import java.util.Date;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.tools.Gap;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public abstract class BusyImpl implements IBusy
{
    //===========//
	//  Champs	 //
	//===========//
    private Date daStart;
    private Date daEnd;
    private String strName;
    
	//=============//
	//Constructeurs//
    //=============//
	/**
	 * Default constructor for an unavailibility. 
	 */
	protected BusyImpl()
	{}
	
	/**
	 * Constructs an unavailibility for a device with just a name in parameter. 
	 * 
	 * @param strName the name of the busy
	 */
	public BusyImpl(String strName)
	{
		this.strName = strName;
	}
	
    /**
     * Constructs an unavailibility for a device. 
     * 
     * 
     * @param daStart the start date of the unavailibility.
     * @param daEnd the end date of the unavailibility.
     * @param strName the name of the busy
     */
    public BusyImpl(String strName,Date daStart, Date daEnd)
    {
        this.strName = strName;
        this.daStart = daStart;
        this.daEnd = daEnd;      
    }
    
    //===========//
    // Méthodes  //
	//===========//
    /** 
     * Returns the start date of the unavailibility.
     * <code>Date date = getStartDate()</code>
     *
     * @return the start date of the unavailibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#getStartDate()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public Date getStartDate()
    {
        return daStart;
    }


    /** 
     * Sets the start date of the unavailibility.
     * <code>setStartDate(daBusy)</code>
     *
     * @param daStart a date.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#setStartDate(java.util.Date)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setStartDate(Date daStart)
    {
        this.daStart = daStart;
    }

    /** 
     * Returns the end date of the unavailibility.
     * <code>Date date = getEndDate()</code>
     *
     * @return the end date of the unavailibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#getEndDate()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public Date getEndDate()
    {
        return daEnd;
    }

    /** 
     * Sets the end date of the unavailibility.
     * <code>setEndDate(daBusy)</code>
     *
     * @param daEnd a date.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#setEndDate(java.util.Date)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setEndDate(Date daEnd)
    {
        this.daEnd = daEnd;
    }
    
    
    public Gap getGap()
    {
    	Calendar calStart = Calendar.getInstance();
    	calStart.setTime(this.daStart);
		Calendar calEnd = Calendar.getInstance();
		calEnd.setTime(this.daEnd);
    	
    	return new Gap(calStart, calEnd);
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#getName()
     * @author   FlexiTeam - Famille
     */
    public String getName()
    {
        return strName;
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param strName 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#setName(java.lang.String)
     * @author   FlexiTeam - Famille
     */
    public void setName(String strName)
    {
        this.strName= strName;

    }

}

