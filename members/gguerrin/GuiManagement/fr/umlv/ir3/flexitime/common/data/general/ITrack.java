/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.general;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.IData;

/**
 * Regroupe differents classes
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface ITrack extends IData
{

    /**
     * Returns the list of class.
     * 
     * @return the list of class.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    List<IClass> getLstClass();

    /**
     * Changes the list of class .
     * 
     * @param lstClass the new list of Class
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setLstClass(List<IClass> lstClass);

    /**
     * Add a class in a track
     * 
     * @param pClass the Class added.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void addClass(IClass pClass);

    /**
     * Remove a class in a track
     * 
     * @param pClass the Class removed.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void removeClass(IClass pClass);
}
