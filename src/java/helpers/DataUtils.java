package helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Tag;

/**
 * Métodos para conversiones útiles de un tipo de datos a otro.
 */
public class DataUtils
{
    /**
     * Devuelve la diferencia de dos fechas. Negativo significa que la segunda es mayor, positivo que lo es la primera y 0 que ambas son iguales.
     * @param date1
     * @param date2
     * @return 
     */
    public static int compareDates(String date1, String date2)
    {
        int year1 = Integer.parseInt(date1.substring(0,4));
        int month1 = Integer.parseInt(date1.substring(5,7));
        int day1 = Integer.parseInt(date1.substring(8,10));
    
        int year2 = Integer.parseInt(date2.substring(0,4));
        int month2 = Integer.parseInt(date2.substring(5,7));
        int day2 = Integer.parseInt(date2.substring(8,10));
    
        int difYear, difMonth;
        
        //Compara año
        if((difYear = year1 - year2) !=0)
        {
            //Devolver diferencia
            return difYear;
        }
        //Mismo año. Comparar meses
        if((difMonth = month1 - month2) !=0)
        {
            //Devolver diferencia
            return difMonth;
        }
        
        //Mismo año y mes. Devuelve diferencia de días
        return day1 - day2;
        
        
    }
    
    
    private DataUtils(){}
    
    public static List<String> splitBySpaces(String subject)
    {
        return Arrays.asList(subject.split(" "));
    }
    
    public static String joinBySpaces(List<String> subject)
    {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while(!subject.isEmpty())
        {
            sb.append(subject.get(i++));
            if(i == subject.size())
            {
                break;
            }
            sb.append(" ");
        }
        
        return sb.toString();
    }
    
    public static List<Tag> createTagListFromStringList(List<String> tagTexts)
    {
        List<Tag> tags = new ArrayList<Tag>();
        
        for(String tagText : tagTexts)
        {
            Tag tag = new Tag();
            tag.setTagtext(tagText);
            tags.add(tag);
        }
        
        return tags;
    }
    
    public static List<Tag> createTagListFromSpacedString(String tagString)
    {
        return createTagListFromStringList(splitBySpaces(tagString));
    }
    
    public static List<Tag> createTagListFromStringArray(String[] tagTexts)
    {
        return createTagListFromStringList(Arrays.asList(tagTexts));
    }
}
