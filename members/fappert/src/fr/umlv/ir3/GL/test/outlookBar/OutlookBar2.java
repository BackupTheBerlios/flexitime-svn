/*
 * Created on 29 nov. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.test.outlookBar;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;


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
public class OutlookBar2 extends JPanel
{
	BoxLayout layout;
	JPanel panel;
	ArrayList listButton;
	ArrayList listComponent;
	int currentSelected = 0;
	
	/**
	 * 
	 */
	public OutlookBar2() {
		super(new BorderLayout());
		panel = new JPanel();
		layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		add(panel);
		
		listButton = new ArrayList();
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
		listButton.add(button);
		listComponent.add(comp);
		//rebuilt();
	}

	private final void setSelected(JButton button)
	{
		currentSelected = listButton.indexOf(button);
		System.err.println("setSelected => " + currentSelected);
		rebuilt();
	}
	
	/**
	 * 
	 */
	private void rebuilt()
	{
		System.out.println("rebuilt");
		//panel.removeAll();
		int i = 0;
		for (Iterator iter = listButton.iterator(); iter.hasNext();) {
			JButton button = (JButton) iter.next();
			//panel.add(button,i);
			panel.add(button, BorderLayout.NORTH);
			System.err.println("ajout de : " + button.getText());
			if(currentSelected == i)
			{
				System.err.println(" + son Component");
				
				//panel.add((JComponent)listComponent.get(i),++i);
				//panel.setPreferredSize(new Dimension())
				
				panel.add((JComponent)listComponent.get(i),BorderLayout.CENTER);
			}
			i++;
		}
		panel.updateUI();
	}
	
	private void refresh()
	{
		
	}
}
