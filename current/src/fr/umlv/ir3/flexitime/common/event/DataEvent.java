/*
 * Created on 30 déc. 2004 by Jérôme GUERS Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.event;

import java.io.Serializable;
import java.util.EventObject;

import fr.umlv.ir3.flexitime.common.data.IData;

/**
 * Event sended to IDataListener
 * 
 * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class DataEvent extends EventObject implements Serializable
{
    //============//
    // Propriétés //
    //============//
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3978141062810318644L;

    /**
     * Indicates that the data has been added added
     */
    public final static int TYPE_ADDED=1;
    
    /**
     * indicates that the data has changed
     */
    
    public final static int TYPE_CHANGED=2;
    /**
     * Indicates that the data has been removed
     */
    public final static int TYPE_REMOVED=3;

    //========//
    // Champs //
    //========//
    
    private final int iEventType;
    
    //===============//
    // Constructeurs //
    //===============//
    
    /**
     * 
     * Event delivered when the state of a IData has changed
     * @param d IData that originated the event
     * @param eType one of TYPE_PROPERTY_CHANGED, TYPE_PROPERTY_ADDED
     * 		or TYPE_PROPERTY_REMOVED.
     */
    public DataEvent(IData d, int eType)
    {
        super(d);
        iEventType = eType;
        
    }
    
    //==========//
    // Méthodes //
    //==========//
    /**
     *  Getter for IData contained in this event
     * 
     * @return IData that generated this event 
     * 
     */
    public IData getData()
    {
        return (IData)getSource();
    }
    
    /**
     * Return eventType
     * @return Returns the eventType.
     */
    public int getEventType()
    {
        return iEventType;
    }
    
    
}
