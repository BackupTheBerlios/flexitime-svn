/*
 * Created on 23 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data;

/**
 * Represents a data
 * 
 * @version Révision 72
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Data
{

    /**
     * Returns the name of a data.
     * 
     * @return the name of the data.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    String getName();

    /**
     * Changes the name of the data.
     * 
     * @param name the new name.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setName(String name);

}
