/*
 * Created on 6 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.renderers;




import javax.swing.JComponent;

import fr.umlv.ir3.flexitime.richClient.gui.panel.exploitation.FlexiPlanning;
import fr.umlv.ir3.flexitime.richClient.gui.panel.exploitation.JLesson;
import fr.umlv.ir3.flexitime.richClient.gui.panel.exploitation.LessonBloc;



/**
 * Renders an item in a Planning
 * 
 * @author FlexiTeam - binou
 */
public class EDTCellRenderer
{
    private JComponent comp = null;


    /** 
     * Return a component that has been configured to display the specified object. 
     * That component's paint method is then called to "render" the cell in the planning
     *
     * @param flexiEDT the planning we're painting
     * @param elementAt The object returned by edt.getModel().getElementAt(...)
     * @param week the week of the cell to be paint
     * @param day the day of the cell to be paint
     * @param gap the day's gap of the cell to be paint
     * @return A component whose paint() method will render the specified value
     * 
     * @see EDTCellRenderer
     */
    public JComponent getEDTCellRendererComponent(FlexiPlanning flexiEDT, Object elementAt, int week, int day, int gap)
    {
        this.comp = null;
        if(elementAt != null)
        {
            if(elementAt instanceof LessonBloc)
            {
                //nous sommes bien dans le cas d'un Busy à placer
                comp = new JLesson( (LessonBloc)elementAt ); 
            }   
            else
            {
                //cas d'un créneau vide à placer
                comp = new JLesson();
                /*JLabel label = new JLabel();
                label.setText("");
                label.setBackground(Color.WHITE);
                label.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                label.setPreferredSize(new Dimension(FlexiEDT.WEEK_WIDTH,FlexiEDT.GAP_HEIGTH*1));
                label.setOpaque(true);
                
                
                comp = label;*/
                
                /*if(week%2 == 0 && gap%2 == 0)
                    this.label.setBackground(FlexiColor.getColor(FlexiColor.lightblue));
                else
                {
                    if(week%2 == 1 && gap%2 == 1)
                        this.label.setBackground(FlexiColor.getColor(FlexiColor.lightblue));
                    else
                        this.label.setBackground(FlexiColor.getColor(FlexiColor.lightsteelblue));
                }*/
            }
        }
        
       
        return comp;
    }

    


}

