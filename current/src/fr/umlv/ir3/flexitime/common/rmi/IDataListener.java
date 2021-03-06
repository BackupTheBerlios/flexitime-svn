/*
 * Created on 27 d�c. 2004
 * by Val�re
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.rmi;

import fr.umlv.ir3.flexitime.common.event.DataEvent;

/**
 * Interface that all distant listeners have to implement
 * Extends Remote in order to be called remotely.
 * 
 * @version 1.0
 * @author FlexiTeam - Val�re
 */
public interface IDataListener
{

    /**
     *  
     * Called when a data has changed 
     * @param event Data that has changed
     * 
     */
    public void dataChanged(DataEvent event);
}