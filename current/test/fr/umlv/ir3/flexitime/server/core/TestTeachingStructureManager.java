/*
 * Created on 15 janv. 2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.TeachingStructureImpl;
import junit.framework.TestCase;

/**
 * Les notify des méthodes save() update() et delete() ne sont pas testées.
 * 
 * @author BOUVET Adrien
 */
public class TestTeachingStructureManager extends TestCase
{
	TeachingStructureManager structManager = new TeachingStructureManager();
	ITeachingStructure struct = new TeachingStructureImpl("test");


	public void testSaveAndGet() throws RemoteException
	{
		structManager.save(struct);
	
		ArrayList list = new ArrayList(structManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ITeachingStructure) break;
		}
		if( (TeachingStructureImpl)iter != struct ) fail("objet sauvegardé différent de celui récupéré; save or get fails"); 
	}


	public void testDelete() throws RemoteException
	{
		structManager.delete(struct);
	
		ArrayList list = new ArrayList(structManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ITeachingStructure) break;
		}
		if( (TeachingStructureImpl)iter == struct ) fail("objet toujours présent dans la liste; delete fails"); 
	}

	
	public void testUpdate() throws RemoteException
	{
		structManager.save(struct);
		struct.setName("test2");
		structManager.update(struct);
	
		ArrayList list = new ArrayList(structManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ITeachingStructure) break;
		}
		if( ((TeachingStructureImpl)iter).getName() != struct.getName() ) fail("Nom des objets différents; update fails");
	}
	
}
