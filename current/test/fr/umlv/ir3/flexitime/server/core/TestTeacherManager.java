/*
 * Created on 15 janv. 2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.resources.impl.TeacherImpl;
import junit.framework.TestCase;

/**
 * Les notify des méthodes save() update() et delete() ne sont pas testées.
 * 
 * @author BOUVET Adrien
 */
public class TestTeacherManager extends TestCase
{
	TeacherManager teacherManager = new TeacherManager();
	ITeacher teacher = new TeacherImpl("test");


	public void testSaveAndGet() throws RemoteException
	{
		teacherManager.save(teacher);
	
		ArrayList list = new ArrayList(teacherManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ITeacher) break;
		}
		if( (TeacherImpl)iter != teacher ) fail("objet sauvegardé différent de celui récupéré; save or get fails"); 
	}


	public void testDelete() throws RemoteException
	{
		teacherManager.delete(teacher);
	
		ArrayList list = new ArrayList(teacherManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ITeacher) break;
		}
		if( (TeacherImpl)iter == teacher ) fail("objet toujours présent dans la liste; delete fails"); 
	}

	
	public void testUpdate() throws RemoteException
	{
		teacherManager.save(teacher);
		teacher.setName("test2");
		teacherManager.update(teacher);
	
		ArrayList list = new ArrayList(teacherManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ITeacher) break;
		}
		if( ((TeacherImpl)iter).getName() != teacher.getName() ) fail("Nom des objets différents; update fails");
	}
	
}
