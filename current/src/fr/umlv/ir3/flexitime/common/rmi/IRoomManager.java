/*
 * Created on 23 d�c. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;

import fr.umlv.ir3.flexitime.common.data.ressources.Room;


/**
 * IRoomManager - DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IRoomManager extends Remote {
    /** 
     * getRoom - DOCME Description
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
    Room getRoom(String name);
    /** 
     * saveRoom - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param room 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    void saveRoom(Room room);
    /** 
     * removeRoom - DOCME Description
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
    Room removeRoom(String name);
    /** 
     * lockRoom - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param room
     * @return 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    boolean lockRoom(Room room);
    /** 
     * unlockRoom - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param room
     * @return 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    boolean unlockRoom(Room room);
}
