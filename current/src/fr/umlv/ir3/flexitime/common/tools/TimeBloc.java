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
}
