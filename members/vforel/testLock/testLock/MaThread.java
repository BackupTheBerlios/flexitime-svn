/*
 * Created on 14 janv. 2005
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package testLock;


/**
 * MaThread - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Valère FOREL
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
