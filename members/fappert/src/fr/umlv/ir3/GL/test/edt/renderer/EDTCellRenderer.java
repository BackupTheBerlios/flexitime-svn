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
import fr.umlv.ir3.GL.test.edt.model.EDTModel;


/**
 * DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * @see (si n�cessaire)
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
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param flexiEDT
     * @param elementAt
     * @return 
     * 
     * @see (si n�cessaire)
     * @author   FlexiTeam - binou
     */
    public JComponent getEDTCellRendererComponent(FlexiEDT flexiEDT, Object elementAt)
    {
        this.label = new JLabel();
        if(elementAt == null)
        {
            //aucun rendu pour ce cr�neau car il sera surpass� par un Busy
            return null;
        }
        else
        {
            EDTModel.LessonBloc objet = (EDTModel.LessonBloc)elementAt;
            this.contrainte = objet.getGapSize();
            if(objet.getBusy() == null)
            {
                //cas d'un cr�neau vide (sans cours)
                this.label.setText("    free");
                this.label.setBackground(Color.WHITE);
            }
            else
            {
                //nous sommes bien dans le cas d'un Busy � placer
                this.label.setBackground(objet.getBusy().getColor());
                this.label.setText(objet.getBusy().getReason());
            }
        }
        
        this.label.setPreferredSize(new Dimension(FlexiEDT.WEEK_WIDTH,FlexiEDT.GAP_HEIGTH*contrainte));
        this.label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.label.setOpaque(true);
        return this.label;
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @see (si n�cessaire)
     * @author   FlexiTeam - binou
     */
    public int getEDTCellRendererConstraint()
    {
        // TODO Auto-generated method stub
        return this.contrainte;
    }
    


}

