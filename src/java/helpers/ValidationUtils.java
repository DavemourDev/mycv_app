/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.Calendar;

/**
 *
 * @author mati
 */
public class ValidationUtils 
{
    private ValidationUtils(){}
    
    public static boolean stringLength(String subject, int minWidth, int maxWidth)
    {
        int length = subject.length();
        return length >= minWidth && length <= maxWidth;
    }
    
    public static boolean isEmail(String subject)
    {
        return subject.matches("/(?:[a-z0-9!#$%&'*+\\/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+\\/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])/");
    }
    
    public static boolean isValidDate(String subject)
    {
        if(subject.matches("\\d{2}\\/\\d{2}\\/d{4}"))
        {
            return false;
        }
        
        try
        {
            int day = Integer.parseInt(subject.substring(0,2));
            int month = Integer.parseInt(subject.substring(3,4));
            int year = Integer.parseInt(subject.substring(6,9));
            
            if((year < 1900 || year > Calendar.getInstance().get(Calendar.YEAR)) || (month >12 || month < 1))
            {
                return false;
            }
            
            int maxDays = 31;
            
            if(month == 2)
            {
                boolean leapYear = year % 4 == 0 && !(year % 100 == 0 && !(year % 400 == 0));
                maxDays = leapYear? 29 : 28;
            }
            else if(month == 4 || month == 6 || month == 9 || month == 11)
            {
                maxDays = 30;
            }
            
            if(day < 1 || day > maxDays)
            {
                return false;
            }
        }
        catch(Exception ex)
        {
            return false;
        }
        
        return true;
    }
}
