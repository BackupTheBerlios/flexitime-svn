/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models.management.room;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.LocalDataManager;
import fr.umlv.ir3.flexitime.richClient.models.management.RootTreeNode;

/**
 * Represents a tree node for a root room
 * @author GUERRIN Guillaume
 */
public class RootRoomTreeNode extends RootTreeNode
{
	//	==================//
    //   Constructeurs  //
    //==================// 
	
	public RootRoomTreeNode(TreeNode parent,List lstBuilding) throws RemoteException
	{
		super(parent,lstBuilding);
         LocalDataManager.getManager().addDataListener(IBuilding.class,this);
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 * @throws RemoteException 
	 */
	public RootRoomTreeNode(TreeNode parent,List lstBuilding,DefaultTreeModel model) throws RemoteException
	{
		super(parent,lstBuilding,model);
        LocalDataManager.getManager().addDataListener(IBuilding.class,this);
	}
	
	
	//	=============//
    //   Méthodes  //
    //=============//

	
	/**
	 * Creates dynamiquely the list of the children when the user click on the "plus"
	 * @return the list of sub categories
	 * @throws RemoteException 
	 */
	public List processChildren()
	{
		if(children.size()>0)return children;
		ArrayList list = new ArrayList(lst.size());
		for(int i = 0;i<lst.size();i++)
		{
			if(lst.get(i) !=null)
            {
			    add((IBuilding)lst.get(i));
            }
		}
		return children;
	}

	public void add() throws FlexiException
	{
		DataFactory.createBuilding("Nouveau Batiment");
	}
	
    public void buildingAdded(IBuilding building)
    {
        lst.add(building);
        add(building);
    }
    public void add(IBuilding building)
    {
       try
       {
           System.out.println("Add BuildingNode");
           BuildingTreeNode child = new BuildingTreeNode(this,building,model);
           children.add(child);
           model.nodesWereInserted(this,new int[]{children.size()-1});
       }
       catch(RemoteException e)
       {
        JOptionPane.showMessageDialog(null,e.getMessage(),"Ajout impossible",JOptionPane.ERROR_MESSAGE);
       }
    }

	public void remove(TreeNode childNode) throws RemoteException, FlexiException {
         LocalDataManager.getManager().deleteBuilding(((BuildingTreeNode)childNode).getBuilding());
        
    }
    /* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(javax.swing.tree.TreeNode)
	 */
	public void remove(IBuilding building) {
		BuildingTreeNode childNode=searchChild(building);
        if(childNode != null)
        {
            //lst.remove(building);
            int index = children.indexOf(childNode);
            children.remove(index);	
            model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
        }
	}

    /* (non-Javadoc)
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
     */
    public void dataChanged(DataEvent event)
    {
        IBuilding building = (IBuilding)event.getSource();
        int type = event.getEventType();
        switch(type)
        {
            case DataEvent.TYPE_PROPERTY_ADDED:
            {
               add(building);
                break;
            }
            case DataEvent.TYPE_PROPERTY_CHANGED :
            {
                BuildingTreeNode btn = searchChild(building);
                if(btn != null){
                    btn.setBuilding(building);
                }
                break;
            }
            case DataEvent.TYPE_PROPERTY_REMOVED:
            {
                remove(building);
                break;
            }
  
        }
        
    }
    
    public BuildingTreeNode searchChild(IBuilding building)
    {
        Iterator ite = children.iterator() ;
        for(;ite.hasNext();)
        {
            BuildingTreeNode btn= (BuildingTreeNode)ite.next();
            if(btn.getBuilding().equals(building))
            {
                return btn;
            }
        }
        return null;
    }
}
