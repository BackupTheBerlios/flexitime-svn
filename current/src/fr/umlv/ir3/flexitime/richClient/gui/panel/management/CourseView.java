/*
 * Created on 22 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.gui.panel.management;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
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

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CourseView
{

	JPanel panel;
	ResourceTreeModel model;
	JTree tree;
	JButton okButton;
	JButton cancelButton;
	JTextField name;
	JLabel nbPerson;
	JLabel nbGroup;
    JTextField nbHourTotal;
    JTextField time;
    JColorChooser coul;
    JButton buttonCoul;
    JTextField prof;
    
	//JTextField nbPerson;
	//JTextField nbGroup;
	JLabel errorLabel;
	public CourseView(TreeModel model,JTree tree)
	{
		this.model=(ResourceTreeModel)model;
		this.tree=tree;
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
		nbHourTotal = new JTextField();
        time = new JTextField();
        coul = new JColorChooser(Color.BLUE);
        prof = new JTextField();
        /*errorLabel = new JLabel();
		errorLabel.setForeground(Color.RED);
		errorLabel.setVisible(false);*/
		okButton = new JButton("Appliquer");
		okButton.setEnabled(false);
		cancelButton=new JButton("Annuler");
		cancelButton.setEnabled( false);
        buttonCoul= new JButton (">");
		name = new JTextField(tree.getSelectionPath().getLastPathComponent().toString());
		//nbPerson = new JLabel(""+((CourseTreeNode)tree.getSelectionPath().getLastPathComponent()).getIClass().getNbPerson());
		//nbPerson = new JTextField(""+((ClassTreeNode)tree.getSelectionPath().getLastPathComponent()).getIClass().getNbPerson());
		//nbPerson.setEnabled(false);
		//nbGroup = new JLabel(""+((ClassTreeNode)tree.getSelectionPath().getLastPathComponent()).getIClass().getNbGroup());
		//nbGroup = new JTextField(""+((ClassTreeNode)tree.getSelectionPath().getLastPathComponent()).getIClass().getNbGroup());
		//nbGroup.setEnabled(false);
		DocumentListener documentListener = new DocumentListener(){

			public void insertUpdate(DocumentEvent arg0) {
		            okButton.setEnabled(true);
					cancelButton.setEnabled(true);
			}

			public void removeUpdate(DocumentEvent arg0) {
				insertUpdate(arg0);
			}

			public void changedUpdate(DocumentEvent arg0) {}
			
			
		};
		name.getDocument().addDocumentListener(documentListener);
		//Mise en place des actions des boutons
		okButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) 
			{
				model.valueForPathChanged(tree.getSelectionPath(),name.getText());
				okButton.setEnabled(false);
				cancelButton.setEnabled(false);
			}	
		});
		cancelButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				name.setText(tree.getSelectionPath().getLastPathComponent().toString());
				nbPerson.setText(""+((GroupTreeNode)tree.getSelectionPath().getLastPathComponent()).getGroup().getNbPerson());
				okButton.setEnabled(false);
				cancelButton.setEnabled(false);
			}
		
		});
		
        buttonCoul.addActionListener(new ActionListener()
                {

                    public void actionPerformed(ActionEvent arg0)
                    {
                        JPopupMenu popMenu = new JPopupMenu();
                        popMenu.add(coul);
                        popMenu.setVisible(true);
                        popMenu.show((Component)arg0.getSource(),buttonCoul.getX(),buttonCoul.getY());
                        //JMenuItem menuItem;
                        
                    }
            
        });
		FormLayout layout = new FormLayout("50px, pref, 10px, 50dlu,50px,50dlu,70px","70px, pref, 20px, pref,20px,pref,20px,pref,20px,pref,40px,pref");
		//Collone 							 1		2	  3		4	  5	   6	7	 8	 9    10     1      2    3      4    5    6    7    8    9     10
		//layout.setRowGroups(new int[][]{{1, 3, 5}});
		panel.setLayout(layout);
		CellConstraints cc = new CellConstraints();
		panel.add(new JLabel("Nom:"), cc.xy (2, 2));
		panel.add(name, cc.xyw(4, 2, 2));
		panel.add(new JLabel("Nombre d'heures totales:"), cc.xyw (4, 4, 3));
		panel.add(nbHourTotal, cc.xy (6, 4));
		panel.add(new JLabel("Durée d'une séance"), cc.xyw (4, 6, 3));
		panel.add(time, cc.xy (6, 6));
		panel.add(new JLabel("Couleur:"),cc.xy (4, 8));
        panel.add(buttonCoul,cc.xy(6, 8));
        panel.add(new JLabel("Professeur:"),cc.xy (4, 10));
        panel.add(prof,cc.xy(6, 10));
        panel.add(okButton, cc.xy (4, 12));
		panel.add(cancelButton,cc.xy (6, 12));
		
		panel.validate();
		panel.repaint();

	}
	
	public JPanel getPanel()
	{
		return panel;
	}


}
