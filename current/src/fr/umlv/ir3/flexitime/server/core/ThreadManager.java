/*
 * Created on 13 janv. 2005
 * by Administrateur
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.IDataListener;


/**
 * DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - Administrateur
 */
public class ThreadManager extends Thread
{
    private List listenerList;
    private IData data;
    private int property;
    /**
     * DOCME
     * @param list
     * @param data
     * @param property
     */
    public ThreadManager(List list, IData data, int property) {
        this.listenerList = list;
        this.data = data;
        this.property = property;
    }
    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     *  
     * 
     * @see java.lang.Thread#run()
     * @author   FlexiTeam - Administrateur
     */
    public void run() {
        ArrayList toRemove = new ArrayList();
        for (Iterator iter = listenerList.iterator() ; iter.hasNext() ;)
        {
            IDataListener element = (IDataListener) iter.next();
            try
            {
                element.dataChanged(new DataEvent(data, property));
            }
            catch (RemoteException e)
            {
                //Listener not reachable
                //Mark it to be removed
                toRemove.add(element);
            }
        }
        
        if(!toRemove.isEmpty()){
            listenerList.removeAll(toRemove);
        }
    }
}

