/*
 * Created on 14 janv. 2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.impl.BuildingImpl;
import junit.framework.TestCase;

/**
 * Les notify des m�thodes save() delete() et update() ne sont pas test�s. 
 * 
 * @author BOUVET Adrien
 */
public class TestBuildingManager extends TestCase
{
	
	BuildingManager buildingManager = new BuildingManager();
	IBuilding building = new BuildingImpl("test");
	
	
	public void testSaveAndGet() throws RemoteException
	{
		buildingManager.save(building);
		
		ArrayList list = new ArrayList(buildingManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IBuilding) break;
		}
		if( (BuildingImpl)iter != building ) fail("objet sauvegard� diff�rent de celui r�cup�r�; save or get fails"); 
	}
	
	
	public void testDelete() throws RemoteException
	{
		buildingManager.delete(building);
		
		ArrayList list = new ArrayList(buildingManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IBuilding) break;
		}
		if( (BuildingImpl)iter == building ) fail("objet toujours pr�sent dans la liste; delete fails"); 
	}
	
		
	public void testUpdate() throws RemoteException
	{
		buildingManager.save(building);
		building.setName("test2");
		buildingManager.update(building);
		
		ArrayList list = new ArrayList(buildingManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IBuilding) break;
		}
		if( ((BuildingImpl)iter).getName() != building.getName() ) fail("Nom des objets diff�rents; update fails");
	}
}
