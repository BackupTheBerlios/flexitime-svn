/*
 * Created on 20 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.gui.actions.management;

import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DefaultTreeActions 
{
	private static FlexiLanguage language = FlexiLanguage.getInstance();
    public static Action add(final TreeModel model,final TreeNode treeNode)
	{
		Action action = new AbstractAction()
		{

			/**
			 * Comment for <code>serialVersionUID</code>
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) 
			{
					try 
                    {
						((ResourceTreeModel)model).add(treeNode);
					} 
                    catch (FlexiException e) {
                        JOptionPane.showMessageDialog(null,e.getMessage(),language.getText("erreurAdd"),JOptionPane.ERROR_MESSAGE);
					}
					
				
			}
			
		};
		return action;
	}
	
	public static Action remove(final TreeModel model,final TreeNode treeNode)
	{
		Action action = new AbstractAction()
		{

			/**
			 * Comment for <code>serialVersionUID</code>
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) 
			{
                try 
                {	
                    ((ResourceTreeModel)model).remove(treeNode);
                }catch (FlexiException e) 
                {
                    JOptionPane.showMessageDialog(null,e.getMessage(),"Suppression impossible",JOptionPane.ERROR_MESSAGE);
                }
                catch(RemoteException re)
                {
                    JOptionPane.showMessageDialog(null,re.getMessage(),"Probleme Distant",JOptionPane.ERROR_MESSAGE);  
                }
                
			}
			
		};
		return action;
	}
	
	public static Action rename(final TreeModel model,final JTree tree,final Object value)
	{
		Action action = new AbstractAction()
		{

			/**
			 * Comment for <code>serialVersionUID</code>
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) 
			{
                ((ResourceTreeModel)model).valueForPathChanged(tree.getSelectionPath(),value);
				
			}
			
		};
		
		return action;
	}
}
