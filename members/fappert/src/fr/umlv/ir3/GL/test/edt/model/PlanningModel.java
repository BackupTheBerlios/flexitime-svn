/*
 * Created on 15 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.GL.test.edt.model;

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
 * @author FlexiTeam - binou
 */
public interface PlanningModel
{

    /**
     * Return the number of week of the content data in the model
     * 
     * @return Returns the nbWeeks.
     */
    public int getNbWeeks();

    /**
     * Returns the number of day in a week
     *
     * @return the number of day in a week
     * 
     * @author   FlexiTeam - binou
     */
    public int getNbDays();

    /**
     * Returns the number of blocs in a day
     * 
     * @return Returns the number of blocs in a day
     */
    public int getNbBloc();

    /** 
     * Return the element at the specified index<br>
     * (should be a Busy)
     * <code>exemple d'appel de la methode</code>
     *
     * @param weekNumber the value of the week (0 is the first)
     * @param dayNumber the value of the day (0 is the first)
     * @param gapNumber the value of the gap (0 is the first)
     * @return the Object at the specified index
     * 
     * @see (si n�cessaire)
     * @author   FlexiTeam - binou
     */
    public Object getElementAt(int weekNumber, int dayNumber, int gapNumber);
}