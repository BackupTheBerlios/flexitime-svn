/*
 * Created on 16 janv. 2005
 * by Jérôme GUERS
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.io.storage;

import java.rmi.RemoteException;
import java.util.*;

import net.sf.hibernate.HibernateException;
import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.resources.impl.TeacherImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import junit.framework.TestCase;


/**
 * DOCME
 * 
 * @version 320
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestBuildingStorage extends TestCase
{
    /**
     * DOCME
     */
    public void testStorage()
    {
        IBuilding building = null;
    
        List allBuilding = null;
        try
        {
            building = DataFactory.createBuilding("BuildingDeValre");
            allBuilding = RemoteDataManager.getManager().getBuildings();
        }catch (Exception e1){
            fail("BuildingStorage:testStorage()");
        }
        boolean find =  false;
        
        for (Iterator iter = allBuilding.iterator() ; iter.hasNext() ;)
        {
            IBuilding element = (IBuilding) iter.next();
            if(element.equals(building))
            {
                System.out.println(element.getName());
                find = true;
            }
        }
        if(find == false)
        {
          fail("Unable to save or to load !!");  
        } 
    }
}

