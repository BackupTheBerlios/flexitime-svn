/*
 * Created on 1 févr. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models.management;

import java.util.List;

import javax.swing.AbstractListModel;

import fr.umlv.ir3.flexitime.common.data.admin.IUser;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class UsersListModel extends AbstractListModel
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3979264742286504752L;
    private List<IUser> listOfUsers;
    

    /**
     * DOCME
     * @param _listOfUsers
     */
    public UsersListModel(List<IUser> _listOfUsers)
    {
        this.listOfUsers = _listOfUsers;
    }
    
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return the number of users.
     * 
     * @see javax.swing.ListModel#getSize()
     */
    public int getSize()
    {
        return listOfUsers.size();
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param index of the user searched.
     * @return the name of the user searched.
     * 
     * @see javax.swing.ListModel#getElementAt(int)
     */
    public Object getElementAt(int index)
    {
        return listOfUsers.get(index);
    }
    
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param user 
     */
    public void removeUser(IUser user)
    {
        int index = listOfUsers.indexOf(user);
        listOfUsers.remove(user);
        fireIntervalRemoved(this, index, index);
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param user 
     * 
     */
    public void addUser(IUser user)
    {
        int index = listOfUsers.indexOf(user);
        listOfUsers.add(user);
        fireIntervalAdded(this, index, index);
    }
}
