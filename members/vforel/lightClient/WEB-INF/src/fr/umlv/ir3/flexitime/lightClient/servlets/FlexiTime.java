/*
 * Created on 23 nov. 2004
 */
package fr.umlv.ir3.flexitime.lightClient.servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import fr.umlv.ir3.flexitime.common.data.admin.IConfig;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.lightClient.authentification.Authentification;
import fr.umlv.ir3.flexitime.lightClient.gestionErreurs.MessagesErreurs;
import fr.umlv.ir3.flexitime.lightClient.gestionErreurs.TraitementException;



/**
 * @author vforel
 */
public class FlexiTime extends HttpServlet{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3690756198215725361L;

    protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1)
            throws ServletException, IOException {
        doPost(arg0, arg1);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jspName = "/JNoAuth";
        String codeErreur = "0";
        String login = "";
        int typePerson = 0;
        String valid = request.getParameter("auth");
        String devalid = request.getParameter("devalid");
        if(valid != null){
            try{
                login = request.getParameter("login");
                String password = request.getParameter("password");
                String server = getServer();
                Authentification.getAuth(server,login,password);
                if(typePerson==1)jspName = "/TraitementTeacher";   
                else jspName = "/TraitementStudent"; 
            }catch(TraitementException te){
                codeErreur = MessagesErreurs.getMessage(te.getMessage());
            }
        }else if(devalid != null){
            login = request.getParameter("login");
        }
        request.setAttribute("login",login);
        request.setAttribute("codeErreur",codeErreur);
        getServletContext().getRequestDispatcher(jspName).forward(request,response);       
    }

    private String getServer() throws TraitementException 
    {
        String server = null;
        BufferedReader fichier;
        String fileName = null;
        /*try
        {
            fileName = System.getProperty(
                    "fr.umlv.ir3.flexitime.configfile", "Conf.xml");
            
            //TODO pourquoi ça marche pas
            fichier = new BufferedReader(new FileReader(fileName));
            server = fichier.readLine();
        }
        catch (Exception e)
        {
            System.out.println("--------------------"+fileName); 
            throw new TraitementException("5");
        }
        System.out.println("--------------------"+server);   */        
        //return server;
        return "localhost";
    }
}
