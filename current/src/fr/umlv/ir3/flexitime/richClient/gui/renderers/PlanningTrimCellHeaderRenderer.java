/*
 * Created on 6 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.renderers;


import java.awt.Color;
import java.awt.Dimension;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;

import fr.umlv.ir3.flexitime.common.tools.Time;
import fr.umlv.ir3.flexitime.richClient.gui.panel.exploitation.JRessourcePlanning;



/**
 * Renders an item header in a Planning
 * 
 * @author FlexiTeam - binou
 */
public class PlanningTrimCellHeaderRenderer
{
    /**
     * Comment for <code>WEEK_HEADER</code>
     */
    public static final int WEEK_HEADER = 0;
    /**
     * Comment for <code>DAY_HEADER</code>
     */
    public static final int DAY_HEADER = 1;
    /**
     * Comment for <code>GAP_HEADER</code>
     */
    public static final int GAP_HEADER = 2;
    /**
     * Comment for <code>DATE_HEADER</code>
     */
    public static final int DATE_HEADER = 3;
    private JLabel label = null;

    
    /** 
     * Return a component that has been configured to display the specified object. 
     * That component's paint method is then called to "render" the cell header in the planning
     *
     * @param edt the planning we're painting
     * @param object The object returned by edt.getModel().getElementAt(...)
     * @param headerType hte type of header we will have to paint
     * @param day 
     * @return A component whose paint() method will render the specified value
     * 
     * @see PlanningTrimCellRenderer
     */
    public JComponent getEDTCellHeaderRendererComponent(JRessourcePlanning edt, Object object, int headerType, int length)
    {
        
        switch(headerType)
        {
            case PlanningTrimCellHeaderRenderer.WEEK_HEADER :
                if(object instanceof Integer)
                {
                    Integer i = (Integer)object;
                    this.label = new JLabel();
                    this.label.setPreferredSize(new Dimension(JRessourcePlanning.WEEK_WIDTH,JRessourcePlanning.DAY_HEIGTH));
                    this.label.setBackground(Color.decode("#483d8b"));
                    this.label.setText("sem. " + i.intValue());
                }
                break;
            case PlanningTrimCellHeaderRenderer.DAY_HEADER :
                if(object instanceof String)
                {
                    String text = (String)object;
                    this.label = new JLabel();
                    this.label.setPreferredSize(new Dimension(JRessourcePlanning.DAY_COLUMN_WIDTH,JRessourcePlanning.DAY_HEIGTH));
                    this.label.setBackground(Color.decode("#483d8b"));
                    this.label.setText(text);
                }
                break;
            case PlanningTrimCellHeaderRenderer.GAP_HEADER :
                if(object instanceof String)
                {
                    String text = (String)object;
                    this.label = new JLabel();
                    this.label.setPreferredSize(new Dimension(JRessourcePlanning.DAY_COLUMN_WIDTH,JRessourcePlanning.GAP_HEIGTH*length ));
                    this.label.setBackground(Color.decode("#4682b4"));
                    this.label.setText(text);
                    this.label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
                break;
            case PlanningTrimCellHeaderRenderer.DATE_HEADER :
                if(object instanceof Calendar)
                {
                    Calendar calendar = (Calendar)object;
                    Time t = new Time(calendar);
                    this.label = new JLabel();
                    this.label.setPreferredSize(new Dimension(JRessourcePlanning.WEEK_WIDTH,JRessourcePlanning.DAY_HEIGTH));
                    this.label.setBackground(Color.decode("#4169e1"));
                    this.label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    this.label.setText(
                            t.getIDay() + " " + 
                            t.getStrMonth() + " " +
                            t.getYear()
                            );
                }
                break;
        }
        
        this.label.setOpaque(true);
        //this.label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return label;
    }

}

