/*
 * Created on 24 janv. 2005
 * by VF
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.lightClient.servlets;

import java.io.IOException;
import java.rmi.RMISecurityManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.gui.models.RessourcePlanningHebdoModelAdapter;
import fr.umlv.ir3.flexitime.common.gui.models.RessourcePlanningModel;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.common.tools.Gap;
import fr.umlv.ir3.flexitime.common.tools.MetierSimulatorSansRmi;
import fr.umlv.ir3.flexitime.common.tools.Time;
import fr.umlv.ir3.flexitime.lightClient.authentification.Authentification;
import fr.umlv.ir3.flexitime.lightClient.gui.JRessourcePlanning;
import fr.umlv.ir3.flexitime.lightClient.gui.JRessourcePlanningHebdo;


/**
 * DOCME Description
 * 
 * @author FlexiTeam - Administrateur
 */
public class TraitementStudent extends HttpServlet{
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
        String tracksubmit = request.getParameter("tracksubmit");
        String classsubmit = request.getParameter("classsubmit");
        String tracks = request.getParameter("tracks");
        String classs = request.getParameter("classs");
        
        if(login!=null){
            Calendar c = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            //TODO définir le nombre de semaine à afficher
            c2.add(Calendar.WEEK_OF_YEAR,2);
            Time t1 = new Time(c);
            Time t2 = new Time(c2);
            t1.addDay(-t1.getIDayOfWeek());
            t2.addDay(-t2.getIDayOfWeek());
            if(stepbefore!=null){
                int numsemaine = Integer.parseInt(semaine);
                if(numsemaine>0){
                    numsemaine--;
                    t1.addWeek(numsemaine);
                }
                JRessourcePlanningHebdo fe = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter(MetierSimulatorSansRmi.getGroup2IR3(),new Gap(t1,t2)));
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
                    t1.addWeek(numsemaine);
                    
                }
                JRessourcePlanningHebdo fe = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter(MetierSimulatorSansRmi.getGroup2IR3(),new Gap(t1,t2)));
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
                    JRessourcePlanning fe = new JRessourcePlanning(new RessourcePlanningModel(MetierSimulatorSansRmi.getGroup2IR3(),new Gap(t1,t2)));
                    request.setAttribute("edt",fe.getLigne());
                    request.setAttribute("semaine",semaine);
                    request.setAttribute("planning","trim");
                }else if(planning.equals("trim")){
                    int numsemaine = Integer.parseInt(semaine);
                    t1.addWeek(numsemaine);
                    JRessourcePlanningHebdo fe = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter(MetierSimulatorSansRmi.getGroup2IR3(),new Gap(t1,t2)));
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
                //JRessourcesPlanning fe = new JRessourcesPlanning(new RessourcesPlanningModelAdapter(MetierSimulatorSansRmi.getSalles(),new Gap(t1,t2)));
                //request.setAttribute("edt",fe.getLigne());
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("semaine","0");
                request.setAttribute("planning","hebdo");
                request.setAttribute("typeedt","salles");
                jspName="/JAuth";
            }else if(tracksubmit!=null){
                JRessourcePlanningHebdo fe = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter(MetierSimulatorSansRmi.getGroup2IR3(),new Gap(t1,t2)));
                request.setAttribute("edt",fe.getLigne());
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("semaine","0");
                request.setAttribute("planning","hebdo");
                request.setAttribute("typeedt","edt");
                /*ArrayList listtracks = null;
                try{
                    listtracks = (ArrayList) RemoteDataManager.getManager().getTracks();
                }catch(Exception e){
                    e.printStackTrace();                    
                }

                String ligne = "<select name=\"tracks\">";
                if(listtracks!=null){
                    Iterator ittrack = listtracks.iterator();
                    while(ittrack.hasNext()){
                        ligne = ligne.concat("<option value=\""+((ITrack)ittrack.next()).getName()+"\">");
                    }
                }
                
                ligne = ligne.concat("</select>");
                request.setAttribute("listtracks",ligne);*/
                //----les promotions
                /*ArrayList listclass = null;
                try{
                    listclass = (ArrayList) RemoteDataManager.getManager().getClass();
                }catch(Exception e){
                    e.printStackTrace();                    
                }

                String ligne2 = "<select name=\"classs\">";
                if(listclass!=null){
                    Iterator itclass = listclass.iterator();
                    while(itclass.hasNext()){
                        ligne2 = ligne2.concat("<option value=\""+((IClass)itclass.next()).getName()+"\">");
                    }
                }
                
                ligne = ligne.concat("</select>");
                request.setAttribute("listclass",ligne2);*/
                jspName="/JAuth";
            }else if(classsubmit!=null){
                Gap g = new Gap(t1,t2);
                /*ArrayList listclass = null;
                try{
                    listgroup = (ArrayList) RemoteDataManager.getManager().getGroup();
                }catch(Exception e){
                    e.printStackTrace();                    
                }

                String ligne = "";
                if(listgroup!=null){
                    Iterator itgroup = listgroup.iterator();
                    while(itgroup.hasNext()){
                        //JRessourcePlanningHebdo fe = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter((IGroup)itgroup.next(),g));
                        ligne = ligne.concat(fe.getLigne());
                    }
                }*/
                //request.setAttribute("edt",ligne);
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("semaine","0");
                request.setAttribute("planning","hebdo");
                request.setAttribute("typeedt","edt");
            }else{
                JRessourcePlanningHebdo fe = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter(MetierSimulatorSansRmi.getGroup2IR3(),new Gap(t1,t2)));
                request.setAttribute("edt",fe.getLigne());
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("semaine","0");
                request.setAttribute("planning","hebdo");
                request.setAttribute("typeedt","edt");
                /*ArrayList listtracks = null;
                try{
                    listtracks = (ArrayList) RemoteDataManager.getManager().getTracks();
                }catch(Exception e){
                    e.printStackTrace();                    
                }

                String ligne = "<select name=\"tracks\">";
                if(listtracks!=null){
                    Iterator ittrack = listtracks.iterator();
                    while(ittrack.hasNext()){
                        ligne = ligne.concat("<option value=\""+((ITrack)ittrack.next()).getName()+"\">");
                    }
                }
                
                ligne = ligne.concat("</select>");
                request.setAttribute("listtracks",ligne);*/
                jspName="/JAuth";
            }
        }else{
            request.setAttribute("codeErreur","0");
            jspName = "/JNoAuth";
        }  
        request.setAttribute("typePerson","/TraitementStudent");
        getServletContext().getRequestDispatcher(jspName).forward(request,response);
        
    }
}

