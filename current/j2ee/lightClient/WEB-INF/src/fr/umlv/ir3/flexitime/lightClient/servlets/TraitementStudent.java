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
    private ITrack maTrack;
    private IClass maClass;
    private IGroup monGroup;
    private List<ITrack> mesTracks;
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
        String typeedt = request.getParameter("typeedt");
        String edtSalle = request.getParameter("edtsalle");
        String tracksubmit = request.getParameter("trackssubmit");
        String classsubmit = request.getParameter("classsubmit");
        String groupssubmit = request.getParameter("groupssubmit");
        String tracks = request.getParameter("tracks");
        String classs = request.getParameter("classes");
        String groups = request.getParameter("groups");
        
        if(login!=null){
            Gap g = getGap();
            if(stepbefore!=null){
                int numsemaine = Integer.parseInt(semaine);
                if(numsemaine>0){
                    numsemaine--;
                    g.getStartDate().addWeek(numsemaine);
                }
                //JRessourcePlanningHebdo fe = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter(MetierSimulatorSansRmi.getGroup2IR3(),g));
                //request.setAttribute("edt",fe.getLigne());
                request.setAttribute("listtracks",getSelectTracks(tracks));
                request.setAttribute("listclasses",getSelectClasses(classs));
                request.setAttribute("listgroups",getSelectGroups(groups));
                request.setAttribute("edt",getEDTGroup(g,"hebdo"));
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
                //JRessourcePlanningHebdo fe = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter(MetierSimulatorSansRmi.getGroup2IR3(),g));
                //request.setAttribute("edt",fe.getLigne());
                request.setAttribute("listtracks",getSelectTracks(tracks));
                request.setAttribute("listclasses",getSelectClasses(classs));
                request.setAttribute("listgroups",getSelectGroups(groups));
                request.setAttribute("edt",getEDTGroup(g,"hebdo"));
                request.setAttribute("semaine",String.valueOf(numsemaine));
                request.setAttribute("planning","hebdo");
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("typeedt","edt");
                jspName="/JAuth";
            }else if(switchvue!=null){
                if(planning.equals("hebdo")){                    
                    //JRessourcePlanning fe = new JRessourcePlanning(new RessourcePlanningModel(MetierSimulatorSansRmi.getGroup2IR3(),g));
                    //request.setAttribute("edt",fe.getLigne());
                    request.setAttribute("listtracks",getSelectTracks(tracks));
                    request.setAttribute("listclasses",getSelectClasses(classs));
                    request.setAttribute("listgroups",getSelectGroups(groups));
                    request.setAttribute("edt",getEDTGroup(g,"trim"));
                    request.setAttribute("semaine",semaine);
                    request.setAttribute("planning","trim");
                }else if(planning.equals("trim")){
                    int numsemaine = Integer.parseInt(semaine);
                    g.getStartDate().addWeek(numsemaine);
                    request.setAttribute("listtracks",getSelectTracks(tracks));
                    request.setAttribute("listclasses",getSelectClasses(classs));
                    request.setAttribute("listgroups",getSelectGroups(groups));
                    request.setAttribute("edt",getEDTGroup(g,"hebdo"));
                    //JRessourcePlanningHebdo fe = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter(MetierSimulatorSansRmi.getGroup2IR3(),g));
                    //request.setAttribute("edt",fe.getLigne());
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
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("semaine","0");
                request.setAttribute("planning","hebdo");
                request.setAttribute("typeedt","edt");
                request.setAttribute("listtracks",getSelectTracks(tracks));
                request.setAttribute("listclasses",getSelectClasses(classs));
                request.setAttribute("listgroups",null);
                request.setAttribute("edt",null);
                jspName="/JAuth";
            }else if(classsubmit!=null){
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("semaine","0");
                request.setAttribute("planning","hebdo");
                request.setAttribute("typeedt","edt");                
                request.setAttribute("listtracks",getSelectTracks(tracks));
                request.setAttribute("listclasses",getSelectClasses(classs));
                request.setAttribute("listgroups",getSelectGroups(groups));
                request.setAttribute("edt",null);
                jspName="/JAuth";
            }else if(groupssubmit!=null){
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("semaine","0");
                request.setAttribute("planning","hebdo");
                request.setAttribute("typeedt","edt");                
                request.setAttribute("listtracks",getSelectTracks(tracks));
                request.setAttribute("listclasses",getSelectClasses(classs));
                request.setAttribute("listgroups",getSelectGroups(groups));
                request.setAttribute("edt",getEDTGroup(g,"hebdo"));
                jspName="/JAuth";
            }else if(typeedt!=null){
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("semaine","0");
                request.setAttribute("planning","hebdo");
                request.setAttribute("typeedt","edt");                
                request.setAttribute("listtracks",getSelectTracks(tracks));
                request.setAttribute("listclasses",null);
                request.setAttribute("listgroups",null);
                request.setAttribute("edt",null);
                jspName="/JAuth";
            }else{
                try{
                    mesTracks = RemoteDataManager.getManager().getTracks();
                }catch(Exception e){
                    e.printStackTrace();                    
                }
                request.setAttribute("login",login);
                String longName = Authentification.getLongName(login);
                request.setAttribute("longName",longName);
                request.setAttribute("semaine","0");
                request.setAttribute("planning","hebdo");
                request.setAttribute("typeedt","edt");
                request.setAttribute("listtracks",getSelectTracks(tracks));
                request.setAttribute("listclasses",null);
                request.setAttribute("listgroups",null);
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
    
    private String getSelectTracks(String tracks){
        /*List<ITrack> listtracks = null;
        try{
            listtracks = RemoteDataManager.getManager().getTracks();
        }catch(Exception e){
            e.printStackTrace();                    
        }*/
        List<ITrack> listtracks = mesTracks;
        String ligne = "";
        if(listtracks!=null){
            ligne = ligne.concat("<select name=\"tracks\">");
            Iterator ittrack = listtracks.iterator();
            while(ittrack.hasNext()){
                ITrack t = (ITrack)ittrack.next();
                ligne = ligne.concat("<option value=\""+t.getIdData()+"\"");
                String tmp = String.valueOf(t.getIdData());
                if(tracks!=null && tmp.equals(tracks)){
                    maTrack = t;
                    //listclass = t.getLstClass();
                    ligne = ligne.concat(" selected ");
                    
                }
                ligne = ligne.concat(">"+t.getName());
            }
        }
        
        ligne = ligne.concat("</select>");
        return ligne;
    }
    
    private String getSelectClasses(String _class){
        List<IClass> listclasses = maTrack.getLstClass();
        String ligne = "";
        if(listclasses!=null){
            ligne = ligne.concat("<select name=\"classes\">");
            Iterator itclass = listclasses.iterator();
            while(itclass.hasNext()){
                IClass ic = (IClass)itclass.next();
                ligne = ligne.concat("<option value=\""+ic.getIdData()+"\"");
                String tmp = String.valueOf(ic.getIdData());
                if(_class!=null && tmp.equals(_class)){
                    maClass = ic;
                    ligne = ligne.concat(" selected ");
                    
                }
                ligne = ligne.concat(">"+ic.getName());
            }
        }
        
        ligne = ligne.concat("</select>");
        return ligne;
    }
    
    private String getSelectGroups(String groups){
        List<IGroup> listgroups = maClass.getLstGroups();
        String ligne = "";
        if(listgroups!=null){
            ligne = ligne.concat("<select name=\"groups\">");
            Iterator itgroup = listgroups.iterator();
            while(itgroup.hasNext()){
                IGroup ig = (IGroup)itgroup.next();
                ligne = ligne.concat("<option value=\""+ig.getIdData()+"\"");
                String tmp = String.valueOf(ig.getIdData());
                if(groups!=null && tmp.equals(groups)){
                    monGroup = ig;
                    ligne = ligne.concat(" selected ");
                    
                }
                ligne = ligne.concat(">"+ig.getName());
            }
        }
        
        ligne = ligne.concat("</select>");
        return ligne;
    }
    
    private String getEDTGroup(Gap g, String type){
        String ligne = "";
        if(type.equals("hebdo")){
            JRessourcePlanningHebdo fe = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter(monGroup,g));
            ligne = ligne.concat(fe.getLigne());
        }else{
            JRessourcePlanning fe = new JRessourcePlanning(new RessourcePlanningModel(monGroup,g));
            ligne = ligne.concat(fe.getLigne());
        }
        
        return ligne;
    }
}

