/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;
import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;

/**
 * Represents a tree node for a course
 * @author GUERRIN Guillaume
 */
public class CourseTreeNode implements FlexiTreeNode 
{
		//===========//
	    //   Champs  //
	    //===========// 
		/**
		* The model
		*/
		private DefaultTreeModel model;
		
		/**
		 * The parent
		 */
		private final TreeNode parent;
		
		/**
		 * The course
		 */
		private ICourse course;

		/**
		 * The list of the sub categories
		 */
		private List children;
		 
		
		//==================//
	    //   Constructeurs  //
	    //==================// 
		
		public CourseTreeNode(TreeNode parent,ICourse course)
		{
			this.parent = parent;
			this.course = course;
			children = new ArrayList();
		}
		
		/**
		 * Constructor by initialising
		 * @param parent the parent
		 * @param cat the category
		 * @param factory the BuckFactory
		 * @param model the model
		 */
		public CourseTreeNode(TreeNode parent,ICourse course,DefaultTreeModel model)
		{
			this(parent,course);
			this.model=model;
		}
		
		
		//	=============//
	    //   Méthodes  //
	    //=============//
		/* (non-Javadoc)
		 * @see javax.swing.tree.TreeNode#getChildAt(int)
		 */
		public TreeNode getChildAt(int childIndex) {
			return null;
		}

		/* (non-Javadoc)
		 * @see javax.swing.tree.TreeNode#getChildCount()
		 */
		public int getChildCount() {
			return 0;
		}

		/* (non-Javadoc)
		 * @see javax.swing.tree.TreeNode#getParent()
		 */
		public TreeNode getParent() {
			return parent;
		}

		/* (non-Javadoc)
		 * @see javax.swing.tree.TreeNode#getIndex(javax.swing.tree.TreeNode)
		 */
		public int getIndex(TreeNode node) {
			return 0;
		}

		/* (non-Javadoc)
		 * @see javax.swing.tree.TreeNode#getAllowsChildren()
		 */
		public boolean getAllowsChildren() {
			return false;
		}

		/* (non-Javadoc)
		 * @see javax.swing.tree.TreeNode#isLeaf()
		 */
		public boolean isLeaf() {
			return true;
		}

		/* (non-Javadoc)
		 * @see javax.swing.tree.TreeNode#children()
		 */
		public Enumeration children() {
			return null;
		}
		public ICourse getCourse()
		{
			return course;
		}
		public void setCourse(ICourse course)
        {
            this.course = course;
            model.nodeChanged(this);
        }
		
        
		public String toString()
		{
			return course.getName();
		}

		/* (non-Javadoc)
		 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(java.lang.Object)
		 */
		public void add() {}
		
		/* (non-Javadoc)
		 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
		 */
		public void remove(TreeNode node) {
			//Non Utilisée
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setValue(javax.swing.tree.TreePath, java.lang.Object)
		 */
		public void setValue(Object newValue) throws RemoteException {
			course.setName((String)newValue);
            RemoteDataManager.getManager().saveOrUpdateCourse(course,course.getParentSubject());
			
		}

		/* (non-Javadoc)
		 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setModel(fr.umlv.ir3.flexitime.richClient.models.ResourceModel)
		 */
		public void setModel(DefaultTreeModel model) {
			this.model=model;
			
		}

}
