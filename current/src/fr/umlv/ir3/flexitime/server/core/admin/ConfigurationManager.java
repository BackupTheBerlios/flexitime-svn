/*
 * Created on 26 déc. 2004
 * by Valère
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core.admin;

import java.util.HashMap;

import fr.umlv.ir3.flexitime.common.data.admin.IConfig;
import fr.umlv.ir3.flexitime.common.data.admin.IPreferences;
import fr.umlv.ir3.flexitime.common.rmi.admin.IConfigurationListener;
import fr.umlv.ir3.flexitime.common.rmi.admin.IConfigurationManager;

/**
 * ConfigurationManagerImpl - DOCME Description explication supplémentaire si
 * nécessaire in english please... Que fait cette classe, qu'est-ce qu'elle
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @author FlexiTeam - Valère
 */
public class ConfigurationManager implements IConfigurationManager 
{
    //Pas de gestion de lock car un seul admin en meme temps !!
    public IConfig get()
    {
        //On va chercher la config dans la base
        //if ConfigStorage.lock() == false;
        //On la retourne
        //return ConfigStorage.get();
        return(null);
    }
    
    public void save(IConfig config)
    {
        //if ConfigStorage.lock() == false;
        //On met la nouvelle
        //ConfigStorage.set(config);
        //notifié?
    }

}