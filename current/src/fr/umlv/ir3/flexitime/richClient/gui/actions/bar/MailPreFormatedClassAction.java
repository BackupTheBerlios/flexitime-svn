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
import fr.umlv.ir3.flexitime.richClient.gui.views.MailView;


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
public class MailPreFormatedClassAction extends AbstractAction
{
    private static MailPreFormatedClassAction action;
    private static Icon icon = Client.getIcon(MailPreFormatedClassAction.class, "../../pictures/_mail.png");
    
    public static MailPreFormatedClassAction getInstance()
    {
        if(action==null)
            action = new MailPreFormatedClassAction();
        
        return action;
    }

    protected MailPreFormatedClassAction()
    {
        super("à une promotion", icon);
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
        //afficher une JDialog contenant la liste des promotions classées
        //la secrétaire choisie une promo
        //créer l'EdT de la promo et le stocker temporairement
        //construire une mailView avec le champ From, To, Subject et PJ rempli
        //envoyer le mail kan la secrétaire appuie sur OK
        MailView mail = new MailView();
        mail.printView();
    }
}
