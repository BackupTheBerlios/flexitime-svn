/*
 * Created on 18 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
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
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;
import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.TeachingStructureTreeNode;


/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ClassTreeNode extends DataListenerImpl implements FlexiTreeNode 
{
	//===========//
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
	 * The class
	 */
	private IClass iClass;

	/**
	 * The list of the sub categories
	 */
	private List children;
	
	/**
	 * The teaching Structure
	 */
	private FlexiTreeNode teachingStructure;
	/**
	 * List of Listener
	*/
	List listener; 
	 
	
	//==================//
    //   Constructeurs  //
    //==================// 
	
	public ClassTreeNode(FlexiTreeNode parent,IClass iClass) throws RemoteException
	{
		this.parent = parent;
		this.iClass = iClass;
		children = new ArrayList();
		this.listener = new ArrayList();
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
	public ClassTreeNode(FlexiTreeNode parent,IClass iClass,DefaultTreeModel model) throws RemoteException
	{
		this(parent,iClass);
		this.model= (ResourceTreeModel)model;
	}
	
	
	//	=============//
    //   Méthodes  //
    //=============//
	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getChildAt(int)
	 */
	public FlexiTreeNode getChildAt(int childIndex) 
	{
		if(children.size()>0)
		{
			if(childIndex>=children.size())
			{
				return teachingStructure;
			}
			else
			{
				return (FlexiTreeNode)children.get( childIndex);
			}
		}
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
		if(iClass.getLstGroups() == null) return true;
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
	
    public IClass getIClass()
    {
        return(iClass); 
    }
    
    public void setIClass(IClass iClass)
    {
        this.iClass =  iClass;
        model.nodeChanged(this);
    }
    
    
    public List processChildren()
	{
		if(children.size()>0)return children;
		
		for(int i = 0;i<iClass.getLstGroups().size();i++)
		{
			add((IGroup)iClass.getLstGroups().get(i));
		}
		teachingStructure = new TeachingStructureTreeNode(this,iClass.getTeachingStructure(),model);
		return children;
	}
	
	/**
	 * Redefinition of the method toString()
	 * @return the name into a string
	 */
	public String toString()
	{
		return iClass.getName();
	}

	
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public void add() throws FlexiException 
    {
        System.out.println("Add group");
        IGroup groupe = DataFactory.createGroup("Nouveau Groupe",0,iClass);
	}
    
     public void add(IGroup group)
    {
            GroupTreeNode child = new GroupTreeNode(this,group,model);
            children.add(child);
            model.nodesWereInserted(this,new int[]{children.size()-1});
    }

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public void remove(TreeNode childNode) throws RemoteException, FlexiException 
	{
        RemoteDataManager.getManager().deleteGroup(((GroupTreeNode)childNode).getGroup());  	
	}
    
    public void remove(IGroup group) 
    {
            GroupTreeNode childNode = searchChild(group);  
            iClass.removeGroup(group);
            int index = children.indexOf(childNode);
            children.remove(childNode); 
            model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
        
    }

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setValue(javax.swing.tree.TreePath, java.lang.Object)
	 */
	public void setValue(Object newValue) {
		iClass.setName((String)newValue);
		model.nodeChanged(this);
		
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
        IClass iClass = (IClass)event.getSource();
        int type = event.getEventType();
        switch(type)
        {
            case DataEvent.TYPE_PROPERTY_SUBDATA_ADDED:
            {
                Object[] tabGroup = event.getSubObjects();
                for(int i=0;i<tabGroup.length;i++)
                {
                   add((IGroup)tabGroup[i]);
                }
                break;
            }
            case DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED:
            {
                Object[] tabGroup = event.getSubObjects();
               for(int i=0;i<tabGroup.length;i++)
               {
                GroupTreeNode ctn = searchChild((IGroup)tabGroup[i]);
                   ctn.setGroup((IGroup)tabGroup[i]);
               }
               break; 
            }
            case DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED:
            {
                Object[] tabGroup = event.getSubObjects();
                for(int i=0;i<tabGroup.length;i++)
                {
                    remove((IGroup)tabGroup[i]);
                }
                break;   
            }
  
        }
    }
    
    
    public GroupTreeNode searchChild(IGroup group)
    {
        Iterator ite = children.iterator() ;
        for(;ite.hasNext();)
        {
            GroupTreeNode gtn= (GroupTreeNode)ite.next();
            if(gtn.getGroup().equals(group))
            {
                return gtn;
            }
        }
        return null;
    }
}
