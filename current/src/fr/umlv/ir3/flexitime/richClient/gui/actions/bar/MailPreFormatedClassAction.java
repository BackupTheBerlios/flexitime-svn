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
 * An action implementation useful for sending a pre-formated mail to a class.
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class MailPreFormatedClassAction extends AbstractAction
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3977866180692293685L;
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
        super("� une promotion", icon);
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
        //afficher une JDialog contenant la liste des promotions class�es
        //la secr�taire choisie une promo
        //cr�er l'EdT de la promo et le stocker temporairement
        //construire une mailView avec le champ From, To, Subject et PJ rempli
        //envoyer le mail kan la secr�taire appuie sur OK
        
        
        
        
        /*JDialog chooseClassView = new JDialog(, "Choisir une promotion", true);     //$NON-NLS-1$
        
        FormLayout layout = new FormLayout(
                "right:pref, 3dlu, pref, 3dlu, pref, 3dlu, pref, 30dlu, pref", // 9 columns//$NON-NLS-1$
                "3dlu, p, p, p, 9dlu, p, 3dlu, p, 9dlu, p");      // 9 rows//$NON-NLS-1$
        
        
        builder = new PanelBuilder(layout);
        builder.setDefaultDialogBorder();
        
        //Obtain a reusable constraints object to place components in the grid.
        CellConstraints cc = new CellConstraints();

        //creation des components
        

        //ajout des components au layout

        
        
        
        chooseClassView.add(builder.getPanel());  
        chooseClassView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //loginFrame.setIconImage(icon.getImage());
        chooseClassView.setSize(400, 200);
        chooseClassView.setResizable(false);
        //placement de la fenetre sur l'ecran
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = chooseClassView.getPreferredSize();
        chooseClassView.setLocation(screenSize.width/2 - (labelSize.width/2), screenSize.height/6 - (labelSize.height/2));
        chooseClassView.setVisible(true);
   
        
        
        */
        
        
        MailView mail = new MailView();
        mail.printView(null);
    }
}
