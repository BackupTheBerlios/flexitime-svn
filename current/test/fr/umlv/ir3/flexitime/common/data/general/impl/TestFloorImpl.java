/*
 * Created on 26 janv. 2005
 * by Jérôme GUERS
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.general.impl;

import fr.umlv.ir3.flexitime.common.data.general.*;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.data.resources.impl.*;

import junit.framework.TestCase;


/**
 * Test ClassImpl 
 * 
 * @version 285
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestFloorImpl extends TestCase {

    IBuilding building = new BuildingImpl("Copernic");
    IFloor floor = new FloorImpl("first", building);
    
    /**
     * 
     *
     */
    public void testLstRoom()
    {
        IRoom room1 = new RoomImpl("2003");
        room1.setIdData(new Long(1));
        IRoom room2 = new RoomImpl("2027");
        room2.setIdData(new Long(1));
        
        floor.addRoom(room1);
        floor.addRoom(room2);

        if(! (((IRoom)(floor.getLstRoom().get(0))).getName().equals("2003")))
            fail("erreur Lecture des salles");
        
        if(!(floor.removeRoom(room1)))
            fail("problème de suppression");
        if(! (((IRoom)(floor.getLstRoom().get(0))).getName().equals("2027")))
            fail("erreur suppression de salles");
    }
}
