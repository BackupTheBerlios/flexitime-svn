/*
 * Created on 14 janv. 2005
 * by Famille
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi.admin;

import java.rmi.Remote;

import fr.umlv.ir3.flexitime.common.data.admin.IPreferences;


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
 * @author FlexiTeam - Famille
 */
public interface IPreferenceManager extends Remote 
{
    public IPreferences getPreferences(String userName);
    public void setPreferences(String userName,IPreferences pref);
}

