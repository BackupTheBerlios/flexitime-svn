/*
 * Created on 28 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure;

import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.SubjectView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.SubjectsGroupView;


/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SubjectViewModel extends DataListenerImpl
{
    ISubject subject ;
    SubjectView view;
       
       public SubjectViewModel(ISubject subject) throws RemoteException
       {
           this.subject=subject;
           RemoteDataManager.getManager().addDataListener(ISubjectsGroup.class,this);
       }
       
       public void setValue(String value) throws RemoteException
       {
           subject.setName(value);
           RemoteDataManager.getManager().saveOrUpdateSubject(subject,subject.getParentSubjectsGroup());
       }

       /* (non-Javadoc)
        * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
        */
       public void dataChanged(DataEvent event) throws RemoteException
       {
           ISubjectsGroup subjectGroup= (ISubjectsGroup)event.getSource();
           int type = event.getEventType();
           switch(type)
           {
               case DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED :
               {
                Object[] tabSubject = event.getSubObjects();
                for(int i=0;i<tabSubject.length;i++)
                {
                    if(this.subject.equals(tabSubject[i]))
                    {
                        this.subject = (ISubject)tabSubject[i];
                        view.setValue(subject.getName());
                    }
                }
                break;
               }
           }
           
       }
       /**
        * @return Returns the track.
        */
       public ISubject getSubject()
       {
           return subject;
       }

       /**
        * @param view The view to set.
        */
       public void setView(SubjectView view)
       {
           this.view = view;
       }
}
