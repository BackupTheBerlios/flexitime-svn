/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.tools;
import java.util.Calendar;


/**
 * Time - Description Tool for time<br>
 * This Class allows the users to work with Time Object And to have it under different kinds
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public class Time
{
    //===========//
	//  Champs   //
	//===========//
    private Calendar cal;
    //=================//
	//  Constructeurs  //
    //=================//
    /**
     * Default constructor - Get the calendar now 
     */
    public Time(){
        cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
    }
    /**
     * Constructor - Take a calendar
     * @param c a calendar
     */
    public Time(Calendar c){
        cal = c;
        cal.setFirstDayOfWeek(Calendar.MONDAY);
    }
    /**
     * Constructor - Take all the element of a date
     * @param year
     * @param month (1-12)
     * @param day
     * @param hour
     * @param minute
     */
    public Time(int year, int month, int day, int hour, int minute){
        cal = Calendar.getInstance();
        cal.clear();
        cal.set(year,month-1,day,hour,minute,0);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
    }
    //=============//
    //  Méthodes   //
	//=============//
    /** 
     * getYear - get the year
     *
     * @return Returns the year
     */
    public int getYear() {
        return cal.get(Calendar.YEAR);
    }
    /** 
     * getIMonth - get the month<br>
     * January = 1<br>
     * December = 12
     *
     * @return Returns the month
     */
    public int getIMonth() {
        return cal.get(Calendar.MONTH)+1;
    }
    /** 
     * getStrMonth - get the Month in String
     *
     * @return Returns the month in String
     */
    public String getStrMonth() {
        return getMonth(cal.get(Calendar.MONTH)+1);
    }
    /** 
     * getWeek - get the week of the year
     *
     * @return Returns the week
     */
    public int getWeek() {
        return cal.get(Calendar.WEEK_OF_YEAR);
    }
    /** 
     * getIDay - get the day in the month
     *
     * @return Returns the day in the month
     */
    public int getIDay() {
        return cal.get(Calendar.DAY_OF_MONTH);
    }
    /** 
     * getIDay - get the day in week<br>
     * Monday = 0<br>
     * Sunday = 6
     *
     * @return Returns the day in the week
     */
    public int getIDayOfWeek() {
        int d =  cal.get(Calendar.DAY_OF_WEEK);
        if(d==Calendar.SUNDAY) return 6;
        return d-2;
    } 
    /** 
     * getStrDay - get the day in String
     *
     * @return Returns the day in String
     */
    public String getStrDay(){
        int d =  cal.get(Calendar.DAY_OF_WEEK);
        if(d==Calendar.SUNDAY) return getDay(6);
        return getDay(d-2);
    }
    /** 
     * getHour - get the hour in 24H
     *
     * @return Returns the hour in 24H
     */
    public int getHour() {
        return cal.get(Calendar.HOUR_OF_DAY);
    }
    /** 
     * getMinute - get the minutes
     *
     * @return Returns the minutes
     */
    public int getMinute() {
        return cal.get(Calendar.MINUTE);
    }
    /** 
     * getSecond - get the seconds
     *
     * @return Returns the seconds
     */
    public int getSecond() {
        return cal.get(Calendar.SECOND);
    }
    /** 
     * getMSecond - get the milliseconds
     *
     * @return Returns the milliseconds
     */
    public int getMSecond() {
        return cal.get(Calendar.MILLISECOND);
    }
    /** 
     * getDate - get the date in dd/mm/yyyy
     *
     * @return Returns the date
     */
    public String getDate() {
        String day = getIDay()<10?"0"+getIDay():new Integer(getIDay()).toString();
        String month = getIMonth()<10?"0"+getIMonth():new Integer(getIMonth()).toString();
        return day+"/"+month+"/"+getYear();
    }
    /** 
     * getStrDate - get the date in "strDay iDay strMonth year"
     *
     * @return Returns the date
     */
    public String getStrDate() {
        return getStrDay()+" "+getIDay()+" "+getStrMonth()+" "+getYear();
    }
    /** 
     * getFullTime - get the time in "hh:mm:ss:mms"
     *
     * @return Returns the time
     */
    public String getFullTime() {
        String h = getHour()<10?"0"+getHour():new Integer(getHour()).toString();
        String m = getMinute()<10?"0"+getMinute():new Integer(getMinute()).toString();
        String s = getSecond()<10?"0"+getSecond():new Integer(getSecond()).toString();
        String ms = getMSecond()<100?"0"+getMSecond():new Integer(getMSecond()).toString();
        ms = getMSecond()<10?"00"+getMSecond():ms;
        return h+":"+m+":"+s+":"+ms;
    }
    /** 
     * getTime - get the time in "hh:mm"
     *
     * @return Returns the time
     */
    public String getTime() {
        String h = getHour()<10?"0"+getHour():new Integer(getHour()).toString();
        String m = getMinute()<10?"0"+getMinute():new Integer(getMinute()).toString();
        return h+":"+m;
    }
    /** 
     * getCal - get the calendar
     *
     * @return Returns the calendar
     */
    public Calendar getCal() {
        return cal;
    }
    /** 
     * compare - compare 2 Time
     *
     * @param t1 a Time
     * @param t2 a Time
     * @return Returns -1 if time1 is before time2<br>
     * 1 if time1 is after time2<br>
     * 0 if it's equal  
     */
    public static int compare(Time t1,Time t2){
        if(t1.getCal().compareTo(t2.getCal())==-1) return -1;
        else if(t1.getCal().compareTo(t2.getCal())==1) return 1;
        else return 0;
    }
    /** 
     * addDay - add or remove a number of day
     *
     * @param number the number to add or remove 
     */
    public void addDay(int number){
        cal.add(Calendar.DAY_OF_MONTH,number);
    }
    /** 
     * addMonth - add or remove a number of month
     *
     * @param number the number of month to add or remove
     */
    public void addMonth(int number){
        cal.add(Calendar.MONTH,number);
    }
    /** 
     * addYear - add or remove a number of year
     *
     * @param number the number of year to add or remove
     */
    public void addYear(int number){
        cal.add(Calendar.YEAR,number);
    }
    /** 
     * addHour - add or remove a number of hour
     *
     * @param number the number of hour to add or remove
     */
    public void addHour(int number){
        cal.add(Calendar.HOUR_OF_DAY,number);
    }
    /** 
     * addMinute - add or remove a number of minute
     *
     * @param number the number of minute to add or remove
     */
    public void addMinute(int number){
        cal.add(Calendar.MINUTE,number);
    }
    /** 
     * addSecond - add or remove a number of seconds
     *
     * @param number the number of second to add or remove
     */
    public void addSecond(int number){
        cal.add(Calendar.SECOND,number);
    }
    /** 
     * addMSecond - add or remove a number of milliseconds
     *
     * @param number the number of milliseconds to add or remove
     */
    public void addMSecond(int number){
        cal.add(Calendar.MILLISECOND,number);
    }
    /** 
     * addWeek - add or remove a number of week
     *
     * @param number the number of week to add or remove
     */
    public void addWeek(int number){
        cal.add(Calendar.WEEK_OF_YEAR,number);
    }
    //======================//
    //  Méthodes statiques  //
	//======================//
    /** 
     * getGapMSecond - Get the number of millisecond between two Time
     *
     * @param t1 a Time
     * @param t2 a Time
     * @return Returns the number of millisecond between two Time in long<br>
     */
    public static long getGapMSecond(Time t1, Time t2){
        long gap = (t2.getCal().getTimeInMillis() - t1.getCal().getTimeInMillis());
        if (gap < 0) return -gap;
        return gap;
    }
    /** 
     * getGapMSecond - Get the number of second between two Time
     *
     * @param t1 a Time
     * @param t2 a Time
     * @return Returns the number of second between two Time in long<br>
     */
    public static long getGapSecond(Time t1, Time t2){
        long gap = (t2.getCal().getTimeInMillis() - t1.getCal().getTimeInMillis()) / 1000;
        if (gap < 0) return -gap;
        return gap;
    }
    /** 
     * getGapMinute - Get the number of minute between two Time
     *
     * @param t1 a Time
     * @param t2 a Time
     * @return Returns the number of minute between two Time in int<br>
     * Returns -1 if it can't get a int with the long
     */
    public static int getGapMinute(Time t1, Time t2){
        long gap = (t2.getCal().getTimeInMillis() - t1.getCal().getTimeInMillis()) / 60000;
        try{
            if (gap < 0) return (int)-gap;
            return (int)gap;
        }catch(Exception e){
            return -1;
        }
    }
    /** 
     * getGapHour - Get the number of hour between two Time
     *
     * @param t1 a Time
     * @param t2 a Time
     * @return Returns the number of bour between two Time in int<br>
     * Returns -1 if it can't get a int with the long
     */
    public static int getGapHour(Time t1, Time t2){
        long gap = (t2.getCal().getTimeInMillis() - t1.getCal().getTimeInMillis()) / 3600000;
        try{
            if (gap < 0) return (int)-gap;
            return (int)gap;
        }catch(Exception e){
            return -1;
        }
    }
    /** 
     * getGapWeek - Get the number of week between two Time
     *
     * @param t1 a Time
     * @param t2 a Time
     * @return Returns the number of week between two Time in int<br>
     */
    public static int getGapWeek(Time t1, Time t2){
        Time minTime;
        Time maxTime;
        int number = 0;
        if(Time.compare(t1,t2)==-1){
            minTime = t1;
            maxTime = t2;
        }else{
            minTime = t2;
            maxTime = t1;
        }
        if(minTime.getYear()==maxTime.getYear()) {
            number = maxTime.getWeek() - minTime.getWeek();
            if(number<0) number = maxTime.getWeek();
            return number;
        }
        for(int i = 0;i<maxTime.getYear()-minTime.getYear()+1;i++){
            if(i==0)number = number + minTime.getCal().getMaximum(Calendar.WEEK_OF_YEAR) - minTime.getWeek(); 
            else if(i==maxTime.getYear()-minTime.getYear()) number = number + maxTime.getWeek();
            else {
                Calendar c = Calendar.getInstance();
                c.set(Calendar.YEAR,minTime.getYear()+i);
                number = number + c.getMaximum(Calendar.WEEK_OF_YEAR);
            }
        }
        return number;          
    }
    /** 
     * countNbHour_HM - gets the number of hour (in float) between 2 Time<br>
     * It doesn't take care of year, month, day
     *
     * @param begin the begin time
     * @param end the end time
     * @return Returns the number of hour
     */
    public static float countNbHour_HM(Time begin, Time end)
    {
        return (end.getHour() - begin.getHour()) + (((float)end.getMinute() - (float)begin.getMinute())/60);
    }
    /** 
     * countNbMinute_HM - gets the number of minute between 2 Time<br>
     * It doesn't take care of year, month, day
     *
     * @param begin the begin time
     * @param end the end time
     * @return Returns the number of minute
     */
    public static int countNbMinute_HM(Time begin, Time end)
    {
        return ( (end.getHour() - begin.getHour()) * 60 + (end.getMinute() - begin.getMinute()));
    } 
    //======================//
    //  Méthodes privées    //
	//======================//
    /*
     * getMonth - Get the month in AlphaNumeric
     * 
     *     <code>String str = time.getMonth(5)</code>
     *
     * @param m the month number
     * @return Returns the month in string
     */
    private String getMonth(int m){
        String str = null;
        switch(m){
            case 1: str = "Janvier";break;
            case 2: str = "Février";break;
            case 3: str = "Mars";break;
            case 4: str = "Avril";break;
            case 5: str = "Mai";break;
            case 6: str = "Juin";break;
            case 7: str = "Juillet";break;
            case 8: str = "Août";break;
            case 9: str = "Septembre";break;
            case 10: str = "Octobre";break;
            case 11: str = "Novembre";break;
            case 12: str = "Décembre";break;
        }
        return str;
    }
    /*
     * getDay - Get the day in AlphaNumeric
     * 
     *     <code>String str = time.getDay(2)</code>
     *
     * @param d the day number
     * @return Returns the day in string
     */
    private String getDay(int d){
        String str = null;
        switch(d){
            case 0: str = "Lundi";break;
            case 1: str = "Mardi";break;
            case 2: str = "Mercredi";break;
            case 3: str = "Jeudi";break;
            case 4: str = "Vendredi";break;
            case 5: str = "Samedi";break;
            case 6: str = "Dimanche";break;
        }
        return str;
    }
}