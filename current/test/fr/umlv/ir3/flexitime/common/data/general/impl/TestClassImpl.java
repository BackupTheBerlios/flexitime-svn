/*
 * Created on 5 janv. 2005
 * by Famille
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.general.impl;

import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.resources.impl.*;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;

import junit.framework.TestCase;


/**
 * TestClassImpl - DOCME Description
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
public class TestClassImpl extends TestCase {
    String strName = "toto";
    List lstGroup  = new ArrayList();
    ITeachingStructure struct;
    ClassImpl pclass = new ClassImpl(strName);

    public void testGetNbGroup()
    {
        GroupImpl group1 = new GroupImpl("titi",new ArrayList(),10,new ClassImpl());
        pclass.addGroup(group1);
        pclass.addGroup( new GroupImpl("tutu",new ArrayList(),20,new ClassImpl()));
        
        if(pclass.getNbGroup() != 2)
            fail("Erreur NbGroup");
       
        pclass.removeGroup(group1);
        if(pclass.getNbGroup() != 1)
            fail("Erreur NbFloor");
          
    }
    
    public void testGetNbPerson()
    {
        GroupImpl group1 = new GroupImpl("titi",new ArrayList(),10,new ClassImpl());
        pclass.addGroup(group1);
        pclass.addGroup( new GroupImpl("tutu",new ArrayList(),20,new ClassImpl()));
        
        if(pclass.getNbPerson() != 30)
            fail("Erreur NbGroup");
       
        pclass.removeGroup(group1);
        if(pclass.getNbPerson() != 20)
            fail("Erreur NbFloor");
          
    }
    
    public void testLstGroup()
    {
        GroupImpl group1 = new GroupImpl("titi",new ArrayList(),10,new ClassImpl());
        pclass.addGroup(group1);
        pclass.addGroup( new GroupImpl("tutu",new ArrayList(),20,new ClassImpl()));
        
        if( ((GroupImpl)(pclass.getLstGroups().get(0))).getName().compareTo("titi") != 0 )
            fail("erreur Lecture des Group");
        
        pclass.removeGroup(group1);
        if( ((GroupImpl)(pclass.getLstGroups().get(0))).getName().compareTo("tutu") != 0 )
            fail("erreur Lecture des Group 2 ");
        
    }
}
