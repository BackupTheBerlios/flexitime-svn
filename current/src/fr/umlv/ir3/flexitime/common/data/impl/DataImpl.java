/*
 * Created on 13 janv. 2005
 * by Pr�sad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.impl;

import fr.umlv.ir3.flexitime.common.data.IData;


/**
 * DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * @see (si n�cessaire)
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
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;

    }
}

