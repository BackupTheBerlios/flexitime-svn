/*
 * Created on 14 janv. 2005
 * by Val�re FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package testLock;


/**
 * MaThread - DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - Val�re FOREL
 */
public class MaThread extends Thread{
    Manager m;
    int id;
    public MaThread(Manager m, int id){
        this.m = m;
        this.id = id;
    }
    public void run(){
        try {
            m.lock();
            // while(m.lock()!=true){}
            m.traitement(id);
            m.unlock();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
