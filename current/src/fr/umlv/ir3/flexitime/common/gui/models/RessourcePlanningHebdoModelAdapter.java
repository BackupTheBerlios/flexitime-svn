/*
 * Created on 21 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.gui.models;

import java.util.Calendar;

import fr.umlv.ir3.flexitime.common.data.resources.IResource;
import fr.umlv.ir3.flexitime.common.tools.Gap;
import fr.umlv.ir3.flexitime.common.tools.Time;


/**
 * Adapter extended the <code>RessourcePlanningModel</code> to <br>
 * manipulate data for one ressource juste for one week
 * 
 * @version 0.5
 * 
 * @author FlexiTeam - binou
 */
public class RessourcePlanningHebdoModelAdapter extends RessourcePlanningModel
{

    /**
     * Constructs a Model according to the specified Ressource
     * and the initial Gap to handle
     * 
     * @param ressource
     * @param initialGap
     */
    public RessourcePlanningHebdoModelAdapter(IResource ressource, Gap initialGap)
    {
        super(ressource,initialGap);
        //this.model = new RessourcePlanningModel(ressource,initialGap);
    }
    
    /** 
     * Return the element at the specified index<br>
     *
     * @param dayNumber the value of the day (0 is the first)
     * @param gapNumber the value of the gap (0 is the first)
     * @return the Object at the specified index
     * 
     * @author   FlexiTeam - binou
     */
    public Object getElementAt(int dayNumber, int gapNumber)
    {
        return super.getElementAt(0, dayNumber, gapNumber);
    }
    
    /**
     * Return a String which is the name of the date we want
     * <br>
     * in order to constructs the header of the Day in the planning Example :
     * <code>model.getDayHeaderAt(2)</code> will return "Mardi 2 Janvier 2005"
     * 
     * @param dayNumber the value of the day (0 is the first)
     * @return an String representation of this day
     * @author FlexiTeam - binou
     */
    public Object getDayHeaderAt(int dayNumber)
    {
        Time t = new Time((Calendar)super.getDateHeaderAt(0,dayNumber));
        return (String)super.getDayHeaderAt(dayNumber) + " " + t.getStrDate().substring(0, t.getStrDate().length()-5);  //$NON-NLS-1$
    }
    
 
    /** 
     * Allows to know if there is a lesson a the specified week, day and gap
     *
     * @param dayNumber the value of the day (0 is the first)
     * @param gapNumber the value of the gap (0 is the first)
     * @return true if there's a lesson
     * 
     */
    public boolean isALesson(int dayNumber, int gapNumber)
    {
        return super.isALesson(0, dayNumber, gapNumber);
    }
}

