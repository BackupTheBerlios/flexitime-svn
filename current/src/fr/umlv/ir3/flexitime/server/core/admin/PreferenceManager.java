/*
 * Created on 26 d�c. 2004
 * by Val�re
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core.admin;

import java.util.HashMap;

import fr.umlv.ir3.flexitime.common.data.admin.IConfig;
import fr.umlv.ir3.flexitime.common.data.admin.IPreferences;
import fr.umlv.ir3.flexitime.common.rmi.admin.IPreferenceListener;
import fr.umlv.ir3.flexitime.common.rmi.admin.IPreferenceManager;

/**
 * PreferenceManagerImpl - DOCME Description explication suppl�mentaire si
 * n�cessaire in english please... Que fait cette classe, qu'est-ce qu'elle
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * @author FlexiTeam - Val�re
 */
public class PreferenceManager implements IPreferenceManager
{
    UserManager userManager;
    
    public PreferenceManager(IConfig config)
    {
        userManager = new UserManager(config);
    }
    
    /**
     * getPreferences - DOCME Description Quel service est rendu par cette
     * m�thode <code>exemple d'appel de la methode</code>
     * 
     * @param login
     * @return
     * @see fr.umlv.ir3.flexitime.common.rmi.admin.IPreferenceListener#getPreferences(java.lang.String)
     * @author FlexiTeam - Val�re
     * @date 26 d�c. 2004
     */
    public IPreferences getPreferences(String userName)
    {
        return(userManager.get(userName).getPreferences());
    }
    
    public void setPreferences(String userName,IPreferences pref)
    {
        userManager.get(userName).setPreferences(pref);
        //TODO Notifi� ??
    }
    /**
     * This method loads the user's preferences in memory and apply them to the
     * client's GUI.
     */
    void load()
    {
    	//connex rmi
    	//recup prefManager
    	//prefmanager.get attributes
    }

    /**
     * This method saves all the user's preferences in database.
     */
    void save()
    {
    	//connex rmi
    	//recup PrefManager
    	//prefManager.set attributes
    }
}