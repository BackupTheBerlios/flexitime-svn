/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure;

import java.awt.Color;
import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.LocalDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.CourseView;


/**
 * Represents the model of the graphics view of a course
 * @author GUERRIN Guillaume
 */
public class CourseViewModel extends DataListenerImpl
{
    ICourse course ;
    CourseView view;
    
    public CourseViewModel(ICourse course) throws RemoteException
    {
        this.course=course;
        LocalDataManager.getManager().addDataListener(ISubject.class,this);
    }
    
    public void setValue(Object[] values) throws RemoteException
    {
        if(values.length>0)
        {
            course.setName((String)values[0]);
            course.setNbHours((Integer.parseInt((String)values[1])));
            course.setDefaultLength((Integer.parseInt((String)values[2])));
            course.setColor((Color)values[3]);
            try
            {
                LocalDataManager.getManager().saveOrUpdateCourse(course,course.getParentSubject());
            }
            catch (FlexiException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }

    /* (non-Javadoc)
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
     */
    public void dataChanged(DataEvent event)
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
