/*
 * Created on 14 déc. 2004
 * by BOUVET Adrien
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.richClient.gui.views;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.event.*;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.debug.FormDebugPanel;
import com.jgoodies.forms.layout.*;

import fr.umlv.ir3.flexitime.common.tools.*;
import fr.umlv.ir3.flexitime.richClient.io.FlexiMail;

/**
 * This class draws a frame where the user can specify some options before
 * sending a mail.
 * 
 * @version 325
 * @author FlexiTeam - BOUVET Adrien
 */
public class MailView
{
    private JFrame mailFrame;
    
    /**
     * DOCME
     */
    public void printView(final String[] lienPJ)
    {
        final FlexiLanguage language = FlexiLanguage.getInstance();
        mailFrame = new JFrame(language.getText("mailFrameName"));
        
        FormLayout layout = new FormLayout(
                "right:pref, 3dlu, pref, 3dlu, pref, 3dlu, pref, pref", // 8 columns
                "p, 3dlu, p, 3dlu, p, 3dlu, p, 9dlu, p, 3dlu, p, 3dlu, p, 9dlu, p, 3dlu, p, 9dlu, p");      // 19 rows
        
        PanelBuilder builder = new PanelBuilder(layout);
        builder.setDefaultDialogBorder();
        
        //Obtain a reusable constraints object to place components in the grid.
        CellConstraints cc = new CellConstraints();

        //creation des components
        final JButton butOK = new JButton(language.getText("ok"));
        final JButton butErase = new JButton(language.getText("erase"));
        final JButton butCancel= new JButton(language.getText("cancel"));
        
        final JLabel errorLabel = new JLabel();

        final JTextField tfFrom = new JTextField();
        tfFrom.setText(language.getText("templateSender"));
        tfFrom.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e)
            {
                if(tfFrom.getText().equals(language.getText("templateSender")))
                {
                    tfFrom.setText("");   
                }
            }

            public void mousePressed(MouseEvent e)
            {}

            public void mouseReleased(MouseEvent e)
            {}

            public void mouseEntered(MouseEvent e)
            {}

            public void mouseExited(MouseEvent e)
            {}
        });
        
        final JTextField tfTo = new JTextField();
        tfTo.setText(language.getText("templateDest"));
        tfTo.setAutoscrolls(true);
        tfTo.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e)
            {
                if(tfTo.getText().equals(language.getText("templateDest")))
                {
                    tfTo.setText("");   
                }
            }

            public void mousePressed(MouseEvent e)
            {}

            public void mouseReleased(MouseEvent e)
            {}

            public void mouseEntered(MouseEvent e)
            {}

            public void mouseExited(MouseEvent e)
            {}
        });
        
        DocumentListener addDL = new DocumentListener() {

            public void insertUpdate(DocumentEvent e)
            {
                if(!(Validator.validMail(tfFrom.getText())))
                {
                    errorLabel.setText(language.getText("errMail1"));
                    butOK.setEnabled(false);
                }
                else if(!(Validator.validMultiMails(tfTo.getText())))
                {
                    errorLabel.setText(language.getText("errMail2"));
                    butOK.setEnabled(false);
                }
                else
                    butOK.setEnabled(true);
            }

            public void removeUpdate(DocumentEvent e)
            {
                insertUpdate(e);
            }

            public void changedUpdate(DocumentEvent e)
            {
                insertUpdate(e);
            }
        };
        tfFrom.getDocument().addDocumentListener(addDL);
        tfTo.getDocument().addDocumentListener(addDL);
        
        final JTextField tfSubject = new JTextField();
        tfSubject.setText(language.getText("templateSubj"));
        tfSubject.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e)
            {
                if(tfSubject.getText().equals(language.getText("templateSubj")))
                {
                    tfSubject.setText("");   
                }
            }

            public void mousePressed(MouseEvent e)
            {}

            public void mouseReleased(MouseEvent e)
            {}

            public void mouseEntered(MouseEvent e)
            {}

            public void mouseExited(MouseEvent e)
            {}
        });
        
        final JTextField tfFileAttached = new JTextField();
        if(lienPJ!=null)
        {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0 ; i < lienPJ.length ; i++)
            {
                buffer.append(lienPJ[i]);
                buffer.append("; ");
            }
            tfFileAttached.setText(buffer.toString());            
        }
        tfFileAttached.setEditable(false);
        
        
        final JTextArea taMessage = new JTextArea(); //TODO specifier taille ?
        taMessage.setText(language.getText("templateMess"));
        taMessage.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e)
            {
                if(taMessage.getText().equals(language.getText("templateMess")))
                {
                    taMessage.setText("");   
                }
            }

            public void mousePressed(MouseEvent e)
            {}

            public void mouseReleased(MouseEvent e)
            {}

            public void mouseEntered(MouseEvent e)
            {}

            public void mouseExited(MouseEvent e)
            {}
        });
        
        butOK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                String from = tfFrom.getText();
                
                StringTokenizer semicolon = new StringTokenizer(tfTo.getText(), ";");
                ArrayList<String> addrDest = new ArrayList<String>();
                while(semicolon.hasMoreTokens())
                {
                    String token = semicolon.nextToken();
                    StringTokenizer coma = new StringTokenizer(token, ",");
                    while(coma.hasMoreTokens())
                        addrDest.add(coma.nextToken());
                }
                String[] to = new String[addrDest.size()];
                for (int i = 0 ; i < to.length ; i++)
                    to[i] = addrDest.get(i);
                
                String subject = tfSubject.getText();
                String mess = taMessage.getText();
                    
                FlexiMail.send(from, to, subject, mess, lienPJ);
                mailFrame.dispose();
            }            
        });
        
        butErase.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                tfFrom.setText("");
                tfTo.setText("");
                tfSubject.setText("");
                taMessage.setText("");
            }            
        });
        
        butCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                mailFrame.dispose();
            }            
        });
        
        //TODO : placer errorLabel
        //ajout des components au layout
        builder.addSeparator(language.getText("mailLblHead"),         cc.xyw(1, 1, 8));
        builder.addLabel(language.getText("mailLblSender"),              cc.xy (1, 3));
        builder.add(tfFrom,                     cc.xyw(3, 3, 5));
        builder.addLabel(language.getText("mailLblDest"),                cc.xy (1, 5));
        builder.add(tfTo,                       cc.xyw(3, 5, 5));
        builder.addLabel(language.getText("mailLblSubj"),           cc.xy (1, 7));
        builder.add(tfSubject,                  cc.xyw(3, 7, 5));
        
        builder.addLabel(language.getText("mailLblFiles"),     cc.xy (1, 13));
        builder.add(tfFileAttached,             cc.xyw(3, 13, 5));
        
        builder.addSeparator(language.getText("mailLblMess"),        cc.xyw(1, 15, 8));        
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
