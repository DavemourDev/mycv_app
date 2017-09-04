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
    int id, user_id;
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

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }

        return email;
    }

    public static Email instantiateFromCurrentResult(ResultSet rs) throws SQLException
    {
        Email email = new Email(rs.getString("email"), rs.getString("description"));
        email.setId(rs.getInt("id"));
        email.setUser_id(rs.getInt("user_id"));
        return email;
    }
}
