/*
 * Created on 23 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.gui.actions.management;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.BuildingView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.ClassView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.CourseView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.DevicesView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.FloorView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.GroupView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.SubjectView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.SubjectsGroupView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.TrackView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.RoomsView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.TeacherView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.TeachingStructureView;
import fr.umlv.ir3.flexitime.richClient.models.management.device.DeviceTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.device.DevicesViewModel;
import fr.umlv.ir3.flexitime.richClient.models.management.device.TypeDeviceTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.room.BuildingTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.room.BuildingViewModel;
import fr.umlv.ir3.flexitime.richClient.models.management.room.FloorTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.room.FloorViewModel;
import fr.umlv.ir3.flexitime.richClient.models.management.room.RoomTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.room.RoomViewModel;
import fr.umlv.ir3.flexitime.richClient.models.management.room.TypeRoomTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.teacher.TeacherListModel;
import fr.umlv.ir3.flexitime.richClient.models.management.teacher.TeacherViewModel;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.CourseTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.CourseViewModel;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.SubjectTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.SubjectViewModel;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.SubjectsGroupTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.SubjectsGroupViewModel;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.TeachingStructureTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.TypeCourseTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.ClassTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.ClassViewModel;
import fr.umlv.ir3.flexitime.richClient.models.management.track.GroupTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.GroupViewModel;
import fr.umlv.ir3.flexitime.richClient.models.management.track.TrackTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.TrackViewModel;

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
				 try 
                 {
                    JTree tmpTree = (JTree)arg0.getSource();
					if(tmpTree.getSelectionPath()!= null)
					{
						TreeNode tmpTreeNode = (TreeNode)tmpTree.getSelectionPath().getLastPathComponent();
						JPanel panel1 = new JPanel(new BorderLayout());
						if(tmpTreeNode instanceof TrackTreeNode)
						{										   
				            TrackViewModel model = new TrackViewModel(((TrackTreeNode)tmpTreeNode).getTrack());
				            TrackView trackView = new TrackView(model);
				            panel1.add(new JScrollPane(trackView.getPanel()), BorderLayout.CENTER);
				            panel1.setBorder(BorderFactory.createTitledBorder("Filière"));
                               	
						}
						else if(tmpTreeNode instanceof ClassTreeNode)
						{                     
                            ClassViewModel model = new ClassViewModel(((ClassTreeNode)tmpTreeNode).getIClass());
                            ClassView classView = new ClassView(model);
							panel1.add(new JScrollPane(classView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Promotion"));
							
						}
						else if(tmpTreeNode instanceof GroupTreeNode)
						{
							GroupViewModel model = new GroupViewModel(((GroupTreeNode)tmpTreeNode).getGroup());
                            GroupView groupView = new GroupView(model);
							panel1.add(new JScrollPane(groupView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Groupe"));
							
						}
						else if(tmpTreeNode instanceof TeachingStructureTreeNode)
						{
							TeachingStructureView teachingStructureView = new TeachingStructureView(tmpTree.getModel(),tmpTree);
							panel1.add(new JScrollPane(teachingStructureView.getPanel()), BorderLayout.CENTER);
                            panel1.setBorder(BorderFactory.createTitledBorder("Structure d'enseignement"));
						}
						//panelParent.remove(0);
                        ((JSplitPane)panelParent).setRightComponent(panel1);
                        //panelParent.add(panel1, BorderLayout.CENTER,0);
						panelParent.validate() ;
						panelParent.repaint();
					}
                 } 
                    catch (RemoteException e) 
                     {
                         JOptionPane.showMessageDialog(null,e.getMessage(),"Afficahge impossible",JOptionPane.ERROR_MESSAGE);
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
				 try 
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
							DevicesViewModel model = new DevicesViewModel(((DeviceTreeNode)tmpTreeNode).getDevice());
                            DevicesView deviceView = new DevicesView(model);
							panel1.add(new JScrollPane(deviceView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Matériel"));
							
						}
						//panelParent.remove(0);
                        ((JSplitPane)panelParent).setRightComponent(panel1);                      
						//panelParent.add(panel1, BorderLayout.CENTER,0);
                        panelParent.validate() ;
						panelParent.repaint();
					}

                 } 
                 catch (RemoteException e) 
                  {
                      JOptionPane.showMessageDialog(null,e.getMessage(),"Afficahge impossible",JOptionPane.ERROR_MESSAGE);
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
                try 
                {   	
                    JTree tmpTree = (JTree)arg0.getSource();
					if(tmpTree.getSelectionPath()!= null)
					{
						TreeNode tmpTreeNode = (TreeNode)tmpTree.getSelectionPath().getLastPathComponent();
						JPanel panel1 = new JPanel(new BorderLayout());
						if(tmpTreeNode instanceof BuildingTreeNode)
						{                           
                            BuildingViewModel model =null;
                            model = new BuildingViewModel(((BuildingTreeNode)tmpTreeNode).getBuilding());
                            BuildingView buildingView = new BuildingView(model);
                            panel1.add(new JScrollPane(buildingView.getPanel()), BorderLayout.CENTER);
                            panel1.setBorder(BorderFactory.createTitledBorder("Batiment"));
						}
						else if(tmpTreeNode instanceof FloorTreeNode)
						{
                            FloorViewModel model = new FloorViewModel(((FloorTreeNode)tmpTreeNode).getFloor());
                            FloorView floorView = new FloorView(model);
							panel1.add(new JScrollPane(floorView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Etage"));
							
						}
						else if(tmpTreeNode instanceof TypeRoomTreeNode)
						{
							//Pas de vue
							
						}
						else if(tmpTreeNode instanceof RoomTreeNode)
						{
							RoomViewModel model = new RoomViewModel(((RoomTreeNode)tmpTreeNode).getRoom());
                            RoomsView roomView = new RoomsView(model);
							panel1.add(new JScrollPane(roomView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Salle"));
							
						}
						//panelParent.remove(0);
						//panelParent.add(panel1, BorderLayout.CENTER,0);
						((JSplitPane)panelParent).setRightComponent(panel1);              
                        panelParent.validate() ;
						panelParent.repaint();
					}
                } 
                catch (RemoteException e) 
                {
                    JOptionPane.showMessageDialog(null,e.getMessage(),"Afficahge impossible",JOptionPane.ERROR_MESSAGE);
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
				 try 
				 {  
                    JList list  = (JList)arg0.getSource();	
    				TeacherViewModel model = new TeacherViewModel((ITeacher)((TeacherListModel)list.getModel()).getPartyAt(list.getSelectedIndex()));
    				TeacherView teacherView = new TeacherView(model);
    				JPanel panel1 = new JPanel(new BorderLayout());
    		        panel1.add(new JScrollPane(teacherView.getPanel()), BorderLayout.CENTER);
    		        panel1.setBorder(BorderFactory.createTitledBorder("Professeur"));
    		        panel1.setVisible( true);
    		        //panelParent.remove(0);
                    //panelParent.add(panel1, BorderLayout.CENTER,0);
                    ((JSplitPane)panelParent).setRightComponent(panel1);
                    panelParent.validate() ;
    		        panelParent.repaint();
                 }
				 catch (RemoteException e) 
				 {
				     JOptionPane.showMessageDialog(null,e.getMessage(),"Afficahge impossible",JOptionPane.ERROR_MESSAGE);
				 }
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
                try 
                {
                        JTree tmpTree = (JTree)arg0.getSource();
    					if(tmpTree.getSelectionPath()!= null)
    					{
    						TreeNode tmpTreeNode = (TreeNode)tmpTree.getSelectionPath().getLastPathComponent();
    						JPanel panel1 = new JPanel(new BorderLayout());
    						if(tmpTreeNode instanceof SubjectsGroupTreeNode)
    						{
                                SubjectsGroupViewModel model = new SubjectsGroupViewModel(((SubjectsGroupTreeNode)tmpTreeNode).getSubjectsGroup());
                                SubjectsGroupView subjectsGroupView = new SubjectsGroupView(model);
    							panel1.add(new JScrollPane(subjectsGroupView.getPanel()), BorderLayout.CENTER);
    							panel1.setBorder(BorderFactory.createTitledBorder("Bloc"));
    							
    						}
    						else if(tmpTreeNode instanceof SubjectTreeNode)
    						{
    							SubjectViewModel model = new SubjectViewModel(((SubjectTreeNode)tmpTreeNode).getSubject());
                                SubjectView subjectView = new SubjectView(model);
    							panel1.add(new JScrollPane(subjectView.getPanel()), BorderLayout.CENTER);
    							panel1.setBorder(BorderFactory.createTitledBorder("Matière"));
    							
    						}
    						else if(tmpTreeNode instanceof TypeCourseTreeNode)
    						{
    							//Pas de vue
    							
    						}
    						else if(tmpTreeNode instanceof CourseTreeNode)
    						{
    							CourseViewModel model = new CourseViewModel(((CourseTreeNode)tmpTreeNode).getCourse());
                                CourseView courseView = new CourseView(model);
    							panel1.add(new JScrollPane(courseView.getPanel()), BorderLayout.CENTER);
    							panel1.setBorder(BorderFactory.createTitledBorder("Cours"));
    							
    						}
                            //panel1.setMaximumSize(new Dimension(10,10));
                            //panelParent.remove(0);
    						//panelParent.add(panel1,JSplitPane.RIGHT,0);
                            //panelParent.add(panel1, BorderLayout.CENTER,0);
    						((JSplitPane)panelParent).setRightComponent(panel1);
                            panelParent.validate() ;
    						panelParent.repaint();
    					}
				    }
                    catch (RemoteException e) 
                    {
                        JOptionPane.showMessageDialog(null,e.getMessage(),"Afficahge impossible",JOptionPane.ERROR_MESSAGE);
                    }
			    }
	        	
	        };
	        return selectionListener;
	}
}
