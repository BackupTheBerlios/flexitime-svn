/*
 * Created on 14 déc. 2004
 * by BOUVET Adrien
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.richClient.gui.views;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;


/**
 * This class draws a frame where the user can authenticate.
 * 
 * @version 0.1
 * @author FlexiTeam - BOUVET Adrien
 */
public class LoginView
{
    private JFrame loginFrame;
    private PanelBuilder builder;
    private String login = "";
    private char[] pass;

    /**
     * DOCME
     */
    public LoginView()
    {
        loginFrame = new JFrame("Authentification");     
        
        FormLayout layout = new FormLayout(
                "right:pref, 3dlu, pref, 3dlu, pref, 3dlu, pref, 30dlu, pref", // 9 columns
                "3dlu, p, p, p, 9dlu, p, 3dlu, p, 9dlu, p");      // 9 rows
        
        
        builder = new PanelBuilder(layout);
        builder.setDefaultDialogBorder();
        
        //Obtain a reusable constraints object to place components in the grid.
        CellConstraints cc = new CellConstraints();

        //creation des components
        ImageIcon icon = new ImageIcon(getClass().getResource("../pictures/FlexiTime_icone32.png"));
        JLabel labIcon = new JLabel(icon);
        final JTextField tfLogin = new JTextField();
        tfLogin.setText("<votre nom>");
        final JPasswordField tfPass = new JPasswordField("password");  
        tfPass.setText("password");
        JButton butOK = new JButton("OK");
        butOK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                //TODO tester si champs vide
                //si non :
                login = tfLogin.getText();
                pass = tfPass.getPassword();
                //si oui afficher error
            }            
        });
        JButton butErase = new JButton("Effacer");
        butErase.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                tfLogin.setText("");
                tfPass.setText("");
            }            
        });
        JButton butStop = new JButton("Fermer");
        butStop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                System.exit(1);
            }            
        });
        

        //ajout des components au layout
        builder.addLabel("Merci de vous authentifier pour pouvoir utiliser le logiciel.", cc.xyw(1, 2, 8));
        builder.addLabel("Si vous ne possédez pas de login/password,", cc.xyw(1, 3, 8));
        builder.addLabel("vous pouvez éteindre le logiciel en cliquant sur \"Fermer\".", cc.xyw(1, 4, 8));
        builder.add(labIcon, cc.xywh(9, 2, 1, 3));
        builder.addLabel("Login :", cc.xy(1, 6));
        builder.add(tfLogin, cc.xyw(3, 6, 5));
        builder.addLabel("Password :", cc.xy(1, 8));
        builder.add(tfPass, cc.xyw(3, 8, 5));
        builder.add(butOK, cc.xy(3, 10));
        builder.add(butErase, cc.xy(5, 10));
        builder.add(butStop, cc.xy(7, 10));
        
        
        
        loginFrame.add(builder.getPanel());  
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setIconImage(icon.getImage());
        loginFrame.setSize(400, 200);
        loginFrame.setResizable(false);
        //placement de la fenetre sur l'ecran
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = loginFrame.getPreferredSize();
        loginFrame.setLocation(screenSize.width/2 - (labelSize.width/2), screenSize.height/6 - (labelSize.height/2));
    }
    
    
    /**
     * printView - DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @return an int indicating if the user is well logged in.
     */
    public JFrame getFrame()
    {
        return loginFrame;
    }

    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return the login entered by the user.
     */
    public String getLogin()
    {
        return login;        
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param log 
     * 
     */
    public void setLogin(String log)
    {
        this.login=log;        
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return the password entered by the user.
     */
    public char[] getPass()
    {
        return pass;        
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     */
    public void setRepack()
    {
        //TODO Ne marche pas ...
        loginFrame.getRootPane().revalidate();
    }
}