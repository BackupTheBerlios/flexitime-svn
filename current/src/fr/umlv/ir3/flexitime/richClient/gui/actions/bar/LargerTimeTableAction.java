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
public class LargerTimeTableAction extends AbstractAction
{
    private static LargerTimeTableAction action;
    private static Icon icon = Client.getIcon(LargerTimeTableAction.class, "../../pictures/_zoom+.png");
    
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
        // TODO Auto-generated method stub
        
    }

}

