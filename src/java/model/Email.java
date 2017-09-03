package model;

import core.Database;
import helpers.DatabaseUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mati
 */
class Email 
{
    String email, description;

    public Email()
    {
        //--
    }
    
    public Email(String email, String description)
    {
        this.setEmail(email);
        this.setDescription(description);
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    public static List<Email> findAll() 
    {
        List<Email> list = new ArrayList<>();
        
        try 
        {
            ResultSet rs = DatabaseUtils.selectAll("email");
       
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
    
    
    public static List<Email> findBy(String attr, String value) 
    {
        List<Email> list = new ArrayList<>();
        
        try {
            
            ResultSet rs = DatabaseUtils.selectAllWhere("email", attr, value);
       
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

    public static Email findById(int id) 
    {
        Email email = null;

        try 
        {
            ResultSet rs = DatabaseUtils.selectById("email", id);
       
            if (rs.next()) {
                email = instantiateFromCurrentResult(rs);
            }
        } catch (Exception ex) {
            System.err.println("Error de conexión con la base de datos.");
        }

        return email;
    }

    public static Email instantiateFromCurrentResult(ResultSet rs) throws SQLException
    {
        return new Email(rs.getString("email"), rs.getString("description"));
        
    }
}
