/*
 * Created on 15 janv. 2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.SubjectsGroupImpl;
import junit.framework.TestCase;

/**
 * Les notify des méthodes save() update() et delete() ne sont pas testées.
 * 
 * @author BOUVET Adrien
 */
public class TestSubjectsGroupManager extends TestCase
{
	SubjectsGroupManager subjectsGroupManager = new SubjectsGroupManager();
	ISubjectsGroup subjectsGroup = new SubjectsGroupImpl("test");


	public void testSaveAndGet() throws RemoteException
	{
		subjectsGroupManager.save(subjectsGroup);
	
		ArrayList list = new ArrayList(subjectsGroupManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ISubjectsGroup) break;
		}
		if( (SubjectsGroupImpl)iter != subjectsGroup ) fail("objet sauvegardé différent de celui récupéré; save or get fails"); 
	}


	public void testDelete() throws RemoteException
	{
		subjectsGroupManager.delete(subjectsGroup);
	
		ArrayList list = new ArrayList(subjectsGroupManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ISubjectsGroup) break;
		}
		if( (SubjectsGroupImpl)iter == subjectsGroup ) fail("objet toujours présent dans la liste; delete fails"); 
	}

	
	public void testUpdate() throws RemoteException
	{
		subjectsGroupManager.save(subjectsGroup);
		subjectsGroup.setName("test2");
		subjectsGroupManager.update(subjectsGroup);
	
		ArrayList list = new ArrayList(subjectsGroupManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ISubjectsGroup) break;
		}
		if( ((SubjectsGroupImpl)iter).getName() != subjectsGroup.getName() ) fail("Nom des objets différents; update fails");
	}
	
}
