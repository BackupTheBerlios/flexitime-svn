/*
 * Created on 4 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.GL.test.edt;

import java.awt.*;
import javax.swing.*;

import fr.umlv.ir3.GL.test.edt.model.EDTModel;
import fr.umlv.ir3.GL.test.edt.renderer.EDTCellHeaderRenderer;
import fr.umlv.ir3.GL.test.edt.renderer.EDTCellRenderer;



/**
 * DOCME Description
 * 
 * A component that allows the user to manage a planning
 * A separate model, <code>EDTModel</code>, represents the contents
 * of the planning.
 * 
 * @version 0.1
 * @see model.EDTModel
 * @see renderer.EDTCellRenderer
 * @see renderer.EDTCellHeaderRenderer
 * 
 * @author FlexiTeam - binou
 */
public class FlexiEDT extends JPanel
{
	public static final int WEEK_WIDTH = 75;
	public static final int DAY_HEIGTH = 25;
	public static final int GAP_HEIGTH = 10;
	
	private JGap gap;
	
	
    private EDTModel model;
    private EDTCellRenderer cellRenderer;
    private EDTCellHeaderRenderer cellHeaderRenderer;

    public FlexiEDT(EDTModel model)
    {
        super(new GridBagLayout());
        setLayout(new GridBagLayout());
        
        this.model = model;
        this.cellRenderer = new EDTCellRenderer();
        this.cellHeaderRenderer = new EDTCellHeaderRenderer();
        
        this.init();
        //this.initGapOnEDT_Debug();
        
    }

   




    /** 
     * DOCME Description
     * Initialyse the Planning
     * 
     * @author   FlexiTeam - binou
     */
    private void init()
    {
        this.createWeekLign();
        this.createDayColumn();
        this.fillLesson();
    }
    

    /** 
     * DOCME Description
     * Generate the week Header of the planning containing the number of each week
     * 
     * @author   FlexiTeam - binou
     */
    private void createWeekLign()
    {
        for (int i = 1 ; i <= model.getNbWeeks() ; i++)
            addWeekHeader(i,0,i);
    } 
    
    /** 
     * DOCME Description
     * Generate the first Column of the planning
     * containing : <br>
     * - the name of each day
     * - all gap's header
     * - each date of each days on each weeks
     * 
     * @author   FlexiTeam - binou
     */
    private void createDayColumn()
    {
        int tempY;
        for (int i = 0 ; i < model.getNbDays()  ; i++)
        {
            tempY = i*(model.getNbGaps()+1)+1;
            addDayHeader(0,tempY,i);
            for (int j = 1 ; j <= model.getNbWeeks() ; j++)
                addDateHeader(j,tempY,j,i);
            for (int j = 1 ; j <= model.getNbGaps() ; j++)
                addGapHeader(0,tempY+j,j);
        }
    }
    
    /** 
     * DOCME Description
     * Generate the data in the planning :
     * - each Lessons
     * - each empty space (no lessons)
     * 
     * @author   FlexiTeam - binou
     */
    private void fillLesson()
    {
        int tempY;
        for (int k = 1 ; k <= model.getNbWeeks() ; k++)
        {
            for (int i = 0 ; i < model.getNbDays() ; i++)
            {
                tempY = i * (model.getNbGaps() + 1) + 1;
                for (int j = 1 ; j <= model.getNbGaps() ; j++)
                    //addEmptyLesson(k, tempY + j);
                    addGap(k, tempY+j, k,i+1,j);
            }
        }
    }
    
    



    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param weekNumber
     * @param dayNumber
     * @param gapNumber 
     * 
     * @see (si nécessaire)
     * @author   FlexiTeam - binou
     */
    private void addGap(int x, int y, int weekNumber, int dayNumber, int gapNumber)
    {
        JComponent comp = cellRenderer.getEDTCellRendererComponent(this,model.getElementAt(weekNumber,dayNumber,gapNumber));
        int fusion = cellRenderer.getEDTCellRendererConstraint();
        /*if(comp != null)
        {
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = x;
            c.gridy = y;
            c.gridheight = fusion;
            c.fill = GridBagConstraints.VERTICAL;
            add(comp, c);
            System.out.println("add en ["+x+","+y+","+fusion+"]=>"+comp);
        }
        else
            System.out.println("null");*/
    }






    /** 
     * DOCME Description
     * Add to the layout a week header at the specified coordinate
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     * @param weekNumber the column number of the header to add
     * 
     * @author   FlexiTeam - binou
     */
    private void addWeekHeader(int x, int y, int weekNumber)
    {
        //System.out.println("Ajout d'un header semaine en ["+x+","+y+"]");
        
        JComponent comp = cellHeaderRenderer.getEDTCellHeaderRendererComponent(this,model.getWeekHeaderAt(weekNumber),EDTCellHeaderRenderer.WEEK_HEADER);
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        add(comp, c);
    }
    

