package model;

import core.Database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mati
 */
class Email {
    String email, description;

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
        
        try {
            ResultSet rs = Database.getInstance().query("select * from `email`");
            
            while(rs.next())
            {
                Email email = new Email();
                email.setEmail(rs.getString("email"));
                email.setDescription(rs.getString("description"));
                list.add(email);
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return list;
    }
    
}
