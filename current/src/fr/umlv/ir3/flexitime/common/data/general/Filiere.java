/*
 * Created on 13 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.common.data.general;

import java.util.List;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface Filiere extends General {
	/** returns the list of promomotions.
	   * @return the list of promotions.
	   */
	  List getLstPromotion();
	  
	  /** changes the name.
	   *  @param name .
	   */
	  void setLstPromotion(List lstPromotion);
	  
	  /** add a promotion in a filiere
	   * @return the list of promotions.
	   */
	  void addPromotion(Promotion promotion);
	  
	  /** cremove a promotion in a filiere
	   *  @param name .
	   */
	  void removePromotion(Promotion promotion);
}
