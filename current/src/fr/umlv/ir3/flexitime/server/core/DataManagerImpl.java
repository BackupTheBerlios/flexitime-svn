/*
 * Created on 20 janv. 2005
 * by Pr�sad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.activity.IDeviceBusy;
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
import fr.umlv.ir3.flexitime.common.data.resources.impl.ResourceImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.IDataListener;
import fr.umlv.ir3.flexitime.common.rmi.IRemoteDataManager;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.server.io.storage.BuildingStorage;
import fr.umlv.ir3.flexitime.server.io.storage.BusyStorage;
import fr.umlv.ir3.flexitime.server.io.storage.ClassStorage;
import fr.umlv.ir3.flexitime.server.io.storage.CourseStorage;
import fr.umlv.ir3.flexitime.server.io.storage.DeviceStorage;
import fr.umlv.ir3.flexitime.server.io.storage.FloorStorage;
import fr.umlv.ir3.flexitime.server.io.storage.GroupStorage;
import fr.umlv.ir3.flexitime.server.io.storage.HibernateUtil;
import fr.umlv.ir3.flexitime.server.io.storage.LessonStorage;
import fr.umlv.ir3.flexitime.server.io.storage.RoomStorage;
import fr.umlv.ir3.flexitime.server.io.storage.SubjectStorage;
import fr.umlv.ir3.flexitime.server.io.storage.SubjectsGroupStorage;
import fr.umlv.ir3.flexitime.server.io.storage.TeacherStorage;
import fr.umlv.ir3.flexitime.server.io.storage.TeachingStructureStorage;
import fr.umlv.ir3.flexitime.server.io.storage.TrackStorage;

/**
 * Implementation of IDataListener Exposed via RMI in order to be contacted by
 * clients
 */
