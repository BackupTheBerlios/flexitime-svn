/*
 * Created on 20 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class RootTreeNode extends DataListenerImpl implements FlexiTreeNode 
{
//	===========//
    //   Champs  //
    //===========// 
	/**
	* The model
	*/
	protected DefaultTreeModel model;
	
	/**
	 * The parent
	 */
	protected final TreeNode parent;
	
	/**
	 * The list
	 */
	protected List lst;

	/**
	 * The list of the sub categories
	 */
	protected List children;
	
	 
	
	//==================//
    //   Constructeurs  //
    //==================// 
	
	public RootTreeNode(TreeNode parent,List lstTrack) throws RemoteException
	{
		this.parent = parent;
		if( lstTrack==null)lst=new ArrayList();
		else this.lst = lstTrack;
		children = new ArrayList();
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 */
	public RootTreeNode(TreeNode parent,List lst,DefaultTreeModel model)throws RemoteException
	{
		this(parent,lst);
		this.model=model;
	}
	
	
	//	=============//
    //   Méthodes  //
    //=============//
	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getChildAt(int)
	 */
	public TreeNode getChildAt(int childIndex) {
		if(childIndex>=0)
			{
			TreeNode node =(TreeNode)processChildren().get(childIndex);
			return node;
			}
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getChildCount()
	 */
	public int getChildCount() {
		return processChildren().size();
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getParent()
	 */
	public TreeNode getParent() {
		return parent;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getIndex(javax.swing.tree.TreeNode)
	 */
	public int getIndex(TreeNode node) {
		return processChildren().indexOf(node);
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getAllowsChildren()
	 */
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#isLeaf()
	 */
	public boolean isLeaf() 
	{
		if(lst == null)return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#children()
	 */
	public Enumeration children() {
		return Collections.enumeration(processChildren());
	}
	
	public List getList()
	{
		return lst;
	}
	/**
	 * Creates dynamiquely the list of the children when the user click on the "plus"
	 * @return the list of sub categories
	 * @throws RemoteException 
	 */
	public abstract List processChildren();
	/**
	 * Redefinition of the method toString()
	 * @return the name into a string
	 */
	public String toString()
	{
		return "root";
	}
	/**
	 * To get the model
	 * @return the model
	 */
	public DefaultTreeModel getModel() {
		return model;
	}

	/**
	 * To set the model
	 * @param model the new model
	 */
	public void setModel(DefaultTreeModel model) {
		this.model = model;
	}

	public abstract TreeNode add() throws FlexiException;
	
	
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(java.lang.Object)
	 */
	abstract public void change(List value);

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(javax.swing.tree.TreeNode)
	 */
	abstract public void remove(TreeNode childNode) throws RemoteException, FlexiException;

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setValue(java.lang.Object)
	 */
	public void setValue(Object newValue) 
	{
		// Non utilisée	
	}
	public void addFlexiTreeNodeListener(FlexiTreeNodeListener ob)
	{
		//Non utilisée
	}
	
	public void informListenerChange(Object value)
	{
		//Non utilisée
	}
}
