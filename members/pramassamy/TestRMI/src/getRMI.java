import java.rmi.RemoteException;

/*
 * Created on 11 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Prâsad
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class getRMI implements IgetRMI {

	Professeur prof;
	
	public getRMI()
	{
		prof = new Professeur();
	}
	/* (non-Javadoc)
	 * @see IgetRMI#getProf()
	 */
	public Professeur getProf() throws RemoteException {
		return prof;
	}

}
