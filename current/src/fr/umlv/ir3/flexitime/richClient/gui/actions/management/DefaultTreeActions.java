/*
 * Created on 20 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.gui.actions.management;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTree;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DefaultTreeActions 
{
	public static Action add(final TreeModel model,final TreeNode treeNode)
	{
		Action action = new AbstractAction()
		{

			/**
			 * Comment for <code>serialVersionUID</code>
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) 
			{
					((ResourceTreeModel)model).add(treeNode);
					
				
			}
			
		};
		return action;
	}
	
	public static Action remove(final TreeModel model,final TreeNode treeNode)
	{
		Action action = new AbstractAction()
		{

			/**
			 * Comment for <code>serialVersionUID</code>
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) 
			{
					((ResourceTreeModel)model).remove(treeNode);
				
			}
			
		};
		return action;
	}
	
	public static Action rename(final TreeModel model,final JTree tree,final Object value)
	{
		Action action = new AbstractAction()
		{

			/**
			 * Comment for <code>serialVersionUID</code>
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) 
			{
				((ResourceTreeModel)model).valueForPathChanged(tree.getSelectionPath(),value);
				
			}
			
		};
		
		return action;
	}
}
