/*
 * Created on 6 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.GL.test.edt.renderer;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Calendar;


import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;

import fr.umlv.ir3.GL.test.edt.FlexiEDT;


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
public class EDTCellHeaderRenderer
{
    public static final int WEEK_HEADER = 0;
    public static final int DAY_HEADER = 1;
    public static final int GAP_HEADER = 2;
    public static final int DATE_HEADER = 3;
    private JLabel label;

    /**
     * DOCME
     * 
     */
    public EDTCellHeaderRenderer()
    {
        
    }
    
    public JComponent getEDTCellHeaderRendererComponent(FlexiEDT edt, Object object, int headerType)
    {
        this.label = null;
        
        switch(headerType)
        {
            case EDTCellHeaderRenderer.WEEK_HEADER :
                if(object instanceof Integer)
                {
                    Integer i = (Integer)object;
                    this.label = new JLabel();
                    this.label.setPreferredSize(new Dimension(FlexiEDT.WEEK_WIDTH,FlexiEDT.DAY_HEIGTH));
                    this.label.setBackground(Color.BLUE);
                    this.label.setText("sem. " + i.intValue());
                }
                break;
            case EDTCellHeaderRenderer.DAY_HEADER :
                if(object instanceof String)
                {
                    String text = (String)object;
                    this.label = new JLabel();
                    this.label.setPreferredSize(new Dimension(FlexiEDT.WEEK_WIDTH,FlexiEDT.DAY_HEIGTH));
                    this.label.setBackground(Color.BLUE);
                    this.label.setText(text);
                }
                break;
            case EDTCellHeaderRenderer.GAP_HEADER :
                if(object instanceof String)
                {
                    String text = (String)object;
                    this.label = new JLabel();
                    this.label.setPreferredSize(new Dimension(FlexiEDT.WEEK_WIDTH,FlexiEDT.GAP_HEIGTH));
                    this.label.setBackground(Color.CYAN);
                    this.label.setText(text);
                }
                break;
            case EDTCellHeaderRenderer.DATE_HEADER :
                if(object instanceof Calendar)
                {
                    Calendar calendar = (Calendar)object;
                    this.label = new JLabel();
                    this.label.setPreferredSize(new Dimension(FlexiEDT.WEEK_WIDTH,FlexiEDT.DAY_HEIGTH));
                    this.label.setBackground(Color.BLUE);
                    this.label.setText(
                            calendar.get(Calendar.DAY_OF_MONTH) + "-" + 
                            calendar.get(Calendar.MONTH+1) + "-" +
                            calendar.get(Calendar.YEAR) + "-"
                            );
                }
                break;
        }
        
        this.label.setOpaque(true);
        this.label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return label;
    }

}

