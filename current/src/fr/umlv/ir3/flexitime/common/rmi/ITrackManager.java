/*
 * Created on 23 d�c. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;

import fr.umlv.ir3.flexitime.common.data.general.Track;


/**
 * ITrackManager - DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface ITrackManager extends Remote {
    /** 
     * getTrack - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 d�c. 2004
     */
    Track getTrack(String name);
    /** 
     * addTrack - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param track 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 d�c. 2004
     */
    void saveTrack(Track track);
    /** 
     * removeTrack - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 d�c. 2004
     */
    Track removeTrack(String name);
    /** 
     * lockTrack - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param track
     * @return 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    boolean lockTrack(Track track);
    /** 
     * unlockTrack - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param track
     * @return 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    boolean unlockTrack(Track track);
   
}
