/*
 * Created on 19 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management;

import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface FlexiTreeNode extends TreeNode 
{
	public void change(List obj);
	public TreeNode add();
	public void remove(TreeNode node);
	public void setValue(Object newValue);
	public void setModel(DefaultTreeModel model);
	public void addFlexiTreeNodeListener(FlexiTreeNodeListener ob);
	public void informListenerChange(Object value);
}
