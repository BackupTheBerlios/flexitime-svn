/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models.management;

import java.rmi.RemoteException;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.exception.FlexiException;

/**
 * Represents the interface of a tree Node 
 * All Our TreeNode implements this class
 * @author GUERRIN Guillaume
 */
public interface FlexiTreeNode extends TreeNode 
{
	public void add()throws FlexiException ;
	public void remove(TreeNode node) throws RemoteException, FlexiException;
	public void setValue(Object newValue) throws RemoteException;
	public void setModel(DefaultTreeModel model);
}
