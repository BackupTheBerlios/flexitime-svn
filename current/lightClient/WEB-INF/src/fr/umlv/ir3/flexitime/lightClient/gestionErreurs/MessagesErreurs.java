/*
 * Created on 24 janv. 2005
 * by VF
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.lightClient.gestionErreurs;

import java.util.HashMap;


/**
 * DOCME Description
 * 
 * @author FlexiTeam - Administrateur
 */
public class MessagesErreurs
{
    private static HashMap<String,String> message;
    static{
        message = new HashMap<String,String>();
        message.put("0","0");
        message.put("1","Login inconnu");
        message.put("2","Mot de passe incorrect");
        message.put("3","Login ou Mot de passe incorrect");
        message.put("4","Serveur introuvable. Contactez votre administrateur");
        message.put("5","Erreur interne de configuration. Contactez votre administrateur");
    }
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     *
     * @param index
     * @return the error message
     * 
     */
    public static String getMessage(String index){
        return message.get(index);
    }
}

