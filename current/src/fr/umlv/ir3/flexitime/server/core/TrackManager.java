/*
 * Created on 15 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.general.Track;

/**
 * TracksManagerImpl - implements the interface TracksManager
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Valère FOREL
 */
public class TrackManager extends AbstractManager {

    /**
     * DOCME
     * @throws RemoteException
     */
    protected TrackManager() throws RemoteException {
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
     * @param track
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public void create(Track track) throws RemoteException {}
    /** 
     * update - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param track
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public void update(Track track) throws RemoteException {}
    /** 
     * remove - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param track
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public void remove(Track track) throws RemoteException {}
    /** 
     * lock - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param track
     * @return
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public boolean lock(Track track) throws RemoteException {
        return false;
    }
    /** 
     * unlock - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param track
     * @return
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public boolean unlock(Track track) throws RemoteException {
        return false;
    }

}
