/*
 * Created on 21 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;


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
public class IPServerView
{
    static String newIP = " ";
    
    /**
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * @param i 
     * 
     * @return the IP adress of the server. 
     * 
     */
    public static String printView(int i)
    {
        //info :
        //server ne peut etre joint
        //entrer son @ IP
        
        JFrame maFrame = new JFrame();
        
        FormLayout layout = new FormLayout(
                "right:pref, 5dlu, pref, 7dlu, pref, 3dlu, pref", // 7 columns
                "p, 3dlu, p, p, 3dlu, p, 3dlu, p");      // 8 rows
        
        //Specify that columns 1 & 5 have equal widths.       
        layout.setColumnGroups(new int[][]{ {1, 5} });
        
        
        PanelBuilder builder = new PanelBuilder(layout);
        builder.setDefaultDialogBorder();
        
        //Obtain a reusable constraints object to place components in the grid.
        CellConstraints cc = new CellConstraints();

        //Fill the grid with components; the builder can create
        //frequently used components, e.g. separators and labels.
        final JTextArea ipField = new JTextArea();
        JButton butOK = new JButton("OK");
        butOK.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent arg0)
            {
                newIP=ipField.getText();
            }
            
        });
        JButton butErase = new JButton("Effacer");
        butErase.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent arg0)
            {
                ipField.setText(" ");
            }
            
        });
                
        //Add a titled separator to cell (1, 1) that spans 7 columns.
        builder.addSeparator("Information",   cc.xyw(1,  1, 7));
        builder.addLabel("blabla ip injoignable",       cc.xyw (1,  3, 7));
        builder.addLabel("Rentrer new ip",       cc.xyw (1,  4, 7));
        builder.addLabel("IP :",       cc.xy (1,  6));
        builder.add(ipField,         cc.xyw(3,  6, 3));
        builder.add(butOK, cc.xy (3,  8));
        builder.add(butErase, cc.xy (5,  8));

        //The builder holds the layout container that we now return.
        maFrame.add(builder.getPanel());
        

        maFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //TODO ImageIcon icon = new ImageIcon(maFrame.getClass().getResource("FlexiTime.png"));
        //maFrame.setIconImage(icon.getImage());
        maFrame.setSize(300, 300);
        maFrame.setVisible(true);
        
        // attend que le user rentre une IP
        while(newIP.compareTo(" ") == 0) {}

        maFrame.setVisible(true);
        return newIP;
    }

}

