/*
 * Created on 23 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity;

/**
 * Represents the unavailability for a teacher.
 * 
 * @version 0.2
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface ITeacherBusy extends IBusy
{

    /**
     * Comment for <code>REASON_WORK</code>
     */
    public final static int REASON_WORK      = 1;
    /**
     * Comment for <code>REASON_HOLLYDAYS</code>
     */
    public final static int REASON_HOLLYDAYS = 2;
    /**
     * Comment for <code>REASON_SICK</code>
     */
    public final static int REASON_SICK      = 3;
    /**
     * Comment for <code>REASON_STAGE</code>
     */
    public final static int REASON_STAGE     = 4;
    /**
     * Comment for <code>REASON_PERSO</code>
     */
    public final static int REASON_PERSO     = 5;

    /**
     * Changes the Reason of the unavailability.
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
