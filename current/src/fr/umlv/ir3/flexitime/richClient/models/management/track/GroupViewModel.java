/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models.management.track;

import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.LocalDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.GroupView;


/**
 * Represents the model of the graphics view of a Group
 * @author GUERRIN Guillaume
 */
public class GroupViewModel extends DataListenerImpl
{
    IGroup group ;
    GroupView view;
    
    public GroupViewModel(IGroup group) throws RemoteException
    {
        this.group=group;
        LocalDataManager.getManager().addDataListener(IClass.class,this);
    }
    
    public void setValue(String[] values) throws RemoteException
    {
        if(values.length>0)
        {
            group.setName(values[0]);
            group.setNbPerson(Integer.valueOf(values[1]).intValue());
            try
            {
                LocalDataManager.getManager().saveOrUpdateGroup(group,group.getParentClass());
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
    
    public void setGroup(IGroup group)
    {
     this.group=group;   
     view.fireChanged();
    }

    /**
     * @param view The view to set.
     */
    public void setView(GroupView view)
    {
        this.view = view;
    }

}
