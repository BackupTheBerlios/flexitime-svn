/*
 * Created on 13 déc. 2004
 * by Adrien Bouvet
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.richClient.gui.panel.management;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import fr.umlv.ir3.flexitime.richClient.models.management.track.TrackViewModel;

/**
 * TrackView - DOCME Description explication supplémentaire si nécessaire in
 * english please... Que fait cette classe, qu'est-ce qu'elle représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * @author FlexiTeam - Adrien Bouvet
 */
public class TrackView
{
	JPanel panel;
	TrackViewModel model;
	JButton okButton;
	JButton cancelButton;
	JTextField name;
	public TrackView(TrackViewModel model)
	{
		this.model=model;
		model.setView(this);
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
        okButton = new JButton("Appliquer");
		cancelButton=new JButton("Annuler");
		okButton.setEnabled(false);
		cancelButton.setEnabled(false);
		name = new JTextField(model.getTrack().getName());
		name.getDocument().addDocumentListener(new DocumentListener(){

			public void insertUpdate(DocumentEvent arg0) {
				okButton.setEnabled(true);
				cancelButton.setEnabled(true);
				
			}

			public void removeUpdate(DocumentEvent arg0) {
				insertUpdate(arg0);
			}

			public void changedUpdate(DocumentEvent arg0) {
				
			}
			
			
		});

		//Mise en place des actions des boutons
		okButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) 
            {
			    try {
					    model.setValue(name.getText());
                        okButton.setEnabled(false);
                        cancelButton.setEnabled(false);
				    } catch (RemoteException e) 
                    {
				        JOptionPane.showMessageDialog(null,e.getMessage(),"Modification impossible",JOptionPane.ERROR_MESSAGE);
				    }
				   
			}	
		});
		cancelButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				name.setText(model.getTrack().getName());
				okButton.setEnabled(false);
				cancelButton.setEnabled(false);
			}
		
		});
		
		FormLayout layout = new FormLayout("50px, pref, 10px, 100dlu,pref,pref,20px,pref,","70px, pref, 30px, pref");
		//Collone 							 1		2	  3		4		5	6	7	  8		9  10	11
		//layout.setRowGroups(new int[][]{{1, 3, 5}});
		panel.setLayout(layout);
		CellConstraints cc = new CellConstraints();
		panel.add(new JLabel("Nom:"), cc.xy (2, 2));
		panel.add(name, cc.xyw(4, 2, 2));
		panel.add(okButton, cc.xy (6, 4));
		panel.add(cancelButton,cc.xy (8, 4));
		
		panel.validate();
		panel.repaint();

	}
	
	public JPanel getPanel()
	{
		return panel;
	}
	
    public void setValue(String value)
    {
        name.setText(value);
    }




	
	
	

	
}