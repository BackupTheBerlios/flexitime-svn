/*
 * Created on 16 janv. 2005
 * by Pr�sad
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
 * @version Verion ou r�vision SVN
 * @see (si n�cessaire)
 * 
 */
public class NextWeekAction extends AbstractAction
{
    private static NextWeekAction action;
    private static Icon icon = Client.getIcon(NextWeekAction.class, "../../pictures/_forward.png");
    
    ExploitationView view;
    
    public static NextWeekAction getInstance(ExploitationView view)
    {
        if(action==null)
            action = new NextWeekAction(view);
        
        return action;
    }

    protected NextWeekAction(ExploitationView view)
    {
        super("Avancer d'une semaine", icon);
        this.view = view;
    }
    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param e 
     * 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e)
    {
        view.stepOver();
    }

}

