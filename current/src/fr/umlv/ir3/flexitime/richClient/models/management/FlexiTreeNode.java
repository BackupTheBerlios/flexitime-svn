/*
 * Created on 19 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management;

import java.rmi.RemoteException;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface FlexiTreeNode extends TreeNode 
{
	public void add()throws FlexiException ;
	public void remove(TreeNode node) throws RemoteException, FlexiException;
	public void setValue(Object newValue) throws RemoteException;
	public void setModel(DefaultTreeModel model);
}
