/*
 * Created on 4 janv. 2005
 * by Pr�sad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.rmi;

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
 * @author FlexiTeam - Pr�sad
 */
public interface IDataManager
{

    /**
     * adds a listener to the list
     * 
     * @param _class TODO
     * @param l listener to be added
     */
    public void addDataListener(Class _class, IDataListener l)
            ;

    /**
     * removes a listener from the list
     * 
     * @param _class TODO
     * @param l IDataListener to be removed
     */
    public void removeDataListener(Class _class, IDataListener l)
            ;

    /**
     * locks a data
     * 
     * @param d data to lock
     * @return true if data can be locked, flase otherwise
     * @ if not reachable
     */
    public boolean lock(Object d);

    /**
     * unlocks a data
     * 
     * @param d Data to unlock
     * @ if not reachable
     */
    public void unlock(Object d) ;

    /**
     * Adds a Data created by a client Have to save Data and fire the add
     * 
     * @param building
     * @return true if OK
     * @throws FlexiException 
     */
    public IBuilding saveOrUpdateBuilding(IBuilding building) throws FlexiException ;

    /**
     * get all datas managed by this manager
     * 
     * @return all datas
     * @throws FlexiException 
     */
    public List<IBuilding> getBuildings() throws FlexiException ;

    /**
     * removes a data have to delete data from storage and inform clients
     * 
     * @param building
     * @return true if OK
     * @throws FlexiException 
     */
    public boolean deleteBuilding(IBuilding building) throws FlexiException;

    /**
     * Adds a Data created by a client Have to save Data and fire the add
     * @param _class
     * @param parent TODO
     * 
     * @return true if OK
     * @throws FlexiException 

     */
    public IClass saveOrUpdateClass(IClass _class, ITrack parent) throws FlexiException ;

    /**
     * get all datas managed by this manager
     * 
     * @param track
     * @return all datas
     * @
     */
    //public List<IClass> getClasses(ITrack track) ;

    /**
     * removes a data have to delete data from storage and inform clients
     * 
     * @param _class
     * @return true if OK
     * @throws FlexiException 
     */
    public boolean deleteClass(IClass _class) throws FlexiException;

    /**
     * Adds a Data created by a client Have to save Data and fire the add
     * @param course
     * @param parent TODO
     * 
     * @return true if OK
     * @throws FlexiException 
     */
    public ICourse saveOrUpdateCourse(ICourse course, ISubject parent) throws FlexiException ;

    /**
     * get all datas managed by this manager
     * 
     * @param subject
     * @return all datas
     */
    //public List<ICourse> getCourses(ISubject subject) ;

    /**
     * removes a data have to delete data from storage and inform clients
     * 
     * @param course
     * @return true if OK
     * @throws FlexiException 
     */
    public boolean deleteCourse(ICourse course) throws FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param device 
     * @return true if OK
     * @throws FlexiException 
     */
    public IDevice saveOrUpdateDevice(IDevice device) throws FlexiException ;
    
    /**
     *  
     * get all datas managed by this manager
     * @return all datas
     * @throws FlexiException 
     */
    public List<IDevice> getDevices() throws FlexiException ; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param device 
     * @return true if OK
     * @throws FlexiException 
     */
    public boolean deleteDevice(IDevice device) throws FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param floor 
     * @param param TODO
     * @return true if OK
     * @throws FlexiException 
     */
    public IFloor saveOrUpdateFloor(IFloor floor, IBuilding param) throws FlexiException ;
    
    /**
     *  
     * get all datas managed by this manager
     * @param building 
     * @return all datas
     */
    //public List<IFloor> getFloors(IBuilding building) ; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param floor 
     * @return true if OK
     * @throws FlexiException 
     */
    public boolean deleteFloor(IFloor floor) throws FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param group 
     * @param parent TODO
     * @return true if OK
     * @throws FlexiException 
     */
    public IGroup saveOrUpdateGroup(IGroup group, IClass parent) throws FlexiException ;
    
    /**
     *  
     * get all datas managed by this manager
     * @param _class 
     * @return all datas
     */
    //public List<IGroup> getGroups(IClass _class) ; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param group 
     * @return true if OK
     * @throws FlexiException 
     */
    public boolean deleteGroup(IGroup group) throws FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param lesson 
     * @param lresource TODO
     * @return true if OK
     */
    //public ILesson saveOrUpdateLesson(ILesson lesson, List<IResource> lresource) ;
    
    
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param lesson 
     * @return true if OK
     * @throws FlexiException 
     */
    public boolean deleteLesson(ILesson lesson) throws FlexiException ;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param room 
     * @param parent TODO
     * @return true if OK
     * @throws FlexiException 
     */
    public IRoom saveOrUpdateRoom(IRoom room, IFloor parent) throws FlexiException ;
    
