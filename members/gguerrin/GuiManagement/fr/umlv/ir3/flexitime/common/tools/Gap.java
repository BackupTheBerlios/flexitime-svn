/*
 * Created on 12 déc. 2004
 * by FA
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.tools;

import java.util.Calendar;
import java.util.Date;


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
    //=============//
    //  Méthodes   //
    //=============//
    /** 
	 * getEndDate -
	 *
	 * @return the end date
	 */
	public Time getEndDate() {
		return endDate;
	}
	/** 
	 * setEndDate - 
	 *
	 * @param endDate 
	 */
	public void setEndDate(Time endDate) {
		this.endDate = endDate;
	}
	/** 
	 * getStartDate - 
	 *
	 * @return the start date
	 */
	public Time getStartDate() {
		return startDate;
	}
	/** 
	 * setStartDate - 
	 *
	 * @param startDate 
	 */
	public void setStartDate(Time startDate) {
		this.startDate = startDate;
	}
	/** 
	 * getGap - Gets a Gap with 2 Date
	 *
	 * @param start the start Date
	 * @param end the end Date
	 * @return Returns the gap
	 */
	public static Gap getGap(Date start, Date end){
	    Gap g = new Gap();
	    g.getStartDate().getCal().setTime(start);
	    g.getEndDate().getCal().setTime(end);
	    return g;
	}
}