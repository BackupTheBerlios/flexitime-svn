/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.actions.management;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.richClient.models.management.RootTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.device.DeviceTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.device.TypeDeviceTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.room.BuildingTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.room.FloorTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.room.RoomTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.room.TypeRoomTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.CourseTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.SubjectTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.SubjectsGroupTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.TeachingStructureTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.TypeCourseTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.ClassTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.GroupTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.TrackTreeNode;

/**
 * represents the différents mouseListener of the TreeNodes
 * @author Guillaume GUERRIN
 */
public class FlexiMouseListenerFactory 
{
	private static FlexiLanguage language = FlexiLanguage.getInstance();
    /**
	 * Creates a Mouse Listener for a tree of Track
	 * @param panelParent
	 * @return
	 */
	public static MouseListener createTrackMouseLister()
	    {
	    	MouseListener mouseLis = new MouseListener()
	        {
	    		public void mouseReleased(MouseEvent arg0) {
					if(arg0.isPopupTrigger())
					{
						JTree tmpTree = (JTree)arg0.getSource();
						JPopupMenu popMenu;
						String[] name=null;
						Action[] action=null;
						if(tmpTree.getSelectionPath()!= null)
						{
							TreeNode tmpTreeNode = (TreeNode)tmpTree.getSelectionPath().getLastPathComponent();
							
							if(tmpTreeNode instanceof TrackTreeNode)
							{
								name = new String[]{language.getText("addTrack"),language.getText("addClass"),language.getText("delResource")};
								action = new Action[]{DefaultTreeActions.add(tmpTree.getModel(),tmpTreeNode.getParent()) ,DefaultTreeActions.add(tmpTree.getModel(),tmpTreeNode) ,DefaultTreeActions.remove(tmpTree.getModel(),tmpTreeNode)};
							}
							else if(tmpTreeNode instanceof ClassTreeNode)
							{
								name = new String[]{language.getText("addGroup"),language.getText("delResource")};
								action = new Action[]{DefaultTreeActions.add(tmpTree.getModel(),tmpTreeNode) ,DefaultTreeActions.remove(tmpTree.getModel(),tmpTreeNode)};
							}
							else if(tmpTreeNode instanceof GroupTreeNode)
							{
								name = new String[]{language.getText("delResource")};
								action = new Action[]{DefaultTreeActions.remove(tmpTree.getModel(),tmpTreeNode)};
							}
							else if(tmpTreeNode instanceof TeachingStructureTreeNode)
							{
								return;
							}
						}
						else
						{
							name = new String[]{language.getText("addTrack")};
							action = new Action[]{DefaultTreeActions.add(tmpTree.getModel(),(RootTreeNode)tmpTree.getModel().getRoot())};
							
						}
						popMenu = createPopupMenu(name,action);
						popMenu.show(arg0.getComponent(),arg0.getX(),arg0.getY());
					}
					
				}
	    		
	    		public void mousePressed(MouseEvent arg0) {
	    			mouseReleased(arg0);
					
				}
				public void mouseEntered(MouseEvent arg0) {}
				public void mouseExited(MouseEvent arg0) {}
				public void mouseClicked(MouseEvent arg0){}
	        	
	        };
	        return mouseLis;
	    }
	    
	    
	/**
	 * Creates a Mouse Listener for a tree of Device
	 * @param panelParent
	 * @return
	 */
	public static MouseListener createDeviceMouseLister()
	    {
	    	MouseListener mouseLis = new MouseListener()
	        {
	    		public void mouseReleased(MouseEvent arg0) {
					if(arg0.isPopupTrigger())
					{
						JTree tmpTree = (JTree)arg0.getSource();
						JPopupMenu popMenu;
						String[] name=null;
						Action[] action=null;
						if(tmpTree.getSelectionPath()!= null)
						{
							TreeNode tmpTreeNode = (TreeNode)tmpTree.getSelectionPath().getLastPathComponent();
							if(tmpTreeNode instanceof TypeDeviceTreeNode)
							{
								name = new String[]{language.getText("addDevice")};
								action = new Action[]{DefaultTreeActions.add(tmpTree.getModel(),tmpTreeNode) };
								
							}
							else if(tmpTreeNode instanceof DeviceTreeNode)
							{
								name = new String[]{language.getText("Supprimer")};
								action = new Action[]{DefaultTreeActions.remove(tmpTree.getModel(),tmpTreeNode)};
							}
							popMenu = createPopupMenu(name,action);
							popMenu.show(arg0.getComponent(),arg0.getX(),arg0.getY());
						}
					}
					
				}
	    		
	    		public void mousePressed(MouseEvent arg0) {
	    			mouseReleased(arg0);
					
				}
				public void mouseEntered(MouseEvent arg0) {}
				public void mouseExited(MouseEvent arg0) {}
				public void mouseClicked(MouseEvent arg0){}
	        	
	        };
	        return mouseLis;
	    }
	    
