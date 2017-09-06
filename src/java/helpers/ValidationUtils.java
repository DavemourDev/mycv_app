/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.regex.Pattern;

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
        Pattern pattern = Pattern.compile("[a-zA-Z]+(\\s[a-zA-Z]+)+");
        
        //Acabar
        return true;
    }
}
