/*
 * Created on 20 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.device;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;
import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DeviceTreeNode implements FlexiTreeNode
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
	 * The device
	 */
	private IDevice device;

	/**
	 * The list of the sub categories
	 */
	private List children;
	
	/**
	 * List of Listener
	*/
	List listener;  
	
	//==================//
    //   Constructeurs  //
    //==================// 
	
	public DeviceTreeNode(TreeNode parent,IDevice device)
	{
		this.parent = parent;
		this.device = device;
		children = new ArrayList();
		this.listener = new ArrayList();
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 */
	public DeviceTreeNode(TreeNode parent,IDevice device,DefaultTreeModel model)
	{
		this(parent,device);
		this.model=model;
	}
	
	
	//	=============//
    //   Méthodes  //
    //=============//
	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getChildAt(int)
	 */
	public TreeNode getChildAt(int childIndex) {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getChildCount()
	 */
	public int getChildCount() {
		return 0;
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
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getAllowsChildren()
	 */
	public boolean getAllowsChildren() {
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#isLeaf()
	 */
	public boolean isLeaf() {
		return true;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#children()
	 */
	public Enumeration children() {
		return null;
	}
	
    public IDevice getDevice()
	{
		return device;
	}
    
    public void setDevice(IDevice device)
    {
       this.device=device;
       informListenerChange(device.getName());
        model.nodeChanged(this);
    }
	/**
	 * Creates dynamiquely the list of the children when the user click on the "plus"
	 * @return the list of sub categories
	 */
	/*public List processChildren()
	{
		if(children.size()>0)return children;
		
		ArrayList list = new ArrayList(track.getLstClass().size());
		for(int i = 0;i<track.getLstClass().size();i++)
		{
			list.add(new TrackTreeNode(this,(Category)cat.getSubCategories().get(i),factory,model));
		}
		this.children =list;
		return(list);
	}*/
	public String toString()
	{
		return device.getName();
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(java.lang.Object)
	 */
	public TreeNode add() {
		//Non utilisée
		System.out.println("- Add de group");
		return null;
	}
	
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(java.lang.Object)
	 */
	public void change(List obj) {
		//Non utilisée
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public void remove(TreeNode node) {
		//Non Utilisée
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setValue(javax.swing.tree.TreePath, java.lang.Object)
	 */
	public void setValue(Object newValue) {
		device.setName((String)newValue);
		informListenerChange(newValue);
		model.nodeChanged(this);
		
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setModel(fr.umlv.ir3.flexitime.richClient.models.ResourceModel)
	 */
	public void setModel(DefaultTreeModel model) {
		// TODO Auto-generated method stub
		
	}
	public void addFlexiTreeNodeListener(FlexiTreeNodeListener ob)
	{
		listener.add(ob);
	}
	
	public void informListenerChange(Object value)
	{
		Iterator iter = listener.iterator() ;
		for(;iter.hasNext();)
		{
			((FlexiTreeNodeListener)iter.next()).nodeChanged(value);
		}
	}
}
