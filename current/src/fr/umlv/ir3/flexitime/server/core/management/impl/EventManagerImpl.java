/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import fr.umlv.ir3.flexitime.server.core.management.*;
import fr.umlv.ir3.flexitime.server.core.management.event.*;


/**
 * EventManagerImpl - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public class EventManagerImpl implements EventManager {

    /** 
     * addListener - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param itemClass
     * @param property
     * @param eventType
     * @param listener 
     * 
     * @see fr.umlv.ir3.flexitime.server.core.management.EventManager#addListener(java.lang.Class, java.lang.String, int, fr.umlv.ir3.flexitime.server.core.management.event.PropertyListener)
     * @author   FlexiTeam - Administrateur
     * @date     13 déc. 2004
     */
    public void addListener(Class itemClass, String property, int eventType, PropertyListener listener) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * removeListener - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param itemClass
     * @param property
     * @param listener 
     * 
     * @see fr.umlv.ir3.flexitime.server.core.management.EventManager#removeListener(java.lang.Class, java.lang.String, fr.umlv.ir3.flexitime.server.core.management.event.PropertyListener)
     * @author   FlexiTeam - Administrateur
     * @date     13 déc. 2004
     */
    public void removeListener(Class itemClass, String property, PropertyListener listener) {
        // TODO Auto-generated method stub
        
    }

}
