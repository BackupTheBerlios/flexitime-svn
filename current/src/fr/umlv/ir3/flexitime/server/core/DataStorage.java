/*
 * Created on 2 févr. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * 
 */
public class DataStorage
{
    
    private static ConcurrentHashMap<Long, Object> map = new ConcurrentHashMap<Long, Object>();
    private static ConcurrentHashMap<Class, HashSet<Object>> comap = new ConcurrentHashMap<Class, HashSet<Object>>();
    
    public static void putIfAbsent(Long id, Object obj)
    {
        System.out.println("DataStorage: putting " + obj);
        map.putIfAbsent(id, obj);
        
        HashSet<Object> tree = comap.get(obj.getClass().getInterfaces()[0]);
        if(tree == null)
        {
            tree = new HashSet<Object>();
            comap.put(obj.getClass().getInterfaces()[0], tree);
        }
        
        tree.add(obj);
        
    }
    
    public static List get(Class c)
    {
        HashSet t = comap.get(c);
        if(t==null)
            return null;
        
        return new ArrayList(t);
    }
    
    public static Object get(Long id)
    {
        return map.get(id);
    }
    
    public static void addBuildings(Collection<IBuilding> lb)
    {
        for(IBuilding b: lb)
        {
            putIfAbsent(b.getIdData(), b);
            addFloors(b.getLstFloor());
            
        }
    }
    
    public static void addFloors(List<IFloor> lf)
    {
        for(IFloor f : lf)
        {
            putIfAbsent(f.getIdData(), f);
            addRooms(f.getLstRoom());
        }
    }
    
    public static void addRooms(Collection<IRoom> cr)
    {
        for(IRoom r : cr)
        {
            putIfAbsent(r.getIdData(), r);
            //addBusies(r.getSetBusy());
        }
    }

    public static void addBusies(Collection<IBusy> cb)
    {
        for(IBusy bu : cb)
        {
            putIfAbsent(bu.getIdBusy(), bu);
            
//            if(bu instanceof ILesson)
//            {
//                for(IResource re : ((ILesson)bu).getAllResources())
//                {
//                    
//                }
//            }
        }
    }
    
    public static void addTeachers(Collection<ITeacher> ct)
    {
        for(ITeacher t : ct)
        {
            putIfAbsent(t.getIdData(), t);
            //addBusies(t.getSetBusy());
        }
    }
    
    public static void addDevices(Collection<IDevice> cd)
    {
        for(IDevice d : cd)
        {
            putIfAbsent(d.getIdData(), d);
            //addBusies(d.getSetBusy());
        }
    }
    
    public static void addTracks(Collection<ITrack> ct)
    {
        for(ITrack t : ct)
        {
            putIfAbsent(t.getIdData(), t);
            addClasses(t.getLstClass());
        }
    }
    
    public static void addClasses(Collection<IClass> cc)
    {
        for(IClass c : cc)
        {
            putIfAbsent(c.getIdData(), c);
            addGroups(c.getLstGroups());
            addTeachingStructure(c.getTeachingStructure());
        }
    }
    
    public static void addGroups(Collection<IGroup> cg)
    {
        for(IGroup g : cg)
        {
            putIfAbsent(g.getIdData(), g);
            //addBusies(g.getSetBusy());
        }
    }
    
    public static void addTeachingStructure(ITeachingStructure ts)
    {
        if(ts == null)
            return;
        putIfAbsent(ts.getIdData(), ts);
        addSubjectsGroups(ts.getLstSubjectsGroup());
    }
    
    public static void addSubjectsGroups(Collection<ISubjectsGroup> csg)
    {
        for(ISubjectsGroup sg : csg)
        {
            putIfAbsent(sg.getIdData(), sg);
            addSubjects(sg.getLstSubject());
        }
    }
    
    public static void addSubjects(Collection<ISubject> cs)
    {
        for(ISubject s : cs)
        {
            putIfAbsent(s.getIdData(), s);
            addCourses(s.getLstCourse());
        }
    }
    
    public static void addCourses(Collection<ICourse> cc)
    {
        for(ICourse c : cc)
        {
            putIfAbsent(c.getIdData(), c);
        }
    }
}

