/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.resources;

import java.util.Set;

import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.data.activity.IBusy;

/**
 * This interface represents a resource
 * 
 * @version 240
 * @author FlexiTeam - Jérôme GUERS
 */
public interface IResource extends IData
{

    /**
     * Returns the list of unavailabilities of the resouce.
     * 
     * @return the list of unavailabilities of the resource.
     */
    Set<IBusy> getSetBusy();

    /**
     * Changes the list of unavailabilities of the resouce.
     * 
     * @param setBusy the new unavailabilities.
     */
    void setSetBusy(Set<IBusy> setBusy);

    /**
     * Add a unavailabilities in a Resource .
     * 
     * @param busy the new unavailabilitie
     */
    void addBusy(IBusy busy);

    /**
     * Remove a unavailabilities of a Resource.
     * 
     * @param busy the new unavailabilitie
     */
    void removeBusy(IBusy busy);
}
