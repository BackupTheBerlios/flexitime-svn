/*
 * Created on 20 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.gui.actions.management;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;
import fr.umlv.ir3.flexitime.richClient.models.management.teacher.TeacherListModel;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TeacherActions 
{
	public static Action addTeacher(final ListModel model, final JList list)
	{
		
		Action action = new AbstractAction()
		{

			/**
			 * Comment for <code>serialVersionUID</code>
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) 
			{	
				((TeacherListModel)model).add();
				 System.out.println(((TeacherListModel)model).getSize());
				 list.setSelectedIndex(((TeacherListModel)model).getSize()-1);//list.getVisibleRowCount());
			}
			
		};
		return action;
	}
	
	public static Action removeTeacher(final ListModel model,final JList list)
	{
		Action action = new AbstractAction()
		{
			/**
			 * Comment for <code>serialVersionUID</code>
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) 
			{
					((TeacherListModel)model).remove(list.getSelectedIndex());
					list.setSelectedIndex(0);
			}
			
		};
		return action;
	}
}
