/*
 * Created on 23 déc. 2004
 * by Famille
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.activity;




/**
 * TeacherBusy
 * This interface represents the unavailabilities for a teacher
 * 
 * @version Révision 72
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface TeacherBusy extends Busy{
    
	
    public final static int REASON_WORK=1;
    public final static int REASON_HOLLYDAYS=2;
    public final static int REASON_SICK=3;
    public final static int REASON_STAGE=4;
    public final static int REASON_PERSO=5;
	  
	  /** 
	   * setReason 
	   * changes the Reason of the unavailabilities.
	   * 
	   * @param iReason the Reason of the unavailabilities.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     20 déc. 2004
	   */
	  void setReason(int iReason);
	  

}
