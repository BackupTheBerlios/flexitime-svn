/*
 * Created on 5 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.GL.test.edt.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import fr.umlv.ir3.GL.test.edt.Busy;
import fr.umlv.ir3.GL.test.edt.Gap;
import fr.umlv.ir3.GL.test.edt.MetierSimulator;

/**
 * DOCME Description explication supplémentaire si nécessaire in english
 * please... Que fait cette classe, qu'est-ce qu'elle représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * @author FlexiTeam - binou
 */
public class EDTModel
{

    //Données dépendantes des préférences
    private final String[] dayList = { "Lundi", "Mardi", "Mercredi", "Jeudi","Vendredi"};
    private final int      nbDays  = 5;
    //TODO faire un JSlider pour assurer la cohérence
    private final int      gapTime;
    //private final Gap fullDayHourGap;
    private final Gap edtWeekGap;
    private final Gap[] blocList;

    //Données dépendantes de l'appli
    //private Calendar       firstDate;
    //private Calendar       lastDate;

    //Données calculées à mettre à jour
    private int            nbWeeks;
    private int            nbGaps;

    //Données métiers à placer
    private List           busyList;
    private List           weekList;



    /**
     * DOCME
     */
    public EDTModel()
    {
        super();
        
        this.edtWeekGap = new Gap(2005,0,3,0,0,2005,1,8,0,0);
        this.gapTime = 30;
        
        this.blocList = new Gap[4];
        this.blocList[0] = new Gap(1901,1,1,8,30,1901,1,1,9,30);
        this.blocList[1] = new Gap(1901,1,1,10,45,1901,1,1,12,45);
        this.blocList[2] = new Gap(1901,1,1,13,45,1901,1,1,15,45);
        this.blocList[3] = new Gap(1901,1,1,16,0,1901,1,1,18,0);

        this.nbWeeks = edtWeekGap.getEndDate().getCal().get(Calendar.WEEK_OF_YEAR)
                - edtWeekGap.getStartDate().getCal().get(Calendar.WEEK_OF_YEAR) + 1;
        //this.nbGaps = this.getGapNumberBetween(blocList[0].getStartDate().getCal(), blocList[blocList.length-1].getEndDate().getCal());
        System.out.println("nbWeeks=" + nbWeeks);
        System.out.println("nbBlocs=" + this.blocList.length);
        
        this.nbGaps = 0;
        for (int i = 0; i < blocList.length; i++) {
			Gap gap = blocList[i];
			this.nbGaps += getGapNumberBetween(gap.getStartDate().getCal(),gap.getEndDate().getCal());
			//System.out.println("bloc["+i+"]="+ this.getNbGaps(i));
		}
        System.out.println("nbGap=" + this.nbGaps);
        
        this.busyList = MetierSimulator.getDatas();
        this.weekList = new ArrayList(nbWeeks);
        
        //this.initialyse();

    }

    /**
	 * @param gap
	 * @return
	 */
	private int countNbGap(Gap gap) {
		
		return 0;
	}

	/**
     * Return DOCME
     * 
     * @return Returns the nbDays.
     */
    public int getNbDays()
    {
        return nbDays;
    }

    /**
     * Return DOCME
     * 
     * @return Returns the nbGaps.
     */
    public int getNbGaps(int blocNumber)
    {
    	int nb = this.getGapNumberBetween(blocList[blocNumber].getStartDate().getCal(), blocList[blocNumber].getEndDate().getCal());

        return nb;
    }
    
    public int getNbGaps()
    {
        return 4;
    }
    
    /**
     * Return DOCME
     * 
     * @return Returns the nbGaps.
     */
    public int getNbBloc()
    {

        return blocList.length;
    }

    /**
     * Return DOCME
     * 
     * @return Returns the nbWeeks.
     */
    public int getNbWeeks()
    {
        return nbWeeks;
    }

    /**
     * Return an Integer which is the value of the week in its
     * year in order to constructs the Header of the week column <br>
     * Example :<code>model.getWeekHeaderAt(2)</code> will return 14 if the
     * second column of the planning is the 14th week of its year
     * 
     * @param weekNumber the order value of the weeks we are working on
     * @return an Integer which is the number of the week in its year
     * @author FlexiTeam - binou
     */
    public Object getWeekHeaderAt(int weekNumber)
    {
        //TODO retourner le Integer correspondant au numero réel de la semaine
        // dans l'année
        return (new Integer(1));
    }

    /**
     * DOCME Description Return a String which is the name of the day we want
     * <br>
     * in order to constructs the header of the Day in the planning Example :
     * <code>model.getDayHeaderAt(2)</code> will return "Mardi"
     * 
     * @param dayNumber the order value of the day we are working on
     * @return an String representation of this day
     * @author FlexiTeam - binou
     */
    public Object getDayHeaderAt(int dayNumber)
    {
        return (dayList[dayNumber]);
    }

    public Object getGapHeaderAt(int gapNumber)
    {
        //TODO valeure réelle
        return ("8h-10h");
    }

    public Object getDateHeaderAt(int weekNumber, int dayNumber)
    {
        //TODO valeure réelle a retourner
        Calendar res = Calendar.getInstance();
        res.set(2005, 12, 25);
        return res;
    }

