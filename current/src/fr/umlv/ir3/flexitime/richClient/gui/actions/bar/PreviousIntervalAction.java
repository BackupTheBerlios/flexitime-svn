/*
 * Created on 28 janv. 2005
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
 * An action implementation useful for moving backward of the number of weeks actually shown.
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class PreviousIntervalAction extends AbstractAction
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3258407352582879286L;
    private static PreviousIntervalAction action;
    private static Icon icon = Client.getIcon(PreviousIntervalAction.class, "../../pictures/_backFull.png");
    
    private static ExploitationView view;
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return an action
     */
    public static PreviousIntervalAction getInstance()
    {
        if(action==null)
            action = new PreviousIntervalAction();
        
        return action;
    }

    protected PreviousIntervalAction()
    {
        super("Reculer d'un interval de temps", icon);
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
        view.fullStepBack();
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
