/*
 * Created on 23 janv. 2005
 * by Jérôme GUERS
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.activity.impl;

import java.util.*;

import fr.umlv.ir3.flexitime.common.data.activity.*;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.impl.GroupImpl;
import fr.umlv.ir3.flexitime.server.MetierSimulator;
import junit.framework.TestCase;


/**
 * DOCME 
 * 
 * @version 245
 * @see fr.umlv.ir3.flexitime.common.data.activity.impl.BusyImpl#compareTo(Object)
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestCompareBusies extends TestCase
{
    public void testCompare()
    {
        IGroup group = MetierSimulator.getGroup2IR3();
        
        Set<IBusy> set = group.getSetBusy();
        for (Iterator iter = set.iterator() ; iter.hasNext() ;)
        {
            IBusy element = (IBusy) iter.next();
            if(iter.hasNext())
            {
                if(element.getStartDate().compareTo(((IBusy)iter.next()).getStartDate()) > 0)
                    fail("Mauvais tri: " + element.getStartDate() + " > " + ((IBusy)iter.next()).getStartDate());
            }
        }
    }
}

