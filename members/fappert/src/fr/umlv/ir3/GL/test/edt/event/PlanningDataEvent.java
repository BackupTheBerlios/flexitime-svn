/*
 * Created on 16 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.GL.test.edt.event;



/**
 * Defines an event that encapsulates changes to a planning.
 *
 * @version 0.1 16/01/05
 * @author Fabien Appert
 */
public class PlanningDataEvent
{
    /** Identifies one or more changes in the planning contents. */
    public static final int CONTENTS_CHANGED = 0;
    /** Identifies the addition of one or more contiguous items to the planning */
    public static final int INTERVAL_ADDED = 1;
    /** Identifies the removal of one or more contiguous items from the planning */
    public static final int INTERVAL_REMOVED = 2;

    private int type;
    private int weekNumber;
    private int dayNumber;
    private int lowerGap;
    private int upperGap;

    /**
     * Returns the event type. The possible values are:
     * <ul>
     * <li> {@link #CONTENTS_CHANGED}
     * <li> {@link #INTERVAL_ADDED}
     * <li> {@link #INTERVAL_REMOVED}
     * </ul>
     *
     * @return an int representing the type value
     */
    public int getType() { return type; }

    
    /**
     * Returns the week of the range.
     *
     * @return an int representing the week value
     */
    public int getWeekNumber() { return weekNumber; }
    
    
    /**
     * Returns the day of the range.
     *
     * @return an int representing the day value
     */
    public int getDaynumber() { return dayNumber; }
    
    /**
     * Returns the lower gap of the range.
     *
     * @return an int representing the lower gap value
     */
    public int getLowerGap() { return lowerGap; }
    
    /**
     * Returns the upper gap of the range.
     *
     * @return an int representing the upper gap value
     */
    public int getUpperGap() { return upperGap; }

    
    /**
     * Constructs a PlanningDataEvent object
     *
     * @param source  the source Object (typically <code>this</code>)
     * @param type    an int specifying {@link #CONTENTS_CHANGED},
     *                {@link #INTERVAL_ADDED}, or {@link #INTERVAL_REMOVED}
     * @param week  the week of the interval
     * @param day  the day of the interval
     * @param lowerGap  one end of the interval
     * @param upperGap  the other end of the interval
     */
    public PlanningDataEvent(int type, int week, int day, int lowerGap, int upperGap)
    {
		this.type = type;
		this.dayNumber = day;
		this.weekNumber = week;
		this.lowerGap = Math.min(lowerGap, upperGap);
		this.upperGap = Math.max(lowerGap, upperGap);
    }

    /**
     * Returns a string representation of this PlanningDataEvent. This method 
     * is intended to be used only for debugging purposes, and the 
     * content and format of the returned string may vary between      
     * implementations. The returned string may be empty but may not 
     * be <code>null</code>.
     * 
     * @return  a string representation of this PlanningDataEvent.
     */
    public String toString() {
        return getClass().getName() +
        "[type=" + type +
        ",week=" + weekNumber +
        ",day=" + dayNumber +
        ",lowerGap=" + lowerGap +
        ",upperGap=" + upperGap + "]";
    }
}





