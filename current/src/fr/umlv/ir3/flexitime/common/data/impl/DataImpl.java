/*
 * Created on 13 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.impl;

import fr.umlv.ir3.flexitime.common.data.IData;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * 
 * @author FlexiTeam - Prâsad
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
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;

    }
}

