/*
 * Created on 8 janv. 2005
 * by VF
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.tools;

import java.util.HashMap;
import java.util.Iterator;

import fr.umlv.ir3.flexitime.common.data.activity.Busy;
import fr.umlv.ir3.flexitime.common.data.ressources.Teacher;


/**
 * Gets the stats of a resources
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - VF
 */
public class FlexiStat
{
    public static HashMap getStatTeacher(Teacher t){
        HashMap map = null;
        Iterator it = t.getLstBusy().iterator();
        while(it.hasNext()){
            Busy b = (Busy)it.next();
            // pb, je n'ai pas de cours dans Busy
        }
        return map;
    }

}

