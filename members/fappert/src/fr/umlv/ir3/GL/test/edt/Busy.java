/*
 * Created on 5 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.GL.test.edt;

import java.awt.Color;
import java.util.Calendar;



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
public class Busy
{
    private Calendar debut;
    private Calendar fin;
    
    private String reason;
    
    


    
    public String getReason()
    {
        return reason;
    }
    public void setReason(String reason)
    {
        this.reason = reason;
    }
    public Busy(int startYear, int startMonth, int startDate, int startHour, int startMinute, int endYear, int endMonth, int endDate, int endHour, int endMinute, Color color, String reason)
    {
        this.debut = Calendar.getInstance();
        this.debut.set(startYear,startMonth,startDate,startHour,startMinute);
        this.fin = Calendar.getInstance();
        this.fin.set(endYear,endMonth,endDate,endHour,endMinute);
        this.reason = reason;
    }

    public Color getColor()
    {
        return color;
    }
    public void setColor(Color color)
    {
        this.color = color;
    }
    private Color color;
 
    public Calendar getDebut()
    {
        return debut;
    }
    public void setDebut(Calendar debut)
    {
        this.debut = debut;
    }
    public Calendar getFin()
    {
        return fin;
    }
    public void setFin(Calendar fin)
    {
        this.fin = fin;
    }
}

