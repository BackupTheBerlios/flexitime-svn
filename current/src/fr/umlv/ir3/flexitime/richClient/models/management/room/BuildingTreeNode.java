/*
 * Created on 20 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;
import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BuildingTreeNode implements FlexiTreeNode
{
//	===========//
    //   Champs  //
    //===========// 
	/**
	* The model
	*/
	private ResourceTreeModel model;
	
	/**
	 * The parent
	 */
	private final FlexiTreeNode parent;
	
	/**
	 * The Building
	 */
	private IBuilding building;

	/**
	 * The list of the sub categories
	 */
	private List children;
	
	/**
	 * List of Listener
	*/
	List listener; 
	
	//==================//
    //   Constructeurs  //
    //==================// 
	
	public BuildingTreeNode(FlexiTreeNode parent,IBuilding building)
	{
		this.parent = parent;
		this.building = building;
		children = new ArrayList();
		this.listener = new ArrayList();
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 */
	public BuildingTreeNode(FlexiTreeNode parent,IBuilding building,DefaultTreeModel model)
	{
		this(parent,building);
		this.model= (ResourceTreeModel)model;
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
		if(building.getLstFloor() == null) return true;
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
		
		ArrayList list = new ArrayList(building.getLstFloor().size());
		for(int i = 0;i<building.getLstFloor().size();i++)
		{
			list.add(new FloorTreeNode(this,(IFloor)building.getLstFloor().get(i),model));
		}
		this.children =list;
		return(list);
	}
	
	public IBuilding getBuilding()
	{
		return(building);	
	}
	/**
	 * Redefinition of the method toString()
	 * @return the name into a string
	 */
	public String toString()
	{
		return building.getName();
	}

	
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public TreeNode add() {
		//synchronized(this.cat)
		//{
				IFloor floor = DataFactory.createFloor("Nouvel étage",building);
				FloorTreeNode child = new FloorTreeNode(this,floor,model);
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
	public void change(List value) {
		//non utilisée
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public void remove(TreeNode childNode) 
	{
		//synchronized(cat.getParent())
		//{
			building.removeFloor(((FloorTreeNode)childNode).getFloor());
			//TODO Enlevé floor de la base
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
			building.setName((String)newValue);
			informListenerChange(newValue);
			model.nodeChanged(this);
		//}
		
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setModel(fr.umlv.ir3.flexitime.richClient.models.ResourceModel)
	 */
	public void setModel(DefaultTreeModel model) {
		this.model = (ResourceTreeModel)model;
		
	}
	public void addFlexiTreeNodeListener(FlexiTreeNodeListener ob)
	{
		listener.add(ob);
	}
	
	public void informListenerChange(Object value)
	{
		Iterator iter = listener.iterator() ;
		for(;iter.hasNext();)
		{
			((FlexiTreeNodeListener)iter.next()).nodeChanged(value);
		}
	}

}
