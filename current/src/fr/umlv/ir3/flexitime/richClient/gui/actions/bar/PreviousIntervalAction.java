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
 * DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class PreviousIntervalAction extends AbstractAction
{
    private static PreviousIntervalAction action;
    private static Icon icon = Client.getIcon(PreviousIntervalAction.class, "../../pictures/_backFull.png");
    
    ExploitationView view;
    
    public static PreviousIntervalAction getInstance(ExploitationView view)
    {
        if(action==null)
            action = new PreviousIntervalAction(view);
        
        return action;
    }

    protected PreviousIntervalAction(ExploitationView view)
    {
        super("Reculer d'un interval de temps", icon);
        this.view = view;
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
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

}
