/*
 * Created on 21 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.exception;


/**
 * Catch the Exceptions of the application 
 * 
 * @version Prasad
 * 
 */
public class FlexiException extends Exception
{

    /**
     * DOCME
     */
    public FlexiException()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * DOCME
     * @param message
     */
    public FlexiException(String message)
    {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * DOCME
     * @param message
     * @param cause
     */
    public FlexiException(String message, Throwable cause)
    {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * DOCME
     * @param cause
     */
    public FlexiException(Throwable cause)
    {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args)
    {}
}

