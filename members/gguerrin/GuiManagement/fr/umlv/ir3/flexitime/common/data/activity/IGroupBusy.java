/*
 * Created on 23 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity;

/**
 * Represents the unavailabilities for a group
 * 
 * @version Révision 0.2
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IGroupBusy extends IBusy
{

    /**
     * Comment for <code>REASON_HOLLYDAYS</code>
     */
    public final static int REASON_HOLLYDAYS = 1;
    /**
     * Comment for <code>REASON_WORK</code>
     */
    public final static int REASON_WORK      = 2;

    /**
     * Changes the reason of the unavailability.
     * 
     * @param iReason the Reason of the unavailability.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setReason(int iReason);
    
    /**
     * Returns the reason of the unavailability.
     * 
     * @return the Reason of the unavailability.
     * @author FlexiTeam - Adrien BOUVET
     */
    int getReason();
}
