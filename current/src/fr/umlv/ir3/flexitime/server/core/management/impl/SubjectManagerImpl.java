/*
 * Created on 26 déc. 2004
 * by Valère
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.Subject;
import fr.umlv.ir3.flexitime.common.rmi.ISubjectManager;


/**
 * SubjectManagerImpl - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Valère
 */
public class SubjectManagerImpl implements ISubjectManager{

    /** 
     * getSubject - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ISubjectManager#getSubject(java.lang.String)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Subject getSubject(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * saveSubject - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param subject 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ISubjectManager#saveSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.Subject)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public void saveSubject(Subject subject) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * removeSubject - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ISubjectManager#removeSubject(java.lang.String)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Subject removeSubject(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * lockSubject - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param subject
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ISubjectManager#lockSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.Subject)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean lockSubject(Subject subject) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * unlockSubject - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param subject
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ISubjectManager#unlockSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.Subject)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean unlockSubject(Subject subject) {
        // TODO Auto-generated method stub
        return false;
    }

}
