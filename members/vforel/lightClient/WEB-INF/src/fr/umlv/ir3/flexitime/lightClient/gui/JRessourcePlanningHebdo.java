/*
 * Created on 21 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.lightClient.gui;

import java.awt.Color;
import java.util.Calendar;


import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.gui.models.BusyBloc;
import fr.umlv.ir3.flexitime.common.gui.models.RessourcePlanningHebdoModelAdapter;
import fr.umlv.ir3.flexitime.common.tools.Time;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - binou
 */
public class JRessourcePlanningHebdo 
{
    
    
    /**
     * Comment for <code>WEEK_WIDTH</code>
     */
    public static final int DATE_WIDTH = 120;
    /**
     * Comment for <code>DAY_COLUMN_WIDTH</code>
     */
    public static final int TIMEBLOC_WIDTH = 90;
    /**
     * Comment for <code>DAY_HEIGTH</code>
     */
    public static final int DATE_HEIGTH = 30;
    /**
     * Comment for <code>GAP_HEIGTH</code>
     */
    public static final int GAP_HEIGTH = 50;

    
    private RessourcePlanningHebdoModelAdapter model;

    
    String ligne = "";
    String ligneTmp = "";
    
    /**
     * Creates a new JRessourcePlanningHebdo, using the specified model
     * 
     * @param model the model to reprensents the data
     */
    public JRessourcePlanningHebdo(RessourcePlanningHebdoModelAdapter model)
    {
        super();
        
        this.model = model;

                
        //this.selectedItems = new ArrayList<JBusy>();
        
        this.init();

    }
    
    
    /** 
     * Initialyse the time table
     * Is only used at the creation
     * 
     * @author   FlexiTeam - binou
     */
    private void init()
    {
        ligne = ligne.concat("<table class=\"edt\" width=\"100%\">");
        this.createDayLign();
        this.createWeekColumn();
        ligne = ligne.concat("</table>");
    }
   
   
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * @return the adapter model
     *
     * 
     */
    public RessourcePlanningHebdoModelAdapter getModel()
    {
        // TODO Auto-generated method stub
        return this.model;
    }

    
 
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * 
     * 
     */
    public void increase()
    {
        model.increase();
        this.init();
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * 
     * 
     */
    public void decrease()
    {
        model.decrease();
        this.init();
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * 
     * 
     */
    public void stepOver()
    {
        model.stepOver();
        this.init();
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * 
     * 
     */
    public void stepBack()
    {
        model.stepBack();
        this.init();
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * 
     * 
     */
    public void fullStepOver()
    {
        model.fullStepOver();
        this.init();
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * 
     * 
     */
    public void fullStepBack()
    {
        model.fullStepBack();
        this.init();
    }
  
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     *
     * @return the html ligne
     * 
     */
    public String getLigne(){
        return ligne;
    }


    private void createDayLign()
    {
        ligne = ligne.concat("<tr><td  background=\"/res/header_r4_c5.jpg\"></td>");
        for (int i = 0 ; i < model.getNbDays() ; i++){
            ligne = ligne.concat("<td align=\"center\" width=\"20%\" background=\"/res/header_r4_c5.jpg\"><b>"+addDayHeader(i)+"</b></td>");
        }
        ligne = ligne.concat("</tr>");
    } 
    
    private void createWeekColumn()
    { 
        ligne = ligne.concat("<td valign=\"top\">"+addHourTable()+"</td>");
            for (int i = 0 ; i < model.getNbDays() ; i++)
            {
                ligne = ligne.concat("<td valign=\"top\" width=\"20%\">");
                this.fillLesson(0,i);
                ligne = ligne.concat("</td>");
            }
            ligne = ligne.concat("</tr>");
    }
   
    private String addHourTable(){
        String tmp ="";
        tmp = tmp.concat("<table class=\"hour\" cellpadding=\"0\" cellspacing=\"0\" width=\"120\">");
        for(int i=0; i<model.getNbBloc();i++){
            tmp = tmp.concat("<tr><td height=\"40\" align=\"center\" width=\"120\" bgcolor=\"#B4E6FD\">"+addGapHeader(i)+"</td></tr>");
        }
        tmp = tmp.concat("</table>");
        return tmp;
        
        
    }
    private void fillLesson(int k,int i)
    {
        ligne = ligne.concat("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">");
        int empty = 0;
        boolean is = false;
        for (int j = 0 ; j < model.getDayGapSize() ; j++){
            if(model.getElementAt(k,i,j) instanceof BusyBloc){
                if(empty > 0){
                    ligne = ligne.concat("<tr><td height=\""+(empty*20)+"\">&nbsp;</td></tr>");
                    empty = 0;
                }
                int gap = ((BusyBloc)model.getElementAt(k,i,j)).getNbGap() * 20;
                Color col = ((ILesson)((BusyBloc)model.getElementAt(k,i,j)).getBusy()).getCourse().getColor();
                String t = ColorToHexa(col);
                ligne = ligne.concat("<tr bgcolor=\"#"+t+"\"><td height=\""+gap+"\" align=\"center\">");
                ligne = ligne.concat(addGap(k,i,j)+"</td></tr>"); 
                is = true;
                empty=0;
            }else if(model.getElementAt(k,i,j)!=null){
                empty++;
            }
        }
        if(empty > 0 && is){
            ligne = ligne.concat("<tr><td height=\""+(empty*20)+"\">&nbsp;</td></tr>");
            empty = 0;
        }
        if(!is){
            ligne = ligne.concat("<tr><td height=\"160\">&nbsp;</td></tr>");
        }
        ligne = ligne.concat("</table>"); 
    }
    /*private String addWeekHeader(int weekNumber)
    {
        return getEDTCellHeader(model.getWeekHeaderAt(weekNumber),JRessourcePlanning.WEEK_HEADER);
    }*/
    private String getEDTCellHeader(Object object, int headerType)
    {
        String tmp = "";
        switch(headerType)
        {
            case JRessourcePlanning.WEEK_HEADER :
                if(object instanceof Integer)
                {
                    tmp = "sem. " + ((Integer)object).intValue();
                }
                break;
            case JRessourcePlanning.DAY_HEADER :
                if(object instanceof String)
                {
                    tmp = (String)object;  
                }
                break;
            case JRessourcePlanning.GAP_HEADER :
                if(object instanceof String)
                {
                    tmp = (String)object;
                }
                break;
            case JRessourcePlanning.DATE_HEADER :
                if(object instanceof Calendar)
                {
                    Time t = new Time((Calendar)object);
                    tmp = t.getStrDate();
                }
                break;
        }
        return tmp;
    }
    /*private String addDateHeader(int weekNumber, int dayNumber)
    {
        return getEDTCellHeader(model.getDateHeaderAt(weekNumber,dayNumber),JRessourcePlanning.DATE_HEADER);
    }*/
    private String addGapHeader(int blocNumber)
    {
        return getEDTCellHeader(model.getGapHeaderAt(blocNumber),JRessourcePlanning.GAP_HEADER);
    }
    private String addDayHeader(int dayNumber)
    {
       return getEDTCellHeader(model.getDayHeaderAt(dayNumber),JRessourcePlanning.DAY_HEADER);
    }
    private String addGap(int weekNumber, int dayNumber, int gapNumber)
    {
        return getEDTCell(model.getElementAt(weekNumber,dayNumber,gapNumber));
    }
    private String getEDTCell(Object elementAt)
    {
        String tmp = "";
        if(elementAt != null)
        {
            if(elementAt instanceof BusyBloc)
            {
                //nous sommes bien dans le cas d'un Busy à placer
                tmp = ((ILesson)((BusyBloc)elementAt).getBusy()).getCourse().getName() + " "
                + ((BusyBloc)elementAt).getBusy().getGap().getStartDate().getStrTime() + "/"
                + ((BusyBloc)elementAt).getBusy().getGap().getEndDate().getStrTime();
            }   
         }
         return tmp;
    }
    private String ColorToHexa(Color col){
        String red = Integer.toHexString(col.getRed());
        String blue = Integer.toHexString(col.getBlue());
        String green = Integer.toHexString(col.getGreen());
        if(red.length()!=2) red = "0"+red;
        if(green.length()!=2) green = "0"+green;
        if(blue.length()!=2) blue = "0"+blue;
        return red+green+blue;
    }

}

