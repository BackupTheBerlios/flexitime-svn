/*
 * Created on 13 janv. 2005
 * by Famille
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.io;

import java.util.ArrayList;

import junit.framework.TestCase;


/**
 * DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - Famille
 */
public class TestFlexiLDAP extends TestCase
{
    public void testCreateConnection()
    {
        String name="fappert";
        String passwd = "popopopo";
        FlexiLDAP ldap = new FlexiLDAP("gontime.ath.cx",389,"ou=Users,ou=Etudiant,dc=donvincenzo,dc=com","ou=Groups,ou=Etudiant,dc=donvincenzo,dc=com");
        if(ldap.createConnection(name,passwd) != true)fail("CreateConnexion");
    }
    
    public void testGetAttribute()
    {
        String name="fappert";
        String passwd = "popopopo";
        FlexiLDAP ldap = new FlexiLDAP("gontime.ath.cx",389,"ou=Users,ou=Etudiant,dc=donvincenzo,dc=com","ou=Groups,ou=Etudiant,dc=donvincenzo,dc=com");
        if(ldap.createConnection(name,passwd) != true)fail("CreateConnexion");
        ArrayList list = new ArrayList();
        if((list=ldap.getAttribute("uid",FlexiLDAP.TYPE_USER,"jguers"))==null)fail("Recuperation Attributs");
        if( ((String)list.get(0)).compareTo("jguers")!= 0 )fail("Lecture Attributs");
        // if((list=ldap.getAttribute("cn",FlexiLDAP.TYPE_USER,"fappert"))==null)fail("Recuperation Attributs");
       // if( ((String)list.get(0)).compareTo("Fabien ")!= 0 )fail("Lecture Attributs");
    }
}
