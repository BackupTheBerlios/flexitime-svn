/*
 * Created on 23 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.gui.actions.management;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.richClient.gui.panel.management.ClassView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.CourseView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.GroupView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.NameView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.RoomsView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.TeacherView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.TeachingStructureView;
import fr.umlv.ir3.flexitime.richClient.models.management.device.DeviceTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.device.TypeDeviceTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.room.BuildingTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.room.FloorTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.room.RoomTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.room.TypeRoomTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.ClassTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.CourseTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.GroupTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.SubjectTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.SubjectsGroupTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.TeachingStructureTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.TrackTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.TypeCourseTreeNode;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FlexiSelectionListenerFactory 
{
	/**
	 * Creates a TreeSelectionListener for a tree of Track
	 * @param panelParent
	 * @return
	 */
	public static TreeSelectionListener createTrackTreeSelectionListener(final JComponent/*JPanel*/ panelParent)
	{
		TreeSelectionListener selectionListener = new TreeSelectionListener()
		{
			public void valueChanged(TreeSelectionEvent arg0) 
			{
					JTree tmpTree = (JTree)arg0.getSource();
					if(tmpTree.getSelectionPath()!= null)
					{
						TreeNode tmpTreeNode = (TreeNode)tmpTree.getSelectionPath().getLastPathComponent();
						JPanel panel1 = new JPanel(new BorderLayout());
						if(tmpTreeNode instanceof TrackTreeNode)
						{
							NameView trackView = new NameView(tmpTree.getModel(),tmpTree);
							panel1.add(new JScrollPane(trackView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Filière"));
							
						}
						else if(tmpTreeNode instanceof ClassTreeNode)
						{
							ClassView classView = new ClassView(tmpTree.getModel(),tmpTree);
							panel1.add(new JScrollPane(classView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Promotion"));
							
						}
						else if(tmpTreeNode instanceof GroupTreeNode)
						{
							GroupView groupView = new GroupView(tmpTree.getModel(),tmpTree);
							panel1.add(new JScrollPane(groupView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Groupe"));
							
						}
						else if(tmpTreeNode instanceof TeachingStructureTreeNode)
						{
							TeachingStructureView teachingStructureView = new TeachingStructureView(tmpTree.getModel(),tmpTree);
							panel1.add(new JScrollPane(teachingStructureView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Structure d'enseignement"));
						}
						panelParent.remove(0);
                        //((JSplitPane)panelParent).setRightComponent(panel1);
                        panelParent.add(panel1, BorderLayout.CENTER,0);
						panelParent.validate() ;
						panelParent.repaint();
					}
				}
	        	
	        };
	        return selectionListener;
	}
	    
	/**
	 * Creates a TreeSelectionListener for a tree of Device
	 * @param panelParent
	 * @return
	 */
	public static TreeSelectionListener createDeviceTreeSelectionListener(final JComponent/*JPanel*/ panelParent)
	{
		TreeSelectionListener selectionListener = new TreeSelectionListener()
		{
			public void valueChanged(TreeSelectionEvent arg0) 
			{
					JTree tmpTree = (JTree)arg0.getSource();
					if(tmpTree.getSelectionPath()!= null)
					{
						TreeNode tmpTreeNode = (TreeNode)tmpTree.getSelectionPath().getLastPathComponent();
						JPanel panel1 = new JPanel(new BorderLayout());
						if(tmpTreeNode instanceof TypeDeviceTreeNode)
						{
							//Pas de vue
							/*NameView deviceView = new NameView(tmpTree.getModel(),tmpTree);
							panel1.add(new JScrollPane(deviceView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Type de Matériel"));*/
							
						}
						else if(tmpTreeNode instanceof DeviceTreeNode)
						{
							NameView deviceView = new NameView(tmpTree.getModel(),tmpTree);
							panel1.add(new JScrollPane(deviceView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Matériel"));
							
						}
						panelParent.remove(0);
                        //((JSplitPane)panelParent).setRightComponent(panel1);                      
						panelParent.add(panel1, BorderLayout.CENTER,0);
                        panelParent.validate() ;
						panelParent.repaint();
					}
				}
	        	
	        };
	        return selectionListener;
	}

	
	/**
	 * Creates a TreeSelectionListener for a tree of Room
	 * @param panelParent
	 * @return
	 */
	public static TreeSelectionListener createRoomTreeSelectionListener(final JComponent/*JPanel*/ panelParent)    
	{
		TreeSelectionListener selectionListener = new TreeSelectionListener()
		{
			public void valueChanged(TreeSelectionEvent arg0) 
			{
					JTree tmpTree = (JTree)arg0.getSource();
					if(tmpTree.getSelectionPath()!= null)
					{
						TreeNode tmpTreeNode = (TreeNode)tmpTree.getSelectionPath().getLastPathComponent();
						JPanel panel1 = new JPanel(new BorderLayout());
						if(tmpTreeNode instanceof BuildingTreeNode)
						{
							NameView buildingView = new NameView(tmpTree.getModel(),tmpTree);
							panel1.add(new JScrollPane(buildingView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Batiment"));
							
						}
						else if(tmpTreeNode instanceof FloorTreeNode)
						{
							NameView floorView = new NameView(tmpTree.getModel(),tmpTree);
							panel1.add(new JScrollPane(floorView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Etage"));
							
						}
						else if(tmpTreeNode instanceof TypeRoomTreeNode)
						{
							//Pas de vue
							
						}
						else if(tmpTreeNode instanceof RoomTreeNode)
						{
							RoomsView roomView = new RoomsView(tmpTree.getModel(),tmpTree);
							panel1.add(new JScrollPane(roomView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Salle"));
							
						}
						panelParent.remove(0);
						panelParent.add(panel1, BorderLayout.CENTER,0);
						//((JSplitPane)panelParent).setRightComponent(panel1);              
                        panelParent.validate() ;
						panelParent.repaint();
					}
				}
	        	
	        };
	        return selectionListener;
	}
	  
	/**
	 * Creates a List SelectionListener for a list of Teacher
	 * @param panelParent
	 * @return
	 */
	public static ListSelectionListener createTeacherListSelectionListener(final JComponent/*JPanel*/ panelParent)    
	{
		ListSelectionListener selectionListener = new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent arg0) 
			{
				JList list  = (JList)arg0.getSource();	
				
				TeacherView teacherView = new TeacherView(list.getModel(),list);
				JPanel panel1 = new JPanel(new BorderLayout());
		        panel1.add(new JScrollPane(teacherView.getPanel()), BorderLayout.CENTER);
		        panel1.setBorder(BorderFactory.createTitledBorder("Professeur"));
		        panel1.setVisible( true);
		        panelParent.remove(0);
                panelParent.add(panel1, BorderLayout.CENTER,0);
                //((JSplitPane)panelParent).setRightComponent(panel1);
                panelParent.validate() ;
		        panelParent.repaint();
			}
	        	
		};
	    return selectionListener;
	}
	
	/**
	 * Creates a TreeSelectionListener for a tree of SubjectsGroup
	 * @param panelParent
	 * @return
	 */
	public static TreeSelectionListener createSubjectsGroupTreeSelectionListener(final JComponent/*JPanel*/ panelParent)
	{
		TreeSelectionListener selectionListener = new TreeSelectionListener()
		{
			public void valueChanged(TreeSelectionEvent arg0) 
			{
					JTree tmpTree = (JTree)arg0.getSource();
					if(tmpTree.getSelectionPath()!= null)
					{
						TreeNode tmpTreeNode = (TreeNode)tmpTree.getSelectionPath().getLastPathComponent();
						JPanel panel1 = new JPanel(new BorderLayout());
						if(tmpTreeNode instanceof SubjectsGroupTreeNode)
						{
							NameView subjectsGroupView = new NameView(tmpTree.getModel(),tmpTree);
							panel1.add(new JScrollPane(subjectsGroupView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Bloc"));
							
						}
						else if(tmpTreeNode instanceof SubjectTreeNode)
						{
							NameView subjectView = new NameView(tmpTree.getModel(),tmpTree);
							panel1.add(new JScrollPane(subjectView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Matière"));
							
						}
						else if(tmpTreeNode instanceof TypeCourseTreeNode)
						{
							//Pas de vue
							
						}
						else if(tmpTreeNode instanceof CourseTreeNode)
						{
							CourseView courseView = new CourseView(tmpTree.getModel(),tmpTree);
							panel1.add(new JScrollPane(courseView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Cours"));
							
						}
                        panel1.setMaximumSize(new Dimension(10,10));
                        panelParent.remove(0);
						//panelParent.add(panel1,JSplitPane.RIGHT,0);
                        panelParent.add(panel1, BorderLayout.CENTER,0);
						//((JSplitPane)panelParent).setRightComponent(panel1);
                        panelParent.validate() ;
						panelParent.repaint();
					}
				}
	        	
	        };
	        return selectionListener;
	}
}
