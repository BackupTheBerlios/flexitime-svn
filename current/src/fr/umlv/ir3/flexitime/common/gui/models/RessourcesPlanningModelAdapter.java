/*
 * Created on 21 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.gui.models;

import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.resources.IResource;
import fr.umlv.ir3.flexitime.common.tools.Gap;


/**
 * Adapter using <code>RessourcePlanningModel</code> to manage severals ressources in severals weeks
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * 
 * @author FlexiTeam - binou
 */
public class RessourcesPlanningModelAdapter
{
    
    
    private final List<IResource> ressourceList;
    private List<RessourcePlanningModel> models;

    /**
     * DOCME
     * @param ressourceList
     * @param initialGap
     */
    public RessourcesPlanningModelAdapter(List<IResource> ressourceList, Gap initialGap)
    {
        this.ressourceList = ressourceList;
        if(ressourceList == null)
            System.err.println("RessourcesPlanningModelAdapter() : erreur de construction du model");
        
        this.models = new ArrayList<RessourcePlanningModel>(ressourceList.size());

        
        for(IResource ress : ressourceList)
            models.add(new RessourcePlanningModel(ress, initialGap));
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
    public Object getElementAt(int ressNumber, int blocNumber, int weekNumber, int dayNumber)
    {
        //TODO attention le gamNumber ne sera ptete pas le meme (BlocNumber en fait)
        int gapNumber = blocNumber;
        return models.get(ressNumber).getElementAt(weekNumber,dayNumber,gapNumber);
    }

}

