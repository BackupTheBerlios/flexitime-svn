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
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.event.MouseInputAdapter;





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
public class JLesson extends JLabel //implements MouseListener, MouseMotionListener
{
	LessonBloc lesson = null;
    
    boolean isSelected =false;
    
    private MouseEvent firstMouseEvent = null;
    private static boolean installInputMapBindings = true;
    
    public JLesson(LessonBloc lesson)
    {
    	this.lesson = lesson;
    	
    	
		MouseEventForwarder forwarder = new MouseEventForwarder();
		addMouseListener(forwarder);
		addMouseMotionListener(forwarder);
        
        if(lesson == null)
        {
            this.setText("");
            this.setBackground(Color.WHITE);
            this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            this.setPreferredSize(new Dimension(FlexiEDT.WEEK_WIDTH,FlexiEDT.GAP_HEIGTH*1));
        }
        else
        {
	        this.setBackground(lesson.getBusy().getColor());
	        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        this.setFont(new Font("Serif", Font.PLAIN, 9));
	        this.setText("<html>" + lesson.getBusy().getReason() + " " + lesson.getBusy().getGap().getStartDate().getTime()+ "/" + lesson.getBusy().getGap().getEndDate().getTime()+ "</html>");
	        this.setToolTipText("<html>" + lesson.getBusy().getReason() + "<br>" + lesson.getBusy().getGap().getStartDate().getTime()+ "/" + lesson.getBusy().getGap().getEndDate().getTime()+ "<br> blablabla </html>");
	        this.setPreferredSize(new Dimension(FlexiEDT.WEEK_WIDTH,FlexiEDT.GAP_HEIGTH*lesson.getNbGap()));
        }
        
        this.setOpaque(true);
            
    }
    

    

    
    
    /**
     * DOCME
     * @param comp
     */
    /*public JLesson(JLesson lesson)
    {
        this(new LessonBloc(lesson.getLesson()));
    }*






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
            System.out.println("BLACK at" + System.currentTimeMillis());
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }


    /*public void mousePressed(MouseEvent e) {
        
        //Don't bother to drag if there is no image.
        if (lesson == null) return;

        
        System.out.println("mousePressed() over " + getText());

        firstMouseEvent = e;
        e.consume();
    }

    public void mouseDragged(MouseEvent e) {
        
        //Don't bother to drag if the component displays no image.
        if (lesson == null) return;
        
        //System.out.println("mouseDragged() at " +System.currentTimeMillis());
        
        if (firstMouseEvent != null) {
            e.consume();

            //If they are holding down the control key, COPY rather than MOVE
            int ctrlMask = InputEvent.CTRL_DOWN_MASK;
            int action = ((e.getModifiersEx() & ctrlMask) == ctrlMask) ?
                  TransferHandler.COPY : TransferHandler.MOVE;

            int dx = Math.abs(e.getX() - firstMouseEvent.getX());
            int dy = Math.abs(e.getY() - firstMouseEvent.getY());
            //Arbitrarily define a 5-pixel shift as the
            //official beginning of a drag.
            if (dx > 1 || dy > 1) {
                if(!this.isSelected())
                    this.setSelected(true);
                //This is a drag, not a click.
                JComponent c = (JComponent)e.getSource();
                System.out.println("mouseDragged() : handler.exportAsDrag() at " +System.currentTimeMillis());
                System.out.println("mouseDragged') : from " + getText());
                TransferHandler handler = c.getTransferHandler();
                //Tell the transfer handler to initiate the drag.
                handler.exportAsDrag(c, firstMouseEvent, action);
                firstMouseEvent = null;
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        firstMouseEvent = null;
        //System.out.println("mouseReleased() over " + getText());
    }

    

    //This method is necessary because DragPictureDemo and
    //DragPictureDemo2 both use this class and DragPictureDemo
    //needs to have the input map bindings installed for
    //cut/copy/paste.  DragPictureDemo2 uses menu accelerators
    //and does not need to have the input map bindings installed.
    //Your program would use one approach or the other, but not
    //both.  The default for installInputMapBindings is true.
    public static void setInstallInputMapBindings(boolean flag) {
        installInputMapBindings = flag;
    }

    public static boolean getInstallInputMapBindingds() { //for completeness
        return installInputMapBindings;
    }


    public void mouseClicked(MouseEvent e)
    {
    	//System.out.println("mouseClicked() over " + getText());
    	this.setSelected(!this.isSelected());
    }*/

  
    
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
    public Component getClone()
    {
        // TODO Auto-generated method stub
        return null;
    }
	
	
}

