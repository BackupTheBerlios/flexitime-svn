package fr.umlv.ir3.flexitime.richClient.gui.panel;
import java.awt.BorderLayout;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;


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
	 * @throws RemoteException 
	 * 
	 */
	public ManagementView() throws RemoteException 
	{
		/*List lstTrack = RemoteDataManager.getManager().getTracks();
        List lstDevice= RemoteDataManager.getManager().getDevices();
        List lstBuilding = RemoteDataManager.getManager().getBuildings() ;
        List lstTeacher =RemoteDataManager.getManager().getTeachers();*/
        
        List lstTrack = new ArrayList();
        List lstDevice= new ArrayList();
        List lstBuilding = new ArrayList();
        List lstTeacher =new ArrayList();
        
        panel = new JPanel(new BorderLayout());
        OutlookBarManagement fb1 = new OutlookBarManagement(panel,lstTrack,lstDevice,lstBuilding,lstTeacher);
		//NameView trackView = new NameView((IData)lstTrack.get(0));
		JPanel panel1 = new JPanel(new BorderLayout());
        //panel1.add(new JScrollPane(trackView.getPanel()), BorderLayout.CENTER);
        //panel1.setBorder(BorderFactory.createTitledBorder("Filière"));
        
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
