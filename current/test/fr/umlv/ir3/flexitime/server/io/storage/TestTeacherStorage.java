/*
 * Created on 16 janv. 2005
 * by Jérôme GUERS
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.io.storage;

import java.util.*;

import net.sf.hibernate.HibernateException;
import fr.umlv.ir3.flexitime.common.data.resources.impl.TeacherImpl;
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
        TeacherImpl teacher = new TeacherImpl("REVUZ", "Doiminique");
        
        try {
            TeacherStorage.save(teacher);
            
            List allTeacher = TeacherStorage.get();
            boolean find =  false;
            
            for (Iterator iter = allTeacher.iterator() ; iter.hasNext() ;)
            {
                TeacherImpl element = (TeacherImpl) iter.next();
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
        } catch (HibernateException e) {
            fail("Erreur hibernate");
        }
       
    }
}

