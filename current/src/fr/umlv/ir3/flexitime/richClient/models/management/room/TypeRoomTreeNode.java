/*
 * Created on 21 janv. 2005
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
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;
import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;
import fr.umlv.ir3.flexitime.richClient.models.management.device.DeviceTreeNode;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TypeRoomTreeNode implements FlexiTreeNode
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
	 * The list of room
	 */
	private List lstRoom;

	/**
	 * The name of the type
	 */
	private String name;
	/**
	 * The name of the type
	 */
	private int type;
	/**
	 * The list of the sub categories
	 */
	private List children;
	
	 
	
	//==================//
    //   Constructeurs  //
    //==================// 
	
	public TypeRoomTreeNode(TreeNode parent,String name,int type,List lstRoom)
	{
		this.parent = parent;
		this.name=name;
		this.type= type;
		this.lstRoom = lstRoom;
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 */
	public TypeRoomTreeNode(TreeNode parent,String name,int type,List lstRoom,DefaultTreeModel model)
	{
		this(parent,name,type,lstRoom);
		this.model=model;
		children = new ArrayList();
	}
	
	
	//	=============//
    //   M�thodes  //
    //=============//
	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getChildAt(int)
	 */
	public TreeNode getChildAt(int childIndex) {
		return (TreeNode)processChildren().get(childIndex);
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getChildCount()
	 */
	public int getChildCount() {
		return processChildren().size();
	}
   
    /* (non-Javadoc)
     * @see javax.swing.tree.TreeNode#getChildCount()
     */
    public int getType() {
        return type;
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
	public boolean isLeaf() {
		if(lstRoom == null) return true;
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
		
		ArrayList list = new ArrayList(lstRoom.size());
		for(int i = 0;i<lstRoom.size();i++)
		{
			list.add(new RoomTreeNode(this,(IRoom)lstRoom.get(i),model));
		}
		this.children =list;
		return(list);
	}
	
	public List getLstDevice()
	{
		return lstRoom;
	}
	/**
	 * Redefinition of the method toString()
	 * @return the name into a string
	 */
	public String toString()
	{
		return name;
	}

	
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(java.lang.Object)
	 */
	public TreeNode add() throws FlexiException 
	{
			IRoom room= DataFactory.createRoom("Nouvelle Salle",type,0,((FloorTreeNode)this.getParent()).getFloor());
			room.setType(type);
			RoomTreeNode child = new RoomTreeNode(this,room,model);
			lstRoom.add(room);
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
    
    public TreeNode add(IRoom room)
    {
        lstRoom.add( room);
        RoomTreeNode child = new RoomTreeNode(this,room,model);
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
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(java.lang.Object)
	 */
	public void change(List value) {
		//		Non utilis�e
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public void remove(TreeNode childNode) {
		lstRoom.remove(((RoomTreeNode)childNode).getRoom());
		((FloorTreeNode)this.getParent()).getFloor().getLstRoom().remove(((RoomTreeNode)childNode).getRoom());
		//Effacement du room dans la base
		int index = children.indexOf(childNode);
		children.remove(childNode);	
		model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
		
	}
    
    public void remove(IRoom room) {
        RoomTreeNode childNode = searchChild(room);
        lstRoom.remove(room);
        int index = children.indexOf(childNode);
        children.remove(childNode); 
        model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
        
    }
    
    public RoomTreeNode searchChild(IRoom room)
    {
        Iterator ite = children.iterator() ;
        for(;ite.hasNext();)
        {
            RoomTreeNode rtn= (RoomTreeNode)ite.next();
            if(rtn.getRoom().equals(room))
            {
                return rtn;
            }
        }
        return null;
    }

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setValue(javax.swing.tree.TreePath, java.lang.Object)
	 */
	public void setValue(Object newValue) {
		/*track.setName((String)newValue);
		model.nodeChanged(this);*/
		
	}


	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setModel(fr.umlv.ir3.flexitime.richClient.models.ResourceModel)
	 */
	public void setModel(DefaultTreeModel model) {
		this.model= (ResourceTreeModel)model;
		
	}
	public void addFlexiTreeNodeListener(FlexiTreeNodeListener ob)
	{
		//Non utilis�e
	}
	
	public void informListenerChange(Object value)
	{
		//Non utilis�e
	}

}
