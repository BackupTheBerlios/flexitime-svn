/*
 * Created on 15 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import fr.umlv.ir3.flexitime.common.data.general.Track;
import fr.umlv.ir3.flexitime.common.rmi.ITrackManager;



/**
 * TracksManagerImpl - implements the interface TracksManager
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Valère FOREL
 */
public class TrackManagerImpl implements ITrackManager {

    /** 
     * getTrack - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ITrackManager#getTrack(java.lang.String)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Track getTrack(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * saveTrack - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param track 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ITrackManager#saveTrack(fr.umlv.ir3.flexitime.common.data.general.Track)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public void saveTrack(Track track) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * removeTrack - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ITrackManager#removeTrack(java.lang.String)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Track removeTrack(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * lockTrack - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param track
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ITrackManager#lockTrack(fr.umlv.ir3.flexitime.common.data.general.Track)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean lockTrack(Track track) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * unlockTrack - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param track
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ITrackManager#unlockTrack(fr.umlv.ir3.flexitime.common.data.general.Track)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean unlockTrack(Track track) {
        // TODO Auto-generated method stub
        return false;
    }

}
