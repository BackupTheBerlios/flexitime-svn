package fr.umlv.ir3.flexitime.richClient.models.management;

import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import fr.umlv.ir3.flexitime.common.exception.FlexiException;



/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ResourceTreeModel extends DefaultTreeModel {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The constructor by initialising
	 * @param node the node of the new category
	 * @param factory the BuckFactory
	 * @param book the book
	 */
	public ResourceTreeModel(TreeNode node)
	{
		super(node);
		((FlexiTreeNode)node).setModel(this);
	}	
	
	/**
	 * To add a resource
	 * @param tree the tree of the categories
	 * @param value the new category
	 * @throws FlexiException 
	 */
	public void add(TreeNode tree) throws FlexiException
	{
		((FlexiTreeNode)tree).add();
	}
	
	/**
	 * To remove a category
	 * @param tree the category to be deleted
	 * @throws FlexiException 
	 * @throws RemoteException 
	 */
	public void remove(TreeNode tree) throws RemoteException, FlexiException
	{
		if(tree.getParent()!=null)
		{
			FlexiTreeNode treeParent = (FlexiTreeNode)tree.getParent();
			treeParent.remove(tree);
		}
	}
	
	/**
	 * Redefinition of the method valueForPathChanged
	 * @param path the path
	 * @param newValue the newValue 
	 * @throws RemoteException 
	 */
	public void valueForPathChanged(TreePath path,Object newValue)
	{
		
        //System.out.println("path:"+ path+"  value:"+newValue );
		FlexiTreeNode node = (FlexiTreeNode)path.getLastPathComponent();
		try 
        {
			node.setValue(newValue);
		} catch (RemoteException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Modififcation impossible",JOptionPane.ERROR_MESSAGE);
		}
	}

}
