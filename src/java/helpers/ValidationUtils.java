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
        return subject.matches("(?:[a-z0-9!#$%&'*+\\/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+\\/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    }
    
    public static boolean isValidDate(String subject)
    {
        if(!subject.matches("(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})"))
        {
            System.out.println("Fecha no cumple el formato: " + subject);
            return false;
        }
        
        try
        {
            int day = Integer.parseInt(subject.substring(0,2));
            int month = Integer.parseInt(subject.substring(3,5));
            int year = Integer.parseInt(subject.substring(6,10));
            
            if((year < 1900 || year > Calendar.getInstance().get(Calendar.YEAR)) || (month >12 || month < 1))
            {
                System.out.println("El mes no es correcto: " + month);
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
                
                System.out.println("Dia fuera de rango");
                
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
