/*
 * Created on 5 janv. 2005
 * by Famille
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.general.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.ressources.impl.*;
import junit.framework.TestCase;


/**
 * TestBuildingImpl - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * 
 * @author FlexiTeam - Famille
 */
public class TestBuildingImpl extends TestCase {

    String strName = "toto";
    List lstFloor  = new ArrayList();
    BuildingImpl building = new BuildingImpl(strName,lstFloor);

    public void testGetNbFloor()
    {
        FloorImpl floor1 = new FloorImpl("titi",new ArrayList());
        building.addFloor(floor1);
        building.addFloor( new FloorImpl("tutu",new ArrayList()));
        
        if(building.getNbFloor() != 2)
            fail("Erreur NbFloor");
       
        building.removeFloor(floor1);
        if(building.getNbFloor() != 1)
            fail("Erreur NbFloor");
        
        
    }
    
    public void testLstFloor()
    {
        FloorImpl floor1 = new FloorImpl("titi",new ArrayList());
        building.addFloor(floor1);
        building.addFloor( new FloorImpl("tutu",new ArrayList()));
        
        if( ((FloorImpl)(building.getLstFloor().get(0))).getName().compareTo("titi") != 0 )
            fail("erreur Lecture des Floor");
        
        building.removeFloor(floor1);
        if( ((FloorImpl)(building.getLstFloor().get(0))).getName().compareTo("tutu") != 0 )
            fail("erreur Lecture des Floor 2 ");
        
    }
    
}
