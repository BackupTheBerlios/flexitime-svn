/*
 * Created on 18 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.track;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.richClient.models.management.RootTreeNode;

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
		ArrayList list = new ArrayList(lst.size());
		for(int i = 0;i<lst.size();i++)
		{
			list.add(new TrackTreeNode(this,(ITrack)lst.get(i),model));
		}
		this.children =list;
		return(list);
	}

	public TreeNode add() throws FlexiException 
	{
		//synchronized(this.cat)
		//{
		System.out.println("Add track");
        ITrack track = DataFactory.createTrack("Nouvelle Filière");
		lst.add(track);
		TrackTreeNode child = new TrackTreeNode(this,track,model);
	/*	if(children.size()==0)
		{
			processChildren();
		}
		else*/
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
		//non utilisée
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(javax.swing.tree.TreeNode)
	 */
	public void remove(TreeNode childNode) {
		lst.remove(((TrackTreeNode)childNode).getTrack());
		int index = children.indexOf(childNode);
		children.remove(childNode);	
		model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
		
	}

    /* (non-Javadoc)
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
     */
    public void dataChanged(DataEvent event) throws RemoteException
    {
        // TODO Auto-generated method stub
        
    }
}
