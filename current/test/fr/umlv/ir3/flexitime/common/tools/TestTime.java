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
    Time time = new Time();
    
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
        if(time.getStrDate().compareTo("Vendredi 7 Janvier 2005") != 0 ) fail();
    }

    public void testGetDate()
    {
        if(time.getDate().compareTo("07/01/2005") != 0 ) fail();
    }
    
    public void testRollDay()
    {
        time.rollDay(10);
        if(time.getStrDate().compareTo("Lundi 17 Janvier 2005") != 0 ) fail();
    }
    
    public void testCompare()
    {
        if(Time.compare(time,time)!=0)fail();
    }
}

