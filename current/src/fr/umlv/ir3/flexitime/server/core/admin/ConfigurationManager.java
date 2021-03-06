/*
 * Created on 26 d�c. 2004
 * by Val�re
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import fr.umlv.ir3.flexitime.common.data.admin.IConfig;
import fr.umlv.ir3.flexitime.common.event.ConfigEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.admin.IConfigurationListener;
import fr.umlv.ir3.flexitime.common.rmi.admin.IConfigurationManager;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.server.io.FlexiLDAP;
import fr.umlv.ir3.flexitime.server.io.storage.HibernateUtil;

/**
 * Implement IConfig. This class return all the time the same configuration.
 * 
 * @version 250
 * @author FlexiTeam - J�r�me GUERS
 */
public class ConfigurationManager extends UnicastRemoteObject implements IConfigurationManager
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3256442499634378288L;
    private static IConfig currentConfig;
    
    private List<IConfigurationListener> listenerList = new CopyOnWriteArrayList<IConfigurationListener>();
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * @throws FlexiException 
     * @throws RemoteException 
     * 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.admin.IConfigurationManager#init()
     */
    public void init() throws FlexiException, RemoteException
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
            throw new FlexiException(FlexiLanguage.getInstance().getText("errServerConf1") + e.getMessage(), e.getCause());
        }

        catch (ParserConfigurationException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("errServerConf1") + e.getMessage(), e.getCause());
        }
        catch (IOException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("errServerConf2") + e.getMessage(), e.getCause());
        }
        
        upDateConfig();
    }

    
    /**
     * DOCME
     * @throws RemoteException
     */
    public ConfigurationManager() throws RemoteException
    {
        super();
    }
    
    private void upDateConfig() throws FlexiException, RemoteException
    {
        HibernateUtil.setConfiguration(currentConfig);
        FlexiLDAP.setConfiguration(currentConfig);
        
        ConfigEvent e = new ConfigEvent(currentConfig);
        List<IConfigurationListener> toRemove = new ArrayList<IConfigurationListener>();
        for(IConfigurationListener l : listenerList)
        {
            try
            {
                l.ConfigurationChanged(e);
            }
            catch(RemoteException ex)
            {
                ex.printStackTrace();
                toRemove.add(l);
            }
        }
        
        listenerList.removeAll(toRemove);
    }

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
    public IConfig get() throws RemoteException, FlexiException
    {
        if (currentConfig == null)
        {
            init();
        }
        return currentConfig;
    }

    /**
     * DOCME
     * 
     * @param config
     * @return if the configuration was well saved
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.admin.IConfigurationManager#save(fr.umlv.ir3.flexitime.common.data.admin.IConfig)
     */
    public boolean save(IConfig config) throws RemoteException, FlexiException
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
            upDateConfig();
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
    
    
    /** 
     *
     * @param listener
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.admin.IConfigurationManager#addConfigurationListener(fr.umlv.ir3.flexitime.common.rmi.admin.IConfigurationListener)
     */
    public void addConfigurationListener(IConfigurationListener listener)
            throws RemoteException
    {
        listenerList.add(listener);
    }
    
    
    /** 
     * @param listener
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.admin.IConfigurationManager#removeConfigurationListener(fr.umlv.ir3.flexitime.common.rmi.admin.IConfigurationListener)
     */
    public void removeConfigurationListener(IConfigurationListener listener)
            throws RemoteException
    {
        listenerList.remove(listener);
    }
}
