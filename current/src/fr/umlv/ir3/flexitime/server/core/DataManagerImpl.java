/*
 * Created on 20 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import net.sf.hibernate.HibernateException;

import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
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
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.IDataListener;
import fr.umlv.ir3.flexitime.common.rmi.IDataManager;
import fr.umlv.ir3.flexitime.server.io.storage.BuildingStorage;
import fr.umlv.ir3.flexitime.server.io.storage.FloorStorage;
import fr.umlv.ir3.flexitime.server.io.storage.RoomStorage;

/**
 * DOCME Description explication supplémentaire si nécessaire in english
 * please... Que fait cette classe, qu'est-ce qu'elle représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 */
public class DataManagerImpl implements IDataManager
{

    protected final EventManager manager = new EventManager();

    /**
     * adds a listener to the list
     * 
     * @param _class Class that the listener listen to
     * @param l listener to be added
     * @throws RemoteException if not reachable
     */
    public void addDataListener(Class _class, IDataListener l)
            throws RemoteException
    {
        manager.addDataListener(_class, l);
    }

    /**
     * removes a listener from the list
     * 
     * @param _class Class that the listener listen to
     * @param l IDataListener to be removed
     * @throws RemoteException if not reachable
     */
    public void removeDataListener(Class _class, IDataListener l)
            throws RemoteException
    {
        // FIXME Vérifier les références pour la suppression
        manager.removeDataListener(_class, l);
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param d
     * @return true if Object can be locked
     * @throws RemoteException
     * @throws InterruptedException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#lock(java.lang.Object)
     */
    public boolean lock(Object d) throws RemoteException, InterruptedException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param d
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#unlock(java.lang.Object)
     */
    public void unlock(Object d) throws RemoteException
    {
    // TODO Auto-generated method stub

    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param building
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateBuilding(fr.umlv.ir3.flexitime.common.data.general.IBuilding)
     */
    public boolean saveOrUpdateBuilding(IBuilding building)
            throws RemoteException
    {
        boolean save;
        if (building.getIdData() != null)
            save = false;
        else
            save = true;

        try
        {
            BuildingStorage.save(building);
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            return false;
        }
        int type = save ? DataEvent.TYPE_PROPERTY_ADDED
                : DataEvent.TYPE_PROPERTY_CHANGED;

        manager.fireDataChanged(IBuilding.class, new DataEvent(building,
                "", type)); //$NON-NLS-1$
        return true;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getBuildings()
     */
    public List<IBuilding> getBuildings() throws RemoteException
    {
        List<IBuilding> l;
        try
        {
            l = BuildingStorage.get();
        }
        catch (HibernateException e)
        {

            e.printStackTrace();
            l = new ArrayList<IBuilding>();
        }
        return l;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param building
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteBuilding(fr.umlv.ir3.flexitime.common.data.general.IBuilding)
     */
    public boolean deleteBuilding(IBuilding building) throws RemoteException
    {
        try
        {
            BuildingStorage.delete((IBuilding) building);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        manager.fireDataChanged(IBuilding.class, new DataEvent(building,
                "", DataEvent.TYPE_PROPERTY_REMOVED)); //$NON-NLS-1$
        return true;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param _class
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateClass(fr.umlv.ir3.flexitime.common.data.general.IClass)
     */
    public boolean saveOrUpdateClass(IClass _class) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param track
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getClasses(fr.umlv.ir3.flexitime.common.data.general.ITrack)
     */
    public List<IClass> getClasses(ITrack track) throws RemoteException
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param _class
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteClass(fr.umlv.ir3.flexitime.common.data.general.IClass)
     */
    public boolean deleteClass(IClass _class) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param course
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateCourse(fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse)
     */
    public boolean saveOrUpdateCourse(ICourse course) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param subject
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getCourses(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject)
     */
    public List<ICourse> getCourses(ISubject subject) throws RemoteException
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param course
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteCourse(fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse)
     */
    public boolean deleteCourse(ICourse course) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param device
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateDevice(fr.umlv.ir3.flexitime.common.data.resources.IDevice)
     */
    public boolean saveOrUpdateDevice(IDevice device) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getDevices()
     */
    public List<IDevice> getDevices() throws RemoteException
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param device
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteDevice(fr.umlv.ir3.flexitime.common.data.resources.IDevice)
     */
    public boolean deleteDevice(IDevice device) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param floor
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateFloor(fr.umlv.ir3.flexitime.common.data.general.IFloor)
     */
    public boolean saveOrUpdateFloor(IFloor floor) throws RemoteException
    {
        int type = floor.getIdData() == null ? DataEvent.TYPE_PROPERTY_ADDED
                : DataEvent.TYPE_PROPERTY_CHANGED;

        try
        {
            BuildingStorage.save(floor.getParentBuilding());
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

        int indices = floor.getParentBuilding().getLstFloor().indexOf(floor);
        manager
                .fireDataChanged(
                        IBuilding.class,
                        new DataEvent(
                                floor.getParentBuilding(),
                                "lstFloor", type, new Object[] { floor }, new int[] { indices })); //$NON-NLS-1$

        return true;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param building
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getFloors(fr.umlv.ir3.flexitime.common.data.general.IBuilding)
     */
    public List<IFloor> getFloors(IBuilding building) throws RemoteException
    {
        List<IFloor> l;

        try
        {
            l = FloorStorage.get((IBuilding) building);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            l = new ArrayList<IFloor>();
        }
        return l;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param floor
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteFloor(fr.umlv.ir3.flexitime.common.data.general.IFloor)
     */
    public boolean deleteFloor(IFloor floor) throws RemoteException
    {
        int indice = floor.getParentBuilding().getLstFloor().indexOf(floor);

        try
        {
            FloorStorage.delete(floor);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

        manager
                .fireDataChanged(
                        IBuilding.class,
                        new DataEvent(
                                floor.getParentBuilding(),
                                "lstFloor", DataEvent.TYPE_PROPERTY_REMOVED, new Object[] { floor }, new int[] { indice })); //$NON-NLS-1$

        return true;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param group
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateGroup(fr.umlv.ir3.flexitime.common.data.resources.IGroup)
     */
    public boolean saveOrUpdateGroup(IGroup group) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param _class
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getGroups(fr.umlv.ir3.flexitime.common.data.general.IClass)
     */
    public List<IGroup> getGroups(IClass _class) throws RemoteException
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param group
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteGroup(fr.umlv.ir3.flexitime.common.data.resources.IGroup)
     */
    public boolean deleteGroup(IGroup group) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param lesson
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateLesson(fr.umlv.ir3.flexitime.common.data.activity.ILesson)
     */
    public boolean saveOrUpdateLesson(ILesson lesson) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param group
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getLessons(fr.umlv.ir3.flexitime.common.data.resources.IGroup)
     */
    public List<ILesson> getLessons(IGroup group) throws RemoteException
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param lesson
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteLesson(fr.umlv.ir3.flexitime.common.data.activity.ILesson)
     */
    public boolean deleteLesson(ILesson lesson) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param room
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateRoom(fr.umlv.ir3.flexitime.common.data.resources.IRoom)
     */
    public boolean saveOrUpdateRoom(IRoom room) throws RemoteException
    {
        int type = room.getIdData() == null ? DataEvent.TYPE_PROPERTY_ADDED
                : DataEvent.TYPE_PROPERTY_CHANGED;

        try
        {
            FloorStorage.save(room.getFloor());
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        int indices = room.getFloor().getLstRoom().indexOf(room);

        manager.fireDataChanged(IFloor.class, new DataEvent(room.getFloor(),
                "lstRoom", type, new Object[] { room }, new int[] { indices })); //$NON-NLS-1$
        return true;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param floor
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getRooms(fr.umlv.ir3.flexitime.common.data.general.IFloor)
     */
    public List<IRoom> getRooms(IFloor floor) throws RemoteException
    {
        List<IRoom> l;
        try
        {
            l = RoomStorage.get(floor);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            l = new ArrayList<IRoom>();
        }
        return l;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param room
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteRoom(fr.umlv.ir3.flexitime.common.data.resources.IRoom)
     */
    public boolean deleteRoom(IRoom room) throws RemoteException
    {
        int indice = room.getFloor().getLstRoom().indexOf(room);

        try
        {
            RoomStorage.delete(room);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

        manager
                .fireDataChanged(
                        IFloor.class,
                        new DataEvent(
                                room.getFloor(),
                                "lstRoom", DataEvent.TYPE_PROPERTY_REMOVED, new Object[] { room }, new int[] { indice })); //$NON-NLS-1$

        return true;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param subject
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject)
     */
    public boolean saveOrUpdateSubject(ISubject subject) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param subjectsGroup
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getSubjects(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup)
     */
    public List<ISubject> getSubjects(ISubjectsGroup subjectsGroup)
            throws RemoteException
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param subject
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject)
     */
    public boolean deleteSubject(ISubject subject) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param subjectsGroup
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateSubjectsGroup(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup)
     */
    public boolean saveOrUpdateSubjectsGroup(ISubjectsGroup subjectsGroup)
            throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param _class
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getSubjectsGroup(fr.umlv.ir3.flexitime.common.data.general.IClass)
     */
    public List<ISubjectsGroup> getSubjectsGroup(IClass _class)
            throws RemoteException
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param subjectsGroup
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteSubjectsGroup(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup)
     */
    public boolean deleteSubjectsGroup(ISubjectsGroup subjectsGroup)
            throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param teacher
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateTeacher(fr.umlv.ir3.flexitime.common.data.resources.ITeacher)
     */
    public boolean saveOrUpdateTeacher(ITeacher teacher) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getTeachers()
     */
    public List<ITeacher> getTeachers() throws RemoteException
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param teacher
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteTeacher(fr.umlv.ir3.flexitime.common.data.resources.ITeacher)
     */
    public boolean deleteTeacher(ITeacher teacher) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param teachingStructure
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateTeachingStructure(fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure)
     */
    public boolean saveOrUpdateTeachingStructure(
            ITeachingStructure teachingStructure) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param _class
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getTeachingStructure(fr.umlv.ir3.flexitime.common.data.general.IClass)
     */
    public ITeachingStructure getTeachingStructure(IClass _class)
            throws RemoteException
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param teachingStructure
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteTeachingStructure(fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure)
     */
    public boolean deleteTeachingStructure(ITeachingStructure teachingStructure)
            throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param track
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateTrack(fr.umlv.ir3.flexitime.common.data.general.ITrack)
     */
    public boolean saveOrUpdateTrack(ITrack track) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getTracks()
     */
    public List<ITrack> getTracks() throws RemoteException
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param track
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteTrack(fr.umlv.ir3.flexitime.common.data.general.ITrack)
     */
    public boolean deleteTrack(ITrack track) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

}
