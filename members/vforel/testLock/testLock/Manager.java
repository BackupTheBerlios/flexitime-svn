/*
 * Created on 14 janv. 2005
 * by Val�re FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package testLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Manager - DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - Val�re FOREL
 */
public class Manager {
    private final Lock monLock = new ReentrantLock();
    public Manager(){
    }
    public synchronized boolean lock() throws InterruptedException{
        // Si le lock n'est pas lib�r� au bout de 10 secondes je le prends
        if(monLock.tryLock(10,TimeUnit.SECONDS)) return true;
        
        // Si le lock est pris je passe le if
        //if(monLock.tryLock()) return true;
        return false;
    }
    public void traitement(int id) throws InterruptedException{
        for(int i=0; i<15; i++) {
            Thread.sleep(1000);
            System.out.println(id+":"+i);
        }
    }
    public void unlock(){
        monLock.unlock();
    }
    
}
