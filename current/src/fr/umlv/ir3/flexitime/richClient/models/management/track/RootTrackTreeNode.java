/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
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
 * Represents a tree node for a root of a track
 * @author GUERRIN Guillaume
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
    //   Méthodes  //
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
			if(lst.get(i)!=null)add((ITrack)lst.get(i));
		}
        return children;
	}

	/**
     *Allows to create a new track in the dataBase 
	 */
    public void add() throws FlexiException 
	{
		System.out.println("Add track");
		DataFactory.createTrack("Nouvelle Filière");
	}
    
    /**
     * Allows to add the track in the local list 
     * and calls the graphic addition
     * @param track
     */
    public void trackAdded(ITrack track)
    {
        lst.add(track);
        add(track);
    }
    
    /**
     * Allows to do a graphics addition or a track 
     * @param track
     */
    public void add(ITrack track)
    {
        try
        {
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
		//non utilisée
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(javax.swing.tree.TreeNode)
	 */
	public void remove(TreeNode childNode) throws RemoteException, FlexiException {
		RemoteDataManager.getManager().deleteTrack(((TrackTreeNode)childNode).getTrack());
		
	}
    
    public void remove(ITrack track) {
        TrackTreeNode childNode = searchChild(track);
        
        if(childNode!=null)
        {
            lst.remove(track);
            int index = children.indexOf(childNode);
            children.remove(childNode); 
            model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
        }
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
                trackAdded(track);
                break;
            }
            case DataEvent.TYPE_PROPERTY_CHANGED :
            {
                TrackTreeNode ttn = searchChild(track);
                if(ttn!=null)
                {
                    ttn.setTrack(track);
                }
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
