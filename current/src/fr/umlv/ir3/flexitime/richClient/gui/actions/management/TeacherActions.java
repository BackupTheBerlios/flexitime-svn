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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.richClient.models.management.teacher.TeacherListModel;

/**
 * represents the différents actions that a user can to do on the model of a teacher
 * @author Guillaume GUERRIN
 */
public class TeacherActions 
{
	private static FlexiLanguage language = FlexiLanguage.getInstance();
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
					JOptionPane.showMessageDialog(null,e.getMessage(),language.getText("errorDisplay"),JOptionPane.ERROR_MESSAGE);
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
						JOptionPane.showMessageDialog(null,e.getMessage(),language.getText("errorDel"),JOptionPane.ERROR_MESSAGE);
					} catch (FlexiException e) {
						JOptionPane.showMessageDialog(null,e.getMessage(),language.getText("errorDel"),JOptionPane.ERROR_MESSAGE);
					}
					list.setSelectedIndex(0);
			}
			
		};
		return action;
	}
}
