/*
 * Created on 15 janv. 2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.general.impl.TrackImpl;
import junit.framework.TestCase;

/**
 * Les notify des m�thodes save() update() et delete() ne sont pas test�es.
 * 
 * @author BOUVET Adrien
 */
public class TestTrackManager extends TestCase
{
	TrackManager trackManager = new TrackManager();
	ITrack track = new TrackImpl("test");


	public void testSaveAndGet() throws RemoteException
	{
		trackManager.save(track);
	
		ArrayList list = new ArrayList(trackManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ITrack) break;
		}
		if( (TrackImpl)iter != track ) fail("objet sauvegard� diff�rent de celui r�cup�r�; save or get fails"); 
	}


	public void testDelete() throws RemoteException
	{
		trackManager.delete(track);
	
		ArrayList list = new ArrayList(trackManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ITrack) break;
		}
		if( (TrackImpl)iter == track ) fail("objet toujours pr�sent dans la liste; delete fails"); 
	}

	
	public void testUpdate() throws RemoteException
	{
		trackManager.save(track);
		track.setName("test2");
		trackManager.update(track);
	
		ArrayList list = new ArrayList(trackManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ITrack) break;
		}
		if( ((TrackImpl)iter).getName() != track.getName() ) fail("Nom des objets diff�rents; update fails");
	}
	
}
