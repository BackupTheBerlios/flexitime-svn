/*
 * Created on 20 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.device;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;
import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TypeDeviceTreeNode implements FlexiTreeNode
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
	 * The list of device
	 */
	private List lstDevice;

	/**
	 * The name of the type
	 */
	private String name;
	/**
	 * The int of the type
	 */
	private int type;
	/**
	 * The list of the sub categories
	 */
	private List children;
	
	 
	
	//==================//
    //   Constructeurs  //
    //==================// 
	
	public TypeDeviceTreeNode(TreeNode parent,String name,int type,List lstDevice)
	{
		this.parent = parent;
		this.name=name;
		this.type =type;
		this.lstDevice = lstDevice;
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 * @throws RemoteException 
	 */
	public TypeDeviceTreeNode(TreeNode parent,String name,int type,List lstDevice,DefaultTreeModel model)
	{
		this(parent,name,type,lstDevice);
		this.model=model;
		children = new ArrayList();
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
		if(lstDevice == null) return true;
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
		
		ArrayList list = new ArrayList(lstDevice.size());
		for(int i = 0;i<lstDevice.size();i++)
		{
			list.add(new DeviceTreeNode(this,(IDevice)lstDevice.get(i),model));
		}
		this.children =list;
		return(list);
	}
	
	public List getLstDevice()
	{
		return lstDevice;
	}
    public int getType()
    {
        return type;
    }
	/**
	 * Redefinition of the method toString()
	 * @return the name into a string
	 */
	public String toString()
	{
		return name;
	}

	
	/*
    * (non-Javadoc)
     * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(java.lang.Object)
     */
    public TreeNode add() throws FlexiException 
    {
            IDevice device= DataFactory.createDevice("Nouveau Matériel");
            device.setType(type);
            return(add(device));
    }
    
	public TreeNode add(IDevice device)
    {
        lstDevice.add( device);
        DeviceTreeNode child = new DeviceTreeNode(this,device,model);
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
	public void change(List value) {
		//Non utilisée
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public void remove(TreeNode childNode) throws RemoteException, FlexiException {
		lstDevice.remove(((DeviceTreeNode)childNode).getDevice());
        ((RootDeviceTreeNode)this.getParent()).getList().remove(((DeviceTreeNode)childNode).getDevice());
		int index = children.indexOf(childNode);
		children.remove(childNode);	
		model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
		
	}
    
    public void remove(IDevice device) {
        DeviceTreeNode childNode = searchChild(device);
        lstDevice.remove(device);
        int index = children.indexOf(childNode);
        children.remove(childNode); 
        model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
        
    }
    
    public DeviceTreeNode searchChild(IDevice device)
    {
        Iterator ite = children.iterator() ;
        for(;ite.hasNext();)
        {
            DeviceTreeNode dtn= (DeviceTreeNode)ite.next();
            if(dtn.getDevice().equals(device))
            {
                return dtn;
            }
        }
        return null;
    }

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setValue(javax.swing.tree.TreePath, java.lang.Object)
	 */
	public void setValue(Object device) {
		DeviceTreeNode childNode = searchChild((IDevice)device);
        childNode.setDevice(((IDevice)device));
	}


	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setModel(fr.umlv.ir3.flexitime.richClient.models.ResourceModel)
	 */
	public void setModel(DefaultTreeModel model) {
		this.model= (ResourceTreeModel)model;
		
	}
	public void addFlexiTreeNodeListener(FlexiTreeNodeListener ob)
	{
		//Non utilisée
	}
	
	public void informListenerChange(Object value)
	{
		//Non utilisée
	}

}
