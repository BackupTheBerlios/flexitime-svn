/*
 * Created on 12 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.test.edt;


import temp.Busy;

/**
 * Encapsulate a Busy and is number of Gap
 * 
 * @version 1.0
 * 
 * @author FlexiTeam - binou
 */
public class LessonBloc
{
    Busy busy;
    int nbGap;

    public Busy getBusy()
    {
        return busy;
    }
    public int getNbGap()
    {
        return nbGap;
    }

    public LessonBloc(Busy busy, int nbGap)
    {
        this.busy=busy;
        this.nbGap=nbGap;
    }
    /**
     * DOCME
     * @param lesson
     */
    public LessonBloc(LessonBloc lesson)
    {
        //this.busy = new Busy(lesson.getBusy());
        this.nbGap = lesson.getNbGap();
    }


}
