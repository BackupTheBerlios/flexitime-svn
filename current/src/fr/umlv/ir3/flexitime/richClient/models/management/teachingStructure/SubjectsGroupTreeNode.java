/*
 * Created on 23 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure;

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
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;
import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;
import fr.umlv.ir3.flexitime.richClient.models.management.track.ClassTreeNode;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SubjectsGroupTreeNode extends DataListenerImpl implements FlexiTreeNode
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
	 * The track
	 */
	private ISubjectsGroup subjectsGroup;

	/**
	 * The list of the sub categories
	 */
	private List children;
	
	 
	
	//==================//
    //   Constructeurs  //
    //==================// 
	
	public SubjectsGroupTreeNode(TreeNode parent,ISubjectsGroup subjectsGroup) throws RemoteException
	{
		this.parent = parent;
		this.subjectsGroup = subjectsGroup;
		children = new ArrayList();
        RemoteDataManager.getManager().addDataListener(ISubjectsGroup.class,this);
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 * @throws RemoteException 
	 */
	public SubjectsGroupTreeNode(TreeNode parent,ISubjectsGroup subjectsGroup,DefaultTreeModel model) throws RemoteException
	{
		this(parent,subjectsGroup);
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
		if(subjectsGroup.getLstSubject() == null) return true;
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
		for(int i = 0;i<subjectsGroup.getLstSubject().size();i++)
		{
			add((ISubject)subjectsGroup.getLstSubject().get(i));
		}
		return children;
	}
	
	public ISubjectsGroup getSubjectsGroup()
	{
		return subjectsGroup;
	}
    
    public void setSubjectsGroup(ISubjectsGroup subjectsGroup)
    {
        this.subjectsGroup =  subjectsGroup;
        model.nodeChanged(this);
    }
	/**
	 * Redefinition of the method toString()
	 * @return the name into a string
	 */
	public String toString()
	{
		return subjectsGroup.getName();
	}

	
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(java.lang.Object)
	 */
	public void add() throws FlexiException 
	{
        DataFactory.createSubject("Nouvelle Matière",subjectsGroup);
	}
	
    public void subjectAdded(ISubject subject)
    {
         subjectsGroup.addSubject(subject);
        add(subject);
    }
    
    public void add(ISubject subject)
    {
        try
        {    
            SubjectTreeNode child = new SubjectTreeNode(this,subject,model);
            children.add(child);
            model.nodesWereInserted(this,new int[]{children.size()-1});
        }
        catch(RemoteException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Ajout impossible",JOptionPane.ERROR_MESSAGE);  
        }
    }
	

    public void remove(TreeNode childNode) throws RemoteException, FlexiException 
    {
        RemoteDataManager.getManager().deleteClass(((ClassTreeNode)childNode).getIClass());
    }
	
        /* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	
    public void remove(ISubject subject) 
    {
        SubjectTreeNode childNode = searchChild(subject);
        if(childNode != null)
        {
            subjectsGroup.removeSubject(((SubjectTreeNode)childNode).getSubject());
            int index = children.indexOf(childNode);
            children.remove(childNode); 
            model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
        }
        
		
    }

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setValue(javax.swing.tree.TreePath, java.lang.Object)
	 */
	public void setValue(Object newValue) {
		subjectsGroup.setName((String)newValue);
		model.nodeChanged(this);
		
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
        ISubjectsGroup subjectsGroup = (ISubjectsGroup)event.getSource();
        if(this.subjectsGroup.equals(subjectsGroup))
        {
            int type = event.getEventType();
            switch(type)
            {
                case DataEvent.TYPE_PROPERTY_SUBDATA_ADDED:
                {
                    Object[] tabSubject = event.getSubObjects();
                    for(int i=0;i<tabSubject.length;i++)
                    {
                        subjectAdded((ISubject)tabSubject[i]);
                    }
                    break;
                }
                case DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED:
                {
                    Object[] tabSubject = event.getSubObjects();
                   for(int i=0;i<tabSubject.length;i++)
                   {
                       SubjectTreeNode stn = searchChild((ISubject)tabSubject[i]);
                       if(stn != null)
                       {
                           stn.setSubject((ISubject)tabSubject[i]);
                       }
                   }
                   break; 
                }
                case DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED:
                {
                    Object[] tabSubject = event.getSubObjects();
                    for(int i=0;i<tabSubject.length;i++)
                    {
                        remove((ISubject)tabSubject[i]);
                    }
                    break;   
                }
            } 
        }
    }
    
    public SubjectTreeNode searchChild(ISubject subject)
    {
        Iterator ite = children.iterator() ;
        for(;ite.hasNext();)
        {
            SubjectTreeNode stn= (SubjectTreeNode)ite.next();
            if(stn.getSubject().equals(subject))
            {
                return stn;
            }
        }
        return null;
    }
}
