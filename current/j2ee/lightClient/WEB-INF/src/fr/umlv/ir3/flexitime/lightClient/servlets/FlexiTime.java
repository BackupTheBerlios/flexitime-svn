/*
 * Created on 23 nov. 2004
 */
package fr.umlv.ir3.flexitime.lightClient.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
                //TODO regarder le type de perssonnes
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
        try
        {
            String path = getServletConfig().getServletContext().getRealPath("/");
            fileName = "Conf.xml";
            fichier = new BufferedReader(new FileReader(path+fileName));
            server = fichier.readLine();
        }
        catch (Exception e)
        {
            throw new TraitementException("5");
        }
        return server;
    }
}
