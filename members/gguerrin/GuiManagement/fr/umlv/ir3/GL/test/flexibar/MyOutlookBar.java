/*
 * Created on 18 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.test.flexibar;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;


import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.richClient.gui.actions.DefaultActions;
import fr.umlv.ir3.flexitime.richClient.gui.actions.TrackActions;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.DevicesView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.RoomsView;
import fr.umlv.ir3.flexitime.richClient.models.*;


/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MyOutlookBar
{
	static JFrame frame;
    JPanel panel1;
	JPanel panelParent;
    JTextArea textArea;
    JTextField textField;
    JList list;
    JTable table;
    JTree tree;

    public MyOutlookBar(JPanel panelParent,List listTrack,List listDevice,List listBuilding) {
        this.panelParent = panelParent;
    	panel1 = new JPanel(new BorderLayout());
        //JPanel panel = new JPanel();
        //panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        //panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        //Create a list model and a list.
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("GUERRIN Guillaume");
        listModel.addElement("GUERS Jerome");
        listModel.addElement("APPERT Fabien");
        
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        JScrollPane listView = new JScrollPane(list);
        listView.setPreferredSize(new Dimension(300, 100));
        //panel.add(createPancelForComponent(listView, "JList"));

        //track
        RootTreeNode rootTrackTree = new RootTrackTreeNode(null,listTrack);
        JTree treeTrack = createJTree(rootTrackTree);
        treeTrack.addMouseListener(createTrackMouseLister());
        JScrollPane scrollTrack = new JScrollPane(treeTrack);
        scrollTrack.setPreferredSize(new Dimension(300,100));
        scrollTrack.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //materiel
        RootTreeNode rootDeviceTree = new RootDeviceTreeNode(null,listDevice);
        JTree treeDevice = createJTree(rootDeviceTree);
        treeDevice.addMouseListener(createDeviceMouseLister());
        JScrollPane scrollDevice = new JScrollPane(treeDevice);
        scrollDevice.setPreferredSize(new Dimension(300,100));
        scrollDevice.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //salles
        RootTreeNode rootRoomTree = new RootRoomTreeNode(null,listBuilding);
        JTree treeRoom =createJTree(rootRoomTree);
        treeRoom.addMouseListener(createRoomMouseLister());
        JScrollPane scrollRoom = new JScrollPane(treeRoom);
        scrollRoom.setPreferredSize(new Dimension(300,100));
        scrollRoom.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        FlexiBar ob = new FlexiBar();
        ob.add("Filières",scrollTrack);
        ob.add("Matériels", scrollDevice);
        ob.add("Salles",scrollRoom);
        ob.add("Professeurs",list);
        
        panel1.add(ob, BorderLayout.WEST);
        panel1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
    
    public JPanel getPanel()
    {
    	return panel1;
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
    	final ResourceModel model = new ResourceModel(rootTree);
    	rootTree.setModel(model);
        final JTree tmpTree = new JTree(model);
        //tmpTree.getSelectionModel().setSelectionMode
        //      (TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
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

    
    public MouseListener createTrackMouseLister()
    {
    	MouseListener mouseLis = new MouseListener()
        {
    		public void mouseReleased(MouseEvent arg0) {
				if(arg0.isPopupTrigger())
				{
					JTree tmpTree = (JTree)arg0.getSource();
					if(tmpTree.getSelectionPath()!= null)
					{
						TreeNode tmpTreeNode = (TreeNode)tmpTree.getSelectionPath().getLastPathComponent();
						JPopupMenu popMenu;
						if(tmpTreeNode instanceof TrackTreeNode)
						{
							String[] name = new String[]{"Ajouter une Filière","Ajouter une Promotion","Supprimer"};
							Action[] action = new Action[]{DefaultActions.add(tmpTree.getModel(),tmpTreeNode.getParent()) ,DefaultActions.add(tmpTree.getModel(),tmpTreeNode) ,DefaultActions.remove(tmpTree.getModel(),tmpTreeNode)};
							popMenu = createPopupMenu(name,action);
							popMenu.show(arg0.getComponent(),arg0.getX(),arg0.getY());
						}
						else if(tmpTreeNode instanceof ClassTreeNode)
						{
							String[] name = new String[]{"Ajouter un Groupe","Supprimer"};
							Action[] action = new Action[]{DefaultActions.add(tmpTree.getModel(),tmpTreeNode) ,DefaultActions.remove(tmpTree.getModel(),tmpTreeNode)};
							popMenu = createPopupMenu(name,action);
							popMenu.show(arg0.getComponent(),arg0.getX(),arg0.getY());
						}
						else if(tmpTreeNode instanceof GroupTreeNode)
						{
							String[] name = new String[]{"Supprimer"};
							Action[] action = new Action[]{DefaultActions.remove(tmpTree.getModel(),tmpTreeNode)};
							popMenu = createPopupMenu(name,action);
							popMenu.show(arg0.getComponent(),arg0.getX(),arg0.getY());
						}
					}
					else
					{
						JPopupMenu popMenu;
						String[] name = new String[]{"Ajouter une Filière"};
						Action[] action = new Action[]{DefaultActions.add(tmpTree.getModel(),(RootTreeNode)tmpTree.getModel().getRoot())};
						popMenu = createPopupMenu(name,action);
						popMenu.show(arg0.getComponent(),arg0.getX(),arg0.getY());
					}
				}
				
			}
    		
    		public void mousePressed(MouseEvent arg0) {
				if(arg0.isPopupTrigger())
				{
					//TODO Peut etre mettre une copie de MouseReleased 
				}
				
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0){}
        	
        };
        return mouseLis;
    }
    
    
    public MouseListener createDeviceMouseLister()
    {
    	MouseListener mouseLis = new MouseListener()
        {
    		public void mouseReleased(MouseEvent arg0) {
				if(arg0.isPopupTrigger())
				{
					JTree tmpTree = (JTree)arg0.getSource();
					if(tmpTree.getSelectionPath()!= null)
					{
						TreeNode tmpTreeNode = (TreeNode)tmpTree.getSelectionPath().getLastPathComponent();
						JPopupMenu popMenu;
						if(tmpTreeNode instanceof TypeDeviceTreeNode)
						{
							String[] name = new String[]{"Ajouter un Matériel","Supprimer"};
							Action[] action = new Action[]{DefaultActions.add(tmpTree.getModel(),tmpTreeNode) ,DefaultActions.remove(tmpTree.getModel(),tmpTreeNode)};
							popMenu = createPopupMenu(name,action);
							popMenu.show(arg0.getComponent(),arg0.getX(),arg0.getY());
						}
						else if(tmpTreeNode instanceof DeviceTreeNode)
						{
							String[] name = new String[]{"Supprimer"};
							Action[] action = new Action[]{DefaultActions.remove(tmpTree.getModel(),tmpTreeNode)};
							popMenu = createPopupMenu(name,action);
							popMenu.show(arg0.getComponent(),arg0.getX(),arg0.getY());
						}
			
					}
				}
				
			}
    		
    		public void mousePressed(MouseEvent arg0) {
				if(arg0.isPopupTrigger())
				{
					//TODO Peut etre mettre une copie de MouseReleased 
				}
				
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0)
			{
				DevicesView deviceView = new DevicesView();
				JPanel panel1 = new JPanel(new BorderLayout());
		        panel1.add(new JScrollPane(deviceView), BorderLayout.CENTER);
		        panel1.setBorder(BorderFactory.createTitledBorder("Matériel"));
		        panel1.setVisible( true);
		        panelParent.remove(0);
		        panelParent.add(panel1, BorderLayout.CENTER,0);
		        panelParent.validate() ;
		        panelParent.repaint();
			}
        	
        };
        return mouseLis;
    }
    
    public MouseListener createRoomMouseLister()
    {
    	MouseListener mouseLis = new MouseListener()
        {
    		public void mouseReleased(MouseEvent arg0) {
				if(arg0.isPopupTrigger())
				{
					JTree tmpTree = (JTree)arg0.getSource();
					if(tmpTree.getSelectionPath()!= null)
					{
						TreeNode tmpTreeNode = (TreeNode)tmpTree.getSelectionPath().getLastPathComponent();
						JPopupMenu popMenu;
						if(tmpTreeNode instanceof BuildingTreeNode)
						{
							String[] name = new String[]{"Ajouter un Batiment","Ajouter un Etage","Supprimer"};
							Action[] action = new Action[]{DefaultActions.add(tmpTree.getModel(),tmpTreeNode.getParent()) ,DefaultActions.add(tmpTree.getModel(),tmpTreeNode) ,DefaultActions.remove(tmpTree.getModel(),tmpTreeNode)};
							popMenu = createPopupMenu(name,action);
							popMenu.show(arg0.getComponent(),arg0.getX(),arg0.getY());
						}
						else if(tmpTreeNode instanceof FloorTreeNode)
						{
							String[] name = new String[]{"Supprimer"};
							Action[] action = new Action[]{DefaultActions.remove(tmpTree.getModel(),tmpTreeNode)};
							popMenu = createPopupMenu(name,action);
							popMenu.show(arg0.getComponent(),arg0.getX(),arg0.getY());
						}
						else if(tmpTreeNode instanceof TypeRoomTreeNode)
						{
							String[] name = new String[]{"Ajouter une salle"};
							Action[] action = new Action[]{DefaultActions.add(tmpTree.getModel(),tmpTreeNode)};
							popMenu = createPopupMenu(name,action);
							popMenu.show(arg0.getComponent(),arg0.getX(),arg0.getY());
						}
						else if(tmpTreeNode instanceof RoomTreeNode)
						{
							String[] name = new String[]{"Supprimer"};
							Action[] action = new Action[]{DefaultActions.remove(tmpTree.getModel(),tmpTreeNode)};
							popMenu = createPopupMenu(name,action);
							popMenu.show(arg0.getComponent(),arg0.getX(),arg0.getY());
						}
			
					}
					else
					{
						JPopupMenu popMenu;
						String[] name = new String[]{"Ajouter un Batiment"};
						Action[] action = new Action[]{DefaultActions.add(tmpTree.getModel(),(RootTreeNode)tmpTree.getModel().getRoot())};
						popMenu = createPopupMenu(name,action);
						popMenu.show(arg0.getComponent(),arg0.getX(),arg0.getY());
					}
				}
				
			}
    		
    		public void mousePressed(MouseEvent arg0) {
				if(arg0.isPopupTrigger())
				{
					//TODO Peut etre mettre une copie de MouseReleased 
				}
				
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0)
			{
				RoomsView roomView = new RoomsView();
				JPanel panel1 = new JPanel(new BorderLayout());
		        panel1.add(new JScrollPane(roomView), BorderLayout.CENTER);
		        panel1.setBorder(BorderFactory.createTitledBorder("Salle"));
		        panel1.setVisible( true);
		        panelParent.remove(0);
		        panelParent.add(panel1, BorderLayout.CENTER,0);
		        panelParent.validate() ;
		        panelParent.repaint();
			}
        	
        };
        return mouseLis;
    }
    
    public JPopupMenu createPopupMenu(String[] name,Action[] action)
    {
    	JPopupMenu popMenu = new JPopupMenu();
    	JMenuItem menuItem;
    	for (int i=0; i<name.length  ;i++)
		{
			menuItem = new JMenuItem();
			menuItem.setAction(action[i]);
			menuItem.setText(name[i]);
			popMenu.add(menuItem);
		}	
    	popMenu.setVisible(true);
		return popMenu;
		
    }
}
