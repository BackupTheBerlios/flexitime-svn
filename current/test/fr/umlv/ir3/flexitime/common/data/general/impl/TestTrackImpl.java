/*
 * Created on 26 janv. 2005
 * by Jérôme GUERS
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.general.impl;

import fr.umlv.ir3.flexitime.common.data.general.*;


import junit.framework.TestCase;

/**
 * Test ClassImpl
 * 
 * @version 285
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestTrackImpl extends TestCase
{
    ITrack track = new TrackImpl("IR");

    /**
     * 
     * 
     */
    public void testLstClass()
    {
        IClass class1 = new ClassImpl("ir1", track);
        track.addClass(class1);
        track.addClass(new ClassImpl("ir2", track));

        if (! ( ( (IClass) ( track.getLstClass().get(0) ) ).getName()
                .equals("ir1") )) fail("erreur Lecture des promos");

        track.removeClass(class1);
        if (! ( ( (IClass) ( track.getLstClass().get(0) ) ).getName()
                .equals("ir2") )) fail("erreur suppression des promos");    }
}
