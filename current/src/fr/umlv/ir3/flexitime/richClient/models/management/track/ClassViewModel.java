/*
 * Created on 28 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.track;

import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.ClassView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.TrackView;


/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ClassViewModel extends DataListenerImpl
{
    IClass iClass ;
    ClassView view;
    
    public ClassViewModel(IClass iClass) throws RemoteException
    {
        this.iClass=iClass;
        RemoteDataManager.getManager().addDataListener(ITrack.class,this);
    }
    
    public void setValue(String value) throws RemoteException
    {
        iClass.setName(value);
        RemoteDataManager.getManager().saveOrUpdateClass(iClass,iClass.getParentTrack());
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
            case DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED :
            {
             Object[] tabClass = event.getSubObjects();
             for(int i=0;i<tabClass.length;i++)
             {
                 if(this.iClass.equals(tabClass[i]))
                 {
                     this.iClass = (IClass)tabClass[i];
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
    public IClass getIClass()
    {
        return iClass;
    }

    /**
     * @param view The view to set.
     */
    public void setView(ClassView view)
    {
        this.view = view;
    }

}
