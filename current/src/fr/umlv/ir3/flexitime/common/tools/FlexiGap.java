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
public class FlexiGap {
    //===========//
	//  Champs   //
	//===========//
	private FlexiTime startDate;
	private FlexiTime endDate;
    //=================//
	//  Constructeurs  //
    //=================//
	/**
	 * Default constructor 
	 */
	public FlexiGap() {
		this.startDate = new FlexiTime();
		this.endDate = new FlexiTime();
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
	public FlexiGap(int startYear, int startMonth, int startDay, int startHour,
			int startMinute, int endYear, int endMonth, int endDay,
			int endHour, int endMinute) {
		this.startDate = new FlexiTime(startYear, startMonth, startDay, startHour, startMinute);
		this.endDate = new FlexiTime(endYear, endMonth, endDay, endHour, endMinute);
	}
	/**
	 * Constructor - Take the two calendar
	 * @param startDate
	 * @param endDate
	 */
	public FlexiGap(Calendar startDate, Calendar endDate) {

		this.startDate = new FlexiTime(startDate);
		this.endDate = new FlexiTime(endDate);
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
	public FlexiTime getEndDate() {
		return endDate;
	}
	/** 
	 * setEndDate - DOCME Description
	 * 
	 *     <code>exemple d'appel de la methode</code>
	 *
	 * @param endDate 
	 */
	public void setEndDate(FlexiTime endDate) {
		this.endDate = endDate;
	}
	/** 
	 * getStartDate - DOCME Description
	 * 
	 *     <code>exemple d'appel de la methode</code>
	 *
	 * @return the start date
	 */
	public FlexiTime getStartDate() {
		return startDate;
	}
	/** 
	 * setStartDate - DOCME Description
	 * 
	 *     <code>exemple d'appel de la methode</code>
	 *
	 * @param startDate 
	 */
	public void setStartDate(FlexiTime startDate) {
		this.startDate = startDate;
	}
}