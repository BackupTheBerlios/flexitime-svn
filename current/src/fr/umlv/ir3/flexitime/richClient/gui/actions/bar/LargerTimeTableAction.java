/*
 * Created on 20 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.actions.bar;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;

import fr.umlv.ir3.flexitime.richClient.gui.Client;
import fr.umlv.ir3.flexitime.richClient.gui.panel.exploitation.ExploitationView;


/**
 * An action implementation useful for encreasing the number of weeks included in the 
 * timetable of the exploitation view.
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class LargerTimeTableAction extends AbstractAction
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3904960871661910327L;
    private static LargerTimeTableAction action;
    private static Icon icon = Client.getIcon(Client.class, "pictures/_zoom+.png");
    
    private static ExploitationView view;
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return an action
     */
    public static LargerTimeTableAction getInstance()
    {
        if(action==null)
            action = new LargerTimeTableAction();
        return action;
    }

    protected LargerTimeTableAction()
    {
        super("Agrandir la plage", icon);
    }
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param arg0 
     * 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent arg0)
    {
        view.increase();
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

