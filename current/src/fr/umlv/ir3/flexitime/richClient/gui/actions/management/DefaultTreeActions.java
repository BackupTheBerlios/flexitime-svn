/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
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

import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;

/**
 * represents the différents actions that a user can to do on the model
 * @author Guillaume GUERRIN
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
                        JOptionPane.showMessageDialog(null,e.getMessage(),language.getText("errorAdd"),JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(null,e.getMessage(),language.getText("errorDel"),JOptionPane.ERROR_MESSAGE);
                }
                catch(RemoteException re)
                {
                    JOptionPane.showMessageDialog(null,re.getMessage(),language.getText("errorCom"),JOptionPane.ERROR_MESSAGE);  
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
