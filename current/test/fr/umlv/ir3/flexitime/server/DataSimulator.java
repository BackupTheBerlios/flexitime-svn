package fr.umlv.ir3.flexitime.server;
import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
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

/*
 * Created on 21 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DataSimulator 
{
	public static List createTrackList()
	{
		//Construction des Track
        ITrack trackIR = DataFactory.createTrack("IR");
        ITrack trackMF = DataFactory.createTrack("MF");
        ITrack trackEI = DataFactory.createTrack("EI");
        //Construction des class
        
        IClass classIR1 = DataFactory.createClass("IR1",trackIR);
        ITeachingStructure teach = DataFactory.createTeachingStructure("name",classIR1);
        ISubjectsGroup subgroup = DataFactory.createSubjectsGroup("Mathématique",teach);
        ISubject sub = DataFactory.createSubject("Mathematique du signal",subgroup);
        ICourse course = DataFactory.createCourse("CM math signal",sub,ICourse.CM);
        classIR1.setTeachingStructure(teach);
        IClass classIR2 = DataFactory.createClass("IR2",trackIR);
        classIR2.setTeachingStructure(DataFactory.createTeachingStructure("name",classIR2));
        IClass classIR3 = DataFactory.createClass("IR3",trackIR);
        classIR3.setTeachingStructure(DataFactory.createTeachingStructure("name",classIR3));
        IClass classMF1 = DataFactory.createClass("MF1",trackMF);
        classMF1.setTeachingStructure(DataFactory.createTeachingStructure("name",classMF1));
        IClass classMF2 = DataFactory.createClass("MF2",trackMF);
        classMF2.setTeachingStructure(DataFactory.createTeachingStructure("name",classMF2));
        IClass classMF3 = DataFactory.createClass("MF3",trackMF);
        classMF3.setTeachingStructure(DataFactory.createTeachingStructure("name",classMF3));
        IClass classEI1 = DataFactory.createClass("EI1",trackEI);
        classEI1.setTeachingStructure(DataFactory.createTeachingStructure("name",classEI1));
        IClass classEI2 = DataFactory.createClass("EI2",trackEI);
        classEI2.setTeachingStructure(DataFactory.createTeachingStructure("name",classEI2));
        IClass classEI3 = DataFactory.createClass("EI3",trackEI);
        classEI2.setTeachingStructure(DataFactory.createTeachingStructure("name",classEI2));
        
        //Construction des groupes
        //IR1
        IGroup groupIR11 = DataFactory.createGroup("group1",10,classIR1);
        IGroup groupIR12 = DataFactory.createGroup("group2",10,classIR1);
        //IR2
        IGroup groupIR21 = DataFactory.createGroup("group1",10,classIR2);
        IGroup groupIR22 = DataFactory.createGroup("group2",10,classIR2);
//      IR3
        IGroup groupIR31 = DataFactory.createGroup("group1",10,classIR3);
        IGroup groupIR32 = DataFactory.createGroup("group2",10,classIR3);
//      MF1
        IGroup groupMF11 = DataFactory.createGroup("group1",10,classMF1);
        IGroup groupMF12 = DataFactory.createGroup("group2",10,classMF1);
//      MF2
        IGroup groupMF21 = DataFactory.createGroup("group1",10,classMF2);
        IGroup groupMF22 = DataFactory.createGroup("group2",10,classMF2);
//      MF3
        IGroup groupMF31 = DataFactory.createGroup("group1",10,classMF3);
        IGroup groupMF32 = DataFactory.createGroup("group2",10,classMF3);
//      EI1
        IGroup groupEI11 = DataFactory.createGroup("group1",10,classEI1);
        IGroup groupEI12 = DataFactory.createGroup("group2",10,classEI1);
//      EI2
        IGroup groupEI21 = DataFactory.createGroup("group1",10,classEI2);
        IGroup groupEI22 = DataFactory.createGroup("group2",10,classEI2);
//      EI3
        IGroup groupEI31 = DataFactory.createGroup("group1",10,classEI3);
        IGroup groupEI32 = DataFactory.createGroup("group2",10,classEI3);

        List lstTrack = new ArrayList();
        lstTrack.add(trackIR);
        lstTrack.add(trackMF);
        lstTrack.add(trackEI);
        
        return lstTrack;
	}
	
	public static List createDeviceList()
	{
		List lstDevice = new ArrayList();
		//Construction des Devices videoproj type 0
        IDevice device = DataFactory.createDevice("VideoIR1");
        device.setType(0);
        lstDevice.add(device);
        IDevice device1 = DataFactory.createDevice("VideoIR2");
        device1.setType(0);
        lstDevice.add(device1);
        IDevice device2 = DataFactory.createDevice("VideoIR3");
        device2.setType(0);
        lstDevice.add(device2);
        
        //Construction des Devices tele type 1
        IDevice device3 = DataFactory.createDevice("TeleIR1");
        device3.setType(1);
        lstDevice.add(device3);
        IDevice device4 = DataFactory.createDevice("TeleIR2");
        device4.setType(1);
        lstDevice.add(device4);
        IDevice device5 = DataFactory.createDevice("TeleIR3");
        device5.setType(1);
        lstDevice.add(device5);
        
//      Construction des Devices magnétoscope type 2
        IDevice device6 = DataFactory.createDevice("MagnetoIR1");
        device6.setType(2);
        lstDevice.add(device6);
        IDevice device7 = DataFactory.createDevice("MagnetoIR2");
        device7.setType(2);
        lstDevice.add(device7);
        IDevice device8 = DataFactory.createDevice("MagnetoIR3");
        device8.setType(2);
        lstDevice.add(device8);
        
        return lstDevice;
	}
	
	
	public static List createRoomList()
	{
		List lstBuilding = new ArrayList();
		//Construction des Batiments
		IBuilding buildingCop = DataFactory.createBuilding("Copernic");
		IBuilding buildingRab = DataFactory.createBuilding("Rabelais");
		IBuilding buildingDes = DataFactory.createBuilding("Descartes");
		
//		Construction des Etage
		IFloor floorCop1 = DataFactory.createFloor("Etage1",buildingCop);
		IFloor floorCop2 = DataFactory.createFloor("Etage2",buildingCop);
		IFloor floorCop3 = DataFactory.createFloor("Etage3",buildingCop);
		IFloor floorCop4 = DataFactory.createFloor("Etage4",buildingCop);
		
		IFloor floorRab1 = DataFactory.createFloor("Etage1",buildingRab);
		IFloor floorRab2 = DataFactory.createFloor("Etage2",buildingRab);
		IFloor floorRab3 = DataFactory.createFloor("Etage3",buildingRab);
		
		IFloor floorDes1 = DataFactory.createFloor("Etage1",buildingDes);
		IFloor floorDes2 = DataFactory.createFloor("Etage2",buildingDes);

		
		//Construction des salles
		IRoom RoomCop11 = DataFactory.createRoom("Salle Cop11",0,30,floorCop1);
		IRoom RoomCop12 = DataFactory.createRoom("Salle Cop12",1,20,floorCop1);
		IRoom RoomCop13 = DataFactory.createRoom("Salle Cop13",2,10,floorCop1);
		IRoom RoomCop14 = DataFactory.createRoom("Salle Cop14",0,40,floorCop1);
		
		IRoom RoomCop21 = DataFactory.createRoom("Salle Cop21",0,30,floorCop2);
		IRoom RoomCop22 = DataFactory.createRoom("Salle Cop22",1,20,floorCop2);
		IRoom RoomCop23 = DataFactory.createRoom("Salle Cop23",2,10,floorCop2);
		IRoom RoomCop24 = DataFactory.createRoom("Salle Cop24",1,10,floorCop2);
		IRoom RoomCop25 = DataFactory.createRoom("Salle Cop25",2,20,floorCop2);
		
		IRoom RoomCop31 = DataFactory.createRoom("Salle Cop31",0,30,floorCop3);
		
		//2eme batiment
		IRoom RoomRab11 = DataFactory.createRoom("Salle Rab11",0,30,floorRab1);
		IRoom RoomRab12 = DataFactory.createRoom("Salle Rab12",1,20,floorRab1);
		IRoom RoomRab13 = DataFactory.createRoom("Salle Rab13",2,10,floorRab1);
		IRoom RoomRab14 = DataFactory.createRoom("Salle Rab14",0,40,floorRab1);
		
		IRoom RoomRab31 = DataFactory.createRoom("Salle Rab31",0,30,floorRab3);
		IRoom RoomRab32 = DataFactory.createRoom("Salle Rab32",1,20,floorRab3);
		IRoom RoomRab33 = DataFactory.createRoom("Salle Rab33",2,10,floorRab3);
		IRoom RoomRab34 = DataFactory.createRoom("Salle Rab34",1,10,floorRab3);
		IRoom RoomRab35 = DataFactory.createRoom("Salle Rab35",2,20,floorRab3);
		
		IRoom RoomRab21 = DataFactory.createRoom("Salle Rab21",0,30,floorRab2);
		
		//3eme batiment
		IRoom RoomDes21 = DataFactory.createRoom("Salle Des21",0,30,floorDes2);
		IRoom RoomDes22 = DataFactory.createRoom("Salle Des22",1,20,floorDes2);
		IRoom RoomDes23 = DataFactory.createRoom("Salle Des23",2,10,floorDes2);
		IRoom RoomDes24 = DataFactory.createRoom("Salle Des24",0,40,floorDes2);
		
		IRoom RoomDes11 = DataFactory.createRoom("Salle Des11",0,30,floorDes1);
		IRoom RoomDes12 = DataFactory.createRoom("Salle Des12",1,20,floorDes1);
		IRoom RoomDes13 = DataFactory.createRoom("Salle Des13",2,10,floorDes1);
		IRoom RoomDes14 = DataFactory.createRoom("Salle Des14",1,10,floorDes1);
		IRoom RoomDes15 = DataFactory.createRoom("Salle Des15",2,20,floorDes1);
		
		lstBuilding.add(buildingCop);
		lstBuilding.add(buildingRab);
		lstBuilding.add(buildingDes);
		return lstBuilding;
	}
	
	public static List createTeacherList()
	{
		List lstTeacher = new ArrayList();
		ITeacher teacher1 = DataFactory.createTeacher("Forax","Rémi");
		ITeacher teacher2 = DataFactory.createTeacher("Calmejane","Lionel");
		ITeacher teacher3 = DataFactory.createTeacher("Cervelle","Julien");
		ITeacher teacher4 = DataFactory.createTeacher("Revuz","Dominique");
		ITeacher teacher5 = DataFactory.createTeacher("Duris","Etienne");
		
		
		lstTeacher.add(teacher1);
		lstTeacher.add(teacher2);
		lstTeacher.add(teacher3);
		lstTeacher.add(teacher4);
		lstTeacher.add(teacher5);
		
		return lstTeacher;
	}
}
