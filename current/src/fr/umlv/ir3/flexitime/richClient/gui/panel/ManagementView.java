package fr.umlv.ir3.flexitime.richClient.gui.panel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

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
    JSplitPane jSP;
	/**
	 * @throws RemoteException 
	 * 
	 */
	public ManagementView() throws RemoteException 
	{
		List lstTrack = RemoteDataManager.getManager().getTracks();
        List lstDevice= RemoteDataManager.getManager().getDevices();
        List lstBuilding = RemoteDataManager.getManager().getBuildings() ;
        List lstTeacher =RemoteDataManager.getManager().getTeachers();
        
        //List lstTrack = new ArrayList();
       //List lstDevice= new ArrayList();
       // List lstBuilding = new ArrayList();
        //List lstTeacher =new ArrayList();
        
        panel = new JPanel(new BorderLayout());
        jSP = new JSplitPane();
        
        //OutlookBarManagement fb1 = new OutlookBarManagement(panel,lstTrack,lstDevice,lstBuilding,lstTeacher);
        OutlookBarManagement fb1 = new OutlookBarManagement(jSP,lstTrack,lstDevice,lstBuilding,lstTeacher);
		//NameView trackView = new NameView((IData)lstTrack.get(0));
		JPanel panel1 = new JPanel(new BorderLayout());
        //panel1.add(new JScrollPane(trackView.getPanel()), BorderLayout.CENTER);
        //panel1.setBorder(BorderFactory.createTitledBorder("Filière"));
        
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(fb1.getPanel(), BorderLayout.CENTER);
        //panel2.setBorder(BorderFactory.createTitledBorder("Visualisation"));
        //panel2.setMinimumSize(new Dimension(180,90));
        //panel2.setMaximumSize(new Dimension(200,200));
       /* fb1.getPanel().setMinimumSize(new Dimension(110,90));
        fb1.getPanel().setMaximumSize(new Dimension(110,90));
        fb1.getPanel().setPreferredSize(new Dimension(110,100));*/
        
        /*panel.add(panel1, BorderLayout.CENTER,0);
	    panel.add(panel2, BorderLayout.WEST,1);*/
        jSP.add(panel1, JSplitPane.RIGHT,0);
        jSP.add(panel2,  JSplitPane.LEFT,1);
        jSP.setDividerLocation(180 + jSP.getInsets().left);
        jSP.setDividerSize(3);

        //jSP.setContinuousLayout(true);
	}
	
	public JPanel getPanel()
	{
		return panel;
	}
    public JSplitPane getJSP()
    {
        return jSP;
    }

}