	/**
	 * Creates a Mouse Listener for a tree of Room
	 * @param panelParent
	 * @return
	 */
	public static MouseListener createRoomMouseLister()
	    {
	    	MouseListener mouseLis = new MouseListener()
	        {
	    		public void mouseReleased(MouseEvent arg0) {
					if(arg0.isPopupTrigger())
					{
						JTree tmpTree = (JTree)arg0.getSource();
						JPopupMenu popMenu;
						String[] name=null;
						Action[] action=null;
						if(tmpTree.getSelectionPath()!= null)
						{
							TreeNode tmpTreeNode = (TreeNode)tmpTree.getSelectionPath().getLastPathComponent();
							if(tmpTreeNode instanceof BuildingTreeNode)
							{
								name = new String[]{language.getText("addBuilding"),language.getText("addFloor"),language.getText("delResource")};
								action = new Action[]{DefaultTreeActions.add(tmpTree.getModel(),tmpTreeNode.getParent()) ,DefaultTreeActions.add(tmpTree.getModel(),tmpTreeNode) ,DefaultTreeActions.remove(tmpTree.getModel(),tmpTreeNode)};
							}
							else if(tmpTreeNode instanceof FloorTreeNode)
							{
								name = new String[]{language.getText("delResource")};
								action = new Action[]{DefaultTreeActions.remove(tmpTree.getModel(),tmpTreeNode)};
							}
							else if(tmpTreeNode instanceof TypeRoomTreeNode)
							{
								name = new String[]{language.getText("addRoom")};
								action = new Action[]{DefaultTreeActions.add(tmpTree.getModel(),tmpTreeNode)};
							}
							else if(tmpTreeNode instanceof RoomTreeNode)
							{
								name = new String[]{language.getText("delResource")};
								action = new Action[]{DefaultTreeActions.remove(tmpTree.getModel(),tmpTreeNode)};
								//tmpTree.addSelectionRow(6) ;
								//System.out.println(tmpTree.getLeadSelectionRow());
								//System.out.println(tmpTree.getse );
								//tmpTree.setSelectionRow();
							}
				
						}
						else
						{
							name = new String[]{language.getText("addBuilding")};
							action = new Action[]{DefaultTreeActions.add(tmpTree.getModel(),(RootTreeNode)tmpTree.getModel().getRoot())};	
						}
						popMenu = createPopupMenu(name,action);
						popMenu.show(arg0.getComponent(),arg0.getX(),arg0.getY());
					}
					
				}
	    		
	    		public void mousePressed(MouseEvent arg0) {
	    			mouseReleased(arg0);
					
				}
				public void mouseEntered(MouseEvent arg0) {}
				public void mouseExited(MouseEvent arg0) {}
				public void mouseClicked(MouseEvent arg0){}
	        	
	        };
	        return mouseLis;
	    }
	
