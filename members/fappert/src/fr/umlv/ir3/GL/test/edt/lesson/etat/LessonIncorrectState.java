/*
 * Created on 4 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.GL.test.edt.lesson.etat;

import fr.umlv.ir3.GL.test.edt.lesson.JLesson;


/**
 * DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * @see (si n�cessaire)
 * 
 * @author FlexiTeam - binou
 */
public class LessonIncorrectState implements LessonState
{

    private JLesson lesson;

    /**
     * DOCME
     * @param lesson
     */
    public LessonIncorrectState(JLesson lesson)
    {
        this.lesson = lesson;
    }
    
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @see fr.umlv.ir3.GL.test.edt.lesson.etat.LessonState#getText()
     * @author   FlexiTeam - binou
     */
    public String getText()
    {
        return null;
    }

}

