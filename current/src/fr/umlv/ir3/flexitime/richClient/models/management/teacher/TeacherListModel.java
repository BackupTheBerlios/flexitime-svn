package fr.umlv.ir3.flexitime.richClient.models.management.teacher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

import javax.swing.AbstractListModel;
import javax.swing.table.AbstractTableModel;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;



/**
 * The class PeopleListModel is the model for the people list
 * @author AIME Séverine and GUERRIN Guillaume
 */
public class TeacherListModel extends AbstractListModel {

	/**
	 * The teacher list
	 */
	private List lstTeacher;
	
	/**
	 * The contructor by intialising
	 * @param factory the BuckFactory
	 * @param book the book
	 * @param people the people
	 */ 
	public TeacherListModel(List lstTeacher)
	{
		this.lstTeacher = lstTeacher;
	}
	
	/**
	 * To get the size of the people list
	 * @return the size of the people list
	 */
	public int getSize()
	{
		return lstTeacher.size();
	}

	/**
	 * To get the party specified by its index
	 * @param the index of the party searched
	 * @return the party searched
	 */
	public Object getElementAt(int index)
	{
		ITeacher teacher = (ITeacher)lstTeacher.get(index);
		return teacher.getName()+ " " + teacher.getFirstName();
	}

	/**
	 * To get the party specified by its index
	 * @param the index of the party searched
	 * @return the party searched
	 */
	public Object getPartyAt(int index)
	{
		return lstTeacher.get(index);
	}
	
	
	////////////////////////////////////////////////////////////
	
	/**
	 * To add a people to the people list
	 * @param str the name of the new people
	 */
	public void add()
	{	
		
		lstTeacher.add(DataFactory.createTeacher("Nouveau Professeur",""));
		this.fireIntervalAdded(this,lstTeacher.size()-1,lstTeacher.size());
	}

	/**
	 * To delete a party
	 * @param index the party to be deleted
	 */
	public void remove(int index)
	{
			lstTeacher.remove(index);
			this.fireIntervalRemoved(this,lstTeacher.size()-1,lstTeacher.size());
	}
	
	public void change(List values,int index)
	{
		if(values.size() >=3)
		{
			ITeacher teacher = (ITeacher)getPartyAt(index);
			teacher.setName((String)values.get(0));
			teacher.setFirstName((String)values.get(1));
			teacher.setEmail((String)values.get(2));
			fireContentsChanged(this,index,index);
			
		}
		
	}

}
