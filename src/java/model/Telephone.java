package model;

import helpers.DatabaseUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * NOTA: No se implementa en esta versión.
 * @author David
 */
class Telephone 
{
    private int id;
    private String number, description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
 
    public static List<Telephone> findAll() 
    {
        List<Telephone> list = new ArrayList<>();
        
        try 
        {
            
            ResultSet rs = DatabaseUtils.selectAll("telephone");
       
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

    public static List<Telephone> findBy(String attr, String value) 
    {
        List<Telephone> list = new ArrayList<>();
        
        try {
            
            ResultSet rs = DatabaseUtils.selectAllWhere("telephone", attr, value);
       
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

    public static Telephone findById(int id) 
    {
        Telephone telephone = null;
        
        try {
            
            ResultSet rs = DatabaseUtils.selectById("telephone", id);
       
            if(rs.next())
            {
                telephone = instantiateFromCurrentResult(rs);
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return telephone;
    }

    public static Telephone instantiateFromCurrentResult(ResultSet rs) throws SQLException
    {
        Telephone telephone = new Telephone();
        telephone.setId(rs.getInt("id"));
        telephone.setNumber(rs.getString("number"));
        telephone.setDescription(rs.getString("description"));
        return telephone;
    }

    
    
}
