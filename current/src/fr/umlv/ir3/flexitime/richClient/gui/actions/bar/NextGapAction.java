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
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * 
 */
public class NextGapAction extends AbstractAction
{
    private static NextGapAction action;
    private static Icon icon = Client.getIcon(NextGapAction.class, "../../pictures/_forward.png");
    
    ExploitationView view;
    
    public static NextGapAction getInstance(ExploitationView view)
    {
        if(action==null)
            action = new NextGapAction(view);
        
        return action;
    }

    protected NextGapAction(ExploitationView view)
    {
        super("Créneau suivant", icon);
        this.view = view;
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
        view.fullStepOver();
    }

}

