/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models.management.room;

import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.LocalDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.RoomsView;


/**
 * Represents the model of the graphics view of a room
 * @author GUERRIN Guillaume
 */
public class RoomViewModel extends DataListenerImpl
{
    IRoom room ;
    RoomsView view;
    
    public RoomViewModel(IRoom room) throws RemoteException
    {
        this.room=room;
        LocalDataManager.getManager().addDataListener(IFloor.class,this);
    }
    
    public void setValue(String[] values) throws RemoteException
    {
        if(values.length>0)
        {
            room.setName(values[0]);
            room.setCapacity(Integer.valueOf(values[1]).intValue());
            try
            {
                LocalDataManager.getManager().saveOrUpdateRoom(room,room.getFloor());
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
        IFloor floor = (IFloor)event.getSource();
        int type = event.getEventType();
        switch(type)
        {
            case DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED :
            {
                 Object[] tabRoom = (Object[])event.getSubObjects();
             for(int i=0;i<tabRoom.length;i++)
             {
                 if(this.room.equals((IRoom)tabRoom[i]))
                 {
                     this.room = (IRoom)tabRoom[i];
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
    public IRoom getRoom()
    {
        return room;
    }

    /**
     * @param view The view to set.
     */
    public void setView(RoomsView view)
    {
        this.view = view;
    }
}
