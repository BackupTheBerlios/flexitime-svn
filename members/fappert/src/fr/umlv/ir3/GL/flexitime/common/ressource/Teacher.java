/*
 * Created on 14 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.flexitime.common.ressource;

import java.io.Serializable;

/**
 * @author binou
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Teacher implements Serializable, Comparable
{
	private String firstName;
	private String surName;
	private String email;

	/**
	 * @param firstName
	 * @param surName
	 * @param email
	 */
	public Teacher(String firstName, String surName, String email) {
		super();
		this.firstName = firstName;
		this.surName = surName;
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getSurName() {
		return surName;
	}
	
	public String toString()
	{
		return getFirstName() + " " + getSurName() + " " + getEmail();
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o) {
		return ((Teacher)o).getFirstName().compareTo(this.firstName);
	}
}
