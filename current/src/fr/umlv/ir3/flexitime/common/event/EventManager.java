/*
 * Created on 20 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.event;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import fr.umlv.ir3.flexitime.common.rmi.IDataListener;

/**
 * Event Manager Client listener register to this class to be notified of
 * changes
 */
public class EventManager
{

    private final ConcurrentHashMap<Class, List<IDataListener>> map = new ConcurrentHashMap<Class, List<IDataListener>>();

    /**
     * @param _class
     * @param listener
     */
    public void addDataListener(Class _class, IDataListener listener)
    {
        List<IDataListener> l = map.get(_class);
        if (l == null)
        {
            l = new CopyOnWriteArrayList<IDataListener>();
            map.put(_class, l);
        }

        l.add(listener);
    }

    /**
     * @param _class
     * @param listener
     */
    public void removeDataListener(Class _class, IDataListener listener)
    {
        List<IDataListener> l = map.get(_class);
        if (l == null) return;

        synchronized (l)
        {
            l.remove(listener);
        }
    }

    /**
     * @param _class
     * @param event
     */
    public void fireDataChanged(Class _class, DataEvent event)
    {
        List<IDataListener> l = map.get(_class);
        if (l == null) return;

        for (Iterator iter = l.iterator() ; iter.hasNext() ;)
        {
            IDataListener element = (IDataListener) iter.next();

            element.dataChanged(event);

        }

    }

}
