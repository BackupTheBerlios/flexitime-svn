/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.panel.management;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.richClient.models.management.teacher.CourseTeacherListModel;
import fr.umlv.ir3.flexitime.richClient.models.management.teacher.TeacherListModel;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.CourseViewModel;

/**
 * CourseView
 * represents the view of a course
 * @author Guillaume GUERRIN
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
    JButton removeTeacher;
    JList prof;
    JList globalTeacherList;
    JScrollPane listViewTeacher;
    JPopupMenu popMenu;
    JPopupMenu popMenu2;
	JLabel errorLabel;
    ListModel teacherListModel;
    CourseTeacherListModel courseTeacherListModel;
    JPanel listTeacherPanel;
    JScrollPane listTeacherScroll;
    JButton addTeacher;
    private static FlexiLanguage language = FlexiLanguage.getInstance();
    
    public CourseView(CourseViewModel model,ListModel teacherList)
	{
	    this.model =model;
        this.teacherListModel = teacherList;
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
		nbHourTotal = new JTextField();
        time = new JTextField();
        popMenu = new JPopupMenu();
        popMenu2 = new JPopupMenu();
        coul = new JColorChooser(Color.BLUE);
        if(model.getCourse().getColor()!=null)coul.setColor(model.getCourse().getColor());
        coul.setPreviewPanel(new JPanel());
        //coul.setMaximumSize(new Dimension(410,100));
        coul.getSelectionModel().addChangeListener(new ChangeListener(){

            public void stateChanged(ChangeEvent arg0)
            {
                Color newColor = coul.getColor();
                buttonCoul.setBackground(newColor);
                if(!errorLabel.isVisible())
                {
                    okButton.setEnabled(true);
                    cancelButton.setEnabled(true);
                }
            }
            
        });
        try {
            courseTeacherListModel = new CourseTeacherListModel(model.getCourse().getLstTeacher(),model.getCourse());
            prof = new JList(courseTeacherListModel);
            listViewTeacher = new JScrollPane(prof);
            listViewTeacher.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            //prof.setMinimumSize(new Dimension(100,100));
            //prof.setMaximumSize(new Dimension(250,250));
            createListTeacherPanel();
            //globalTeacherList.setMinimumSize(new Dimension(50,50));
            //globalTeacherList.setMaximumSize(new Dimension(50,50));
 
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
        removeTeacher = new JButton(language.getText("remTeacher"));
        if(model.getCourse().getColor()!=null)buttonCoul.setBackground(model.getCourse().getColor());
		name = new JTextField(model.getCourse().getName());
		nbHourTotal = new JTextField(""+model.getCourse().getNbHours());
        time = new JTextField(""+model.getCourse().getDefaultLength());
		
		//Creation d'un key listener
        KeyListener keylName=new KeyListener() 
        {

            public void keyTyped(KeyEvent e){}
            public void keyPressed(KeyEvent e){}
            public void keyReleased(KeyEvent e)
            {
                 try{
                    Integer number = Integer.valueOf(nbHourTotal.getText()).intValue();   
                    Integer number2 = Integer.valueOf(time.getText()).intValue();
                    okButton.setEnabled(true);
                    cancelButton.setEnabled(true);
                    errorLabel.setVisible(false);
                }
                catch(NumberFormatException ex){
                    if(nbHourTotal.getText().length()>9)errorLabel.setText("Valeur excessive");
                    else errorLabel.setText("Valeur numérique uniquement");
                    errorLabel.setVisible(true);
                    okButton.setEnabled(false);
                    cancelButton.setEnabled(false);
                } 
            }
        };
     
		name.addKeyListener(keylName);
        nbHourTotal.addKeyListener(keylName);
        time.addKeyListener(keylName);
		
        ////////////////////////////////////////
        //Mise en place des actions des boutons
        ////////////////////////////////////////
		
        //Bouton Appliquer
		okButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) 
			{
				Object[] values = new Object[4];
                values[0]=name.getText();
                values[1]=nbHourTotal.getText();
                values[2]=time.getText();
                values[3]=coul.getColor();
			    try {
					model.setValue(values);
				} catch (RemoteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage(),"Modification impossible",JOptionPane.ERROR_MESSAGE);
				}
				okButton.setEnabled(false);
				cancelButton.setEnabled(false);
			}	
		});
		
        //Bouton Annuler
        cancelButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				name.setText(model.getCourse().getName());
                if(model.getCourse().getColor()!=null)coul.setColor(model.getCourse().getColor());
                else coul.setColor(Color.BLUE);
                nbHourTotal.setText("" + model.getCourse().getNbHours());
                time.setText("" + model.getCourse().getDefaultLength());
                //nbPerson.setText(""+((GroupTreeNode)tree.getSelectionPath().getLastPathComponent()).getGroup().getNbPerson());
				okButton.setEnabled(false);
				cancelButton.setEnabled(false);
                errorLabel.setVisible(false);
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
                        popMenu2.add(listTeacherPanel);
                        popMenu2.show(buttonTeacher,buttonTeacher.getWidth(),buttonTeacher.getHeight());
                        
                    }
            
                });
       
        //Bouton de suppression d'un prof
        removeTeacher.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                if(prof.getSelectedIndex()>=0)
                {
                   try 
                   {
                    courseTeacherListModel.remove((ITeacher)((CourseTeacherListModel)courseTeacherListModel).getPartyAt(prof.getSelectedIndex()));
                   } catch (RemoteException e) {
                    JOptionPane.showMessageDialog(null,e.getMessage(),"Suppression impossible",JOptionPane.ERROR_MESSAGE);
                   } 
                }
            }
            
        });
        
        //////////////////////////////////////////
        // CREATION DU FORMULAIRE
        //////////////////////////////////////////
        FormLayout layout = new FormLayout("20px, pref,20px, 20px,20dlu,30dlu,30dlu,10px,10dlu,10px,pref,40px","10px, pref, 20px, pref,20px,pref,20px,pref,20px,pref,40px,5px,40px,20dlu,20px,pref,10px,pref,50px");
		//Collone 							1		2	  3		4	 5	   6    7	 8	   9   10    11   12 |   1      2    3      4    5    6    7    8    9   10   11    12   13   14   15  16    17   18  19
		//layout.setRowGroups(new int[][]{{1, 3, 5}});
		panel.setLayout(layout);
		CellConstraints cc = new CellConstraints();
		panel.add(new JLabel(language.getText("formName")+" :"), cc.xy (2, 2));
		panel.add(name, cc.xyw(4, 2, 4));
		panel.add(new JLabel(language.getText("defaultCourseLength")+" :"), cc.xyw (3, 4, 5));
		panel.add(nbHourTotal, cc.xyw (9, 4,3));
		panel.add(new JLabel(language.getText("courseTime")+" :"), cc.xyw (3, 6, 5));
		panel.add(time, cc.xyw (9, 6,3));
		panel.add(new JLabel(language.getText("color")+":"),cc.xyw (3, 8,3));
        panel.add(buttonCoul,cc.xy(6, 8));
        panel.add(new JLabel(language.getText("teachers")+" :"),cc.xyw (3, 10, 3));
        panel.add(listViewTeacher,cc.xyw(6, 11,4));
        panel.add(buttonTeacher,cc.xy(11,11));
        panel.add(removeTeacher,cc.xy(11,13));
        panel.add(errorLabel,cc.xyw(2,16, 10));
        panel.add(okButton, cc.xyw (2, 18, 4));
		panel.add(cancelButton,cc.xyw (7, 18, 4));
		
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
        time.setText("" + model.getCourse().getDefaultLength());
        courseTeacherListModel.change(model.getCourse().getLstTeacher());
        okButton.setEnabled(false);
        cancelButton.setEnabled(false);
        errorLabel.setVisible(false);
    }

    private void createListTeacherPanel()
    {
        listTeacherPanel = new JPanel();
        listTeacherPanel.setBorder(BorderFactory.createTitledBorder("Listes des Professeurs"));
        globalTeacherList = new JList(teacherListModel);
        listTeacherScroll = new JScrollPane(globalTeacherList);
        listTeacherScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        addTeacher=new JButton("+");
        addTeacher.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent arg0)
            {
                if(globalTeacherList.getSelectedIndex()>=0)
                {
                   try 
                   {
					courseTeacherListModel.add((ITeacher)((TeacherListModel)teacherListModel).getPartyAt(globalTeacherList.getSelectedIndex()));
					popMenu2.setVisible(false);
                   } catch (RemoteException e) {
                    JOptionPane.showMessageDialog(null,e.getMessage(),"Ajout impossible",JOptionPane.ERROR_MESSAGE);
                   } catch (FlexiException e) {
                    JOptionPane.showMessageDialog(null,e.getMessage(),"Ajout impossible",JOptionPane.ERROR_MESSAGE);
                   }
                }
            }
            
        });
        FormLayout layout = new FormLayout("2px,100dlu,3px,30dlu,2px","2px,pref,pref,10px");
        listTeacherPanel.setLayout(layout);
        CellConstraints cc = new CellConstraints();
        listTeacherPanel.add(listTeacherScroll,cc.xy(2,2));
        listTeacherPanel.add(addTeacher,cc.xy(4,2));
    }


}
