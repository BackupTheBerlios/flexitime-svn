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
	public final static String root = "flexi:config";
    public final static String uriData = "flexi:uriServerData";
    public final static String nameDB = "flexi:nameBase";
    public final static String userDB = "flexi:userBDD";
    public final static String passDB = "flexi:passBDD";
    public final static String uriLDAP = "flexi:uriServerLDAP";
    public final static String portLDAP = "flexi:portLDAP";
    public final static String pathUserLDAP = "flexi:pathUserLDAP";
    public final static String pathGroupLDAP = "flexi:pathGroupLDAP";
    public final static String uriMail = "flexi:uriSMTPserver";
}
