/*
 * Created on 15 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.umlv.ir3.flexitime.richClient.event.PlanningDataEvent;
import fr.umlv.ir3.flexitime.richClient.event.PlanningDataListener;




/**
 * An abstract model that notify the client for changement
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - binou
 */
public abstract class AbstractPlanningModel implements PlanningModel
{
    private List<PlanningDataListener> listenerList;
    
    
    /**
     * Constructs bla bla bla ;)
     * 
     */
    public AbstractPlanningModel()
    {
        this.listenerList = new ArrayList<PlanningDataListener>(2);
    }
    
    /**
     * Adds a listener to the list that's notified each time a change
     * to the data model occurs.
     *
     * @param l the <code>PlanningDataListener</code> to be added
     */  
    public void addPlanningDataListener(PlanningDataListener l) {
        listenerList.add(l);
    }


    /**
     * Removes a listener from the list that's notified each time a 
     * change to the data model occurs.
     *
     * @param l the <code>PlanningDataListener</code> to be removed
     */  
    public void removePlanningDataListener(PlanningDataListener l) {
	listenerList.remove(l);
    }


    /**
     * Returns an array of all the list data listeners
     * registered on this <code>AbstractPlanningModel</code>.
     *
     * @return all of this model's <code>PlanningDataListener</code>s,
     *         or an empty array if no list data listeners
     *         are currently registered
     * 
     * @see #addPlanningDataListener
     * @see #removePlanningDataListener
     * 
     * @since 1.4
     */
    public PlanningDataListener[] getPlanningDataListeners() {
        return (PlanningDataListener[])listenerList.toArray();
    }


    /**
     * <code>AbstractListModel</code> subclasses must call this method
     * <b>after</b>
     * one or more elements of the list change.  The changed elements
     * are specified by the closed interval lowerGap, upperGap -- the endpoints
     * are included.  Note that
     * lowerGap need not be less than or equal to upperGap.
     * 
     * @param source the <code>PlanningModel</code> that changed, typically "this"
     * @param lowerGap one end of the interval
     * @param upperGap the other end of the interval
     * @see DefaultPlanningModel
     */
    protected void fireContentsChanged(int week, int day, int lowerGap, int upperGap)
    {
		for (Iterator iter = listenerList.iterator() ; iter.hasNext() ;)
	    {
	        PlanningDataListener element = (PlanningDataListener) iter.next();
	        element.contentsChanged(new PlanningDataEvent(PlanningDataEvent.CONTENTS_CHANGED, week, day, lowerGap, upperGap));
	    }
    }


    /**
     * <code>AbstractPlanningModel</code> subclasses must call this method
     * <b>after</b>
     * one or more elements are added to the model.  The new elements
     * are specified by a closed interval lowerGap, upperGap -- the enpoints
     * are included.  Note that
     * lowerGap need not be less than or equal to upperGap.
     * 
     * @param source the <code>PlanningModel</code> that changed, typically "this"
     * @param lowerGap one end of the interval
     * @param upperGap the other end of the interval
     * @see DefaultPlanningModel
     */
    protected void fireIntervalAdded(int week, int day, int lowerGap, int upperGap)
    {
		for (Iterator iter = listenerList.iterator() ; iter.hasNext() ;)
	    {
	        PlanningDataListener element = (PlanningDataListener) iter.next();
	        element.intervalAdded(new PlanningDataEvent(PlanningDataEvent.INTERVAL_ADDED, week, day, lowerGap, upperGap));
	    }
    }


    /**
     * <code>AbstractPlanningModel</code> subclasses must call this method
     * <b>after</b> one or more elements are removed from the model. 
     * <code>lowerGap</code> and <code>upperGap</code> are the end points
     * of the interval that's been removed.  Note that <code>lowerGap</code>
     * need not be less than or equal to <code>upperGap</code>.
     * 
     * @param source the <code>PlanningModel</code> that changed, typically "this"
     * @param lowerGap one end of the interval,
     *               including <code>lowerGap</code>
     * @param upperGap the other end of the interval,
     *               including <code>upperGap</code>
     * @see DefaultPlanningModel
     */
    protected void fireIntervalRemoved(int week, int day, int lowerGap, int upperGap)
    {
		for (Iterator iter = listenerList.iterator() ; iter.hasNext() ;)
	    {
	        PlanningDataListener element = (PlanningDataListener) iter.next();
	        element.intervalRemoved(new PlanningDataEvent(PlanningDataEvent.INTERVAL_REMOVED, week, day, lowerGap, upperGap));
	    }
    }

}

