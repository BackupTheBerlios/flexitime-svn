/*
 * Created on 15 janv. 2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.impl.ClassImpl;
import junit.framework.TestCase;

/**
 * Les notify des méthodes save() delete() et update() ne sont pas testés. 
 * 
 * @author BOUVET Adrien
 */
public class TestClassManager extends TestCase
{
	ClassManager classManager = new ClassManager();
	IClass classs = new ClassImpl("test");


	public void testSaveAndGet() throws RemoteException
	{
		classManager.save(classs);
	
		ArrayList list = new ArrayList(classManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IClass) break;
		}
		if( (ClassImpl)iter != classs ) fail("objet sauvegardé différent de celui récupéré; save or get fails"); 
	}


	public void testDelete() throws RemoteException
	{
		classManager.delete(classs);
	
		ArrayList list = new ArrayList(classManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IClass) break;
		}
		if( (ClassImpl)iter == classs ) fail("objet toujours présent dans la liste; delete fails"); 
	}

	
	public void testUpdate() throws RemoteException
	{
		classManager.save(classs);
		classs.setName("test2");
		classManager.update(classs);
	
		ArrayList list = new ArrayList(classManager.get());
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next() instanceof IClass) break;
		}
		if( ((ClassImpl)iter).getName() != classs.getName() ) fail("Nom des objets différents; update fails");
	}
	
}
