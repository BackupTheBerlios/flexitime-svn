/*
 * Created on 28 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.room;

import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.BuildingView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.DevicesView;


/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BuildingViewModel extends DataListenerImpl
    {
         IBuilding building ;
         BuildingView view;
            
            public BuildingViewModel(IBuilding building) throws RemoteException
            {
                this.building=building;
                RemoteDataManager.getManager().addDataListener(IBuilding.class,this);
            }
            
            public void setValue(String value) throws RemoteException
            {
                building.setName(value);
                RemoteDataManager.getManager().saveOrUpdateBuilding(building);
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

            /**
             * @param view The view to set.
             */
            public void setView(BuildingView view)
            {
                this.view = view;
            }
}
