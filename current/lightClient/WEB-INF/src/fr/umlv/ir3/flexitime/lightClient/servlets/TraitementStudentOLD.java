/*
 * Created on 24 janv. 2005
 * by VF
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.lightClient.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
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
public class TraitementStudentOLD extends HttpServlet{
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
        String tracksubmit = request.getParameter("trackssubmit");
        String classsubmit = request.getParameter("classsubmit");
        String tracks = request.getParameter("tracks");
        String classs = request.getParameter("classs");
        
        if(login!=null){
            Gap g = getGap();
            if(stepbefore!=null){
                int numsemaine = Integer.parseInt(semaine);
                if(numsemaine>0){
                    numsemaine--;
                    g.getStartDate().addWeek(numsemaine);
                }
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
                    g.getStartDate().addWeek(numsemaine);
                    
                }
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
                    JRessourcePlanning fe = new JRessourcePlanning(new RessourcePlanningModel(MetierSimulatorSansRmi.getGroup2IR3(),g));
                    request.setAttribute("edt",fe.getLigne());
                    request.setAttribute("semaine",semaine);
                    request.setAttribute("planning","trim");
                }else if(planning.equals("trim")){
                    int numsemaine = Integer.parseInt(semaine);
                    g.getStartDate().addWeek(numsemaine);
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
                //TODO
                //JRessourcesPlanning fe = new JRessourcesPlanning(new RessourcesPlanningModel(MetierSimulatorSansRmi.get2017(),g));
                //request.setAttribute("edt",fe.getLigne());
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("semaine","0");
                request.setAttribute("planning","hebdo");
                request.setAttribute("typeedt","salles");
                jspName="/JAuth";
            }else if(tracksubmit!=null){
                //TODO
                //JRessourcePlanningHebdo fe = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter(MetierSimulatorSansRmi.getGroup2IR3(),g));
                //request.setAttribute("edt",fe.getLigne());
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("semaine","0");
                request.setAttribute("planning","hebdo");
                request.setAttribute("typeedt","edt");
                List<ITrack> listtracks = null;
                try{
                    listtracks = RemoteDataManager.getManager().getTracks();
                }catch(Exception e){
                    e.printStackTrace();                    
                }

                String ligne = "<select name=\"tracks\">";

                List<IClass> listclass = null;
                if(listtracks!=null){
                    Iterator ittrack = listtracks.iterator();
                    while(ittrack.hasNext()){
                        ITrack t = (ITrack)ittrack.next();
                        ligne = ligne.concat("<option value=\""+t.getIdData()+"\"");
                        String tmp = String.valueOf(t.getIdData());
                        if(tmp.equals(tracks)){
                            try{
                                System.out.println(t.getName());
                                listclass = t.getLstClass();
                                ligne = ligne.concat(" selected ");
                            }catch(Exception e){
                                e.printStackTrace();                    
                            }
                        }
                        ligne = ligne.concat(">"+t.getName());
                    }
                }
                
                ligne = ligne.concat("</select>");
                request.setAttribute("listtracks",ligne);
                
                //----les promotions
                
                String ligne2 = "<select name=\"classs\">";
                if(listclass!=null){
                    Iterator itclass = listclass.iterator();
                    while(itclass.hasNext()){
                        IClass ic = (IClass)itclass.next();
                        ligne2 = ligne2.concat("<option value=\""+ic.getIdData()+"\">"+ic.getName());
                    }
                }
                
                ligne2 = ligne2.concat("</select>");
                request.setAttribute("listclass",ligne2);
                request.setAttribute("edt",null);
                jspName="/JAuth";
            }else if(classsubmit!=null){
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("semaine","0");
                request.setAttribute("planning","hebdo");
                request.setAttribute("typeedt","edt");
                List<ITrack> listtracks = null;
                try{
                    listtracks = RemoteDataManager.getManager().getTracks();
                }catch(Exception e){
                    e.printStackTrace();                    
                }

                String ligne = "<select name=\"tracks\">";

                List<IClass> listclass = null;
                if(listtracks!=null){
                    Iterator ittrack = listtracks.iterator();
                    while(ittrack.hasNext()){
                        ITrack t = (ITrack)ittrack.next();
                        ligne = ligne.concat("<option value=\""+t.getIdData()+"\"");
                        String tmp = String.valueOf(t.getIdData());
                        if(tmp.equals(tracks)){
                            try{
                                System.out.println(t.getName());
                                listclass = t.getLstClass();
                                ligne = ligne.concat(" selected ");
                            }catch(Exception e){
                                e.printStackTrace();                    
                            }
                        }
                        ligne = ligne.concat(">"+t.getName());
                    }
                }
                
                ligne = ligne.concat("</select>");
                request.setAttribute("listtracks",ligne);
                
                //----les promotions
                List<IGroup> listgroup = null;
                String ligne2 = "<select name=\"classs\">";
                if(listclass!=null){
                    Iterator itclass = listclass.iterator();
                    while(itclass.hasNext()){
                        IClass ic = (IClass)itclass.next();
                        ligne2 = ligne2.concat("<option value=\""+ic.getIdData()+"\"");
                        String tmp = String.valueOf(ic.getIdData());
                        if(tmp.equals(classs)){
                            try{
                                System.out.println(ic.getName());
                                listgroup = ic.getLstGroups();
                                ligne2 = ligne2.concat(" selected ");
                            }catch(Exception e){
                                e.printStackTrace();                    
                            }
                        }
                        ligne2 = ligne2.concat(">"+ic.getName());
                    }
                }
                
                ligne2 = ligne2.concat("</select>");
                request.setAttribute("listclass",ligne2);
                
                
                String ligne3 = "";
                if(listgroup!=null){
                    Iterator itgroup = listgroup.iterator();
                    while(itgroup.hasNext()){
                        JRessourcePlanningHebdo fe = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter((IGroup)itgroup.next(),g));
                        ligne3 = ligne3.concat(fe.getLigne());
                    }
                }
                request.setAttribute("edt",ligne3);
                jspName="/JAuth";

            }else{
                //JRessourcePlanningHebdo fe = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter(MetierSimulatorSansRmi.getGroup2IR3(),g));
                //request.setAttribute("edt",fe.getLigne());
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("semaine","0");
                request.setAttribute("planning","hebdo");
                request.setAttribute("typeedt","edt");
                            
                ArrayList listtracks = null;
                try{
                    listtracks = (ArrayList) RemoteDataManager.getManager().getTracks();
                }catch(Exception e){
                    e.printStackTrace();                    
                }

                String ligne = "<select name=\"tracks\">";
                if(listtracks!=null){
                    Iterator ittrack = listtracks.iterator();
                    while(ittrack.hasNext()){
                        ITrack t = (ITrack)ittrack.next();
                        ligne = ligne.concat("<option value=\""+t.getIdData()+"\">"+t.getName());
                    }
                }
                
                ligne = ligne.concat("</select>");
                request.setAttribute("listtracks",ligne);
                request.setAttribute("listclass",null);
                request.setAttribute("edt",null);

                jspName="/JAuth";
            }
        }else{
            request.setAttribute("codeErreur","0");
            jspName = "/JNoAuth";
        }  
        request.setAttribute("typePerson","/TraitementStudent");
        getServletContext().getRequestDispatcher(jspName).forward(request,response);
        
    }
    
    private Gap getGap(){
        Calendar c = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c2.add(Calendar.WEEK_OF_YEAR,2);
        Time t1 = new Time(c);
        Time t2 = new Time(c2);
        if(t1.getIDayOfWeek()==5) {
            t1.addDay(2);t2.addDay(2);
        }
        if(t1.getIDayOfWeek()==6) {
            t1.addDay(1);t2.addDay(2);
        }
        t1.addDay(-t1.getIDayOfWeek());
        t2.addDay(-t2.getIDayOfWeek()); 
        return new Gap(t1,t2);
    }
}

