/*
 * Created on 16 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.actions.bar;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;

import fr.umlv.ir3.flexitime.richClient.gui.Client;


/**
 * An action implementation useful for switching the actual view to management.
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class ManagementAction extends AbstractAction
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3256718485576234549L;
    private static ManagementAction action;
    private static Icon icon = Client.getIcon(Client.class, "pictures/_gestion.png");
    
    public static ManagementAction getInstance()
    {
        if(action==null)
            action = new ManagementAction();
        
        return action;
    }

    protected ManagementAction()
    {
        super("Passer en mode Gestion", icon);
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
        Client.setMngmtMode();
    }

}

