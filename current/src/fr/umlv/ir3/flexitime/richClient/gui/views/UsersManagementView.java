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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
 * This class draws a frame where the super user can manage soft's users.
 * 
 * @version 0.1
 * @author FlexiTeam - BOUVET Adrien
 */
public class UsersManagementView
{
    private JDialog userMngmtView;
    private PanelBuilder builder;
    private String[] permissions = { "admin" , "rw" , "ro" };
    private static FlexiLanguage language;
    static
    {
        language = FlexiLanguage.getInstance();
    }
    
    
    /**
     * printView - DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     */
    public void printView(JFrame parentFrame)
    {
        userMngmtView = new JDialog(parentFrame, "Gestion des utilisateurs", true);     //$NON-NLS-1$
        
        FormLayout layout = new FormLayout(
                "right:pref, 3dlu, pref, 3dlu, pref", // 5 columns//$NON-NLS-1$
                "9dlu, p, 3dlu, p, p, 3dlu, p, 3dlu, p, 9dlu, p");      // 11 rows//$NON-NLS-1$
        
        
        builder = new PanelBuilder(layout);
        builder.setDefaultDialogBorder();
        
        //Obtain a reusable constraints object to place components in the grid.
        CellConstraints cc = new CellConstraints();

        //creation des components
        final JTextField tfLogin = new JTextField();
        tfLogin.setText("<le login>");//$NON-NLS-1$
        tfLogin.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent arg0)
            {
                if(tfLogin.getText().compareTo("<le login>") == 0)//$NON-NLS-1$
                {
                    tfLogin.setText("");   //$NON-NLS-1$
                }
            }
            public void mousePressed(MouseEvent arg0){}
            public void mouseReleased(MouseEvent arg0){}
            public void mouseEntered(MouseEvent arg0){}
            public void mouseExited(MouseEvent arg0){}            
        });
        final JTextField tfPass = new JTextField();
        tfPass.setEnabled(false);
        final JLabel labPass = new JLabel("Password :");
        labPass.setEnabled(false);
        final JLabel labLDAP1 = new JLabel("Cocher si le mot de passe du");
        final JLabel labLDAP2 = new JLabel("user est stocké dans le LDAP");
        final JCheckBox checkLDAP = new JCheckBox("ldap");
        checkLDAP.setSelected(true);
        checkLDAP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0)
            {
                if(checkLDAP.isSelected())
                {
                    tfPass.setEnabled(false);
                    labPass.setEnabled(false);
                }
                else
                {
                    tfPass.setEnabled(true);
                    labPass.setEnabled(true);
                }
            }
        });
        final JComboBox cbPermissions = new JComboBox(permissions);
        cbPermissions.setSelectedIndex(2);
        //cbPermissions.addActionListener(cbPermissions);
        
        JButton butOK = new JButton("OK");//$NON-NLS-1$
        butOK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                if( (tfLogin.getText().compareTo("")!=0 && tfLogin.getText().compareTo("<le login>")!=0) && (checkLDAP.isSelected() || tfPass.getText().compareTo("")!=0) ) //$NON-NLS-1$
                {
                    //creer nouvel utilisateur
                    //l'ajouter a la base de données
                    String s = "=>Ajouter "+tfLogin.getText();
                    if(checkLDAP.isSelected())
                        s+=", pass=<celui de ldap>";
                    else
                        s+=", pass=" +tfPass.getText();
                    s+=", droit="+ permissions[cbPermissions.getSelectedIndex()]; 
                    System.out.println(s);
                    userMngmtView.dispose();
                }
                else
                    JOptionPane.showMessageDialog(null, language.getText("errUserMngmt1"), language.getText("erreur"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
            }            
        });
        JButton butErase = new JButton("Effacer");//$NON-NLS-1$
        butErase.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                tfLogin.setText(""); //$NON-NLS-1$
                tfPass.setText(""); //$NON-NLS-1$
                tfPass.setEnabled(false);
                checkLDAP.setSelected(true);
                cbPermissions.setSelectedIndex(2);
            }            
        });
        JButton butCancel = new JButton("Annuler"); //$NON-NLS-1$
        butCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                userMngmtView.dispose();
            }            
        });
        

        //ajout des components au layout
        builder.addLabel("Login :",         cc.xy  (1, 2)); //$NON-NLS-1$
        builder.add(tfLogin,                cc.xyw (3, 2, 3));
        builder.add(checkLDAP,              cc.xywh(1, 4, 1, 2));
        builder.add(labLDAP1,               cc.xyw (3, 4, 3));
        builder.add(labLDAP2,               cc.xyw (3, 5, 3));
        builder.add(labPass,                cc.xy  (1, 7));
        builder.add(tfPass,                 cc.xyw (3, 7, 3));
        builder.addLabel("Droits :",        cc.xy  (1, 9));
        builder.add(cbPermissions,          cc.xyw (3, 9, 3));
        builder.add(butOK,                  cc.xy  (1, 11));
        builder.add(butErase,               cc.xy  (3, 11));
        builder.add(butCancel,              cc.xy  (5, 11));
        
        
        
        userMngmtView.add(builder.getPanel());  
        userMngmtView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //ImageIcon icon = new ImageIcon(getClass().getResource("../pictures/FlexiTime_icone32.png"));//$NON-NLS-1$
        //userMngmtView.setIconImage(icon.getImage());
        userMngmtView.setSize(250, 200);
        userMngmtView.setResizable(false);
        //placement de la fenetre sur l'ecran
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = userMngmtView.getPreferredSize();
        userMngmtView.setLocation(screenSize.width/2 - (labelSize.width/2), screenSize.height/2 - (labelSize.height/2));
        
        userMngmtView.setVisible(true);
         
    }
}