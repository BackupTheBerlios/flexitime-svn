/*
 * Created on 29 nov. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.test.outlookBar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;



/**
 * @author binou
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class OutlookBar extends JPanel
{
	private final int B_WIDTH = 90;
	private final int B_HEIGHT = 20;
	private final int P_WIDTH = 90;
	private final int P_HEIGHT = Integer.MAX_VALUE;
	
	BoxLayout layout;
	JPanel panel;
	ArrayList listComponent;
	int currentSelected = -1;

	
	/**
	 * 
	 */
	public OutlookBar() {
		super(new BorderLayout());
		panel = new JPanel();
		layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		//panel.setSize(30,150);
		panel.setPreferredSize(new Dimension(90,400));
		add(panel);
		
		listComponent = new ArrayList();
	}
	
	public void add(JButton button, JComponent comp)
	{
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("click");
				setSelected((JButton)arg0.getSource());

			}
		});
		button.setMinimumSize(new Dimension(this.B_WIDTH,this.B_HEIGHT));
		button.setMaximumSize(new Dimension(this.B_WIDTH,this.B_HEIGHT));
		button.setPreferredSize(new Dimension(this.B_WIDTH,this.B_HEIGHT));
		button.setAlignmentX(LEFT_ALIGNMENT);
		comp.setMinimumSize(new Dimension(this.P_WIDTH,this.P_HEIGHT));
		comp.setMaximumSize(new Dimension(this.P_WIDTH,this.P_HEIGHT));
		//comp.setPreferredSize(new Dimension(this.P_WIDTH,this.P_HEIGHT));
		comp.setAlignmentX(LEFT_ALIGNMENT);
		if(currentSelected == -1)
		{
			comp.setVisible(true);
			currentSelected=0;
		}else
			comp.setVisible(false);
		
		listComponent.add(button);
		listComponent.add(comp);
		
		panel.add(button);
		panel.add(comp);
	}

	private final void setSelected(JButton button)
	{
		if(currentSelected > -1 )
		{
			((JComponent)listComponent.get(currentSelected+1)).setVisible(false);
		}
		currentSelected = listComponent.indexOf(button);
		((JComponent)listComponent.get(currentSelected+1)).setVisible(true);
		
		System.err.println("setSelected => " + currentSelected);
	}
}
