/*
 * Created on 13 d�c. 2004
 * by Val�re FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.rmi.admin;

import fr.umlv.ir3.flexitime.common.event.DataEvent;

/**
 * Configuration - Sets the configuration of the program
 * 
 * @version 0.1
 * @author FlexiTeam - Val�re FOREL
 */
public interface IConfigurationListener
{

    /**
     * configurationChanged - DOCME Description Quel service est rendu par cette
     * m�thode <code>exemple d'appel de la methode</code>
     * 
     * @param event
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public void configurationChanged(DataEvent event);
}