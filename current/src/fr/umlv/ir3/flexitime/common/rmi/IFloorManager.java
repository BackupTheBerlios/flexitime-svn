/*
 * Created on 23 d�c. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;
import fr.umlv.ir3.flexitime.common.data.general.Floor;



/**
 * IFloorManager - DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IFloorManager extends Remote,AbstractManager {
    /** 
     * getFloor - DOCME Description
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
    Floor getFloor(String name);
    /** 
     * saveFloor - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param floor 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    void saveFloor(Floor floor);
    /** 
     * removeFloor - DOCME Description
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
    Floor removeFloor(String name);
    /** 
     * lockFloor - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param floor
     * @return 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    boolean lockFloor(Floor floor);
    /** 
     * unlockFloor - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param floor
     * @return 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    boolean unlockFloor(Floor floor);
}
