/*
 * Created on 26 d�c. 2004
 * by Val�re
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import fr.umlv.ir3.flexitime.common.data.ressources.Room;
import fr.umlv.ir3.flexitime.common.rmi.IRoomManager;


/**
 * RoomManagerImpl - DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - Val�re
 */
public class RoomManagerImpl implements IRoomManager{

    /** 
     * getRoom - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IRoomManager#getRoom(java.lang.String)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public Room getRoom(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * saveRoom - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param room 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IRoomManager#saveRoom(fr.umlv.ir3.flexitime.common.data.ressources.Room)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public void saveRoom(Room room) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * removeRoom - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IRoomManager#removeRoom(java.lang.String)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public Room removeRoom(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * lockRoom - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param room
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IRoomManager#lockRoom(fr.umlv.ir3.flexitime.common.data.ressources.Room)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public boolean lockRoom(Room room) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * unlockRoom - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param room
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IRoomManager#unlockRoom(fr.umlv.ir3.flexitime.common.data.ressources.Room)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public boolean unlockRoom(Room room) {
        // TODO Auto-generated method stub
        return false;
    }

}
