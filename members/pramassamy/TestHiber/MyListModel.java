/*
 * Created on 13 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package TestHiber;

import java.util.List;

import javax.swing.AbstractListModel;

import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;

/**
 * DOCME Description explication supplémentaire si nécessaire in english
 * please... Que fait cette classe, qu'est-ce qu'elle représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * @author FlexiTeam - Prâsad
 */
public class MyListModel extends AbstractListModel
{

    private List profs;

    public MyListModel(List l)
    {
        profs = l;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @return
     * @see javax.swing.ListModel#getSize()
     */
    public int getSize()
    {
        return profs.size();
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param index
     * @return
     * @see javax.swing.ListModel#getElementAt(int)
     */
    public Object getElementAt(int index)
    {
        ITeacher t = ((ITeacher) profs.get(index));
        return t.getName() + "::" + t.getFirstName() + "::" + t.getEmail();
    }
    
    public ITeacher getAt(int index){
        return (ITeacher)profs.get(index);
    }

}

