/*
 * Created on 16 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.actions.bar;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;

import fr.umlv.ir3.flexitime.richClient.gui.Client;
import fr.umlv.ir3.flexitime.richClient.gui.panel.exploitation.ExploitationView;


/**
 * An action implementation useful for moving backward to view the timetable of the previous week.
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class PreviousWeekAction extends AbstractAction
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3257847679773062195L;
    private static PreviousWeekAction action;
    private static Icon icon = Client.getIcon(Client.class, "pictures/_back.png");
    
    private static ExploitationView view;
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return an action
     */
    public static PreviousWeekAction getInstance()
    {
        if(action==null)
            action = new PreviousWeekAction();
        
        return action;
    }

    protected PreviousWeekAction()
    {
        super("Reculer d'une semaine", icon);
    }
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param e 
     * 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e)
    {
        view.stepBack();
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param _view 
     * 
     */
    public static void setView(ExploitationView _view)
    {
        view = _view;        
    }
}

