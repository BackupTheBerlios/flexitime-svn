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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;


/**
 * This class draws a frame where the user can authenticate.
 * 
 * @version 0.1
 * @author FlexiTeam - BOUVET Adrien
 */
public class LoginView
{   
    private JDialog loginView;
    private PanelBuilder builder;
    private String login = ""; //$NON-NLS-1$
    private char[] pass;
    private static FlexiLanguage language;
    static
    {
        language = FlexiLanguage.getInstance();
    }

    /**
     * DOCME
     * @param parentFrame 
     */
    public LoginView(JFrame parentFrame)
    {
        loginView = new JDialog(parentFrame, "Authentification", true);     //$NON-NLS-1$
        
        FormLayout layout = new FormLayout(
                "right:pref, 3dlu, pref, 3dlu, pref, 3dlu, pref, 30dlu, pref", // 9 columns//$NON-NLS-1$
                "3dlu, p, p, p, 9dlu, p, 3dlu, p, 9dlu, p");      // 9 rows//$NON-NLS-1$
        
        
        builder = new PanelBuilder(layout);
        builder.setDefaultDialogBorder();
        
        //Obtain a reusable constraints object to place components in the grid.
        CellConstraints cc = new CellConstraints();

        //creation des components
        ImageIcon icon = new ImageIcon(getClass().getResource("../pictures/FlexiTime_icone32.png"));//$NON-NLS-1$
        JLabel labIcon = new JLabel(icon);
        final JTextField tfLogin = new JTextField();
        tfLogin.setText("<votre nom>");//$NON-NLS-1$
        tfLogin.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent arg0)
            {
                if(tfLogin.getText().compareTo("<votre nom>") == 0)//$NON-NLS-1$
                {
                    tfLogin.setText("");   //$NON-NLS-1$
                }
            }

            public void mousePressed(MouseEvent arg0)
            {}

            public void mouseReleased(MouseEvent arg0)
            {}

            public void mouseEntered(MouseEvent arg0)
            {}

            public void mouseExited(MouseEvent arg0)
            {}            
        });
        final JPasswordField tfPass = new JPasswordField("password");  //$NON-NLS-1$
        tfPass.setText("password");//$NON-NLS-1$
        tfPass.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent arg0)
            {
                char[] tmp = tfPass.getPassword();
                String temp = new String(tmp);
                if(temp.compareTo("password") == 0)//$NON-NLS-1$
                {
                    tfPass.setText("");//$NON-NLS-1$//$NON-NLS-1$
                }
            }

            public void mousePressed(MouseEvent arg0)
            {}

            public void mouseReleased(MouseEvent arg0)
            {}

            public void mouseEntered(MouseEvent arg0)
            {}

            public void mouseExited(MouseEvent arg0)
            {}            
        });
        JButton butOK = new JButton("OK");//$NON-NLS-1$
        butOK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                if(tfLogin.getText().compareTo("")!=0) //$NON-NLS-1$
                {
                    login = tfLogin.getText();
                    pass = tfPass.getPassword();
                    loginView.setVisible(false);
                }
                else
                    JOptionPane.showMessageDialog(null, language.getText("errLogin2"), language.getText("erreur"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
            }            
        });
        JButton butErase = new JButton("Effacer");//$NON-NLS-1$
        butErase.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                tfLogin.setText(""); //$NON-NLS-1$
                tfPass.setText(""); //$NON-NLS-1$
            }            
        });
        JButton butStop = new JButton("Fermer"); //$NON-NLS-1$
        butStop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                System.exit(1);
            }            
        });
        

        //ajout des components au layout
        builder.addLabel("Merci de vous authentifier pour pouvoir utiliser le logiciel.", cc.xyw(1, 2, 8)); //$NON-NLS-1$
        builder.addLabel("Si vous ne possédez pas de login/password,", cc.xyw(1, 3, 8)); //$NON-NLS-1$
        builder.addLabel("vous pouvez éteindre le logiciel en cliquant sur \"Fermer\".", cc.xyw(1, 4, 8)); //$NON-NLS-1$
        builder.add(labIcon, cc.xywh(9, 2, 1, 3));
        builder.addLabel("Login :", cc.xy(1, 6)); //$NON-NLS-1$
        builder.add(tfLogin, cc.xyw(3, 6, 5));
        builder.addLabel("Password :", cc.xy(1, 8)); //$NON-NLS-1$
        builder.add(tfPass, cc.xyw(3, 8, 5));
        builder.add(butOK, cc.xy(3, 10));
        builder.add(butErase, cc.xy(5, 10));
        builder.add(butStop, cc.xy(7, 10));
        
        
        
        loginView.add(builder.getPanel());  
        loginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //loginFrame.setIconImage(icon.getImage());
        loginView.setSize(400, 200);
        loginView.setResizable(false);
        //placement de la fenetre sur l'ecran
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = loginView.getPreferredSize();
        loginView.setLocation(screenSize.width/2 - (labelSize.width/2), screenSize.height/6 - (labelSize.height/2));
    }
    
    
    /**
     * printView - DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @return an int indicating if the user is well logged in.
     */
    public JDialog getFrame()
    {
        return loginView;
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
     * @return the password entered by the user.
     */
    public String getPass()
    {
        return new String(pass);        
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     */
    public void reset()
    {
        this.login=""; //$NON-NLS-1$
    }
    
}