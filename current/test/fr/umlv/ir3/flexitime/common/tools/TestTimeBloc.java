/*
 * Created on 20 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.tools;

import junit.framework.TestCase;


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
public class TestTimeBloc extends TestCase
{
    
    public void testIsInclude()
    {
        TimeBloc bloc = new TimeBloc(8,30,10,30);
        Time t = new Time(1901,1,1,9,30);
        if( bloc.isInclude(t) != true  ) fail();
        t = new Time(1901,1,1,10,30);
        if( bloc.isInclude(t) != false  ) fail();
        t = new Time(1901,1,1,11,30);
        if( bloc.isInclude(t) != false  ) fail();
        t = new Time(1901,1,1,15,45);
        if( bloc.isInclude(t) != false  ) fail();
    }
    
    public void testCountNbMinutesBefore()
    {
        TimeBloc bloc = new TimeBloc(8,30,10,30);
        Time t = new Time(1901,1,1,8,45);
        System.out.println(bloc.countNbMinutesBefore(t));
        if( bloc.countNbMinutesBefore(t) != 120  ) fail();
    }
    
    public void testCountNbMinutesAfter()
    {
        TimeBloc bloc = new TimeBloc(8,30,10,30);
        Time t = new Time(1901,1,1,9,30);
        if( bloc.countNbMinutesAfter(t) != 60  ) fail();
    }

}

