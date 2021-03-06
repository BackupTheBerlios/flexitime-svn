/*
 * Created on 13 janv. 2005
 * by Pr�sad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.impl;

import fr.umlv.ir3.flexitime.common.data.IData;

/**
 * Abstract class and base class of all implementations of data
 * 
 * Implements the interface IData 
 * @version 1.0
 * 
 * @author FlexiTeam - Pr�sad
 */
public abstract class DataImpl implements IData
{
    private String name;
    protected Long idData = null;

    protected DataImpl()
    {
        
    }
    
    protected DataImpl(String name)
    {
        this.name = name;
    }
    
    /**
     * Getter for the name
     * @return the name of the data
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#getName()
     */
    public String getName()
    {
        return name;
    }
    
    /**
     *  
     * Setter for the name 
     * @param name the name to set
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#setName(java.lang.String)
     */
    public void setName(String name)
    {
        this.name = name;

    }
    
    /**
     * Getter for idData
     *
     * @return id of the data
     * 
     */
    public Long getIdData()
    {
        return idData;
    }
    
    /**
     *  
     * Setter fo idData
     * @param idData id to set
     * 
     */
    public void setIdData(Long idData)
    {
        this.idData = idData;
    }
    
    /**
     * Test the equality of two datas.
     * <ul>
     * <li>If one data has an ID, the other must have one, else there are not
     * equals.</li>
     * <li>If any data has an ID, they must have the same name to be equals.
     * </li>
     * <li>Else, they must have the same ID.</li>
     * </ul>
     * 
     * @param obj
     *            other data to compare with
     * @return <code>true</code> if this object is the same as the obj
     *         argument; <code>false</code> otherwise.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        if (! ( this.getClass().equals(obj.getClass()))) return false;
        IData other = (IData) obj;
        if ( ( ( idData != null ) && ( other.getIdData() == null ) )
                || ( ( idData == null ) && ( other.getIdData() != null ) ))
            return false;
        if (idData == null) return this.getName().equals(other.getName());
        return ( idData == other.getIdData() );
    }
}

