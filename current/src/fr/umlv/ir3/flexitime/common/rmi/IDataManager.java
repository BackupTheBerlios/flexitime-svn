/*
 * Created on 4 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

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
import fr.umlv.ir3.flexitime.common.exception.FlexiException;

/**
 * Interface for all Data managers extends Remote to be called remotely
 * 
 * @version 1.0
 * @see java.rmi.Remote
 * @author FlexiTeam - Prâsad
 */
public interface IDataManager extends Remote
{

    /**
     * adds a listener to the list
     * 
     * @param _class TODO
     * @param l listener to be added
     * @throws RemoteException if not reachable
     */
    public void addDataListener(Class _class, IDataListener l)
            throws RemoteException;

    /**
     * removes a listener from the list
     * 
     * @param _class TODO
     * @param l IDataListener to be removed
     * @throws RemoteException if not reachable
     */
    public void removeDataListener(Class _class, IDataListener l)
            throws RemoteException;

    /**
     * locks a data
     * 
     * @param d data to lock
     * @return true if data can be locked, flase otherwise
     * @throws RemoteException if not reachable
     * @throws InterruptedException
     */
    public boolean lock(Object d) throws RemoteException, InterruptedException;

    /**
     * unlocks a data
     * 
     * @param d Data to unlock
     * @throws RemoteException if not reachable
     */
    public void unlock(Object d) throws RemoteException;

    /**
     * Adds a Data created by a client Have to save Data and fire the add
     * 
     * @param building
     * @return true if OK
     * @throws RemoteException
     */
    public IBuilding saveOrUpdateBuilding(IBuilding building) throws RemoteException;

    /**
     * get all datas managed by this manager
     * 
     * @return all datas
     * @throws RemoteException
     */
    public List<IBuilding> getBuildings() throws RemoteException;

    /**
     * removes a data have to delete data from storage and inform clients
     * 
     * @param building
     * @return true if OK
     * @throws RemoteException
     * @throws FlexiException 
     */
    public boolean deleteBuilding(IBuilding building) throws RemoteException, FlexiException;

    /**
     * Adds a Data created by a client Have to save Data and fire the add
     * @param _class
     * @param parent TODO
     * 
     * @return true if OK
     * @throws RemoteException
     */
    public IClass saveOrUpdateClass(IClass _class, ITrack parent) throws RemoteException;

    /**
     * get all datas managed by this manager
     * 
     * @param track
     * @return all datas
     * @throws RemoteException
     */
    public List<IClass> getClasses(ITrack track) throws RemoteException;

    /**
     * removes a data have to delete data from storage and inform clients
     * 
     * @param _class
     * @return true if OK
     * @throws RemoteException
     * @throws FlexiException 
     */
    public boolean deleteClass(IClass _class) throws RemoteException, FlexiException;

    /**
     * Adds a Data created by a client Have to save Data and fire the add
     * @param course
     * @param parent TODO
     * 
     * @return true if OK
     * @throws RemoteException
     */
    public ICourse saveOrUpdateCourse(ICourse course, ISubject parent) throws RemoteException;

    /**
     * get all datas managed by this manager
     * 
     * @param subject
     * @return all datas
     * @throws RemoteException
     */
    public List<ICourse> getCourses(ISubject subject) throws RemoteException;

    /**
     * removes a data have to delete data from storage and inform clients
     * 
     * @param course
     * @return true if OK
     * @throws RemoteException
     * @throws FlexiException 
     */
    public boolean deleteCourse(ICourse course) throws RemoteException, FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param device 
     * @return true if OK
     * @throws RemoteException 
     */
    public IDevice saveOrUpdateDevice(IDevice device) throws RemoteException;
    
    /**
     *  
     * get all datas managed by this manager
     * @return all datas
     * @throws RemoteException 
     */
    public List<IDevice> getDevices() throws RemoteException; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param device 
     * @return true if OK
     * @throws RemoteException 
     * @throws FlexiException 
     */
    public boolean deleteDevice(IDevice device) throws RemoteException, FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param floor 
     * @param param TODO
     * @return true if OK
     * @throws RemoteException 
     */
    public IFloor saveOrUpdateFloor(IFloor floor, IBuilding param) throws RemoteException;
    
    /**
     *  
     * get all datas managed by this manager
     * @param building 
     * @return all datas
     * @throws RemoteException 
     */
    public List<IFloor> getFloors(IBuilding building) throws RemoteException; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param floor 
     * @return true if OK
     * @throws RemoteException 
     * @throws FlexiException 
     */
    public boolean deleteFloor(IFloor floor) throws RemoteException, FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param group 
     * @param parent TODO
     * @return true if OK
     * @throws RemoteException 
     */
    public IGroup saveOrUpdateGroup(IGroup group, IClass parent) throws RemoteException;
    
