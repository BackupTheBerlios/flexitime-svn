/*
 * Created on 13 déc. 2004
 * by Adrien Bouvet
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.richClient.gui.panel.management;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * DevicesView - DOCME Description explication supplémentaire si nécessaire in
 * english please... Que fait cette classe, qu'est-ce qu'elle représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * @author FlexiTeam - Adrien Bouvet
 */
public class DevicesView extends JLabel
{
	public DevicesView()
	{
		
		super();
		create();
	}
	/**
	 * This function create a label
	 * @param c the container
	 * @param title the title 
	 * @param gb the gridBag
	 * @param cont contrainst
	 * @return a JLabel
	 */
	public static JLabel createLabel(Container c,String title,GridBagLayout gb,GridBagConstraints cont)
	{
		JLabel label=new JLabel(title);
		gb.setConstraints(label,cont);
		return label;
	}

	/**
	 * This function create a button
	 * @param c the button
	 * @param title the title 
	 * @param gb the gridBag
	 * @param cont contrainst
	 * @return a JButton
	 */
	public static JButton createButton(JButton button,Container c,String title,GridBagLayout gb,GridBagConstraints cont)
	{
		gb.setConstraints(button,cont);
		return button;
	}

	/**
	 * This function create a text field
	 * @param c the text field
	 * @param title the title 
	 * @param gb the gridBag
	 * @param cont contrainst
	 * @return a JTextField
	 */
	public static JTextField createTextField(JTextField text,Container c,String title,GridBagLayout gb,GridBagConstraints cont)
	{
		gb.setConstraints(text,cont);
		return text;
	}

	/**
	 * This function create a frame where the user writes the information
	 * @param frame the frame
	 * @param name the name
	 * @param description the description
	 * @param okButton the button ok
	 * @param cancelButton the button cancel
	 */
	public void create()
	{

		JTextField name = new JTextField();
		//JTextField type= new JTextField("TYPE");
		JComboBox type = new JComboBox();
		type.addItem("Vidéo Projecteur");
		type.addItem("Télévision");
		type.addItem("Ordinateur Portable");
		
		JTextField text= new JTextField();
		JButton okButton= new JButton("Appliquer");
		JButton cancelButton=new JButton("Annuler");
		JButton addType = new JButton("...");
		
		FormLayout layout = new FormLayout("10px, pref, pref, 10px, 70dlu,pref,20px,pref,pref,20px,pref","50px, pref, 25px, pref, 50px,pref,pref");
		//Collone 							 1		2	  3		4		5	6	7	  8		9  10	11
		//layout.setRowGroups(new int[][]{{1, 3, 5}});
		this.setLayout(layout);
		CellConstraints cc = new CellConstraints();
		this.add(new JLabel("Nom"), cc.xy (3, 2));
		this.add(name, cc.xyw(5, 2, 2));
		this.add(new JLabel("Type"), cc.xy (3, 4));
		this.add(type, cc.xy (5, 4));
		this.add(addType, cc.xy (8, 4));
		this.add(okButton, cc.xy (9, 7));
		this.add(cancelButton,cc.xy (11, 7));
		
		this.validate();
		this.repaint();

	}

}