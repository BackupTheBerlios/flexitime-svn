/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models.management.teacher;

import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.LocalDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.TeacherView;


/**
 * Represents a graphics view of a Teacher
 * @author GUERRIN Guillaume
 */
public class TeacherViewModel extends DataListenerImpl
{
    ITeacher teacher;
    TeacherView view;
    
    public TeacherViewModel(ITeacher teacher) throws RemoteException
    {
        this.teacher=teacher;
        LocalDataManager.getManager().addDataListener(ITeacher.class,this);
    }
    
    public void setValue(String[] values) throws RemoteException
    {
        if(values.length>=3)
        {
            teacher.setName(values[0]);
            teacher.setFirstName(values[1]);
            teacher.setEmail(values[2]);
            try
            {
                LocalDataManager.getManager().saveOrUpdateTeacher(teacher);
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
        ITeacher teacher = (ITeacher)event.getSource();
        int type = event.getEventType();
        switch(type)
        {
            case DataEvent.TYPE_PROPERTY_CHANGED :
            {
                if(this.teacher.equals(teacher))
                {
                    this.teacher = teacher;
                    view.fireChanged();
                }
                break;
            }
        }
        
    }
    /**
     * @return Returns the track.
     */
    public ITeacher getTeacher()
    {
        return teacher;
    }
    
    public void setTeacher(ITeacher teacher)
    {
        this.teacher=teacher;
        view.fireChanged();
    }

    /**
     * @param view The view to set.
     */
    public void setView(TeacherView view)
    {
        this.view = view;
    }
}
