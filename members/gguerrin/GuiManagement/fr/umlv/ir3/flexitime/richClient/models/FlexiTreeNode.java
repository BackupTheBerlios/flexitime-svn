/*
 * Created on 19 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models;

import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface FlexiTreeNode extends TreeNode 
{
	public TreeNode add(List obj);
	public TreeNode add();
	public void remove(TreeNode node);
	public void setValue(Object newValue);
	public void setModel(DefaultTreeModel model);
}
