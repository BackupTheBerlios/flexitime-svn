/*
 * Created on 20 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;

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
	
	public RootRoomTreeNode(TreeNode parent,List lstBuilding)
	{
		super(parent,lstBuilding);
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 */
	public RootRoomTreeNode(TreeNode parent,List lstBuilding,DefaultTreeModel model)
	{
		super(parent,lstBuilding,model);
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
			list.add(new BuildingTreeNode(this,(IBuilding)lst.get(i),model));
		}
		this.children =list;
		return(list);
	}

	public TreeNode add() 
	{
		//synchronized(this.cat)
		//{
		IBuilding build = DataFactory.createBuilding("Nouveau Batiment");
		BuildingTreeNode child = new BuildingTreeNode(this,build,model);
		lst.add(build);
		if(children.size()==0)
		{
			processChildren();
		}
		else
		{
			children.add(child);
		}
		model.nodesWereInserted(this,new int[]{children.size()-1});
		return child;
	}
	
	
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(java.lang.Object)
	 */
	public TreeNode add(List value) {
		if(value.size() == 1)
		{
			ITrack track = DataFactory.createTrack((String)value.get(0));
			TrackTreeNode child = new TrackTreeNode(this,track,model);
			if(children.size()==0)
			{
				processChildren();
			}
			else
			{
				children.add(child);
			}
			model.nodesWereInserted(this,new int[]{children.size()-1});
			return child;
		}
		return null;
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
}