public class DataManagerImpl extends UnicastRemoteObject implements
        IRemoteDataManager
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long    serialVersionUID = 3257562889115088182L;
    protected final EventManager manager          = new EventManager();

    /**
     * Default constructor export object so that it can be called via RMI
     * 
     * @throws RemoteException if a error occurs when exporting the object
     */
    public DataManagerImpl() throws RemoteException
    {
        super();
    }

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
        //manager.addDataListener(_class, l);
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
        // FIXME V�rifier les r�f�rences pour la suppression
        //manager.removeDataListener(_class, l);
    }

    /**
     * DOCME Description Quel service est rendu par cette m�thode
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
        return true;
    }

    /**
     * DOCME Description Quel service est rendu par cette m�thode
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
     * @param building
     * @return IBuilding
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateBuilding(fr.umlv.ir3.flexitime.common.data.general.IBuilding)
     */
    public IBuilding saveOrUpdateBuilding(IBuilding building)
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
            return null;
        }
        int type = save ? DataEvent.TYPE_PROPERTY_ADDED
                : DataEvent.TYPE_PROPERTY_CHANGED;

        manager.fireDataChanged(new DataEvent(building, "", type)); //$NON-NLS-1$
        return building;
    }

    /**
     * @return a list of IBuilding
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getBuildings()
     */
    public List<IBuilding> getBuildings() throws RemoteException
    {
        List<IBuilding> l = DataStorage.get(IBuilding.class);
        if (l != null) return l;
        try
        {
            l = BuildingStorage.get();
        }
        catch (HibernateException e)
        {

            e.printStackTrace();
            l = new ArrayList<IBuilding>();
        }
        DataStorage.addBuildings(l);
        return l;
    }

    /**
     * @param building
     * @return true if OK
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteBuilding(fr.umlv.ir3.flexitime.common.data.general.IBuilding)
     */
    public boolean deleteBuilding(IBuilding building) throws RemoteException,
            FlexiException
    {
        try
        {
            BuildingStorage.delete((IBuilding) building);
        }
        catch (HibernateException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText(
                    "buildingDeletion"), e); //$NON-NLS-1$
        }
        manager.fireDataChanged(new DataEvent(building,
                "", DataEvent.TYPE_PROPERTY_REMOVED)); //$NON-NLS-1$
        return true;
    }

    /**
     * @param _class
     * @return IClass
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateClass(fr.umlv.ir3.flexitime.common.data.general.IClass,
     *      ITrack)
     */
    public IClass saveOrUpdateClass(IClass _class, ITrack parent)
            throws RemoteException
    {
        int type;
        if (_class.getIdData() == null)
        {
            type = DataEvent.TYPE_PROPERTY_SUBDATA_ADDED;
            parent.addClass(_class);
        }
        else
            type = DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED;

        try
        {
            TrackStorage.save(parent);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        int indices = _class.getParentTrack().getLstClass().indexOf(_class);
        manager
                .fireDataChanged(new DataEvent(
                        _class.getParentTrack(),
                        "lstClass", type, new Object[] { _class }, new int[] { indices })); //$NON-NLS-1$

        return _class;
    }

    /**
     * @param track
     * @return list of IClass
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getClasses(fr.umlv.ir3.flexitime.common.data.general.ITrack)
     */
    public List<IClass> getClasses(ITrack track) throws RemoteException
    {
        List<IClass> l;

        try
        {
            l = ClassStorage.get(track);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            l = new ArrayList<IClass>();
        }
        return l;
    }

    /**
     * @param _class
     * @return true if OK
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteClass(fr.umlv.ir3.flexitime.common.data.general.IClass)
     */
    public boolean deleteClass(IClass _class) throws RemoteException,
            FlexiException
    {
        int indice = _class.getParentTrack().getLstClass().indexOf(_class);

        try
        {
            // TeachingStructureStorage.delete(_class.getTeachingStructure());
            ClassStorage.delete(_class);
        }
        catch (HibernateException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText(
                    "classDeletion"), e); //$NON-NLS-1$
        }

        manager
                .fireDataChanged(new DataEvent(
                        _class.getParentTrack(),
                        "lstClass", DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED, new Object[] { _class }, new int[] { indice })); //$NON-NLS-1$

        return true;
    }

    /**
     * @param course
     * @return ICourse
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateCourse(fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse,
     *      ISubject)
     */
    public ICourse saveOrUpdateCourse(ICourse course, ISubject parent)
            throws RemoteException
    {
        int type;
        if (course.getIdData() == null)
        {
            type = DataEvent.TYPE_PROPERTY_SUBDATA_ADDED;
            parent.addCourse(course);
        }
        else
            type = DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED;

        try
        {
            SubjectStorage.save(parent);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        int indices = course.getParentSubject().getLstCourse().indexOf(course);
        manager
                .fireDataChanged(new DataEvent(
                        course.getParentSubject(),
                        "lstCourse", type, new Object[] { course }, new int[] { indices })); //$NON-NLS-1$

        return course;
    }

    /**
     * @param subject
     * @return list of ICourse
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getCourses(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject)
     */
    public List<ICourse> getCourses(ISubject subject) throws RemoteException
    {
        List<ICourse> l;

        try
        {
            l = CourseStorage.get(subject);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            l = new ArrayList<ICourse>();
        }
        return l;
    }

    /**
     * @param course
     * @return true if OK
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteCourse(fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse)
     */
    public boolean deleteCourse(ICourse course) throws RemoteException,
            FlexiException
    {
        int indice = course.getParentSubject().getLstCourse().indexOf(course);

        try
        {
            course.getParentSubject().removeCourse(course);
            // CourseStorage.delete(course);
            SubjectStorage.save(course.getParentSubject());
        }
        catch (HibernateException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText(
                    "courseDeletion"), e); //$NON-NLS-1$
        }

        manager
                .fireDataChanged(new DataEvent(
                        course.getParentSubject(),
                        "lstCourse", DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED, new Object[] { course }, new int[] { indice })); //$NON-NLS-1$

        return true;
    }

    /**
     * @param device
     * @return IDevice
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateDevice(fr.umlv.ir3.flexitime.common.data.resources.IDevice)
     */
    public IDevice saveOrUpdateDevice(IDevice device) throws RemoteException
    {
        int type = device.getIdData() == null ? DataEvent.TYPE_PROPERTY_ADDED
                : DataEvent.TYPE_PROPERTY_CHANGED;

        try
        {
            DeviceStorage.save(device);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        manager.fireDataChanged(new DataEvent(device, "", type)); //$NON-NLS-1$

        return device;
    }

    /**
     * @return list of IDevice
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getDevices()
     */
    public List<IDevice> getDevices() throws RemoteException
    {
        List<IDevice> l = DataStorage.get(IDevice.class);
        if (l != null) return l;
        try
        {
            l = DeviceStorage.get();
        }
        catch (HibernateException e)
        {

            e.printStackTrace();
            l = new ArrayList<IDevice>();
        }
        DataStorage.addDevices(l);
        return l;
    }

    /**
     * @param device
     * @return true if OK
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteDevice(fr.umlv.ir3.flexitime.common.data.resources.IDevice)
     */
    public boolean deleteDevice(IDevice device) throws RemoteException,
            FlexiException
    {
        try
        {
            DeviceStorage.delete(device);
        }
        catch (HibernateException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText(
                    "deviceDeletion"), e); //$NON-NLS-1$
        }
        manager.fireDataChanged(new DataEvent(device,
                "", DataEvent.TYPE_PROPERTY_REMOVED)); //$NON-NLS-1$
        return true;
    }

    /**
     * @param floor
     * @return IFloor
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateFloor(fr.umlv.ir3.flexitime.common.data.general.IFloor,
     *      IBuilding)
     */
    public IFloor saveOrUpdateFloor(IFloor floor, IBuilding parent)
            throws RemoteException
    {
        int type;
        if (floor.getIdData() == null)
        {
            type = DataEvent.TYPE_PROPERTY_SUBDATA_ADDED;
            parent.addFloor(floor);
        }
        else
            type = DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED;

        try
        {
            BuildingStorage.save(floor.getParentBuilding());
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        System.err.println(floor.getIdData());
        int indices = floor.getParentBuilding().getLstFloor().indexOf(floor);
        manager
                .fireDataChanged(new DataEvent(
                        floor.getParentBuilding(),
                        "lstFloor", type, new Object[] { floor }, new int[] { indices })); //$NON-NLS-1$

        return floor;
    }

    /**
     * @param building
     * @return list of IFloor
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
     * @param floor
     * @return ture if OK
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteFloor(fr.umlv.ir3.flexitime.common.data.general.IFloor)
     */
    public boolean deleteFloor(IFloor floor) throws RemoteException,
            FlexiException
    {
        int indice = floor.getParentBuilding().getLstFloor().indexOf(floor);

        try
        {
            FloorStorage.delete(floor);
        }
        catch (HibernateException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText(
                    "floorDeletion"), e); //$NON-NLS-1$
        }

        manager
                .fireDataChanged(new DataEvent(
                        floor.getParentBuilding(),
                        "lstFloor", DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED, new Object[] { floor }, new int[] { indice })); //$NON-NLS-1$

        return true;
    }

    /**
     * @param group
     * @return IGroup
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateGroup(fr.umlv.ir3.flexitime.common.data.resources.IGroup,
     *      IClass)
     */
    public IGroup saveOrUpdateGroup(IGroup group, IClass parent)
            throws RemoteException
    {
        int type;
        if (group.getIdData() == null)
        {
            type = DataEvent.TYPE_PROPERTY_SUBDATA_ADDED;
            parent.addGroup(group);
        }
        else
            type = DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED;

        try
        {
            ClassStorage.save(parent);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        int indices = group.getParentClass().getLstGroups().indexOf(group);
        manager
                .fireDataChanged(new DataEvent(
                        group.getParentClass(),
                        "lstClass", type, new Object[] { group }, new int[] { indices })); //$NON-NLS-1$

        return group;
    }

    /**
     * @param _class
     * @return list of IGroup
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getGroups(fr.umlv.ir3.flexitime.common.data.general.IClass)
     */
    public List<IGroup> getGroups(IClass _class) throws RemoteException
    {
        List<IGroup> l;

        try
        {
            l = GroupStorage.get(_class);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            l = new ArrayList<IGroup>();
        }
        return l;
    }

    /**
     * @param group
     * @return true if OK
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteGroup(fr.umlv.ir3.flexitime.common.data.resources.IGroup)
     */
    public boolean deleteGroup(IGroup group) throws RemoteException,
            FlexiException
    {
        int indice = group.getParentClass().getLstGroups().indexOf(group);

        try
        {
            GroupStorage.delete(group);
        }
        catch (HibernateException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText(
                    "groupDeletion"), e); //$NON-NLS-1$
        }

        manager
                .fireDataChanged(new DataEvent(
                        group.getParentClass(),
                        "lstGroup", DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED, new Object[] { group }, new int[] { indice })); //$NON-NLS-1$

        return true;
    }

    public Long saveLesson(ILesson lesson, Long[] idR) throws RemoteException
    {
        try
        {
            LessonStorage.save(lesson, idR);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        for (int i = 0 ; i < idR.length ; i++)
        {
            IResource r;
            if ( ( r = (IResource) DataStorage.get(idR[i]) ) == null)
            {

                try
                {
                    Session s = HibernateUtil.currentSession();
                    r = (IResource) s.load(ResourceImpl.class, idR[i]);
                    DataStorage.putIfAbsent(idR[i], r);
                }
                catch (HibernateException e1)
                {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                finally
                {
                    try
                    {
                        HibernateUtil.closeSession();
                    }
                    catch (HibernateException e2)
                    {
                        // TODO Auto-generated catch block
                        e2.printStackTrace();
                    }
                }
            }
            manager
                    .fireDataChanged(new DataEvent(
                            r,
                            "setBusy", DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED, new Object[] { lesson })); //$NON-NLS-1$
        }

        return lesson.getIdBusy();

    }

    /**
     * @param lesson
     * @param lresource
     * @return ILesson
     * @throws RemoteException
     */
    public ILesson saveOrUpdateLesson(ILesson lesson, List<IResource> lresource)
            throws RemoteException
    {
        System.err.println("Appel de saveLesson");
        boolean newOne = ( lesson.getIdBusy() == null );
        // int type = lesson.getIdBusy() == null ?
        // DataEvent.TYPE_PROPERTY_SUBDATA_ADDED
        // : DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED;

        int type[] = new int[lresource.size()];
        int i = 0;
        for (IResource elem : lresource)
        {
            type[i] = lesson.addResource(elem) ? DataEvent.TYPE_PROPERTY_SUBDATA_ADDED
                    : DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED;
            ++i;
        }

        // Sauvegarde de la lesson
        try
        {
            LessonStorage.save(lesson);
        }
        catch (HibernateException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        i = 0;
        for (IResource elem : lresource)
        {
            // Class c = null;
            // if (elem instanceof IDevice)
            // c = IDevice.class;
            // else if (elem instanceof IGroup)
            // c = IGroup.class;
            // else if (elem instanceof IRoom)
            // c = IRoom.class;
            // else if (elem instanceof ITeacher) c = ITeacher.class;

            manager.fireDataChanged(new DataEvent(elem, "setBusy", type[i],
                    new Object[] { lesson }));
            ++i;
        }

        // Mise � jour des ressources associ�es
        i = 0;
        // for (IResource r : lresource)
        // {
        // if (r instanceof IGroup)
        // {
        // IGroup g = (IGroup) r;
        // if (newOne || !g.getSetBusy().contains(lesson))
        // {
        // // g.addBusy(lesson);
        // lesson.addResource(g);
        // }
        // try
        // {
        // GroupStorage.save(g);
        // }
        // catch (HibernateException e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // return null;
        // }
        //
        // manager.fireDataChanged(IGroup.class, new DataEvent(g,
        // "lstBusy", type[i], new Object[] { lesson }));
        //
        // }
        // else if (r instanceof IDevice)
        // {
        // IDevice d = (IDevice) r;
        // if (newOne || !d.getSetBusy().contains(lesson))
        // d.addBusy(lesson);
        // try
        // {
        // DeviceStorage.save(d);
        // }
        // catch (HibernateException e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // return null;
        // }
        //
        // manager.fireDataChanged(IDevice.class, new DataEvent(d,
        // "lstBusy", type[i], new Object[] { lesson }));
        //
        // }
        // else if (r instanceof IRoom)
        // {
        // IRoom ro = (IRoom) r;
        // if (newOne || !ro.getSetBusy().contains(lesson))
        // ro.addBusy(lesson);
        // try
        // {
        // RoomStorage.save(ro);
        // }
        // catch (HibernateException e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // return null;
        // }
        // manager.fireDataChanged(IRoom.class, new DataEvent(ro,
        // "lstBusy", type[i], new Object[] { lesson }));
        // }
        // else if (r instanceof ITeacher)
        // {
        // ITeacher t = (ITeacher) r;
        // if (newOne || !t.getSetBusy().contains(lesson))
        // t.addBusy(lesson);
        // try
        // {
        // TeacherStorage.save(t);
        // }
        // catch (HibernateException e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // return null;
        // }
        // manager.fireDataChanged(ITeacher.class, new DataEvent(t,
        // "lstBusy", type[i], new Object[] { lesson }));
        //
        // }
        //            
        // ++i;
        //
        // }

        // for (Iterator<IGroup> it = lesson.getLstGroup().iterator() ; it
        // .hasNext() ;)
        // {
        // IGroup g = it.next();
        // try
        // {
        // GroupStorage.save(g);
        // }
        // catch (HibernateException e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // return null;
        // }
        //
        // manager.fireDataChanged(IGroup.class, new DataEvent(g, "lstBusy",
        // type, new Object[] { lesson }));
        //
        // }
        //
        // for (Iterator<IDevice> it = lesson.getLstDevice().iterator() ; it
        // .hasNext() ;)
        // {
        // IDevice d = it.next();
        // try
        // {
        // DeviceStorage.save(d);
        // }
        // catch (HibernateException e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // return null;
        // }
        // manager.fireDataChanged(IDevice.class, new DataEvent(d, "lstBusy",
        // type, new Object[] { lesson }));
        //
        // }
        //
        // for (Iterator<IRoom> it = lesson.getLstRoom().iterator() ;
        // it.hasNext() ;)
        // {
        // IRoom r = it.next();
        // try
        // {
        // RoomStorage.save(r);
        // }
        // catch (HibernateException e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // return null;
        // }
        // manager.fireDataChanged(IRoom.class, new DataEvent(r, "lstBusy",
        // type, new Object[] { lesson }));
        //
        // }
        //
        // for (Iterator<ITeacher> it = lesson.getLstTeacher().iterator() ; it
        // .hasNext() ;)
        // {
        // ITeacher t = it.next();
        // try
        // {
        // TeacherStorage.save(t);
        // }
        // catch (HibernateException e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // return null;
        // }
        // manager.fireDataChanged(ITeacher.class, new DataEvent(t, "lstBusy",
        // type, new Object[] { lesson }));
        //
        // }

        return lesson;
    }

    /**
     * DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param lesson
     * @return true if OK
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteLesson(fr.umlv.ir3.flexitime.common.data.activity.ILesson)
     */
    public boolean deleteLesson(ILesson lesson) throws RemoteException
    {
        for (Iterator<IGroup> it = lesson.getSetGroup().iterator() ; it
                .hasNext() ;)
        {
            IGroup g = it.next();
            try
            {
                g.getSetBusy().remove(lesson);
                GroupStorage.save(g);
            }
            catch (HibernateException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
            manager.fireDataChanged(new DataEvent(g, "lstBusy",
                    DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED,
                    new Object[] { lesson }));

        }

        for (Iterator<IDevice> it = lesson.getSetDevice().iterator() ; it
                .hasNext() ;)
        {
            IDevice d = it.next();
            try
            {
                d.getSetBusy().remove(lesson);
                DeviceStorage.save(d);
            }
            catch (HibernateException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
            manager.fireDataChanged(new DataEvent(d, "lstBusy",
                    DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED,
                    new Object[] { lesson }));

        }

        for (Iterator<IRoom> it = lesson.getSetRoom().iterator() ; it.hasNext() ;)
        {
            IRoom r = it.next();
            try
            {
                r.getSetBusy().remove(lesson);
                RoomStorage.save(r);
            }
            catch (HibernateException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
            manager.fireDataChanged(new DataEvent(r, "lstBusy",
                    DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED,
                    new Object[] { lesson }));

        }

        for (Iterator<ITeacher> it = lesson.getSetTeacher().iterator() ; it
                .hasNext() ;)
        {

            ITeacher t = it.next();
            try
            {
                t.getSetBusy().remove(lesson);
                TeacherStorage.save(t);
            }
            catch (HibernateException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
            manager.fireDataChanged(new DataEvent(t, "lstBusy",
                    DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED,
                    new Object[] { lesson }));

        }

        try
        {
            LessonStorage.delete(lesson);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return true;
    }

    /**
     * @param room
     * @return IRoom
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateRoom(fr.umlv.ir3.flexitime.common.data.resources.IRoom,
     *      IFloor)
     */
    public IRoom saveOrUpdateRoom(IRoom room, IFloor parent)
            throws RemoteException
    {
        int type;
        if (room.getIdData() == null)
        {
            type = DataEvent.TYPE_PROPERTY_SUBDATA_ADDED;
            parent.addRoom(room);
        }
        else
            type = DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED;

        try
        {
            FloorStorage.save(parent);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        int indices = room.getFloor().getLstRoom().indexOf(room);

        manager.fireDataChanged(new DataEvent(room.getFloor(),
                "lstRoom", type, new Object[] { room }, new int[] { indices })); //$NON-NLS-1$
        return room;
    }

    /**
     * @param floor
     * @return list of IRoom
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
     * @param room
     * @return true if OK
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteRoom(fr.umlv.ir3.flexitime.common.data.resources.IRoom)
     */
    public boolean deleteRoom(IRoom room) throws RemoteException,
            FlexiException
    {
        int indice = room.getFloor().getLstRoom().indexOf(room);

        try
        {
            RoomStorage.delete(room);
        }
        catch (HibernateException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText(
                    "roomDeletion"), e); //$NON-NLS-1$
        }

        manager
                .fireDataChanged(new DataEvent(
                        room.getFloor(),
                        "lstRoom", DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED, new Object[] { room }, new int[] { indice })); //$NON-NLS-1$

        return true;
    }

    /**
     * @param subject
     * @return ISubject
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject,
     *      ISubjectsGroup)
     */
    public ISubject saveOrUpdateSubject(ISubject subject, ISubjectsGroup parent)
            throws RemoteException
    {
        int type;
        if (subject.getIdData() == null)
        {
            type = DataEvent.TYPE_PROPERTY_SUBDATA_ADDED;
            parent.addSubject(subject);
        }
        else
            type = DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED;

        try
        {
            SubjectsGroupStorage.save(parent);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        int indices = subject.getParentSubjectsGroup().getLstSubject().indexOf(
                subject);

        manager
                .fireDataChanged(new DataEvent(
                        subject.getParentSubjectsGroup(),
                        "lstSubject", type, new Object[] { subject }, new int[] { indices })); //$NON-NLS-1$
        return subject;
    }

    /**
     * @param subjectsGroup
     * @return list of ISubject
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getSubjects(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup)
     */
    public List<ISubject> getSubjects(ISubjectsGroup subjectsGroup)
            throws RemoteException
    {
        List<ISubject> l;
        try
        {
            l = SubjectStorage.get(subjectsGroup);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            l = new ArrayList<ISubject>();
        }
        return l;
    }

    /**
     * @param subject
     * @return true if OK
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject)
     */
    public boolean deleteSubject(ISubject subject) throws RemoteException,
            FlexiException
    {
        int indice = subject.getParentSubjectsGroup().getLstSubject().indexOf(
                subject);

        try
        {
            subject.getParentSubjectsGroup().removeSubject(subject);
            // SubjectStorage.delete(subject);
            SubjectsGroupStorage.save(subject.getParentSubjectsGroup());
        }
        catch (HibernateException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText(
                    "subjectDeletion"), e); //$NON-NLS-1$
        }

        manager
                .fireDataChanged(new DataEvent(
                        subject.getParentSubjectsGroup(),
                        "lstSubject", DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED, new Object[] { subject }, new int[] { indice })); //$NON-NLS-1$

        return true;
    }

    /**
     * @param subjectsGroup
     * @return ISubjectsGroup
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateSubjectsGroup(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup,
     *      ITeachingStructure)
     */
    public ISubjectsGroup saveOrUpdateSubjectsGroup(
            ISubjectsGroup subjectsGroup, ITeachingStructure parent)
            throws RemoteException
    {
        int type;
        if (subjectsGroup.getIdData() == null)
        {
            type = DataEvent.TYPE_PROPERTY_SUBDATA_ADDED;
            parent.addSubjectsGroup(subjectsGroup);
        }
        else
            type = DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED;

        try
        {
            TeachingStructureStorage.save(parent);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        int indices = subjectsGroup.getParentTeachStruct()
                .getLstSubjectsGroup().indexOf(subjectsGroup);

        manager
                .fireDataChanged(new DataEvent(
                        subjectsGroup.getParentTeachStruct(),
                        "lstSubjectsGroup", type, new Object[] { subjectsGroup }, new int[] { indices })); //$NON-NLS-1$
        return subjectsGroup;
    }

    /**
     * @param ts
     * @return list of ISubjectsGroup
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getSubjectsGroup(ITeachingStructure)
     */
    public List<ISubjectsGroup> getSubjectsGroup(ITeachingStructure ts)
            throws RemoteException
    {
        List<ISubjectsGroup> l;
        try
        {
            l = SubjectsGroupStorage.get(ts);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            l = new ArrayList<ISubjectsGroup>();
        }
        return l;
    }

    /**
     * @param subjectsGroup
     * @return true if OK
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteSubjectsGroup(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup)
     */
    public boolean deleteSubjectsGroup(ISubjectsGroup subjectsGroup)
            throws RemoteException, FlexiException
    {
        int indice = subjectsGroup.getParentTeachStruct().getLstSubjectsGroup()
                .indexOf(subjectsGroup);

        try
        {
            SubjectsGroupStorage.delete(subjectsGroup);
        }
        catch (HibernateException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText(
                    "subjectsGroupDeletion"), e); //$NON-NLS-1$
        }

        manager
                .fireDataChanged(new DataEvent(
                        subjectsGroup.getParentTeachStruct(),
                        "lstSubjectsGroup", DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED, new Object[] { subjectsGroup }, new int[] { indice })); //$NON-NLS-1$

        return true;
    }

    /**
     * @param teacher
     * @return ITeacher
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateTeacher(fr.umlv.ir3.flexitime.common.data.resources.ITeacher)
     */
    public ITeacher saveOrUpdateTeacher(ITeacher teacher)
            throws RemoteException
    {
        int type = teacher.getIdData() == null ? DataEvent.TYPE_PROPERTY_ADDED
                : DataEvent.TYPE_PROPERTY_CHANGED;

        try
        {
            TeacherStorage.save(teacher);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        manager.fireDataChanged(new DataEvent(teacher, "", type)); //$NON-NLS-1$

        return teacher;
    }

    /**
     * @return list of ITeacher
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getTeachers()
     */
    public List<ITeacher> getTeachers() throws RemoteException
    {
        List<ITeacher> l = DataStorage.get(ITeacher.class);
        if (l != null) return l;
        try
        {
            l = TeacherStorage.get();
        }
        catch (HibernateException e)
        {

            e.printStackTrace();
            l = new ArrayList<ITeacher>();
        }
        DataStorage.addTeachers(l);
        return l;
    }

    /**
     * @param teacher
     * @return true if OK
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteTeacher(fr.umlv.ir3.flexitime.common.data.resources.ITeacher)
     */
    public boolean deleteTeacher(ITeacher teacher) throws RemoteException,
            FlexiException
    {
        try
        {
            // A mettre dans le reallyDeleteTecher
            // for(Iterator<IBusy> it = teacher.getLstBusy().iterator();
            // it.hasNext(); )
            // {
            // IBusy b = it.next();
            // if(b instanceof ILesson)
            // {
            // ILesson l = (ILesson) b;
            // l.removeResource(teacher);
            // LessonStorage.save(l);
            // }
            // }

            TeacherStorage.delete(teacher);
        }
        catch (HibernateException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText(
                    "teacherDeletion"), e); //$NON-NLS-1$

        }
        manager.fireDataChanged(new DataEvent(teacher,
                "", DataEvent.TYPE_PROPERTY_REMOVED)); //$NON-NLS-1$
        return true;
    }

    /**
     * @param teachingStructure
     * @return ITeachingStructure
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateTeachingStructure(fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure,
     *      IClass)
     */
    public ITeachingStructure saveOrUpdateTeachingStructure(
            ITeachingStructure teachingStructure, IClass parent)
            throws RemoteException
    {
        int type;
        if (teachingStructure.getIdData() == null)
        {
            type = DataEvent.TYPE_PROPERTY_SUBDATA_ADDED;
            parent.setTeachingStructure(teachingStructure);
        }
        else
            type = DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED;

        try
        {
            ClassStorage.save(parent);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        manager.fireDataChanged(new DataEvent(teachingStructure
                .getParentClass(),
                "teachingStructure", type, new Object[] { teachingStructure })); //$NON-NLS-1$
        return teachingStructure;
    }

    /**
     * @param _class
     * @return ITeachingStructure
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getTeachingStructure(fr.umlv.ir3.flexitime.common.data.general.IClass)
     */
    public ITeachingStructure getTeachingStructure(IClass _class)
            throws RemoteException
    {
        ITeachingStructure ts;

        try
        {
            ts = TeachingStructureStorage.get(_class);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ts = null;
        }

        return ts;

    }

    /**
     * @param teachingStructure
     * @return true if OK
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteTeachingStructure(fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure)
     */
    public boolean deleteTeachingStructure(ITeachingStructure teachingStructure)
            throws RemoteException, FlexiException
    {
        try
        {
            TeachingStructureStorage.delete(teachingStructure);
        }
        catch (HibernateException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText(
                    "teachingStructureDeletion"), e); //$NON-NLS-1$
        }
        manager
                .fireDataChanged(new DataEvent(
                        teachingStructure,
                        "teachingStructure", DataEvent.TYPE_PROPERTY_REMOVED, new Object[] { teachingStructure })); //$NON-NLS-1$
        return true;
    }

    /**
     * @param track
     * @return ITrack
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateTrack(fr.umlv.ir3.flexitime.common.data.general.ITrack)
     */
    public ITrack saveOrUpdateTrack(ITrack track) throws RemoteException
    {
        int type = track.getIdData() == null ? DataEvent.TYPE_PROPERTY_ADDED
                : DataEvent.TYPE_PROPERTY_CHANGED;

        try
        {
            TrackStorage.save(track);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        manager.fireDataChanged(new DataEvent(track, "", type)); //$NON-NLS-1$

        return track;
    }

    /**
     * @return list of ITrack
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getTracks()
     */
    public List<ITrack> getTracks() throws RemoteException
    {
        List<ITrack> l = DataStorage.get(ITrack.class);
        if (l != null) return l;
        try
        {
            l = TrackStorage.get();
        }
        catch (HibernateException e)
        {

            e.printStackTrace();
            l = new ArrayList<ITrack>();
        }
        DataStorage.addTracks(l);
        return l;
    }

    /**
     * DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param user
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getTracks(fr.umlv.ir3.flexitime.common.data.admin.IUser)
     */
    public List<ITrack> getTracks(IUser user) throws RemoteException
    {
        List<ITrack> l = DataStorage.get(ITrack.class);
        if (l != null)
        {
            List<ITrack> toSend = new ArrayList<ITrack>();
            for (ITrack t : l)
            {
                if (t.getSetUser().contains(user)) toSend.add(t);

            }
            if (toSend.size() != 0) return toSend;
        }

        try
        {
            l = TrackStorage.getTracks(user);
        }
        catch (HibernateException e)
        {

            e.printStackTrace();
            l = new ArrayList<ITrack>();
        }
        DataStorage.addTracks(l);
        return l;
    }

    /**
     * @param track
     * @return true if OK
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteTrack(fr.umlv.ir3.flexitime.common.data.general.ITrack)
     */
    public boolean deleteTrack(ITrack track) throws RemoteException,
            FlexiException
    {
        try
        {
            TrackStorage.delete(track);
        }
        catch (HibernateException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText(
                    "trackDeletion"), e); //$NON-NLS-1$
        }
        manager.fireDataChanged(new DataEvent(track,
                "", DataEvent.TYPE_PROPERTY_REMOVED)); //$NON-NLS-1$
        return true;
    }

    /**
     * @param busy
     * @param parent
     * @return IDeviceBusy
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateDeviceBusy(fr.umlv.ir3.flexitime.common.data.activity.IDeviceBusy,
     *      fr.umlv.ir3.flexitime.common.data.resources.IDevice)
     */
    public IDeviceBusy saveOrUpdateDeviceBusy(IDeviceBusy busy, IDevice parent)
            throws RemoteException
    {
        int type = busy.getIdBusy() == null ? DataEvent.TYPE_PROPERTY_SUBDATA_ADDED
                : DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED;

        try
        {
            DeviceStorage.save(parent);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        manager.fireDataChanged(new DataEvent(parent,
                "setBusy", type, new Object[] { busy })); //$NON-NLS-1$

        return busy;
    }

    /**
     * @param parent
     * @return list of busies
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getBusies(fr.umlv.ir3.flexitime.common.data.resources.IResource)
     */
    public List<IBusy> getBusies(Long idResource, Class resourceClass)
            throws RemoteException
    {
        List l = null;
        try
        {
            if (resourceClass.equals(IGroup.class))
                l = BusyStorage.getGroupBusy(idResource);
            if (resourceClass.equals(IDevice.class))
                l = BusyStorage.getDeviceBusy(idResource);
            if (resourceClass.equals(IRoom.class))
                l = BusyStorage.getRoomBusy(idResource);
            if (resourceClass.equals(ITeacher.class))
                l = BusyStorage.getTeacherBusy(idResource);
            for (Iterator it = l.iterator() ; it.hasNext() ;)
            {
                System.out.println(it.next().getClass());
            }
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return l;
    }

    public static void main(String[] args) throws RemoteException
    {
        DataManagerImpl d = new DataManagerImpl();
        d.getBusies(new Long(37), IGroup.class);
    }

    /**
     * @param b
     * @param parent
     * @return IBusy
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#saveOrUpdateResourceBusy(fr.umlv.ir3.flexitime.common.data.activity.IBusy,
     *      fr.umlv.ir3.flexitime.common.data.resources.IResource)
     */
    public IBusy saveOrUpdateResourceBusy(IBusy b, IResource parent)
            throws RemoteException
    {
        int type = b.getIdBusy() == null ? DataEvent.TYPE_PROPERTY_SUBDATA_ADDED
                : DataEvent.TYPE_PROPERTY_SUBDATA_CHANGED;

        // Class c = null;
        //
        // if (parent instanceof IDevice)
        // c = IDevice.class;
        // else if (parent instanceof IGroup)
        // c = IGroup.class;
        // else if (parent instanceof IRoom)
        // c = IRoom.class;
        // else if (parent instanceof ITeacher) c = ITeacher.class;

        try
        {
            // TeacherStorage.save(parent);
            BusyStorage.save(b);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        manager.fireDataChanged(new DataEvent(parent,
                "setBusy", type, new Object[] { b })); //$NON-NLS-1$

        return b;
    }

    /**
     * @param b
     * @param parent
     * @return true if OK
     * @throws RemoteException
     * @throws FlexiException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#deleteResourceBusy(fr.umlv.ir3.flexitime.common.data.activity.ITeacherBusy,
     *      fr.umlv.ir3.flexitime.common.data.resources.ITeacher)
     */
    public boolean deleteResourceBusy(IBusy b, IResource parent)
            throws RemoteException, FlexiException
    {
        // Class c = null;
        //
        // if (parent instanceof IDevice)
        // c = IDevice.class;
        // else if (parent instanceof IGroup)
        // c = IGroup.class;
        // else if (parent instanceof IRoom)
        // c = IRoom.class;
        // else if (parent instanceof ITeacher) c = ITeacher.class;

        try
        {
            BusyStorage.delete(b);
        }
        catch (HibernateException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText(
                    "classDeletion"), e); //$NON-NLS-1$
        }

        manager
                .fireDataChanged(new DataEvent(
                        parent,
                        "setBusy", DataEvent.TYPE_PROPERTY_SUBDATA_REMOVED, new Object[] { b })); //$NON-NLS-1$

        return true;
    }

    // POUR LES TESTS

    /**
     * @return IGroup
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getGroup()
     */
    public IGroup getGroup() throws RemoteException
    {
        try
        {
            return GroupStorage.getGroup();
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    /**
     * DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param idChildGroup
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#getParentClass(java.lang.Long)
     */
    public IClass getClassFromId(Long idClass) throws RemoteException
    {
        IClass c = (IClass) DataStorage.get(idClass);
        if (c != null) return c;
        try
        {
            return ClassStorage.getClassFromId(idClass);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public List<IRoom> getRooms() throws RemoteException
    {
        List<IRoom> l = DataStorage.get(IRoom.class);
        if (l != null) { return l; }

        try
        {
            l = RoomStorage.get();
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DataStorage.addRooms(l);
        return l;
    }
}
