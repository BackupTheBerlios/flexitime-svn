/*
 * Created on 4 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.GL.test.edt;

import java.awt.Color;
import java.awt.Dimension;


import javax.swing.BorderFactory;
import javax.swing.JLabel;




/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * 
 * @author FlexiTeam - binou
 */
public class JGap extends JLabel
{
    public static int DEFAULT_GAP_HEIGHT = 10;
    public static int DEFAULT_GAP_WIDTH = 10;
    
    
    
    /**
     * DOCME
     * 
     */
    public JGap(String text, Color backColor, int width, int height)
    {
        super();
 
        this.setOpaque(true);
        if(text != null)
            this.setText(text);
        this.setBackground(backColor);
        //this.setBorder(BorderFactory.createEtchedBorder(1));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setPreferredSize(new Dimension(width,height));
    }
    public static void setDefaultGapSize(int gapHeigth, int gapWidth)
    {
        JGap.DEFAULT_GAP_HEIGHT = gapHeigth;
        JGap.DEFAULT_GAP_WIDTH = gapWidth;
    }

}

