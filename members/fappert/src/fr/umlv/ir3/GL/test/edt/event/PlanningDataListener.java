/*
 * Created on 16 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.GL.test.edt.event;



public interface PlanningDataListener{

    /** 
     * Sent after the indices in the lowerGap,upperGap 
     * interval have been inserted in the data model.
     * The new interval includes both lowerGap and upperGap.
     *
     * @param e  a <code>PlanningDataEvent</code> encapsulating the
     *    event information
     */
    void intervalAdded(PlanningDataEvent e);

    
    /**
     * Sent after the indices in the lowerGap,upperGap interval
     * have been removed from the data model.  The interval 
     * includes both lowerGap and upperGap.
     *
     * @param e  a <code>PlanningDataEvent</code> encapsulating the
     *    event information
     */
    void intervalRemoved(PlanningDataEvent e);


    /** 
     * Sent when the contents of the list has changed in a way 
     * that's too complex to characterize with the previous 
     * methods. For example, this is sent when an item has been
     * replaced. lowerGap and upperGap bracket the change.
     *
     * @param e  a <code>PlanningDataEvent</code> encapsulating the
     *    event information
     */
    void contentsChanged(PlanningDataEvent e);
}


