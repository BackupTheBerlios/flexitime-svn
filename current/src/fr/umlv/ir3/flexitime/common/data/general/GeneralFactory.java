/*
 * Created on 18 janv. 2005
 * by Jérôme GUERS
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.general;

import fr.umlv.ir3.flexitime.common.data.general.impl.*;

/**
 * Create all general objects from specific parameters. This class contains only statics
 * methods to create each types of admin objects.
 * 
 * @version 204
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class GeneralFactory
{
    /**
     * Create a new Building with the given name
     *
     * @param name the name of the new building
     * @return a new Building naming <code>name</code> 
     */
    public static IBuilding createBuilding(String name)
    {
        return new BuildingImpl(name);
    }
    
     /**
     * Create a new class with the given name and add it to the parent Track 
     *
     * @param name the name of the class
     * @param parent the track to which this class belong
     * @return a new Class 
     */
    public static IClass createClass(String name, ITrack parent)
    {
        IClass class1 = new ClassImpl(name, parent);
        parent.addClass(class1);
        return class1;
    }
    
    /**
     * Create a new floor with the given name and add it to the parent building 
     *
     * @param name the name of the floor
     * @param parent the building to which this floor belong
     * @return a new Class 
     */
    public static IFloor createFloor(String name, IBuilding parent)
    {
        IFloor floor = new FloorImpl(name, parent);
        parent.addFloor(floor);
        return floor;
    }
    
    /**
     * Create a new Track with the given name 
     *
     * @param name the name of the track
     * @return a new Class 
     */
    public static ITrack createTrack(String name)
    {
        return new TrackImpl(name);
    }
}

