/*
 * Created on 5 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package temp;

import java.awt.Color;



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
    private Gap gap;
    
    private String reason;
    
    private Color color;
    


    
    public Gap getGap()
    {
        return gap;
    }
    public void setGap(Gap gap)
    {
        this.gap = gap;
    }
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
        this.color = color;
        this.reason = reason;
        this.gap = new Gap(startYear,startMonth,startDate,startHour,startMinute,endYear,endMonth,endDate,endHour,endMinute);
        
    }

    public Color getColor()
    {
        return color;
    }
    public void setColor(Color color)
    {
        this.color = color;
    }
    
 
}

