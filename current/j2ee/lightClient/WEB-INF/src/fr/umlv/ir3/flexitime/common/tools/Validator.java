/*
 * Created on 30 janv. 2005
 * by Jérôme GUERS
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.tools;

import java.util.StringTokenizer;

/**
 * Contains differents methods to validate forms fields 
 * 
 * @version 325
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class Validator
{
    private static boolean validMailSection(String section)
    {
        boolean valid = true;
        char[] sec = section.toCharArray();
        for (int i = 0 ; i < sec.length ; i++)
        {
            if(!(Character.isLetterOrDigit(sec[i])))
                valid = false;
        }
        return valid;
    }
    
    /**
     * Valid if the mail contains only letter, digit, "." and an unique "@".
     *
     * @param mail
     * @return true if the mail is valid
     */
    public static boolean validMail(String mail)
    {
        boolean valid = true;
        
        if(mail.length() == 0)
            return false;
        
        int start = 0;
        while(start < mail.length() && mail.charAt(start) == ' ')
            start++;
        mail = mail.substring(start);
        int end = mail.length() - 1;
        while(end > 0 && mail.charAt(end) == ' ')
            end--;
        mail = mail.substring(0, end + 1);
        
        if(mail.length() == 0)
            return true;
        
        StringTokenizer str = new StringTokenizer(mail,"@");
        if(str.countTokens()!= 2)
            valid = false;

        else
        {
            String name = str.nextToken();
            StringTokenizer tokName = new StringTokenizer(name,".");
            for( int tokenNum = 0; tokenNum < tokName.countTokens() && valid ; tokenNum++)
            {
                if(!(validMailSection(tokName.nextToken())))
                        valid = false;
            }
            
            String host = str.nextToken();
            if(valid && host != "")
            {
                StringTokenizer tokHost = new StringTokenizer(host,".");
                if(tokHost.countTokens()<2)
                {
                    valid = false;
                }
                for( int tokenNum = 0; tokenNum < tokHost.countTokens() && valid ; tokenNum++)
                {
                    if(!(validMailSection(tokHost.nextToken())))
                            valid = false;
                }
            }
        }
        return valid;
    }

    /** 
     * DOCME
     *
     * @param addr
     * @return true ro false
     */
    public static boolean validMultiMails(String addr)
    {
        boolean valid = true;
        
        if(addr.length() == 0)
            return false;
        StringTokenizer semicolon = new StringTokenizer(addr, ";");
        while(semicolon.hasMoreTokens())
        {
            StringTokenizer coma = new StringTokenizer(semicolon.nextToken(), ",");
            while(coma.hasMoreTokens())
            {
                if(!(validMail(coma.nextToken())))
                    valid = false;
            }
        }
        
        return valid; 
    }
}

