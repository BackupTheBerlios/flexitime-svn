/*
 * Created on 15 janv. 2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.data.resources.impl.RoomImpl;
import junit.framework.TestCase;

/**
 * Les notify des m�thodes save() update() et delete() ne sont pas test�es.
 * 
 * @author BOUVET Adrien
 */
public class TestRoomManager extends TestCase
{
	RoomManager roomManager = new RoomManager();
	IRoom room = new RoomImpl("test");


	public void testSaveAndGet() throws RemoteException
	{
		roomManager.save(room);
	
		ArrayList list = new ArrayList(roomManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IRoom) break;
		}
		if( (RoomImpl)iter != room ) fail("objet sauvegard� diff�rent de celui r�cup�r�; save or get fails"); 
	}


	public void testDelete() throws RemoteException
	{
		roomManager.delete(room);
	
		ArrayList list = new ArrayList(roomManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IRoom) break;
		}
		if( (RoomImpl)iter == room ) fail("objet toujours pr�sent dans la liste; delete fails"); 
	}

	
	public void testUpdate() throws RemoteException
	{
		roomManager.save(room);
		room.setName("test2");
		roomManager.update(room);
	
		ArrayList list = new ArrayList(roomManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IRoom) break;
		}
		if( ((RoomImpl)iter).getName() != room.getName() ) fail("Nom des objets diff�rents; update fails");
	}
	
}
