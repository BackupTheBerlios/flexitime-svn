/*
 * Created on 20 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.DataProxy;
import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.admin.IUser;
import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.IResource;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.event.EventManager;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.admin.IConfigurationManager;
import fr.umlv.ir3.flexitime.common.rmi.admin.IUserManager;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;

/**
 * Singleton used for communication with the server
 */
public class LocalDataManager implements IDataManager
{

    private static LocalDataManager  localManager;

    //private static RemoteDataManager remoteManager;

    protected EventManager           eventManager = new EventManager();

    private class RemoteListener extends UnicastRemoteObject implements
            IRemoteDataListener
    {

        /**
         * DOCME
         * 
         * @throws RemoteException
         */
        protected RemoteListener() throws RemoteException
        {
            super();
            // TODO Auto-generated constructor stub
        }

        /**
         * Comment for <code>serialVersionUID</code>
         */
        private static final long serialVersionUID = 3258689918581945910L;

        /**
         * DOCME Description Quel service est rendu par cette méthode
         * <code>exemple d'appel de la methode</code>
         * 
         * @param event
         * @throws RemoteException
         * @see fr.umlv.ir3.flexitime.common.rmi.IRemoteDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
         */
        public void dataChanged(DataEvent event) throws RemoteException
        {
        // TODO Auto-generated method stub

        }

    }

    public static LocalDataManager getManager()
    {
        if(RemoteDataManager.getManager() == null)
            return null;
        if (localManager == null)
        {
            localManager = new LocalDataManager();
//            RemoteListener r = new RemoteListener();
//            remoteManager.getManager().
            
        }

        return localManager;
    }

    public static IUserManager getUserManager()
    {
        return RemoteDataManager.getUserManager();
    }

    public static void setIpServer(String ip)
    {
        RemoteDataManager.setIpServer(ip);
    }

