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
	public static final int DAY_COLUMN_WIDTH = 75;
	public static final int DAY_HEIGTH = 25;
	public static final int GAP_HEIGTH = 4;
	
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
    }

   
    /** 
     * Returns the model of the FlexiEDT
     *
     * @return the model used by the component
     * 
     * @see EDTModel
     * @author   FlexiTeam - binou
     */
    public EDTModel getModel()
    {
        return model;
    }



    /** 
     * Initialyse the time table
     * Is only used at the creation
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
     * Generate the week Header of the time table containing the number of each week
     * 
     * @author   FlexiTeam - binou
     */
    private void createWeekLign()
    {
        for (int i = 0 ; i < model.getNbWeeks() ; i++)
            addWeekHeader(i+1,0,i);  //+1 =+dayColumn
    } 
    
    /** 
     * Generate the first Column of the planning
     * containing : <br>
     * - the name of each day
     * - all gap's header
     * - each date of each days on each weeks
     * Is only used at the creation
     * 
     * @author   FlexiTeam - binou
     */
    private void createDayColumn()
    {
        int tempY;
        for (int i = 0 ; i < model.getNbDays()  ; i++)
        {
            tempY = i*(model.getNbGaps()+1)+1; //dernier +1 = +weekLign
            addDayHeader(0,tempY,i);
            for (int j = 0 ; j < model.getNbWeeks() ; j++)
                addDateHeader(j+1,tempY,j,i);
            int length;
            int cur = tempY+1;
            for (int j = 0 ; j < model.getNbBloc() ; j++)
            {
                length = model.getBlocSize(j);
                addGapHeader(0,cur,j,length);
                cur += length;
            }
        }
    }
    
    /** 
     * Generate the data in the planning :
     * - each Lessons
     * - each empty space (no lessons)
     * Is only used at the creation
     * 
     * @author   FlexiTeam - binou
     */
    private void fillLesson()
    {
        int tempY;
        for (int k = 0 ; k < model.getNbWeeks() ; k++)
        {
            for (int i = 0 ; i < model.getNbDays() ; i++)
            {
                tempY = i * (model.getNbGaps() + 1) + 1;
                for (int j = 0 ; j < model.getNbGaps() ; j++)
                    //addEmptyLesson(k, tempY + j);
                    addGap(k+1, (tempY+1)+j, k,i,j);
            }
        } 
    }
    
    /** 
     * DOCME Description
     * Add to the layout a week header at the specified coordinate
     * Is only used at the creation
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
     * Is only used at the creation
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
     * Is only used at the creation
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     * @param length
     * @param gapNumber the gap number of the header to add
     * 
     * @author   FlexiTeam - binou
     */
    private void addGapHeader(int x, int y, int blocNumber, int length)
    {
        //System.out.println("Ajout d'un header horaire en ["+x+","+y+"]");
        JComponent comp = cellHeaderRenderer.getEDTCellHeaderRendererComponent(this,model.getGapHeaderAt(blocNumber),EDTCellHeaderRenderer.GAP_HEADER);
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.gridheight = length;
        c.fill = GridBagConstraints.VERTICAL;
        add(comp, c);
    }


    /** 
     * DOCME Description
     * Add to the layout a day header at the specified coordinate
     * Is only used at the creation
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

        JComponent comp = cellRenderer.getEDTCellRendererComponent(this,model.getElementAt(weekNumber,dayNumber,gapNumber), weekNumber, dayNumber,gapNumber);
        int fusion = cellRenderer.getEDTCellRendererConstraint();
        if(comp != null)
        {
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = x;
            c.gridy = y;
            c.gridheight = fusion;
            c.fill = GridBagConstraints.VERTICAL;
            add(comp, c);
        }
        
        /*if(weekNumber == 0)
        {
            Object o = (model.getElementAt(weekNumber,dayNumber,gapNumber));
            if(o != null)
                System.out.println("["+ dayNumber + "," + gapNumber + ","+x+","+y+","+fusion+" ]=> " + o.getClass());
            else
                System.out.println("["+ dayNumber + "," + gapNumber + ","+x+","+y+","+fusion+" ]=> null");
        }*/
    }
    

}

