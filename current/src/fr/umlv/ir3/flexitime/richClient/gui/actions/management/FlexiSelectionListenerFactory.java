/*
 * Created on 23 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.gui.actions.management;

import java.awt.BorderLayout;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.BuildingView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.ClassView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.CourseView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.DevicesView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.FloorView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.GroupView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.RoomsView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.SubjectView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.SubjectsGroupView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.TeacherView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.TeachingStructureView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.TrackView;
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
 * represents diff�rents Listeners that I must to inform
 * @author Guillaume GUERRIN
 */
public class FlexiSelectionListenerFactory 
{
	private static FlexiLanguage language = FlexiLanguage.getInstance();
    /**
	 * Creates a TreeSelectionListener for a tree of Track
	 * @param panelParent
	 * @return
	 */
	public static TreeSelectionListener createTrackTreeSelectionListener(final JComponent panelParent,final ListModel teacherList)
	{
       
        TreeSelectionListener selectionListener = new TreeSelectionListener()
		{
             
             TrackViewModel modelTrack = null;
             TrackView trackView =null;
             ClassViewModel modelClass = null;
             ClassView classView =null;
             GroupViewModel modelGroup =null; 
             GroupView groupView=null;
             TeachingStructureView teachingStructureView=null;
            public void valueChanged(TreeSelectionEvent arg0) 
			{
                
                try 
                 {
                    JPanel panel1 = new JPanel(new BorderLayout());
                    JTree tmpTree = (JTree)arg0.getSource();
					if(tmpTree.getSelectionPath()!= null)
					{
						TreeNode tmpTreeNode = (TreeNode)tmpTree.getSelectionPath().getLastPathComponent();

						if(tmpTreeNode instanceof TrackTreeNode)
						{										   
				            if(modelTrack==null)
                            {
				                modelTrack = new TrackViewModel(((TrackTreeNode)tmpTreeNode).getTrack());
				                trackView = new TrackView(modelTrack);
                            }
                            else
                            {
                                modelTrack.setTrack(((TrackTreeNode)tmpTreeNode).getTrack());
                            }
                            panel1.add(new JScrollPane(trackView.getPanel()), BorderLayout.CENTER);
                            panel1.setBorder(BorderFactory.createTitledBorder(language.getText("track")));
						}
						else if(tmpTreeNode instanceof ClassTreeNode)
						{                     
                            if(modelClass == null)
                            {
                                modelClass = new ClassViewModel(((ClassTreeNode)tmpTreeNode).getIClass());
                                classView = new ClassView(modelClass);
    							
                            }
                            else
                            {
                                modelClass.setIClass(((ClassTreeNode)tmpTreeNode).getIClass());
                            }
                            panel1.add(new JScrollPane(classView.getPanel()), BorderLayout.CENTER);
                            panel1.setBorder(BorderFactory.createTitledBorder(language.getText("class")));
						}
						else if(tmpTreeNode instanceof GroupTreeNode)
						{
							if(modelGroup ==null)
                            {
                                modelGroup = new GroupViewModel(((GroupTreeNode)tmpTreeNode).getGroup());
                                groupView = new GroupView(modelGroup);
    							
                            }
                            else
                            {
                                modelGroup.setGroup(((GroupTreeNode)tmpTreeNode).getGroup());
                            }
                            panel1.add(new JScrollPane(groupView.getPanel()), BorderLayout.CENTER);
                            panel1.setBorder(BorderFactory.createTitledBorder(language.getText("group")));
						}
						else if(tmpTreeNode instanceof TeachingStructureTreeNode)
						{
							if(teachingStructureView==null) 
                            {
                                teachingStructureView = new TeachingStructureView(tmpTree.getModel(),tmpTree,teacherList);
                                
                            }
                            else
                            {
                                teachingStructureView.setTeachingStructure(((TeachingStructureTreeNode)tmpTreeNode).getTeachingStructure());
                            }
                            panel1.add(new JScrollPane(teachingStructureView.getPanel()), BorderLayout.CENTER);
                            panel1.setBorder(BorderFactory.createTitledBorder(language.getText("teachingStructure")));
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
                         JOptionPane.showMessageDialog(null,e.getMessage(),language.getText("errorDisplay"),JOptionPane.ERROR_MESSAGE);
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
            DevicesViewModel model=null;
            DevicesView deviceView=null;
            JPanel panel1 = new JPanel(new BorderLayout());
            public void valueChanged(TreeSelectionEvent arg0) 
			{
				 try 
                 {	
				     JTree tmpTree = (JTree)arg0.getSource();
					if(tmpTree.getSelectionPath()!= null)
					{
						TreeNode tmpTreeNode = (TreeNode)tmpTree.getSelectionPath().getLastPathComponent();
						//JPanel panel1 = new JPanel(new BorderLayout());
						if(tmpTreeNode instanceof TypeDeviceTreeNode)
						{
							//Pas de vue
							/*NameView deviceView = new NameView(tmpTree.getModel(),tmpTree);
							panel1.add(new JScrollPane(deviceView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder("Type de Mat�riel"));*/
							
						}
						else if(tmpTreeNode instanceof DeviceTreeNode)
						{
							if(model == null)
                            {   
							     model = new DevicesViewModel(((DeviceTreeNode)tmpTreeNode).getDevice());
							     deviceView = new DevicesView(model);
                                 panel1.add(new JScrollPane(deviceView.getPanel()), BorderLayout.CENTER);
                                 panel1.setBorder(BorderFactory.createTitledBorder(language.getText("device")));
                            }
                            else
                            {
                                model.setDevice(((DeviceTreeNode)tmpTreeNode).getDevice());
                            }			
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
                      JOptionPane.showMessageDialog(null,e.getMessage(),language.getText("errorDevice"),JOptionPane.ERROR_MESSAGE);
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
			BuildingViewModel modelBuilding =null;
            BuildingView buildingView = null;
            FloorViewModel modelFloor = null;
            FloorView floorView =null;
            RoomViewModel modelRoom =null;
            RoomsView roomView=null;
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
                            if(modelBuilding==null)
                            {
                                modelBuilding = new BuildingViewModel(((BuildingTreeNode)tmpTreeNode).getBuilding());
                                buildingView = new BuildingView(modelBuilding);
                            }
                            else
                            {
                                modelBuilding.setBuilding(((BuildingTreeNode)tmpTreeNode).getBuilding());
                            }
                            panel1.add(new JScrollPane(buildingView.getPanel()), BorderLayout.CENTER);
                            panel1.setBorder(BorderFactory.createTitledBorder(language.getText("building")));
						}
						else if(tmpTreeNode instanceof FloorTreeNode)
						{
                            if(modelFloor==null)
                            {
                                modelFloor = new FloorViewModel(((FloorTreeNode)tmpTreeNode).getFloor());
                                floorView = new FloorView(modelFloor);
                            }
                            else
                            {
                                modelFloor.setFloor(((FloorTreeNode)tmpTreeNode).getFloor());
                            }
							panel1.add(new JScrollPane(floorView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder(language.getText("floor")));
							
						}
						else if(tmpTreeNode instanceof TypeRoomTreeNode)
						{
							//Pas de vue
							
						}
						else if(tmpTreeNode instanceof RoomTreeNode)
						{
							if(modelRoom==null)
                            {
							    modelRoom = new RoomViewModel(((RoomTreeNode)tmpTreeNode).getRoom());
							    roomView = new RoomsView(modelRoom);
                            }
                            else
                            {
                                modelRoom.setRoom(((RoomTreeNode)tmpTreeNode).getRoom());
                            }
							panel1.add(new JScrollPane(roomView.getPanel()), BorderLayout.CENTER);
							panel1.setBorder(BorderFactory.createTitledBorder(language.getText("room")));
							
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
                    JOptionPane.showMessageDialog(null,e.getMessage(),language.getText("errorDisplay"),JOptionPane.ERROR_MESSAGE);
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
			TeacherViewModel modelTeacher =null;
            TeacherView teacherView=null;
            public void valueChanged(ListSelectionEvent arg0) 
			{
				 try 
				 {  
                    JList list  = (JList)arg0.getSource();	
    				if(modelTeacher==null)
                    {
                         modelTeacher = new TeacherViewModel((ITeacher)((TeacherListModel)list.getModel()).getPartyAt(list.getSelectedIndex()));
                         teacherView = new TeacherView(modelTeacher);
                    }
                    else
                    {
                        modelTeacher.setTeacher((ITeacher)((TeacherListModel)list.getModel()).getPartyAt(list.getSelectedIndex()));
                    }
                        
                   
    				JPanel panel1 = new JPanel(new BorderLayout());
    		        panel1.add(new JScrollPane(teacherView.getPanel()), BorderLayout.CENTER);
    		        panel1.setBorder(BorderFactory.createTitledBorder(language.getText("teacher")));
    		        panel1.setVisible( true);
    		        //panelParent.remove(0);
                    //panelParent.add(panel1, BorderLayout.CENTER,0);
                    ((JSplitPane)panelParent).setRightComponent(panel1);
                    panelParent.validate() ;
    		        panelParent.repaint();
                 }
				 catch (RemoteException e) 
				 {
				     JOptionPane.showMessageDialog(null,e.getMessage(),language.getText("errorDisplay"),JOptionPane.ERROR_MESSAGE);
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
	public static TreeSelectionListener createSubjectsGroupTreeSelectionListener(final JComponent panelParent,final ListModel teacherList)
	{
		TreeSelectionListener selectionListener = new TreeSelectionListener()
		{
			SubjectsGroupViewModel modelSubjectsGroup =null;
            SubjectsGroupView subjectsGroupView =null;
            SubjectViewModel modelSubject=null;
            SubjectView subjectView =null;
            CourseViewModel modelCourse =null;
            CourseView courseView =null;
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
                                if(modelSubjectsGroup==null)                                    
                                {
                                    modelSubjectsGroup = new SubjectsGroupViewModel(((SubjectsGroupTreeNode)tmpTreeNode).getSubjectsGroup());
                                    subjectsGroupView = new SubjectsGroupView(modelSubjectsGroup);
                                }
                                else
                                {
                                    modelSubjectsGroup.setSubjectsGroup(((SubjectsGroupTreeNode)tmpTreeNode).getSubjectsGroup());  
                                }
                                panel1.add(new JScrollPane(subjectsGroupView.getPanel()), BorderLayout.CENTER);
    							panel1.setBorder(BorderFactory.createTitledBorder(language.getText("subjectsGroup")));
    							
    						}
    						else if(tmpTreeNode instanceof SubjectTreeNode)
    						{
    							if(modelSubject==null)
                                {
    							    modelSubject = new SubjectViewModel(((SubjectTreeNode)tmpTreeNode).getSubject());
    							    subjectView = new SubjectView(modelSubject);
                                }
                                else
                                {
                                    modelSubject.setSubject(((SubjectTreeNode)tmpTreeNode).getSubject());
                                }
                                panel1.add(new JScrollPane(subjectView.getPanel()), BorderLayout.CENTER);
    							panel1.setBorder(BorderFactory.createTitledBorder(language.getText("subject")));
    							
    						}
    						else if(tmpTreeNode instanceof TypeCourseTreeNode)
    						{
    							//Pas de vue
    							
    						}
    						else if(tmpTreeNode instanceof CourseTreeNode)
    						{
    							if(modelCourse==null)
                                {
    							    modelCourse = new CourseViewModel(((CourseTreeNode)tmpTreeNode).getCourse());
    							    courseView = new CourseView(modelCourse,teacherList);
                                }
                                else
                                {
                                    modelCourse.setCourse(((CourseTreeNode)tmpTreeNode).getCourse());
                                }
                                panel1.add(new JScrollPane(courseView.getPanel()), BorderLayout.CENTER);
    							panel1.setBorder(BorderFactory.createTitledBorder(language.getText("course")));
    							
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
                        JOptionPane.showMessageDialog(null,e.getMessage(),language.getText("errorDisplay"),JOptionPane.ERROR_MESSAGE);
                    }
			    }
	        	
	        };
	        return selectionListener;
	}
}
