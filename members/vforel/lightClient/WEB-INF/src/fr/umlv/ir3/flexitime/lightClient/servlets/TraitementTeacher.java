/*
 * Created on 24 janv. 2005
 * by VF
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.lightClient.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.umlv.ir3.flexitime.common.gui.models.RessourcePlanningHebdoModelAdapter;
import fr.umlv.ir3.flexitime.common.gui.models.RessourcePlanningModel;
import fr.umlv.ir3.flexitime.common.tools.Gap;
import fr.umlv.ir3.flexitime.common.tools.MetierSimulatorSansRmi;
import fr.umlv.ir3.flexitime.lightClient.authentification.Authentification;
import fr.umlv.ir3.flexitime.lightClient.gui.JRessourcePlanning;
import fr.umlv.ir3.flexitime.lightClient.gui.JRessourcePlanningHebdo;


/**
 * DOCME Description
 * 
 * @author FlexiTeam - Administrateur
 */
public class TraitementTeacher extends HttpServlet{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3688791375315351602L;

    protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1)
        throws ServletException, IOException {
        doPost(arg0, arg1);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String jspName = "/JNoAuth";
        String stepbefore = request.getParameter("stepbefore");
        String stepafter = request.getParameter("stepafter");
        String switchvue = request.getParameter("switch");
        String login = request.getParameter("login");
        String semaine = request.getParameter("semaine");
        String planning = request.getParameter("planning");
        String edtSalle = request.getParameter("edtsalle");
        
        if(login!=null){
            Calendar c = Calendar.getInstance();
            c.setFirstDayOfWeek(Calendar.SATURDAY);
            c.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
            Calendar c2 = Calendar.getInstance();
            //TODO définir le nombre de semaine à afficher
            c2.setFirstDayOfWeek(Calendar.SATURDAY);
            c2.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
            c2.add(Calendar.WEEK_OF_YEAR,2);
            if(stepbefore!=null){
                int numsemaine = Integer.parseInt(semaine);
                if(numsemaine>0){
                    numsemaine--;
                    c.add(Calendar.WEEK_OF_YEAR,numsemaine);
                }
                Gap g = new Gap(c,c2);
                JRessourcePlanningHebdo fe = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter(MetierSimulatorSansRmi.getGroup2IR3(),g));
                request.setAttribute("edt",fe.getLigne());
                
                request.setAttribute("semaine",String.valueOf(numsemaine));
                request.setAttribute("planning","hebdo");
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("typeedt","edt");
                jspName="/JAuth";
            }else if(stepafter!=null){
                int numsemaine = Integer.parseInt(semaine);
                if(numsemaine<3){
                    numsemaine++;
                    c.add(Calendar.WEEK_OF_YEAR,numsemaine);
                }
                Gap g = new Gap(c,c2);
                JRessourcePlanningHebdo fe = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter(MetierSimulatorSansRmi.getGroup2IR3(),g));
                request.setAttribute("edt",fe.getLigne());
                request.setAttribute("semaine",String.valueOf(numsemaine));
                request.setAttribute("planning","hebdo");
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("typeedt","edt");
                jspName="/JAuth";
            }else if(switchvue!=null){
                if(planning.equals("hebdo")){
                    Gap g = new Gap(c,c2);
                    JRessourcePlanning fe = new JRessourcePlanning(new RessourcePlanningModel(MetierSimulatorSansRmi.getGroup2IR3(),g));
                    request.setAttribute("edt",fe.getLigne());
                    request.setAttribute("semaine",semaine);
                    request.setAttribute("planning","trim");
                }else if(planning.equals("trim")){
                    int numsemaine = Integer.parseInt(semaine);
                    c.add(Calendar.WEEK_OF_YEAR,numsemaine);
                    Gap g = new Gap(c,c2);
                    JRessourcePlanningHebdo fe = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter(MetierSimulatorSansRmi.getGroup2IR3(),g));
                    request.setAttribute("edt",fe.getLigne());
                    request.setAttribute("semaine",semaine);
                    request.setAttribute("planning","hebdo");
                }
                
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("typeedt","edt");
                
                jspName="/JAuth";
            }else if(edtSalle!=null){
                Gap g = new Gap(c,c2);
                //JRessourcesPlanning fe = new JRessourcesPlanning(new RessourcesPlanningModelAdapter(MetierSimulatorSansRmi.getSalles(),g));
                //request.setAttribute("edt",fe.getLigne());
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("semaine","0");
                request.setAttribute("planning","hebdo");
                request.setAttribute("typeedt","salles");
                jspName="/JAuth";
            }else{
                Gap g = new Gap(c,c2);
                JRessourcePlanningHebdo fe = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter(MetierSimulatorSansRmi.getGroup2IR3(),g));
                request.setAttribute("edt",fe.getLigne());
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("semaine","0");
                request.setAttribute("planning","hebdo");
                request.setAttribute("typeedt","edt");
                jspName="/JAuth";
            }
        }else{
            request.setAttribute("codeErreur","0");
            jspName = "/JNoAuth";
        }   
        request.setAttribute("typePerson","/TraitementTeacher");
        getServletContext().getRequestDispatcher(jspName).forward(request,response);
        
    }
}

