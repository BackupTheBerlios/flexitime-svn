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
 * An action implementation useful for exporting timetables.
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Adrien BOUVET 
 */
public class ExportAction extends AbstractAction
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3257007639937430841L;
    private static ExportAction action;
    private static Icon icon = Client.getIcon(Client.class, "pictures/_export.png");
    
    public static ExportAction getInstance()
    {
        if(action==null)
            action = new ExportAction();
        return action;
    }

    protected ExportAction()
    {
        super("Exporter", icon);
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

