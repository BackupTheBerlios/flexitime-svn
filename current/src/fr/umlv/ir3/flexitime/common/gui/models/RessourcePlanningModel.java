/*
 * Created on 5 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.gui.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.resources.IResource;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.common.tools.Gap;
import fr.umlv.ir3.flexitime.common.tools.Time;
import fr.umlv.ir3.flexitime.common.tools.TimeBloc;
import fr.umlv.ir3.flexitime.server.MetierSimulator;




/**
 * DOCME Description explication supplémentaire si nécessaire in english
 * please... Que fait cette classe, qu'est-ce qu'elle représente, ...
 * 
 * @version Verion ou révision SVN
 * @author FlexiTeam - binou
 */
public class RessourcePlanningModel extends AbstractPlanningModel
{
    private static FlexiLanguage language;
    static
    {
        language = FlexiLanguage.getInstance();
    }
    
    //Données dépendantes des préférences
    private final String[] tmpDayEnum = { "Lundi", "Mardi", "Mercredi", "Jeudi","Vendredi"};
    private final int      nbDays  = 5;
    //TODO faire un JSlider pour assurer la cohérence
    private final int      gapTime = 60;
    private final Gap edtWeekGap = new Gap(2005,1,3,0,0,2005,2,31,0,0);
    private final TimeBloc[] blocList;


    //Données calculées à mettre à jour
    private int            nbWeeks = 0;
    private int            nbGaps = 0;
    //private int            blocNbGapsList;

    
    //Données métiers à placer ordonnée dans une liste de semaine, contenante une liste de jour, avec la liste de tous les Busy dans l'ordre
    private List<List[]>           busyList;
    //Image des Busy encapsulé par des LessonBloc et structuré de la meme maniere => list de semaine avec une liste de jour et une liste de LessonBloc
    private List<DayBloc[]>         busyListImage;
    
    //TODO idée => fusionner les 2 listes pour gain de place
    


