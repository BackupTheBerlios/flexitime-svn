/*
 * Created on 26 déc. 2004
 * by Valère
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import fr.umlv.ir3.flexitime.common.data.ressources.Group;
import fr.umlv.ir3.flexitime.common.rmi.IGroupManager;


/**
 * GroupManagerImpl - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Valère
 */
public class GroupManagerImpl implements IGroupManager{

    /** 
     * getGroup - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IGroupManager#getGroup(java.lang.String)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Group getGroup(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * saveGroup - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param group 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IGroupManager#saveGroup(fr.umlv.ir3.flexitime.common.data.ressources.Group)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public void saveGroup(Group group) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * removeGroup - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IGroupManager#removeGroup(java.lang.String)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Group removeGroup(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * lockGroup - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param group
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IGroupManager#lockGroup(fr.umlv.ir3.flexitime.common.data.ressources.Group)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean lockGroup(Group group) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * unlockGroup - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param group
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IGroupManager#unlockGroup(fr.umlv.ir3.flexitime.common.data.ressources.Group)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean unlockGroup(Group group) {
        // TODO Auto-generated method stub
        return false;
    }

}
