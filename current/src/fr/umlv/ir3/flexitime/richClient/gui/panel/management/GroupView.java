/*
 * Created on 22 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.gui.panel.management;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

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
import fr.umlv.ir3.flexitime.richClient.models.management.track.GroupTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.GroupViewModel;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class GroupView
{

	JPanel panel;
	GroupViewModel model;
	JButton okButton;
	JButton cancelButton;
	JTextField name;
	JTextField nbPerson;
	JLabel errorLabel;
	public GroupView(GroupViewModel model)
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
		errorLabel = new JLabel();
		errorLabel.setForeground(Color.RED);
		errorLabel.setVisible(false);
		okButton = new JButton("Appliquer");
		okButton.setEnabled(false);
		cancelButton=new JButton("Annuler");
		cancelButton.setEnabled( false);
		name = new JTextField(model.getGroup().getName());
		nbPerson = new JTextField(""+ model.getGroup().getNbPerson());
		DocumentListener documentListener = new DocumentListener(){

			public void insertUpdate(DocumentEvent arg0) {
				try{
		            Integer number = Integer.valueOf(nbPerson.getText()).intValue();
		            okButton.setEnabled(true);
					cancelButton.setEnabled(true);
					errorLabel.setVisible(false);
				}
		        catch(NumberFormatException e){
		        	if(nbPerson.getText().length()>9)errorLabel.setText("Valeur excessive");
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
		nbPerson.getDocument().addDocumentListener(documentListener);
		//Mise en place des actions des boutons
		okButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) 
			{
				try 
                {
    			    String[] values = new String[2];
    				values[0]=name.getText();
    				values[1]=nbPerson.getText();
    				model.setValue(values);
    				okButton.setEnabled(false);
    				cancelButton.setEnabled(false);
                } 
                catch (RemoteException e) {
                    JOptionPane.showMessageDialog(null,e.getMessage(),"Modification impossible",JOptionPane.ERROR_MESSAGE);
                }
			}	
		});
		cancelButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				name.setText(model.getGroup().getName());
				nbPerson.setText(""+model.getGroup().getNbPerson());
				okButton.setEnabled(false);
				cancelButton.setEnabled(false);
			}
		
		});
		
		FormLayout layout = new FormLayout("50px, pref, 10px, 50dlu,35dlu,pref,20px,pref,","70px, pref, 20px, pref,20px,30px,pref");
		//Collone 							 1		2	  3		4		5	6	7	  8		9  10	11
		//layout.setRowGroups(new int[][]{{1, 3, 5}});
		panel.setLayout(layout);
		CellConstraints cc = new CellConstraints();
		panel.add(new JLabel("Nom:"), cc.xy (2, 2));
		panel.add(name, cc.xyw(4, 2, 2));
		panel.add(new JLabel("Nombre de Personnes:"), cc.xyw (2, 4,3));
		panel.add(nbPerson, cc.xy (5, 4));
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
     
    public void fireChanged()
     {
         name.setText(model.getGroup().getName());
         nbPerson.setText("" + model.getGroup().getNbPerson());
     }
}
