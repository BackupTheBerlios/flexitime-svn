/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.tools;

import java.util.Calendar;


/**
 * Description Tool for time. <br>
 * This Class allows the users to work with Time Object And to have it under
 * different kinds
 * 
 * @version 216
 * @author FlexiTeam - Jérôme GUERS
 */
public class Time implements Comparable
{

    // ===========//
    // Champs //
    // ===========//
    private Calendar             cal;
    private static FlexiLanguage language;

    // =================//
    // Constructeurs //
    // =================//
    static
    {
        language = FlexiLanguage.getInstance();
    }

    /**
     * Default constructor - Get the calendar now
     */
    public Time()
    {
        cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
    }

    /**
     * Take a calendar
     * 
     * @param c
     *            a calendar
     */
    public Time(Calendar c)
    {
        cal = c;
        cal.setFirstDayOfWeek(Calendar.MONDAY);
    }

    /**
     * Take all the element of a date
     * 
     * @param year
     * @param month
     *            (1-12)
     * @param day
     * @param hour
     * @param minute
     */
    public Time(int year, int month, int day, int hour, int minute)
    {
        cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, day, hour, minute, 0);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
    }

    // =============//
    // Méthodes //
    // =============//
    /**
     * getYear - get the year
     * 
     * @return Returns the year
     */
    public int getYear()
    {
        return cal.get(Calendar.YEAR);
    }

    /**
     * getIMonth - get the month <br>
     * January = 1 <br>
     * December = 12
     * 
     * @return Returns the month
     */
    public int getIMonth()
    {
        return cal.get(Calendar.MONTH);
    }

    /**
     * getStrMonth - get the Month in String
     * 
     * @return Returns the month in String
     */
    public String getStrMonth()
    {
        return language.getMonth(cal.get(Calendar.MONTH));
    }

    /**
     * getWeek - get the week of the year
     * 
     * @return Returns the week
     */
    public int getWeek()
    {
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * getIDay - get the day in the month
     * 
     * @return Returns the day in the month
     */
    public int getIDay()
    {
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * getIDay - get the day in week <br>
     * Monday = 0 <br>
     * Sunday = 6
     * 
     * @return Returns the day in the week
     */
    public int getIDayOfWeek()
    {
        int d = cal.get(Calendar.DAY_OF_WEEK);
        if (d == Calendar.SUNDAY) return 6;
        return d - 2;
    }

    /**
     * getStrDay - get the day in String
     * 
     * @return Returns the day in String
     */
    public String getStrDay()
    {
        return language.getDay(cal.get(Calendar.DAY_OF_WEEK));
    }

    /**
     * getHour - get the hour in 24H
     * 
     * @return Returns the hour in 24H
     */
    public int getHour()
    {
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * getMinute - get the minutes
     * 
     * @return Returns the minutes
     */
    public int getMinute()
    {
        return cal.get(Calendar.MINUTE);
    }

    /**
     * getSecond - get the seconds
     * 
     * @return Returns the seconds
     */
    public int getSecond()
    {
        return cal.get(Calendar.SECOND);
    }

    /**
     * getMSecond - get the milliseconds
     * 
     * @return Returns the milliseconds
     */
    public int getMSecond()
    {
        return cal.get(Calendar.MILLISECOND);
    }

    /**
     * getDate - get the date in dd/mm/yyyy
     * 
     * @return Returns the date
     */
    public String getShortDate()
    {
        return language.formatShortDate(this);
    }

    /**
     * getStrDate - get the date in "strDay iDay strMonth year"
     * 
     * @return Returns the date
     */
    public String getStrDate()
    {
        return language.formatLongDate(this);
    }

    /**
     * getFullTime - get the time in "hh:mm:ss:mms"
     * 
     * @return Returns the time
     */
    public String getFullTime()
    {
        return language.formatLongTime(this);
    }

    /**
     * Get the time in "hh:mm"
     * 
     * @return Returns the time
     */
    public String getStrTime()
    {
        return language.formatShortTime(this);
    }

    /**
     * Get the calendar
     * 
     * @return Returns the calendar
     */
    public Calendar getCal()
    {
        return cal;
    }

    /**
     * Compare 2 Time
     * 
     * @param t2
     *            a Time
     * @return
     *            <ul>
     *            <li>-1 if time1 is before time2</li>
     *            <li>1 if time1 is after time2</li>
     *            <li>0 if it's equal</li>
     *            </ul>
     */
    public int compareTo(Object t2)
    {
        return this.getCal().compareTo(((Time)t2).getCal());
    }

    /**
     * Add or remove a number of day
     * 
     * @param number
     *            the number to add or remove
     */
    public void addDay(int number)
    {
        cal.add(Calendar.DAY_OF_MONTH, number);
    }

    /**
     * Add or remove a number of month
     * 
     * @param number
     *            the number of month to add or remove
     */
    public void addMonth(int number)
    {
        cal.add(Calendar.MONTH, number);
    }

    /**
     * Add or remove a number of year
     * 
     * @param number
     *            the number of year to add or remove
     */
    public void addYear(int number)
    {
        cal.add(Calendar.YEAR, number);
    }

    /**
     * Add or remove a number of hour
     * 
     * @param number
     *            the number of hour to add or remove
     */
    public void addHour(int number)
    {
        cal.add(Calendar.HOUR_OF_DAY, number);
    }

    /**
     * Add or remove a number of minute
     * 
     * @param number
     *            the number of minute to add or remove
     */
    public void addMinute(int number)
    {
        cal.add(Calendar.MINUTE, number);
    }

    /**
     * Add or remove a number of seconds
     * 
     * @param number
     *            the number of second to add or remove
     */
    public void addSecond(int number)
    {
        cal.add(Calendar.SECOND, number);
    }

    /**
     * Add or remove a number of milliseconds
     * 
     * @param number
     *            the number of milliseconds to add or remove
     */
    public void addMSecond(int number)
    {
        cal.add(Calendar.MILLISECOND, number);
    }

    /**
     * Add or remove a number of week
     * 
     * @param number
     *            the number of week to add or remove
     */
    public void addWeek(int number)
    {
        cal.add(Calendar.WEEK_OF_YEAR, number);
    }

    // ================== //
    // Méthodes statiques //
    // ================== //
    /**
     * Compare 2 Time
     * 
     * @param t1
     *            a Time
     * @param t2
     *            a Time
     * @return
     *            <ul>
     *            <li>-1 if time1 is before time2</li>
     *            <li>1 if time1 is after time2</li>
     *            <li>0 if it's equal</li>
     *            </ul>
     */
    public static int compare(Time t1, Time t2)
    {
        return t1.getCal().compareTo(t2.getCal());
    }
    
    /**
     * Get the number of millisecond between two Time.
     * 
     * @param t1
     *            a Time
     * @param t2
     *            a Time
     * @return Number of millisecond between two Time in long
     */
    public static long getGapMSecond(Time t1, Time t2)
    {
        long gap = ( t2.getCal().getTimeInMillis() - t1.getCal()
                .getTimeInMillis() );
        if (gap < 0) return -gap;
        return gap;
    }

    /**
     * Get the number of second between two Time.
     * 
     * @param t1
     *            a Time
     * @param t2
     *            a Time
     * @return Number of second between two Time in long <br>
     */
    public static long getGapSecond(Time t1, Time t2)
    {
        long gap = ( t2.getCal().getTimeInMillis() - t1.getCal()
                .getTimeInMillis() ) / 1000;
        if (gap < 0) return -gap;
        return gap;
    }

    /**
     * Get the number of minute between two Time.
     * 
     * @param t1
     *            a Time
     * @param t2
     *            a Time
     * @return
     *            <ul>
     *            <li>the number of minute between two Time in int</li>
     *            <li>-1 if it can't get a int with the long</li>
     *            </ul>
     */
    public static int getGapMinute(Time t1, Time t2)
    {
        long gap = ( t2.getCal().getTimeInMillis() - t1.getCal()
                .getTimeInMillis() ) / 60000;
        try
        {
            if (gap < 0) return (int) -gap;
            return (int) gap;
        }
        catch (Exception e)
        {
            return -1;
        }
    }

    /**
     * Get the number of hour between two Time.
     * 
     * @param t1
     *            a Time
     * @param t2
     *            a Time
     * @return
     *            <ul>
     *            <li>the number of hour between two Time in int</li>
     *            </li>
     *            </ul>
     *            -1 if it can't get a int with the long</li>
     *            </ul>
     */
    public static int getGapHour(Time t1, Time t2)
    {
        long gap = ( t2.getCal().getTimeInMillis() - t1.getCal()
                .getTimeInMillis() ) / 3600000;
        try
        {
            if (gap < 0) return (int) -gap;
            return (int) gap;
        }
        catch (Exception e)
        {
            return -1;
        }
    }

    /**
     * Get the number of week between two Time.
     * 
     * @param t1
     *            a Time
     * @param t2
     *            a Time
     * @return Number of week between two Time in int
     */
    public static int getGapWeek(Time t1, Time t2)
    {
        Calendar c = Calendar.getInstance();
        long number = t1.getCal().getTimeInMillis();
        c.setTimeInMillis(number);
        Calendar c2 = t2.getCal();
        
        if(c.get(Calendar.WEEK_OF_YEAR)==c2.get(Calendar.WEEK_OF_YEAR) && c.get(Calendar.YEAR)==c2.get(Calendar.YEAR))
            return 0;
        long nb3 = c2.getTimeInMillis()-c.getTimeInMillis();

        if((nb3/100)<(60*60*60*24*7)) return 0;
        int tmp = 0;
        boolean bool= false;
        while(bool==false){
            do{
                tmp++;
                c.add(Calendar.WEEK_OF_YEAR,1);
            }while(c.get(Calendar.WEEK_OF_YEAR)!=c2.get(Calendar.WEEK_OF_YEAR));
            if(c.get(Calendar.YEAR)==c2.get(Calendar.YEAR))bool=true;
        }
        return tmp;
    }
    
   /*public static void main(String[] args){
        Time t= new Time(2004,12,27,0,0);
        Time t2 = new Time(2050,1,2,0,0);
        System.out.println(Time.getGapWeek(t,t2));
    }*/

    /**
     * Gets the number of hour (in float) between 2 Time. <br>
     * It doesn't take care of year, month, day
     * 
     * @param begin
     *            the begin time
     * @param end
     *            the end time
     * @return Number of hour
     */
    public static float countNbHour_HM(Time begin, Time end)
    {
        return ( end.getHour() - begin.getHour() )
                + ( ( (float) end.getMinute() - (float) begin.getMinute() ) / 60 );
    }

    /**
     * Gets the number of minute between 2 Time. <br>
     * It doesn't take care of year, month, day
     * 
     * @param begin
     *            the begin time
     * @param end
     *            the end time
     * @return Number of minute
     */
    public static int countNbMinute_HM(Time begin, Time end)
    {
        return ( ( end.getHour() - begin.getHour() ) * 60 + ( end.getMinute() - begin
                .getMinute() ) );
    }
}
