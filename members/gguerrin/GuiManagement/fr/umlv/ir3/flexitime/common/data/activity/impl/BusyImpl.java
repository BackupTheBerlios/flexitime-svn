/*
 * Created on 6 janv. 2005
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity.impl;

import java.util.*;
import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.tools.*;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;

/**
 * DOCME Description
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public abstract class BusyImpl implements IBusy
{

    // ===========//
    // Champs //
    // ===========//
    private Date   daStart;
    private Date   daEnd;
    protected Long idBusy;
    private static FlexiLanguage language;
    static
    {
        language = FlexiLanguage.getInstance();
    }

    // =============//
    // Constructeurs//
    // =============//
    /**
     * Default constructor for an unavailibility.
     */
    protected BusyImpl()
    {}

    /**
     * Constructs an unavailibility for a device.
     * 
     * @param daStart
     *            the start date of the unavailibility.
     * @param daEnd
     *            the end date of the unavailibility.
     */
    private BusyImpl(Date daStart, Date daEnd)
    {
        this.daStart = daStart;
        this.daEnd = daEnd;
    }

    /**
     * Construct an unavaibility for a device for a specified gap.
     * 
     * @param g
     *            the gap between the start date and the end date of the
     *            unavaibility
     */
    BusyImpl(Gap g)
    {
        this(g.getStartDate().getCal().getTime(), g.getEndDate().getCal()
                .getTime());
    }

    // ===========//
    // M�thodes //
    // ===========//
    /**
     * Returns the start date of the unavailibility.
     * <code>Date date = getStartDate()</code>
     * 
     * @return the start date of the unavailibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#getStartDate()
     */
    public Date getStartDate()
    {
        return daStart;
    }

    /**
     * Sets the start date of the unavailibility.
     * <code>setStartDate(daBusy)</code>
     * 
     * @param daStart
     *            a date.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#setStartDate(java.util.Date)
     * @author FlexiTeam - Adrien BOUVET
     */
    public void setStartDate(Date daStart)
    {
        this.daStart = daStart;
    }

    /**
     * Returns the end date of the unavailibility.
     * <code>Date date = getEndDate()</code>
     * 
     * @return the end date of the unavailibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#getEndDate()
     */
    public Date getEndDate()
    {
        return daEnd;
    }

    /**
     * Sets the end date of the unavailibility. <code>setEndDate(daBusy)</code>
     * 
     * @param daEnd
     *            a date.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#setEndDate(java.util.Date)
     */
    public void setEndDate(Date daEnd)
    {
        this.daEnd = daEnd;
    }

    /**
     * Return a gap between the start date of the busy and the end date
     * 
     * @return the gap of the busy
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#getGap()
     */
    public Gap getGap()
    {
        Calendar calStart = Calendar.getInstance();
        calStart.setTime(this.daStart);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(this.daEnd);

        return new Gap(calStart, calEnd);
    }

    /**
     * Getter for id of the Busy
     * 
     * @return id of the busy
     */
    public Long getIdBusy()
    {
        return idBusy;
    }

    /**
     * Setter of id
     * 
     * @param idBusy
     *            id to set
     * 
     */
    public void setIdBusy(Long idBusy)
    {
        this.idBusy = idBusy;
    }

    /**
     * Compare two Busy.
     * Only the start of the unavaibilities are compared.
     * 
     * @param o
     *            the second busy to compare
     * @return a negative integer, zero, or a positive integer as this object is
     *         less than, equal to, or greater than the specified object.
     * 
     * @throws ClassCastException
     *             if the specified object's type prevents it from being
     *             compared to this Object.
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Object o)
    {
        if (! ( o instanceof IBusy ))
            throw new ClassCastException(language.getText("errBusy01")); //$NON-NLS-1$
    
        IBusy bus = (IBusy)o;
        
        return this.daStart.compareTo(bus.getStartDate());
    }
}
