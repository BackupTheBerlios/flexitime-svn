/*
 * Created on 28 nov. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.test.dnd;

/*
 * BasicDnD.java is a 1.4 example that requires
 * no other files.
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.table.*;

import fr.umlv.ir3.GL.test.printing.PrintUtilities;

public class TestDnD extends JPanel implements ActionListener {
    static JFrame frame;
    JTextArea textArea;
    JList list;
    JTable table;
    JTree tree;
    JCheckBox toggleDnD;

    public TestDnD() {
        super(new BorderLayout());
        JPanel leftPanel = createVerticalBoxPanel();
        JPanel rightPanel = createVerticalBoxPanel();

        
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

        //RIGHT COLUMN
        //Use the table model to create a table.
        table = new JTable(tm);
        rightPanel.add(createPanelForComponent(table, "JTable"));





        //LEFT COLUMN
        //Create a tree.
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Mia Familia");
        DefaultMutableTreeNode sharon = new DefaultMutableTreeNode("Sharon");
        rootNode.add(sharon);
        DefaultMutableTreeNode maya = new DefaultMutableTreeNode("Maya");
        sharon.add(maya);
        DefaultMutableTreeNode anya = new DefaultMutableTreeNode("Anya");
        sharon.add(anya);
        sharon.add(new DefaultMutableTreeNode("Bongo"));
        maya.add(new DefaultMutableTreeNode("Muffin"));
        anya.add(new DefaultMutableTreeNode("Winky"));
        DefaultTreeModel model = new DefaultTreeModel(rootNode);
        tree = new JTree(model);
        tree.getSelectionModel().setSelectionMode
              (TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
        JScrollPane treeView = new JScrollPane(tree);
        treeView.setPreferredSize(new Dimension(300, 100));
        leftPanel.add(createPanelForComponent(treeView, "JTree"));

        
        //Create a list model and a list.
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("Martha Washington");
        listModel.addElement("Abigail Adams");
        listModel.addElement("Martha Randolph");
        listModel.addElement("Dolley Madison");
        listModel.addElement("Elizabeth Monroe");
        listModel.addElement("Louisa Adams");
        listModel.addElement("Emily Donelson");
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        JScrollPane listView = new JScrollPane(list);
        listView.setPreferredSize(new Dimension(300, 100));
        leftPanel.add(createPanelForComponent(listView, "JList"));
        
        
        //Create a scrolled text area.
        textArea = new JTextArea(5, 30);
        textArea.setText("Favorite shows:\nBuffy, Alias, Angel");
        JScrollPane scrollPane = new JScrollPane(textArea);
        leftPanel.add(createPanelForComponent(scrollPane, "JTextArea"));
        
        
        //Create the toggle button.
        toggleDnD = new JCheckBox("Turn on Drag and Drop");
        toggleDnD.setActionCommand("toggleDnD");
        toggleDnD.addActionListener(this);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                              leftPanel, rightPanel);
        splitPane.setOneTouchExpandable(true);

        add(splitPane, BorderLayout.CENTER);
        add(toggleDnD, BorderLayout.PAGE_END);
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }

    protected JPanel createVerticalBoxPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        return p;
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

    public void actionPerformed(ActionEvent e) {
        if ("toggleDnD".equals(e.getActionCommand())) {
            boolean toggle = toggleDnD.isSelected();
            textArea.setDragEnabled(toggle);
            list.setDragEnabled(toggle);
            table.setDragEnabled(toggle);
            tree.setDragEnabled(toggle);
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        frame = new JFrame("BasicDnD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new TestDnD();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        PrintUtilities.printComponent(newContentPane);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
