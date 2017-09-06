package model;

import config.Config;
import core.Database;
import helpers.DatabaseUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author DAVID
 */
public class User
{
    private int id;
    private String email, password;

    public User() {
        
    }

    public User(String email, String password) 
    {
        this.setEmail(email);
        this.setPassword(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public boolean equals(Object e) 
    {
        return this.hashCode() == e.hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.email);
        hash = 13 * hash + Objects.hashCode(this.password);
        return hash;
    }

    public static User findById(int id) 
    {
        User user = null;

        try {
            ResultSet rs = DatabaseUtils.selectById("user", id);

            if (rs.next()) {
                user = instantiateFromCurrentResult(rs);
            }
        } catch (Exception ex) {
            System.err.println("Error de conexión con la base de datos.");
        }

        return user;
    }

    public static List<User> findAll() 
    {
        List<User> list = new ArrayList<>();
        
        try {
            ResultSet rs = DatabaseUtils.selectAll("user");
            
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

    public static List<User> findBy(String attr, String value) 
    {
        List<User> list = new ArrayList<>();
        
        try {
            ResultSet rs = DatabaseUtils.selectAllWhere("user", attr, value);
            
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

    public static User instantiateFromCurrentResult(ResultSet rs) throws SQLException
    {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        return user;
    }
    
    /**
     * Comprueba si existe un usuario con el email de la instancia y su contraseña en la base de datos.
     * 
     * Se recomienda su uso para el login de usuario.
     * 
     * @return true si en la tabla `user` existe un registro con el mismo email y contraseña que el objeto que llama. De lo contrario, false.
     */
    public boolean authentication() throws Exception
    {
        String query = String.format("select * from `user` where `email`='%s' and `password`=%s('%s');", this.getEmail(), Config.PASSWORD_ENCRYPT_FUNCTION, this.getPassword());
        return Database.getInstance().query(query).next();
    }
    
    public boolean register()
    {
        int affected;
           
        try {
            String query = String.format("insert into `user`(`email`, `password`) values ('%s', %s('%s'));", this.getEmail(), Config.PASSWORD_ENCRYPT_FUNCTION, this.getPassword());
            System.out.println(query);
            affected = Database.getInstance().queryUpdate(query); 
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos (registrar usuario).");
            affected = 0;
        }
        
        return affected > 0;
    }
    
    /**
     * Comprueba si existe un usuario con el email de la instancia en la base de datos.
     * 
     * Se recomienda su uso para el registro de usuario.
     * 
     * @return true si en la tabla `user` existe un registro con el mismo email y contraseña que el objeto que llama. De lo contrario, false.
     */
    public boolean exists()
    {
        return User.findAll().stream().anyMatch( //Si una llamada da true el resultado devuelto es true.
            user -> this.getEmail().equals(user.getEmail()) //Para cada usuario, se compara el email de la instancia con él.
        );
    }
    
    /**
     * En vías de extinción 
     * */
    public void fetchIdWithDatabase() throws Exception
    {
        try
        {
            ResultSet rs = Database.getInstance().query("select `id` from `user` where `email`='"+ this.getEmail()+"' and `password`='"+ this.getPassword()+"';");
            rs.next();
            this.id = rs.getInt("id");
        }
        catch(Exception ex)
        {
            this.id = 0;
        }
    }
}
