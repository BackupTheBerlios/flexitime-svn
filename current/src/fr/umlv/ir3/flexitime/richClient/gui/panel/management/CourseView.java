/*
 * Created on 22 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.gui.panel.management;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.tree.TreeModel;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;
import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;
import fr.umlv.ir3.flexitime.richClient.models.management.teacher.TeacherListModel;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.CourseViewModel;
import fr.umlv.ir3.flexitime.richClient.models.management.track.GroupTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.GroupViewModel;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CourseView
{

	JPanel panel;
	CourseViewModel model;
	JButton okButton;
	JButton cancelButton;
	JTextField name;
    JTextField nbHourTotal;
    JTextField time;
    JColorChooser coul;
    JButton buttonCoul;
    JButton buttonTeacher;
    JList prof;
    JList globalTeacherList;
    //JTextField globalTeacherList;
    JPopupMenu popMenu;
    JPopupMenu popMenu2;
	JLabel errorLabel;
    ListModel teacherList;
    private static FlexiLanguage language = FlexiLanguage.getInstance();
    
    public CourseView(CourseViewModel model,ListModel teacherList)
	{
	    this.model =model;
        this.teacherList = teacherList;
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
        popMenu = new JPopupMenu();
        popMenu2 = new JPopupMenu();
        coul = new JColorChooser(Color.BLUE);
       // if(model.getCourse().getColor()!=null)coul.setColor(model.getCourse().getColor());
        coul.setPreviewPanel(new JPanel());
        coul.setMaximumSize(new Dimension(410,100));
        coul.getSelectionModel().addChangeListener(new ChangeListener(){

            public void stateChanged(ChangeEvent arg0)
            {
                Color newColor = coul.getColor();
                buttonCoul.setBackground(newColor);
                
            }
            
        });
        try {
            prof = new JList(new TeacherListModel(model.getCourse().getLstTeacher()));
            prof.setMinimumSize(new Dimension(100,100));
            prof.setMaximumSize(new Dimension(250,250));
            globalTeacherList = new JList(teacherList);
            globalTeacherList.setMinimumSize(new Dimension(50,50));
            globalTeacherList.setMaximumSize(new Dimension(50,50));
 
            } catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        errorLabel = new JLabel();
		errorLabel.setForeground(Color.RED);
		errorLabel.setVisible(false);
		okButton = new JButton(language.getText("apply"));
		okButton.setEnabled(false);
		cancelButton=new JButton(language.getText("cancel"));
		cancelButton.setEnabled( false);
        buttonCoul= new JButton (language.getText("btColor"));
        buttonTeacher = new JButton(language.getText("btTeacher"));
        //if(model.getCourse().getColor()!=null)buttonCoul.setBackground(model.getCourse().getColor());
		name = new JTextField(model.getCourse().getName());
		nbHourTotal = new JTextField(""+model.getCourse().getNbHours());
        time = new JTextField(""+model.getCourse().getNbHours());
		
		//Creation d'un document listener
        DocumentListener documentListener = new DocumentListener(){

			public void insertUpdate(DocumentEvent arg0) {
                try{
                    Integer number = Integer.valueOf(nbHourTotal.getText()).intValue();   
                    Integer number2 = Integer.valueOf(time.getText()).intValue();
                okButton.setEnabled(true);
					cancelButton.setEnabled(true);
                }
                catch(NumberFormatException e){
                    if(nbHourTotal.getText().length()>9)errorLabel.setText("Valeur excessive");
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
        nbHourTotal.getDocument().addDocumentListener(documentListener);
        time.getDocument().addDocumentListener(documentListener);
		
        ////////////////////////////////////////
        //Mise en place des actions des boutons
        ////////////////////////////////////////
		
        //Bouton Appliquer
		okButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) 
			{
				//String[] values = new String[];
               // model.setValue();
				okButton.setEnabled(false);
				cancelButton.setEnabled(false);
			}	
		});
		
        //Bouton Annuler
        cancelButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				name.setText(model.getCourse().getName());
				//nbPerson.setText(""+((GroupTreeNode)tree.getSelectionPath().getLastPathComponent()).getGroup().getNbPerson());
				okButton.setEnabled(false);
				cancelButton.setEnabled(false);
			}
		
		});
		
        //Bouton de couleur
        buttonCoul.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent arg0)
            {
                popMenu.add(coul);
                popMenu.show(buttonCoul,buttonTeacher.getWidth(),buttonTeacher.getHeight());
                //JMenuItem menuItem;
                        
            }
            
        });
		
        //Bouton de la liste des profs
        buttonTeacher.addActionListener(new ActionListener()
                {

                    public void actionPerformed(ActionEvent arg0)
                    {
                        popMenu2.add(globalTeacherList);
                        popMenu2.show(buttonTeacher,buttonTeacher.getWidth(),buttonTeacher.getHeight());
                        
                    }
            
                });
       
        
        
        //////////////////////////////////////////
        // CREATION DU FORMULAIRE
        //////////////////////////////////////////
        FormLayout layout = new FormLayout("50px, pref, 10px, 50dlu,50px,50dlu,70px,pref","10px, pref, 20px, pref,20px,pref,20px,pref,20px,pref,40px,pref");
		//Collone 							 1		2	  3		4	  5	   6	7	 8	 9    10     1      2    3      4    5    6    7    8    9     10
		//layout.setRowGroups(new int[][]{{1, 3, 5}});
		panel.setLayout(layout);
		CellConstraints cc = new CellConstraints();
		panel.add(new JLabel(language.getText("formName")+":"), cc.xy (2, 2));
		panel.add(name, cc.xyw(4, 2, 2));
		panel.add(new JLabel(language.getText(language.getText("defaultCourseLength"))), cc.xyw (4, 4, 3));
		panel.add(nbHourTotal, cc.xy (6, 4));
		panel.add(new JLabel(language.getText("courseTime")+":"), cc.xyw (4, 6, 3));
		panel.add(time, cc.xy (6, 6));
		panel.add(new JLabel(language.getText("color")+":"),cc.xy (4, 8));
        panel.add(buttonCoul,cc.xy(6, 8));
        panel.add(new JLabel(language.getText("teacher"+":")),cc.xy (4, 10));
        panel.add(prof,cc.xy(6, 10));
        panel.add(buttonTeacher,cc.xy(7,10));
        panel.add(okButton, cc.xy (4, 12));
		panel.add(cancelButton,cc.xy (6, 12));
		
		panel.validate();
		panel.repaint();

	}
	
	/**
     * Returns the panel of a CourseView
     * @return
	 */
    public JPanel getPanel()
	{
		return panel;
	}
    
    /**
     * Is called when a element of the forms has changed
     *
     */
    public void fireChanged()
    {
        name.setText(model.getCourse().getName());
        nbHourTotal.setText("" + model.getCourse().getNbHours());
        buttonCoul.setBackground(model.getCourse().getColor());
        //prof.setText(""+model.getCourse().getLstTeacher());
        time.setText("" + model.getCourse().getDefaultLength());
    }


}
