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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

import fr.umlv.ir3.flexitime.common.exception.FlexiException;
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
				try 
                {
					((TeacherListModel)model).add();
				} catch (FlexiException e)
                {
					JOptionPane.showMessageDialog(null,e.getMessage(),"Ajout impossible",JOptionPane.ERROR_MESSAGE);
				}
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
					try {
						((TeacherListModel)model).remove(list.getSelectedIndex());
					} catch (RemoteException e) {
						JOptionPane.showMessageDialog(null,e.getMessage(),"Suppression impossible",JOptionPane.ERROR_MESSAGE);
					} catch (FlexiException e) {
						JOptionPane.showMessageDialog(null,e.getMessage(),"Suppression impossible",JOptionPane.ERROR_MESSAGE);
					}
					list.setSelectedIndex(0);
			}
			
		};
		return action;
	}
}