    public Object getElementAt(int weekNumber, int dayNumber, int gapNumber)
    {
        System.out.println("get en ["+weekNumber+","+dayNumber+","+gapNumber+"]");
        DayBloc[] tabBloc = (DayBloc[])this.weekList.get(weekNumber-1);
        DayBloc bloc = tabBloc[dayNumber-1];
        LessonBloc l = bloc.getElementAt(gapNumber-1);
        if(l != null)
            System.out.println(l.toString());
        
        else
            System.out.println("null");
        
        if(weekNumber == 1 && dayNumber == 1)
            bloc.show();

        
        return  l;
        
    }

    //***************************************************
    // useful method
    //***************************************************

    private int getGapNumberBetween(Calendar debut, Calendar fin)
    {
        int diff = minutesBetween(debut, fin);
        return diff / gapTime;
    }

    private int minutesBetween(Calendar debut, Calendar fin)
    {

        long nbMinutes = fin.getTimeInMillis() - debut.getTimeInMillis();
        Long tmp = new Long(nbMinutes / 1000 / 60);
        return tmp.intValue();
    }

    private void initialyse()
    {
        //TODO ke des données pour la semaine 1 pour l'instant il faudra le
        // faire poru chaque semaine
        //on suppose les busy dans l'ordre chronologik
        //on suppose les busy cohérents, ne s'entrecoupent pas

        DayBloc[] tab = null;
        for (int i = 0 ; i < nbWeeks ; i++)
        {
            tab = new DayBloc[dayList.length];
            for (int j = 0 ; j < dayList.length ; j++)
            {
                tab[j] = new DayBloc(getBusyList(i,j));
                if(i== 0 && j == 0)
                    tab[j].show();
                weekList.add(0, tab);
            }
        }
    }
    
    
    private List getBusyList(int weekNumber, int dayNumber)
    {
        if(weekNumber == 0 && dayNumber == 0)
            return this.busyList;
        else
            return null;
    }

    private class DayBloc
    {

        private LessonBloc[] lessonBlocList;

        public DayBloc(List list)
        {
            if(list == null)
                list = new ArrayList();
            this.lessonBlocList = new LessonBloc[nbGaps];

            Iterator iter = list.iterator();
            Busy busy = null;
            LessonBloc curLessonBloc;
            if (iter.hasNext())
            {
                busy = (Busy) iter.next();
                curLessonBloc = new LessonBloc(busy);
            } else
                curLessonBloc = null;

            for (int i = 0 ; i < nbGaps ; i++)
            {
                if (curLessonBloc != null && curLessonBloc.getFirstGap() == i)
                {
                    lessonBlocList[i] = curLessonBloc;
                    i += curLessonBloc.getGapSize() - 1;
                    if (iter.hasNext())
                    {
                        busy = (Busy) iter.next();
                        curLessonBloc = new LessonBloc(busy);
                    } else
                        curLessonBloc = null;

                } else
                {
                    lessonBlocList[i] = new LessonBloc(i);
                }
            }

            //show();
        }
        
        public LessonBloc getElementAt(int gapNumber)
        {
            return this.lessonBlocList[gapNumber];
        }

        public void show()
        {
            for (int i = 0 ; i < lessonBlocList.length ; i++)
            {
                if(lessonBlocList[i] != null)
                {
                    System.out.println("=>[" + lessonBlocList[i].getFirstGap()
                        + "," + lessonBlocList[i].getLastGap() + ","
                        + lessonBlocList[i].getBusy() + "]");
                }
                else
                    System.out.println("null");
            }
        }
    }
    
    public class LessonBloc
    {

        int     firstGap;
        int     lastGap;
        int     gapSize;
        boolean breakInclusion = false;
        Busy    busy;

        public LessonBloc(int firstGap)
        {
            this.firstGap = firstGap;
            this.lastGap = firstGap;
            this.busy = null;
        }

        public LessonBloc(Busy busy)
        {
            this.busy = busy;
            this.firstGap = getGapNumberBetween(blocList[0].getEndDate().getCal(), busy.getDebut());
            this.lastGap = getGapNumberBetween(blocList[0].getEndDate().getCal(), busy.getFin()) - 1;
            //System.out.println("LessonBloc()");
            //System.out.println("firstGap -> " + firstGap);
            //System.out.println("lastGap -> " + lastGap);
            //System.out.println("gapSize -> " + getGapSize());
        }

        public boolean isBreakInclusion()
        {
            return breakInclusion;
        }

        public void setBreakInclusion(boolean breakInclusion)
        {
            this.breakInclusion = breakInclusion;
        }

        public Busy getBusy()
        {
            return busy;
        }

        public void setBusy(Busy busy)
        {
            this.busy = busy;
        }

        public int getFirstGap()
        {
            return firstGap;
        }

        public void setFirstGap(int firstGap)
        {
            this.firstGap = firstGap;
        }

        public int getGapSize()
        {
            return (this.lastGap - this.firstGap) + 1;
        }

        public int getLastGap()
        {
            return lastGap;
        }

        public void setLastGap(int lastGap)
        {
            this.lastGap = lastGap;
        }
        
        public String toString()
        {
            return new String("LessonBloc [" + firstGap +","+lastGap+":"+gapSize+"]");
        }
    }
}

