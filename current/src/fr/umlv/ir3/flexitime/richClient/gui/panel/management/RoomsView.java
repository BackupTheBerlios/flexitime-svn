/*
 * Created on 13 déc. 2004
 * by Adrien Bouvet
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.richClient.gui.panel.management;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.tree.TreeModel;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;
import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;
import fr.umlv.ir3.flexitime.richClient.models.management.room.RoomTreeNode;

/**
 * RoomsView - DOCME Description explication supplémentaire si nécessaire in
 * english please... Que fait cette classe, qu'est-ce qu'elle représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * @author FlexiTeam - Adrien Bouvet
 */
public class RoomsView implements FlexiTreeNodeListener
{
	JPanel panel;
	ResourceTreeModel model;
	JTree tree;
	JButton okButton;
	JButton cancelButton;
	JTextField name;
	JTextField capacity;
	JLabel errorLabel;
	public RoomsView(TreeModel model,JTree tree)
	{
		this.model=(ResourceTreeModel)model;
		this.tree=tree;
		((FlexiTreeNode)this.tree.getSelectionPath().getLastPathComponent()).addFlexiTreeNodeListener(this);
		create();
	}
	

	/**
	 * This function create a frame where the user writes the information
	 * @param frame the frame
	 * @param name the name
	 * @param description the description
	 * @param okButton the button ok
	 * @param cancelButton the button cancel
	 */
	private void create()
	{
		panel = new JPanel();
		errorLabel = new JLabel();
		errorLabel.setForeground(Color.RED);
		errorLabel.setVisible(false);
		okButton = new JButton("Appliquer");
		okButton.setEnabled(false);
		cancelButton=new JButton("Annuler");
		cancelButton.setEnabled( false);
		name = new JTextField(tree.getSelectionPath().getLastPathComponent().toString());
		capacity = new JTextField(""+((RoomTreeNode)tree.getSelectionPath().getLastPathComponent()).getRoom().getCapacity());
		DocumentListener documentListener = new DocumentListener(){

			public void insertUpdate(DocumentEvent arg0) {
				try{
		            Integer number = Integer.valueOf(capacity.getText()).intValue();
		            okButton.setEnabled(true);
					cancelButton.setEnabled(true);
					errorLabel.setVisible(false);
				}
		        catch(NumberFormatException e){
		        	if(capacity.getText().length()>9)errorLabel.setText("Valeur excessive");
		        	else errorLabel.setText("Valeur numérique uniquement");
		        	errorLabel.setVisible(true);
		        	okButton.setEnabled(false);
					cancelButton.setEnabled(false);
		        } 
			}

			public void removeUpdate(DocumentEvent arg0) {
				insertUpdate(arg0);
			}

			public void changedUpdate(DocumentEvent arg0) {}
			
			
		};
		name.getDocument().addDocumentListener(documentListener);
		capacity.getDocument().addDocumentListener(documentListener);
		//Mise en place des actions des boutons
		okButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) 
			{
				List list = new ArrayList();
				list.add(name.getText());
				list.add(capacity.getText());
				model.change((FlexiTreeNode)tree.getSelectionPath().getLastPathComponent(),list);
				okButton.setEnabled(false);
				cancelButton.setEnabled(false);
			}	
		});
		cancelButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				name.setText(tree.getSelectionPath().getLastPathComponent().toString());
				capacity.setText(""+((RoomTreeNode)tree.getSelectionPath().getLastPathComponent()).getRoom().getCapacity());
				okButton.setEnabled(false);
				cancelButton.setEnabled(false);
			}
		
		});
		
		FormLayout layout = new FormLayout("50px, pref, 10px, 35dlu,50dlu,pref,20px,pref,","70px, pref, 20px, pref,20px,30px,pref");
		//Collone 							 1		2	  3		4		5	6	7	  8		9  10	11
		//layout.setRowGroups(new int[][]{{1, 3, 5}});
		panel.setLayout(layout);
		CellConstraints cc = new CellConstraints();
		panel.add(new JLabel("Nom:"), cc.xy (2, 2));
		panel.add(name, cc.xyw(4, 2, 2));
		panel.add(new JLabel("Capacité:"), cc.xy (2, 4));
		panel.add(capacity, cc.xy (4, 4));
		panel.add(errorLabel,cc.xyw(2,5,4));
		panel.add(okButton, cc.xy (6, 7));
		panel.add(cancelButton,cc.xy (8, 7));
		
		panel.validate();
		panel.repaint();

	}
	
	public JPanel getPanel()
	{
		return panel;
	}


	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.gui.actions.FlexiTreeNodeListener#nodeChanged(java.lang.Object)
	 */
	public void nodeChanged(Object obj) {
		name.setText( (String)obj);
		okButton.setEnabled( false);
		cancelButton.setEnabled( false);
		
	}
}