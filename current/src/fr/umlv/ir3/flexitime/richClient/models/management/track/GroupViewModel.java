/*
 * Created on 28 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.track;

import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.GroupView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.RoomsView;


/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class GroupViewModel extends DataListenerImpl
{
    IGroup group ;
    GroupView view;
    
    public GroupViewModel(IGroup group) throws RemoteException
    {
        this.group=group;
        RemoteDataManager.getManager().addDataListener(IClass.class,this);
    }
    
    public void setValue(String[] values) throws RemoteException
    {
        if(values.length>0)
        {
            group.setName(values[0]);
            group.setNbPerson(Integer.valueOf(values[1]).intValue());
            RemoteDataManager.getManager().saveOrUpdateGroup(group,group.getParentClass());
        }
        
    }

    /* (non-Javadoc)
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
     */
    public void dataChanged(DataEvent event) throws RemoteException
    {
        IClass iClass = (IClass)event.getSource();
        int type = event.getEventType();
        switch(type)
        {
            case DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED :
            {
             Object[] tabGroup = event.getSubObjects();
             for(int i=0;i<tabGroup.length;i++)
             {
                 if(this.group.equals(tabGroup[i]))
                 {
                     this.group = (IGroup)tabGroup[i];
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
    public IGroup getGroup()
    {
        return group;
    }

    /**
     * @param view The view to set.
     */
    public void setView(GroupView view)
    {
        this.view = view;
    }

}
