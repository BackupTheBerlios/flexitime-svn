/*
 * Created on 23 d�c. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;

import fr.umlv.ir3.flexitime.common.data.ressources.Group;


/**
 * IGroupManager - DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IGroupManager extends Remote {
    /** 
     * getGroup - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    Group getGroup(String name);
    /** 
     * saveGroup - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param group 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    void saveGroup(Group group);
    /** 
     * removeGroup - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    Group removeGroup(String name);
    /** 
     * lockGroup - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param group
     * @return 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    boolean lockGroup(Group group);
    /** 
     * unlockGroup - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param group
     * @return 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    boolean unlockGroup(Group group);

}
