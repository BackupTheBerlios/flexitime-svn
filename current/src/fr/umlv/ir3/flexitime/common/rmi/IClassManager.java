/*
 * Created on 23 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;
import fr.umlv.ir3.flexitime.common.data.general.Class;



/**
 * IClassManager - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IClassManager extends Remote,AbstractManager {
    /** 
     * getClass - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    Class getClass(String name);
    /** 
     * addClass - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param _class 
     * 
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    void saveClass(Class _class);
    /** 
     * removeClass - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    Class removeClass(String name);
    /** 
     * lockClass - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param _class
     * @return 
     * 
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    boolean lockClass(Class _class);
    /** 
     * unlockClass - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param _class
     * @return 
     * 
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    boolean unlockClass(Class _class);

}
