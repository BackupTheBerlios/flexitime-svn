/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models.management.track;

import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.LocalDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.ClassView;


/**
 * Represents the model of the graphics view of a Class
 * @author GUERRIN Guillaume
 */
public class ClassViewModel extends DataListenerImpl
{
    IClass iClass ;
    ClassView view;
    
    public ClassViewModel(IClass iClass) throws RemoteException
    {
        this.iClass=iClass;
        LocalDataManager.getManager().addDataListener(ITrack.class,this);
    }
    
    public void setValue(String value) throws RemoteException
    {
        iClass.setName(value);
        try
        {
            LocalDataManager.getManager().saveOrUpdateClass(iClass,iClass.getParentTrack());
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
    
    public void setIClass(IClass iClass)
    {
        this.iClass=iClass;
        view.fireChanged();
    }

    /**
     * @param view The view to set.
     */
    public void setView(ClassView view)
    {
        this.view = view;
    }

}
