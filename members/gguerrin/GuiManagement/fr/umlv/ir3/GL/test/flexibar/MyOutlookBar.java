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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;

import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.richClient.models.ClassTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.RootTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.TrackModel;
import fr.umlv.ir3.flexitime.richClient.models.TrackTreeNode;

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
	JTextArea textArea;
    JTextField textField;
    JList list;
    JTable table;
    JTree tree;

    public MyOutlookBar(List listTrack) {
        panel1 = new JPanel(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        //Create a table model.
        DefaultTableModel tm = new DefaultTableModel();
        tm.addColumn("Column 0");
        tm.addColumn("Column 1");
        tm.addColumn("Column 2");
        tm.addColumn("Column 3");
        tm.addRow(new String[]{"Table 00", "Table 01", "Table 02", "Table 03"});
        tm.addRow(new String[]{"Table 10", "Table 11", "Table 12", "Table 13"});
        tm.addRow(new String[]{"Table 20", "Table 21", "Table 22", "Table 23"});
        tm.addRow(new String[]{"Table 30", "Table 31", "Table 32", "Table 33"});

        //LEFT COLUMN
        //Use the table model to create a table.
        table = new JTable(tm);
        panel.add(new JScrollPane(createPanelForComponent(table, "JTable")));

        //Create a textfield.
        textField = new JTextField(30);
        textField.setText("pwet");
        //panel.add(createPanelForComponent(textField, "JTextField"));

        //Create a scrolled text area.
        textArea = new JTextArea(5, 30);
        textArea.setText("Favorite shows:\nBuffy, Alias, Angel");
        JScrollPane scrollPane = new JScrollPane(textArea);
        //panel.add(createPanelForComponent(scrollPane, "JTextArea"));

        //Create a list model and a list.
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("VideoIR1");
        listModel.addElement("VideoIR2");
        listModel.addElement("VideoIR3");
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        JScrollPane listView = new JScrollPane(list);
        listView.setPreferredSize(new Dimension(300, 100));
        //panel.add(createPancelForComponent(listView, "JList"));

        //salles
        RootTreeNode rootTree1 = new RootTreeNode(null,listTrack);
        DefaultTreeModel model1 = new DefaultTreeModel(rootTree1);
        rootTree1.setModel(model1);
        JTree tree1 = new JTree(model1);
        tree1.getSelectionModel().setSelectionMode
              (TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
        tree1.setRootVisible(false);
        tree1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tree1.setAutoscrolls(true);
        //matiere
        RootTreeNode rootTree2 = new RootTreeNode(null,listTrack);
        DefaultTreeModel model2 = new DefaultTreeModel(rootTree2);
        rootTree2.setModel(model2);
        JTree tree2 = new JTree(model2);
        tree2.getSelectionModel().setSelectionMode
              (TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
        tree2.setRootVisible(false);
        tree2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tree2.setAutoscrolls(true);
        //track
        RootTreeNode rootTree = new RootTreeNode(null,listTrack);
        DefaultTreeModel model = new DefaultTreeModel(rootTree);
        rootTree.setModel(model);
        tree = new JTree(model);
        tree.getSelectionModel().setSelectionMode
              (TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
        tree.setRootVisible(false);
        tree.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tree.setAutoscrolls(true);
        MouseListener mouseLis = new MouseListener()
        {

			public void mouseClicked(MouseEvent arg0) {
				if(arg0.isPopupTrigger())
					{
						JTree tmpTree = (JTree)arg0.getSource();
						//tmpTree.getSelectionPath().getLastPathComponent();
						System.out.println("PopupTrigger"+ tmpTree.getSelectionPath().getLastPathComponent());
					}
				
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent arg0) {
				if(arg0.isPopupTrigger())
				{
					JTree tmpTree = (JTree)arg0.getSource();
					TreeNode tmpTreeNode = (TreeNode)tmpTree.getSelectionPath().getLastPathComponent();
					System.out.println("PopupTrigger sur "+ tmpTreeNode + "  type:"+ tmpTreeNode.getClass());
					if(tmpTreeNode instanceof ClassTreeNode)
					{
						IClass iClass = ((ClassTreeNode)tmpTreeNode).getIClass();
						System.out.println("Mon papa est:"+iClass.getParentTrack().getName());
					}
				}
				
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        };
        tree.addMouseListener(mouseLis);
        JScrollPane scroll = new JScrollPane(tree);
        scroll.setPreferredSize(new Dimension(300,100));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //panel.add(scroll);
        JScrollPane scroll2 = new JScrollPane(tree2);
        scroll2.setPreferredSize(new Dimension(300,100));
        scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane scroll3 = new JScrollPane(tree1);
        scroll3.setPreferredSize(new Dimension(300,100));
        scroll3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        FlexiBar ob = new FlexiBar();
        ob.add("Filières",scroll);
        ob.add("Matériels", scroll2);
        ob.add("Salles",scroll3);
        ob.add("Professeurs",list);
        
        panel1.add(ob, BorderLayout.WEST);
        //add(panel, BorderLayout.CENTER);
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
    

}
