package model;

import config.Config;
import helpers.DatabaseUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class EducationLevel implements Comparable<EducationLevel> 
{
    private static final String TABLE_NAME = "education_level";
    private int id;
    private String name;

    public EducationLevel()
    {
        //NADA
    }
    
    public EducationLevel(int id, String name)
    {
        this.setId(id);
        this.setName(name);
    }
    
    @Override
    public int compareTo(EducationLevel el) {
        return this.getId() - el.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
       public static List<EducationLevel> findAll()
    {
        List<EducationLevel> list = new ArrayList<>();
        
        try 
        {
            ResultSet rs = DatabaseUtils.selectAll(TABLE_NAME);
            
            while(rs.next())
            {
                list.add(instantiateFromResultSet(rs));
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return list;
    }
    
    public static List<EducationLevel> findBy(String attr, String value)
    {
        List<EducationLevel> list = new ArrayList<>();
        
        try 
        {
            ResultSet rs = DatabaseUtils.selectAllWhere(TABLE_NAME, attr, value);
            
            while(rs.next())
            {
                list.add(instantiateFromResultSet(rs));
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return list;
    }
    
    /**
     *
     * @param id
     * @return
     */
    public static EducationLevel findById(int id)
    {
        EducationLevel el = null;
        
        try 
        {
            ResultSet rs = DatabaseUtils.selectById(TABLE_NAME, id);
            
            if(rs.next())
            {
                el = instantiateFromResultSet(rs);
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return el;
    }
    
    public static EducationLevel instantiateFromResultSet(ResultSet rs) throws SQLException
    {
        return new EducationLevel(rs.getInt("id"), rs.getString(String.format("name_%s", Config.LANGUAGE)));
    }
}