    /** 
     * DOCME Description
     * Add to the layout a date header at the specified coordinate
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     * @param weekNumber the week number of the date to add
     * @param dayNumber the day number of the header to add
     * 
     * @author   FlexiTeam - binou
     */
    private void addDateHeader(int x, int y, int weekNumber, int dayNumber)
    {
        //System.out.println("Ajout d'un header jour/semaine en ["+x+","+y+"]");
        
        JComponent comp = cellHeaderRenderer.getEDTCellHeaderRendererComponent(this,model.getDateHeaderAt(weekNumber,dayNumber),EDTCellHeaderRenderer.DATE_HEADER);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        add(comp, c);
    }
    


    /** 
     * DOCME Description
     * Add to the layout a gap header at the specified coordinate
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     * @param gapNumber the gap number of the header to add
     * 
     * @author   FlexiTeam - binou
     */
    private void addGapHeader(int x, int y, int gapNumber)
    {
        //System.out.println("Ajout d'un header horaire en ["+x+","+y+"]");
        JComponent comp = cellHeaderRenderer.getEDTCellHeaderRendererComponent(this,model.getGapHeaderAt(gapNumber),EDTCellHeaderRenderer.GAP_HEADER);
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        add(comp, c);
    }


    /** 
     * DOCME Description
     * Add to the layout a day header at the specified coordinate
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     * @param dayNumber - the day number of the header to add
     * 
     * @see (si nécessaire)
     * @author   FlexiTeam - binou
     */
    private void addDayHeader(int x, int y, int dayNumber)
    {
       //System.out.println("Ajout d'un header jour en ["+x+","+y+"]");
       JComponent comp = cellHeaderRenderer.getEDTCellHeaderRendererComponent(this,model.getDayHeaderAt(dayNumber),EDTCellHeaderRenderer.DAY_HEADER);
       
       GridBagConstraints c = new GridBagConstraints();
       c.gridx = x;
       c.gridy = y;
       add(comp, c);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //********************************************
    // 					DEBUG
    //********************************************
    
    private void addEmptyLesson(int x, int y)
    {
        System.out.println("Ajout d'une seance vide en ["+x+","+y+"]");
        gap = new JGap("",Color.WHITE,WEEK_WIDTH,GAP_HEIGTH);
        addGap(gap,x,y);
    }

    private void addGap(JGap gap2,int x, int y)
    {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        add(gap2, c);
    }
    
    private void addMultiGap(JGap gap2,int x, int y, int length)
    {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.gridheight = length;
        c.fill = GridBagConstraints.VERTICAL;
        add(gap2, c);
    }
    
    private void initGapOnEDT_Debug()
    {
        JGap.setDefaultGapSize(FlexiEDT.WEEK_WIDTH, FlexiEDT.GAP_HEIGTH);
        
        JButton button;
        JGap emptyGap;
        

        
        gap = new JGap("Corba",Color.RED,WEEK_WIDTH,GAP_HEIGTH);
        addMultiGap(gap,2,24,2);
        gap = new JGap("J2EE",Color.GREEN,WEEK_WIDTH,GAP_HEIGTH);
        addMultiGap(gap,4,22,2);
        gap = new JGap("SNA",Color.PINK,WEEK_WIDTH,GAP_HEIGTH);
        addMultiGap(gap,2,22,1);
        gap = new JGap("ProjetGL",Color.YELLOW,WEEK_WIDTH,GAP_HEIGTH);
        addMultiGap(gap,1,24,2);
        
        gap = new JGap("",Color.WHITE,WEEK_WIDTH,GAP_HEIGTH);
        addGap(gap,1,22);
        gap = new JGap("",Color.WHITE,WEEK_WIDTH,GAP_HEIGTH);
        addGap(gap,1,23);
        gap = new JGap("",Color.WHITE,WEEK_WIDTH,GAP_HEIGTH);
        addGap(gap,2,23);
        for (int i = 0 ; i < 4 ; i++)
        {
            gap = new JGap("",Color.WHITE,WEEK_WIDTH,GAP_HEIGTH);
            addGap(gap,3,22+i);
            
        }
        for (int i = 0 ; i < 4 ; i++)
        {
            gap = new JGap("",Color.WHITE,WEEK_WIDTH,GAP_HEIGTH);
            addGap(gap,5,22+i);
            
        }
        gap = new JGap("",Color.WHITE,WEEK_WIDTH,GAP_HEIGTH);
        addGap(gap,4,24);
        gap = new JGap("",Color.WHITE,WEEK_WIDTH,GAP_HEIGTH);
        addGap(gap,4,25);
    }
    public EDTModel getModel()
    {
        return model;
    }
}