    //TODO gérer la fusion horizontalement !! ca serait top

    
    /**
     * DOCME
     */
    public RessourcePlanningModel(IResource ressource)
    {
        super();
     
        Set ressourceSet = ressource.getSetBusy();
        //ressourceSet.
        this.nbWeeks = Time.getGapWeek(edtWeekGap.getStartDate(),edtWeekGap.getEndDate()) + 1 ;
        
        /*this.blocList = new Gap[4];
        this.blocList[0] = new Gap(1901,1,1,8,30,1901,1,1,10,30);
        this.blocList[1] = new Gap(1901,1,1,10,45,1901,1,1,12,45);
        this.blocList[2] = new Gap(1901,1,1,13,45,1901,1,1,15,45);
        this.blocList[3] = new Gap(1901,1,1,16,0,1901,1,1,18,0);*/
        this.blocList = new TimeBloc[4];
        this.blocList[0] = new TimeBloc(8,30,10,30);
        this.blocList[1] = new TimeBloc(10,45,12,45);
        this.blocList[2] = new TimeBloc(13,45,15,45);
        this.blocList[3] = new TimeBloc(16,0,18,0);


        for (int i = 0; i < blocList.length; i++)
            this.nbGaps += countNbGap(blocList[i].countNbMinutes());
  
        // Je suppose :
        // -> Busy toutes comprises dans le créneau concerné ici
        // -> Busy valides (pas de chevauchement etc ...)
        // -> Busy dans l'ordre chronologique
        this.busyList = new ArrayList<List[]>(nbWeeks);
        this.busyListImage = new ArrayList<DayBloc[]>(nbWeeks);
        
        //this.initialyseDatas(MetierSimulator.getLessonsList());
        this.initialyseDatas(ressourceSet);
        //this.initialyseDatas(null);
        this.initialyseImage();
        
        System.out.println("nbWeeks=" + nbWeeks);
        System.out.println("nbBlocs=" + this.blocList.length);
        System.out.println("nbGap=" + this.nbGaps);
        
        for(Object busy : ressourceSet)
        {
            IBusy bus = (IBusy)busy;
            System.out.println("Busy : " + bus.getStartDate() + " => " + bus.getEndDate());
        }

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
     * Returns the number of blocs in a day
     * 
     * @return Returns the number of blocs in a day
     */
    public int getNbBloc()
    {

        return blocList.length;
    }


    
    /** 
     * Returns the number of gap in a day
     *
     * @return the number of gap in a day
     * 
     * @author   FlexiTeam - binou
     */
    public int getDayGapSize()
    {
        return this.nbGaps;
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
        return this.countNbGap(blocList[blocNumber].countNbMinutes());
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
        return (tmpDayEnum[dayNumber]);
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
        return language.formatShortTime( new Time(1901,1,1,blocList[blocNumber].getStartHour(),blocList[blocNumber].getStartMin()))  + "-" + language.formatShortTime(   new Time(1901,1,1,blocList[blocNumber].getEndHour(),blocList[blocNumber].getEndMin())   );
    }


    /** 
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
        //TODO bug sur la date
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
     * @author   FlexiTeam - binou
     */
    public Object getElementAt(int weekNumber, int dayNumber, int gapNumber)
    {
        return this.getDayBloc(weekNumber, dayNumber).getElementAt(gapNumber);
    }
    

    
    
    
    /** 
     * Returns the number of empty gap available after the specified gap
     *
     * @param weekNumber the value of the week (0 is the first)
     * @param dayNumber the value of the day (0 is the first)
     * @param gapNumber the value of the gap (0 is the first)
     * @return the number of empty gap
     * 
     * @author   FlexiTeam - binou
     */
    public int getNbEmptyGapAt(int weekNumber, int dayNumber, int gapNumber)
    {
        
        DayBloc bloc = this.getDayBloc(weekNumber, dayNumber);
        int count = 0;
        int i = gapNumber;
        while(i < bloc.representationList.length && !(bloc.representationList[i] == null || bloc.representationList[i] instanceof BusyBloc)  )
        {
            count++;
            i++;
        }
        return count;
    }
    
    
    /** 
     * Allow to know if there is a lesson a the specified week, day and gap
     *
     * @param weekNumber the value of the week (0 is the first)
     * @param dayNumber the value of the day (0 is the first)
     * @param gapNumber the value of the gap (0 is the first)
     * @return true if there's a lesson
     * 
     * @author   FlexiTeam - binou
     */
    public boolean isALesson(int weekNumber, int dayNumber, int gapNumber)
    {
        if(weekNumber >= this.nbWeeks || dayNumber >= this.nbDays || gapNumber >= this.nbGaps)
            return false;
        //System.out.println(weekNumber + "_" + dayNumber + "_" + gapNumber);
        DayBloc bloc = this.getDayBloc(weekNumber, dayNumber);
        Object o = bloc.getElementAt(gapNumber);
        return (o == null || o instanceof BusyBloc);
    }
    
    
    
    
    
    
	/**
     * @param weekNumber the value of the week (0 is the first)
     * @param dayNumber the value of the day (0 is the first)
     * @param gapNumber the value of the gap (0 is the first)
	 * @param lesson
	 */
	public void addElement(int weekNumber, int dayNumber, int gapNumber, BusyBloc lesson)
	{
		//Ici il faudra ajouter le cours au groupe et le faire valider par le serveur
		
	    //pas de verif avant de placer le cours pour l'instant
	    DayBloc bloc = this.getDayBloc(weekNumber, dayNumber);
	    bloc.representationList[gapNumber] = lesson;
	    if(lesson.getNbGap() > 1 )
	    {
	        for (int i = gapNumber+1 ; i < gapNumber+lesson.getNbGap() ; i++)
	            bloc.representationList[i] = null;
	    }
	    
	    
		fireIntervalAdded(weekNumber, dayNumber, gapNumber, gapNumber+lesson.getNbGap()-1 );
	}
    
    
       /** 
     * DOCME Description
     */
    public void increase()
    {
        //this.edtWeekGap;
    }



    /** 
     * DOCME Description
     */
    public void decrease()
    {
        this.busyList.remove(0);
        this.busyListImage.remove(0);
        this.nbWeeks -= 1;
    }



    /** 
     * DOCME Description
     */
    public void stepOver()
    {
        // TODO Auto-generated method stub
        
    }



    /** 
     * DOCME Description
     */
    public void stepBack()
    {
        // TODO Auto-generated method stub
        
    }



    /** 
     * DOCME Description
     */
    public void fullStepOver()
    {
        // TODO Auto-generated method stub
        
    }



    /** 
     * DOCME Description
     */
    public void fullStepBack()
    {
        // TODO Auto-generated method stub
        
    }




    
    
    





    //***************************************************
    // usefull methods
    //***************************************************


	private DayBloc getDayBloc(int weekNumber, int dayNumber)
	{
	    return ((DayBloc[])this.busyListImage.get(weekNumber))[dayNumber];
	}

	private int countNbGap(Time begin, Time end)
	{
		return Time.countNbMinute_HM(begin,end)/gapTime;
	}
    
    private int countNbGap(int nbMinutes)
    {
        return nbMinutes/gapTime;
    }
	
	
    private List getBusyList(int weekNumber, int dayNumber)
    {
        return ((List[])this.busyList.get(weekNumber))[dayNumber];
    }
    
    
    /*
     * Prend un liste de des Busy ordonnées et la reconstruis dans la structure Liste de semaine\liste de jour\liste de busy
     *
     */
    private void initialyseDatas(Set<IBusy> datas)
    {
        Iterator iter;
        if(datas != null)
            iter = datas.iterator();
        else
            iter = (new ArrayList()).iterator();
        
        //Cas ou il n'y a aucun Busy, on charge une DayList ki sera vide (aucun Busy)
        if(!iter.hasNext())
        {
            for(int i=0; i < this.nbWeeks;i++)
                this.busyList.add(new List[this.nbDays]);
            return;
        }
        
        
        IBusy curBusy = (IBusy)iter.next();
        //Pour chauqe semaine on va créer une dayList et y mettre la liste des Busy de chaque jour
        for(int week=0; week < this.nbWeeks;week++)
        {
            List<IBusy>[] dayList = new ArrayList[this.nbDays];
            //Ajout dans l'ordre ici add(week,dayList) implicite
            this.busyList.add(dayList);
            
            int dayNumber;
            boolean stop = false;
            //On parcours les Busy tant qu'ils correspondent à la semaine que l'on rempli
            while(!stop && isInWeek(curBusy,week))
            {
                dayNumber = curBusy.getGap().getStartDate().getIDayOfWeek();
                if(dayList[dayNumber] == null)
                    dayList[dayNumber] = new ArrayList<IBusy>(1);
                System.out.println("ajout de " + curBusy);
                dayList[dayNumber].add(curBusy);
                if(iter.hasNext())
                    curBusy = (IBusy)iter.next();
                else
                    stop = true;
            }
        }
    }
    
    private int getWeekNumber(IBusy curBusy)
    {
        return curBusy.getGap().getStartDate().getWeek() - this.edtWeekGap.getStartDate().getWeek();
    }
    
    private boolean isInWeek(IBusy curBusy, int week)
    {
        return 0 == (this.edtWeekGap.getStartDate().getWeek()+week - curBusy.getGap().getStartDate().getWeek());
    }


    private void initialyseImage()
    {
        DayBloc[] tab = null;
        for (int i = 0 ; i < nbWeeks ; i++)
        {
            tab = new DayBloc[tmpDayEnum.length];
            busyListImage.add(i, tab);
            for (int j = 0 ; j < tmpDayEnum.length ; j++)
            {
                tab[j] = new DayBloc();
                tab[j].init(getBusyList(i,j));
            }
        }
    }
    
    
    /**
     * Represent the composition of a day, with busy, empty gap and  
     * 
     * @version 1.5
     * 
     * @author FlexiTeam - binou
     */
    private class DayBloc
    {

        /**
         * Represent a the contents data in a day
         */
        public Object[] representationList;

        /**
         * Constructs a dayBloc
         */
        public DayBloc()
        {
            this.representationList = new Object[nbGaps];
            for (int i = 0 ; i < representationList.length ; i++)
                representationList[i]  = new Integer(0);
        }
        
        private void init(List list)
        {
            if(list == null || list.size() == 0)
                return;
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
                IBusy busy = (IBusy) iter.next();
                System.out.println("Busy : " + busy.getStartDate() + " => " + busy.getEndDate());
                
                //***************************************************************
                //  On cherche le premier bloc ki contient la date de debut du Busy
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
                //  On cherche le premier bloc ki contient la date de fin du Busy
                while( curBloc < blocList.length && Time.countNbMinute_HM( busy.getGap().getEndDate() , blocList[curBloc].getEndDate() ) < 0 )
                {
                    precSizeBloc += getBlocSize(curBloc);
                    curBloc++;
                }
                
                int lastGap;
//              Cas ou l'heure de fin dépasse le dernier creneau ... on affecte alors la derniere case
                if(curBloc == blocList.length)
                    lastGap = precSizeBloc -1;
                else
                {
                
                
                    int nbMinutes = Time.countNbMinute_HM( blocList[curBloc].getStartDate() , busy.getGap().getEndDate());
                    
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
                }
                    
                System.out.println("Bloc pour la fin : " + curBloc);
                System.out.println("Cours du gap " + firstGap + " au " + lastGap);
                
                //on place le LessonBloc sur le premier créneau
                this.representationList[firstGap] = new BusyBloc(busy,lastGap-firstGap+1);
                //On affecte tous les creneaux internes à null
                for(int i = firstGap+1; i <= lastGap; i++)
                    representationList[i]= null;
                
            }
        }

        /** 
         * Return an element At the specified indice
         *
         * @param gapNumber
         * @return the element
         * 
         */
        public Object getElementAt(int gapNumber)
        {
            return this.representationList[gapNumber];
        }
    }


} 