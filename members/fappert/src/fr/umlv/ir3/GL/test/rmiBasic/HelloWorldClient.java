package fr.umlv.ir3.GL.test.rmiBasic;

import java.rmi.Naming;


/**
 * @author Ludo
 *
 */
public class HelloWorldClient
{
	public static void main (String [] args)
	{
		try
		{
            HelloWorld hello = (HelloWorld) Naming.lookup ("rmi://localhost/hello");
			
            System.out.println (hello.hello ());
        }
		catch (Exception e)
		{
            e.printStackTrace();
        }
	}
}