    /**
     *  
     * get all datas managed by this manager
     * @param floor 
     * @return all datas
     */
    //public List<IRoom> getRooms(IFloor floor) ; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param room 
     * @return true if OK
     * @throws FlexiException 
     */
    public boolean deleteRoom(IRoom room) throws FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param subject 
     * @param parent TODO
     * @return true if OK
     * @throws FlexiException 
     */
    public ISubject saveOrUpdateSubject(ISubject subject, ISubjectsGroup parent) throws FlexiException ;
    
    /**
     *  
     * get all datas managed by this manager
     * @param subjectsGroup 
     * @return all datas
     */
    //public List<ISubject> getSubjects(ISubjectsGroup subjectsGroup) ; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param subject 
     * @return true if OK
     * @throws FlexiException 
     */
    public boolean deleteSubject(ISubject subject) throws FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param subjectsGroup 
     * @param parent TODO
     * @return true if OK
     * @throws FlexiException 
     */
    public ISubjectsGroup saveOrUpdateSubjectsGroup(ISubjectsGroup subjectsGroup, ITeachingStructure parent) throws FlexiException ;
    
    /**
     *  
     * get all datas managed by this manager
     * @param ts 
     * @return all datas
     */
    //public List<ISubjectsGroup> getSubjectsGroup(ITeachingStructure ts) ; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param subjectsGroup 
     * @return true if OK
     * @throws FlexiException 
     */
    public boolean deleteSubjectsGroup(ISubjectsGroup subjectsGroup) throws FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param teacher 
     * @return true if OK
     * @throws FlexiException 
     */
    public ITeacher saveOrUpdateTeacher(ITeacher teacher) throws FlexiException ;
    
    /**
     *  
     * get all datas managed by this manager
     * @return all datas
     * @throws FlexiException 
     */
    public List<ITeacher> getTeachers() throws FlexiException ; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param teacher 
     * @return true if OK
     * @throws FlexiException 
     */
    public boolean deleteTeacher(ITeacher teacher) throws FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param teachingStructure 
     * @param parent TODO
     * @return true if OK
     * @throws FlexiException 
     */
    public ITeachingStructure saveOrUpdateTeachingStructure(ITeachingStructure teachingStructure, IClass parent) throws FlexiException ;
    
    /**
     *  
     * get all datas managed by this manager
     * @param _class 
     * @return all datas
     */
    //public ITeachingStructure getTeachingStructure(IClass _class) ; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param teachingStructure 
     * @return true if OK
     * @throws FlexiException 
     */
    public boolean deleteTeachingStructure(ITeachingStructure teachingStructure) throws FlexiException;
    
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * @param track 
     * @return true if OK
     * @throws FlexiException 
     */
    public ITrack saveOrUpdateTrack(ITrack track) throws FlexiException ;
    
    /**
     *  
     * get all datas managed by this manager
     * @param user 
     * @return all datas
     * @throws FlexiException 
     */
    public List<ITrack> getTracks(IUser user) throws FlexiException ; 
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * @param track 
     * @return true if OK
     * @throws FlexiException 
     */
    public boolean deleteTrack(ITrack track) throws FlexiException;
    
    
    /**
     * @param b
     * @param parent
     * @return IBusy
     */
    public IBusy saveOrUpdateResourceBusy(IBusy b, IResource parent) ;
    /**
     * @param b
     * @param parent
     * @return true if OK
     * @throws FlexiException 
     * 
     */
    public boolean deleteResourceBusy(IBusy b, IResource parent) throws FlexiException;
    
    /**
     * 
     * @param parent
     * @return List of busies
     * @throws FlexiException 
     */
    public List<IBusy> getBusies(Long idResource, Class c) throws FlexiException ;
    
    
    //POUR LES TEST//
    /**
     * @return IGroup
     * 
     */
    public IGroup getGroup() ;
    
    public IClass getClassFromId(Long idClass) throws FlexiException ;
    
    public List<IRoom> getRooms() ;
}
