/*
 * Created on 12 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.common.gui.models;





import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.tools.Gap;



/**
 * Encapsulate a Busy and is number of Gap
 * 
 * @version 1.0
 * 
 * @author FlexiTeam - binou
 */
public class BusyBloc
{
    IBusy busy;
    int nbGap;


    /** 
     * @return nbGap
     * 
     */
    public int getNbGap()
    {
        return nbGap;
    }
    /** 
     * @param nbGap 
     * 
     */
    public void setNbGap(int nbGap)
    {
        this.nbGap = nbGap;
    }
    /**
     * 
     * @param busy
     * @param nbGap
     */
    public BusyBloc(IBusy busy, int nbGap)
    {
        this.busy=busy;
        this.nbGap=nbGap;
    }
    /**
     * DOCME
     * @param busyBloc
     */
    public BusyBloc(BusyBloc busyBloc)
    {
        ILesson lesson;
        if(busyBloc.getBusy() instanceof ILesson)
        {
            lesson = (ILesson)busyBloc.getBusy();
            //TODO !!!! ATTENTION COPY DE LA REF DU Lesson ICI !!!! A CHANGER
            //TODO verifier si on doit valuer le nbGap suivant le course ou le lesson
            this.busy = DataFactory.createLesson(lesson);    //new Busy(lesson.getBusy());
            this.nbGap = busyBloc.getNbGap();
        }
    }


    /** 
     * Returns the Busy encapsulate in the busyBloc
     *
     * @return  a busy
     * 
     */
    public IBusy getBusy()
    {
        return busy;
    }
    /** 
     * Sets the Busy encapsulate in the busyBloc
     *
     * @param busy 
     * 
     */
    public void setBusy(IBusy busy)
    {
        this.busy = busy;
    }
}
