/*
 * Created on 23 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.models.management.RootTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.ClassTreeNode;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RootSubjectsGroupTreeNode extends RootTreeNode
{
	//==================//
    //     Champs		//
    //==================// 
	ITeachingStructure teachingStructure;
	//	==================//
    //   Constructeurs  //
    //==================// 
	
	public RootSubjectsGroupTreeNode(TreeNode parent,ITeachingStructure teachingStructure) throws RemoteException
	{
		super(parent,teachingStructure.getLstSubjectsGroup());
		this.teachingStructure = teachingStructure;
        RemoteDataManager.getManager().addDataListener(ITeachingStructure.class,this);
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 * @throws RemoteException 
	 */
	public RootSubjectsGroupTreeNode(TreeNode parent,ITeachingStructure teachingStructure,DefaultTreeModel model) throws RemoteException
	{
		super(parent,teachingStructure.getLstSubjectsGroup(),model);
		this.teachingStructure=teachingStructure;
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
			add((ISubjectsGroup)lst.get(i));
		}
		return children;
	}

	public void add() throws FlexiException 
	{

		ISubjectsGroup subGroup = DataFactory.createSubjectsGroup("Nouveau Bloc",teachingStructure);
	}
    
    public void subjectsGroupAdded(ISubjectsGroup subGroup)
    {
        lst.add(subGroup);
        add(subGroup);
    }
    
    public void add(ISubjectsGroup subGroup)
    {
        try
        {    
            SubjectsGroupTreeNode child = new SubjectsGroupTreeNode(this,subGroup,model);
            children.add(child);
            model.nodesWereInserted(this,new int[]{children.size()-1});
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
        RemoteDataManager.getManager().deleteSubjectsGroup(((SubjectsGroupTreeNode)childNode).getSubjectsGroup());  
        
    }
    
    
    /* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(javax.swing.tree.TreeNode)
	 */
	public void remove(ISubjectsGroup subGroup) 
    {
		SubjectsGroupTreeNode childNode = searchChild(subGroup);
        lst.remove(((SubjectsGroupTreeNode)childNode).getSubjectsGroup());
		int index = children.indexOf(childNode);
		children.remove(childNode);	
		model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
		
	}

    /* (non-Javadoc)
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
     */
    public void dataChanged(DataEvent event) throws RemoteException
    {
        ITeachingStructure teaching = (ITeachingStructure)event.getSource();
        if(this.teachingStructure.equals(teaching))
        {
            int type = event.getEventType();
            switch(type)
            {
                case DataEvent.TYPE_PROPERTY_SUBDATA_ADDED:
                {
                    Object[] tabSubjectsGroup = event.getSubObjects();
                    for(int i=0;i<tabSubjectsGroup.length;i++)
                    {
                        subjectsGroupAdded((ISubjectsGroup)tabSubjectsGroup[i]);
                    }
                    break;
                }
                case DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED:
                {
                    Object[] tabSubjectsGroup = event.getSubObjects();
                   for(int i=0;i<tabSubjectsGroup.length;i++)
                   {
                       SubjectsGroupTreeNode sgtn = searchChild((ISubjectsGroup)tabSubjectsGroup[i]);
                       sgtn.setSubjectsGroup((ISubjectsGroup)tabSubjectsGroup[i]);
                   }
                   break; 
                }
                case DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED:
                {
                    Object[] tabSubjectsGroup = event.getSubObjects();
                    for(int i=0;i<tabSubjectsGroup.length;i++)
                    {
                        remove((ISubjectsGroup)tabSubjectsGroup[i]);
                    }
                    break;   
                }
            }
        }
    }
    
    
    public SubjectsGroupTreeNode searchChild(ISubjectsGroup subGroup)
    {
        Iterator ite = children.iterator() ;
        for(;ite.hasNext();)
        {
            SubjectsGroupTreeNode sgtn= (SubjectsGroupTreeNode)ite.next();
            if(sgtn.getSubjectsGroup().equals(subGroup))
            {
                return sgtn;
            }
        }
        return null;
    }
}
