/*
 * Created on 30 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server;

import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;


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
public class EventSimulator
{
    static class GroupListener extends DataListenerImpl
    {

        /**
         * @throws RemoteException
         */
        protected GroupListener() throws RemoteException
        {
            super();
            // TODO Auto-generated constructor stub
        }

        /**
         * Comment for <code>serialVersionUID</code>
         */
        private static final long serialVersionUID = 3256728372607268407L;

        /** 
         * @param event
         * @throws RemoteException 
         * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
         */
        public void dataChanged(DataEvent event) throws RemoteException
        {
            System.out.println("Event de groupe\t"+event);
            
        }
        
    }
    
    static class TeacherListener extends DataListenerImpl
    {

        /**
         * @throws RemoteException
         */
        protected TeacherListener() throws RemoteException
        {
            super();
            // TODO Auto-generated constructor stub
        }

        /**
         * Comment for <code>serialVersionUID</code>
         */
        private static final long serialVersionUID = 3256728372607268407L;

        /** 
         * @param event
         * @throws RemoteException 
         * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
         */
        public void dataChanged(DataEvent event) throws RemoteException
        {
            System.out.println("Event de Teacher\t"+event);
            
        }
        
    }
    static class DeviceListener extends DataListenerImpl
    {

        /**
         * @throws RemoteException
         */
        protected DeviceListener() throws RemoteException
        {
            super();
            // TODO Auto-generated constructor stub
        }

        /**
         * Comment for <code>serialVersionUID</code>
         */
        private static final long serialVersionUID = 3256728372607268407L;

        /** 
         * @param event
         * @throws RemoteException 
         * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
         */
        public void dataChanged(DataEvent event) throws RemoteException
        {
            System.out.println("Event de Device\t"+event);
            
        }
        
    }
    static class BuildingListener extends DataListenerImpl
    {

        /**
         * @throws RemoteException
         */
        protected BuildingListener() throws RemoteException
        {
            super();
            // TODO Auto-generated constructor stub
        }

        /**
         * Comment for <code>serialVersionUID</code>
         */
        private static final long serialVersionUID = 3256728372607268407L;

        /** 
         * @param event
         * @throws RemoteException 
         * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
         */
        public void dataChanged(DataEvent event) throws RemoteException
        {
            System.out.println("Event de Building\t"+event);
            
        }
        
    }
    static class FloorListener extends DataListenerImpl
    {

        /**
         * @throws RemoteException
         */
        protected FloorListener() throws RemoteException
        {
            super();
            // TODO Auto-generated constructor stub
        }

        /**
         * Comment for <code>serialVersionUID</code>
         */
        private static final long serialVersionUID = 3256728372607268407L;

        /** 
         * @param event
         * @throws RemoteException 
         * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
         */
        public void dataChanged(DataEvent event) throws RemoteException
        {
            System.out.println("Event de Floor\t"+event);
            
        }
        
    }
    static class RoomListener extends DataListenerImpl
    {

        /**
         * @throws RemoteException
         */
        protected RoomListener() throws RemoteException
        {
            super();
            // TODO Auto-generated constructor stub
        }

        /**
         * Comment for <code>serialVersionUID</code>
         */
        private static final long serialVersionUID = 3256728372607268407L;

        /** 
         * @param event
         * @throws RemoteException 
         * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
         */
        public void dataChanged(DataEvent event) throws RemoteException
        {
            System.out.println("Event de Room\t"+event);
            
        }
        
    }
    static class TrackListener extends DataListenerImpl
    {

        /**
         * @throws RemoteException
         */
        protected TrackListener() throws RemoteException
        {
            super();
            // TODO Auto-generated constructor stub
        }

        /**
         * Comment for <code>serialVersionUID</code>
         */
        private static final long serialVersionUID = 3256728372607268407L;

        /** 
         * @param event
         * @throws RemoteException 
         * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
         */
        public void dataChanged(DataEvent event) throws RemoteException
        {
            System.out.println("Event de Track\t"+event);
            
        }
        
    }
    static class ClassListener extends DataListenerImpl
    {

        /**
         * @throws RemoteException
         */
        protected ClassListener() throws RemoteException
        {
            super();
            // TODO Auto-generated constructor stub
        }

        /**
         * Comment for <code>serialVersionUID</code>
         */
        private static final long serialVersionUID = 3256728372607268407L;

        /** 
         * @param event
         * @throws RemoteException 
         * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
         */
        public void dataChanged(DataEvent event) throws RemoteException
        {
            System.out.println("Event de Class\t"+event);
            
        }
        
    }

    public static void main(String[] args) throws RemoteException
    {
        RemoteDataManager.getManager().addDataListener(IBuilding.class, new BuildingListener());
        RemoteDataManager.getManager().addDataListener(IFloor.class, new FloorListener());
        RemoteDataManager.getManager().addDataListener(IRoom.class, new RoomListener());
        
        RemoteDataManager.getManager().addDataListener(IDevice.class, new DeviceListener());
        RemoteDataManager.getManager().addDataListener(ITeacher.class, new TeacherListener());
        
        RemoteDataManager.getManager().addDataListener(ITrack.class, new TrackListener());
        RemoteDataManager.getManager().addDataListener(IClass.class, new ClassListener());
        RemoteDataManager.getManager().addDataListener(IGroup.class, new GroupListener());
        
        //MetierSimulator.getRoussel();
    }
}

