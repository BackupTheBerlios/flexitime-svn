/*
 * Created on 26 déc. 2004
 * by Valère
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core.admin;

import java.io.*;
import java.net.MalformedURLException;

import javax.xml.parsers.*;

import org.xml.sax.*;

import fr.umlv.ir3.flexitime.common.data.admin.IConfig;
import fr.umlv.ir3.flexitime.common.exception.*;
import fr.umlv.ir3.flexitime.common.rmi.admin.IConfigurationManager;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;

/**
 * Implement IConfig. This class return all the time the same configuration.
 * 
 * @version 250
 * @author FlexiTeam - Jérôme GUERS
 */
public class ConfigurationManager implements IConfigurationManager
{

    private static IConfig currentConfig;

    /**
     * Load the configuration if it is the first time the configuration is
     * loaded or return th current config. <br>
     * The default file name used to load the configuration is
     * <code>flexiConfig.xml</code>. If the property
     * <code>fr.umlv.ir3.flexitime.configfile</code> is set, this value is
     * considered.
     * 
     * @return current configuration
     * @throws FlexiException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.admin.IConfigurationManager#get()
     */
    public IConfig get() throws FlexiException
    {
        if (currentConfig == null)
        {
            String fileName = System.getProperty(
                    "fr.umlv.ir3.flexitime.configfile", "flexiConfig.xml");
            File f = new File(fileName);
            InputSource inSrc;
            try
            {
                inSrc = new InputSource(new FileReader(f));
                inSrc.setSystemId(f.toURL().toExternalForm());

                SAXConfHandler handler = new SAXConfHandler();
                XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();

                xmlReader.setContentHandler(handler);
                xmlReader.parse(inSrc);
                currentConfig = handler.getConfig();

            }
            catch (MalformedURLException e)
            {}

            catch (SAXException e)
            {
                throw new FlexiException(FlexiLanguage.getInstance().getText("errConf1") + e.getMessage(), e.getCause());
            }

            catch (ParserConfigurationException e)
            {
                throw new FlexiException(FlexiLanguage.getInstance().getText("errConf1") + e.getMessage(), e.getCause());
            }
            catch (IOException e)
            {
                throw new FlexiException(FlexiLanguage.getInstance().getText("errConf2") + e.getMessage(), e.getCause());
            }
        }
        return currentConfig;
    }

    /**
     * DOCME
     * 
     * @param config
     * @return if the configuration was well saved
     * @see fr.umlv.ir3.flexitime.common.rmi.admin.IConfigurationManager#save(fr.umlv.ir3.flexitime.common.data.admin.IConfig)
     */
    public boolean save(IConfig config)
    {
        boolean error = false;

        String fileName = System.getProperty(
                "fr.umlv.ir3.flexitime.configfile", "flexiConfig.xml");
        File f = new File(fileName);
        try
        {
            FileOutputStream out = new FileOutputStream(f);

            out.write(DTDConfiguration.xmlHeader.getBytes());
            out.write("\n".getBytes());
            openElem(out, DTDConfiguration.root, 0);
            out.write("\n".getBytes());

            openElem(out, DTDConfiguration.uriData, 1);
            out.write(config.getUriServerData().getBytes());
            closeElem(out, DTDConfiguration.uriData);

            openElem(out, DTDConfiguration.nameDB, 1);
            out.write(config.getNameBase().getBytes());
            closeElem(out, DTDConfiguration.nameDB);

            openElem(out, DTDConfiguration.userDB, 1);
            out.write(config.getUserBDD().getBytes());
            closeElem(out, DTDConfiguration.userDB);

            openElem(out, DTDConfiguration.passDB, 1);
            out.write(config.getPassBDD().getBytes());
            closeElem(out, DTDConfiguration.passDB);

            openElem(out, DTDConfiguration.uriLDAP, 1);
            out.write(config.getUriServerLDAP().getBytes());
            closeElem(out, DTDConfiguration.uriLDAP);

            openElem(out, DTDConfiguration.portLDAP, 1);
            out.write(Integer.toString(config.getPortLDAP()).getBytes());
            closeElem(out, DTDConfiguration.portLDAP);

            openElem(out, DTDConfiguration.pathUserLDAP, 1);
            out.write(config.getPathUserLDAP().getBytes());
            closeElem(out, DTDConfiguration.pathUserLDAP);

            openElem(out, DTDConfiguration.pathGroupLDAP, 1);
            out.write(config.getPathGroupLDAP().getBytes());
            closeElem(out, DTDConfiguration.pathGroupLDAP);

            openElem(out, DTDConfiguration.uriMail, 1);
            out.write(config.getUriSMTPserver().getBytes());
            closeElem(out, DTDConfiguration.uriMail);

            closeElem(out, DTDConfiguration.root);

            currentConfig = config;
        }
        catch (IOException e)
        {
            error = true;
        }

        return error;
    }

    private void closeElem(FileOutputStream out, String root)
            throws IOException
    {
        out.write("</".getBytes());
        out.write(root.getBytes());
        out.write(">\n".getBytes());
    }

    private void openElem(FileOutputStream out, String root, int i)
            throws IOException
    {
        for (int j = 0 ; j < i ; j++)
            out.write("\t".getBytes());
        out.write("<".getBytes());
        out.write(root.getBytes());
        out.write(">".getBytes());
    }
}
