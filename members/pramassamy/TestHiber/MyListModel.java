/*
 * Created on 13 janv. 2005
 * by Pr�sad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package TestHiber;

import java.util.List;

import javax.swing.AbstractListModel;

import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;

/**
 * DOCME Description explication suppl�mentaire si n�cessaire in english
 * please... Que fait cette classe, qu'est-ce qu'elle repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * @see (si n�cessaire)
 * @author FlexiTeam - Pr�sad
 */
public class MyListModel extends AbstractListModel
{

    private List profs;

    public MyListModel(List l)
    {
        profs = l;
    }

    /**
     * DOCME Description Quel service est rendu par cette m�thode
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
     * DOCME Description Quel service est rendu par cette m�thode
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

