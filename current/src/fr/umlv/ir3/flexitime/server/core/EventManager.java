/*
 * Created on 20 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.IDataListener;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * 
 */
public class EventManager
{
    private final HashMap<Class, List<IDataListener>> map = new HashMap<Class, List<IDataListener>>();
    
    
    
    public void addDataListener(Class _class, IDataListener listener)
    {
        List<IDataListener> l = map.get(_class);
        if(l==null)
        {
            l = new ArrayList<IDataListener>();
            map.put(_class, l);
        }
        
        l.add(listener);
    }
    
    public void removeDataListener(Class _class, IDataListener listener)
    {
        List<IDataListener> l = map.get(_class);
        if(l==null)
            return;
        
        l.remove(listener);
    }
    
    public void fireDataChanged(Class _class, DataEvent event)
    {
        List<IDataListener> l = map.get(_class);
        if(l==null)
            return;
        
//        for(Iterator<IDataListener> it = l.iterator(); it.hasNext(); )
//        {
//            IDataListener listener = it.next();
//            
//            try
//            {
//                listener.dataChanged(event);
//            }
//            catch (RemoteException e)
//            {
//                //Plus de listener
//                l.remove(listener);
//            }
//        }
        
        ThreadManager t = new ThreadManager(l, event);
        t.start();
        
    }

}

