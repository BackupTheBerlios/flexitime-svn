/*
 * Created on 13 janv. 2005
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.admin;

import fr.umlv.ir3.flexitime.common.data.IData;


/**
 * Represents the interface of a User
 * 
 * @version 240
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public interface IUser extends IData
{ 
    /**
     * returns the Password of a user

     * @return the Password of a user
     */
    public String getPassword();
    
    /**
     * returns the Password of a user
     *
     *  @param pass the Password of a user
     */
    public void setPassword(String pass);
    
    /**
     * returns the preference of a user
     *
     * @return the preference of a user
     */
    public IPreferences getPreferences();
    
    /**
     * set the preference of a user
     * 
     * @param pref
     *            the preference of a user
     */
    public void setPreferences(IPreferences pref);
    
    /**
     * DOCME
     * 
     * @return a boolean 
     */
    public boolean isLdap();
    
    /**
     * Test the equality of two users.
     * <ul>
     * <li>If one user has an ID, the other must have one, else there are not
     * equals.</li>
     * <li>If any user has an ID, they must have the same name to be equals.
     * </li>
     * <li>Else, they must have the same ID.</li>
     * </ul>
     * 
     * @param obj
     *            other user to compare with
     * @return <code>true</code> if this object is the same as the obj
     *         argument; <code>false</code> otherwise.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj);
    
    /**
     * Returns privilege for this user
     *
     * @return privilege 
     * 
     */
    public int getPrivilege();
    
    /**
     *  
     * Sets privilege for this user
     *
     * @param newPrivilege privilege to set
     * 
     */
    public void setPrivilege(int newPrivilege);
    
    /** ADMIN */
    public static int ADMIN = 0;
    /** SECRETARY */
    public static int SECRETARY = 1;
    /** USER */
    public static int USER = 2;
    
}

