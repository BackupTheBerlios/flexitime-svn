
package fr.umlv.ir3.flexitime.common.event;

import java.io.Serializable;
import java.util.Arrays;
import java.util.EventObject;

/**
 * Event sended to PropertyListener.
 * 
 * @author Remi Forax
 * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener
 */
public class DataEvent implements Serializable
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3979274642101712951L;
    private Object source;

    /**
     * Event delivered whenever the state of an item's property change.
     * 
     * @param item the object that originated the event.
     * @param propertyName the name of the property that was changed.
     */
    public DataEvent(Object item, String propertyName)
    {
        this(item, propertyName, TYPE_PROPERTY_CHANGED, EMPTY_OBJECT_ARRAY,
                EMPTY_INTEGER_ARRAY);
    }
    
    /**
     * Event delivered whenever the state of an item's property change.
     * 
     * @param item the object that originated the event.
     * @param propertyName the name of the property that was changed.
     * @param eventType 
     */
    public DataEvent(Object item, String propertyName, int eventType)
    {
        this(item, propertyName, eventType, EMPTY_OBJECT_ARRAY,
                EMPTY_INTEGER_ARRAY);
    }

    /**
     * Event delivered whenever objects of a Collection or a Set are added,
     * removed or whenever their states changed.
     * 
     * @param item the object that originated the event.
     * @param propertyName the name of the property that was changed.
     * @param eventType one of TYPE_PROPERTY_CHANGED, TYPE_PROPERTY_ADDED or
     *            TYPE_PROPERTY_REMOVED.
     * @param subObjects objetcs that was changed/added/removed.
     */
    public DataEvent(Object item, String propertyName, int eventType,
            Object[] subObjects)
    {
        this(item, propertyName, eventType, subObjects, EMPTY_INTEGER_ARRAY);
    }

    /**
     * Event delivered whenever objects of a List are added, removed or whenever
     * their states changed.
     * 
     * @param item the object that originated the event.
     * @param propertyName the name of the property that was changed.
     * @param eventType one of the following choices : TYPE_PROPERTY_CHANGED,
     *            TYPE_PROPERTY_ADDED or TYPE_PROPERTY_REMOVED
     * @param subObjects objetcs that was changed/added/removed.
     * @param subIndicies indicies of the objects that was changed/added/removed
     *            in the List.
     */
    public DataEvent(Object item, String propertyName, int eventType,
            Object[] subObjects, int[] subIndicies)
    {
        source = item;
        this.propertyName = propertyName;
        this.eventType = eventType;
        this.subObjects = subObjects;
        this.subIndicies = subIndicies;
    }

    

    /**
     * returns the name of the property that was changed.
     * 
     * @return the name of the property that was changed.
     */
    public String getPropertyName()
    {
        return propertyName;
    }

    /**
     * returns the event type of this event.
     * 
     * @return the event type of this event. One of the following choices :
     *         TYPE_PROPERTY_CHANGED, TYPE_PROPERTY_ADDED or
     *         TYPE_PROPERTY_REMOVED
     */
    public int getEventType()
    {
        return eventType;
    }

    /**
     * returns objects that that was added, removed or changed.
     * 
     * @return an array of objects that was added/removed/changed or an empty
     *         array.
     */
    public Object[] getSubObjects()
    {
        return subObjects;
    }

    /**
     * returns indices of objects returned by
     * {@link #getSubObjects() getSubObjects}. indices are defined for List and
     * undefined for Collection or Set.
     * 
     * @return an array of index of sub item objects or an empty array.
     */
    public int[] getSubIndicies()
    {
        return subIndicies;
    }
    
    /**
     *  
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @see (si nécessaire)
     */
    public Object getSource()
    {
        return source;
    }

    /**
     * returns a string representation of this event.
     * 
     * @return a string representation of this event.
     */
    public String toString()
    {
        return getClass().getName() + "[object=" + getSource() + " property="  //$NON-NLS-1$//$NON-NLS-2$
                + propertyName + " eventType=" + eventType + " subObjects="  //$NON-NLS-1$//$NON-NLS-2$
                + Arrays.asList(subObjects) + " subIndicies=" //$NON-NLS-1$
                + toString(subIndicies) + ']';
    }

    private static String toString(int[] array)
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append('[');
        for (int i = 0 ; i < array.length ; i++)
            buffer.append(array[i]).append(' ');
        if (array.length != 0) buffer.setLength(buffer.length() - 1);
        return buffer.append(']').toString();
    }

    private final String          propertyName;
    private final int             eventType;
    private final Object[]        subObjects;
    private final int[]           subIndicies;

    private static final int[]    EMPTY_INTEGER_ARRAY   = new int[0];
    private static final Object[] EMPTY_OBJECT_ARRAY    = new Object[0];

    /**
     * Constant that indicates that property has changed
     */
    public final static int       TYPE_PROPERTY_CHANGED = 1;
    /**
     * Constant that indicates that property has been added
     */
    public final static int       TYPE_PROPERTY_ADDED   = 2;
    /**
     * Constant that indicates that property has been removed
     */
    public final static int       TYPE_PROPERTY_REMOVED = 3;
    /**
     * Constant that indicates that a subData of property has changed
     */
    public final static int       TYPE_PROPERTY_SUBDATA_CHANGED = 4;
    /**
     * Constant that indicates that a subData of property has been added
     */
    public final static int       TYPE_PROPERTY_SUBDATA_ADDED = 5;
    /**
     * Constant that indicates that a subData of property has been removed
     */
    public final static int       TYPE_PROPERTY_SUBDATA_REMOVED = 6;
    
    
}
