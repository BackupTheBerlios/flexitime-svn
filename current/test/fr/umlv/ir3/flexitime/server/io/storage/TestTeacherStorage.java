/*
 * Created on 16 janv. 2005
 * by Jérôme GUERS
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.io.storage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.hibernate.HibernateException;
import fr.umlv.ir3.flexitime.common.data.resources.impl.TeacherImpl;
import junit.framework.TestCase;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestTeacherStorage extends TestCase
{
    /**
     *  
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * 
     * @see (si nécessaire)
     */
    public void testStorage()
    {
        TeacherImpl teacher = new TeacherImpl("Docteur REVUZ");
        
        try {
            TeacherStorage.save(teacher);
            
            List allTeacher = TeacherStorage.get();
            boolean find =  false;
            
            for (Iterator iter = allTeacher.iterator() ; iter.hasNext() ;)
            {
                TeacherImpl element = (TeacherImpl) iter.next();
                if(element.equals(teacher))
                {
                    find = true;
                }
            }
            if(find == false)
            {
              fail("Unable to save or to load !!");  
            }
        } catch (HibernateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
}

