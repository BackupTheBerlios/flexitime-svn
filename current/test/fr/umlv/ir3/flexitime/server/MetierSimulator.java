/*
 * Created on 19 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.CourseImpl;
import fr.umlv.ir3.flexitime.common.tools.Gap;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - binou
 */
public class MetierSimulator
{
    /** 
     * @return dsfsd
     */
    public static List getLessonsList()
    {
        List<ILesson> res = new ArrayList<ILesson>(3);
        res.add(DataFactory.createLesson(new Gap(2005,1,3,8,30,2005,1,3,10,30) , new CourseImpl("Corba", 1,50,Color.YELLOW,2) , 120 )   );
        res.add(DataFactory.createLesson(new Gap(2005,1,3,13,45,2005,1,3,15,45) , new CourseImpl("J2EE", 1,50,Color.MAGENTA,2) , 120    )   );
        res.add(DataFactory.createLesson(new Gap(2005,1,3,16,00,2005,1,3,17,00) , new CourseImpl("MSI", 1,50,Color.GREEN,2), 60));
        
        res.add(DataFactory.createLesson(new Gap(2005,1,4,8,30,2005,1,4,12,45) , new CourseImpl("J2EE", 1,50,Color.MAGENTA,2), 240));
        res.add(DataFactory.createLesson(new Gap(2005,1,4,13,45,2005,1,4,15,45) , new CourseImpl("Corba", 1,50,Color.YELLOW,2), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,4,16,00,2005,1,4,17,30) , new CourseImpl("MSI", 1,50,Color.GREEN,2), 90));

        res.add(DataFactory.createLesson(new Gap(2005,1,5,10,45,2005,1,5,12,45) , new CourseImpl("J2EE", 1,50,Color.MAGENTA,2), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,5,13,30,2005,1,5,15,30) , new CourseImpl("Corba", 1,50,Color.YELLOW,2), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,5,16,00,2005,1,5,18,00) , new CourseImpl("MSI", 1,50,Color.GREEN,2), 120));

        res.add(DataFactory.createLesson(new Gap(2005,1,6,8,30,2005,1,6,10,30) , new CourseImpl("MSI", 1,50,Color.GREEN,2), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,6,10,45,2005,1,6,12,45) , new CourseImpl("Corba", 1,50,Color.YELLOW,2), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,6,13,45,2005,1,6,18,00) , new CourseImpl("J2EE", 1,50,Color.MAGENTA,2), 240));

        
        res.add(DataFactory.createLesson(new Gap(2005,1,7,13,45,2005,1,7,15,45) , new CourseImpl("J2EE", 1,50,Color.MAGENTA,2), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,7,16,00,2005,1,7,17,00) , new CourseImpl("Corba", 1,50,Color.YELLOW,2), 60));
        res.add(DataFactory.createLesson(new Gap(2005,1,7,17,00,2005,1,7,18,00) , new CourseImpl("MSI", 1,50,Color.GREEN,2), 60));

        res.add(DataFactory.createLesson(new Gap(2005,1,10,11,45,2005,1,10,12,45) , new CourseImpl("J2EE", 1,50,Color.MAGENTA,2), 60));
        res.add(DataFactory.createLesson(new Gap(2005,1,10,13,45,2005,1,10,15,45) , new CourseImpl("Corba", 1,50,Color.YELLOW,2), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,10,16,00,2005,1,10,18,00) , new CourseImpl("MSI", 1,50,Color.GREEN,2), 120));

        res.add(DataFactory.createLesson(new Gap(2005,1,11,16,00,2005,1,11,18,00) , new CourseImpl("MSI", 1,50,Color.GREEN,2), 120));
        
        
        res.add(DataFactory.createLesson(new Gap(2005,1,12,8,30,2005,1,12,10,30) , new CourseImpl("Corba", 1,50,Color.YELLOW,2), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,12,13,45,2005,1,12,15,45) , new CourseImpl("J2EE", 1,50,Color.MAGENTA,2), 120));

        
        res.add(DataFactory.createLesson(new Gap(2005,1,13,8,30,2005,1,13,10,30) , new CourseImpl("Corba", 1,50,Color.YELLOW,2), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,13,13,45,2005,1,13,15,45) , new CourseImpl("J2EE", 1,50,Color.MAGENTA,2), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,13,16,00,2005,1,13,17,00) , new CourseImpl("MSI", 1,50,Color.GREEN,2), 60));

        
        res.add(DataFactory.createLesson(new Gap(2005,1,14,8,30,2005,1,14,10,30) , new CourseImpl("Corba", 1,50,Color.YELLOW,2), 120));
        
        
        res.add(DataFactory.createLesson(new Gap(2005,1,19,8,30,2005,1,19,10,30) , new CourseImpl("J2EE", 1,50,Color.MAGENTA,2), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,19,16,00,2005,1,3,17,00) , new CourseImpl("MSI", 1,50,Color.GREEN,2), 60));

        res.add(DataFactory.createLesson(new Gap(2005,1,27,10,00,2005,1,19,12,00) , new CourseImpl("MSI", 1,50,Color.GREEN,2), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,27,14,30,2005,1,19,17,30) , new CourseImpl("Corba", 1,50,Color.YELLOW,2), 180));
        res.add(DataFactory.createLesson(new Gap(2005,1,28,10,45,2005,1,19,12,45) , new CourseImpl("J2EE", 1,50,Color.MAGENTA,2), 120));

        
        return res;
    }

}

