/*
 * Created on 14 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.flexitime.server.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.umlv.ir3.GL.flexitime.common.ressource.Teacher;

/**
 * @author binou
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TeacherStorage
{
	private ArrayList list = new ArrayList();
	
	public TeacherStorage()
	{
		list.add(new Teacher("Marcelus","Wallas","marcellus@pulp.com"));
		list.add(new Teacher("Echo","Request","adrien@ping.fr"));
		list.add(new Teacher("Sydney","Bristow","alias@serieTV.com"));
		list.add(new Teacher("Jack","Bauer","24@hours.com"));
	}
	
	public List getTeachers()
	{
		return list;
	}

	/**
	 * @param text1
	 * @param text2
	 * @param text3
	 * @return
	 */
	public Teacher createTeacher(String text1, String text2, String text3) {
		Teacher res = new Teacher(text1,text2,text3);
		list.add(res);
		return res;
	}

	/**
	 * @param teacher
	 */
	public void deleteTeacher(Teacher teacher) {
		list.remove(teacher);
	}
	
	public String toString()
	{
		StringBuffer buf = new StringBuffer();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Teacher element = (Teacher) iter.next();
			buf.append(element.toString() + ";");
		}
		return buf.toString();
	}

}
