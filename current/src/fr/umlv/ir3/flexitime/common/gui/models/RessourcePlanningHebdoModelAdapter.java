/*
 * Created on 21 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.gui.models;

import java.util.Calendar;

import fr.umlv.ir3.flexitime.common.data.resources.IResource;
import fr.umlv.ir3.flexitime.common.tools.Gap;
import fr.umlv.ir3.flexitime.common.tools.Time;


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
public class RessourcePlanningHebdoModelAdapter extends RessourcePlanningModel
{

    /**
     * DOCME
     * @param ressource
     * @param initialGap
     */
    public RessourcePlanningHebdoModelAdapter(IResource ressource, Gap initialGap)
    {
        super(ressource,initialGap);
        //this.model = new RessourcePlanningModel(ressource,initialGap);
    }
    
    /** 
     * Return the element at the specified index<br>
     *
     * @param dayNumber the value of the day (0 is the first)
     * @param gapNumber the value of the gap (0 is the first)
     * @return the Object at the specified index
     * 
     * @author   FlexiTeam - binou
     */
    public Object getElementAt(int dayNumber, int gapNumber)
    {
        return super.getElementAt(0, dayNumber, gapNumber);
    }
    
    /**
     * Return a String which is the name of the date we want
     * <br>
     * in order to constructs the header of the Day in the planning Example :
     * <code>model.getDayHeaderAt(2)</code> will return "Mardi 2 Janvier 2005"
     * 
     * @param dayNumber the value of the day (0 is the first)
     * @return an String representation of this day
     * @author FlexiTeam - binou
     */
    public Object getDayHeaderAt(int dayNumber)
    {
        Time t = new Time((Calendar)super.getDateHeaderAt(0,dayNumber));
        return (String)super.getDayHeaderAt(dayNumber) + " " + t.getStrDate().substring(0, t.getStrDate().length()-5);  //$NON-NLS-1$
    }
    
    
    
    
    
    
    
    
    
    
    
    
//  /**
//  * DOCME
//  * @param model2
//  */
// public RessourcePlanningHebdoModelAdapter(RessourcePlanningModel model2)
// {
//     
//     this.model = model2;
// }
//    
//
//    /** 
//     * DOCME Description
//     * Quel service est rendu par cette méthode
//     * <code>exemple d'appel de la methode</code>
//     *
//     * @param hebdo 
//     * 
//     */
//    public void addPlanningDataListener(JRessourcePlanningHebdo hebdo)
//    {
//        model.addPlanningDataListener(hebdo);        
//    }
//
//    /** 
//     * DOCME Description
//     * Quel service est rendu par cette méthode
//     * <code>exemple d'appel de la methode</code>
//     *
//     * @return 
//     * 
//     */
//    public int getNbDays()
//    {
//        return model.getNbDays();
//    }
//
//    /** 
//     * DOCME Description
//     * Quel service est rendu par cette méthode
//     * <code>exemple d'appel de la methode</code>
//     *
//     * @return 
//     * 
//     */
//    public int getNbBloc()
//    {
//        return model.getNbBloc();
//    }
//
//    /** 
//     * DOCME Description
//     * Quel service est rendu par cette méthode
//     * <code>exemple d'appel de la methode</code>
//     *
//     * @param j
//     * @return 
//     * 
//     */
//    public int getBlocSize(int j)
//    {
//        return model.getBlocSize(j);
//    }
//
//
//
//
//    /** 
//     * DOCME Description
//     * Quel service est rendu par cette méthode
//     * <code>exemple d'appel de la methode</code>
//     *
//     * @param blocNumber
//     * @return 
//     * 
//     */
//    public Object getGapHeaderAt(int blocNumber)
//    {
//        // TODO Auto-generated method stub
//        return model.getGapHeaderAt(blocNumber);
//    }
//
//    /** 
//     * DOCME Description
//     * Quel service est rendu par cette méthode
//     * <code>exemple d'appel de la methode</code>
//     *
//     * @return 
//     * 
//     */
//    public int getDayGapSize()
//    {
//        return model.getDayGapSize();
//    }
//
//    /** 
//     * DOCME Description
//     * Quel service est rendu par cette méthode
//     * <code>exemple d'appel de la methode</code>
//     *
//     * @return 
//     * 
//     */
//    public Gap getCurrentGap()
//    {
//        return model.getCurrentGap();
//    }
//    /** 
//     * DOCME Description
//     * Quel service est rendu par cette méthode
//     * <code>exemple d'appel de la methode</code>
//     *
//     * @param dayNumber
//     * @return 
//     * 
//     */
//    public Object getDayHeaderAt(int dayNumber)
//    {
//        return model.getDayHeaderAt(dayNumber);
//    }
//    
//    /** 
//     * Change the range of week currently used for the planning<br>
//     * the result will be the previous Gap of week
//     */
//    public void fullStepBack()
//    {
//        model.fullStepBack();
//    }
//    
//    /** 
//     * Change the range of week currently used for the planning<br>
//     * the result will be the same gap but one week earlier
//     */
//    public void stepBack()
//    {
//        model.stepBack();
//    }
//    
//    /** 
//     * Change the range of week currently used for the planning<br>
//     * the result will be the the same gap without the ending week
//     */
//    public void decrease()
//    {
//        model.decrease();
//    }
//    
//    /** 
//     * Change the range of week currently used for the planning<br>
//     * the result will be the the same gap with another week added
//     */
//    public void increase()
//    {
//        model.increase();
//    }
//    
//    /** 
//     * Change the range of week currently used for the planning<br>
//     * the result will be the same gap but one week later
//     */
//    public void stepOver()
//    {
//        model.stepOver();
//    }
//    
//
//    /** 
//     * Change the range of week currently used for the planning<br>
//     * the result will be the next Gap of week
//     */
//    public void fullStepOver()
//    {
//        model.fullStepOver();
//    }
//    
//    /** 
//     * Decrease the size of gap's time
//     */
//    public void lessGapTime()
//    {
//        model.lessGapTime();
//    }
//    
//    /** 
//     * Increase the size of gap's time
//     */
//    public void moreGapTime()
//    {
//        model.moreGapTime();
//    }
//    
//    /** 
//     * Get the multiplier used to calculate the gapTime
//     *
//     * @return the multiplier
//     * 
//     * @see RessourcePlanningModel#getGapUnit()
//     * 
//     */
//    public int getGapMultiplicateur()
//    {
//        return model.getGapMultiplicateur();
//    }
//    
//    /** 
//     * Get the unit used to calculate the gapTime
//     *
//     * @return the unit in minutes
//     * 
//     * @see RessourcePlanningModel#getGapMultiplicateur()
//     */
//    public int getGapUnit()
//    {
//        return model.getGapUnit();
//    }

    
    
    

}

