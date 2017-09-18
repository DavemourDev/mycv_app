package model;

import config.Config;
import helpers.DatabaseUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mati
 */
public class EducationLevel implements Comparable<EducationLevel> 
{

    private int id, value;
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
    
    public EducationLevel(int id, String name, int value)
    {
        this(id, name);
        this.setValue(value);
    }
    
    @Override
    public int compareTo(EducationLevel el) {
        return this.getValue() - el.getValue();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
            ResultSet rs = DatabaseUtils.selectAll("el");
            
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
            ResultSet rs = DatabaseUtils.selectAllWhere("education_level", attr, value);
            
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
            ResultSet rs = DatabaseUtils.selectById("education_level", id);
            
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
