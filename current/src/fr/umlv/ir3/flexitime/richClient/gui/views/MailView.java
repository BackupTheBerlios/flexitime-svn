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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import fr.umlv.ir3.flexitime.server.io.FlexiMail;

/**
 * This class draws a frame where the user can specify some options before
 * sending a mail.
 * 
 * @version 0.1
 * @author FlexiTeam - BOUVET Adrien
 */
public class MailView
{
    private JFrame mailFrame;

    /**
     * printView - DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     */
    public void printView(String lienPJ)
    {
        mailFrame = new JFrame("Envoie d'un mail");     
        
        FormLayout layout = new FormLayout(
                "right:pref, 3dlu, pref, 3dlu, pref, 3dlu, pref, pref", // 8 columns
                "p, 3dlu, p, 3dlu, p, 3dlu, p, 9dlu, p, 3dlu, p, 3dlu, p, 9dlu, p, 3dlu, p, 9dlu, p");      // 19 rows
        
        
        PanelBuilder builder = new PanelBuilder(layout);
        builder.setDefaultDialogBorder();
        
        //Obtain a reusable constraints object to place components in the grid.
        CellConstraints cc = new CellConstraints();

        //creation des components
        final JTextField tfFrom = new JTextField();
        tfFrom.setText("<expéditeur>");
        tfFrom.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent arg0)
            {
                if(tfFrom.getText().compareTo("<expéditeur>") == 0)
                {
                    tfFrom.setText("");   
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
        
        final JTextField tfTo = new JTextField();
        tfTo.setText("<destinataire>");
        tfTo.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent arg0)
            {
                if(tfTo.getText().compareTo("<destinataire>") == 0)
                {
                    tfTo.setText("");
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
        
        final JTextField tfSubject = new JTextField();
        tfSubject.setText("<sujet>");
        tfSubject.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent arg0)
            {
                if(tfSubject.getText().compareTo("<sujet>") == 0)
                {
                    tfSubject.setText("");   
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
        
        final JTextField tfSMTPServer = new JTextField();
        //TODO recuperer IP du fichier de conf !
        tfSMTPServer.setText("recuperer IP du fichier de conf !");
        tfSMTPServer.setEditable(false);
        
        final JTextField tfFileAttached = new JTextField();
        if(lienPJ!=null)
        {
            tfFileAttached.setText(lienPJ);            
        }
        tfFileAttached.setEditable(false);
        
        
        final JTextArea taMessage = new JTextArea(); //TODO specifier taille ?
        taMessage.setText("<votre message ici>");
        taMessage.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent arg0)
            {
                if(taMessage.getText().compareTo("<votre message ici>") == 0)
                {
                    taMessage.setText("");   
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
        
        JButton butOK = new JButton("OK");
        butOK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                //TODO tester si champs vides
                //si non :
                //créer un objet FlexiMail avec en params les valeurs des champs d la FlexiView
                //FlexiMail.send()
                //si oui afficher error
                FlexiMail mail = new FlexiMail();
                boolean ok = true;
                if( (tfFrom.getText().compareTo("")!=0) && (tfFrom.getText().compareTo("<expéditeur>")!=0))
                {
                    mail.setFrom(tfFrom.getText());
                }
                else ok=false;
                if( (tfFrom.getText().compareTo("")!=0) && (tfFrom.getText().compareTo("<expéditeur>")!=0))
                {
                    mail.setFrom(tfFrom.getText());
                }
                else ok=false;
            }            
        });
        JButton butErase = new JButton("Effacer");
        butErase.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                tfFrom.setText("");
                tfTo.setText("");
                tfSubject.setText("");
                taMessage.setText("");
            }            
        });
        JButton butCancel = new JButton("Annuler");
        butCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                mailFrame.dispose();
            }            
        });
        

        //ajout des components au layout
        builder.addSeparator("En-Tête",         cc.xyw(1, 1, 8));
        builder.addLabel("From :",              cc.xy (1, 3));
        builder.add(tfFrom,                     cc.xyw(3, 3, 5));
        builder.addLabel("To :",                cc.xy (1, 5));
        builder.add(tfTo,                       cc.xyw(3, 5, 5));
        builder.addLabel("Subject :",           cc.xy (1, 7));
        builder.add(tfSubject,                  cc.xyw(3, 7, 5));
        
        builder.addSeparator("Informations",    cc.xyw(1, 9, 8));
        builder.addLabel("SMTP Serveur :",      cc.xy (1, 11));
        builder.add(tfSMTPServer,                  cc.xyw(3, 11, 5));
        builder.addLabel("File Attached :",     cc.xy (1, 13));
        builder.add(tfFileAttached,             cc.xyw(3, 13, 5));
        
        builder.addSeparator("Messages",        cc.xyw(1, 15, 8));        
        builder.add(taMessage,                  cc.xyw(1, 17, 8));
        
        builder.add(butOK,                      cc.xy (3, 19));
        builder.add(butErase,                   cc.xy (5, 19));
        builder.add(butCancel,                  cc.xy (7, 19));
        
        mailFrame.add(builder.getPanel());  
        mailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon icon = new ImageIcon(getClass().getResource("../pictures/FlexiTime_icone32.png"));
        mailFrame.setIconImage(icon.getImage());
        mailFrame.setSize(330, 350);
        //mailFrame.setResizable(false);
        //placement de la fenetre sur l'ecran
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = mailFrame.getPreferredSize();
        mailFrame.setLocation(screenSize.width/2 - (labelSize.width/2), screenSize.height/2 - (labelSize.height/2));
        mailFrame.setVisible(true);
    }
}
