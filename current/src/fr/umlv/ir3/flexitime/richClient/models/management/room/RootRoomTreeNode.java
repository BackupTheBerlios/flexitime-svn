/*
 * Created on 20 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
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
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.models.management.RootTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.device.TypeDeviceTreeNode;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RootRoomTreeNode extends RootTreeNode
{
	//	==================//
    //   Constructeurs  //
    //==================// 
	
	public RootRoomTreeNode(TreeNode parent,List lstBuilding) throws RemoteException
	{
		super(parent,lstBuilding);
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
	public RootRoomTreeNode(TreeNode parent,List lstBuilding,DefaultTreeModel model) throws RemoteException
	{
		super(parent,lstBuilding,model);
        RemoteDataManager.getManager().addDataListener(IBuilding.class,this);
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
			list.add(add((IBuilding)lst.get(i)));
		}
		this.children =list;
		return(list);
	}

	public TreeNode add() throws FlexiException
	{
		IBuilding build = DataFactory.createBuilding("Nouveau Batiment");
		return(add(build));
	}
	
    public TreeNode add(IBuilding building)
    {
       try
       {
           System.out.println("Add BuildingNode");
           BuildingTreeNode child = new BuildingTreeNode(this,building,model);
           lst.add(building);
           children.add(child);
           model.nodesWereInserted(this,new int[]{children.size()-1});
           return child; 
       }
       catch(RemoteException e)
       {
        JOptionPane.showMessageDialog(null,e.getMessage(),"Ajout impossible",JOptionPane.ERROR_MESSAGE);
       }
       return null;
    }
	
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(java.lang.Object)
	 */
	public void change(List value) {
	//non Utilisée
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(javax.swing.tree.TreeNode)
	 */
	public void remove(TreeNode childNode) {
		lst.remove(((BuildingTreeNode)childNode).getBuilding());
		int index = children.indexOf(childNode);
		children.remove(childNode);	
		model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
		
	}

    /* (non-Javadoc)
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
     */
    public void dataChanged(DataEvent event) throws RemoteException
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
                btn.setValue(building.getName());
                break;
            }
            case DataEvent.TYPE_PROPERTY_REMOVED:
            {
                 BuildingTreeNode btn = searchChild(building);
                 remove(btn);
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
