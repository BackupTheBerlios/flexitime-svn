/*
 * Created on 23 déc. 2004
 * by Famille
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity;

/**
 * Represents the unavailabilities for a device
 * 
 * @version Révision 72
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IDeviceBusy extends IBusy
{

    /**
     * Comment for <code>REASON_BROCKEN</code>
     */
    public final static int REASON_BROCKEN   = 1;
    /**
     * Comment for <code>REASON_LENDED</code>
     */
    public final static int REASON_LENDED    = 2;
    /**
     * Comment for <code>REASON_IN_REPAIR</code>
     */
    public final static int REASON_IN_REPAIR = 3;

    /**
     * Changes the Reason of the unavailabilities.
     * 
     * @param iReason the Reason of the unavailabilities.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setReason(int iReason);

}
