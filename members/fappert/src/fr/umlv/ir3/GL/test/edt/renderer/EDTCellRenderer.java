/*
 * Created on 6 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.GL.test.edt.renderer;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;

import fr.umlv.ir3.GL.test.edt.FlexiEDT;
import fr.umlv.ir3.GL.test.edt.JLesson;
import fr.umlv.ir3.GL.test.edt.LessonBloc;


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
public class EDTCellRenderer
{
    private JComponent comp;

    /**
     * DOCME
     * 
     */
    public EDTCellRenderer()
    {}

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param flexiEDT
     * @param elementAt
     * @return 
     * 
     * @see (si nécessaire)
     * @author   FlexiTeam - binou
     */
    public JComponent getEDTCellRendererComponent(FlexiEDT flexiEDT, Object elementAt, int week, int day, int gap)
    {
        this.comp = null;
        if(elementAt != null)
        {
            if(elementAt instanceof LessonBloc)
            {
                //nous sommes bien dans le cas d'un Busy à placer
                comp = new JLesson( (LessonBloc)elementAt ); 
            }   
            else
            {
                //cas d'un créneau vide à placer
                comp = new JLesson(null);
                /*JLabel label = new JLabel();
                label.setText("");
                label.setBackground(Color.WHITE);
                label.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                label.setPreferredSize(new Dimension(FlexiEDT.WEEK_WIDTH,FlexiEDT.GAP_HEIGTH*1));
                label.setOpaque(true);
                
                
                comp = label;*/
                
                /*if(week%2 == 0 && gap%2 == 0)
                    this.label.setBackground(FlexiColor.getColor(FlexiColor.lightblue));
                else
                {
                    if(week%2 == 1 && gap%2 == 1)
                        this.label.setBackground(FlexiColor.getColor(FlexiColor.lightblue));
                    else
                        this.label.setBackground(FlexiColor.getColor(FlexiColor.lightsteelblue));
                }*/
            }
        }
        
       
        return comp;
    }

    


}

