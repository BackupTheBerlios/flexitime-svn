/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.resources;

/**
 * Represents a device as a videoprojector
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IDevice extends IResource
{
    // Definition des types
    /**
     * Comment for <code>VIDEOPROJECTOR</code>
     */
    public final static int   VIDEOPROJECTOR      = 1;
    /**
     * Comment for <code>TV</code>
     */
    public final static int   TV                  = 2;
    /**
     * Comment for <code>VIDEO_TAPE_RECORDER</code>
     */
    public final static int   VIDEO_TAPE_RECORDER = 3;

    /**
     * Returns the type of the device.
     * 
     * @return the type of the device.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    int getType();

    /**
     * Changes the type of the device.
     * 
     * @param type the new type.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setType(int type);

}
