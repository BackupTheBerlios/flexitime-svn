package fr.umlv.ir3.GL.test.printing;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import javax.swing.JButton;
import javax.swing.JPanel;

class MyButton extends JButton implements Printable {

	public MyButton() {
		super("Print");

	}

	public int print(Graphics g, PageFormat pf, int pi) throws PrinterException {
		Graphics2D g2 = (Graphics2D) g;
		g2.translate(pf.getImageableX(), pf.getImageableY());
		Font f = new Font("Monospaced", Font.PLAIN, 12);
		g2.setFont(f);
		paint(g2);
		return Printable.PAGE_EXISTS;
	}
}

public class print2button extends JPanel implements ActionListener {

	private JButton b, b2;

	public print2button() {
		setBackground(Color.white);
		b = new MyButton();
		b2 = new MyButton();
		b2.setLabel("Print 2");
		b.addActionListener(this);
		b2.addActionListener(this);
		add(b);
		add(b2);

	}

	public void actionPerformed(ActionEvent e) {
		PrintUtilities.printComponent(this);
	}

	public static void main(String s[]) {
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		Frame f = new Frame("print2button");
		f.addWindowListener(l);
		f.add("Center", new print2button());
		f.pack();
		f.setSize(new Dimension(400, 300));
		f.show();
	}
}