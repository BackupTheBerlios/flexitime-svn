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
import java.util.TreeSet;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.resources.IResource;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.common.tools.Gap;
import fr.umlv.ir3.flexitime.common.tools.Time;
import fr.umlv.ir3.flexitime.common.tools.TimeBloc;


/**
 * DOCME Description explication supplémentaire si nécessaire in english
 * please... Que fait cette classe, qu'est-ce qu'elle représente, ...
 * 
 * @version 1.0
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
    private final String[] tmpDayEnum = { "Lundi", "Mardi", "Mercredi", "Jeudi","Vendredi"}; //$NON-NLS-1$
    private final int      nbDays  = 5;
    
    
    private final int gapUnit = 15;
    private int gapMultiplicateur = 4;
    private int      gapTime;
    
    private final TimeBloc[] blocList;


    //Données calculées à mettre à jour
    //Attention a bien mettre le premier Gap a 00:01 et le dernier a 23:59
    private Gap             edtWeekGap;
    private int            nbWeeks = 0;
    private int            nbGaps = 0;
    //private int            blocNbGapsList;

    //La ressoruce
    private IResource ressource;
    //Totues les indispo de la Ressource
    private Set<IBusy> ressourceSet;
    //Données métiers à placer ordonnée dans une liste de semaine, contenante une liste de jour, avec la liste de tous les Busy dans l'ordre
    private List<List[]>           busyList;
    //Image des Busy encapsulé par des LessonBloc et structuré de la meme maniere => list de semaine avec une liste de jour et une liste de LessonBloc
    private List<DayBloc[]>         busyListImage;
    
    //TODO faire un JSlider pour assurer la cohérence
    //TODO idée => fusionner les 2 listes pour gain de place
    //TODO gérer la fusion horizontalement !! ca serait top

    
    /**
     * Constructs a Model according to the specified Ressource
     * and the initial Gap to handle
     *  
     * @param _ressource the ressource concerned by the planning
     * @param initialGap th initial gap handle to create the model
     */
    public RessourcePlanningModel(IResource _ressource, Gap initialGap)
    {
        super();

        this.ressource = _ressource;
        this.ressourceSet = ressource.getSetBusy();
        this.edtWeekGap = initialGap;
        
        this.blocList = new TimeBloc[4];
        this.blocList[0] = new TimeBloc(8,30,10,30);
        this.blocList[1] = new TimeBloc(10,45,12,45);
        this.blocList[2] = new TimeBloc(13,45,15,45);
        this.blocList[3] = new TimeBloc(16,0,18,0);

        initWorkingData();
        initDataList();
        
  
        // Je suppose :
        // -> Busy toutes comprises dans le créneau concerné ici
        // -> Busy valides (pas de chevauchement etc ...)
        // -> Busy dans l'ordre chronologique
        

        
        //System.out.println("Debut : " + this.edtWeekGap.getStartDate().getStrDate());
        //System.out.println("Fin : " + this.edtWeekGap.getEndDate().getStrDate());


    }

    private void initWorkingData()
    {
        this.gapTime = this.gapUnit * this.gapMultiplicateur;
        this.nbWeeks = Time.getGapWeek(edtWeekGap.getStartDate(),edtWeekGap.getEndDate()) + 1 ;
        this.nbGaps = 0;
        for (int i = 0; i < blocList.length; i++)
            this.nbGaps += countNbGap(blocList[i].countNbMinutes());
        
        System.out.println("nbWeeks=" + nbWeeks); //$NON-NLS-1$
        System.out.println("nbBlocs=" + this.blocList.length); //$NON-NLS-1$
        System.out.println("nbGap=" + this.nbGaps); //$NON-NLS-1$
    }
    
    private void initDataList()
    {
        this.initialyseDatas(subSet(this.ressourceSet,this.edtWeekGap));
        //this.initialyseDatas(MetierSimulator.getLessonsList());
        //this.initialyseDatas(null);
        this.initialyseImage();  
    }

    private Set subSet(Set<IBusy> from, Gap gap)
    {
        boolean stop = false;
        TreeSet<IBusy> set = new TreeSet<IBusy>();
        if(from == null)
            return set;
        Iterator iter = from.iterator();
        if(!iter.hasNext())
            return set;
        IBusy busy = (IBusy) iter.next();
        while(!stop &&  Time.compare(busy.getGap().getStartDate() , gap.getEndDate()) == -1)
        {
            //System.out.println("************************");
            //System.out.println(busy.getGap().getStartDate().getStrDate());
            //System.out.println(busy.getGap().getEndDate().getStrDate());
            
            if(Time.compare(busy.getGap().getStartDate() , gap.getStartDate()) == 1)
                set.add(busy);

            if(iter.hasNext())
                busy = (IBusy) iter.next();
            else
                stop = true;
        }
        
        return set;
        
        //Gap start = new Gap(gap.getStartDate().getCal(), gap.getStartDate().getCal());
        //Gap end = new Gap(gap.getEndDate().getCal(), gap.getEndDate().getCal());
        //return (TreeSet)from.subSet(DataFactory.createLesson(start,null, new ArrayList(),0) , DataFactory.createLesson(end,null,new ArrayList(),0));
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
     * return the current Gap that use le model
     *
     * @return the gap
     * 
     */
    public Gap getCurrentGap()
    {
        return edtWeekGap;
    }
    



    /** 
     * Get the multiplier used to calculate the gapTime
     *
     * @return the multiplier
     * 
     * @see RessourcePlanningModel#getGapUnit()
     * 
     */
    public int getGapMultiplicateur()
    {
        return gapMultiplicateur;
    }
    
    /** 
     * Get the unit used to calculate the gapTime
     *
     * @return the unit in minutes
     * 
     * @see RessourcePlanningModel#getGapMultiplicateur()
     */
    public int getGapUnit()
    {
        return gapUnit;
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
        return language.formatShortTime( new Time(1901,1,1,blocList[blocNumber].getStartHour(),blocList[blocNumber].getStartMin()))  + "-" + language.formatShortTime(   new Time(1901,1,1,blocList[blocNumber].getEndHour(),blocList[blocNumber].getEndMin())   ); //$NON-NLS-1$
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
        Calendar res = (Calendar)this.edtWeekGap.getStartDate().getCal().clone();
        res.add(Calendar.DAY_OF_MONTH,weekNumber*7+dayNumber);
        /*System.out.println("demande sur semaine " + weekNumber + " jour " + dayNumber);
        System.out.println("jour " + res.get(Calendar.DAY_OF_MONTH));
        System.out.println("mois " + res.get(Calendar.MONTH));
        System.out.println("année " + res.get(Calendar.YEAR));*/
        
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
     * Add a BusyBloc to the contents data
     * 
     * @param weekNumber the value of the week (0 is the first)
     * @param dayNumber the value of the day (0 is the first)
     * @param gapNumber the value of the gap (0 is the first)
	 * @param lesson
	 */
	public void addElement(int weekNumber, int dayNumber, int gapNumber, BusyBloc lesson)
	{
		//Ici il faudra ajouter le cours au groupe et le faire valider par le serveur
		
	    //pas de verif avant de placer le cours pour l'instant, mais le controle a deja été fait dans le controleur normalement
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
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param weekNumber
     * @param dayNumber
     * @param gapNumber 
     * 
     */
    public void updateLesson(int weekNumber, int dayNumber, int gapNumber)
    {
        //le BusyBloc a normalement déja été changé
        //TODO communication au serveur

        BusyBloc busyBloc = (BusyBloc)this.getDayBloc(weekNumber, dayNumber).getElementAt(gapNumber);
        
        fireContentsChanged(weekNumber,dayNumber,gapNumber,gapNumber+busyBloc.getNbGap());
    }
    
    
    
    
    /** 
     * Change the range of week currently used for the planning<br>
     * the result will be the previous Gap of week
     */
    public void fullStepBack()
    {
        this.edtWeekGap.getStartDate().addWeek(-this.nbWeeks);
        this.edtWeekGap.getEndDate().addWeek(-this.nbWeeks);

        this.initDataList();
    }
    
    /** 
     * Change the range of week currently used for the planning<br>
     * the result will be the same gap but one week earlier
     */
    public void stepBack()
    {
//      TODO optimiser en ne faisant ke l'ajout
        this.edtWeekGap.getStartDate().addWeek(-1);
        this.edtWeekGap.getEndDate().addWeek(-1);

        this.initDataList();
        
    }
    

    /** 
     * Change the range of week currently used for the planning<br>
     * the result will be the the same gap without the ending week
     */
    public void decrease()
    {
        this.edtWeekGap.getEndDate().addWeek(-1);
        this.nbWeeks -= 1;

        this.busyList.remove(this.busyList.size()-1);
        this.busyListImage.remove(this.busyListImage.size()-1);
    }
    
    /** 
     * Change the range of week currently used for the planning<br>
     * the result will be the the same gap with another week added
     */
    public void increase()
    {
        this.edtWeekGap.getEndDate().addWeek(1);
        this.nbWeeks += 1;
        
        this.initDataList();
    }
    

    /** 
     * Change the range of week currently used for the planning<br>
     * the result will be the same gap but one week later
     */
    public void stepOver()
    {
        this.edtWeekGap.getStartDate().addWeek(1);
        this.edtWeekGap.getEndDate().addWeek(1);
        
        this.initDataList();
        
    }


    /** 
     * Decrease the size of gap's time
     */
    public void lessGapTime()
    {
        if(this.gapMultiplicateur < 2)
            return;
        this.gapMultiplicateur = this.gapMultiplicateur/2;
        this.initWorkingData();
        this.initDataList();
    }
    
    /** 
     * Increase the size of gap's time
     */
    public void moreGapTime()
    {
        if(this.gapMultiplicateur > 4)
            return;
        this.gapMultiplicateur = this.gapMultiplicateur*2;
        this.initWorkingData();
        this.initDataList();
    }





    /** 
     * Change the range of week currently used for the planning<br>
     * the result will be the next Gap of week
     */
    public void fullStepOver()
    {
        this.edtWeekGap.getStartDate().addWeek(this.nbWeeks);
        this.edtWeekGap.getEndDate().addWeek(this.nbWeeks);

        this.initDataList();
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
    private void initialyseDatas(Set datas)
    {
        this.busyList = new ArrayList<List[]>(nbWeeks);
        
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
            //System.out.println(isInWeek(curBusy,week));
            //On parcours les Busy tant qu'ils correspondent à la semaine que l'on rempli
            while(!stop && isInWeek(curBusy,week))
            {
                dayNumber = curBusy.getGap().getStartDate().getIDayOfWeek();
                if(dayList[dayNumber] == null)
                    dayList[dayNumber] = new ArrayList<IBusy>(1);
                //System.out.println("ajout de " + curBusy.getGap().getStartDate().getStrDate());
                dayList[dayNumber].add(curBusy);
                if(iter.hasNext())
                    curBusy = (IBusy)iter.next();
                else
                    stop = true;
            }
        }
    }
    
    /*private int getWeekNumber(IBusy curBusy)
    {
        return curBusy.getGap().getStartDate().getWeek() - this.edtWeekGap.getStartDate().getWeek();
    }*/
    
    private boolean isInWeek(IBusy curBusy, int week)
    {
        //System.out.println("-------------------------");
        //System.out.println("test de " + curBusy.getGap().getStartDate().getStrDate() + " => " + curBusy.getGap().getEndDate().getStrDate());
        //System.out.println("sur week " + week);
        //System.out.println(this.edtWeekGap.getStartDate().getWeek());
        Time t = new Time((Calendar)this.edtWeekGap.getStartDate().getCal().clone());
        t.addWeek(week);
        //System.out.println("Apres ajout : " + t.getWeek());
        //System.out.println(curBusy.getGap().getStartDate().getWeek());
        
        return t.getWeek() == curBusy.getGap().getStartDate().getWeek();
    }


    private void initialyseImage()
    {
        this.busyListImage = new ArrayList<DayBloc[]>(nbWeeks);
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
                //System.out.println("Busy : " + busy.getStartDate() + " => " + busy.getEndDate());
                
                //***************************************************************
                //  On cherche le premier bloc ki contient la date de debut du Busy
                while( curBloc < blocList.length && Time.countNbMinute_HM( busy.getGap().getStartDate() , blocList[curBloc].getEndDate() ) <= 0 )
                {
                    precSizeBloc += getBlocSize(curBloc);
                    curBloc++;
                }
                
                //cas d'erreur, le cours a placer est en dehors des plages horaires
                if(curBloc == blocList.length)
                    return;

                //On cherche le numéro du Gap ki le contiendra dans ce bloc et on ajoute tous les gap des blocs d'avant
                int firstGap = countNbGap(blocList[curBloc].getStartDate() ,  busy.getGap().getStartDate()) +precSizeBloc;
                //cas ou la date de début est entre des blocs
                if(Time.countNbMinute_HM( blocList[curBloc].getStartDate() , busy.getGap().getStartDate() ) < 0)
                    firstGap = precSizeBloc;
                    

                //System.out.println("Bloc pour le debut : " + curBloc);
                
                
                
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
                    
                //System.out.println("Bloc pour la fin : " + curBloc);
                //System.out.println("Cours du gap " + firstGap + " au " + lastGap);
                
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