package fr.umlv.ir3.flexitime.richClient.models.management.teacher;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.models.management.device.TypeDeviceTreeNode;



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
	 * @throws RemoteException 
	 */ 
	public TeacherListModel(List lstTeacher) throws RemoteException
	{
		RemoteDataManager.getManager().addDataListener(ITeacher.class,new TeacherListener());
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
	 * @throws FlexiException 
	 */
	public void add() throws FlexiException
	{	
		
		lstTeacher.add(DataFactory.createTeacher("Nouveau Professeur",""));
		this.fireIntervalAdded(this,lstTeacher.size()-1,lstTeacher.size());
	}
    
    public void add(ITeacher teacher)
    {
        lstTeacher.add(teacher);
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
	
    /**
     * To delete a party
     * @param index the party to be deleted
     */
    public void remove(ITeacher teacher)
    {
            lstTeacher.remove(teacher);
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
    
    public class TeacherListener extends DataListenerImpl
    {       

        /**
         * @throws RemoteException
         */
        protected TeacherListener() throws RemoteException
        {
            super();
        }

        /**
         * Comment for <code>serialVersionUID</code>
         */
        private static final long serialVersionUID = 3256442508224444216L;

        /* (non-Javadoc)
         * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
         */
        public void dataChanged(DataEvent event) throws RemoteException
        {
            ITeacher teacher = (ITeacher)event.getSource();
            int type = event.getEventType();
            switch(type)
            {
                case DataEvent.TYPE_PROPERTY_ADDED:
                {
                    add(teacher);
                    break;
                }
                case DataEvent.TYPE_PROPERTY_CHANGED :
                {
                    int ind = lstTeacher.indexOf(teacher);
                    List list = new ArrayList();
                    list.add(teacher.getName());
                    list.add( teacher.getFirstName());
                    list.add( teacher.getEmail());
                    change(list,ind);
                    break;
                }
                case DataEvent.TYPE_PROPERTY_REMOVED:
                {
                     remove(teacher);
                    break;
                }
            }
            
        }
        
    }

}
