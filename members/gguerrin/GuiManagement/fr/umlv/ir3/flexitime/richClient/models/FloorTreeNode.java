/*
 * Created on 20 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FloorTreeNode implements FlexiTreeNode
{
//	===========//
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
	 * The Floor
	 */
	private IFloor floor;

	/**
	 * The list of the sub categories
	 */
	private List children;
	
	 
	
	//==================//
    //   Constructeurs  //
    //==================// 
	
	public FloorTreeNode(FlexiTreeNode parent,IFloor floor)
	{
		this.parent = parent;
		this.floor = floor;
		children = new ArrayList();
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 */
	public FloorTreeNode(FlexiTreeNode parent,IFloor floor,DefaultTreeModel model)
	{
		this(parent,floor);
		this.model= (ResourceModel)model;
		children = new ArrayList();
	}
	
	
	//	=============//
    //   M�thodes  //
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
		return floor.getLstRoom().size()==0;
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
		
		ArrayList list = new ArrayList(floor.getLstRoom().size());
		Iterator ite = floor.getLstRoom().iterator();
		HashMap map = new HashMap();
		for(;ite.hasNext();)
		{
			IRoom room = (IRoom)ite.next();
			if(!map.containsKey(new Integer(room.getType())))
			{
				ArrayList Roomlist = new ArrayList();
				Roomlist.add(room);
				map.put(new Integer(room.getType()),Roomlist);
			}
			else
			{
				((ArrayList)map.get(new Integer(room.getType()))).add(room);
			}
		}
		Iterator TypeRoomIte = map.keySet().iterator();
		for(;TypeRoomIte.hasNext();)
		{
			Integer type = (Integer)TypeRoomIte.next();
			String name = new String();
			name += type;
			List lstRoom = (List)map.get(type);
			
			list.add(new TypeRoomTreeNode(this,name,lstRoom,model));
		}
		this.children =list;
		return(list);
	}
	
	public IFloor getFloor()
	{
		return(floor);	
	}
	/**
	 * Redefinition of the method toString()
	 * @return the name into a string
	 */
	public String toString()
	{
		return floor.getName();
	}

	
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public TreeNode add() {
		//synchronized(this.cat)
		//{
				IRoom room = DataFactory.createRoom("Nouveau type",0,10,floor);
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
	public TreeNode add(List value) {
		//synchronized(this.cat)
		//{
			/*if(value.size() == 2)
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
			}*/
			return null;
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public void remove(TreeNode childNode) 
	{
		//synchronized(cat.getParent())
		//{
			//floor.removeRoom(((FloorTreeNode)childNode).getFloor());
			//int index = children.indexOf(childNode);
			//children.remove(childNode);	
			//model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
		//}
		
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setValue(javax.swing.tree.TreePath, java.lang.Object)
	 */
	public void setValue(Object newValue) {
		//synchronized(this.cat)
		//{
			floor.setName((String)newValue);
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
