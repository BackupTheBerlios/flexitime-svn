/*
 * Created on 15 janv. 2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.CourseImpl;
import junit.framework.TestCase;

/**
 * Les notify de smethodes save() delete() et update() n'ont pas été testées.
 * 
 * @author BOUVET Adrien
 */
public class TestCourseManager extends TestCase
{
	CourseManager courseManager = new CourseManager();
	ICourse course = new CourseImpl("test");


	public void testSaveAndGet() throws RemoteException
	{
		courseManager.save(course);
	
		ArrayList list = new ArrayList(courseManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ICourse) break;
		}
		if( (CourseImpl)iter != course ) fail("objet sauvegardé différent de celui récupéré; save or get fails"); 
	}


	public void testDelete() throws RemoteException
	{
		courseManager.delete(course);
	
		ArrayList list = new ArrayList(courseManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ICourse) break;
		}
		if( (CourseImpl)iter == course ) fail("objet toujours présent dans la liste; delete fails"); 
	}

	
	public void testUpdate() throws RemoteException
	{
		courseManager.save(course);
		course.setName("test2");
		courseManager.update(course);
	
		ArrayList list = new ArrayList(courseManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof ICourse) break;
		}
		if( ((CourseImpl)iter).getName() != course.getName() ) fail("Nom des objets différents; update fails");
	}
	
}
