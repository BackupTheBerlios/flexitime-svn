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
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RootDeviceTreeNode extends RootTreeNode
{
//	==================//
    //   Constructeurs  //
    //==================// 
	
	public RootDeviceTreeNode(TreeNode parent,List lstDevice)
	{
		super(parent,lstDevice);
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 */
	public RootDeviceTreeNode(TreeNode parent,List lstDevice,DefaultTreeModel model)
	{
		super(parent,lstDevice,model);
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
		Iterator ite = lst.iterator();
		HashMap map = new HashMap();
		for(;ite.hasNext();)
		{
			IDevice dev = (IDevice)ite.next();
			if(!map.containsKey(new Integer(dev.getType())))
			{
				ArrayList Devicelist = new ArrayList();
				Devicelist.add(dev);
				map.put(new Integer(dev.getType()),Devicelist);
			}
			else
			{
				((ArrayList)map.get(new Integer(dev.getType()))).add(dev);
			}
		}
		Iterator TypeDeviceIte = map.keySet().iterator();
		for(;TypeDeviceIte.hasNext();)
		{
			Integer type = (Integer)TypeDeviceIte.next();
			String name = new String();
			name += type;
			List lstDevice = (List)map.get(type);
			
			list.add(new TypeDeviceTreeNode(this,name,lstDevice,model));
		}
		this.children =list;
		return(list);
	}

	public TreeNode add() 
	{
		//synchronized(this.cat)
		//{
		ITrack track = DataFactory.createTrack("Nouvelle Filière");
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
		lst.remove(((DeviceTreeNode)childNode).getDevice());
		int index = children.indexOf(childNode);
		children.remove(childNode);	
		model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
		
	}
}
