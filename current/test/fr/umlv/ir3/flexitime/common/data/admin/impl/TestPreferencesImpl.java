/*
 * Created on 11 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.admin.impl;

import java.awt.Color;

import junit.framework.TestCase;

import fr.umlv.ir3.flexitime.common.data.admin.IPreferences;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;

/**
 * Defines all the preferences that can set a user.<br>
 * Implements the interface IPreferences
 * 
 * @version 240
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestPreferencesImpl extends TestCase
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3904961949799100468L;
    // ======== //
    // Champs //
    // ======== //
    PreferencesImpl pref = new PreferencesImpl();
    // =============//
    // Méthodes //
    // =============//
    /**
     * Getter for idPref
     * 
     * @return id of the preference
     */
    public void testGetIdPref()
    {
        pref.setIdPref(new Long(0));
        if(pref.getIdPref().compareTo(new Long(0))!=0)fail("erreur long");
        
    }

    

   

   

  


  

   

  
}
