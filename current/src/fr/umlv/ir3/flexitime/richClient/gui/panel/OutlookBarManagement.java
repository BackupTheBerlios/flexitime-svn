/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.panel;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.TreeSelectionModel;

import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiMouseListenerFactory;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiSelectionListenerFactory;
import fr.umlv.ir3.flexitime.richClient.gui.renderers.FlexiTreeRenderer;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;
import fr.umlv.ir3.flexitime.richClient.models.management.RootTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.device.RootDeviceTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.room.RootRoomTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.teacher.TeacherListModel;
import fr.umlv.ir3.flexitime.richClient.models.management.track.RootTrackTreeNode;


/**
 * represents all the left view with all the information
 * @author Guillaume GUERRIN
 */
public class OutlookBarManagement
{
	//static JFrame frame;
	JPanel panelOutlookBar;
	JComponent panelParent;
    TeacherListModel listModel;
    //JPanel panelParent;
    //JList list;


    public OutlookBarManagement(final /*JPanel*/JComponent panelParent,List listTrack,List listDevice,List listBuilding,List listTeacher) throws RemoteException 
    {

        this.panelParent = panelParent;
        panelOutlookBar = new JPanel(new BorderLayout());
        //panelOutlookBar.setPreferredSize();
        //Create a list model and a list for the Teachers.
        listModel = new TeacherListModel(listTeacher);
        JList list = new JList(listModel);
        list.addMouseListener(FlexiMouseListenerFactory.createTeacherMouseLister());
        list.addListSelectionListener(FlexiSelectionListenerFactory.createTeacherListSelectionListener(this.panelParent));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listView = new JScrollPane(list);
        //listView.setPreferredSize(new Dimension(300, 100));
        listView.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //Tree for track
        RootTreeNode rootTrackTree;
		rootTrackTree = new RootTrackTreeNode(null,listTrack);
        JTree treeTrack = createJTree(rootTrackTree);
        treeTrack.addMouseListener(FlexiMouseListenerFactory.createTrackMouseLister());
        treeTrack.addTreeSelectionListener(FlexiSelectionListenerFactory.createTrackTreeSelectionListener(this.panelParent,listModel));
        JScrollPane scrollTrack = new JScrollPane(treeTrack);
        //scrollTrack.setPreferredSize(new Dimension(300,100));
        scrollTrack.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        treeTrack.getDragEnabled();
       
        //Tree for materiel
        RootTreeNode rootDeviceTree = new RootDeviceTreeNode(null,listDevice);
        JTree treeDevice = createJTree(rootDeviceTree);
        treeDevice.addMouseListener(FlexiMouseListenerFactory.createDeviceMouseLister());
        treeDevice.addTreeSelectionListener(FlexiSelectionListenerFactory.createDeviceTreeSelectionListener(this.panelParent));
        JScrollPane scrollDevice = new JScrollPane(treeDevice);
        //scrollDevice.setPreferredSize(new Dimension(300,100));
        scrollDevice.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //DefaultTreeCellRenderer renderer =new DefaultTreeCellRenderer();
        //renderer.setLeafIcon();
        //System.out.println(treeDevice.getCellRenderer().getTreeCellRendererComponent(treeDevice,rootDeviceTree,true,false,false,1,true));
        treeDevice.setCellRenderer(new FlexiTreeRenderer());
        //Tree for salles
        RootTreeNode rootRoomTree = new RootRoomTreeNode(null,listBuilding);
        JTree treeRoom =createJTree(rootRoomTree);
        treeRoom.addMouseListener(FlexiMouseListenerFactory.createRoomMouseLister());
        treeRoom.addTreeSelectionListener(FlexiSelectionListenerFactory.createRoomTreeSelectionListener(this.panelParent));
        JScrollPane scrollRoom = new JScrollPane(treeRoom);
        //scrollRoom.setPreferredSize(new Dimension(300,100));
        scrollRoom.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       
        
        FlexiBar ob = new FlexiBar();
        ob.add("Filières",scrollTrack);
        ob.add("Matériels", scrollDevice);
        ob.add("Salles",scrollRoom);
        ob.add("Professeurs",listView);
        panelOutlookBar.add(ob, BorderLayout.WEST);
       // ob.setPreferredSize(ob.getParent().getPreferredSize());
        panelOutlookBar.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
    
    public JPanel getPanel()
    {
    	return panelOutlookBar;
    }
    

    public JPanel createPanelForComponent(JComponent comp,String title) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(comp, BorderLayout.CENTER);
        if (title != null) {
            panel.setBorder(BorderFactory.createTitledBorder(title));
        }
        return panel;
    }
    
    public JTree createJTree(RootTreeNode rootTree)
    {
    	final ResourceTreeModel model = new ResourceTreeModel(rootTree);
    	rootTree.setModel(model);
        final JTree tmpTree = new JTree(model);
        tmpTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tmpTree.setRootVisible(false);
        tmpTree.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tmpTree.setAutoscrolls(true);
        
        tmpTree.setEditable(true);

        tmpTree.getCellEditor().addCellEditorListener(new CellEditorListener()
		{
			public void editingCanceled(ChangeEvent e) 
			{
				if(((String)tmpTree.getCellEditor().getCellEditorValue()).compareTo("")!= 0)
					model.valueForPathChanged(tmpTree.getSelectionPath(),tmpTree.getCellEditor().getCellEditorValue() );
			}
			public void editingStopped(ChangeEvent e) {}
		});
        return tmpTree;
    }
}
