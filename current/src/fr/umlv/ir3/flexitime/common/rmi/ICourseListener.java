/*
 * Created on 23 déc. 2004
 * by Famille
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.rmi;

import fr.umlv.ir3.flexitime.common.event.DataEvent;

/**
 * ICourseListener - Interface which gets the event on the course
 * 
 * @version Verion ou révision SVN
 * @author FlexiTeam - Famille
 */
public interface ICourseListener
{

    /**
     * courseChanged - DOCME Description Quel service est rendu par cette
     * méthode <code>exemple d'appel de la methode</code>
     * 
     * @param event
     * @author FlexiTeam - Valère
     * @date 27 déc. 2004
     */
    public void courseChanged(DataEvent event);
}