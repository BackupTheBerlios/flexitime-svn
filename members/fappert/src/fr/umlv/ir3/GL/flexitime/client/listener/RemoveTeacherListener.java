/*
 * Created on 20 févr. 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package fr.umlv.ir3.GL.flexitime.client.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import fr.umlv.ir3.GL.flexitime.client.model.TeacherListModel;

/**
 *
 * The RemoveTiersControleur notify the model to remove a Tiers
 * 
 * @author Adrien Bouvet & Fabien Appert
 */
public class RemoveTeacherListener implements ActionListener
{

	private TeacherListModel model;
	private JList list;

	/**
	 * 
	 */
	public RemoveTeacherListener(TeacherListModel model, JList list)
	{
		super();
		this.model = model;
		this.list = list;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0)
	{
		if(list.getSelectedIndex() != -1)
			model.remove(list.getSelectedIndex());
	}

}
