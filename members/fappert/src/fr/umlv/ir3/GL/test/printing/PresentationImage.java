/*
 * Created on 21 nov. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.test.printing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/**
 * @author binou
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class PresentationImage {

	public static void main(String[] args) {
		WindowListener listener = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};

		MaFrame _fenetre = new MaFrame("Impression 2 deja vue");
		_fenetre.addWindowListener(listener);
		_fenetre.show();
	}
}