/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.richClient.models.management.FlexiTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;

/**
 * Represents a tree node for a type of course
 * @author GUERRIN Guillaume
 */
public class TypeCourseTreeNode implements FlexiTreeNode
{
//	===========//
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
	 * The list of device
	 */
	private List lstCourse;

	/**
	 * The name of the type
	 */
	private String name;
	/**
	 * The int of the type
	 */
	private int type;
	/**
	 * The list of the sub categories
	 */
	private List children;
	
	 
	
	//==================//
    //   Constructeurs  //
    //==================// 
	
	public TypeCourseTreeNode(TreeNode parent,String name,int type,List lstCourse)
	{
		this.parent = parent;
		this.name=name;
		this.type =type;
		this.lstCourse = lstCourse;
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 */
	public TypeCourseTreeNode(TreeNode parent,String name,int type,List lstCourse,DefaultTreeModel model)
	{
		this(parent,name,type,lstCourse);
		this.model=model;
		children = new ArrayList();
	}
	
	
	//	=============//
    //   Méthodes  //
    //=============//
	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getChildAt(int)
	 */
	public TreeNode getChildAt(int childIndex) {
		return (TreeNode)processChildren().get(childIndex);
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
	public TreeNode getParent() {
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
		if(lstCourse == null) return true;
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
		
		ArrayList list = new ArrayList(lstCourse.size());
		for(int i = 0;i<lstCourse.size();i++)
		{
			if(lstCourse.get(i)!=null)
            {
			    list.add(new CourseTreeNode(this,(ICourse)lstCourse.get(i),model));
            }
		}
		this.children =list;
		return(list);
	}
	
	public List getLstDevice()
	{
		return lstCourse;
	}
    
    public int getType()
    {
     return type;   
    }
	/**
	 * Redefinition of the method toString()
	 * @return the name into a string
	 */
	public String toString()
	{
		return name;
	}

	
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(java.lang.Object)
	 */
	public void add() throws FlexiException 
	{
	    ICourse course= DataFactory.createCourse("Nouveau Cours",((SubjectTreeNode)this.getParent()).getSubject(),type);
	}
	
    public void add(ICourse course)
    {
            lstCourse.add( course);
            CourseTreeNode child = new CourseTreeNode(this,course,model);
            if(children.size()==0)
            {
                processChildren();
            }
            else
            {
                children.add(child);
            }
            model.nodesWereInserted(this,new int[]{children.size()-1});
    }
	
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#add(java.lang.Object)
	 */
	public void change(List value) {
		//Non utilisée
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode)
	 */
	public void remove(TreeNode childNode) throws RemoteException, FlexiException {
		((SubjectTreeNode)this.getParent()).remove(((CourseTreeNode)childNode).getCourse());
		
	}
    
    public void remove(ICourse course) {
        CourseTreeNode childNode = searchChild(course);
        if(childNode != null)
        {
            lstCourse.remove(((CourseTreeNode)childNode).getCourse());
            int index = children.indexOf(childNode);
            children.remove(childNode);   
            model.nodesWereRemoved(this,new int[]{index},new Object[]{childNode});
        }
    }

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setValue(javax.swing.tree.TreePath, java.lang.Object)
	 */
	public void setValue(Object newValue) {
		//non utilisée
		
	}
    
    public void changedCourse(ICourse course)
    {
        CourseTreeNode childNode= searchChild(course);
        if(childNode!=null)childNode.setCourse(course);
    }

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#setModel(fr.umlv.ir3.flexitime.richClient.models.ResourceModel)
	 */
	public void setModel(DefaultTreeModel model) {
		this.model= (ResourceTreeModel)model;
		
	}
    
    public CourseTreeNode searchChild(ICourse course)
    {
        Iterator ite = children.iterator() ;
        for(;ite.hasNext();)
        {
            CourseTreeNode rtn= (CourseTreeNode)ite.next();
            if(rtn.getCourse().equals(course))
            {
                return rtn;
            }
        }
        return null;
    }

}
