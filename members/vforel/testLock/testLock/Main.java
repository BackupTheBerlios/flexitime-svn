/*
 * Created on 14 janv. 2005
 * by Val�re FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package testLock;


/**
 * Main - DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - Val�re FOREL
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
        Manager m1 = new Manager();
        MaThread mt1 = new MaThread(m1,1);
        MaThread mt2 = new MaThread(m1,2);
        mt1.start();
        mt2.start();
    }
}
