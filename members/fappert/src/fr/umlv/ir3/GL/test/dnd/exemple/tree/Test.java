/*
 * Created on 28 nov. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.test.dnd.exemple.tree;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.io.*;

public class Test extends JFrame implements DropTargetListener {
	private JTextPane textPane = new JTextPane();

	public Test() {
		super("Drag and Drop With Swing");

		new DropTarget(textPane, 
						DnDConstants.ACTION_COPY_OR_MOVE,
						this);

		JSplitPane splitPane = new JSplitPane(
									JSplitPane.HORIZONTAL_SPLIT,
			   						createTreePanel(), 
									createTextPanel());

		splitPane.setDividerLocation(250);	
		splitPane.setOneTouchExpandable(true);

		getContentPane().add(splitPane, BorderLayout.CENTER);
	}
	public static void main(String args[]) {
		Test test = new Test();

		test.setBounds(300,300,850,350);
		test.setVisible(true);
		test.setDefaultCloseOperation(
							WindowConstants.DISPOSE_ON_CLOSE);
		test.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	private JPanel createTreePanel() {
		JPanel treePanel = new JPanel();
		DragTree tree = new DragTree();

		treePanel.setLayout(new BorderLayout());
		treePanel.add(new JScrollPane(tree), BorderLayout.CENTER); 
		treePanel.setBorder(
			BorderFactory.createTitledBorder(
				"Drag source for filenames"));

		return treePanel;
	}
	private JPanel createTextPanel() {
		JPanel textPanel = new JPanel();

		textPanel.setLayout(new BorderLayout());
		textPanel.add(new JScrollPane(textPane), 
									   BorderLayout.CENTER);
		textPanel.setMinimumSize(new Dimension(375,0));
		textPanel.setBorder(BorderFactory.createTitledBorder(
		  "Drop target for filenames"));

		return textPanel;
	}
	private void readFile(final String filename) {
		EditorKit kit = textPane.getEditorKit();
		Document document = textPane.getDocument();

		try {
			document.remove(0,document.getLength());
			kit.read(new FileReader(filename), document, 0); 
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void drop(DropTargetDropEvent e) {
		try {
			DataFlavor stringFlavor = DataFlavor.stringFlavor;
			Transferable tr = e.getTransferable();

			if(e.isDataFlavorSupported(stringFlavor)) {
				String filename = 
						(String)tr.getTransferData(stringFlavor);

				e.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
				readFile(filename);
				textPane.setCaretPosition(0);
				e.dropComplete(true);
			}
			else {
				e.rejectDrop();
			}
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		catch(UnsupportedFlavorException ufe) {
			ufe.printStackTrace();
		}
	}
    public void dragEnter(DropTargetDragEvent e) { }
    public void dragExit(DropTargetEvent e) { }
    public void dragOver(DropTargetDragEvent e) { }
    public void dropActionChanged(DropTargetDragEvent e) { }
}

