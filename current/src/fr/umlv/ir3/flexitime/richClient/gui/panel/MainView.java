/*
 * Created on 13 d�c. 2004
 * by Adrien BOUVET
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.richClient.gui.panel;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 * MainView - DOCME Description explication suppl�mentaire si n�cessaire in
 * english please... Que fait cette classe, qu'est-ce qu'elle repr�sente, ...
 * 
 * @version 0.1
 * @author FlexiTeam - Adrien BOUVET
 */
public class MainView
{
    private JScrollPane panel;
    
    /**
     * Constructs a main view.
     * 
     */
    public MainView()
    {
        JEditorPane editorPanel = new JEditorPane();
        editorPanel.setEditable(false);
        editorPanel.addHyperlinkListener(new HyperlinkListener() {
            
            public void hyperlinkUpdate(HyperlinkEvent arg0)
            {
                System.out.println("ouvir naviguateur..");
            }
            
        });
        java.net.URL helpURL = MainView.class.getResource("accueil.html");
        if (helpURL != null) {
            try {
                editorPanel.setPage(helpURL);
            } catch (IOException e) {
                System.err.println("Attempted to read a bad URL: " + helpURL);
            }
        } else {
            System.err.println("Couldn't find file: accueil.html");
        }
        
        panel = new JScrollPane(editorPanel);
        panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.setPreferredSize(new Dimension(250, 145));
        panel.setMinimumSize(new Dimension(10, 10));
        
    }
    
    /** 
     * Returns the panel of this main view.
     *
     * @return the panel of this main view.
     * 
     */
    public JScrollPane getPanel()
    {
        return panel;        
    }

}