/*
 * Created on 3 févr. 2005
 * by VF
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.admin;

import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import junit.framework.TestCase;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - VF
 */
public class TestUserManager extends TestCase
{
    public void testConnectToLight(){
        try{         
            if(RemoteDataManager.getUserManager().ConnectToLight("jojo","pipo")) fail("UserManager:testConnectLight()");
            
        }catch(Exception e){
            fail("UserManager:testConnectLight()");
        }
    }
    
    public void testConnectToRich(){
        try{         
            if(RemoteDataManager.getUserManager().ConnectToRich("jojo","pipo")) fail("UserManager:testConnectLight()");
            
        }catch(Exception e){
            fail("UserManager:testConnectLight()");
        }
    }
    
    public void testGet(){
        try{
            if(RemoteDataManager.getUserManager().get("popo")!=null) fail("UserManager:get()");
        }catch(Exception e){}
    }
}

