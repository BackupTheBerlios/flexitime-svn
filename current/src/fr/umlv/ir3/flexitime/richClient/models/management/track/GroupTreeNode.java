/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models.management.track;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.LocalDataManager;
import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;

/**
 * Represents a tree node for a group
 * @author GUERRIN Guillaume
 */
public class GroupTreeNode  implements FlexiTreeNode 
{
//	===========//
    //   Champs  //
    //===========// 
	/**
	* The model
	*/
	private DefaultTreeModel model;
	
	/**
	 * The parent
	 */
	private final TreeNode parent;
	
	/**
	 * The group
	 */
	private IGroup group;

	/**
	 * The list of the sub categories
	 */
	private List children;
	
	 
	
	//==================//
    //   Constructeurs  //
    //==================// 
	
	public GroupTreeNode(TreeNode parent,IGroup group)
	{
		this.parent = parent;
		this.group = group;
		children = new ArrayList();
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 */
	public GroupTreeNode(TreeNode parent,IGroup group,DefaultTreeModel model)
	{
		this(parent,group);
		this.model=model;
		
	}
	
	
	//	=============//
    //   M�thodes  //
    //=============//
	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getChildAt(int)
	 */
	public TreeNode getChildAt(int childIndex) {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getChildCount()
	 */
	public int getChildCount() {
		return 0;
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
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getAllowsChildren()
	 */
	public boolean getAllowsChildren() {
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#isLeaf()
	 */
	public boolean isLeaf() {
		return true;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#children()
	 */
	public Enumeration children() {
		return null;
	}
	public IGroup getGroup()
	{
		return group;
	}
    
     public void setGroup(IGroup group)
    {
        this.group = group;
        model.nodeChanged(this);
    }
     
	public String toString()
	{
		return group.getName();
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(java.lang.Object)
	 */
	public void add() {}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public void remove(TreeNode node) {
		//Non Utilis�e
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setValue(javax.swing.tree.TreePath, java.lang.Object)
	 */
	public void setValue(Object newValue) throws RemoteException {
		group.setName((String)newValue);
		try
        {
            LocalDataManager.getManager().saveOrUpdateGroup(group,group.getParentClass());
        }
        catch (FlexiException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setModel(fr.umlv.ir3.flexitime.richClient.models.ResourceModel)
	 */
	public void setModel(DefaultTreeModel model) {
		this.model=model;
		
	}

	
}
