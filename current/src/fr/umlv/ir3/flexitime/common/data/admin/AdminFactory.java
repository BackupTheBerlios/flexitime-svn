/*
 * Created on 18 janv. 2005
 * by Jérôme GUERS
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.admin;

import fr.umlv.ir3.flexitime.common.data.admin.impl.ConfigImpl;


/**
 * Create all admin object from specific parameters. This class contains only statics
 * methods to create each types of admin objects.
 * 
 * @version 204
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class AdminFactory
{
    /**
     * Create an empty configuration 
     *
     * @return a new configuration object without any initialization of the parameter
     */
    public static IConfig createConfig()
    {
        return new ConfigImpl();
    }
}

