/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.panel.management;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.RemoteException;

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

import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;
import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;
import fr.umlv.ir3.flexitime.richClient.models.management.track.ClassTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.ClassViewModel;
import fr.umlv.ir3.flexitime.richClient.models.management.track.GroupTreeNode;

/**
 * ClassView
 * represents the view of a Class
 * @author Guillaume GUERRIN
 */
public class ClassView
{

	JPanel panel;
	ClassViewModel model;
	JButton okButton;
	JButton cancelButton;
	JTextField name;
	JLabel nbPerson;
	JLabel nbGroup;
	//JTextField nbPerson;
	//JTextField nbGroup;
	JLabel errorLabel;
    private static FlexiLanguage language = FlexiLanguage.getInstance();
	public ClassView(ClassViewModel model)
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
		/*errorLabel = new JLabel();
		errorLabel.setForeground(Color.RED);
		errorLabel.setVisible(false);*/
		okButton = new JButton(language.getText("apply"));
		okButton.setEnabled(false);
		cancelButton=new JButton(language.getText("cancel"));
		cancelButton.setEnabled( false);
		name = new JTextField(model.getIClass().getName());
		nbPerson = new JLabel(""+model.getIClass().getNbPerson());
		//nbPerson = new JTextField(""+((ClassTreeNode)tree.getSelectionPath().getLastPathComponent()).getIClass().getNbPerson());
		nbPerson.setEnabled(false);
		nbGroup = new JLabel(""+model.getIClass().getNbGroup());
		//nbGroup = new JTextField(""+((ClassTreeNode)tree.getSelectionPath().getLastPathComponent()).getIClass().getNbGroup());
		nbGroup.setEnabled(false);
		KeyListener keylName=new KeyListener() 
        {

            public void keyTyped(KeyEvent e){}
            public void keyPressed(KeyEvent e){}
            public void keyReleased(KeyEvent e)
            {
                okButton.setEnabled(true);
                cancelButton.setEnabled(true);
            }
        };
		name.addKeyListener(keylName);
		//Mise en place des actions des boutons
		okButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) 
			{
				try 
                {
					model.setValue(name.getText());
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
				name.setText(model.getIClass().getName());
				//nbPerson.setText(""+((GroupTreeNode)tree.getSelectionPath().getLastPathComponent()).getGroup().getNbPerson());
				okButton.setEnabled(false);
				cancelButton.setEnabled(false);
			}
		
		});
		
		FormLayout layout = new FormLayout("50px, pref, 10px, 50dlu,36px,30dlu,20px,pref,30px,pref","70px, pref, 20px, pref,20px,pref,30px,pref");
		//Collone 							 1		2	  3		4	  5	   6	7	 8	 9    10     1      2    3      4    5    6    7    8    9     10
		//layout.setRowGroups(new int[][]{{1, 3, 5}});
		panel.setLayout(layout);
		CellConstraints cc = new CellConstraints();
		panel.add(new JLabel(language.getText("formName")+" :"), cc.xy (2, 2));
		panel.add(name, cc.xyw(4, 2, 2));
		panel.add(new JLabel(language.getText("nbGroup")+" :"), cc.xyw (4, 4,3));
		panel.add(nbGroup, cc.xy (6, 4));
		panel.add(new JLabel(language.getText("nbPerson")+" :"), cc.xyw (4, 6,3));
		panel.add(nbPerson, cc.xy (6, 6));
		panel.add(okButton, cc.xy (8, 8));
		panel.add(cancelButton,cc.xy (10, 8));
		
		panel.validate();
		panel.repaint();

	}
	
	public JPanel getPanel()
	{
		return panel;
	}
    
    public void fireChanged()
    {
        name.setText(model.getIClass().getName());
        nbPerson.setText("" + model.getIClass().getNbPerson());
        nbGroup.setText(""+model.getIClass().getNbGroup());
        okButton.setEnabled(false);
        cancelButton.setEnabled(false);
    }


}
