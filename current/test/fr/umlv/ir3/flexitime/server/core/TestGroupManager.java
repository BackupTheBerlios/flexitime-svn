/*
 * Created on 15 janv. 2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.impl.GroupImpl;
import junit.framework.TestCase;

/**
 * Les notify des m�thodes save() delete() et update() n'ont pas �t� test�es.
 * 
 * @author BOUVET Adrien
 */
public class TestGroupManager extends TestCase
{
	GroupManager groupManager = new GroupManager();
	IGroup group = new GroupImpl("test");


	public void testSaveAndGet() throws RemoteException
	{
		groupManager.save(group);
	
		ArrayList list = new ArrayList(groupManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IGroup) break;
		}
		if( (GroupImpl)iter != group ) fail("objet sauvegard� diff�rent de celui r�cup�r�; save or get fails"); 
	}


	public void testDelete() throws RemoteException
	{
		groupManager.delete(group);
	
		ArrayList list = new ArrayList(groupManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IGroup) break;
		}
		if( (GroupImpl)iter == group ) fail("objet toujours pr�sent dans la liste; delete fails"); 
	}

	
	public void testUpdate() throws RemoteException
	{
		groupManager.save(group);
		group.setName("test2");
		groupManager.update(group);
	
		ArrayList list = new ArrayList(groupManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IGroup) break;
		}
		if( ((GroupImpl)iter).getName() != group.getName() ) fail("Nom des objets diff�rents; update fails");
	}
	
}
