/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

/**
 *
 * @author mati
 */
public class FormatUtils
{
    public static final String[] MONTHS_ES = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static final String[] MONTHS_CA = {"", "Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre"};
    public static final String[] MONTHS_EN = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    private FormatUtils(){}
    
    public static String formatDateYear(String date)    
    {
        StringBuilder sb = new StringBuilder();
        
        if(ValidationUtils.isValidDate(date))
        {
            int year= Integer.parseInt(date.substring(0,4));

            sb.append(year);
            
        }
        
        return sb.toString();
    }
    
    public static String formatDateMonthYear(String date)    
    {
        StringBuilder sb = new StringBuilder();
        
        if(ValidationUtils.isValidDate(date))
        {
            int year= Integer.parseInt(date.substring(0,4));
            int month = Integer.parseInt(date.substring(5,7));

            sb.append(MONTHS_ES[month]);
            sb.append(" del ");
            sb.append(year);
            
        }
        
        return sb.toString();
    }
    
    public static String formatDateDayMonthYear(String date)    
    {
        StringBuilder sb = new StringBuilder();
        
        if(ValidationUtils.isValidDate(date))
        {
            int year= Integer.parseInt(date.substring(0,4));
            int month = Integer.parseInt(date.substring(5,7));
            int day = Integer.parseInt(date.substring(8,10));

            sb.append(day);
            sb.append(" de ");
            sb.append(MONTHS_ES[month]);
            sb.append(" del ");
            sb.append(year);
            
        }
        
        return sb.toString();
    }
    
    public static String surroundWith(String subject, char surrounder)
    {
        return (new StringBuilder()).append(surrounder).append(subject).append(surrounder).toString();
    }
    
    public static String surroundWithParenthesis(String subject)
    {
        return (new StringBuilder()).append('(').append(subject).append(')').toString();
    }
    
    
    
}
