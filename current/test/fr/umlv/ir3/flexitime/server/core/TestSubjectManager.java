/*
 * Created on 15 janv. 2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.SubjectImpl;
import junit.framework.TestCase;

/**
 * Les notify des méthodes update() delete() et save() ne sont pas testées.
 * 
 * @author BOUVET Adrien
 */
public class TestSubjectManager extends TestCase
{
	SubjectManager subjectManager = new SubjectManager();
	ISubject subject = new SubjectImpl("test");


	public void testSaveAndGet() throws RemoteException
	{
		subjectManager.save(subject);
	
		ArrayList list = new ArrayList(subjectManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ISubject) break;
		}
		if( (SubjectImpl)iter != subject ) fail("objet sauvegardé différent de celui récupéré; save or get fails"); 
	}


	public void testDelete() throws RemoteException
	{
		subjectManager.delete(subject);
	
		ArrayList list = new ArrayList(subjectManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ISubject) break;
		}
		if( (SubjectImpl)iter == subject ) fail("objet toujours présent dans la liste; delete fails"); 
	}

	
	public void testUpdate() throws RemoteException
	{
		subjectManager.save(subject);
		subject.setName("test2");
		subjectManager.update(subject);
	
		ArrayList list = new ArrayList(subjectManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ISubject) break;
		}
		if( ((SubjectImpl)iter).getName() != subject.getName() ) fail("Nom des objets différents; update fails");
	}
	
}
