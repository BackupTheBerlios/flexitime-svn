/*
 * Created on 28 nov. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.test.dnd.exemple.tree;


import java.awt.datatransfer.*;
import java.awt.dnd.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.io.*;

class DragTree extends JTree implements DragGestureListener,
										DragSourceListener {
	public DragTree() {
		DragSource dragSource = DragSource.getDefaultDragSource();

		dragSource.createDefaultDragGestureRecognizer(
					this, // component where drag originates
					DnDConstants.ACTION_COPY_OR_MOVE, // actions
					this); // drag gesture recognizer

		setModel(createTreeModel());

		addTreeExpansionListener(new TreeExpansionListener(){
			public void treeCollapsed(TreeExpansionEvent e) {
			}
			public void treeExpanded(TreeExpansionEvent e) {
				TreePath path = e.getPath();

				if(path != null) {
					FileNode node = (FileNode)
								   path.getLastPathComponent();

					if( ! node.isExplored()) {
						DefaultTreeModel model = 
									(DefaultTreeModel)getModel();
						node.explore();
						model.nodeStructureChanged(node);
					}
				}
			}
		});
	}
	public void dragGestureRecognized(DragGestureEvent e) {
		// drag anything ...
		e.startDrag(DragSource.DefaultCopyDrop, // cursor
			new StringSelection(getFilename()), // transferable
			this);  // drag source listener
	}
	public void dragDropEnd(DragSourceDropEvent e) {}
	public void dragEnter(DragSourceDragEvent e) {}
	public void dragExit(DragSourceEvent e) {}
	public void dragOver(DragSourceDragEvent e) {}
	public void dropActionChanged(DragSourceDragEvent e) {}

	public String getFilename() {
		TreePath path = getLeadSelectionPath();
		FileNode node = (FileNode)path.getLastPathComponent();
		return ((File)node.getUserObject()).getAbsolutePath();
	}
	private DefaultTreeModel createTreeModel() {
		File root = new File("D:" + File.separator + "taff");
		FileNode rootNode = new FileNode(root);

		rootNode.explore();
		return new DefaultTreeModel(rootNode);
	}
}
class FileNode extends DefaultMutableTreeNode {
	private boolean explored = false;

	public FileNode(File file) 	{ 
		setUserObject(file); 
	}
	public boolean getAllowsChildren() { return isDirectory(); }
	public boolean isLeaf() 	{ return !isDirectory(); }
	public File getFile()		{ return (File)getUserObject(); }

	public boolean isExplored() { return explored; }

	public boolean isDirectory() {
		File file = getFile();
		return file.isDirectory();
	}
	public String toString() {
		File file = (File)getUserObject();
		String filename = file.toString();
		int index = filename.lastIndexOf(File.separator);

		return (index != -1 && index != filename.length()-1) ? 
									filename.substring(index+1) : 
									filename;
	}
	public void explore() {
		if(!isDirectory())
			return;

		if(!isExplored()) {
			File file = getFile();
			File[] children = file.listFiles();

			for(int i=0; i < children.length; ++i) 
				add(new FileNode(children[i]));

			explored = true;
		}
	}
}

