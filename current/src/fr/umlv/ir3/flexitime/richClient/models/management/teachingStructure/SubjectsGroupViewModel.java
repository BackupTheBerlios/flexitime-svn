/*
 * Created on 28 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure;

import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.FloorView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.SubjectsGroupView;


/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SubjectsGroupViewModel extends DataListenerImpl
{
    ISubjectsGroup subGroup ;
    SubjectsGroupView view;
       
       public SubjectsGroupViewModel(ISubjectsGroup subGroup) throws RemoteException
       {
           this.subGroup=subGroup;
           RemoteDataManager.getManager().addDataListener(ITeachingStructure.class,this);
       }
       
       public void setValue(String value) throws RemoteException
       {
           subGroup.setName(value);
           RemoteDataManager.getManager().saveOrUpdateSubjectsGroup(subGroup,subGroup.getParentTeachStruct());
       }

       /* (non-Javadoc)
        * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
        */
       public void dataChanged(DataEvent event) throws RemoteException
       {
           ITeachingStructure teaching = (ITeachingStructure)event.getSource();
           int type = event.getEventType();
           switch(type)
           {
               case DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED :
               {
                Object[] tabSubjectsGroup = event.getSubObjects();
                for(int i=0;i<tabSubjectsGroup.length;i++)
                {
                    if(this.subGroup.equals(tabSubjectsGroup[i]))
                    {
                        this.subGroup = (ISubjectsGroup)tabSubjectsGroup[i];
                        view.setValue(subGroup.getName());
                    }
                }
                break;
               }
           }
           
       }
       /**
        * @return Returns the track.
        */
       public ISubjectsGroup getSubjectsGroup()
       {
           return subGroup;
       }

       /**
        * @param view The view to set.
        */
       public void setView(SubjectsGroupView view)
       {
           this.view = view;
       }


}
