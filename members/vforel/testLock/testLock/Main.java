/*
 * Created on 14 janv. 2005
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package testLock;


/**
 * Main - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Valère FOREL
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
