/*
 * Created on 20 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.room;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;
import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RoomTreeNode implements FlexiTreeNode
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
	 * The Room
	 */
	private IRoom room;

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
	
	public RoomTreeNode(TreeNode parent,IRoom room)
	{
		this.parent = parent;
		this.room = room;
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
	public RoomTreeNode(TreeNode parent,IRoom room,DefaultTreeModel model)
	{
		this(parent,room);
		this.model=model;

	}
	
	
	//	=============//
    //   Méthodes  //
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
	public IRoom getRoom()
	{
		return room;
	}
	/**
	 * Creates dynamiquely the list of the children when the user click on the "plus"
	 * @return the list of sub categories
	 */
	/*public List processChildren()
	{
		if(children.size()>0)return children;
		
		ArrayList list = new ArrayList(track.getLstClass().size());
		for(int i = 0;i<track.getLstClass().size();i++)
		{
			list.add(new TrackTreeNode(this,(Category)cat.getSubCategories().get(i),factory,model));
		}
		this.children =list;
		return(list);
	}*/
	public String toString()
	{
		return room.getName();
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(java.lang.Object)
	 */
	public TreeNode add() {
		//Non utilisée
		System.out.println("- Add de room");
		return null;
	}
	
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(java.lang.Object)
	 */
	public void change(List obj) {
		if(obj.size()>=2)
		{
			room.setName((String)obj.get(0));
			room.setCapacity((new Integer((String)obj.get(1))).intValue());
			model.nodeChanged(this);
		}
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public void remove(TreeNode node) {
		//Non Utilisée
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setValue(javax.swing.tree.TreePath, java.lang.Object)
	 */
	public void setValue(Object newValue) {
		room.setName((String)newValue);
		informListenerChange(newValue);
		model.nodeChanged(this);
		
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setModel(fr.umlv.ir3.flexitime.richClient.models.ResourceModel)
	 */
	public void setModel(DefaultTreeModel model) {
		// TODO Auto-generated method stub
		
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
