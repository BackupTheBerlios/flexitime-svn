/*
 * Created on 4 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.GL.test.edt.lesson.etat;

import fr.umlv.ir3.GL.test.edt.lesson.JLesson;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
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
     * Quel service est rendu par cette méthode
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

