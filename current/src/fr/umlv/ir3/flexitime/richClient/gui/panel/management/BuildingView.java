/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.panel.management;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.richClient.models.management.device.DevicesViewModel;
import fr.umlv.ir3.flexitime.richClient.models.management.room.BuildingViewModel;


/**
 * BuildingView
 * represents the view of a building
 * @author Guillaume GUERRIN
 */
public class BuildingView
{
    JPanel panel;
    BuildingViewModel model;
    JButton okButton;
    JButton cancelButton;
    JTextField name;
    private static FlexiLanguage language = FlexiLanguage.getInstance();
    public BuildingView(BuildingViewModel model)
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
        okButton = new JButton(language.getText("apply"));
        cancelButton=new JButton(language.getText("cancel"));
        okButton.setEnabled(false);
        cancelButton.setEnabled(false);
        name = new JTextField(model.getBuilding().getName());
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
                        JOptionPane.showMessageDialog(null,e.getMessage(),language.getText("errorChange"),JOptionPane.ERROR_MESSAGE);
                    }
                    
            }   
        });
        cancelButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent arg0) {
                name.setText(model.getBuilding().getName());
                okButton.setEnabled(false);
                cancelButton.setEnabled(false);
            }
        
        });
        
        FormLayout layout = new FormLayout("50px, pref, 10px, 100dlu,pref,pref,20px,pref,","70px, pref, 30px, pref");
        //Collone                            1      2     3     4       5   6   7     8     9  10   11
        //layout.setRowGroups(new int[][]{{1, 3, 5}});
        panel.setLayout(layout);
        CellConstraints cc = new CellConstraints();
        panel.add(new JLabel(language.getText("formName"+":")), cc.xy (2, 2));
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
        okButton.setEnabled(false);
        cancelButton.setEnabled(false);
    }
}
