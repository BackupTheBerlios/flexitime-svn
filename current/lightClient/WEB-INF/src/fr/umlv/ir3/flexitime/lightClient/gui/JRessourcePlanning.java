/*
 * Created on 4 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.lightClient.gui;

import java.awt.*;

import java.util.Calendar;
import java.util.Locale;


import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.gui.models.BusyBloc;
import fr.umlv.ir3.flexitime.common.gui.models.RessourcePlanningModel;
import fr.umlv.ir3.flexitime.common.tools.Gap;
import fr.umlv.ir3.flexitime.common.tools.Time;



/**
 * A component that allows the user to manage a planning
 * A separate model, <code>EDTModel</code>, represents the contents
 * of the planning.
 * 
 * @version 0.1
 * @see RessourcePlanningModel
 * 
 * @author FlexiTeam - binou
 */
public class JRessourcePlanning
{
	/**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3257283613144986167L;
    
    
    /**
     * Comment for <code>WEEK_WIDTH</code>
     */
    public static final int WEEK_WIDTH = 90;
	/**
	 * Comment for <code>DAY_COLUMN_WIDTH</code>
	 */
	public static final int DAY_COLUMN_WIDTH = 75;
	/**
	 * Comment for <code>DAY_HEIGTH</code>
	 */
	public static final int DAY_HEIGTH = 18;
	/**
	 * Comment for <code>GAP_HEIGTH</code>
	 */
	public static final int GAP_HEIGTH = 12;
    
    /**
     * Comment for <code>WEEK_HEADER</code>
     */
    public static final int WEEK_HEADER = 1;
    /**
     * Comment for <code>DAY_HEADER</code>
     */
    public static final int DAY_HEADER = 2;
    /**
     * Comment for <code>GAP_HEADER</code>
     */
    public static final int GAP_HEADER = 3;
    /**
     * Comment for <code>DATE_HEADER</code>
     */
    public static final int DATE_HEADER = 4;
	
    private RessourcePlanningModel model;
 
    String ligne = "";
    String ligneTmp = "";
    
    /**
     * Creates a new FlexiPlanning, using the specified model
     * 
     * @param model the model to reprensents the data
     */
    public JRessourcePlanning(RessourcePlanningModel model)
    {
        super();
 
        this.model = model;
 
        this.init();

    }

   
    /** 
     * Returns the model of the FlexiEDT
     *
     * @return the model used by the component
     * 
     * @see RessourcePlanningModel
     * @author   FlexiTeam - binou
     */
    public RessourcePlanningModel getModel()
    {
        return model;
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
     * Initialyse the time table
     * Is only used at the creation
     * 
     * @author   FlexiTeam - binou
     */
    private void init()
    {
        ligne = ligne.concat("<table class=\"edt\">");
        this.createWeekLign();
        this.createDayColumn();
        ligne = ligne.concat("</table>");
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

    private void createWeekLign()
    {
        ligne = ligne.concat("<tr><td colspan=\"2\" background=\"/res/header_r4_c5.jpg\"></td>");
        for (int i = 0 ; i < model.getNbWeeks() ; i++){
            ligne = ligne.concat("<td align=\"center\" background=\"/res/header_r4_c5.jpg\">"+addWeekHeader(i)+"</td>");
        }
        ligne = ligne.concat("</tr>");
    } 
   
    private void createDayColumn()
    { 
        for (int i = 0 ; i < model.getNbDays()  ; i++)
        {
            ligne = ligne.concat("<tr><td width=\"50\" align=\"center\" background=\"/res/header_r4_c5.jpg\">"+addDayHeader(i)+"</td>");
            ligne = ligne.concat("<td valign=\"top\">"+addHourTable()+"</td>");
            for (int k = 0 ; k < model.getNbWeeks() ; k++)
            {
                ligne = ligne.concat("<td valign=\"top\">");
                this.fillLesson(k,i);
                ligne = ligne.concat("</td>");
            }
            ligne = ligne.concat("</tr>");
        }
    }
    private String addHourTable(){
        String tmp ="";
        tmp = tmp.concat("<table class=\"hour\" cellpadding=\"0\" cellspacing=\"0\" width=\"120\">");
        tmp = tmp.concat("<tr><td height=\"20\" align=\"center\" width=\"120\">&nbsp;</td></tr>");
        for(int i=0; i<model.getNbBloc();i++){
            tmp = tmp.concat("<tr><td height=\"40\" align=\"center\" width=\"120\" bgcolor=\"#B4E6FD\">"+addGapHeader(i)+"</td></tr>");
        }
        tmp = tmp.concat("</table>");
        return tmp;
    }
    private void fillLesson(int k,int i)
    {
        ligne = ligne.concat("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"180\">");
        ligne = ligne.concat("<tr><td align=\"center\" height=\"20\" bgcolor=\"#BAC9DC\"><b><font size=\"2\">"+addDateHeader(k,i)+"</font></b></td></tr>");
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
    private String addWeekHeader(int weekNumber)
    {
        return getEDTCellHeader(model.getWeekHeaderAt(weekNumber),JRessourcePlanning.WEEK_HEADER);
    }
    private String getEDTCellHeader(Object object, int headerType)
    {
        String tmp = "";
        switch(headerType)
        {
            case JRessourcePlanning.WEEK_HEADER :
                if(object instanceof Integer)
                {        
                    tmp = "semaine " + ((Integer)object).intValue();
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
    private String addDateHeader(int weekNumber, int dayNumber)
    {
        return getEDTCellHeader(model.getDateHeaderAt(weekNumber,dayNumber),JRessourcePlanning.DATE_HEADER);
    }
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

