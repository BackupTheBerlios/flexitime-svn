/*
 * Créé le 7 déc. 2004
 */
package fr.umlv.ir3.GL.test.rmi;

import java.rmi.Naming;

/**
 * @author Administrateur
 */
public class Client {
	  /**
	   * Client program for the "Hello, world!" example.
	   * @param argv The command line arguments which are ignored.
	   */
	  public static void main (String[] argv) {
	    try {
	      HelloInterface hello = 
	        (HelloInterface) Naming.lookup ("rmi://127.0.0.1/Hello");
	  
	      System.out.println (hello.say());
	    } catch (Exception e) {
	      System.out.println ("HelloClient exception: " + e);
	    }
	  }
}
