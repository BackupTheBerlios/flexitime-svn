/*
 * Created on 28 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.track;

import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.TrackView;
import fr.umlv.ir3.flexitime.richClient.models.management.room.BuildingTreeNode;


/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TrackViewModel extends DataListenerImpl
{
    ITrack track ;
    TrackView view;
    
    public TrackViewModel(ITrack track) throws RemoteException
    {
        this.track=track;
        RemoteDataManager.getManager().addDataListener(ITrack.class,this);
    }
    
    public void setValue(String value) throws RemoteException
    {
        track.setName(value);
        RemoteDataManager.getManager().saveOrUpdateTrack(track);
    }

    /* (non-Javadoc)
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
     */
    public void dataChanged(DataEvent event) throws RemoteException
    {
        ITrack track = (ITrack)event.getSource();
        int type = event.getEventType();
        switch(type)
        {
            case DataEvent.TYPE_PROPERTY_CHANGED :
            {
                if(this.track.equals(track))
                {
                    this.track = track;
                    view.setValue(track.getName());
                }
                break;
            }
        }
        
    }
    /**
     * @return Returns the track.
     */
    public ITrack getTrack()
    {
        return track;
    }

    /**
     * @param view The view to set.
     */
    public void setView(TrackView view)
    {
        this.view = view;
    }
}
