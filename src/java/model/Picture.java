
package model;

import helpers.DatabaseUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mati
 */
class Picture 
{
    private String url, caption;

    public Picture()
    {
        //--
    }
    
    public Picture(String url, String caption)
    {
        this.setUrl(url);
        this.setCaption(caption);
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    public static List<Picture> findAll() 
    {
        List<Picture> list = new ArrayList<>();
        
        try 
        {
            
            ResultSet rs = DatabaseUtils.selectAll("otherinfo");
       
            while(rs.next())
            {
                list.add(instantiateFromCurrentResult(rs));
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return list;
    }

    public static List<Picture> findBy(String attr, String value) 
    {
        List<Picture> list = new ArrayList<>();
        
        try {
            
            ResultSet rs = DatabaseUtils.selectAllWhere("otherinfo", attr, value);
       
            while(rs.next())
            {
                list.add(instantiateFromCurrentResult(rs));
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return list;
    }

    public static Picture instantiateFromCurrentResult(ResultSet rs) throws SQLException
    {
        return new Picture(rs.getString("url"), rs.getString("caption"));
    }
}
