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
public class PreviousWeekAction extends AbstractAction
{
    private static PreviousWeekAction action;
    private static Icon icon = Client.getIcon(PreviousWeekAction.class, "../../pictures/_back.png");
    
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
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param e 
     * 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e)
    {
    // TODO Auto-generated method stub

    }

}

