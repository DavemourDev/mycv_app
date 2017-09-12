package helpers;

import java.util.Arrays;
import java.util.List;

/**
 * Métodos para conversiones útiles de un tipo de datos a otro.
 */
public class DataUtils
{
    private DataUtils(){}
    
    public static List<String> splitBySpaces(String subject)
    {
        return Arrays.asList(subject.split(" "));
    }
    
    public static String joinBySpaces(List<String> subject)
    {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(true)
        {
            sb.append(subject.get(i++));
            if(i == subject.size())
            {
                return sb.toString();
            }
            sb.append(" ");
        }
    }
}
