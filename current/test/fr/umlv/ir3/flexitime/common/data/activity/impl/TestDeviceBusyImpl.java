/*
 * Created on 5 janv. 2005
 * by Famille
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.activity.impl;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Version ou révision SVN
 * @see (si nécessaire)
 * 
 * @author FlexiTeam - Famille
 */
public class TestDeviceBusyImpl extends TestCase
{
    int iReason = 1;
    String strName = "toto";
    Date daStart = Calendar.getInstance().getTime();
    Date daEnd = Calendar.getInstance().getTime();
    DeviceBusyImpl deviceBusy = new DeviceBusyImpl(iReason,strName,daStart,daEnd);

    public void testGetReason()
    {
        if(deviceBusy.getReason() != 1)fail("Erreur raison");
    }
    public void testGetName()
    {
        if(deviceBusy.getName().compareTo("toto") != 0 )fail("Erreur raison");
    }
    public void testGetStartDate()
    {
        if(deviceBusy.getStartDate().compareTo(daStart) != 0)fail("Erreur raison");
    }
    public void testGetEndDate()
    {
        if(deviceBusy.getEndDate().compareTo(daEnd)!=0)fail("Erreur raison");
    }
}

