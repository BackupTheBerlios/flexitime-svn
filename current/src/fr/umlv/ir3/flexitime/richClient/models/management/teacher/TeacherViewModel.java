/*
 * Created on 28 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.teacher;

import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.RoomsView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.TeacherView;


/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TeacherViewModel extends DataListenerImpl
{
    ITeacher teacher;
    TeacherView view;
    
    public TeacherViewModel(ITeacher teacher) throws RemoteException
    {
        this.teacher=teacher;
        RemoteDataManager.getManager().addDataListener(ITeacher.class,this);
    }
    
    public void setValue(String[] values) throws RemoteException
    {
        if(values.length>=3)
        {
            teacher.setName(values[0]);
            teacher.setFirstName(values[1]);
            teacher.setEmail(values[2]);
            RemoteDataManager.getManager().saveOrUpdateTeacher(teacher);
        }
        
    }

    /* (non-Javadoc)
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
     */
    public void dataChanged(DataEvent event) throws RemoteException
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

    /**
     * @param view The view to set.
     */
    public void setView(TeacherView view)
    {
        this.view = view;
    }
}
