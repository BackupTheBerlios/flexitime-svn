/*
 * Created on 15 janv. 2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.activity.impl.LessonImpl;
import junit.framework.TestCase;

/**
 * LEs notify de sméthodes save() update() et delete() n'ont pas été testées.
 * 
 * @author BOUVET Adrien
 */
public class TestLessonManager extends TestCase
{
	LessonManager lessonManager = new LessonManager();
	ILesson lesson = new LessonImpl("test");


	public void testSaveAndGet() throws RemoteException
	{
		lessonManager.save(lesson);
	
		ArrayList list = new ArrayList(lessonManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IClass) break;
		}
		if( (ClassImpl)iter != lesson ) fail("objet sauvegardé différent de celui récupéré; save or get fails"); 
	}


	public void testDelete() throws RemoteException
	{
		lessonManager.delete(lesson);
	
		ArrayList list = new ArrayList(lessonManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IClass) break;
		}
		if( (ClassImpl)iter == lesson ) fail("objet toujours présent dans la liste; delete fails"); 
	}

	
	public void testUpdate() throws RemoteException
	{
		lessonManager.save(lesson);
		lesson.setName("test2");
		lessonManager.update(lesson);
	
		ArrayList list = new ArrayList(lessonManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IClass) break;
		}
		if( ((ClassImpl)iter).getName() != lesson.getName() ) fail("Nom des objets différents; update fails");
	}
	
	
}
