/*
 * Created on 13 d�c. 2004
 * by Val�re FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;

import fr.umlv.ir3.flexitime.server.core.management.event.*;



/**
 * EventManager - DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Val�re FOREL
 */
public interface IEventManager extends Remote,AbstractManager{
    /** 
     * addListener - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param itemClass
     * @param property
     * @param eventType
     * @param listener 
     * 
     * @author   FlexiTeam - Val�re FOREL
     * @date     13 d�c. 2004
     */
    public abstract void addListener(Class itemClass,String property,int eventType,PropertyListener listener);
    /** 
     * removeListener - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param itemClass
     * @param property
     * @param listener 
     * 
     * @author   FlexiTeam - Val�re FOREL
     * @date     13 d�c. 2004
     */
    public abstract void removeListener(Class itemClass,String property,PropertyListener listener);


}
