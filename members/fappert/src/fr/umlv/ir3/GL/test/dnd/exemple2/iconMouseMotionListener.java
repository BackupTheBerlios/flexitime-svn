/*
 * Created on 28 nov. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.test.dnd.exemple2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 * @author binou
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class iconMouseMotionListener implements MouseMotionListener {

	JLabel label;
	
	/**
	 * @param label
	 */
	public iconMouseMotionListener(JLabel label) {
		
		this.label = label;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	public void mouseDragged(MouseEvent arg0) {
		label.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
