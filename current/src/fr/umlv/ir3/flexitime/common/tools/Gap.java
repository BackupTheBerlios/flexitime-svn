/*
 * Created on 12 déc. 2004
 * by FA
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.tools;

import java.util.Calendar;


/**
 * Gap - Description Tool for gap<br>
 * This Class allows the users to work with Gap of two Time
 * 
 * @version 0.1
 * @author FlexiTeam - FA
 */
public class Gap {
    //===========//
	//  Champs   //
	//===========//
	private Time startDate;
	private Time endDate;
    //=================//
	//  Constructeurs  //
    //=================//
	/**
	 * Default constructor 
	 */
	public Gap() {
		this.startDate = new Time();
		this.endDate = new Time();
	}
	/**
	 * Constructor - Take all the element of the two date
	 * @param startYear
	 * @param startMonth
	 * @param startDay
	 * @param startHour
	 * @param startMinute
	 * @param endYear
	 * @param endMonth
	 * @param endDay
	 * @param endHour
	 * @param endMinute
	 */
	public Gap(int startYear, int startMonth, int startDay, int startHour,
			int startMinute, int endYear, int endMonth, int endDay,
			int endHour, int endMinute) {
		this.startDate = new Time(startYear, startMonth, startDay, startHour, startMinute);
		this.endDate = new Time(endYear, endMonth, endDay, endHour, endMinute);
	}
	/**
	 * Constructor - Take the two calendar
	 * @param startDate
	 * @param endDate
	 */
	public Gap(Calendar startDate, Calendar endDate) {

		this.startDate = new Time(startDate);
		this.endDate = new Time(endDate);
	}
	/** 
	 * getEndDate - DOCME Description
	 * 
	 *     <code>exemple d'appel de la methode</code>
	 *
	 * @return the end date
	 */
    //=============//
    //  Méthodes   //
	//=============//
	public Time getEndDate() {
		return endDate;
	}
	/** 
	 * setEndDate - DOCME Description
	 * 
	 *     <code>exemple d'appel de la methode</code>
	 *
	 * @param endDate 
	 */
	public void setEndDate(Time endDate) {
		this.endDate = endDate;
	}
	/** 
	 * getStartDate - DOCME Description
	 * 
	 *     <code>exemple d'appel de la methode</code>
	 *
	 * @return the start date
	 */
	public Time getStartDate() {
		return startDate;
	}
	/** 
	 * setStartDate - DOCME Description
	 * 
	 *     <code>exemple d'appel de la methode</code>
	 *
	 * @param startDate 
	 */
	public void setStartDate(Time startDate) {
		this.startDate = startDate;
	}
}