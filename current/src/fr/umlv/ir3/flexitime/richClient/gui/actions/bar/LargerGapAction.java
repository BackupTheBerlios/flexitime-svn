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
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class LargerGapAction extends AbstractAction
{
    private static LargerGapAction action;
    private static Icon icon = Client.getIcon(LargerGapAction.class, "../../pictures/_gapLarger2.png");
    
    ExploitationView view;
    
    public static LargerGapAction getInstance(ExploitationView view)
    {
        if(action==null)
            action = new LargerGapAction(view);

        return action;
    }

    protected LargerGapAction(ExploitationView view)
    {
        super("Agrandir la précision d'un emploi du temps", icon);
        this.view = view;
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
        view.moreGapTime();
    }

}
