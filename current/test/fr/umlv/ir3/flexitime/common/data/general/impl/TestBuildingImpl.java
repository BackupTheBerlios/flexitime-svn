/*
 * Created on 5 janv. 2005
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.general.impl;

import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.general.IFloor;

import junit.framework.TestCase;


/**
 * Test BuildingImpl
 * 
 * @version 285
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public class TestBuildingImpl extends TestCase {

    String strName = "toto";
    List<IFloor> lstFloor  = new ArrayList<IFloor>();
    BuildingImpl building = new BuildingImpl(strName,lstFloor);

    /**
     * 
     *
     */
    public void testGetNbFloor()
    {
        FloorImpl floor1 = new FloorImpl("titi", building);
        floor1.setIdData(new Long(1));
        building.addFloor(floor1);
        building.addFloor( new FloorImpl("tutu", building));
        
        if(building.getNbFloor() != 2)
            fail("Erreur NbFloor");
       
        building.removeFloor(floor1);
        if(building.getNbFloor() != 1)
            fail("Erreur NbFloor");
        
        
    }
    
    /**
     * 
     *
     */
    public void testLstFloor()
    {
        FloorImpl floor1 = new FloorImpl("titi", building);
        floor1.setIdData(new Long(1));
        building.addFloor(floor1);
        building.addFloor( new FloorImpl("tutu", building));
        
        if( ((FloorImpl)(building.getLstFloor().get(0))).getName().compareTo("titi") != 0 )
            fail("erreur Lecture des Floor");
        
        building.removeFloor(floor1);
        if( ((FloorImpl)(building.getLstFloor().get(0))).getName().compareTo("tutu") != 0 )
            fail("erreur Lecture des Floor 2 ");
        
    }
}
