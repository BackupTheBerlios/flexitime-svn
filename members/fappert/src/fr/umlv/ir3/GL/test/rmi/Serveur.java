/*
 * Créé le 7 déc. 2004
 */
package fr.umlv.ir3.GL.test.rmi;

import java.rmi.Naming;

/**
 * @author Administrateur
 */
public class Serveur {
	/**
	   * Server program for the "Hello, world!" example.
	   * @param argv The command line arguments which are ignored.
	   */
	  public static void main (String[] argv) {
	    try {
	      Naming.rebind ("Hello", new Hello ("Hello, world!"));
	      System.out.println ("Hello Server is ready.");
	    } catch (Exception e) {
	      System.out.println ("Hello Server failed: " + e);
	    }
	  }
}
