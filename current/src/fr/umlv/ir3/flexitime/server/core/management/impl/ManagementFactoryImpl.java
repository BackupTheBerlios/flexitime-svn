/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import fr.umlv.ir3.flexitime.common.data.general.*;
import fr.umlv.ir3.flexitime.common.data.ressources.*;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.*;
import fr.umlv.ir3.flexitime.server.core.management.*;


/**
 * ManagementFactoryImpl - Implementation of the abstract class ManagementFactory
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public class ManagementFactoryImpl extends ManagementFactory{
    /**
     * createTeacher - creates a teacher
     * 
     *     <code>Teacher t = myFactory.createTeacher("name")</code>
     *
     * @param name name of the teacher
     * @return a Teacher
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    public Teacher createTeacher(String name){
        return null;
        
    }
    /**
     * createRoom - creates a room
     * 
     *     <code>Room r = myFactory.createRoom("name", aFloor)</code>
     *
     * @param name name of the room
     * @param floor floor which the room depends
     * @return a Room
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    /* A VOIR Rooms = Room */
    public Rooms createRoom(String name, Floor floor) {
        return null;
    }
    /**
     * createDevice - creates a device
     * 
     *     <code>Device d = myFactory.createDevice("name")</code>
     *
     * @param name name of the device
     * @return a Device
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    public Device createDevice(String name) {
        return null;
    }
    /**
     * createGroup - creates a group
     * 
     *     <code>Group g = myFactory.createGroup("name", aPromotion)A VOIR</code>
     *
     * @param name name of the group
     * @param promotion promotion which the group depends
     * @return a Group
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    /* A VOIR Groups = Group */
    /* A VOIR Promotion = ?? */
    public Groups createGroup(String name, Promotion promotion) {
        return null;
    }
    /**
     * createTrack - creates a Track
     * 
     *     <code>Track t = myFactory.createTrack("name")</code>
     *
     * @param name name of the track
     * @return a Track
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    /* A VOIR  Filere = Track */
    public Filiere createTrack(String name) {
        return null;
    } 
    /**
     * createPromotion - creates a Promotion A VOIR
     * 
     *     <code>Promotion p = myFactory.createPromotion("name", aTrack) A VOIR</code>
     *
     * @param name name of the promotion A VOIR
     * @return a Promotion A VOIR
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    /* A VOIR Promotion = ?? */
    public Promotion createPromotion(String name) {
        return null;
    } 
    /**
     * createBloc - create a bloc
     * 
     *     <code>Bloc b = myFactory.createBloc("name", aPromotion)A VOIR</code>
     *
     * @param name name of the bloc
     * @param promotion promotion which the bloc depends
     * @return a BLoc
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    /* A VOIR Promotion = ?? */
    public Bloc createBloc(String name, Promotion promotion) {
        return null;
    } 
    /**
     * createMatiere - creates a matiere A VOIR
     * 
     *     <code>Matiere m = myFactory.createMatiere("name", aBloc)A VOIR</code>
     *
     * @param name name of the matiere A VOIR
     * @param bloc bloc which the matiere depends
     * @return a Bloc
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    /* A VOIR Matiere = Subject */
    public Matiere createMatiere(String name, Bloc bloc) {
        return null;
    } 
    /**
     * createCourse - create a course
     * 
     *     <code>Cours c = myFactory.createCourse("name", aMatiere) A VOIR</code>
     *
     * @param name name of the course
     * @param matiere matiere which the course depends
     * @return a Course
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    /* A VOIR Cours = Course */
    /* A VOIR Matiere = Subject */
    public Cours createCourse(String name, Matiere matiere) {
        return null;
    } 
    /**
     * createBuilding - creates a building
     * 
     *     <code>Building b = myFactory.createBuilding("name")</code>
     *
     * @param name name of the building
     * @return a Building
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    public Building createBuilding(String name) {
        return null;
    } 
    /**
     * createFloor - creates a floor
     * 
     *     <code>Floor f = myFactory.createFloor("name", aBuilding)</code>
     *
     * @param name name of the floor
     * @param building building which the floor depends
     * @return a Floor
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    public Floor createFloor(String name, Building building) {
        return null;
    } 


}
