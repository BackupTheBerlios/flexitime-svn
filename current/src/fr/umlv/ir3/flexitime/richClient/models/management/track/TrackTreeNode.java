/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models.management.track;

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
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;
import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;
import fr.umlv.ir3.flexitime.richClient.models.management.room.FloorTreeNode;




/**
 * Represents a tree node for a track
 * @author GUERRIN Guillaume
 */
public class TrackTreeNode extends DataListenerImpl implements  FlexiTreeNode
{
	//===========//
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
	 * The track
	 */
	private ITrack track;

	/**
	 * The list of the sub categories
	 */
	private List children;
	
	 
	
	//==================//
    //   Constructeurs  //
    //==================// 
	
	public TrackTreeNode(TreeNode parent,ITrack track) throws RemoteException
	{
		this.parent = parent;
		this.track = track;
		children = new ArrayList();
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
	public TrackTreeNode(TreeNode parent,ITrack track,DefaultTreeModel model) throws RemoteException
	{
		this(parent,track);
		this.model=model;
	}
	
	
	//	=============//
    //   Méthodes  //
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
		if(track.getLstClass() == null) return true;
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
		for(int i = 0;i<track.getLstClass().size();i++)
		{
			if(track.getLstClass().get(i)!=null)add((IClass)track.getLstClass().get(i));
		}
		return children;
	}
	
	public ITrack getTrack()
	{
		return track;
	}
    
    public void setTrack(ITrack track)
    {
        this.track =  track;
        model.nodeChanged(this);
    }
	/**
	 * Redefinition of the method toString()
	 * @return the name into a string
	 */
	public String toString()
	{
		return track.getName();
	}

	
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(java.lang.Object)
	 */
	public void add() throws FlexiException
	{
            System.out.println("Add promotion");	
            IClass iClass=DataFactory.createClass("Nouvelle Promotion",track);
	}
    
    public void classAdded(IClass iClass)
    {
        track.addClass(iClass);
        add(iClass);
    }
    
    public void add(IClass iClass)
    {
        try
        {    
            if(iClass.getTeachingStructure() == null)DataFactory.createTeachingStructure("structure",iClass);
            ClassTreeNode child = new ClassTreeNode(this,iClass,model);
            children.add(child);
            model.nodesWereInserted(this,new int[]{children.size()-1});
        }
        catch(FlexiException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Ajout impossible",JOptionPane.ERROR_MESSAGE); 
        }
        catch(RemoteException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Ajout impossible",JOptionPane.ERROR_MESSAGE);  
        }
    }

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public void remove(TreeNode childNode) throws RemoteException, FlexiException {
        RemoteDataManager.getManager().deleteClass(((ClassTreeNode)childNode).getIClass());  
		
	}
    
    public void remove(IClass iClass) 
    {
        ClassTreeNode childNode = searchChild(iClass);
        if(childNode != null)
        {
            //track.removeClass(((ClassTreeNode)childNode).getIClass());
            int index = children.indexOf(childNode);
            children.remove(childNode); 
            model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
        }
        
        
    }

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setValue(javax.swing.tree.TreePath, java.lang.Object)
	 */
	public void setValue(Object newValue)throws RemoteException 
    {
		track.setName((String)newValue);
        RemoteDataManager.getManager().saveOrUpdateTrack(track);
		
	}


	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setModel(fr.umlv.ir3.flexitime.richClient.models.ResourceModel)
	 */
	public void setModel(DefaultTreeModel model) {
		this.model= (ResourceTreeModel)model;
		
	}

    /* (non-Javadoc)
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
     */
    public void dataChanged(DataEvent event) throws RemoteException
    {
        ITrack track = (ITrack)event.getSource();
        if(this.track.equals(track))
        {  
            int type = event.getEventType();
            switch(type)
            {
                case DataEvent.TYPE_PROPERTY_SUBDATA_ADDED:
                {
                    Object[] tabClass = event.getSubObjects();
                    for(int i=0;i<tabClass.length;i++)
                    {
                        add((IClass)tabClass[i]);
                    }
                    break;
                }
                case DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED:
                {
                    Object[] tabClass = event.getSubObjects();
                   for(int i=0;i<tabClass.length;i++)
                   {
                       ClassTreeNode ctn = searchChild((IClass)tabClass[i]);
                       if( ctn != null){
                           ctn.setIClass((IClass)tabClass[i]);
                       }
                   }
                   break; 
                }
                case DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED:
                {
                    Object[] tabClass = event.getSubObjects();
                    for(int i=0;i<tabClass.length;i++)
                    {
                        remove((IClass)tabClass[i]);
                    }
                    break;   
                }
            }
        }
    }
    public ClassTreeNode searchChild(IClass iClass)
    {
        Iterator ite = children.iterator() ;
        for(;ite.hasNext();)
        {
            ClassTreeNode ctn= (ClassTreeNode)ite.next();
            if(ctn.getIClass().equals(iClass))
            {
                return ctn;
            }
        }
        return null;
    }
}
