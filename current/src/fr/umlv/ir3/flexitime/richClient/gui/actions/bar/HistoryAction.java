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


/**
 * An action implementation useful for viewing old timetables and their modifications.
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Adrien BOUVET 
 */
public class HistoryAction extends AbstractAction
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4051048575008191539L;
    private static HistoryAction action;
    private static Icon icon = Client.getIcon(HistoryAction.class, "../../pictures/_history.png");
    
    public static HistoryAction getInstance()
    {
        if(action==null)
            action = new HistoryAction();
        
        return action;
    }

    protected HistoryAction()
    {
        super("Passer en mode Historique", icon);
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
    // TODO Auto-generated method stub

    }

}

