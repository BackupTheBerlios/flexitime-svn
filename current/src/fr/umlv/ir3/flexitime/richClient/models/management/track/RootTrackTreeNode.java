/*
 * Created on 18 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.track;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.models.management.RootTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.room.BuildingTreeNode;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RootTrackTreeNode extends RootTreeNode{

	//==================//
    //   Constructeurs  //
    //==================// 
	
	public RootTrackTreeNode(TreeNode parent,List lstTrack) throws RemoteException
	{
		super(parent,lstTrack);
        RemoteDataManager.getManager().addDataListener(ITrack.class,this);
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 * @throws RemoteException 
	 */
	public RootTrackTreeNode(TreeNode parent,List lstTrack,DefaultTreeModel model) throws RemoteException
	{
		super(parent,lstTrack,model);
        RemoteDataManager.getManager().addDataListener(ITrack.class,this);
	}
	
	
	//	=============//
    //   M�thodes  //
    //=============//

	
	/**
	 * Creates dynamiquely the list of the children when the user click on the "plus"
	 * @return the list of sub categories
	 */
	public List processChildren()
	{
		if(children.size()>0)return children;
		for(int i = 0;i<lst.size();i++)
		{
			add((ITrack)lst.get(i));
		}
        return children;
	}

	public void add() throws FlexiException 
	{
		System.out.println("Add track");
		DataFactory.createTrack("Nouvelle Fili�re");
	}
    
    public void add(ITrack track)
    {
        try
        {
            lst.add(track);
            TrackTreeNode child = new TrackTreeNode(this,track,model);
            {
                children.add(child);
            }
            model.nodesWereInserted(this,new int[]{children.size()-1});
        }
        catch(RemoteException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Ajout impossible",JOptionPane.ERROR_MESSAGE);
        }
    }
	
	
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(java.lang.Object)
	 */
	public void change(List value) {
		//non utilis�e
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(javax.swing.tree.TreeNode)
	 */
	public void remove(TreeNode childNode) throws RemoteException, FlexiException {
		RemoteDataManager.getManager().deleteTrack(((TrackTreeNode)childNode).getTrack());
		
	}
    
    public void remove(ITrack track) {
        TrackTreeNode childNode;
        lst.remove(track);
        int index = children.indexOf(childNode = searchChild(track));
        children.remove(childNode); 
        model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
        
    }

    /* (non-Javadoc)
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
     */
    public void dataChanged(DataEvent event) throws RemoteException
    {
        ITrack track = (ITrack)event.getSource();
        int type = event.getEventType();
        switch(type)
        {
            case DataEvent.TYPE_PROPERTY_ADDED:
            {
                add(track);
                break;
            }
            case DataEvent.TYPE_PROPERTY_CHANGED :
            {
                TrackTreeNode ttn = searchChild(track);
                ttn.setTrack(track);
                break;
            }
            case DataEvent.TYPE_PROPERTY_REMOVED:
            {
                remove(track);
                break;
            }
  
        }   
    }
    public TrackTreeNode searchChild(ITrack track)
    {
        Iterator ite = children.iterator() ;
        for(;ite.hasNext();)
        {
            TrackTreeNode ttn= (TrackTreeNode)ite.next();
            if(ttn.getTrack().equals(track))
            {
                return ttn;
            }
        }
        return null;
    }
}
