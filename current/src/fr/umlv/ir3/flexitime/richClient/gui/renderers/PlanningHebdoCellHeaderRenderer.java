/*
 * Created on 6 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.renderers;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;

import fr.umlv.ir3.flexitime.richClient.gui.panel.exploitation.JRessourcePlanningHebdo;



/**
 * Renders an item header in a Planning
 * 
 * @author FlexiTeam - binou
 */
public class PlanningHebdoCellHeaderRenderer
{
    /**
     * Comment for <code>DAY_HEADER</code>
     */
    public static final int DAY_HEADER = 1;
    /**
     * Comment for <code>TIMEBLOC_HEADER</code>
     */
    public static final int TIMEBLOC_HEADER = 2;

    private JLabel label = null;

    
    /** 
     * Return a component that has been configured to display the specified object. 
     * That component's paint method is then called to "render" the cell header in the planning
     *
     * @param edt the planning we're painting
     * @param object The object returned by edt.getModel().getElementAt(...)
     * @param headerType hte type of header we will have to paint
     * @param length 
     * @return A component whose paint() method will render the specified value
     * 
     * @see PlanningTrimCellRenderer
     */
    public JComponent getCellHeaderRendererComponent(JComponent edt, Object object, int headerType, int length)
    {
        
        switch(headerType)
        {
            case PlanningHebdoCellHeaderRenderer.DAY_HEADER :
                if(object instanceof String)
                {
                    String text = (String)object;
                    this.label = new JLabel();
                    this.label.setPreferredSize(new Dimension(JRessourcePlanningHebdo.DATE_WIDTH,JRessourcePlanningHebdo.DATE_HEIGTH));
                    this.label.setBackground(Color.decode("#483d8b"));
                    this.label.setText(text);
                }
                break;
            case PlanningHebdoCellHeaderRenderer.TIMEBLOC_HEADER :
                if(object instanceof String)
                {
                    String text = (String)object;
                    this.label = new JLabel();
                    this.label.setPreferredSize(new Dimension(JRessourcePlanningHebdo.TIMEBLOC_WIDTH,JRessourcePlanningHebdo.GAP_HEIGTH*length));
                    this.label.setBackground(Color.decode("#4682b4"));
                    this.label.setText(text);
                    this.label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
                break;
        }
        
        this.label.setOpaque(true);
        //this.label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return label;
    }

}

