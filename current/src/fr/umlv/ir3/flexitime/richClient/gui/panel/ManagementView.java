
/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.panel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.LocalDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.Client;




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
	 * @throws FlexiException 
	 * 
	 */
	public ManagementView() throws RemoteException, FlexiException 
	{
		List lstTrack = LocalDataManager.getManager().getTracks(Client.iUser);
        List lstDevice= LocalDataManager.getManager().getDevices();
        List lstBuilding = LocalDataManager.getManager().getBuildings() ;
        List lstTeacher =LocalDataManager.getManager().getTeachers();
        
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
        panel2.setBorder(BorderFactory.createTitledBorder("Visualisation"));
        panel2.setMinimumSize(new Dimension(180,90));
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
/*jSP.addMouseListener(new MouseListener(){

    public void mouseClicked(MouseEvent arg0)
    {
        if(jSP.getComponents().length >0)
        {
            
        }
        
    }
    public void recursSize(Component comp)
    {
       for(int i=0;i<comp.getComponentCount();i++)
       {
           recursSize(comp.);
       }
    }
    
    public void mousePressed(MouseEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }

    public void mouseReleased(MouseEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }

    public void mouseEntered(MouseEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }

    public void mouseExited(MouseEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }
    
});*/
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
