/*
 * Created on 18 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.test.flexibar;

import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

import fr.umlv.ir3.flexitime.richClient.models.RootTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.TrackModel;


/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TrackTree 
{
	/**
	 * This function creates the tree for the category to be showed
	 * @param factory the BuckFactory
	 * @param book the book
	 * @param mainFrame the main frame
	 * @param model the category model
	 * @return a JTree
	 */		
	public static  JTree createTree(final JFrame mainFrame,final TrackModel model)
	{
		final JTree tree = new JTree(model);
		tree.setEditable(true);

		tree.getCellEditor().addCellEditorListener(new CellEditorListener()
		{
			public void editingCanceled(ChangeEvent e) 
			{
				System.out.println("Edition Canceled : path"+tree.getSelectionPath()+"  value:"+tree.getCellEditor() .getCellEditorValue() );
				int text = JOptionPane.showConfirmDialog(mainFrame,"Would you validate this changes?");
				if(text!= 0)return;
				else model.valueForPathChanged(tree.getSelectionPath(),tree.getCellEditor() .getCellEditorValue() );
			}
			public void editingStopped(ChangeEvent e) {}
		});
		tree.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		return tree;
	}
}
