/*
 * Created on 21 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;

/**
 * DOCME Description
 * Class to put a splash screen before lunch the soft.
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class FlexiSplash extends JFrame
{
    /**
     * DOCME
     */
    public FlexiSplash(){
        super("FlexiTime");
                
        //setDefaultLookAndFeelDecorated(false);
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE); //set no border
        
        
        //TODO icone deconne....
        ImageIcon splashImage = new ImageIcon(getClass().getResource("pictures/FlexiSplashBeta.png"));
        JLabel lab = new JLabel(splashImage);
        
        getContentPane().add(lab, BorderLayout.CENTER);
        pack();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = lab.getPreferredSize();
        
        // Put image at the middle of the screen
        setLocation(screenSize.width/2 - (labelSize.width/2), screenSize.height/2 - (labelSize.height/2));
        
    }
    
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     */
    public void close() {
        setVisible(false);
        dispose();
    }
    
}

