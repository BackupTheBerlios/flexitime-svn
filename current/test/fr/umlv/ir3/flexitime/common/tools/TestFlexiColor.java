/*
 * Created on 7 janv. 2005
 * by Famille
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.tools;

import java.awt.Color;

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
public class TestFlexiColor extends TestCase
{
    public void testGetColor()
    {
         
        Color color = FlexiColor.getColor("256");
        System.out.println(color.toString());
        if(color.toString().compareTo("java.awt.Color[r=0,g=1,b=0]") !=0 )fail();
        System.out.println(FlexiColor.darker(FlexiColor.getColor("256")).toString());
        System.out.println(FlexiColor.brighter(FlexiColor.getColor("260")).toString());
    }
    
    public void testDarker()
    {
       if(FlexiColor.darker(FlexiColor.getColor("256")).toString().compareTo("java.awt.Color[r=0,g=0,b=0]")!= 0)fail();
    }
    
    public void testBrighter()
    {
       if(FlexiColor.brighter(FlexiColor.getColor("260")).toString().compareTo("java.awt.Color[r=0,g=4,b=5]")!= 0)fail();
    }
}

