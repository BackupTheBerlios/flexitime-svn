/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models.management.room;

import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.LocalDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.BuildingView;


/**
 * Represents the model of the graphics view of a building
 * @author GUERRIN Guillaume
 */
public class BuildingViewModel extends DataListenerImpl
    {
         IBuilding building ;
         BuildingView view;
            
            public BuildingViewModel(IBuilding building) throws RemoteException
            {
                this.building=building;
                LocalDataManager.getManager().addDataListener(IBuilding.class,this);
            }
            
            public void setValue(String value) throws RemoteException
            {
                building.setName(value);
                try
                {
                    LocalDataManager.getManager().saveOrUpdateBuilding(building);
                }
                catch (FlexiException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            /* (non-Javadoc)
             * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
             */
            public void dataChanged(DataEvent event)
            {
                IBuilding building = (IBuilding)event.getSource();
                int type = event.getEventType();
                switch(type)
                {
                    case DataEvent.TYPE_PROPERTY_CHANGED :
                    {
                        if(this.building.equals(building))
                        {
                            this.building = building;
                            view.setValue(building.getName());
                        }
                        break;
                    }
                }
                
            }
            /**
             * @return Returns the track.
             */
            public IBuilding getBuilding()
            {
                return building;
            }
            
            public void setBuilding(IBuilding building)
            {
             this.building = building;   
             view.setValue(building.getName());
            }
            /**
             * @param view The view to set.
             */
            public void setView(BuildingView view)
            {
                this.view = view;
            }
}
