/*
 * Created on 6 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.GL.test.edt.renderer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;

import temp.Busy;
import fr.umlv.ir3.GL.test.edt.FlexiEDT;
import fr.umlv.ir3.GL.test.edt.model.EDTModel;


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
    private JLabel label;
    private int contrainte=1;

    /**
     * DOCME
     * 
     */
    public EDTCellRenderer()
    {
        
    }

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
        this.contrainte = 1;
        this.label = new JLabel();
        if(elementAt == null)
        {
            //aucun rendu pour ce créneau car il sera surpassé par un Busy
            return null;
        }
        else
        {
            if(elementAt instanceof EDTModel.LessonBloc)
            {
                EDTModel.LessonBloc lessonBloc = (EDTModel.LessonBloc)elementAt;
                Busy busy = lessonBloc.getBusy();
//              nous sommes bien dans le cas d'un Busy à placer
                this.contrainte = lessonBloc.getNbGap();
                this.label.setBackground(busy.getColor());
                this.label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setFont(new Font("Serif", Font.PLAIN, 9));
                this.label.setText("<html>" + busy.getReason() + " " + busy.getGap().getStartDate().getTime()+ "/" + busy.getGap().getEndDate().getTime()+ "</html>");
                
            }   
            else
            {
                //cas d'un créneau vide (sans cours)
                this.label.setText("");
                this.label.setBackground(Color.WHITE);
                this.label.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
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
        
        this.label.setPreferredSize(new Dimension(FlexiEDT.WEEK_WIDTH,FlexiEDT.GAP_HEIGTH*contrainte));
        
        this.label.setOpaque(true);
        return this.label;
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @see (si nécessaire)
     * @author   FlexiTeam - binou
     */
    public int getEDTCellRendererConstraint()
    {
        // TODO Auto-generated method stub
        return this.contrainte;
    }
    


}

