/*
 * Created on 12 d�c. 2004
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
	/**
     * Comment for <code>VIDEOPROJECTOR</code>
     */
    public final static int   Vid�oProjecteur     = 0;
    /**
     * Comment for <code>TV</code>
     */
    public final static int   TV                  = 1;
    /**
     * Comment for <code>VIDEO_TAPE_RECORDER</code>
     */
    public final static int   Magn�toscope = 2;
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
