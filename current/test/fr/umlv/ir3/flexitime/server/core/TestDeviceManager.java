/*
 * Created on 15 janv. 2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.impl.DeviceImpl;
import junit.framework.TestCase;

/**
 * Les notify des méthodes save() delete() et update() n'ont pas été testées.
 * 
 * @author BOUVET Adrien
 */
public class TestDeviceManager extends TestCase
{
	DeviceManager deviceManager = new DeviceManager();
	IDevice device = new DeviceImpl("test");


	public void testSaveAndGet() throws RemoteException
	{
		deviceManager.save(device);
	
		ArrayList list = new ArrayList(deviceManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IDevice) break;
		}
		if( (DeviceImpl)iter != device ) fail("objet sauvegardé différent de celui récupéré; save or get fails"); 
	}


	public void testDelete() throws RemoteException
	{
		deviceManager.delete(device);
	
		ArrayList list = new ArrayList(deviceManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IDevice) break;
		}
		if( (DeviceImpl)iter == device ) fail("objet toujours présent dans la liste; delete fails"); 
	}

	
	public void testUpdate() throws RemoteException
	{
		deviceManager.save(device);
		device.setName("test2");
		deviceManager.update(device);
	
		ArrayList list = new ArrayList(deviceManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IDevice) break;
		}
		if( ((DeviceImpl)iter).getName() != device.getName() ) fail("Nom des objets différents; update fails");
	}
	
}
