/*
 * Created on 3 f�vr. 2005
 * by VF
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.admin;

import fr.umlv.ir3.flexitime.common.rmi.LocalDataManager;
import junit.framework.TestCase;


/**
 * DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - VF
 */
public class TestUserManager extends TestCase
{
    public void testConnectToLight(){
        try{         
            if(LocalDataManager.getUserManager().ConnectToLight("jojo","pipo")) fail("UserManager:testConnectLight()");
            
        }catch(Exception e){
            fail("UserManager:testConnectLight()");
        }
    }
    
    public void testConnectToRich(){
        try{         
            if(LocalDataManager.getUserManager().ConnectToRich("jojo","pipo")) fail("UserManager:testConnectLight()");
            
        }catch(Exception e){
            fail("UserManager:testConnectLight()");
        }
    }
    
    public void testGet(){
        try{
            if(LocalDataManager.getUserManager().get("popo")!=null) fail("UserManager:get()");
        }catch(Exception e){}
    }
}

