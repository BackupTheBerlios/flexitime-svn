import java.rmi.Remote;
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
public interface IgetRMI extends Remote {
	public Professeur getProf() throws RemoteException;

}
