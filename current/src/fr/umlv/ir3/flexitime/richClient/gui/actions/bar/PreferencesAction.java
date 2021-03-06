/*
 * Created on 16 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.actions.bar;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import fr.umlv.ir3.flexitime.common.data.admin.impl.PreferencesImpl;
import fr.umlv.ir3.flexitime.richClient.gui.Client;


/**
 * An action implementation useful for printing the preferences' view.
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class PreferencesAction extends AbstractAction
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3257571706666497840L;
    private static PreferencesAction action;
    private PreferencesImpl prefs;
    
    public static PreferencesAction getInstance()
    {
        if(action==null)
            action = new PreferencesAction(new PreferencesImpl());
        
        return action;
    }

    protected PreferencesAction(PreferencesImpl prefs)
    {
        super("Pr�f�rences");
        this.prefs = prefs;        
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
        
        JFrame maFrame = new JFrame("Preferences");     

        ImageIcon icon = new ImageIcon(Client.class.getResource("pictures/FlexiTime_icone32.png"));
        
        FormLayout layout = new FormLayout(
                "right:pref, 3dlu, pref, 3dlu, pref, 3dlu, pref, 30dlu, pref", // 9 columns
                "3dlu, p, p, p, 9dlu, p, 3dlu, p, 9dlu, p");      // 9 rows
        
        
        PanelBuilder builder = new PanelBuilder(layout);
        builder.setDefaultDialogBorder();
        
        //Obtain a reusable constraints object to place components in the grid.
        CellConstraints cc = new CellConstraints();
/*
        //creation des components
        JLabel labIcon = new JLabel(icon);
        final JTextField tfLogin = new JTextField();
        tfLogin.setText("<votre nom>");
        final JPasswordField tfPass = new JPasswordField("password");  
        tfPass.setText("password");
        JButton butOK = new JButton("OK");
        butOK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
            }            
        });
        JButton butErase = new JButton("Effacer");
        butErase.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
            }            
        });
        JButton butStop = new JButton("Fermer");
        butStop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
            }            
        });
        

        //ajout des components au layout
        builder.addLabel("Merci de vous authentifier pour pouvoir utiliser le logiciel.", cc.xyw(1, 2, 8));
        builder.addLabel("Si vous ne poss�dez pas de login/password,", cc.xyw(1, 3, 8));
        builder.addLabel("vous pouvez �teindre le logiciel en cliquant sur \"Fermer\".", cc.xyw(1, 4, 8));
        builder.add(labIcon, cc.xywh(9, 2, 1, 3));
        builder.addLabel("Login :", cc.xy(1, 6));
        builder.add(tfLogin, cc.xyw(3, 6, 5));
        builder.addLabel("Password :", cc.xy(1, 8));
        builder.add(tfPass, cc.xyw(3, 8, 5));
        builder.add(butOK, cc.xy(3, 10));
        builder.add(butErase, cc.xy(5, 10));
        builder.add(butStop, cc.xy(7, 10));
        */
        
        builder.addLabel("TESTOUILLE", cc.xy(1, 2));
        
        maFrame.add(builder.getPanel());  
        maFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        maFrame.setIconImage(icon.getImage());
        maFrame.setSize(400, 200);
        maFrame.setResizable(false);
        //placement de la fenetre sur l'ecran
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = maFrame.getPreferredSize();
        maFrame.setLocation(screenSize.width/2 - (labelSize.width/2), screenSize.height/6 - (labelSize.height/2));
        
        maFrame.setVisible(true);

    }

}

