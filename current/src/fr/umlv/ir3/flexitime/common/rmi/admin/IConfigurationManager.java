/*
 * Created on 14 janv. 2005
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi.admin;

import java.io.IOException;
import java.rmi.Remote;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import fr.umlv.ir3.flexitime.common.data.admin.IConfig;


/**
 * DOCME
 * 
 * @version 250
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public interface IConfigurationManager extends Remote
{
    /**
     * Load the configuration if it is the first time the configuration is
     * loaded or return th current config. <br>
     * The default file name used to load the configuration is
     * <code>flexiConfig.xml</code>. If the property
     * <code>fr.umlv.ir3.flexitime.configfile</code> is set, this value is
     * considered.
     * 
     * @return current configuration
     *  
     * @throws ParserConfigurationException 
     * @throws SAXException 
     * @throws IOException 
     */
    public IConfig get() throws SAXException, ParserConfigurationException, IOException;
    
    /**
     * DOCME
     * 
     * @param config 
     * @return if the configuration was well saved
     */
    public boolean save(IConfig config);
}

