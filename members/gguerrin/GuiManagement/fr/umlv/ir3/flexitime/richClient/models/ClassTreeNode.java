/*
 * Created on 18 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;


/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ClassTreeNode implements FlexiTreeNode 
{
	//===========//
    //   Champs  //
    //===========// 
	/**
	* The model
	*/
	private ResourceModel model;
	
	/**
	 * The parent
	 */
	private final FlexiTreeNode parent;
	
	/**
	 * The class
	 */
	private IClass iClass;

	/**
	 * The list of the sub categories
	 */
	private List children;
	
	 
	
	//==================//
    //   Constructeurs  //
    //==================// 
	
	public ClassTreeNode(FlexiTreeNode parent,IClass iClass)
	{
		this.parent = parent;
		this.iClass = iClass;
		children = new ArrayList();
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 */
	public ClassTreeNode(FlexiTreeNode parent,IClass iClass,DefaultTreeModel model)
	{
		this(parent,iClass);
		this.model= (ResourceModel)model;
		children = new ArrayList();
	}
	
	
	//	=============//
    //   Méthodes  //
    //=============//
	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getChildAt(int)
	 */
	public FlexiTreeNode getChildAt(int childIndex) {
		return (FlexiTreeNode)processChildren().get(childIndex);
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
	public FlexiTreeNode getParent() {
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
	public boolean isLeaf() {
		if(iClass.getLstGroups() == null) return true;
		else return false;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#children()
	 */
	public Enumeration children() {
		return Collections.enumeration(processChildren());
	}
	
	/**
	 * Creates dynamiquely the list of the children when the user click on the "plus"
	 * @return the list of sub categories
	 */
	public List processChildren()
	{
		if(children.size()>0)return children;
		
		ArrayList list = new ArrayList(iClass.getLstGroups().size());
		for(int i = 0;i<iClass.getLstGroups().size();i++)
		{
			list.add(new GroupTreeNode(this,(IGroup)iClass.getLstGroups().get(i),model));
		}
		//Ajout de la teachingStructure
		//if(iClass.getTeachingStructure()==null)iClass.setTeachingStructure(DataFactory.crea);
		list.add(new TeachingStructureTreeNode(this,iClass.getTeachingStructure(),model));
		this.children =list;
		return(list);
	}
	
	public IClass getIClass()
	{
		return(iClass);	
	}
	/**
	 * Redefinition of the method toString()
	 * @return the name into a string
	 */
	public String toString()
	{
		return iClass.getName();
	}

	
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public TreeNode add() {
		//synchronized(this.cat)
		//{
				IGroup groupe = DataFactory.createGroup("Nouveau Groupe",0,iClass);
				GroupTreeNode child = new GroupTreeNode(this,groupe,model);
				if(children.size()==0)
				{
					processChildren();
				}
				else
				{
					children.add(child);
				}
				model.nodesWereInserted(this,new int[]{children.size()-1});
				return child;
	}
	
	
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public TreeNode add(List value) {
		//synchronized(this.cat)
		//{
			if(value.size() == 2)
			{
				IGroup groupe = DataFactory.createGroup((String)value.get(0),((Integer)value.get(1)).intValue(),iClass);
				GroupTreeNode child = new GroupTreeNode(this,groupe,model);
				if(children.size()==0)
				{
					processChildren();
				}
				else
				{
					children.add(child);
				}
				model.nodesWereInserted(this,new int[]{children.size()-1});
				return child;
			}
			return null;
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public void remove(TreeNode childNode) 
	{
		//synchronized(cat.getParent())
		//{
			iClass.removeGroup(((GroupTreeNode)childNode).getGroup());
			int index = children.indexOf(childNode);
			children.remove(childNode);	
			model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
		//}
		
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setValue(javax.swing.tree.TreePath, java.lang.Object)
	 */
	public void setValue(Object newValue) {
		//synchronized(this.cat)
		//{
			iClass.setName((String)newValue);
			model.nodeChanged(this);
		//}
		
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setModel(fr.umlv.ir3.flexitime.richClient.models.ResourceModel)
	 */
	public void setModel(DefaultTreeModel model) {
		this.model = (ResourceModel)model;
		
	}
}
