/*
 * Created on 18 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;



import fr.umlv.ir3.flexitime.richClient.gui.actions.management.DefaultTreeActions;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiMouseListenerFactory;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiSelectionListenerFactory;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.*;
import fr.umlv.ir3.flexitime.richClient.models.*;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;
import fr.umlv.ir3.flexitime.richClient.models.management.RootTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.device.RootDeviceTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.room.RootRoomTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.teacher.TeacherListModel;
import fr.umlv.ir3.flexitime.richClient.models.management.track.RootTrackTreeNode;


/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class OutlookBarManagement
{
	//static JFrame frame;
	JPanel panelOutlookBar;
	JComponent panelParent;
    //JPanel panelParent;
    //JList list;


    public OutlookBarManagement(/*JPanel*/JComponent panelParent,List listTrack,List listDevice,List listBuilding,List listTeacher) {
        this.panelParent = panelParent;
    	panelOutlookBar = new JPanel(new BorderLayout());
    	//panelOutlookBar.setPreferredSize();
    	//Create a list model and a list for the Teachers.
        TeacherListModel listModel = new TeacherListModel(listTeacher);
        JList list = new JList(listModel);
        list.addMouseListener(FlexiMouseListenerFactory.createTeacherMouseLister());
        list.addListSelectionListener(FlexiSelectionListenerFactory.createTeacherListSelectionListener(this.panelParent));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listView = new JScrollPane(list);
        listView.setPreferredSize(new Dimension(300, 100));
        listView.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //Tree for track
        RootTreeNode rootTrackTree = new RootTrackTreeNode(null,listTrack);
        JTree treeTrack = createJTree(rootTrackTree);
        treeTrack.addMouseListener(FlexiMouseListenerFactory.createTrackMouseLister());
        treeTrack.addTreeSelectionListener(FlexiSelectionListenerFactory.createTrackTreeSelectionListener(this.panelParent));
        JScrollPane scrollTrack = new JScrollPane(treeTrack);
        scrollTrack.setPreferredSize(new Dimension(300,100));
        scrollTrack.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //Tree for materiel
        RootTreeNode rootDeviceTree = new RootDeviceTreeNode(null,listDevice);
        JTree treeDevice = createJTree(rootDeviceTree);
        treeDevice.addMouseListener(FlexiMouseListenerFactory.createDeviceMouseLister());
        treeDevice.addTreeSelectionListener(FlexiSelectionListenerFactory.createDeviceTreeSelectionListener(this.panelParent));
        JScrollPane scrollDevice = new JScrollPane(treeDevice);
        scrollDevice.setPreferredSize(new Dimension(300,100));
        scrollDevice.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //Tree for salles
        RootTreeNode rootRoomTree = new RootRoomTreeNode(null,listBuilding);
        JTree treeRoom =createJTree(rootRoomTree);
        treeRoom.addMouseListener(FlexiMouseListenerFactory.createRoomMouseLister());
        treeRoom.addTreeSelectionListener(FlexiSelectionListenerFactory.createRoomTreeSelectionListener(this.panelParent));
        JScrollPane scrollRoom = new JScrollPane(treeRoom);
        scrollRoom.setPreferredSize(new Dimension(300,100));
        scrollRoom.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        FlexiBar ob = new FlexiBar();
        ob.add("Filières",scrollTrack);
        ob.add("Matériels", scrollDevice);
        ob.add("Salles",scrollRoom);
        ob.add("Professeurs",listView);
        panelOutlookBar.add(ob, BorderLayout.WEST);
        panelOutlookBar.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
    
    public JPanel getPanel()
    {
    	return panelOutlookBar;
    }
    

    public JPanel createPanelForComponent(JComponent comp,
                                          String title) {
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
