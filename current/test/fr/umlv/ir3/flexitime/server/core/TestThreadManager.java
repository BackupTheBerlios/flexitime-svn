/*
 * Created on 15 janv. 2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.util.ArrayList;

import fr.umlv.ir3.flexitime.common.rmi.IDataListener;

import junit.framework.TestCase;

/**
 * 
 * 
 * @author BOUVET Adrien
 */
public class TestThreadManager extends TestCase
{
	public void testRun()
	{
		ArrayList list = new ArrayList();
		list.add();
		IDataListener dl = new IDataListener();
		ThreadManager threadManager = new ThreadManager();
		//il faut créer un objet thread manager a partir d'une liste de data
		//puis il faut faire une action sur cette liste qui va générer le déclenchement de slisteners
		//
		
	}
}
