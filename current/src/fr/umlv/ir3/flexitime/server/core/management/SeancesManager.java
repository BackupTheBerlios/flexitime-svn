/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management;

import java.util.*;

import fr.umlv.ir3.flexitime.common.data.activity.*;
import fr.umlv.ir3.flexitime.common.data.ressources.*;
import fr.umlv.ir3.flexitime.common.tools.*;


/**
 * SeancesManager - Manages the seances in a list
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public interface SeancesManager {
    /** 
     * getSeance - get a seance with its name
     * 
     *     <code>Seance c = mySeancesManager.getSeance(date,time,"name of group")</code>
     * 
     * @param debut the date of the seance
     * @param heure the time of the seance
     * @param group the groupe which the seance depends
     * @return a Seance
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    Seance getSeance(Date debut, Time heure, Groups group);
    /** 
     * addSeance - adds a seance in the list
     * 
     *     <code>mySeancesManager.addSeance(mySeance)</code>
     * 
     * @param seance a Seance to add
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    void addSeance(Seance seance);
    /** 
     * removeSeance - remove a seance in the list
     * 
     *     <code>Seance s = mySeancesManager.removeSeance(date,time,"group")</code>
     * 
     * @param debut the date of the seance
     * @param heure the time of the seance
     * @param group the group which the seance depends
     * @return a Seance
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    Seance removeSeance(Date debut, Time heure, Groups group);

}
