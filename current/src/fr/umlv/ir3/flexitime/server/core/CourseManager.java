/*
 * Created on 26 d�c. 2004
 * by Val�re
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.Course;



/**
 * CourseManagerImpl - DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - Val�re
 */
public class CourseManager extends AbstractManager{

    /**
     * DOCME
     * @throws RemoteException
     */
    protected CourseManager() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

	/** 
	 * get - DOCME Description
	 * Quel service est rendu par cette m�thode
	 * 
	 *     <code>exemple d'appel de la methode</code>
	 *
	 * @return
	 * @throws RemoteException 
	 * 
	 * @see fr.umlv.ir3.flexitime.server.core.AbstractManager#get()
	 * @author   FlexiTeam - Val�re
	 * @date     27 d�c. 2004
	 */
	public List get() throws RemoteException {
        return null;
    }
    /** 
     * create - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param course
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Val�re
     * @date     27 d�c. 2004
     */
    public void create(Course course) throws RemoteException {}
    /** 
     * update - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param course
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Val�re
     * @date     27 d�c. 2004
     */
    public void update(Course course) throws RemoteException {}
    /** 
     * remove - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param course
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Val�re
     * @date     27 d�c. 2004
     */
    public void remove(Course course) throws RemoteException {}
    /** 
     * lock - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param course
     * @return
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Val�re
     * @date     27 d�c. 2004
     */
    public boolean lock(Course course) throws RemoteException {
        return false;
    }
    /** 
     * unlock - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param course
     * @return
     * @throws RemoteException 
     * 
     * @author   FlexiTeam - Val�re
     * @date     27 d�c. 2004
     */
    public boolean unlock(Course course) throws RemoteException {
        return false;
    } 
}
