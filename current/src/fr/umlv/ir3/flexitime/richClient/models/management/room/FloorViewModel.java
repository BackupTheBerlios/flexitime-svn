/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models.management.room;

import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.LocalDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.BuildingView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.FloorView;


/**
 * Represents the model of the graphics view of a floor
 * @author GUERRIN Guillaume
 */
public class FloorViewModel extends DataListenerImpl
{
    IFloor floor ;
    FloorView view;
       
       public FloorViewModel(IFloor floor) throws RemoteException
       {
           this.floor=floor;
           LocalDataManager.getManager().addDataListener(IBuilding.class,this);
       }
       
       public void setValue(String value) throws RemoteException
       {
           floor.setName(value);
           LocalDataManager.getManager().saveOrUpdateFloor(floor,floor.getParentBuilding());
       }

       /* (non-Javadoc)
        * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
        */
       public void dataChanged(DataEvent event) throws RemoteException
       {
           IBuilding building = (IBuilding)event.getSource();
           int type = event.getEventType();
           switch(type)
           {
               case DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED :
               {
                Object[] tabFloor = (Object[])event.getSubObjects();
                for(int i=0;i<tabFloor.length;i++)
                {
                    if(this.floor.equals(tabFloor[i]))
                    {
                        this.floor = (IFloor)tabFloor[i];
                        view.setValue(floor.getName());
                    }
                }
                break;
               }
           }
           
       }
       /**
        * @return Returns the track.
        */
       public IFloor getFloor()
       {
           return floor;
       }

       /**
        * @param view The view to set.
        */
       public void setView(FloorView view)
       {
           this.view = view;
       }

}
