/*
 * Created on 21 nov. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.test.printing;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * @author binou
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
class MaFrame extends JFrame {

	MonPanel _panel;

	public MaFrame(String titre) {
		super(titre);
		initComposants();
	}

	/* on initialise les composants graphiques */
	protected void initComposants() {
		this.setSize(new Dimension(500, 480));
		this.setVisible(true);

		JPanel contentPane = (JPanel) this.getContentPane();
		_panel = new MonPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(_panel, BorderLayout.CENTER);
	}
}