/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.ressources;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.Data;
import fr.umlv.ir3.flexitime.common.data.activity.Busy;

/**
 * This interface represents a resource
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Resource extends Data
{

    /**
     * Returns the list of unavailabilities of the resouce.
     * 
     * @return the list of unavailabilities of the resource.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    List getLstBusy();

    /**
     * Changes the list of unavailabilities of the resouce.
     * 
     * @param lstBusy the new unavailabilities.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setLstBusy(List lstBusy);

    /**
     * Add a unavailabilities in a Resource .
     * 
     * @param busy the new unavailabilitie
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void addBusy(Busy busy);

    /**
     * Remove a unavailabilities of a Resource.
     * 
     * @param busy the new unavailabilitie
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void removeBusy(Busy busy);

}
