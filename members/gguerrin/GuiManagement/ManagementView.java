import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.umlv.ir3.GL.test.flexibar.MyOutlookBar;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.DevicesView;


/*
 * Created on 19 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ManagementView 
{
	JPanel panel;
	
	/**
	 * 
	 */
	public ManagementView(List lstTrack,List lstDevice,List lstBuilding) 
	{
		panel = new JPanel(new BorderLayout());
		MyOutlookBar fb1 = new MyOutlookBar(panel,lstTrack,lstDevice,lstBuilding);
		DevicesView deviceView = new DevicesView();
        
		JPanel panel1 = new JPanel(new BorderLayout());
        panel1.add(new JScrollPane(deviceView), BorderLayout.CENTER);
        panel1.setBorder(BorderFactory.createTitledBorder("Matériel"));
        
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(fb1.getPanel(), BorderLayout.CENTER);
        panel2.setBorder(BorderFactory.createTitledBorder("Visualisation"));
        
        panel.add(panel1, BorderLayout.CENTER,0);
	    panel.add(panel2, BorderLayout.WEST,1);
	}
	
	public JPanel getPanel()
	{
		return panel;
	}
}
