/*
 * Created on 19 janv. 2005
 * by Jérôme GUERS
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.tools;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


/**
 * Class for the language<br>
 * Used for the the Externalize string
 * 
 * @version 210
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class FlexiLanguage
{

    // ====== //
    // Champs //
    // ====== //
    Locale                       currentLocale = null;
    ResourceBundle               prop          = null;
    DateFormat                   shortDate     = null;
    DateFormat                   longDate      = null;
    DateFormat                   shortTime     = null;
    DateFormat                   longTime      = null;
    private static FlexiLanguage flexiLanguage = null;

    // ============= //
    // Constructeurs //
    // ============= //
    /**
     * Return a new language instance
     * 
     * @return a new language access
     */
    public static FlexiLanguage getInstance()
    {
        if (flexiLanguage == null)
        {
            flexiLanguage = new FlexiLanguage();
        }
        return flexiLanguage;
    }

    private FlexiLanguage()
    {
        setLocale(Locale.getDefault());
    }

    /**
     * Change the language format
     * 
     * @param locale
     */
    public void setLocale(Locale locale)
    {
        currentLocale = locale;
        shortDate = DateFormat.getDateInstance(DateFormat.SHORT, currentLocale);
        longDate = DateFormat.getDateInstance(DateFormat.FULL, currentLocale);
        shortTime = DateFormat.getTimeInstance(DateFormat.SHORT, currentLocale);
        longTime = DateFormat.getTimeInstance(DateFormat.LONG, currentLocale);
        prop = ResourceBundle.getBundle("str");//$NON-NLS-1$
    }

    /**
     * Format date in short format. ("M/d/yy" for US for exemple)
     * 
     * @param t
     *            time to format date field
     * @return a string format of the time
     */
    public String formatShortDate(Time t)
    {
        return shortDate.format(t.getCal().getTime().getTime());
    }

    /**
     * Format date in long format. ("dddd dd MMMM yyyy" for US for exemple)
     * 
     * @param t
     *            time to format date field
     * @return a string format of the time
     */
    public String formatLongDate(Time t)
    {
        return longDate.format(t.getCal().getTime().getTime());
    }

    /**
     * Format time in short format ("hh:mm" for US for exemple)
     * 
     * @param t
     *            time to format time field
     * @return a string format of the time
     */
    public String formatShortTime(Time t)
    {
        return shortTime.format(t.getCal().getTime().getTime());
    }
    
    /**
     * Format time in long format ("hh:mm:ss" for US for exemple)
     * 
     * @param t
     *            time to format time field
     * @return a string format of the time
     */
    public String formatLongTime(Time t)
    {
        return longTime.format(t.getCal().getTime().getTime());
    }


    /**
     * Parse a string an return a new time corresponding to the string
     * 
     * @param date
     *            date to parse
     * @return a new Time
     * @throws ParseException
     *             if the string does not correspond to a date
     */
    public Time parseDate(String date) throws ParseException
    {
        Time tmp = new Time();
        tmp.getCal().setTime(shortDate.parse(date));
        return tmp;
    }

    /**
     * DOCME
     * 
     * @param m
     * @return a string representing the month <code>m</code>
     */
    public String getMonth(int m)
    {
        GregorianCalendar month = new GregorianCalendar(2000, m, 1);
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "MMMM", this.currentLocale);//$NON-NLS-1$
        StringBuffer result = new StringBuffer();
        result = dateFormat.format(month.getTime(), result, new FieldPosition(
                DateFormat.MONTH_FIELD));
        return result.toString();
    }

    /**
     * DOCME
     * 
     * @param d
     * @return a string representing the day of week <code>d</code>
     */
    public String getDay(int d)
    {
        GregorianCalendar day = new GregorianCalendar(2000, 1, 1);
        while (day.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY)
        {
            day.add(Calendar.DATE, 1);
        }
        day.add(Calendar.DATE, d);

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "EEEE", this.currentLocale);//$NON-NLS-1$
        StringBuffer result = new StringBuffer();
        result = dateFormat.format(day.getTime(), result, new FieldPosition(
                DateFormat.DAY_OF_WEEK_FIELD));
        return result.toString();
    }

    /**
     * Return the string corresponding to the <code>key</code> in the current
     * locale
     * 
     * @param key
     * @return string corresponding
     */
    public String getText(String key)
    {
        try
        {
            return prop.getString(key);
        }
        catch (MissingResourceException e)
        {
            return "Missing resource: " + key; //$NON-NLS-1$
        }
    }
}
