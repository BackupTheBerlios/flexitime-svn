/*
 * Created on 4 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.lightClient.gui;
import java.util.List;


import fr.umlv.ir3.flexitime.common.data.resources.IResource;
import fr.umlv.ir3.flexitime.common.gui.models.RessourcePlanningHebdoModelAdapter;
import fr.umlv.ir3.flexitime.common.gui.models.RessourcePlanningModel;
import fr.umlv.ir3.flexitime.common.tools.Gap;
import fr.umlv.ir3.flexitime.common.tools.Time;

/**
 * DOCME Description
 * 
 * A component that allows the user to manage a planning
 * A separate model, <code>EDTModel</code>, represents the contents
 * of the planning.
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - binou
 */
public class RessourcePlanning
{
    public static final int MODE_TRIM = 1;
    public static final int MODE_HEBDO = 2;
    public static final int MODE_MULTI = 3;
    
    private int mode = 0;
    
    private JRessourcePlanning planningTrim = null;
    private JRessourcePlanningHebdo planningHebdo = null;
    //private JRessourcesPlanning planningMulti = null;
    
    private Object ressource;
    private Gap initialGap;

    public RessourcePlanning()
    {
               
        //TODO lire la config ici
        this.initialGap = new Gap(2005,1,3,0,1,2005,1,16,23,59);
        this.ressource = null;
        
    }
    
    public void setRessource(Object _ressource)
    {
        if(_ressource == null)
            return;
        this.ressource = _ressource;
        
        //Si on etait en mode trim ou hebdo, on recupere la créneau visualisé précédemment
        if(mode != 0)
            if(mode == RessourcePlanning.MODE_TRIM)
                this.initialGap = planningTrim.getModel().getCurrentGap();
            else if(mode == RessourcePlanning.MODE_HEBDO)
                this.initialGap = planningHebdo.getModel().getCurrentGap();
        
       
        
        if(ressource instanceof List)
            this.mode = RessourcePlanning.MODE_MULTI;
        else if(Time.getGapWeek(this.initialGap.getStartDate(), this.initialGap.getEndDate())+1 > 1)
            this.mode = RessourcePlanning.MODE_TRIM;
        else
            this.mode = RessourcePlanning.MODE_HEBDO;
      
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     *
     * @return the mode
     * 
     */
    public int getMode()
    {
        return mode;
    }
    
    private void createPlanning()
    {
        if(this.ressource instanceof IResource)
        {
            if(this.mode == RessourcePlanning.MODE_TRIM)
            {
                System.out.println("Affichage Trim");
                this.mode = RessourcePlanning.MODE_TRIM;
                planningTrim = new JRessourcePlanning(new RessourcePlanningModel((IResource)this.ressource, this.initialGap));
                    
            }
            else
            {
                System.out.println("Affichage hebdo");
                this.mode = RessourcePlanning.MODE_HEBDO;
                planningHebdo = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter((IResource)this.ressource, this.initialGap));
                    
            }
        }
        else if(this.ressource instanceof List)
        {
            System.out.println("Affichage multiple");
        }
    }
    
    private void switchToHebdo()
    {
        this.mode = RessourcePlanning.MODE_HEBDO;
        
        //On opère la décrémentation pour passer à 1 semaine
        this.initialGap = this.planningTrim.getModel().getCurrentGap();
        this.initialGap.getEndDate().addWeek(-1);
        
      
        this.planningHebdo = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter((IResource)this.ressource, this.initialGap));
    }
   
    private void switchToTrim()
    {
        this.mode = RessourcePlanning.MODE_TRIM;
        
        //On opère la décrémentation pour passer à 1 semaine
        this.initialGap = this.planningHebdo.getModel().getCurrentGap();
        this.initialGap.getEndDate().addWeek(1);
        
        
        this.planningTrim = new JRessourcePlanning(new RessourcePlanningModel((IResource)this.ressource, this.initialGap));
        
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * 
     * 
     */
    public void fullStepBack()
    {
        switch(mode)
        {
            case RessourcePlanning.MODE_HEBDO :
                System.out.println("fullStepBack() en mode Hebdo");
                //planningHebdo.fullStepBack();
                break;
            case RessourcePlanning.MODE_MULTI :
                System.err.println("On ne doit pas pouvoir lancer cette action en mode multi !!!");
                break;
            case RessourcePlanning.MODE_TRIM :
                System.out.println("fullStepBack() en mode Trim");
                planningTrim.fullStepBack();
                break;
        }
        
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * 
     * 
     */
    public void stepBack()
    {
        switch(mode)
        {
            case RessourcePlanning.MODE_HEBDO :
                System.out.println("stepBack() en mode Hebdo");
                //planningHebdo.fullStepBack();
                break;
            case RessourcePlanning.MODE_MULTI :
                System.err.println("On ne doit pas pouvoir lancer cette action en mode multi !!!");
                break;
            case RessourcePlanning.MODE_TRIM :
                System.out.println("stepBack() en mode Trim");
                planningTrim.stepBack();
                break;
        }
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * 
     * 
     */
    public void decrease()
    {
        switch(mode)
        {
            case RessourcePlanning.MODE_HEBDO :
                System.err.println("On ne doit pas pouvoir lancer cette action en mode hebdo !!!");
                break;
            case RessourcePlanning.MODE_MULTI :
                System.err.println("On ne doit pas pouvoir lancer cette action en mode multi !!!");
                break;
            case RessourcePlanning.MODE_TRIM :
                if(planningTrim.getModel().getNbWeeks() == 2)
                {
                    this.switchToHebdo();
                }
                else
                {
                    System.out.println("decrease() en mode Trim");
                    planningTrim.decrease();
                }
                break;
                    
        }
    }
    


    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * 
     * 
     */
    public void increase()
    {
        switch(mode)
        {
            case RessourcePlanning.MODE_HEBDO :
                this.switchToTrim();
                break;
            case RessourcePlanning.MODE_MULTI :
                System.err.println("On ne doit pas pouvoir lancer cette action en mode multi !!!");
                break;
            case RessourcePlanning.MODE_TRIM :
                System.out.println("increase() en mode Trim");
                planningTrim.increase();
                break;
        }
    }


    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * 
     */
    public void stepOver()
    {
        switch(mode)
        {
            case RessourcePlanning.MODE_HEBDO :
                System.out.println("stepOver() en mode Hebdo");
                //planningHebdo.fullStepBack();
                break;
            case RessourcePlanning.MODE_MULTI :
                System.err.println("On ne doit pas pouvoir lancer cette action en mode multi !!!");
                break;
            case RessourcePlanning.MODE_TRIM :
                System.out.println("stepOver() en mode Trim");
                planningTrim.stepOver();
                break;
        }
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * 
     */
    public void fullStepOver()
    {
        switch(mode)
        {
            case RessourcePlanning.MODE_HEBDO :
                System.out.println("fullStepOver() en mode Hebdo");
                //planningHebdo.fullStepBack();
                break;
            case RessourcePlanning.MODE_MULTI :
                System.err.println("On ne doit pas pouvoir lancer cette action en mode multi !!!");
                break;
            case RessourcePlanning.MODE_TRIM :
                System.out.println("fullStepOver() en mode Trim");
                planningTrim.fullStepOver();
                break;
        }
    }
}

