/*
 * Created on 21 nov. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.test.printing;

import javax.swing.JPanel;
import javax.swing.JButton;


import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.print.*;

/*******************************************************************************
 * mon panel derivant de JPanel
 ******************************************************************************/
class MonPanel extends JPanel implements Printable, ActionListener {

	PrinterJob _monJob;
	Image _monImage;
	JButton _btPrint;

	public MonPanel() {
	super();
	_btPrint = new JButton("Imprimer");
	_btPrint.addActionListener(this);
	_monImage = getToolkit().getImage("e:\\img.gif");
	setLayout(new BorderLayout());
	add(_btPrint,BorderLayout.NORTH);
	}

	public void actionPerformed(ActionEvent e) {
	_monJob = PrinterJob.getPrinterJob();
	_monJob.setPrintable(this);
	try {
	_monJob.print();
	} catch (Exception ex) { }
	}

	public int print(Graphics g, PageFormat pf, int i) throws PrinterException {
	if (i >= 1) {
	return Printable.NO_SUCH_PAGE;
	}
	g.drawImage(_monImage,50,50,this);
	return Printable.PAGE_EXISTS;
	}

	public void paint(Graphics g) {
	super.paint(g);
	g.drawImage(_monImage,50,50,this);
	repaint();
	}
	}