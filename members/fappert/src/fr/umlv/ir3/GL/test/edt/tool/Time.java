/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.GL.test.edt.tool;
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
    private Calendar cal;
    
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
     * @param month
     * @param day
     * @param hour
     * @param minute
     */
    public Time(int year, int month, int day, int hour, int minute){
        cal = Calendar.getInstance();
        cal.set(year,month-1,day,hour,minute);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
    }
    /** 
     * getMonth - Get the month in AlphaNumeric
     * 
     *     <code>String str = time.getMonth(5)</code>
     *
     * @param m the month number
     * @return Returns the month in string
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
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
    /** 
     * getDay - Get the day in AlphaNumeric
     * 
     *     <code>String str = time.getDay(2)</code>
     *
     * @param d the day number
     * @return Returns the day in string
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    private String getDay(int d){
        String str = null;
        switch(d){
            case 1: str = "Lundi";break;
            case 2: str = "Mardi";break;
            case 3: str = "Mercredi";break;
            case 4: str = "Jeudi";break;
            case 5: str = "Vendredi";break;
            case 6: str = "Samedi";break;
            case 7: str = "Dimanche";break;
        }
        return str;
    }
    /** 
     * getIDay - get the day in the month
     * 
     *     <code>int d = time.getIDay()</code>
     *
     * @return Returns the day in the month
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public int getIDay() {
        return cal.get(Calendar.DAY_OF_MONTH);
    }
    
    public int getIDayOfWeek() {
        return cal.get(Calendar.DAY_OF_WEEK);
    }
    
    
    /** 
     * getStrDay - get the day in String
     * 
     *     <code>String d = time.getStrDay()</code>
     *
     * @return Returns the day in String
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public String getStrDay(){
        return getDay(cal.get(Calendar.DAY_OF_WEEK)-1);
    }
    /** 
     * getHour - get the hour in 24H
     * 
     *     <code>int h = time.getHour()</code>
     *
     * @return Returns the hour in 24H
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public int getHour() {
        return cal.get(Calendar.HOUR_OF_DAY);
    }
    /** 
     * getMinute - get the minutes
     * 
     *     <code>int min = time.getMinute()</code>
     *
     * @return Returns the minutes
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public int getMinute() {
        return cal.get(Calendar.MINUTE);
    }
    /** 
     * getIMonth - get the month
     * 
     *     <code>int m = time.getIMonth()</code>
     *
     * @return Returns the month
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public int getIMonth() {
        return cal.get(Calendar.MONTH)+1;
    }
    /** 
     * getMSecond - get the milliseconds
     * 
     *     <code>int ms = time.getMSecond()</code>
     *
     * @return Returns the milliseconds
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public int getMSecond() {
        return cal.get(Calendar.MILLISECOND);
    }
    /** 
     * getSecond - get the seconds
     * 
     *     <code>int s = time.getSecond()</code>
     *
     * @return Returns the seconds
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public int getSecond() {
        return cal.get(Calendar.SECOND);
    }
    /** 
     * getWeek - get the week of the year
     * 
     *     <code>int w = time.getWeek()</code>
     *
     * @return Returns the week
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public int getWeek() {
        return cal.get(Calendar.WEEK_OF_YEAR);
    }
    /** 
     * getYear - get the year
     * 
     *     <code>int y = time.getYear()</code>
     *
     * @return Returns the year
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public int getYear() {
        return cal.get(Calendar.YEAR);
    }
    /** 
     * getStrMonth - get the Month in String
     * 
     *     <code>int m = time.getStrMonth()</code>
     *
     * @return Returns the month in String
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public String getStrMonth() {
        return getMonth(cal.get(Calendar.MONTH)+1);
    }
    /** 
     * getDate - get the date in dd/mm/yyyy
     * 
     *     <code>String date = time.getDate()</code>
     *
     * @return Returns the date
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public String getDate() {
        String day = getIDay()<10?"0"+getIDay():new Integer(getIDay()).toString();
        String month = getIMonth()<10?"0"+getIMonth():new Integer(getIMonth()).toString();
        return day+"/"+month+"/"+getYear();
    }
    /** 
     * getStrDate - get the date in "strDay iDay strMonth year"
     * 
     *     <code>String date = time.getStrDate()</code>
     *
     * @return Returns the date
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public String getStrDate() {
        return getStrDay()+" "+getIDay()+" "+getStrMonth()+" "+getYear();
    }
    /** 
     * getTime - get the time in "hh:mm:ss:mms"
     * 
     *     <code>String t = time.getTime()</code>
     *
     * @return Returns the time
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public String getTime() {
        String h = getHour()<10?"0"+getHour():new Integer(getHour()).toString();
        String m = getMinute()<10?"0"+getMinute():new Integer(getMinute()).toString();
        String s = getSecond()<10?"0"+getSecond():new Integer(getSecond()).toString();
        String ms = getMSecond()<100?"0"+getMSecond():new Integer(getMSecond()).toString();
        ms = getMSecond()<10?"00"+getMSecond():ms;
        return h+":"+m;
    }
    /** 
     * getCal - get the calendar
     * 
     *     <code>Calendar c = time.getgetCal()</code>
     *
     * @return Returns the calendar
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public Calendar getCal() {
        return cal;
    }
    /** 
     * compare - compare 2 Time
     * 
     *     <code>int c = Time.compare(time1,time2)</code>
     *
     * @param t1 a Time
     * @param t2 a Time
     * @return Returns -1 if time1 is before time2<br>
     * 1 if time1 is after time2<br>
     * 0 if it's equal  
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public static int compare(Time t1,Time t2){
        if(t1.getCal().compareTo(t2.getCal())==-1) return -1;
        else if(t1.getCal().compareTo(t2.getCal())==1) return 1;
        else return 0;
    }
    /** 
     * addDay - add or remove a number of day
     * 
     *     <code>c.addDay(2)</code>
     *
     * @param number the number to add or remove 
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public void addDay(int number){
        cal.add(Calendar.DAY_OF_MONTH,number);
    }
    /** 
     * addMonth - add or remove a number of month
     * 
     *     <code>c.addMonth(2)</code>
     *
     * @param number the number of month to add or remove
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public void addMonth(int number){
        cal.add(Calendar.MONTH,number);
    }
    /** 
     * addYear - add or remove a number of year
     * 
     *     <code>c.addYear(2)</code>
     *
     * @param number the number of year to add or remove
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public void addYear(int number){
        cal.add(Calendar.YEAR,number);
    }
    /** 
     * addHour - add or remove a number of hour
     * 
     *     <code>c.addHour(2)</code>
     *
     * @param number the number of hour to add or remove
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public void addHour(int number){
        cal.add(Calendar.HOUR_OF_DAY,number);
    }
    /** 
     * addMinute - add or remove a number of minute
     * 
     *     <code>c.addMinute(2)</code>
     *
     * @param number the number of minute to add or remove
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public void addMinute(int number){
        cal.add(Calendar.MINUTE,number);
    }
    /** 
     * addSecond - add or remove a number of seconds
     * 
     *     <code>c.addSecond(2)</code>
     *
     * @param number the number of second to add or remove
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public void addSecond(int number){
        cal.add(Calendar.SECOND,number);
    }
    /** 
     * addMSecond - add or remove a number of milliseconds
     * 
     *     <code>c.addMSecond(2)</code>
     *
     * @param number the number of milliseconds to add or remove
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public void addMSecond(int number){
        cal.add(Calendar.MILLISECOND,number);
    }
    /** 
     * addWeek - add or remove a number of week
     * 
     *     <code>c.addWeek(2)</code>
     *
     * @param number the number of week to add or remove
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public void addWeek(int number){
        cal.add(Calendar.WEEK_OF_YEAR,number);
    }
    /** 
     * getGapMSecond - Get the number of millisecond between two Time
     * 
     *     <code>long l = FlexiTime.getGapMSecond(t1,t2)</code>
     *
     * @param t1 a Time
     * @param t2 a Time
     * @return Returns the number of millisecond between two Time in long<br>
     * 
     * @author   FlexiTeam - VF
     * @date     7 janv. 2005
     */
    public static long getGapMSecond(Time t1, Time t2){
        long gap = (t2.getCal().getTimeInMillis() - t1.getCal().getTimeInMillis());
        if (gap < 0) return -gap;
        return gap;
    }
    /** 
     * getGapMSecond - Get the number of second between two Time
     * 
     *     <code>long l = FlexiTime.getGapSecond(t1,t2)</code>
     *
     * @param t1 a Time
     * @param t2 a Time
     * @return Returns the number of second between two Time in long<br>
     * 
     * @author   FlexiTeam - VF
     * @date     7 janv. 2005
     */
    public static long getGapSecond(Time t1, Time t2){
        long gap = (t2.getCal().getTimeInMillis() - t1.getCal().getTimeInMillis()) / 1000;
        if (gap < 0) return -gap;
        return gap;
    }
    /** 
     * getGapMinute - Get the number of minute between two Time
     * 
     *     <code>int i = FlexiTime.getGapMinute(t1,t2)</code>
     *
     * @param t1 a Time
     * @param t2 a Time
     * @return Returns the number of minute between two Time in int<br>
     * Returns -1 if it can't get a int with the long
     * 
     * @author   FlexiTeam - VF
     * @date     7 janv. 2005
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
     *     <code>int i = FlexiTime.getGapHour(t1,t2)</code>
     *
     * @param t1 a Time
     * @param t2 a Time
     * @return Returns the number of bour between two Time in int<br>
     * Returns -1 if it can't get a int with the long
     * 
     * @author   FlexiTeam - VF
     * @date     7 janv. 2005
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
     *     <code>int i = FlexiTime.getGapWeek(t1,t2)</code>
     *
     * @param t1 a Time
     * @param t2 a Time
     * @return Returns the number of week between two Time in int<br>
     * 
     * @author   FlexiTeam - VF
     * @date     7 janv. 2005
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
            System.out.println(maxTime.getWeek()+" "+minTime.getWeek());
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
    
    
    public static int countNbMinute_HM(Time begin, Time end)
    {
        return ( (end.getHour() - begin.getHour()) * 60 + (end.getMinute() - begin.getMinute()));
    } 
    
}