	/**
	 * Creates a MouseListener for a list of Teacher
	 * @param panelParent
	 * @return
	 */   
	public static MouseListener createTeacherMouseLister()   
	{
	 	MouseListener mouseLis = new MouseListener()
	        {
	    		public void mouseReleased(MouseEvent arg0) {
					if(arg0.isPopupTrigger())
					{
						JList tmpList = (JList)arg0.getSource();
						//System.out.println(tmpList.getCellRenderer().);
						JPopupMenu popMenu;
						String[] name =null;
						Action[] action=null;
						if(tmpList.getSelectedIndex() >= 0)
						{
								name = new String[]{language.getText("addTeacher"),language.getText("delResource")};
								action = new Action[]{TeacherActions.addTeacher(tmpList.getModel(),tmpList),TeacherActions.removeTeacher(tmpList.getModel(),tmpList)};
						}
						else
						{

							name = new String[]{language.getText("addTeacher")};
							action = new Action[]{TeacherActions.addTeacher(tmpList.getModel(),tmpList)};
						}
						popMenu = createPopupMenu(name,action);
						popMenu.show(arg0.getComponent(),arg0.getX(),arg0.getY());
					}
					
				}
	    		
	    		public void mousePressed(MouseEvent arg0) {
	    			mouseReleased(arg0);
					
				}
				public void mouseEntered(MouseEvent arg0) {}
				public void mouseExited(MouseEvent arg0) {}
				public void mouseClicked(MouseEvent arg0){}
	        	
	        };
	        return mouseLis;
	    } 
	/**
	 * Creates a MouseListener for a list of SubjectGroup
	 * @param panelParent
	 * @return
	 */    
	public static MouseListener createSubjectsGroupMouseLister(final JComponent parentPanel)
	{
		MouseListener mouseLis = new MouseListener()
        {
    		public void mouseReleased(MouseEvent arg0) {
				if(arg0.isPopupTrigger())
				{
					JTree tmpTree = (JTree)arg0.getSource();
					JPopupMenu popMenu;
					String[] name=null;
					Action[] action=null;
					if(tmpTree.getSelectionPath()!= null)
					{
						TreeNode tmpTreeNode = (TreeNode)tmpTree.getSelectionPath().getLastPathComponent();
						if(tmpTreeNode instanceof SubjectsGroupTreeNode)
						{
							name = new String[]{language.getText("addSubjectsGroup"),language.getText("addSubject"),language.getText("delResource")};
							action = new Action[]{DefaultTreeActions.add(tmpTree.getModel(),tmpTreeNode.getParent()) ,DefaultTreeActions.add(tmpTree.getModel(),tmpTreeNode) ,DefaultTreeActions.remove(tmpTree.getModel(),tmpTreeNode)};
						}
						else if(tmpTreeNode instanceof SubjectTreeNode)
						{
							name = new String[]{language.getText("delResource")};
							action = new Action[]{DefaultTreeActions.remove(tmpTree.getModel(),tmpTreeNode)};
						}
						else if(tmpTreeNode instanceof TypeCourseTreeNode)
						{
							name = new String[]{language.getText("addCourse")};
							action = new Action[]{DefaultTreeActions.add(tmpTree.getModel(),tmpTreeNode)};
						}
						else if(tmpTreeNode instanceof CourseTreeNode)
						{
							name = new String[]{language.getText("delResource")};
							action = new Action[]{DefaultTreeActions.remove(tmpTree.getModel(),tmpTreeNode)};
							//tmpTree.addSelectionRow(6) ;
							//System.out.println(tmpTree.getLeadSelectionRow());
							//System.out.println(tmpTree.getse );
							//tmpTree.setSelectionRow();
						}
			
					}
					else
					{
						name = new String[]{language.getText("addSubjectsGroup")};
						action = new Action[]{DefaultTreeActions.add(tmpTree.getModel(),(RootTreeNode)tmpTree.getModel().getRoot())};	
					}
					popMenu = createPopupMenu(name,action);
					popMenu.show(arg0.getComponent(),arg0.getX(),arg0.getY());
				}
			}
    		
    		public void mousePressed(MouseEvent arg0) {
    			mouseReleased(arg0);
				
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0){}
        	
        };
        return mouseLis;
	}
	  
	  /** Allows to create a JPopupMenu with the differents actions
	  * @param name
	  * @param action
	  * @return
	  */   
	public static JPopupMenu createPopupMenu(String[] name,Action[] action)
	{
		JPopupMenu popMenu = new JPopupMenu();
		JMenuItem menuItem;
		for (int i=0; i<name.length  ;i++)
		{
			menuItem = new JMenuItem();
				menuItem.setAction(action[i]);
				menuItem.setText(name[i]);
			popMenu.add(menuItem);
		}	
		//popMenu.setVisible(true);
		return popMenu;
	
	}
}
