/*
 * Created on 26 d�c. 2004
 * by Val�re
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import fr.umlv.ir3.flexitime.common.data.Data;
import fr.umlv.ir3.flexitime.common.data.general.Class;
import fr.umlv.ir3.flexitime.common.rmi.IClassManager;


/**
 * ClassManagerImpl - DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - Val�re
 */
public class ClassManagerImpl implements IClassManager{

    /** 
     * getClass - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IClassManager#getClass(java.lang.String)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public Class getClass(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * saveClass - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param _class 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IClassManager#saveClass(fr.umlv.ir3.flexitime.common.data.general.Class)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public void saveClass(Class _class) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * removeClass - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IClassManager#removeClass(java.lang.String)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public Class removeClass(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * lockClass - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param _class
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IClassManager#lockClass(fr.umlv.ir3.flexitime.common.data.general.Class)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public boolean lockClass(Class _class) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * unlockClass - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param _class
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IClassManager#unlockClass(fr.umlv.ir3.flexitime.common.data.general.Class)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public boolean unlockClass(Class _class) {
        // TODO Auto-generated method stub
        return false;
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
