/*
 * Created on 24 janv. 2005
 * by Jérôme GUERS
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.admin;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import fr.umlv.ir3.flexitime.common.data.admin.IConfig;
import fr.umlv.ir3.flexitime.common.data.admin.impl.ConfigImpl;
import junit.framework.TestCase;


/**
 * DOCME
 * 
 * @version 250
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestConfigManager extends TestCase
{
    public void testManager()
    {
        IConfig config = new ConfigImpl();
        ConfigurationManager manager = new ConfigurationManager();
        
        // System.setProperty("fr.umlv.ir3.flexitime.configfile", "TestConfig.xml");
        
        config.setUriServerData("jdbc:postgresql://gontime.ath.cx:5432");
        config.setNameBase("flexitime");
        config.setUserBDD("flexitime");
        config.setPassBDD("flexitim");
        config.setUriServerLDAP("gontime.ath.cx");
        config.setPortLDAP(389);
        config.setPathUserLDAP("ou=Users,ou=Etudiant,dc=donvincenzo,dc=com");
        config.setPathGroupLDAP("ou=Groups,ou=Etudiant,dc=donvincenzo,dc=com");
        config.setUriSMTPserver("smtp.neuf.fr");
        
        try {
            manager.save(config);
            IConfig config2 = manager.get();
            
            if(!(config.getUriServerData().equals(config2.getUriServerData())))
                fail("Load string error");
            if(!(config.getPortLDAP() == config2.getPortLDAP()))
                fail("Load int error");
            
        } catch (IOException e) {
            fail(e.getMessage());
        }
        catch (SAXException e)
        {
            fail(e.getMessage());
        }
        catch (ParserConfigurationException e)
        {
            fail(e.getMessage());
        }
    }
}

