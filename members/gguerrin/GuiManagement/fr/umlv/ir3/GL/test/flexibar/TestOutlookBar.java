package fr.umlv.ir3.GL.test.flexibar;

/**
 * @author binou
 *
 *	Class to test OutlookBar Panel
 *
 */


import java.awt.*;

import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.table.*;


public class TestOutlookBar extends JPanel 
{
    static JFrame frame;
    JTextArea textArea;
    JTextField textField;
    JList list;
    JTable table;
    JTree tree;

    public TestOutlookBar() {
        super(new BorderLayout());
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
        listModel.addElement("IR 1");
        listModel.addElement("IR 2");
        listModel.addElement("IR 3");
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        JScrollPane listView = new JScrollPane(list);
        listView.setPreferredSize(new Dimension(300, 100));
        //panel.add(createPanelForComponent(listView, "JList"));

        //Create a tree.
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Bâtiments");
        DefaultMutableTreeNode sharon = new DefaultMutableTreeNode("Copernic");
        rootNode.add(sharon);
        DefaultMutableTreeNode maya = new DefaultMutableTreeNode("Rez de chaussée");
        sharon.add(maya);
        sharon.add(new DefaultMutableTreeNode("1er étage"));
        DefaultMutableTreeNode anya = new DefaultMutableTreeNode("2ème étage");
        sharon.add(anya);
        
        maya.add(new DefaultMutableTreeNode("auditorium"));
        anya.add(new DefaultMutableTreeNode("2027"));
        DefaultTreeModel model = new DefaultTreeModel(rootNode);
        tree = new JTree(model);
        tree.getSelectionModel().setSelectionMode
              (TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
        JScrollPane treeView = new JScrollPane(tree);
        treeView.setPreferredSize(new Dimension(300, 100));
        //panel.add(createPanelForComponent(treeView, "Salles"));

        JScrollPane scroll = new JScrollPane(tree);
        scroll.setPreferredSize(new Dimension(600,600));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //panel.add(scroll);
        
        FlexiBar ob = new FlexiBar();
        ob.add("Filières",table);//list);
        ob.add("Matériels", textField);
        ob.add("Salles",tree);
       // ob.add(new JButton("Matières"),list);
       // ob.add(new JButton("Professeurs"),tree);
        
        add(ob, BorderLayout.WEST);
        //add(panel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
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

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
   /* private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        frame = new JFrame("test de la OutlookBar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new TestOutlookBar();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }*/

   /* public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }*/
}

