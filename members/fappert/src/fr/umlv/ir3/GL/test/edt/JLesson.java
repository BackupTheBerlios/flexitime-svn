/*
 * Created on 12 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.GL.test.edt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;

import fr.umlv.ir3.GL.test.edt.model.EDTModel;

import temp.Busy;


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
public class JLesson extends JLabel implements MouseListener, MouseMotionListener
{
    Busy busy;
    int nbGaps=1;
    
    private MouseEvent firstMouseEvent = null;
    private static boolean installInputMapBindings = true;
    
    public JLesson(EDTModel.LessonBloc lesson)
    {
        addMouseListener(this);
        addMouseMotionListener(this);
        
        if(lesson == null)
        {
            this.setText("");
            this.setBackground(Color.WHITE);
            this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        }
        else
        {
            this.busy = lesson.getBusy();
	        this.nbGaps = lesson.getNbGap();
	        this.setBackground(busy.getColor());
	        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        this.setFont(new Font("Serif", Font.PLAIN, 9));
	        this.setText("<html>" + busy.getReason() + " " + busy.getGap().getStartDate().getTime()+ "/" + busy.getGap().getEndDate().getTime()+ "</html>");
        }
        this.setPreferredSize(new Dimension(FlexiEDT.WEEK_WIDTH,FlexiEDT.GAP_HEIGTH*this.nbGaps));
        this.setOpaque(true);
            
    }
    

    public Busy getBusy()
    {
        return busy;
    }
    public void setBusy(Busy busy)
    {
        this.busy = busy;
    }
    public int getNbGaps()
    {
        return nbGaps;
    }


    public void mousePressed(MouseEvent e) {
        
        //Don't bother to drag if there is no image.
        if (busy == null) return;
        
        //System.out.println("mousePressed() at " +System.currentTimeMillis());

        firstMouseEvent = e;
        e.consume();
    }

    public void mouseDragged(MouseEvent e) {
        
        //Don't bother to drag if the component displays no image.
        if (busy == null) return;
        
        //System.out.println("mouseDragged() at " +System.currentTimeMillis());
        
        if (firstMouseEvent != null) {
            e.consume();

            //If they are holding down the control key, COPY rather than MOVE
            //int ctrlMask = InputEvent.CTRL_DOWN_MASK;
            //int action = ((e.getModifiersEx() & ctrlMask) == ctrlMask) ?
            //      TransferHandler.COPY : TransferHandler.MOVE;

            int dx = Math.abs(e.getX() - firstMouseEvent.getX());
            int dy = Math.abs(e.getY() - firstMouseEvent.getY());
            //Arbitrarily define a 5-pixel shift as the
            //official beginning of a drag.
            if (dx > 5 || dy > 5) {
                //This is a drag, not a click.
                JComponent c = (JComponent)e.getSource();
                System.out.println("handler.exportAsDrag() at " +System.currentTimeMillis());
                //TransferHandler handler = c.getTransferHandler();
                //Tell the transfer handler to initiate the drag.
                //handler.exportAsDrag(c, firstMouseEvent, action);
                firstMouseEvent = null;
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        firstMouseEvent = null;
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

    public void mouseMoved(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {}

    public void mouseEntered(MouseEvent e)  {}

    public void mouseExited(MouseEvent e)  {}
    
    
    
    
    
    
    
    
    
}

