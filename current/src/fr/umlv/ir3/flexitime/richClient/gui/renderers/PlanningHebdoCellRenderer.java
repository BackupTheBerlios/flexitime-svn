/*
 * Created on 6 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.renderers;




import javax.swing.JComponent;

import fr.umlv.ir3.flexitime.common.gui.models.BusyBloc;
import fr.umlv.ir3.flexitime.richClient.gui.panel.exploitation.JBusy;
import fr.umlv.ir3.flexitime.richClient.gui.panel.exploitation.JRessourcePlanningHebdo;



/**
 * Renders an item in a Planning
 * 
 * @author FlexiTeam - binou
 */
public class PlanningHebdoCellRenderer
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
     * @see PlanningTrimCellRenderer
     */
    public JComponent getCellRendererComponent(JComponent flexiEDT, Object elementAt, int day, int gap)
    {
        this.comp = null;
        if(elementAt != null)
        {
            if(elementAt instanceof BusyBloc)
            {
                //nous sommes bien dans le cas d'un Busy à placer
                comp = new JBusy( (BusyBloc)elementAt , JRessourcePlanningHebdo.DATE_WIDTH, JRessourcePlanningHebdo.GAP_HEIGTH); 
            }   
            else
            {
                //cas d'un créneau vide à placer
                comp = new JBusy(JRessourcePlanningHebdo.DATE_WIDTH, JRessourcePlanningHebdo.GAP_HEIGTH);
            }
        }
        
       
        return comp;
    }

    


}


