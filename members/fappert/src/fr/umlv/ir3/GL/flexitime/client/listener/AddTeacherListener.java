/*
 * Created on 20 févr. 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package fr.umlv.ir3.GL.flexitime.client.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.umlv.ir3.GL.flexitime.client.model.TeacherListModel;

/**
 *
 * The AddTiersControleur notify the model to add a Tiers
 * 
 * @author Adrien Bouvet & Fabien Appert
 */
public class AddTeacherListener implements ActionListener
{

	private TeacherListModel model;
	/**
	 * 
	 */
	public AddTeacherListener(TeacherListModel model)
	{
		super();
		this.model = model;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0)
	{
		String text1 = JOptionPane.showInputDialog(null,"Entrez un nom");
		String text2 = JOptionPane.showInputDialog(null,"Entrez un prénom");
		String text3 = JOptionPane.showInputDialog(null,"Entrez un mail");
		if(text1 == null)
			return;
		
		model.add(text1,text2,text3);

	}

}
