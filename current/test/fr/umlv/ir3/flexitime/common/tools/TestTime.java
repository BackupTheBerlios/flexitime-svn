/*
 * Created on 6 janv. 2005
 * by Famille
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.tools;

import java.util.Calendar;

import junit.framework.TestCase;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * 
 * @author FlexiTeam - Famille
 */
public class TestTime extends TestCase
{
   
    
    /**
     *  
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     *  
     * 
     * @author   FlexiTeam - Famille
     */
    public void testGetStrDate()
    {
        //Creation des time avec : le 06/12/2004 qui est un lundi
        FlexiTime time = new FlexiTime(2004, 12, 6, 12, 00);
        if(time.getStrDate().compareTo("Lundi 6 Décembre 2004") != 0 ) fail();
    }

    public void testGetDate()
    {
//      Creation des time avec : le 06/12/2004 qui est un lundi 
        FlexiTime time = new FlexiTime(2004, 12, 6, 12, 00);
        if(time.getDate().compareTo("06/12/2004") != 0 ) fail();
    }
    public void testGetHour()
    {
//      Creation des time avec : le 06/12/2004 à12h00
        FlexiTime time = new FlexiTime(2004, 12, 6, 12, 00);
        if(time.getHour()!= 12 ) fail();
    }
    
    public void testGetMinute()
    {
//      Creation des time avec : le 06/12/2004 à12h00
        FlexiTime time = new FlexiTime(2004, 12, 6, 12, 00);
        if(time.getMinute()!= 00 ) fail();
    }
    
    public void testAddDay()
    {
//      Creation des time avec : le 06/12/2004 
        FlexiTime time = new FlexiTime(2004, 12, 6, 12, 00);
        time.addDay(7);//si on ajoute 7 jours on obtient le lundi 13 decembre 2004
        if(time.getDate().compareTo("13/12/2004") != 0 ) fail();
    }
    
    public void testAddWeek()
    {
//      Creation des time avec : le 06/12/2004 
        FlexiTime time = new FlexiTime(2004, 12, 6, 12, 00);
        time.addWeek(1);//si on ajoute 1semaine on obtient le lundi 13 decembre 2004
        if(time.getDate().compareTo("13/12/2004") != 0 ) fail();
    }
    
    public void testAddMonth()
    {
//      Creation des time avec : le 06/12/2004
        FlexiTime time = new FlexiTime(2004, 12, 6, 12, 00);
        time.addMonth(3);
        if(time.getDate().compareTo("06/03/2005") != 0 ) fail();
    }
    
    public void testAddYear()
    {
//      Creation des time avec : le 06/12/2004 
        FlexiTime time = new FlexiTime(2004, 12, 6, 12, 00);
        time.addYear(2);
        if(time.getDate().compareTo("06/12/2006") != 0 ) fail();
    }
    
    public void testAddHour()
    {
//      Creation des time avec : le 06/12/2004 
        FlexiTime time = new FlexiTime(2004, 12, 6, 12, 00);
        time.addHour(2);
        if(time.getHour() != 14 ) fail();
    }
    
    public void testAddMinute()
    {
//      Creation des time avec : le 06/12/2004 
        FlexiTime time = new FlexiTime(2004, 12, 6, 12, 00);
        time.addMinute(7);
        if(time.getMinute() != 7 ) fail();
    }
    
    public void testCompare()
    {
//      Creation des time avec : 
        FlexiTime time = new FlexiTime(2004, 12, 6, 12, 00);
        if(FlexiTime.compare(time,time)!=0)fail();
    }
    
    
    public void testGetGapWeek()
    {
//      Creation des time avec : 
        FlexiTime time = new FlexiTime(2004, 12, 6, 12, 00);
        FlexiTime time2 = new FlexiTime(2004, 12, 15, 12, 00);
        
        //1. Avec les deux meme
        if(FlexiTime.getGapWeek(time,time) != 0)fail();
        
        //2. Avec deux différents ordre croissant
        if(FlexiTime.getGapWeek(time,time2) != 1)fail();
        
        //3. Avec deux différents ordre décroissant
        if(FlexiTime.getGapWeek(time2,time) != 1)fail();
    }
    
    public void testGetGapHour()
    {
//      Creation des time avec : 
        FlexiTime time = new FlexiTime(2004, 12, 6, 12, 00);
        FlexiTime time2 = new FlexiTime(2004, 12, 6, 16, 00);
        
        //1. Avec les deux meme
        if(FlexiTime.getGapHour(time,time) != 0)fail();
        
        //2. Avec deux différents ordre croissant
        if(FlexiTime.getGapHour(time,time2) != 4)fail();
        
        //3. Avec deux différents ordre décroissant
        if(FlexiTime.getGapHour(time2,time) != 4)fail();
    }
    
    
    public void testGetGapMinute()
    {
//      Creation des time avec : 
        FlexiTime time = new FlexiTime(2004, 12, 6, 12, 00);
        FlexiTime time2 = new FlexiTime(2004, 12, 6, 12, 10);
        
        //1. Avec les deux meme
        if(FlexiTime.getGapMinute(time,time) != 0)fail();
        
        //2. Avec deux différents ordre croissant
        if(FlexiTime.getGapMinute(time,time2) != 10)fail();
        
        //3. Avec deux différents ordre décroissant
        if(FlexiTime.getGapMinute(time2,time) != 10)fail();
    }
}

