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
 * Les notify des m�thodes save() delete() et update() n'ont pas �t� test�es.
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
		if( (FloorImpl)iter != floor ) fail("objet sauvegard� diff�rent de celui r�cup�r�; save or get fails"); 
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
		if( (FloorImpl)iter == floor ) fail("objet toujours pr�sent dans la liste; delete fails"); 
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
		if( ((FloorImpl)iter).getName() != floor.getName() ) fail("Nom des objets diff�rents; update fails");
	}
	
}
