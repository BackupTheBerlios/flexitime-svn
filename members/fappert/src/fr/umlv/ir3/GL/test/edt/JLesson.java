/*
 * Created on 12 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.GL.test.edt;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import java.awt.event.MouseEvent;


import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;





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
public class JLesson extends JLabel
{
	LessonBloc lesson = null;
    
    boolean isSelected = false;
    
    
    
    
    //**********************
    //	Constructeurs
    //**********************
    public JLesson()
    {
        this.lesson = null;
        
		MouseEventForwarder forwarder = new MouseEventForwarder();
		addMouseListener(forwarder);
		addMouseMotionListener(forwarder);
        
        this.setOpaque(true);
        this.setText("");
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        this.setPreferredSize(new Dimension(FlexiPlanning.WEEK_WIDTH,FlexiPlanning.GAP_HEIGTH*1));
    }
    
    
    public JLesson(LessonBloc lesson)
    {
        this.lesson = lesson;

        MouseEventForwarder forwarder = new MouseEventForwarder();
        addMouseListener(forwarder);
        addMouseMotionListener(forwarder);

        this.setOpaque(true);
        this.setBackground(lesson.getBusy().getColor());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setFont(new Font("Serif", Font.PLAIN, 9));
        this.setText("<html>" + lesson.getBusy().getReason() + " "
                + lesson.getBusy().getGap().getStartDate().getTime() + "/"
                + lesson.getBusy().getGap().getEndDate().getTime() + "</html>");
        this.setToolTipText("<html>" + lesson.getBusy().getReason() + "<br>"
                + lesson.getBusy().getGap().getStartDate().getTime() + "/"
                + lesson.getBusy().getGap().getEndDate().getTime()
                + "<br> blablabla </html>");
        this.setPreferredSize(new Dimension(FlexiPlanning.WEEK_WIDTH,
                FlexiPlanning.GAP_HEIGTH * lesson.getNbGap()));
    }

    
    
    //**********************
    //	Selection
    //**********************
    public boolean isSelected()
    { return isSelected;}
    
    private void setSelected(boolean value)
    {
        this.isSelected=value;
        if(value)
        {
            this.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        else
        {
            //System.out.println("BLACK at" + System.currentTimeMillis());
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param b 
     * 
     * @see (si n�cessaire)
     * @author   FlexiTeam - binou
     */
    public void setDragOver(boolean b)
    {
        //System.out.println("drag = " + b);
        if(b == true)
            this.setBackground(Color.GREEN);
        else
            this.setBackground(Color.WHITE);
    }
    
    
    

  
  
    //**********************
    //	getters
    //**********************
	public LessonBloc getLesson() {
		return lesson;
	}
	
	public int getNbGaps()
	{
		if(lesson == null)
			return 1;
		else
			return lesson.getNbGap();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	final class MouseEventForwarder extends MouseInputAdapter {
		public void mousePressed(MouseEvent e) {
			Container parent = getParent();
			if (parent != null) {
				Point newPoint = SwingUtilities.convertPoint(JLesson.this, e.getPoint(), parent);
				e.translatePoint(newPoint.x-e.getX(), newPoint.y-e.getY());
				e.setSource(parent);
				parent.dispatchEvent(e);
			}
		}

		public void mouseReleased(MouseEvent e) {
			Container parent = getParent();
			if (parent != null) {
				Point newPoint = SwingUtilities.convertPoint(JLesson.this, e.getPoint(), parent);
				e.translatePoint(newPoint.x-e.getX(), newPoint.y-e.getY());
				e.setSource(parent);
				parent.dispatchEvent(e);			
			}
		}

		public void mouseDragged(MouseEvent e) {
			Container parent = getParent();
			if (parent != null) {
				Point newPoint = SwingUtilities.convertPoint(JLesson.this, e.getPoint(), parent);
				e.translatePoint(newPoint.x-e.getX(), newPoint.y-e.getY());
				e.setSource(parent);
				parent.dispatchEvent(e);
			}
		}
		
	    public void mouseClicked(MouseEvent e)
	    {
	    	//System.out.println("mouseClicked() over " + getText());
	    	setSelected(!isSelected());
	    }
		
		
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
    public Component getClone()
    {
        // TODO Auto-generated method stub
        return null;
    }



	
	
}

