/*
 * Created on 13 d�c. 2004
 * by Val�re FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import fr.umlv.ir3.flexitime.common.data.Data;
import fr.umlv.ir3.flexitime.common.rmi.IEventManager;
import fr.umlv.ir3.flexitime.server.core.management.event.PropertyListener;





/**
 * EventManagerImpl - Implements the interface EventManager
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Val�re FOREL
 */
public class EventManagerImpl implements IEventManager {

    /** 
     * addListener - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param itemClass
     * @param property
     * @param eventType
     * @param listener 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IEventManager#addListener(java.lang.Class, java.lang.String, int, fr.umlv.ir3.flexitime.server.core.management.event.PropertyListener)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public void addListener(Class itemClass, String property, int eventType, PropertyListener listener) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * removeListener - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param itemClass
     * @param property
     * @param listener 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IEventManager#removeListener(java.lang.Class, java.lang.String, fr.umlv.ir3.flexitime.server.core.management.event.PropertyListener)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public void removeListener(Class itemClass, String property, PropertyListener listener) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * getData - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#getData()
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public Data getData() {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * saveData - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#saveData(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public void saveData(Data data) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * removeData - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#removeData(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public void removeData(Data data) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * lock - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#lock(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public boolean lock(Data data) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * unlock - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#unlock(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public boolean unlock(Data data) {
        // TODO Auto-generated method stub
        return false;
    }

}
