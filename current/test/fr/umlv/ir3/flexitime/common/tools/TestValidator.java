/*
 * Created on 30 janv. 2005
 * by Jérôme GUERS
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.tools;

import junit.framework.TestCase;


/**
 * DOCME
 * 
 * @version 325
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestValidator extends TestCase
{
    /**
     * DOCME
     */
    public void testValidMail()
    {
       if(Validator.validMail("toto"))
           fail("Erreur : manque @");
       
       if(Validator.validMail("toto@titi"))
           fail("Erreur : mauvaise adresse hote");
       
       if(Validator.validMail("toto&tata@titi.com"))
           fail("Erreur : caractère non lettre");
       if(Validator.validMail("toto@ti ti.com"))
           fail("Erreur : espace dans l'adresse");
       
       if(!(Validator.validMail(" toto@titi.com  ")))
           fail("Erreur : adresse entourée d'espace");
       if(!(Validator.validMail("toto99@titi.com")))
           fail("Erreur : adresse valide");
       
    }
    
    /**
     * DOCME
     */
    public void testValidMultiMail()
    {
       if(!(Validator.validMultiMails("toto99@titi.com")))
           fail("Erreur : adresse valide");
       if(Validator.validMultiMails("toto99@titi.com,titi"))
           fail("Erreur : seconde adresse non valide");
       if(!(Validator.validMultiMails("toto99@titi.com,titi90@toto.com")))
           fail("Erreur : adresses valides séparées par des virgules");
       if(!(Validator.validMultiMails("toto99@titi.com; titi90@toto.com")))
           fail("Erreur : adresses valides séparées par des points virgules et un espace");
       if(!(Validator.validMultiMails("toto99@titi.com; titi90@toto.com, titi@tutu.com")))
           fail("Erreur : adresses valides séparées par des points virguleset virgules");

    }
}

