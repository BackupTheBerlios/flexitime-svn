/*
 * Created on 29 nov. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.test.flexibar;

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
 * The Flexitime custom outlookbar
 */
public class FlexiBar extends JPanel
{
	/**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3256720676126536758L;
    
    private final int B_WIDTH = 120;
	private final int B_HEIGHT = 20;
	private final int P_WIDTH = 120;
	private final int P_HEIGHT = Integer.MAX_VALUE;
	
	BoxLayout layout;
	JPanel panel;
	ArrayList<JComponent> listComponent;
	int currentSelected = -1;

	
	/**
	 * 
	 */
	public FlexiBar() {
		super(new BorderLayout());
		panel = new JPanel();
		layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		//panel.setSize(30,150);
		panel.setPreferredSize(new Dimension(P_WIDTH,400));
		add(panel);
		
		listComponent = new ArrayList<JComponent>();
	}
	
	/** 
	 * Create a new tab to the FlexiBar, with the specified 
     * title and the specified component inside the tab.
	 *
	 * @param title the title of the tab to be added
	 * @param comp the component inserted in the tab 
	 * 
	 */
	public void add(String title, JComponent comp)
	{
        JButton button = new JButton(title);
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
		this.validate();
		this.repaint();
		System.err.println("setSelected => " + currentSelected);
	}
}
