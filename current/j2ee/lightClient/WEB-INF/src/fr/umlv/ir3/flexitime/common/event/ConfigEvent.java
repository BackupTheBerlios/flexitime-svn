/*
 * Created on 30 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.event;

import java.io.Serializable;

import fr.umlv.ir3.flexitime.common.data.admin.IConfig;


/**
 * Event delivered when confguration has changed
 * 
 */
public class ConfigEvent implements Serializable
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3258125843346896439L;
    private IConfig cfg;
    
    /**
     * Constructs a ConfigEvent
     * 
     * @param cfg new IConfig 
     */
    public ConfigEvent(IConfig cfg)
    {
        this.cfg = cfg;
    }
    
    /**
     * 
     * @return new Config 
     * 
     */
    public IConfig getConfig()
    {
        return cfg;
    }

}

