/*
 * Created on 12 déc. 2004
 * by FA
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.tools;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;


/**
 * Description Tool for gap<br>
 * This Class allows the users to work with Gap of two Time
 * 
 * @version 0.1
 * @author FlexiTeam - FA
 */
public class TestGap extends TestCase{
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
	public TestGap() {
		this.startDate = new Time();
		this.endDate = new Time();
	}
	
    
    
    //=============//
    //  Méthodes   //
    //=============//
    /** 
	 * getEndDate -
	 *
	 * @return the end date
	 */
	public void  testGetEndDate() {
	}
	/** 
	 * setEndDate - 
	 *
	 * @param endDate 
	 */
	public void testSetEndDate() {
	}
	/** 
	 * getStartDate - 
	 *
	 * @return the start date
	 */
	public void testGetStartDate() {
	}
	/** 
	 * setStartDate - 
	 *
	 * @param startDate 
	 */
	public void testSetStartDate(Time startDate) {
	}
	/** 
	 * getGap - Gets a Gap with 2 Date
	 *
	 * @param start the start Date
	 * @param end the end Date
	 * @return Returns the gap
	 */
	public void testGetGap(){
	}
}