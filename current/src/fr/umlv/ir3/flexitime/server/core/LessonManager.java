/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.activity.Lesson;




/**
 * SeanceManagerImpl - Implements the interface SeancesManager
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public class LessonManager extends AbstractManager {

    /**
     * DOCME
     * @throws RemoteException
     */
    protected LessonManager() throws RemoteException {
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
     * @param lesson
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public void create(Lesson lesson) throws RemoteException {}
    /** 
     * update - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param lesson
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public void update(Lesson lesson) throws RemoteException {}
    /** 
     * remove - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param lesson
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public void remove(Lesson lesson) throws RemoteException {}
    /** 
     * lock - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param lesson
     * @return
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public boolean lock(Lesson lesson) throws RemoteException {
        return false;
    }
    /** 
     * unlock - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param lesson
     * @return
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public boolean unlock(Lesson lesson) throws RemoteException {
        return false;
    }

}
