/*
 * Created on 6 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.GL.test.edt.renderer;


import javax.swing.JComponent;

import fr.umlv.ir3.GL.test.edt.FlexiEDT;
import fr.umlv.ir3.GL.test.edt.JLesson;
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
    private JComponent comp;

    /**
     * DOCME
     * 
     */
    public EDTCellRenderer()
    {}

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
    public JComponent getEDTCellRendererComponent(FlexiEDT flexiEDT, Object elementAt, int week, int day, int gap)
    {
        this.comp = null;
        if(elementAt != null)
        {
            if(elementAt instanceof EDTModel.LessonBloc)
            {
                //nous sommes bien dans le cas d'un Busy � placer
                comp = new JLesson( (EDTModel.LessonBloc)elementAt ); 
            }   
            else
            {
                //cas d'un cr�neau vide � placer
                comp = new JLesson(null);
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