    /**
     *  
     * get all datas managed by this manager
     * @param _class 
     * @return all datas
     * @throws RemoteException 
     */
    public List<IGroup> getGroups(IClass _class) throws RemoteException; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param group 
     * @return true if OK
     * @throws RemoteException 
     * @throws FlexiException 
     */
    public boolean deleteGroup(IGroup group) throws RemoteException, FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param lesson 
     * @param lresource TODO
     * @return true if OK
     * @throws RemoteException 
     */
    public ILesson saveOrUpdateLesson(ILesson lesson, List<IResource> lresource) throws RemoteException;
    
    
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param lesson 
     * @return true if OK
     * @throws RemoteException 
     */
    public boolean deleteLesson(ILesson lesson) throws RemoteException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param room 
     * @param parent TODO
     * @return true if OK
     * @throws RemoteException 
     */
    public IRoom saveOrUpdateRoom(IRoom room, IFloor parent) throws RemoteException;
    
    /**
     *  
     * get all datas managed by this manager
     * @param floor 
     * @return all datas
     * @throws RemoteException 
     */
    public List<IRoom> getRooms(IFloor floor) throws RemoteException; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param room 
     * @return true if OK
     * @throws RemoteException 
     * @throws FlexiException 
     */
    public boolean deleteRoom(IRoom room) throws RemoteException, FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param subject 
     * @param parent TODO
     * @return true if OK
     * @throws RemoteException 
     */
    public ISubject saveOrUpdateSubject(ISubject subject, ISubjectsGroup parent) throws RemoteException;
    
    /**
     *  
     * get all datas managed by this manager
     * @param subjectsGroup 
     * @return all datas
     * @throws RemoteException 
     */
    public List<ISubject> getSubjects(ISubjectsGroup subjectsGroup) throws RemoteException; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param subject 
     * @return true if OK
     * @throws RemoteException 
     * @throws FlexiException 
     */
    public boolean deleteSubject(ISubject subject) throws RemoteException, FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param subjectsGroup 
     * @param parent TODO
     * @return true if OK
     * @throws RemoteException 
     */
    public ISubjectsGroup saveOrUpdateSubjectsGroup(ISubjectsGroup subjectsGroup, ITeachingStructure parent) throws RemoteException;
    
    /**
     *  
     * get all datas managed by this manager
     * @param ts 
     * @return all datas
     * @throws RemoteException 
     */
    public List<ISubjectsGroup> getSubjectsGroup(ITeachingStructure ts) throws RemoteException; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param subjectsGroup 
     * @return true if OK
     * @throws RemoteException 
     * @throws FlexiException 
     */
    public boolean deleteSubjectsGroup(ISubjectsGroup subjectsGroup) throws RemoteException, FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param teacher 
     * @return true if OK
     * @throws RemoteException 
     */
    public ITeacher saveOrUpdateTeacher(ITeacher teacher) throws RemoteException;
    
    /**
     *  
     * get all datas managed by this manager
     * @return all datas
     * @throws RemoteException 
     */
    public List<ITeacher> getTeachers() throws RemoteException; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param teacher 
     * @return true if OK
     * @throws RemoteException 
     * @throws FlexiException 
     */
    public boolean deleteTeacher(ITeacher teacher) throws RemoteException, FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param teachingStructure 
     * @param parent TODO
     * @return true if OK
     * @throws RemoteException 
     */
    public ITeachingStructure saveOrUpdateTeachingStructure(ITeachingStructure teachingStructure, IClass parent) throws RemoteException;
    
    /**
     *  
     * get all datas managed by this manager
     * @param _class 
     * @return all datas
     * @throws RemoteException 
     */
    public ITeachingStructure getTeachingStructure(IClass _class) throws RemoteException; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param teachingStructure 
     * @return true if OK
     * @throws RemoteException 
     * @throws FlexiException 
     */
    public boolean deleteTeachingStructure(ITeachingStructure teachingStructure) throws RemoteException, FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param track 
     * @return true if OK
     * @throws RemoteException 
     */
    public ITrack saveOrUpdateTrack(ITrack track) throws RemoteException;
    
    /**
     *  
     * get all datas managed by this manager
     * @param user 
     * @return all datas
     * @throws RemoteException 
     */
    public List<ITrack> getTracks(IUser user) throws RemoteException; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param track 
     * @return true if OK
     * @throws RemoteException 
     * @throws FlexiException 
     */
    public boolean deleteTrack(ITrack track) throws RemoteException, FlexiException;
    
    
    /**
     * @param b
     * @param parent
     * @return IBusy
     * @throws RemoteException 
     * 
     */
    public IBusy saveOrUpdateResourceBusy(IBusy b, IResource parent) throws RemoteException;
    /**
     * @param b
     * @param parent
     * @return true if OK
     * @throws RemoteException 
     * @throws FlexiException 
     * 
     */
    public boolean deleteResourceBusy(IBusy b, IResource parent) throws RemoteException, FlexiException;
    
    /**
     * 
     * @param parent
     * @return List of busies
     * @throws RemoteException
     */
    public List<IBusy> getBusies(Long idResource, Class c) throws RemoteException;
    
    
    //POUR LES TEST//
    /**
     * @return IGroup
     * @throws RemoteException 
     * 
     */
    public IGroup getGroup() throws RemoteException;
    
    public IClass getClassFromId(Long idClass) throws RemoteException;
    
    public List<IRoom> getRooms() throws RemoteException;
}
