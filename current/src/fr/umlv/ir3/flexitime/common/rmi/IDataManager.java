/*
 * Created on 4 janv. 2005
 * by Pr�sad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

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

/**
 * Interface for all Data managers extends Remote to be called remotely
 * 
 * @version 1.0
 * @see java.rmi.Remote
 * @author FlexiTeam - Pr�sad
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
    public boolean saveOrUpdateBuilding(IBuilding building) throws RemoteException;

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
     */
    public boolean deleteBuilding(IBuilding building) throws RemoteException;

    /**
     * Adds a Data created by a client Have to save Data and fire the add
     * 
     * @param _class
     * @return true if OK
     * @throws RemoteException
     */
    public boolean saveOrUpdateClass(IClass _class) throws RemoteException;

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
     */
    public boolean deleteClass(IClass _class) throws RemoteException;

    /**
     * Adds a Data created by a client Have to save Data and fire the add
     * 
     * @param course
     * @return true if OK
     * @throws RemoteException
     */
    public boolean saveOrUpdateCourse(ICourse course) throws RemoteException;

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
     */
    public boolean deleteCourse(ICourse course) throws RemoteException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param device 
     * @return true if OK
     * @throws RemoteException 
     */
    public boolean saveOrUpdateDevice(IDevice device) throws RemoteException;
    
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
     */
    public boolean deleteDevice(IDevice device) throws RemoteException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param floor 
     * @return true if OK
     * @throws RemoteException 
     */
    public boolean saveOrUpdateFloor(IFloor floor) throws RemoteException;
    
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
     */
    public boolean deleteFloor(IFloor floor) throws RemoteException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param group 
     * @return true if OK
     * @throws RemoteException 
     */
    public boolean saveOrUpdateGroup(IGroup group) throws RemoteException;
    
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
     */
    public boolean deleteGroup(IGroup group) throws RemoteException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param lesson 
     * @return true if OK
     * @throws RemoteException 
     */
    public boolean saveOrUpdateLesson(ILesson lesson) throws RemoteException;
    
    /**
     *  
     * get all datas managed by this manager
     * @param group 
     * @return all datas
     * @throws RemoteException 
     */
    public List<ILesson> getLessons(IGroup group) throws RemoteException; 
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
     * @return true if OK
     * @throws RemoteException 
     */
    public boolean saveOrUpdateRoom(IRoom room) throws RemoteException;
    
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
     */
    public boolean deleteRoom(IRoom room) throws RemoteException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param subject 
     * @return true if OK
     * @throws RemoteException 
     */
    public boolean saveOrUpdateSubject(ISubject subject) throws RemoteException;
    
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
     */
    public boolean deleteSubject(ISubject subject) throws RemoteException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param subjectsGroup 
     * @return true if OK
     * @throws RemoteException 
     */
    public boolean saveOrUpdateSubjectsGroup(ISubjectsGroup subjectsGroup) throws RemoteException;
    
    /**
     *  
     * get all datas managed by this manager
     * @param _class 
     * @return all datas
     * @throws RemoteException 
     */
    public List<ISubjectsGroup> getSubjectsGroup(IClass _class) throws RemoteException; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param subjectsGroup 
     * @return true if OK
     * @throws RemoteException 
     */
    public boolean deleteSubjectsGroup(ISubjectsGroup subjectsGroup) throws RemoteException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param teacher 
     * @return true if OK
     * @throws RemoteException 
     */
    public boolean saveOrUpdateTeacher(ITeacher teacher) throws RemoteException;
    
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
     */
    public boolean deleteTeacher(ITeacher teacher) throws RemoteException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param teachingStructure 
     * @return true if OK
     * @throws RemoteException 
     */
    public boolean saveOrUpdateTeachingStructure(ITeachingStructure teachingStructure) throws RemoteException;
    
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
     */
    public boolean deleteTeachingStructure(ITeachingStructure teachingStructure) throws RemoteException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param track 
     * @return true if OK
     * @throws RemoteException 
     */
    public boolean saveOrUpdateTrack(ITrack track) throws RemoteException;
    
    /**
     *  
     * get all datas managed by this manager
     * @return all datas
     * @throws RemoteException 
     */
    public List<ITrack> getTracks() throws RemoteException; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param track 
     * @return true if OK
     * @throws RemoteException 
     */
    public boolean deleteTrack(ITrack track) throws RemoteException;
}
