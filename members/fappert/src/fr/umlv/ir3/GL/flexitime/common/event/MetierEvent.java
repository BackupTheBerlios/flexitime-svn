/*
 * Created on 22 févr. 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package fr.umlv.ir3.GL.flexitime.common.event;

/**
 *
 * The MetierEvent class represents an specific type of event on an Object (ADDED or REMOVED)
 * 
 * @author Adrien Bouvet & Fabien Appert
 */
public class MetierEvent
{
	private int type;
	
	public static final int CHANGED = 3;
	public static final int REMOVED = 2;
	public static final int ADDED = 1;
	private Object object;

	/**
	 * 
	 */
	public MetierEvent(Object object, int type)
	{
		this.type = type;
		this.object = object;
	}

	/**
	 * @return Returns the object.
	 */
	public Object getObject()
	{
		return object;
	}


	/**
	 * @return Returns the type.
	 */
	public int getType()
	{
		return type;
	}


}
