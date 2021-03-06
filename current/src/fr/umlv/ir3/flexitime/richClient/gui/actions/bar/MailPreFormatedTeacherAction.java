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
 * An action implementation useful for sending a pre-formated mail to a teacher.
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class MailPreFormatedTeacherAction extends AbstractAction
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3258415040573747763L;
    private static MailPreFormatedTeacherAction action;
    private static Icon icon = Client.getIcon(Client.class, "pictures/_mail.png");
    
    public static MailPreFormatedTeacherAction getInstance()
    {
        if(action==null)
            action = new MailPreFormatedTeacherAction();
        
        return action;
    }

    protected MailPreFormatedTeacherAction()
    {
        super("� un professeur", icon);
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
        //afficher une JDialog contenant la liste des professeurs class�e par ordre alpha
        //la secr�taire choisie un prof
        //cr�er l'EdT du prof et le stocker temporairement
        //construire une mailView avec le champ From, To, Subject et PJ rempli
        //envoyer le mail kan la secr�taire appuie sur OK
        MailView mail = new MailView();
        mail.printView(null);
    }
}
