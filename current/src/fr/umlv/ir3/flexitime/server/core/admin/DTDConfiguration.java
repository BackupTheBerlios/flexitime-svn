/*
 * Created on 24 janv. 2005
 * by Jérôme GUERS
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.admin;

/**
 * This class contains all the constant values usefull to parse the 
 * DTD designated for configuration file of FlexiTime.
 *  
 * @version 250
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class DTDConfiguration {
	/* Entete */
	/** Constante representing the header of a XML file */ 
	public final static String xmlHeader = "<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>";
	 
	/* Noms d'elements */
	/**
	 * Comment for <code>root</code>
	 */
	public final static String root = "flexi:config";
    /**
     * Comment for <code>uriData</code>
     */
    public final static String uriData = "flexi:uriServerData";
    /**
     * Comment for <code>nameDB</code>
     */
    public final static String nameDB = "flexi:nameBase";
    /**
     * Comment for <code>userDB</code>
     */
    public final static String userDB = "flexi:userBDD";
    /**
     * Comment for <code>passDB</code>
     */
    public final static String passDB = "flexi:passBDD";
    /**
     * Comment for <code>uriLDAP</code>
     */
    public final static String uriLDAP = "flexi:uriServerLDAP";
    /**
     * Comment for <code>portLDAP</code>
     */
    public final static String portLDAP = "flexi:portLDAP";
    /**
     * Comment for <code>pathUserLDAP</code>
     */
    public final static String pathUserLDAP = "flexi:pathUserLDAP";
    /**
     * Comment for <code>pathGroupLDAP</code>
     */
    public final static String pathGroupLDAP = "flexi:pathGroupLDAP";
    /**
     * Comment for <code>uriMail</code>
     */
    public final static String uriMail = "flexi:uriSMTPserver";
}
