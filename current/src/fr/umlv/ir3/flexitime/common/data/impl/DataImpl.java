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
}

