package model;

import core.Database;
import core.Entity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAVID
 */
public class User implements Entity
{
    private String email, password;

    public User() {
        
    }

    public User(String email, String password) 
    {
        this.setEmail(email);
        this.setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean compare(Entity e) 
    {
        return this.getEmail().equals(((User)e).getEmail()) && this.getPassword().equals(((User)e).getPassword());
    }

    public static List<User> findAll() 
    {
        List<User> list = new ArrayList<>();
        
        try {
            ResultSet rs = Database.getInstance().query("select `email`, `password` from `user`");
            
           // rs.next();
            
            while(rs.next())
            {
                User user = new User();
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
        } catch (Exception ex) {
            
        }
        
        return list;
    }
    
    
    
    
}
