/*
 * Created on 16 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.actions.bar;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;

import fr.umlv.ir3.flexitime.common.tools.PrintUtilities;
import fr.umlv.ir3.flexitime.richClient.gui.Client;
import fr.umlv.ir3.flexitime.richClient.gui.panel.exploitation.ExploitationView;


/**
 * An action implementation useful for printing timetables.
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Adrien BOUVET 
 */
public class PrintAction extends AbstractAction
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4049635689815749687L;
    private static PrintAction action;
    private static Icon icon = Client.getIcon(Client.class, "pictures/_print.png");
    private static JButton button;
    private static ExploitationView exploitView;
    
    protected PrintAction()
    {
        super("Imprimer", icon);
    }
    
    
    public static PrintAction getInstance()
    {
        if(action==null)
            action = new PrintAction();
        
        return action;
    }

    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return a button
     */
    public static JButton getButton()
    {
        if (button == null)
        {
            button = new JButton();
            button.setIcon((Icon) action.getValue(Action.SMALL_ICON));
            button.setToolTipText((String) action.getValue(Action.NAME));
            button.addActionListener(getInstance());
        }

        return button;
    }
    
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param newValue 
     * 
     * @see javax.swing.AbstractAction#setEnabled(boolean)
     */
    public void setEnabled(boolean newValue)
    {
        super.setEnabled(newValue);
        button.setEnabled(newValue);
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param _exploitView 
     */
    public static void setExploitView(ExploitationView _exploitView)
    {
        exploitView = _exploitView;        
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
        JComponent compo = exploitView.getPrintableComponent();
        PrintUtilities.printComponent(compo);
    }
}
