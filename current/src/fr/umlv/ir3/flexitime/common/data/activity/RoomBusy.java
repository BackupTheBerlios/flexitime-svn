/*
 * Created on 23 déc. 2004
 * by Famille
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity;

import fr.umlv.ir3.flexitime.common.data.ressources.Room;

/**
 * Represents the unavailabilities for a Room
 * 
 * @version Révision 72
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface RoomBusy extends Busy
{

    public final static int REASON_IN_WORK = 1;
    public final static int REASON_LENDED  = 2;
    public final static int REASON_CLOSED  = 3;

    /**
     * Changes the Reason of the unavailabilities.
     * 
     * @param iReason the Reason of the unavailabilities.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setReason(int iReason);

}
