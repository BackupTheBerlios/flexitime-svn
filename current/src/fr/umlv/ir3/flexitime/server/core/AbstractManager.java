/*
 * Created on 26 déc. 2004
 * by Valère
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import fr.umlv.ir3.flexitime.common.data.Data;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.IDataListener;
import fr.umlv.ir3.flexitime.common.rmi.IDataManager;


/**
 * AbstractManager - 
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère
 */
public abstract class AbstractManager extends UnicastRemoteObject implements IDataManager{
    /**
	 * @throws RemoteException
	 */
	protected AbstractManager() throws RemoteException {
		super();
	}
	private List listenerList = new ArrayList();
	
	/** 
	 * addListener - DOCME Description
	 * Quel service est rendu par cette méthode
	 * 
	 *     <code>exemple d'appel de la methode</code>
	 *
	 * @param l
	 * @throws RemoteException 
	 * 
	 * @author   FlexiTeam - Valère
	 * @date     27 déc. 2004
	 */
	public void addListener(IDataListener l) throws RemoteException
	{
		listenerList.add(l);
	}
	
	/**
	 * @param t
	 * @param added
	 */
	protected void notifyListener(Data d, int property) throws RemoteException {
		for (Iterator iter = listenerList.iterator(); iter.hasNext();)
		{
			IDataListener element = (IDataListener) iter.next();
			element.dataChanged(new DataEvent(d, property));
		}
	}
	
	/** 
	 * getDatas - DOCME Description
	 * Quel service est rendu par cette méthode
	 * 
	 *     <code>exemple d'appel de la methode</code>
	 *
	 * @return
	 * @throws RemoteException 
	 * 
	 * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getDatas()
	 * @author   FlexiTeam - Valère
	 * @date     27 déc. 2004
	 */
	public List get() throws RemoteException {
        return null;
    }
    /** 
     * createData - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#createData(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public void create(Data data) throws RemoteException {}
    /** 
     * updateData - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#updateData(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public void update(Data data) throws RemoteException {}
    /** 
     * removeData - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#removeData(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public void remove(Data data) throws RemoteException {}
    /** 
     * lock - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @return
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#lock(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public boolean lock(Data data) throws RemoteException {
        return false;
    }
    /** 
     * unlock - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @return
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#unlock(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public boolean unlock(Data data) throws RemoteException {
        return false;
    } 


}
