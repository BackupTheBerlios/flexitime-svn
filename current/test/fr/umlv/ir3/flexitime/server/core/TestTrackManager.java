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
 * Les notify des méthodes save() update() et delete() ne sont pas testées.
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
		if( (TrackImpl)iter != track ) fail("objet sauvegardé différent de celui récupéré; save or get fails"); 
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
		if( (TrackImpl)iter == track ) fail("objet toujours présent dans la liste; delete fails"); 
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
		if( ((TrackImpl)iter).getName() != track.getName() ) fail("Nom des objets différents; update fails");
	}
	
}
