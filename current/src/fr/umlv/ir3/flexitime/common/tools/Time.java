/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.tools;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Time - DOCME Description Tool for time This Class allows the users to work
 * with Time Object And to have it under different kinds
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public class Time
{
    int iYear;
    int iMonth;
    String strMonth;
    int iDay;
    
    int iHour;
    int iMinute;
    int iSecond;
    int iMSecond;
    
    String strDate;
    String strTime;
    
    boolean right;
    
    public Time(){
        Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH);
        int d = c.get(Calendar.DAY_OF_MONTH);
        int h = c.get(Calendar.HOUR);
        int min = c.get(Calendar.MINUTE);
        int s = c.get(Calendar.SECOND);
        int ms = c.get(Calendar.MILLISECOND);
        System.out.println(d+"/"+m+"/"+y+" "+h+":"+min+":"+s+":"+ms);
        
    }
    
    public Time(String strD,String strT){
        if(!isDate(strD) || !isTime(strT)){
            right = false;
            return;
        }
        strDate = strD;
        strTime = strT;
        iDay = new Integer(strD.substring(0,2)).intValue();
        iMonth = new Integer(strD.substring(3,5)).intValue();
        iYear = new Integer(strD.substring(6,10)).intValue();
        strMonth = getMonth(iMonth);
        
        iHour = new Integer(strT.substring(0,2)).intValue();
        iMinute = new Integer(strT.substring(3,5)).intValue();
        iSecond = new Integer(strT.substring(6,8)).intValue();
        iMSecond = new Integer(strT.substring(9,12)).intValue();
    }
    
    public static void main(String[] args){
        //Time t = new Time("01/01/2005","01:02:03:004");
        //System.out.println(t.getIDay()+"/"+t.getIHour()+"/"+t.getIYear());
        //System.out.println(t.getIHour()+":"+t.getIMinute()+":"+t.getISecond()+":"+t.getIMSecond());
        //System.out.println(t.getStrMonth());
        //System.out.println(t.getStrDate()+" "+t.getStrTime());
        Time t = new Time();
    }
    
    private boolean isDate(String str){
        if(str.length()!=10) return false;
        if(!str.substring(2,3).equals("/") || !str.substring(5,6).equals("/")) return false;
        try{
            int day = new Integer(str.substring(0,2)).intValue();
            int month = new Integer(str.substring(3,5)).intValue();
            new Integer(str.substring(6,10)).intValue();
            if(!isDay(day)) return false;
            if(!isMonth(month)) return false;
        }catch(Exception e){
            return false;
        }
        return true;
    }
     
    private boolean isTime(String str){
         if(str.length()!=12) return false;
         if(!str.substring(2,3).equals(":") || !str.substring(5,6).equals(":") || !str.substring(8,9).equals(":")) return false;
         try{
             int hour = new Integer(str.substring(0,2)).intValue();
             int minute = new Integer(str.substring(3,5)).intValue();
             int second = new Integer(str.substring(6,8)).intValue();
             int msecond = new Integer(str.substring(9,12)).intValue();
             if(!isHour(hour)) return false;
             if(!isMinute(minute)) return false;
             if(!isSecond(second)) return false;
             if(!isMSecond(msecond)) return false;
         }catch(Exception e){
             return false;
         }
         return true;
    }
    
    private String getMonth(int m){
        String str = null;
        switch(m){
            case 1: str = "Janvier";break;
            case 2: str = "Février";break;
            case 3: str = "Mars";break;
            case 4: str = "Avril";break;
            case 5: str = "Mai";break;
            case 6: str = "Juin";break;
            case 7: str = "Juillet";break;
            case 8: str = "Août";break;
            case 9: str = "Septembre";break;
            case 10: str = "Octobre";break;
            case 11: str = "Novembre";break;
            case 12: str = "Décembre";break;
        }
        return str;
    }
    
    private boolean isMonth(int m){
        if(m>=1 && m<=12) return true;
        return false;
    }
    private boolean isDay(int d){
        if(d>=1 && d<=31) return true;
        return false;
    }
    private boolean isHour(int h){
        if(h>=0 && h<=23) return true;
        return false;
    }
    private boolean isMinute(int m){
        if(m>=0 && m<=59) return true;
        return false;
    }
    private boolean isSecond(int s){
        if(s>=0 && s<=59) return true;
        return false;
    }
    private boolean isMSecond(int ms){
        if(ms>=0 && ms<=99) return true;
        return false;
    }

    /**
     * Return DOCME
     * @return Returns the iDay.
     */
    public int getIDay() {
        return iDay;
    }
    /**
     * Return DOCME
     * @return Returns the iHour.
     */
    public int getIHour() {
        return iHour;
    }
    /**
     * Return DOCME
     * @return Returns the iMinute.
     */
    public int getIMinute() {
        return iMinute;
    }
    /**
     * Return DOCME
     * @return Returns the iMonth.
     */
    public int getIMonth() {
        return iMonth;
    }
    /**
     * Return DOCME
     * @return Returns the iMSecond.
     */
    public int getIMSecond() {
        return iMSecond;
    }
    /**
     * Return DOCME
     * @return Returns the iSecond.
     */
    public int getISecond() {
        return iSecond;
    }
    /**
     * Return DOCME
     * @return Returns the iYear.
     */
    public int getIYear() {
        return iYear;
    }
    /**
     * Return DOCME
     * @return Returns the strDate.
     */
    public String getStrDate() {
        return strDate;
    }
    /**
     * Return DOCME
     * @return Returns the strMonth.
     */
    public String getStrMonth() {
        return strMonth;
    }
    /**
     * Return DOCME
     * @return Returns the strTime.
     */
    public String getStrTime() {
        return strTime;
    }
    /**
     * Return DOCME
     * @return Returns the right.
     */
    public boolean isRight() {
        return right;
    }
}