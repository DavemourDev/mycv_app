/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Personal;
import model.User;

/**
 *
 * @author mati
 */
public class ValidationUtils 
{
    public static final String EMAIL_REGEXP = "(?:[a-z0-9!#$%&'*+\\/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+\\/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    public static final String DATE_REGEXP = "\\d{4}-\\d{2}-\\d{2}";
    
    private ValidationUtils(){}
    
    public static boolean validatePersonal(Personal personal) throws Exception
    {
        List<String> problems = new ArrayList<String>();
        boolean isValid = true;
        
        
        if(!ValidationUtils.stringLength(personal.getName(), 3, 255))
        {
            isValid = false;
            problems.add("Longitud de nombre incorrecta");
        }

        if(!ValidationUtils.stringLength(personal.getLastname(), 3, 255))
        {
            isValid = false;
            problems.add("Longitud de apellidos incorrecta");
        }

        if(!ValidationUtils.isValidDate(personal.getBirthdate()))
        {
            
            System.out.println("Fecha incorrecta");
            isValid = false;
            problems.add("Fecha Incorrecta!");
        }
    
        if(!isValid)
        {
            System.out.println("Personal no válido!!!!!!");
        }
        
        return isValid;
    }
    
    public static boolean stringLength(String subject, int minWidth, int maxWidth)
    {
        int length = subject.length();
        return length >= minWidth && length <= maxWidth;
    }
    
    public static boolean isEmail(String subject)
    {
        return subject.matches(EMAIL_REGEXP);
    }
    
    public static boolean isValidDate(String subject)
    {
        if(!subject.matches(DATE_REGEXP))
        {
            System.out.println("Fecha no cumple el formato: " + subject);
            return false;
        }
        
        try
        {
            int year= Integer.parseInt(subject.substring(0,4));
            int month = Integer.parseInt(subject.substring(5,7));
            int day = Integer.parseInt(subject.substring(8,10));
            
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
    
    public static boolean validateUser(User user) throws Exception
    {

        boolean isValid = true;
        List<String> problems = new ArrayList<>();
        
        if(!ValidationUtils.isEmail(user.getEmail()))
        {
            isValid=false;
            problems.add("Formato de email no válido");
        }

        if(!ValidationUtils.stringLength(user.getPassword(), 6, 20))
        {
            isValid = false;
            problems.add("La contraseña debe tener 6 caracteres como mínimo");
        }

        if(!isValid)
        {
           throw new Exception(problems.toString());
        }
        
        return isValid;
    }
    
}
