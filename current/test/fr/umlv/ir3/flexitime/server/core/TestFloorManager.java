/*
 * Created on 15 janv. 2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.general.impl.FloorImpl;
import junit.framework.TestCase;

/**
 * Les notify des méthodes save() delete() et update() n'ont pas été testées.
 * 
 * @author BOUVET Adrien
 */
public class TestFloorManager extends TestCase
{
	FloorManager floorManager = new FloorManager();
	IFloor floor = new FloorImpl("test");


	public void testSaveAndGet() throws RemoteException
	{
		floorManager.save(floor);
	
		ArrayList list = new ArrayList(floorManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IFloor) break;
		}
		if( (FloorImpl)iter != floor ) fail("objet sauvegardé différent de celui récupéré; save or get fails"); 
	}


	public void testDelete() throws RemoteException
	{
		floorManager.delete(floor);
	
		ArrayList list = new ArrayList(floorManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IFloor) break;
		}
		if( (FloorImpl)iter == floor ) fail("objet toujours présent dans la liste; delete fails"); 
	}

	
	public void testUpdate() throws RemoteException
	{
		floorManager.save(floor);
		floor.setName("test2");
		floorManager.update(floor);
	
		ArrayList list = new ArrayList(floorManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IFloor) break;
		}
		if( ((FloorImpl)iter).getName() != floor.getName() ) fail("Nom des objets différents; update fails");
	}
	
}
