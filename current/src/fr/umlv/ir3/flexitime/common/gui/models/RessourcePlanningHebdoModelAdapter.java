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
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - binou
 */
public class RessourcePlanningHebdoModelAdapter
{
    private RessourcePlanningModel model;
    
    public RessourcePlanningModel getModel()
    {
        return model;
    }
    public RessourcePlanningHebdoModelAdapter(IResource ressource, Gap initialGap)
    {
        this.model = new RessourcePlanningModel(ressource,initialGap);
    }

    /**
     * DOCME
     * @param model2
     */
    public RessourcePlanningHebdoModelAdapter(RessourcePlanningModel model2)
    {
        this.model = model2;
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param hebdo 
     * 
     */
    public void addPlanningDataListener(JRessourcePlanningHebdo hebdo)
    {
        model.addPlanningDataListener(hebdo);        
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     */
    public int getNbDays()
    {
        return model.getNbDays();
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     */
    public int getNbBloc()
    {
        return model.getNbBloc();
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param j
     * @return 
     * 
     */
    public int getBlocSize(int j)
    {
        return model.getBlocSize(j);
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param dayNumber
     * @param gapNumber
     * @return 
     * 
     */
    public Object getElementAt(int dayNumber, int gapNumber)
    {
        return model.getElementAt(0, dayNumber, gapNumber);
    }


    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param blocNumber
     * @return 
     * 
     */
    public Object getGapHeaderAt(int blocNumber)
    {
        // TODO Auto-generated method stub
        return model.getGapHeaderAt(blocNumber);
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     */
    public int getDayGapSize()
    {
        return model.getDayGapSize();
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     */
    public Gap getCurrentGap()
    {
        return model.getCurrentGap();
    }
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param dayNumber
     * @return 
     * 
     */
    public Object getDayHeaderAt(int dayNumber)
    {
        return model.getDayHeaderAt(dayNumber);
    }

}

