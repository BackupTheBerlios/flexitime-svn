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
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;
import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BuildingTreeNode extends DataListenerImpl implements FlexiTreeNode 
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
	
	public BuildingTreeNode(FlexiTreeNode parent,IBuilding building) throws RemoteException
	{
		this.parent = parent;
		this.building = building;
		children = new ArrayList();
		this.listener = new ArrayList();
        RemoteDataManager.getManager().addDataListener(IBuilding.class,this);
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 * @throws RemoteException 
	 */
	public BuildingTreeNode(FlexiTreeNode parent,IBuilding building,DefaultTreeModel model) throws RemoteException
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
			list.add(add((IFloor)building.getLstFloor().get(i)));
		}
		this.children =list;
		return(list);
	}
	
	public IBuilding getBuilding()
	{
		return(building);	
	}
    
    public void setBuilding(IBuilding building)
    {
        this.building =  building;
        model.nodeChanged(this);
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
	public void add() throws FlexiException 
    {
	   DataFactory.createFloor("Nouvel étage",building);
		
    }
	
    public TreeNode add(IFloor floor)
    {
        try
        {
            System.out.println("Add floor");
            FloorTreeNode child = new FloorTreeNode(this,floor,model);
            children.add(child);
            model.nodesWereInserted(this,new int[]{children.size()-1});
            return child;
        }
        catch(RemoteException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Ajout impossible",JOptionPane.ERROR_MESSAGE);
            return null;    
        }
        
    }

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public void remove(TreeNode childNode) throws RemoteException, FlexiException 
	{
		RemoteDataManager.getManager().deleteFloor(((FloorTreeNode)childNode).getFloor());	
		
	}
    
    public void remove(IFloor floor)
    {
        FloorTreeNode childNode = searchChild(floor);
        //building.removeFloor(((FloorTreeNode)childNode).getFloor());
        int index = children.indexOf(childNode);
        children.remove(childNode); 
        model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
    }


    /* (non-Javadoc)
     * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setValue(javax.swing.tree.TreePath, java.lang.Object)
     */
    public void setValue(Object newValue) throws RemoteException 
    {
        building.setName((String)newValue);
        RemoteDataManager.getManager().saveOrUpdateBuilding(building);
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
         IBuilding building = (IBuilding)event.getSource();
         if(this.building.equals(building))
         {
             int type = event.getEventType();
             switch(type)
             {
                 case DataEvent.TYPE_PROPERTY_SUBDATA_ADDED:
                 {
                     Object[] tabFloor = (Object[])event.getSubObjects();
                     for(int i=0;i<tabFloor.length;i++)
                     {
                        add((IFloor)tabFloor[i]);
                     }
                     break;
                 }
                 case DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED:
                 {
                    Object[] tabFloor = (Object[])event.getSubObjects();
                    for(int i=0;i<tabFloor.length;i++)
                    {
                        FloorTreeNode ftn = searchChild((IFloor)tabFloor[i]);
                        ftn.setFloor((IFloor)tabFloor[i]);
                    }
                    break; 
                 }
                 case DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED:
                 {
                    Object[] tabFloor = (Object[])event.getSubObjects();
                     for(int i=0;i<tabFloor.length;i++)
                     {
                         remove((IFloor)tabFloor[i]);
                     }
                     break;   
                 }
       
             }
         }
        
    }
    
    public FloorTreeNode searchChild(IFloor floor)
    {
        Iterator ite = children.iterator() ;
        for(;ite.hasNext();)
        {
            FloorTreeNode ftn= (FloorTreeNode)ite.next();
            if(ftn.getFloor().equals(floor))
            {
                return ftn;
            }
        }
        return null;
    }

}
