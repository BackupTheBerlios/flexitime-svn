/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models.management.device;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.LocalDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.DevicesView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.TrackView;


/**
 * Represents the model of the graphics view of a device
 * @author GUERRIN Guillaume
 */
public class DevicesViewModel extends DataListenerImpl
{
     IDevice device ;
     DevicesView view;
     List listener;
        
        public DevicesViewModel(IDevice device) throws RemoteException
        {
            this.device=device;
            LocalDataManager.getManager().addDataListener(IDevice.class,this);
            listener = new ArrayList();
        }
        
        public void setValue(String value) throws RemoteException
        {
            device.setName(value);
            LocalDataManager.getManager().saveOrUpdateDevice(device);
        }
        public void setDevice(IDevice device) throws RemoteException
        {
            this.device=device;
            view.setValue(device.getName());
        }

        /* (non-Javadoc)
         * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
         */
        public void dataChanged(DataEvent event) throws RemoteException
        {
            IDevice device = (IDevice)event.getSource();
            int type = event.getEventType();
            switch(type)
            {
                case DataEvent.TYPE_PROPERTY_CHANGED :
                {
                    if(this.device.equals(device))
                    {
                        this.device = device;
                        view.setValue(device.getName());
                    }
                    break;
                }
            }
            
        }
        /**
         * @return Returns the track.
         */
        public IDevice getDevice()
        {
            return device;
        }

        /**
         * @param view The view to set.
         */
        public void setView(DevicesView view)
        {
            this.view = view;
        }
}
