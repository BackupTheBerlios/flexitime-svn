/*
 * Created on 7 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package temp;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * 
 * @author FlexiTeam - binou
 */
public class MetierSimulator
{
    public static List getDatas()
    {
        List res = new ArrayList(3);
        res.add(new Busy(2005,0,3,8,30,2005,0,3,10,30,Color.YELLOW,"Corba"));
        res.add(new Busy(2005,0,3,13,45,2005,0,3,15,45,Color.MAGENTA,"J2EE"));
        res.add(new Busy(2005,0,3,16,00,2005,0,3,17,00,Color.GREEN,"MSI"));
        
        res.add(new Busy(2005,0,4,8,30,2005,0,4,12,45,Color.MAGENTA,"J2EE"));
        res.add(new Busy(2005,0,4,13,45,2005,0,4,15,45,Color.YELLOW,"Corba"));
        res.add(new Busy(2005,0,4,16,00,2005,0,4,17,30,Color.GREEN,"MSI"));

        res.add(new Busy(2005,0,5,10,45,2005,0,5,12,45,Color.MAGENTA,"J2EE"));
        res.add(new Busy(2005,0,5,13,30,2005,0,5,15,30,Color.YELLOW,"Corba"));
        res.add(new Busy(2005,0,5,16,00,2005,0,5,18,00,Color.GREEN,"MSI"));

        res.add(new Busy(2005,0,6,8,30,2005,0,6,10,30,Color.GREEN,"MSI"));
        res.add(new Busy(2005,0,6,10,45,2005,0,6,12,45,Color.YELLOW,"Corba"));
        res.add(new Busy(2005,0,6,13,45,2005,0,6,18,00,Color.MAGENTA,"J2EE"));

        
        res.add(new Busy(2005,0,7,13,45,2005,0,7,15,45,Color.MAGENTA,"J2EE"));
        res.add(new Busy(2005,0,7,16,00,2005,0,7,17,00,Color.YELLOW,"Corba"));
        res.add(new Busy(2005,0,7,17,00,2005,0,7,18,00,Color.GREEN,"MSI"));

        res.add(new Busy(2005,0,10,11,45,2005,0,10,12,45,Color.MAGENTA,"J2EE"));
        res.add(new Busy(2005,0,10,13,45,2005,0,10,15,45,Color.YELLOW,"Corba"));
        res.add(new Busy(2005,0,10,16,00,2005,0,10,18,00,Color.GREEN,"MSI"));

        res.add(new Busy(2005,0,11,16,00,2005,0,11,18,00,Color.GREEN,"MSI"));
        
        
        res.add(new Busy(2005,0,12,8,30,2005,0,12,10,30,Color.YELLOW,"Corba"));
        res.add(new Busy(2005,0,12,13,45,2005,0,12,15,45,Color.MAGENTA,"J2EE"));

        
        res.add(new Busy(2005,0,13,8,30,2005,0,13,10,30,Color.YELLOW,"Corba"));
        res.add(new Busy(2005,0,13,13,45,2005,0,13,15,45,Color.MAGENTA,"J2EE"));
        res.add(new Busy(2005,0,13,16,00,2005,0,13,17,00,Color.GREEN,"MSI"));

        
        res.add(new Busy(2005,0,14,8,30,2005,0,14,10,30,Color.YELLOW,"Corba"));
        
        
        res.add(new Busy(2005,0,19,8,30,2005,0,19,10,30,Color.MAGENTA,"J2EE"));
        res.add(new Busy(2005,0,19,16,00,2005,0,3,17,00,Color.GREEN,"MSI"));

        res.add(new Busy(2005,0,27,10,00,2005,0,19,12,00,Color.GREEN,"MSI"));
        res.add(new Busy(2005,0,27,14,30,2005,0,19,17,30,Color.YELLOW,"Corba"));
        res.add(new Busy(2005,0,28,10,4,2005,0,19,12,45,Color.MAGENTA,"J2EE"));

        
        return res;
    }

}

