/*
 * Created on 21 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.gui.models;

import fr.umlv.ir3.flexitime.common.data.resources.IResource;
import fr.umlv.ir3.flexitime.common.tools.Gap;
import fr.umlv.ir3.flexitime.richClient.gui.panel.exploitation.JRessourcePlanningHebdo;


/**
 * DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - binou
 */
public class RessourcePlanningHebdoModelAdapter
{
    private RessourcePlanningModel model;
    
    public RessourcePlanningHebdoModelAdapter(IResource ressource, Gap initialGap)
    {
        this.model = new RessourcePlanningModel(ressource,initialGap);
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param hebdo 
     * 
     * @see (si n�cessaire)
     */
    public void addPlanningDataListener(JRessourcePlanningHebdo hebdo)
    {
        model.addPlanningDataListener(hebdo);        
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @see (si n�cessaire)
     */
    public int getNbDays()
    {
        return model.getNbDays();
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @see (si n�cessaire)
     */
    public int getNbBloc()
    {
        return model.getNbBloc();
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param j
     * @return 
     * 
     * @see (si n�cessaire)
     */
    public int getBlocSize(int j)
    {
        return model.getBlocSize(j);
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param dayNumber
     * @param gapNumber
     * @return 
     * 
     * @see (si n�cessaire)
     */
    public Object getElementAt(int dayNumber, int gapNumber)
    {
        return model.getElementAt(0, dayNumber, gapNumber);
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param dayNumber
     * @return 
     * 
     * @see (si n�cessaire)
     */
    public Object getDateHeaderAt(int dayNumber)
    {
        return model.getDateHeaderAt(0, dayNumber);
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param blocNumber
     * @return 
     * 
     * @see (si n�cessaire)
     */
    public Object getGapHeaderAt(int blocNumber)
    {
        // TODO Auto-generated method stub
        return model.getGapHeaderAt(blocNumber);
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @see (si n�cessaire)
     */
    public int getDayGapSize()
    {
        return model.getDayGapSize();
    }

}

