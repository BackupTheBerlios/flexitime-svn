/*
 * Created on 6 janv. 2005
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.tools;

import java.util.Calendar;

import junit.framework.TestCase;


/**
 * DOCME
 * 
 * @version 320
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestTime extends TestCase
{
    public void testGetStrDay()
    {
        Time time = new Time(2005, 01, 31, 12, 00);
        FlexiLanguage language = FlexiLanguage.getInstance();
        for(int i=0; i < 7; i++)
        {
            System.out.println(time.getStrDay());
            if(!(time.getStrDay().equals(language.getDay(Calendar.MONDAY + i))))
                fail("Erreur ecriture du jour");
            time.addDay(1);
        }
            
    }
    public void testGetStrDate()
    {
        Time time = new Time(2005, 01, 29, 12, 00);
        if(!(time.getStrDate().equalsIgnoreCase("samedi 29 janvier 2005"))) fail("Erreur affichage de longue date");
    }

    public void testGetDate()
    {
        Time time = new Time(2004, 12, 6, 12, 00);
        if(!(time.getShortDate().equals("06/12/04"))) fail("Erreur affichage de date courtes");
    }
    public void testGetHour()
    {
//      Creation des time avec : le 06/12/2004 à12h00
        Time time = new Time(2004, 12, 6, 12, 00);
        if(time.getHour()!= 12 ) fail();
    }
    
    public void testGetMinute()
    {
//      Creation des time avec : le 06/12/2004 à12h00
        Time time = new Time(2004, 12, 6, 12, 00);
        if(time.getMinute()!= 00 ) fail();
    }
    
    public void testAddDay()
    {
//      Creation des time avec : le 06/12/2004 
        Time time = new Time(2004, 12, 6, 12, 00);
        time.addDay(7);//si on ajoute 7 jours on obtient le lundi 13 decembre 2004
        if(!(time.getShortDate().equals("13/12/04"))) fail("Problème d'ajout de jours");
    }
    
    public void testAddWeek()
    {
//      Creation des time avec : le 06/12/2004 
        Time time = new Time(2004, 12, 6, 12, 00);
        time.addWeek(1);//si on ajoute 1semaine on obtient le lundi 13 decembre 2004
        if(!(time.getShortDate().equals("13/12/04"))) fail("Erreur d'ajout de semaine");
    }
    
    public void testAddMonth()
    {
//      Creation des time avec : le 06/12/2004
        Time time = new Time(2004, 12, 6, 12, 00);
        time.addMonth(3);
        if(!(time.getShortDate().equals("06/03/05"))) fail("Erreur d'ajout de mois");
    }
    
    public void testAddYear()
    {
//      Creation des time avec : le 06/12/2004 
        Time time = new Time(2004, 12, 6, 12, 00);
        time.addYear(2);
        if(!(time.getShortDate().equals("06/12/06"))) fail("Erreur d'ajout d'années");
    }
    
    public void testAddHour()
    {
//      Creation des time avec : le 06/12/2004 
        Time time = new Time(2004, 12, 6, 12, 00);
        time.addHour(2);
        if(time.getHour() != 14 ) fail();
    }
    
    public void testAddMinute()
    {
//      Creation des time avec : le 06/12/2004 
        Time time = new Time(2004, 12, 6, 12, 00);
        time.addMinute(7);
        if(time.getMinute() != 7 ) fail();
    }
    
    public void testCompare()
    {
//      Creation des time avec : 
        Time time = new Time(2004, 12, 6, 12, 00);
        if(Time.compare(time,time)!=0)fail();
    }
    
    
    public void testGetGapWeek()
    {
//      Creation des time avec : 
        Time time = new Time(2004, 12, 6, 12, 00);
        Time time2 = new Time(2004, 12, 15, 12, 00);
        
        //1. Avec les deux meme
        if(Time.getGapWeek(time,time) != 0)fail();
        
        //2. Avec deux différents ordre croissant
        if(Time.getGapWeek(time,time2) != 1)fail();
        
        //3. Avec deux différents ordre décroissant
        if(Time.getGapWeek(time2,time) != 1)fail();
    }
    
    public void testGetGapHour()
    {
//      Creation des time avec : 
        Time time = new Time(2004, 12, 6, 12, 00);
        Time time2 = new Time(2004, 12, 6, 16, 00);
        
        //1. Avec les deux meme
        if(Time.getGapHour(time,time) != 0)fail();
        
        //2. Avec deux différents ordre croissant
        if(Time.getGapHour(time,time2) != 4)fail();
        
        //3. Avec deux différents ordre décroissant
        if(Time.getGapHour(time2,time) != 4)fail();
    }
    
    
    public void testGetGapMinute()
    {
//      Creation des time avec : 
        Time time = new Time(2004, 12, 6, 12, 00);
        Time time2 = new Time(2004, 12, 6, 12, 10);
        
        //1. Avec les deux meme
        if(Time.getGapMinute(time,time) != 0)fail();
        
        //2. Avec deux différents ordre croissant
        if(Time.getGapMinute(time,time2) != 10)fail();
        
        //3. Avec deux différents ordre décroissant
        if(Time.getGapMinute(time2,time) != 10)fail();
    }
}

