/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models.management.teacher;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.models.management.device.TypeDeviceTreeNode;



/**
 * Represents a the model for a List of Teachers in a course
 * @author GUERRIN Guillaume
 */
public class CourseTeacherListModel extends AbstractListModel {

	/**
	 * The teacher list
	 */
	private List lstTeacher;
    private ICourse courseL;
	
	/**
	 * The contructor by intialising
	 * @throws RemoteException 
	 */ 
	public CourseTeacherListModel(List lstTeacher,ICourse course) throws RemoteException
	{
		//RemoteDataManager.getManager().addDataListener(ISubject.class,new TeacherListener());
        this.lstTeacher = lstTeacher;
        this.courseL=course;
	}
	
	/**
	 * To get the size of the teacher list
	 * @return the size of the teacher list
	 */
	public int getSize()
	{
		return lstTeacher.size();
	}
    
    /**
     * To get the teacher list
     * @return the teacher list
     */
    public List getLstTeacher()
    {
        return lstTeacher;
    }
    
    public void setLstTeacher(List lstTeacher)
    {
        System.out.println("Modification de la liste des profs:");
        this.lstTeacher=lstTeacher;
        this.fireContentsChanged(this,0,lstTeacher.size());
        
    }

	/**
	 * To get the party specified by its index
	 * @param index index of the party searched
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
	 * @throws RemoteException 
	 */
	public void add(ITeacher teacher) throws FlexiException, RemoteException
	{	
	    if(!lstTeacher.contains(teacher))
        {
            System.out.println("Ajout d'un prof:");
            lstTeacher.add(teacher);
	        RemoteDataManager.getManager().saveOrUpdateCourse(this.courseL,this.courseL.getParentSubject());
        }
    }
    
   /* public void add(ITeacher teacher)
    {
        lstTeacher.add(teacher);
        this.fireIntervalAdded(this,lstTeacher.size()-1,lstTeacher.size());
    }*/

	/**
	 * To delete a party
	 * @param index the party to be deleted
	 * @throws FlexiException 
	 * @throws RemoteException 
	 */
	public void remove(int index) throws RemoteException, FlexiException
	{
		
	}
	
    /**
     * To delete a party
     * @param index the party to be deleted
     * @throws RemoteException 
     */
    public void remove(ITeacher teacher) throws RemoteException
    {
        System.out.println("suppression d'un prof:");
        lstTeacher.remove(teacher); 
        RemoteDataManager.getManager().saveOrUpdateCourse(courseL,courseL.getParentSubject());
    }
    
	public void change(List lstTeacher)
	{
        setLstTeacher(lstTeacher);
			
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
            ISubject subject = (ISubject)event.getSource();
            int type = event.getEventType();
            if(event.getPropertyName().equals("lstTeacher"))
            {
                switch(type)
                {
                    case DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED:
                    {
                        for(int i=0;i<event.getSubObjects().length;i++)
                        {
                            System.out.println("Modification de la liste des profs:");
                            if(((ICourse)event.getSubObjects()[i]).equals(courseL))
                            {
                                System.out.println("Modification de la liste des profs:");
                                setLstTeacher(((ICourse)event.getSubObjects()[i]).getLstTeacher());
                                System.out.println(((ICourse)event.getSubObjects()[i]).getLstTeacher());
                            }
                         }       
                        break;
                    }
                }
            }
        }
        
    }

}
