/*
 * Created on 7 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.GL.test.edt;

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
        res.add(new Busy(2005,0,3,14,00,2005,0,3,15,00,Color.MAGENTA,"J2EE"));
        res.add(new Busy(2005,0,3,16,00,2005,0,3,18,00,Color.GREEN,"MSI"));
        return res;
    }

}

