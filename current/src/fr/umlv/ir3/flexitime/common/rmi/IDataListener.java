/*
 * Created on 27 d�c. 2004
 * by Val�re
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.rmi;

import fr.umlv.ir3.flexitime.common.event.DataEvent;

/**
 * IDataListener - DOCME Description explication suppl�mentaire si n�cessaire in
 * english please... Que fait cette classe, qu'est-ce qu'elle repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * @author FlexiTeam - Val�re
 */
public interface IDataListener
{

    /**
     * changed - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param data
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public void dataChanged(DataEvent data);
}