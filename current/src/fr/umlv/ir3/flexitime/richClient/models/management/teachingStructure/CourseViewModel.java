/*
 * Created on 30 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure;

import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.CourseView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.GroupView;


/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CourseViewModel extends DataListenerImpl
{
    ICourse course ;
    CourseView view;
    
    public CourseViewModel(ICourse course) throws RemoteException
    {
        this.course=course;
        RemoteDataManager.getManager().addDataListener(ISubject.class,this);
    }
    
    public void setValue(String[] values) throws RemoteException
    {
        if(values.length>0)
        {
            course.setName(values[0]);
            //course.setNbPerson(Integer.valueOf(values[1]).intValue());
            RemoteDataManager.getManager().saveOrUpdateCourse(course,course.getParentSubject());
        }
        
    }

    /* (non-Javadoc)
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
     */
    public void dataChanged(DataEvent event) throws RemoteException
    {
        ISubject subject = (ISubject)event.getSource();
        int type = event.getEventType();
        switch(type)
        {
            case DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED :
            {

                Object[] tabCourse = event.getSubObjects();
             for(int i=0;i<tabCourse.length;i++)
             {
                 if(this.course.equals(tabCourse[i]))
                 {
                     this.course = (ICourse)tabCourse[i];
                     view.fireChanged();
                 }
             }
             break;
            }
        }
        
    }
    /**
     * @return Returns the track.
     */
    public ICourse getCourse()
    {
        return course;
    }

    /**
     * @param view The view to set.
     */
    public void setView(CourseView view)
    {
        this.view = view;
    }
    
    

}
