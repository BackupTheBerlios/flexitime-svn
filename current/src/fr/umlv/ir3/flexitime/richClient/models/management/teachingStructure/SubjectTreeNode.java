/*
 * Created on 23 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;
import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;
import fr.umlv.ir3.flexitime.richClient.models.management.room.TypeRoomTreeNode;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SubjectTreeNode extends DataListenerImpl implements FlexiTreeNode 
	{
		//===========//
	    //   Champs  //
	    //===========// 
		/**
		* The model
		*/
		private ResourceTreeModel model;
		
		/**
		 * The parent
		 */
		private final FlexiTreeNode parent;
		
		/**
		 * The class
		 */
		private ISubject subject;

		/**
		 * The list of the sub categories
		 */
		private List children;
		 
		
		//==================//
	    //   Constructeurs  //
	    //==================// 
		
		public SubjectTreeNode(FlexiTreeNode parent,ISubject subject) throws RemoteException
		{
			this.parent = parent;
			this.subject = subject;
			children = new ArrayList();
            RemoteDataManager.getManager().addDataListener(ISubject.class,this);
		}
		
		/**
		 * Constructor by initialising
		 * @param parent the parent
		 * @param cat the category
		 * @param factory the BuckFactory
		 * @param model the model
		 * @throws RemoteException 
		 */
		public SubjectTreeNode(FlexiTreeNode parent,ISubject subject,DefaultTreeModel model) throws RemoteException
		{
			this(parent,subject);
			this.model= (ResourceTreeModel)model;
		}
		
		
		//	=============//
	    //   Méthodes  //
	    //=============//
		/* (non-Javadoc)
		 * @see javax.swing.tree.TreeNode#getChildAt(int)
		 */
		public FlexiTreeNode getChildAt(int childIndex) 
		{
			return (FlexiTreeNode)processChildren().get(childIndex);
		}

		/* (non-Javadoc)
		 * @see javax.swing.tree.TreeNode#getChildCount()
		 */
		public int getChildCount() {
			return processChildren().size();
		}

		/* (non-Javadoc)
		 * @see javax.swing.tree.TreeNode#getParent()
		 */
		public FlexiTreeNode getParent() {
			return parent;
		}

		/* (non-Javadoc)
		 * @see javax.swing.tree.TreeNode#getIndex(javax.swing.tree.TreeNode)
		 */
		public int getIndex(TreeNode node) {
			return processChildren().indexOf(node);
		}

		/* (non-Javadoc)
		 * @see javax.swing.tree.TreeNode#getAllowsChildren()
		 */
		public boolean getAllowsChildren() {
			// TODO Auto-generated method stub
			return true;
		}

		/* (non-Javadoc)
		 * @see javax.swing.tree.TreeNode#isLeaf()
		 */
		public boolean isLeaf() {
			if(subject.getLstCourse() == null) return true;
			else return false;
		}

		/* (non-Javadoc)
		 * @see javax.swing.tree.TreeNode#children()
		 */
		public Enumeration children() {
			return Collections.enumeration(processChildren());
		}
		
		/**
		 * Creates dynamiquely the list of the children when the user click on the "plus"
		 * @return the list of sub categories
		 */
		public List processChildren()
		{
			if(children.size()>0)return children;
			
			ArrayList list = new ArrayList(subject.getLstCourse().size());
			Iterator ite = subject.getLstCourse().iterator();
			HashMap map = new HashMap();
			for(;ite.hasNext();)
			{
				ICourse cour = (ICourse)ite.next();
				if(!map.containsKey(new Integer(cour.getType())))
				{
					ArrayList courseList = new ArrayList();
					courseList.add(cour);
					map.put(new Integer(cour.getType()),courseList);
				}
				else
				{
					((ArrayList)map.get(new Integer(cour.getType()))).add(cour);
				}
			}
			Iterator TypeCourseIte = map.keySet().iterator();	
			for(int i=0;i<ICourse.class.getFields().length;i++)
			{
				String name = new String();
				name += ICourse.class.getFields()[i].getName() ;
				List lstCourse;
				if(map.get(new Integer(i))!= null )lstCourse = (List)map.get(i);
				else lstCourse = new ArrayList();
				list.add(new TypeCourseTreeNode(this,name,i,lstCourse,model));
			}
			this.children =list;
			return(list);
		}
		
		public ISubject getSubject()
		{
			return(subject);	
		}
        
        public void setSubject(ISubject subject)
        {
            this.subject = subject;
            model.nodeChanged(this);
        }
		/**
		 * Redefinition of the method toString()
		 * @return the name into a string
		 */
		public String toString()
		{
			return subject.getName();
		}

		
		/* (non-Javadoc)
		 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
		 */
		public void add() {}

		/* (non-Javadoc)
		 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
		 */
		public void remove(TreeNode childNode) {}
		
        public void remove(ICourse course) throws RemoteException, FlexiException
        {
            RemoteDataManager.getManager().deleteCourse(course);   
        }
		/* (non-Javadoc)
		 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setValue(javax.swing.tree.TreePath, java.lang.Object)
		 */
		public void setValue(Object newValue) throws RemoteException 
        {
			subject.setName((String)newValue);
            RemoteDataManager.getManager().saveOrUpdateSubject(subject,subject.getParentSubjectsGroup());

			
		}

		/* (non-Javadoc)
		 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setModel(fr.umlv.ir3.flexitime.richClient.models.ResourceModel)
		 */
		public void setModel(DefaultTreeModel model) {
			this.model = (ResourceTreeModel)model;
			
		}

        /* (non-Javadoc)
         * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
         */
        public void dataChanged(DataEvent event) throws RemoteException
        {
            ISubject subject= (ISubject)event.getSource();
            if(this.subject.equals(subject))
            {
                int type = event.getEventType();
                switch(type)
                {
                    case DataEvent.TYPE_PROPERTY_SUBDATA_ADDED:
                    {
                        Object[] tabCourse= event.getSubObjects();
                        for(int i=0;i<tabCourse.length;i++)
                        {
                            subject.addCourse((ICourse)tabCourse[i]);
                            TypeCourseTreeNode tctn = searchChild(((ICourse)tabCourse[i]).getType());
                            tctn.add((ICourse)tabCourse[i]);
                        }
                        break;
                    }
                    case DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED:
                    {
                        Object[] tabCourse= event.getSubObjects();
                       for(int i=0;i<tabCourse.length;i++)
                       {
                           TypeCourseTreeNode tctn = searchChild(((ICourse)tabCourse[i]).getType());
                           tctn.changedCourse((ICourse)tabCourse[i]);
                            break;
                       }
                       break; 
                    }
                    case DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED:
                    {
                        Object[] tabCourse= event.getSubObjects();
                        for(int i=0;i<tabCourse.length;i++)
                        {
                            subject.removeCourse((ICourse)tabCourse[i]);
                            TypeCourseTreeNode tctn = searchChild(((ICourse)tabCourse[i]).getType());
                            tctn.remove((ICourse)tabCourse[i]);
                        }
                        break;   
                    }
                }  
            }
        }
        
        public TypeCourseTreeNode searchChild(int type)
        {
            Iterator ite = children.iterator() ;
            for(;ite.hasNext();)
            {
                TypeCourseTreeNode tctn= (TypeCourseTreeNode)ite.next();
                if(tctn.getType()==type)
                {
                    return tctn;
                }
            }
            return null;
        }
}
