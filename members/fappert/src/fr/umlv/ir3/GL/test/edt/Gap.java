/*
 * Created on 7 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.test.edt;

import java.util.Calendar;

import fr.umlv.ir3.GL.test.edt.tool.Time;

/**
 * @author fappert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Gap {
	private Time startDate;

	private Time endDate;



	/**
	 * 
	 */
	public Gap() {
		this.startDate = new Time();
		this.endDate = new Time();
	}

	/**
	 * 
	 */
	public Gap(int startYear, int startMonth, int startDay, int startHour,
			int startMinute, int endYear, int endMonth, int endDay,
			int endHour, int endMinute) {
		Calendar c1 = Calendar.getInstance();
		c1.set(startYear, startMonth, startDay, startHour, startMinute);
		Calendar c2 = Calendar.getInstance();
		c2.set(endYear, endMonth, endDay, endHour, endMinute);
		this.startDate = new Time(c1);
		this.endDate = new Time(c2);

		//this.startDate = new Time(startYear,startMonth,startDay,startHour,startMinute);
		//this.endDate = new Time(endtYear,endMonth,endDay,endHour,endMinute);
	}

	/**
	 * @param startDate
	 * @param endDate
	 */
	public Gap(Calendar startDate, Calendar endDate) {

		this.startDate = new Time(startDate);
		this.endDate = new Time(endDate);
	}
	
	
	
	public Time getEndDate() {
		return endDate;
	}

	public void setEndDate(Time endDate) {
		this.endDate = endDate;
	}

	public Time getStartDate() {
		return startDate;
	}

	public void setStartDate(Time startDate) {
		this.startDate = startDate;
	}

}