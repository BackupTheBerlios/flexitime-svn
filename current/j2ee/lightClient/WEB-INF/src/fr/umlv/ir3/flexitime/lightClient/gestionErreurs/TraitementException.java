/*
 * Created on 24 janv. 2005
 * by VF
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.lightClient.gestionErreurs;


/**
 * DOCME Description
 * 
 * @author FlexiTeam - Administrateur
 */
public class TraitementException extends Exception
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4050482296488605492L;

    /**
     * DOCME
     * @param message
     */
    public TraitementException(String message){
        super(message);
    }
}

