/*
 * Created on 24 janv. 2005
 * by Jérôme GUERS
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.admin;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.helpers.DefaultHandler;

import fr.umlv.ir3.flexitime.common.data.admin.IConfig;
import fr.umlv.ir3.flexitime.common.data.admin.impl.ConfigImpl;


/**
 * DOCME
 *  
 * @version 250
 * @see org.xml.sax.helpers.DefaultHandler
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class SAXConfHandler extends DefaultHandler
{
    private IConfig config;
    private String currentElem;
    
    /** 
     * Return the config loaded
     *
     * @return the configuration loaded from file
     */
    public IConfig getConfig()
    {
        return config;
    }

    
    /** 
     * DOCME
     *
     * @param ch
     * @param start
     * @param length
     * @throws org.xml.sax.SAXException 
     * 
     * @see org.xml.sax.ContentHandler#characters(char[], int, int)
     */
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        String str = new String(ch, start, length);
        if(currentElem.equals(DTDConfiguration.uriData))
            config.setUriServerData(str);
        else if(currentElem.equals(DTDConfiguration.nameDB))
            config.setNameBase(str);
        else if(currentElem.equals(DTDConfiguration.userDB))
            config.setUserBDD(str);
        else if(currentElem.equals(DTDConfiguration.passDB))
            config.setPassBDD(str);
        else if(currentElem.equals(DTDConfiguration.uriLDAP))
            config.setUriServerLDAP(str);
        else if(currentElem.equals(DTDConfiguration.portLDAP))
        {
            try
            {
                int port = Integer.parseInt(str);
                config.setPortLDAP(port);
            }
            catch (NumberFormatException e)
            {
                config.setPortLDAP(-1);
            }
        }
        else if(currentElem.equals(DTDConfiguration.pathUserLDAP))
            config.setPathUserLDAP(str);
        else if(currentElem.equals(DTDConfiguration.pathGroupLDAP))
            config.setPathGroupLDAP(str);
        else if(currentElem.equals(DTDConfiguration.uriMail))
            config.setUriSMTPserver(str);
    }   
    
    /** 
     * DOCME
     *
     * @param uri
     * @param localName
     * @param qName
     * @throws org.xml.sax.SAXException 
     * 
     * @see org.xml.sax.ContentHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
     */
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        if(DTDConfiguration.root.equals(qName))
            currentElem = null;
        else
            currentElem = DTDConfiguration.root;
    }
    
    /** 
     * DOCME
     *
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws org.xml.sax.SAXException 
     * 
     * @see org.xml.sax.ContentHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        if(qName == DTDConfiguration.root)
        {
            if(currentElem != null)
                throw new SAXNotRecognizedException("A configuration can not be contain.");
            config = new ConfigImpl();
        }
        currentElem = qName;
    }
}

