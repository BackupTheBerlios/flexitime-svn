/*
 * Created on 13 d�c. 2004
 * by Adrien Bouvet
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.richClient.gui.panel.management;

import java.awt.Color;
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

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.common.tools.Validator;
import fr.umlv.ir3.flexitime.richClient.models.management.teacher.TeacherViewModel;

/**
 * subjectsGroupView
 * represents the view of a teacher
 * @author Guillaume GUERRIN
 */
public class TeacherView
{
	JPanel panel;
	TeacherViewModel model;
	JButton okButton;
	JButton cancelButton;
	JTextField name;
	JTextField firstName;
	JTextField email;
	JLabel errorLabel;
	private static FlexiLanguage language = FlexiLanguage.getInstance();
    
    public TeacherView(TeacherViewModel model)
	{
		this.model= model;
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
		name = new JTextField(model.getTeacher().getName());
		firstName = new JTextField(model.getTeacher().getFirstName());
		email = new JTextField(model.getTeacher().getEmail());
		
		//Definition des keylistener
//       Pour Nom et prenom
		KeyListener keyl=new KeyListener() 
        {

            public void keyTyped(KeyEvent e){}
            public void keyPressed(KeyEvent e){}
            public void keyReleased(KeyEvent e)
            {
//              Pour l'email
                if(Validator.validMail(email.getText()))
               {
                   okButton.setEnabled(true);
                   cancelButton.setEnabled(true);
                   errorLabel.setVisible(false);
               }
               else
               {
                   errorLabel.setText("Email non valide");
                   errorLabel.setVisible(true);
               }
            }
        };
		
		
		/*DocumentListener emailListener = new DocumentListener(){

			public void insertUpdate(DocumentEvent arg0) 
			{
				boolean flag =true;
				StringTokenizer str = new StringTokenizer(email.getText(),"@");
				if(str.countTokens()!= 2)
				{
					flag=false;
				}
				else
				{
					str.nextToken();
					String tmp = str.nextToken();
					if(tmp != "")
					{
						str = new StringTokenizer(tmp,".");
						if(str.countTokens()<2)
						{
							flag=false;
						}
					}
				}
				if(flag)
            	{
					
					okButton.setEnabled(true);
					cancelButton.setEnabled(true);
					errorLabel.setVisible(false);
            	}	
				
					
			}
			
			public void removeUpdate(DocumentEvent arg0) 
			{
				insertUpdate(arg0);
			}
			
			public void changedUpdate(DocumentEvent arg0) {}	
		};*/
		
		name.addKeyListener(keyl);
		firstName.addKeyListener(keyl);
		email.addKeyListener(keyl);
		//Mise en place des actions des boutons
		okButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) 
			{
				try 
                {
                    String[] values = new String[3];
    				values[0]= name.getText();
    		        values[1]= firstName.getText();
                    values[2]= email.getText();
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
				name.setText(model.getTeacher().getName());
				firstName.setText(model.getTeacher().getFirstName());
				email.setText(model.getTeacher().getEmail());
				okButton.setEnabled(false);
				cancelButton.setEnabled(false);
			}
		
		});
		
		FormLayout layout = new FormLayout("50px, pref, 10px, 50dlu,30px,pref,10px,50dlu","70px, pref, 20px, pref,20px,30px,pref");
		//Collone 							 1		2	  3		4		5	6	7	  8	
		//layout.setRowGroups(new int[][]{{1, 3, 5}});
		panel.setLayout(layout);
		CellConstraints cc = new CellConstraints();
		panel.add(new JLabel("Nom :"), cc.xy (2, 2));
		panel.add(name, cc.xy(4, 2));
		panel.add(new JLabel("Pr�nom :"), cc.xy(6, 2));
		panel.add(firstName, cc.xy (8, 2));
		panel.add(new JLabel("Email :"), cc.xy(2, 4));
		panel.add(email, cc.xyw (4, 4,3));
		panel.add(errorLabel,cc.xyw(4,5,4));
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
        name.setText(model.getTeacher().getName());
        firstName.setText(model.getTeacher().getFirstName());
        email.setText(model.getTeacher().getEmail());
        okButton.setEnabled(false);
        cancelButton.setEnabled(false);
        errorLabel.setVisible(false);
    }
}