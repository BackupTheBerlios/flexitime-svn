/*
 * Créé le 7 déc. 2004
 */
package fr.umlv.ir3.GL.flexitime.server;

import java.rmi.Naming;

import fr.umlv.ir3.GL.flexitime.server.core.TeacherCore;

/**
 * @author Administrateur
 */
public class FlexitimeServeur {
	/**
	   * Server program for the "Hello, world!" example.
	   * @param argv The command line arguments which are ignored.
	   */
	  public static void main (String[] argv) {
	    try {
	      Naming.rebind ("TeacherCore", new TeacherCore());
	      System.out.println ("Flexitime Server is ready.");
	    } catch (Exception e) {
	      System.out.println ("Flexitime Server failed: " + e);
	    }
	  }
}
