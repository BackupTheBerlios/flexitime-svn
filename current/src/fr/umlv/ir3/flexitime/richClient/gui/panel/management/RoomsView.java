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
import fr.umlv.ir3.flexitime.richClient.models.management.room.RoomViewModel;


/**
 * RoomsView
 * represents the view of a room
 * @author Guillaume GUERRIN
 */
public class RoomsView
{
	JPanel panel;
	RoomViewModel model;
	JButton okButton;
	JButton cancelButton;
	JTextField name;
	JTextField capacity;
	JLabel errorLabel;
	private static FlexiLanguage language = FlexiLanguage.getInstance();
    
    public RoomsView(RoomViewModel model)
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
		name = new JTextField(model.getRoom().getName());
		capacity = new JTextField(""+model.getRoom().getCapacity());
		/*KeyListener keylName=new KeyListener() 
        {

            public void keyTyped(KeyEvent e){}
            public void keyPressed(KeyEvent e){}
            public void keyReleased(KeyEvent e)
            {
                okButton.setEnabled(true);
                cancelButton.setEnabled(true);
            }
        };*/

        
        KeyListener keyl=new KeyListener() 
        {

            public void keyTyped(KeyEvent e){}
            public void keyPressed(KeyEvent e){}
            public void keyReleased(KeyEvent e)
            {
                try
                {
                    Integer number = Integer.valueOf(capacity.getText()).intValue();
                    
                    okButton.setEnabled(true);
                    cancelButton.setEnabled(true);
                    errorLabel.setVisible(false);
                }
                catch(NumberFormatException ex)
                {
                    if(capacity.getText().length()>9)errorLabel.setText("Valeur excessive");
                    else errorLabel.setText("Valeur numérique uniquement");
                    errorLabel.setVisible(true);
                    okButton.setEnabled(false);
                    cancelButton.setEnabled(false);
                }        
            }
        };
		//name.getDocument().addDocumentListener(keylName);
        name.addKeyListener(keyl); 
        capacity.addKeyListener(keyl);
		//Mise en place des actions des boutons
		okButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) 
			{
				try 
                {
                    String[] values = new String[2];
    				values[0] = name.getText();
    				values[1] =capacity.getText();
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
				name.setText(model.getRoom().getName());
				capacity.setText("" + model.getRoom().getCapacity());
				okButton.setEnabled(false);
				cancelButton.setEnabled(false);
			}
		
		});
		
		FormLayout layout = new FormLayout("50px, pref, 10px, 35dlu,50dlu,pref,20px,pref,","70px, pref, 20px, pref,20px,30px,pref");
		//Collone 							 1		2	  3		4		5	6	7	  8		9  10	11
		//layout.setRowGroups(new int[][]{{1, 3, 5}});
		panel.setLayout(layout);
		CellConstraints cc = new CellConstraints();
		panel.add(new JLabel("Nom :"), cc.xy (2, 2));
		panel.add(name, cc.xyw(4, 2, 2));
		panel.add(new JLabel("Capacité :"), cc.xy (2, 4));
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
    
    public void fireChanged()
    {
           name.setText(model.getRoom().getName());
           System.out.println("Avant capacité");
           String str = "" + model.getRoom().getCapacity();
           System.out.println("Après capacité");
           synchronized(capacity)
           {
               capacity.setText(str);
           }
           System.out.println("Après setText");
           errorLabel.setVisible(false);
           okButton.setEnabled(false);
           cancelButton.setEnabled(false);
    }

}