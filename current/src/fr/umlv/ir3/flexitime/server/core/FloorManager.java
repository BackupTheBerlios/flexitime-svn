/*
 * Created on 26 déc. 2004
 * by Valère
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.general.Floor;



/**
 * FloorManagerImpl - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Valère
 */
public class FloorManager extends AbstractManager{

    /**
     * DOCME
     * @throws RemoteException
     */
    protected FloorManager() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

	/** 
	 * get - DOCME Description
	 * Quel service est rendu par cette méthode
	 * 
	 *     <code>exemple d'appel de la methode</code>
	 *
	 * @return
	 * @throws RemoteException 
	 * 
	 * @see fr.umlv.ir3.flexitime.server.core.AbstractManager#get()
	 * @author   FlexiTeam - Valère
	 * @date     27 déc. 2004
	 */
	public List get() throws RemoteException {
        return null;
    }
    /** 
     * create - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param floor
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public void create(Floor floor) throws RemoteException {}
    /** 
     * update - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param floor
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public void update(Floor floor) throws RemoteException {}
    /** 
     * remove - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param floor
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public void remove(Floor floor) throws RemoteException {}
    /** 
     * lock - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param floor
     * @return
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public boolean lock(Floor floor) throws RemoteException {
        return false;
    }
    /** 
     * unlock - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param floor
     * @return
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public boolean unlock(Floor floor) throws RemoteException {
        return false;
    }
}
