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
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * @author FlexiTeam - Adrien BOUVET
 * 
 */
public class GestionAction extends AbstractAction
{
    private static GestionAction action;
    private static Icon icon = Client.getIcon(GestionAction.class, "../../pictures/_gestion.png");
    
    public static GestionAction getInstance()
    {
        if(action==null)
            action = new GestionAction();
        
        return action;
    }

    protected GestionAction()
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

