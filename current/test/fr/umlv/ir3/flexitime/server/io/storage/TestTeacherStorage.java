/*
 * Created on 16 janv. 2005
 * by Jérôme GUERS
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.io.storage;

import java.rmi.RemoteException;
import java.util.*;

import net.sf.hibernate.HibernateException;
import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.resources.impl.TeacherImpl;
import fr.umlv.ir3.flexitime.common.rmi.LocalDataManager;
import junit.framework.TestCase;


/**
 * DOCME
 * 
 * @version 320
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestTeacherStorage extends TestCase
{
    /**
     * DOCME
     */
    public void testStorage()
    {
        ITeacher teacher = null;
    
        List allTeacher = null;
        try
        {
            teacher = DataFactory.createTeacher("REVUZ", "Banane","revuz@boulet.fr");
            allTeacher = LocalDataManager.getManager().getTeachers();
        }catch (Exception e1){
            fail("TeacherStorage:testStorage()");
        }
        boolean find =  false;
        
        for (Iterator iter = allTeacher.iterator() ; iter.hasNext() ;)
        {
            ITeacher element = (ITeacher) iter.next();
            if(element.equals(teacher))
            {
                System.out.println(element.getName());
                find = true;
            }
        }
        if(find == false)
        {
          fail("Unable to save or to load !!");  
        } 
    }
}