    public static IConfigurationManager getConfigurationManager()
    {
        return RemoteDataManager.getConfigurationManager();
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param _class
     * @param l
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#addDataListener(java.lang.Class,
     *      fr.umlv.ir3.flexitime.common.rmi.IDataListener)
     */
    public void addDataListener(Class _class, IDataListener l)
    {
        eventManager.addDataListener(_class, l);
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param _class
     * @param l
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#removeDataListener(java.lang.Class,
     *      fr.umlv.ir3.flexitime.common.rmi.IDataListener)
     */
    public void removeDataListener(Class _class, IDataListener l)
    {
        eventManager.removeDataListener(_class, l);
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param d
     * @return
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#lock(java.lang.Object)
     */
    public boolean lock(Object d)
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param d
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#unlock(java.lang.Object)
     */
    public void unlock(Object d)
    {
    // TODO Auto-generated method stub

    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param building
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateBuilding(fr.umlv.ir3.flexitime.common.data.general.IBuilding)
     */
    public IBuilding saveOrUpdateBuilding(IBuilding building) throws FlexiException
    {
        try
        {
            
            return RemoteDataManager.getManager().saveOrUpdateBuilding(building);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getBuildings()
     */
    public List<IBuilding> getBuildings() throws FlexiException
    {
        List<IBuilding> l = DataProxy.get(IBuilding.class);
        if (l != null) return l;

        try
        {
            l =  RemoteDataManager.getManager().getBuildings();
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
        
        DataProxy.addBuildings(l);
        return l;

    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param building
     * @return
     * @throws FlexiException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteBuilding(fr.umlv.ir3.flexitime.common.data.general.IBuilding)
     */
    public boolean deleteBuilding(IBuilding building) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().deleteBuilding(building);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
        
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param _class
     * @param parent
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateClass(fr.umlv.ir3.flexitime.common.data.general.IClass,
     *      fr.umlv.ir3.flexitime.common.data.general.ITrack)
     */
    public IClass saveOrUpdateClass(IClass _class, ITrack parent) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().saveOrUpdateClass(_class, parent);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param track
     * @return
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getClasses(fr.umlv.ir3.flexitime.common.data.general.ITrack)
     */
    public List<IClass> getClasses(ITrack track)
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
     * @throws FlexiException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteClass(fr.umlv.ir3.flexitime.common.data.general.IClass)
     */
    public boolean deleteClass(IClass _class) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().deleteClass(_class);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
        
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param course
     * @param parent
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateCourse(fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse,
     *      fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject)
     */
    public ICourse saveOrUpdateCourse(ICourse course, ISubject parent) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().saveOrUpdateCourse(course, parent);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param subject
     * @return
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getCourses(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject)
     */
    public List<ICourse> getCourses(ISubject subject)
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
     * @throws FlexiException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteCourse(fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse)
     */
    public boolean deleteCourse(ICourse course) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().deleteCourse(course);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
        
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param device
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateDevice(fr.umlv.ir3.flexitime.common.data.resources.IDevice)
     */
    public IDevice saveOrUpdateDevice(IDevice device) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().saveOrUpdateDevice(device);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getDevices()
     */
    public List<IDevice> getDevices() throws FlexiException
    {
        List<IDevice> l = DataProxy.get(IDevice.class);
        if(l != null)
            return l;
        
        try
        {
            l = RemoteDataManager.getManager().getDevices();
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
        
        DataProxy.addDevices(l);
        return l;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param device
     * @return
     * @throws FlexiException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteDevice(fr.umlv.ir3.flexitime.common.data.resources.IDevice)
     */
    public boolean deleteDevice(IDevice device) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().deleteDevice(device);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param floor
     * @param param
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateFloor(fr.umlv.ir3.flexitime.common.data.general.IFloor,
     *      fr.umlv.ir3.flexitime.common.data.general.IBuilding)
     */
    public IFloor saveOrUpdateFloor(IFloor floor, IBuilding param) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().saveOrUpdateFloor(floor, param);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param building
     * @return
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getFloors(fr.umlv.ir3.flexitime.common.data.general.IBuilding)
     */
    public List<IFloor> getFloors(IBuilding building)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param floor
     * @return
     * @throws FlexiException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteFloor(fr.umlv.ir3.flexitime.common.data.general.IFloor)
     */
    public boolean deleteFloor(IFloor floor) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().deleteFloor(floor);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }

    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param group
     * @param parent
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateGroup(fr.umlv.ir3.flexitime.common.data.resources.IGroup,
     *      fr.umlv.ir3.flexitime.common.data.general.IClass)
     */
    public IGroup saveOrUpdateGroup(IGroup group, IClass parent) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().saveOrUpdateGroup(group, parent);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param _class
     * @return
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getGroups(fr.umlv.ir3.flexitime.common.data.general.IClass)
     */
    public List<IGroup> getGroups(IClass _class)
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
     * @throws FlexiException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteGroup(fr.umlv.ir3.flexitime.common.data.resources.IGroup)
     */
    public boolean deleteGroup(IGroup group) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().deleteGroup(group);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
        
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param lesson
     * @param lresource
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateLesson(fr.umlv.ir3.flexitime.common.data.activity.ILesson,
     *      java.util.List)
     */
    public ILesson saveOrUpdateLesson(ILesson lesson, List<IResource> lresource) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().saveOrUpdateLesson(lesson, lresource);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param lesson
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteLesson(fr.umlv.ir3.flexitime.common.data.activity.ILesson)
     */
    public boolean deleteLesson(ILesson lesson) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().deleteLesson(lesson);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param room
     * @param parent
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateRoom(fr.umlv.ir3.flexitime.common.data.resources.IRoom,
     *      fr.umlv.ir3.flexitime.common.data.general.IFloor)
     */
    public IRoom saveOrUpdateRoom(IRoom room, IFloor parent) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().saveOrUpdateRoom(room, parent);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param floor
     * @return
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getRooms(fr.umlv.ir3.flexitime.common.data.general.IFloor)
     */
    public List<IRoom> getRooms(IFloor floor)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param room
     * @return
     * @throws FlexiException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteRoom(fr.umlv.ir3.flexitime.common.data.resources.IRoom)
     */
    public boolean deleteRoom(IRoom room) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().deleteRoom(room);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param subject
     * @param parent
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject,
     *      fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup)
     */
    public ISubject saveOrUpdateSubject(ISubject subject, ISubjectsGroup parent) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().saveOrUpdateSubject(subject, parent);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param subjectsGroup
     * @return
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getSubjects(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup)
     */
    public List<ISubject> getSubjects(ISubjectsGroup subjectsGroup)
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
     * @throws FlexiException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject)
     */
    public boolean deleteSubject(ISubject subject) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().deleteSubject(subject);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param subjectsGroup
     * @param parent
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateSubjectsGroup(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup,
     *      fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure)
     */
    public ISubjectsGroup saveOrUpdateSubjectsGroup(
            ISubjectsGroup subjectsGroup, ITeachingStructure parent) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().saveOrUpdateSubjectsGroup(subjectsGroup, parent);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param ts
     * @return
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getSubjectsGroup(fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure)
     */
    public List<ISubjectsGroup> getSubjectsGroup(ITeachingStructure ts)
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
     * @throws FlexiException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteSubjectsGroup(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup)
     */
    public boolean deleteSubjectsGroup(ISubjectsGroup subjectsGroup)
            throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().deleteSubjectsGroup(subjectsGroup);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param teacher
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateTeacher(fr.umlv.ir3.flexitime.common.data.resources.ITeacher)
     */
    public ITeacher saveOrUpdateTeacher(ITeacher teacher) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().saveOrUpdateTeacher(teacher);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getTeachers()
     */
    public List<ITeacher> getTeachers() throws FlexiException
    {
        List<ITeacher> l = DataProxy.get(ITeacher.class);
        if(l != null)
            return l;
        
        try
        {
            l = RemoteDataManager.getManager().getTeachers();
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
        
        DataProxy.addTeachers(l);
        return l;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param teacher
     * @return
     * @throws FlexiException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteTeacher(fr.umlv.ir3.flexitime.common.data.resources.ITeacher)
     */
    public boolean deleteTeacher(ITeacher teacher) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().deleteTeacher(teacher);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
        
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param teachingStructure
     * @param parent
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateTeachingStructure(fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure,
     *      fr.umlv.ir3.flexitime.common.data.general.IClass)
     */
    public ITeachingStructure saveOrUpdateTeachingStructure(
            ITeachingStructure teachingStructure, IClass parent) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().saveOrUpdateTeachingStructure(teachingStructure, parent);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param _class
     * @return
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getTeachingStructure(fr.umlv.ir3.flexitime.common.data.general.IClass)
     */
    public ITeachingStructure getTeachingStructure(IClass _class)
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
     * @throws FlexiException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteTeachingStructure(fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure)
     */
    public boolean deleteTeachingStructure(ITeachingStructure teachingStructure)
            throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().deleteTeachingStructure(teachingStructure);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param track
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateTrack(fr.umlv.ir3.flexitime.common.data.general.ITrack)
     */
    public ITrack saveOrUpdateTrack(ITrack track) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().saveOrUpdateTrack(track);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param user
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getTracks(fr.umlv.ir3.flexitime.common.data.admin.IUser)
     */
    public List<ITrack> getTracks(IUser user) throws FlexiException
    {
        List<ITrack> l = DataProxy.get(ITrack.class);
        if(l != null)
            return l;
        
        try
        {
            l = RemoteDataManager.getManager().getTracks(user);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
        
        DataProxy.addTracks(l);
        return l;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param track
     * @return
     * @throws FlexiException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteTrack(fr.umlv.ir3.flexitime.common.data.general.ITrack)
     */
    public boolean deleteTrack(ITrack track) throws FlexiException
    {
        try
        {
            return RemoteDataManager.getManager().deleteTrack(track);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param b
     * @param parent
     * @return
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateResourceBusy(fr.umlv.ir3.flexitime.common.data.activity.IBusy,
     *      fr.umlv.ir3.flexitime.common.data.resources.IResource)
     */
    public IBusy saveOrUpdateResourceBusy(IBusy b, IResource parent)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param b
     * @param parent
     * @return
     * @throws FlexiException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteResourceBusy(fr.umlv.ir3.flexitime.common.data.activity.IBusy,
     *      fr.umlv.ir3.flexitime.common.data.resources.IResource)
     */
    public boolean deleteResourceBusy(IBusy b, IResource parent)
            throws FlexiException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param idResource
     * @param c
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getBusies(java.lang.Long,
     *      java.lang.Class)
     */
    public List<IBusy> getBusies(Long idResource, Class c) throws FlexiException
    {
        
        try
        {
            return RemoteDataManager.getManager().getBusies(idResource, c);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @return
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getGroup()
     */
    public IGroup getGroup()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param idClass
     * @return
     * @throws FlexiException 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getClassFromId(java.lang.Long)
     */
    public IClass getClassFromId(Long idClass) throws FlexiException
    {
        
        try
        {
            return RemoteDataManager.getManager().getClassFromId(idClass);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @return
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getRooms()
     */
    public List<IRoom> getRooms()
    {
        List<IRoom> l = DataProxy.get(IRoom.class);
        if(l != null)
            return l;
        try
        {
            l = RemoteDataManager.getManager().getRooms();
        }
        catch (RemoteException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
