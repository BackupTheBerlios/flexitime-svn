/*
 * Created on 29 nov. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



/**
 * The Flexitime official OutlookBar !
 * 
 * @version 1.1
 * @author binou
 */
public class FlexiBar extends JPanel
{
	/**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3256438097209407029L;
    
    
    private final int B_WIDTH = 150;
	private final int B_HEIGHT = 20;
	private final int P_WIDTH = 200;
	private final int P_HEIGHT = Integer.MAX_VALUE;
	
	BoxLayout layout;
	JPanel panel;
	List<JComponent> listComponent;
	int currentSelected = -1;

	
	/**
     * Creates a new FlexiBar
	 * 
	 */
	public FlexiBar() {
		super(new BorderLayout());
		panel = new JPanel();
		layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		//panel.setPreferredSize(new Dimension(B_WIDTH,400));
        add(panel);
        //panel.setPreferredSize(panel.getParent().getPreferredSize());
		
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
				//System.out.println("click");
				setSelected((JButton)arg0.getSource());

			}
		});
		//button.setMinimumSize(new Dimension(this.B_WIDTH,this.B_HEIGHT));
		//button.setMaximumSize(new Dimension(this.B_WIDTH,this.B_HEIGHT));
		button.setPreferredSize(new Dimension(this.B_WIDTH,this.B_HEIGHT));
        button.setMaximumSize(new Dimension(this.P_HEIGHT,this.B_HEIGHT));
		

        button.setAlignmentX(LEFT_ALIGNMENT);
        JScrollPane pane = new JScrollPane(comp);
        //pane.setMinimumSize(new Dimension(this.P_WIDTH,this.P_HEIGHT));
        pane.setMaximumSize(new Dimension(this.B_WIDTH,this.P_HEIGHT));
        pane.setPreferredSize(new Dimension(this.B_WIDTH,this.B_HEIGHT));
		//comp.setMinimumSize(new Dimension(this.P_WIDTH,this.P_HEIGHT));
		//comp.setMaximumSize(new Dimension(this.B_WIDTH,this.P_HEIGHT));
		//comp.setPreferredSize(new Dimension(this.P_WIDTH,this.P_HEIGHT));
        
		comp.setAlignmentX(LEFT_ALIGNMENT);
        pane.setAlignmentX(LEFT_ALIGNMENT);
        
		if(currentSelected == -1)
		{
			pane.setVisible(true);
			currentSelected=0;
		}else
			pane.setVisible(false);
		
		listComponent.add(button);
		listComponent.add(pane);
		
		panel.add(button);
        //button.setPreferredSize(button.getParent().getPreferredSize());
        panel.add(pane);
        panel.validate();
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
        
		//System.err.println("setSelected => " + currentSelected);
	}
}
