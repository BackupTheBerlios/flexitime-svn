/*
 * Created on 23 nov. 2004
 */
package fr.umlv.ir3.flexitime.lightClient.authentification;

import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.lightClient.gestionErreurs.TraitementException;




/**
 * @author vforel
 */
public class Authentification{

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * @param server 
     *
     * @param login
     * @param password
     * @return the name
     * @throws TraitementException 
     * 
     */
    public static boolean getAuth(String server,String login,String password) throws TraitementException{
        //TODO tester la connection
        if(login==null || login.equals("")) throw new TraitementException("0");
        if(password==null || password.equals("")) throw new TraitementException("0");
        //TODO définir le serveur
        
        RemoteDataManager.setIpServer(server);
        try
        {
            if(!RemoteDataManager.getUserManager().ConnectToLight(login,password)) throw new TraitementException("3");
        }
        catch (RemoteException e)
        {
            throw new TraitementException("4");
        }
        catch (Exception e)
        {
            throw new TraitementException("3");
        }
        return true;
    }
    
    public static String getLongName(String login) {
        String tmp = null;
        try{
           tmp = RemoteDataManager.getUserManager().getLongName(login);
        }catch(Exception e){
            tmp = "";
        }
        return tmp;
    }
}
