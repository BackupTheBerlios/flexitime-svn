/*
 * Created on 20 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.room;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;
import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;
import fr.umlv.ir3.flexitime.richClient.models.management.device.TypeDeviceTreeNode;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FloorTreeNode extends DataListenerImpl implements FlexiTreeNode
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
	 * The Floor
	 */
	private IFloor floor;

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
	
	public FloorTreeNode(FlexiTreeNode parent,IFloor floor) throws RemoteException
	{
		this.parent = parent;
		this.floor = floor;
		children = new ArrayList();
		this.listener = new ArrayList();
        RemoteDataManager.getManager().addDataListener(IFloor.class,this);
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 * @throws RemoteException 
	 */
	public FloorTreeNode(FlexiTreeNode parent,IFloor floor,DefaultTreeModel model) throws RemoteException
	{
		this(parent,floor);
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
		if(floor.getLstRoom() == null) return true;
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
		for(int i=0;i<IRoom.class.getFields().length;i++)
		{
			String name = new String();
			name += IRoom.class.getFields()[i].getName() ;
			List lstRoom;
			if(map.get(new Integer(i))!= null )lstRoom = (List)map.get(i);
			else lstRoom = new ArrayList();
			
			list.add(new TypeRoomTreeNode(this,name,i,lstRoom,model));
		}
		this.children =list;
		return(list);
	}
	
	public IFloor getFloor()
	{
		return(floor);	
	}
    public void setFloor(IFloor floor)
    {
        this.floor = floor;
        model.nodeChanged(this);
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
	public void add() {}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public void remove(TreeNode childNode) 
	{
		//non utilisée
		
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setValue(javax.swing.tree.TreePath, java.lang.Object)
	 */
	public void setValue(Object newValue) throws RemoteException 
    {
			floor.setName((String)newValue);
			RemoteDataManager.getManager().saveOrUpdateFloor(floor,floor.getParentBuilding());
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setModel(fr.umlv.ir3.flexitime.richClient.models.ResourceModel)
	 */
	public void setModel(DefaultTreeModel model) {
		this.model = (ResourceTreeModel)model;
		
	}

    /* (non-Javadoc)
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
     */
    public void dataChanged(DataEvent event) throws RemoteException
    {
        IFloor floor = (IFloor)event.getSource();
        int type = event.getEventType();
        switch(type)
        {
            case DataEvent.TYPE_PROPERTY_SUBDATA_ADDED:
            {
                IRoom[] tabRoom = (IRoom[])event.getSubObjects();
                for(int i=0;i<tabRoom.length;i++)
                {
                    floor.addRoom(tabRoom[i]);
                    TypeRoomTreeNode trtn = searchChild(tabRoom[i].getType());
                    trtn.add(tabRoom[i]);
                }
                break;
            }
            case DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED:
            {
                IRoom[] tabRoom = (IRoom[])event.getSubObjects();
               for(int i=0;i<tabRoom.length;i++)
               {
                   TypeRoomTreeNode tdtn = searchChild(tabRoom[i].getType());
                   tdtn.setValue(tabRoom[i]);
                    break;
               }
               break; 
            }
            case DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED:
            {
                IRoom[] tabRoom = (IRoom[])event.getSubObjects();
                for(int i=0;i<tabRoom.length;i++)
                {
                    floor.removeRoom(tabRoom[i]);
                    TypeRoomTreeNode trtn = searchChild(tabRoom[i].getType());
                    trtn.remove(tabRoom[i]);
                }
                break;   
            }
  
        }
       
        
    }
    public TypeRoomTreeNode searchChild(int type)
    {
        Iterator ite = children.iterator() ;
        for(;ite.hasNext();)
        {
            TypeRoomTreeNode trtn= (TypeRoomTreeNode)ite.next();
            if(trtn.getType()==type)
            {
                return trtn;
            }
        }
        return null;
    }


}
