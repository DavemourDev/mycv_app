package model;

import core.Database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mati
 */
class Telephone 
{
    String number, description;

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
        
        try {
            ResultSet rs = Database.getInstance().query("select * from `email`");
            
            while(rs.next())
            {
                Telephone tel = new Telephone();
                tel.setNumber(rs.getString("number"));
                tel.setDescription(rs.getString("description"));
                list.add(tel);
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return list;
    }   
}
