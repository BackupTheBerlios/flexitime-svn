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
import fr.umlv.ir3.GL.test.edt.tool.Time;

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
    private final int      gapTime = 15;
    private final Gap edtWeekGap;
    private final Gap[] blocList;


    //Données calculées à mettre à jour
    private int            nbWeeks = 0;
    private int            nbGaps = 0;
    //private int            blocNbGapsList;

    
    //Données métiers à placer
    private List           busyList;
    private List           busyListImage;


    //TODO gérer la fusion horizontalement !! ca serait top

    /**
     * DOCME
     */
    public EDTModel()
    {
        super();
        
        this.edtWeekGap = new Gap(2005,0,3,0,0,2005,2,1,0,0);
        this.nbWeeks = edtWeekGap.getEndDate().getCal().get(Calendar.WEEK_OF_YEAR)
        - edtWeekGap.getStartDate().getCal().get(Calendar.WEEK_OF_YEAR) + 1;
        
        this.blocList = new Gap[4];
        this.blocList[0] = new Gap(1901,1,1,8,30,1901,1,1,10,30);
        this.blocList[1] = new Gap(1901,1,1,10,45,1901,1,1,12,45);
        this.blocList[2] = new Gap(1901,1,1,13,45,1901,1,1,15,45);
        this.blocList[3] = new Gap(1901,1,1,16,0,1901,1,1,18,0);


        for (int i = 0; i < blocList.length; i++)
            this.nbGaps += countNbGap(blocList[i].getStartDate(),blocList[i].getEndDate());
  
        // Je suppose :
        // -> Busy toutes comprises dans le créneau concerné ici
        // -> Busy valides (pas de chevauchement etc ...)
        // -> Busy dans l'ordre chronologique
        this.busyList = new ArrayList(nbWeeks);
        this.busyListImage = new ArrayList(nbWeeks);
        
        this.initialyseDatas(MetierSimulator.getDatas());
        this.initialyseImage();
        
        System.out.println("nbWeeks=" + nbWeeks);
        System.out.println("nbBlocs=" + this.blocList.length);
        System.out.println("nbGap=" + this.nbGaps);

    }





    /**
     * Returns the number of day in a week
     *
     * @return the number of day in a week
     * 
     * @author   FlexiTeam - binou
     */
    public int getNbDays()
    {
        return nbDays;
    }


    
    /** 
     * Returns the number of gap in a day
     *
     * @return the number of gap in a day
     * 
     * @author   FlexiTeam - binou
     */
    public int getNbGaps()
    {
        return this.nbGaps;
    }
    
    /**
     * Returns the number of blocs in a day
     * 
     * @return Returns the number of blocs in a day
     */
    public int getNbBloc()
    {

        return blocList.length;
    }
    

    /** 
     * Return the number of gap in a bloc
     *
     * @param blocNumber the number of the bloc (0 is the first one)
     * @return the bloc size
     * 
     * @author   FlexiTeam - binou
     */
    public int getBlocSize(int blocNumber)
    {
        return this.countNbGap(blocList[blocNumber].getStartDate(),blocList[blocNumber].getEndDate());
    }

    /**
     * Return the number of week of the content data in the model
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
     * @param weekNumber the value of the weeks (0 is the first week)
     * @return an Integer which is the number of the week in its year
     * @author FlexiTeam - binou
     */
    public Object getWeekHeaderAt(int weekNumber)
    {
        return (new Integer(this.edtWeekGap.getStartDate().getWeek()+weekNumber));
    }

    /**
     * Return a String which is the name of the day we want
     * <br>
     * in order to constructs the header of the Day in the planning Example :
     * <code>model.getDayHeaderAt(2)</code> will return "Mardi"
     * 
     * @param dayNumber the value of the day (0 is the first)
     * @return an String representation of this day
     * @author FlexiTeam - binou
     */
    public Object getDayHeaderAt(int dayNumber)
    {
        return (dayList[dayNumber]);
    }

    /**
     * Return a String which is the representation of a gap
     * <br>
     * in order to constructs the header of the gap in the planning<br>
     * Example :
     * <code>getGapHeaderAt(0)</code> could return "8h30-10h30"
     * 
     * @param blocNumber the value of the bloc (0 is the first)
     * @return an String representation of this day
     * @author FlexiTeam - binou
     */
    public Object getGapHeaderAt(int blocNumber)
    {
        return blocList[blocNumber].getStartDate().getTime() + "-" + blocList[blocNumber].getEndDate().getTime();
    }


    /** 
     * DOCME Description
     * Return a Calendar in order to constructs the header of a date in the planning<br>
     * at the specified week and day <br>
     *
     * @param weekNumber the value of the week (0 is the first)
     * @param dayNumber the value of the day (0 is the first)
     * @return a Calendar set at the date 
     * 
     * @author   FlexiTeam - binou
     */
    public Object getDateHeaderAt(int weekNumber, int dayNumber)
    {
        //TODO valeure réelle a retourner
        Calendar res = (Calendar)this.edtWeekGap.getStartDate().getCal().clone();
        res.add(Calendar.DAY_OF_MONTH,weekNumber*7+dayNumber);
        
        return res;
    }

    /** 
     * Return the element at the specified index<br>
     * (should be a Busy)
     * <code>exemple d'appel de la methode</code>
     *
     * @param weekNumber the value of the week (0 is the first)
     * @param dayNumber the value of the day (0 is the first)
     * @param gapNumber the value of the gap (0 is the first)
     * @return the Object at the specified index
     * 
     * @see (si nécessaire)
     * @author   FlexiTeam - binou
     */
    public Object getElementAt(int weekNumber, int dayNumber, int gapNumber)
    {
        return ((DayBloc[])this.busyListImage.get(weekNumber))[dayNumber].getElementAt(gapNumber);
    }
    


    //***************************************************
    // useful method
    //***************************************************
    

	private int countNbGap(Time begin, Time end)
	{
		return Time.countNbMinute_HM(begin,end)/gapTime;
	}
	
    private List getBusyList(int weekNumber, int dayNumber)
    {
        return ((List[])this.busyList.get(weekNumber))[dayNumber];
    }
    
    
    private void initialyseDatas(List datas)
    {
        Iterator iter = datas.iterator();
        if(!iter.hasNext())
        {
            for(int i=0; i < this.nbWeeks;i++)
                this.busyList.add(new List[this.nbDays]);
            return;
        }
        Busy curBusy = (Busy)iter.next();
        for(int week=0; week < this.nbWeeks;week++)
        {
            List[] dayList = new List[this.nbDays];
            this.busyList.add(dayList);
            int dayNumber;
            boolean stop = false;
            while(!stop && isInWeek(curBusy,week))
            {
                dayNumber = curBusy.getGap().getStartDate().getIDayOfWeek()-2;
                if(dayList[dayNumber] == null)
                    dayList[dayNumber] = new ArrayList();
                dayList[dayNumber].add(curBusy);
                if(iter.hasNext())
                    curBusy = (Busy)iter.next();
                else
                    stop = true;
            }
            
            
        }
    }
    
    
    private boolean isInWeek(Busy curBusy, int week)
    {
        return 0 == (this.edtWeekGap.getStartDate().getWeek()+week - curBusy.getGap().getStartDate().getWeek());
    }


    
    private void initialyseImage()
    {
        DayBloc[] tab = null;
        for (int i = 0 ; i < nbWeeks ; i++)
        {
            tab = new DayBloc[dayList.length];
            busyListImage.add(i, tab);
            for (int j = 0 ; j < dayList.length ; j++)
            {
                tab[j] = new DayBloc();
                tab[j].init(getBusyList(i,j));
            }
        }
    }
    
    


    private class DayBloc
    {

        private Object[] representationList;

        public DayBloc()
        {
            this.representationList = new Object[nbGaps];
            for (int i = 0 ; i < representationList.length ; i++)
                representationList[i]  = new Object();
        }
        
        public void init(List list)
        {
            if(list == null || list.size() == 0)
                return;
            else
                placeBusy(list);
        }
        
        
        /** 
         * Place all the busy in the list in the appropriate form in the DayBloc's representationList
         *
         * @param list 
         * 
         * @author   FlexiTeam - binou
         */
        private void placeBusy(List list)
        {
            int curBloc = 0;
            int precSizeBloc = 0;
            for (Iterator iter = list.iterator() ; iter.hasNext() ;)
            {
                Busy busy = (Busy) iter.next();
                
                //***************************************************************
                //	On cherche le premier bloc ki contient la date de debut du Busy
                while( curBloc < blocList.length && Time.countNbMinute_HM( busy.getGap().getStartDate() , blocList[curBloc].getEndDate() ) <= 0 )
                {
                    precSizeBloc += getBlocSize(curBloc);
                    curBloc++;
                }
                
                //cas d'erreur, le cours a placer est en dehors des plages horaires
                if(curBloc == blocList.length)
                    return; //TODO lever une exception

                //On cherche le numéro du Gap ki le contiendra dans ce bloc et on ajoute tous les gap des blocs d'avant
                int firstGap = countNbGap(blocList[curBloc].getStartDate() ,  busy.getGap().getStartDate()) +precSizeBloc;
                //cas ou la date de début est entre des blocs
                if(Time.countNbMinute_HM( blocList[curBloc].getStartDate() , busy.getGap().getStartDate() ) < 0)
                    firstGap = precSizeBloc;
                    

                System.out.println("Bloc pour le debut : " + curBloc);
                
                
                
                //***************************************************************
                //	On cherche le premier bloc ki contient la date de fin du Busy
                while( curBloc < blocList.length && Time.countNbMinute_HM( busy.getGap().getEndDate() , blocList[curBloc].getEndDate() ) < 0 )
                {
                    precSizeBloc += getBlocSize(curBloc);
                    curBloc++;
                }
                
                
                
                int lastGap;
                int nbMinutes = Time.countNbMinute_HM( blocList[curBloc].getStartDate() , busy.getGap().getEndDate());
                //Cas ou l'heure de fin dépasse le dernier creneau ... on affecte alors la derniere case
                if(curBloc == blocList.length)
                    lastGap = getBlocSize(curBloc-1)-1+precSizeBloc;
                //cas ou la date de fin se trouve entre 2 blocs ! on lui donne donc la taille des blocs précédents 
                if(nbMinutes <= 0)
                    lastGap = precSizeBloc-1;
                else
                {
                    lastGap = nbMinutes/gapTime + precSizeBloc;
                    //cas ou l'heure de fin est l'heure d'un creneau ... on enleve 1 pour ne pas empieter sur le creneau d'apres
                    if(nbMinutes%gapTime == 0)
                        lastGap--;
                }
                    
                System.out.println("Bloc pour la fin : " + curBloc);
                System.out.println("Cours du gap " + firstGap + " au " + lastGap);
                
                //On affecte tous les creneaux internes à null
                for(int i = firstGap+1; i <= lastGap; i++)
                    representationList[i]= null;
                //puis on place le Busy sur le premier créneau
                this.representationList[firstGap] = new LessonBloc(busy,lastGap-firstGap+1);
            }
        }

        public Object getElementAt(int gapNumber)
        {
            return this.representationList[gapNumber];
        }
    }
    
   
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

    }
}

