package fr.umlv.ir3.GL.test.rmiVincent;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractListModel;

/**
 * Notre modèle... Il se situe seulement sur le serveur et est utilisé par les
 * NumberListModelRMIAdapter qui recevront les appels RMI. Ce modèle renvoit une
 * liste de nombres qui augmentera avec le temps.
 */
public class NumberListModel extends AbstractListModel
{
	public int getSize()
	{
		return m_nSize;
	}

	public Object getElementAt(int nIndex)
	{
		return new Integer(nIndex);
	}

	public NumberListModel()
	{
		// Toutes les secondes, on ajoute un nouveai nombre à notre liste
		// (En fait, on ne fait qu'augmenter le plus grand nombre, les autres
		// sont calculés dans les 2 méthodes d'accès aux données.)
		new Timer().schedule(new TimerTask()
		{
			public void run()
			{
				System.out.println("Plop");
				m_nSize++;
				fireIntervalAdded(NumberListModel.this, m_nSize - 2,
									m_nSize - 1);
			}
		}, 1000, 1000);
	}

	int m_nSize = 1;
}