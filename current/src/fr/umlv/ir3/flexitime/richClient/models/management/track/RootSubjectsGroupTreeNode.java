/*
 * Created on 23 janv. 2005
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
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.richClient.models.management.RootTreeNode;

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
		ArrayList list = new ArrayList(lst.size());
		for(int i = 0;i<lst.size();i++)
		{
			list.add(new SubjectsGroupTreeNode(this,(ISubjectsGroup)lst.get(i),model));
		}
		this.children =list;
		return(list);
	}

	public void add() throws FlexiException 
	{

		ISubjectsGroup subGroup = DataFactory.createSubjectsGroup("Nouveau Bloc",teachingStructure);
		lst.add(subGroup);
		SubjectsGroupTreeNode child = new SubjectsGroupTreeNode(this,subGroup,model);
		{
			children.add(child);
		}
		model.nodesWereInserted(this,new int[]{children.size()-1});
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
        // TODO Auto-generated method stub
        
    }
}
