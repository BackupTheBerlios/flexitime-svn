/*
 * Created on 20 janv. 2005
 * by Jérôme GUERS
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.tools;

/**
 * Represents a bloc of time in the timetable
 * 
 * @version 218
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TimeBloc
{

    // ====== //
    // Champs //
    // ====== //
    private int startHour, startMin, endHour, endMin;

    protected TimeBloc()
    {}

    /**
     * Create an TimeBloc with all parameters
     * 
     * @param sH
     *            start hour
     * @param sM
     *            start minute
     * @param eH
     *            end hour
     * @param eM
     *            end minute
     */
    public TimeBloc(int sH, int sM, int eH, int eM)
    {
        startHour = sH;
        startMin = sM;
        endHour = eH;
        endMin = eM;
    }

    /**
     * Return endHour
     * 
     * @return Returns the endHour.
     */
    public int getEndHour()
    {
        return endHour;
    }

    /**
     * Set endHour
     * 
     * @param endHour
     *            The endHour to set.
     */
    public void setEndHour(int endHour)
    {
        this.endHour = endHour;
    }

    /**
     * Return endMin
     * 
     * @return Returns the endMin.
     */
    public int getEndMin()
    {
        return endMin;
    }

    /**
     * Set endMin
     * 
     * @param endMin
     *            The endMin to set.
     */
    public void setEndMin(int endMin)
    {
        this.endMin = endMin;
    }

    /**
     * Return startHour
     * 
     * @return Returns the startHour.
     */
    public int getStartHour()
    {
        return startHour;
    }

    /**
     * Set startHour
     * 
     * @param startHour
     *            The startHour to set.
     */
    public void setStartHour(int startHour)
    {
        this.startHour = startHour;
    }

    /**
     * Return startMin
     * 
     * @return Returns the startMin.
     */
    public int getStartMin()
    {
        return startMin;
    }

    /**
     * Set startMin
     * 
     * @param startMin
     *            The startMin to set.
     */
    public void setStartMin(int startMin)
    {
        this.startMin = startMin;
    }

    /**
     * Gets the number of minute for this bloc
     * 
     * @return Number of minute
     */
    public int countNbMinutes()
    {
        return ( this.endHour - this.startHour ) * 60
                - ( this.endMin - this.startMin );
    }

    /**
     * Gets the number of minute between the beginning of the bloc and the Time
     * 
     * @param t
     *            a Time in the bloc
     * 
     * @return Number of minute
     */
    public int countNbMinutesBefore(Time t)
    {
        if (this.include(t))
            return ( t.getHour() - this.startHour ) * 60
                    + ( t.getMinute() - this.startMin );
        return -1;
    }

    /**
     * Gets the number of minute between the Time and the ending of the bloc
     * 
     * @param t
     *            a Time in the bloc
     * 
     * @return Number of minute
     */
    public int countNbMinutesAfter(Time t)
    {
        if (this.include(t))
            return ( this.endHour - t.getHour() ) * 60
                    + ( this.endMin - t.getMinute() );
        return -1;
    }

    /**
     * Determines if a Time is included in the bloc
     * 
     * the start Time could be equal, but not the end Time
     * 
     * @param t
     *            a Time to compare
     * @return true if the Time is include in the bloc
     * 
     */
    public boolean include(Time t)
    {
        if ( ( t.getHour() > startHour )
                || ( ( t.getHour() == startHour ) && ( t.getMinute() >= startMin ) ))
        {
            if ( ( t.getHour() < endHour )
                    || ( ( t.getHour() == endHour ) && ( t.getMinute() < endMin ) ))
                return true;
        }
        return false;
    }
}
