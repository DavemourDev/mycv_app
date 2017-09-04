package model.enums;

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
public class Gender {

    private int id;
    private String name;
    
    public Gender() 
    {
    //NADA
    }

    public Gender(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public static List<Gender> findAll() 
    {
        List<Gender> list = new ArrayList<>();

        try {
            ResultSet rs = DatabaseUtils.selectAll("gender");

            while (rs.next()) {
                list.add(instantiateFromCurrentResult(rs));
            }
        } catch (Exception ex) {
            System.err.println("Error de conexión con la base de datos.");
        }

        return list;
    }

    public static Gender findById(int id) 
    {
        Gender gender = null;

        try 
        {
            ResultSet rs = DatabaseUtils.selectById("gender", id);

            if (rs.next()) 
            {
                gender = instantiateFromCurrentResult(rs);
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }

        return gender;
    }

    public static Gender findBy(String attr, String value) 
    {
        Gender gender = null;

        try 
        {
            ResultSet rs = DatabaseUtils.selectAllWhere("gender", attr, value);

            if (rs.next()) 
            {
                gender = instantiateFromCurrentResult(rs);
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }

        return gender;
    }
    
    public static Gender instantiateFromCurrentResult(ResultSet rs) throws SQLException
    {
        return new Gender(rs.getInt("id"), rs.getString(String.format("name_%s", Config.LANGUAGE)));
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

    @Override
    public String toString()
    {
        return this.getName();
    }
    
}
