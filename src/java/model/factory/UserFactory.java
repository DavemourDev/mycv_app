package model.factory;

import helpers.RequestUtils;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import model.User;
import model.abstraction.Entity;
import model.factory.abstraction.EntityFactory;

public class UserFactory extends EntityFactory
{
    {
        modelClass = User.class;
    }
    
    @Override
    public Entity createEntityFromCurrentResult(ResultSet rs)
    {
        try
        {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));

            System.out.println("Instanciando usuario por database");
            
            return user;
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    @Override
    public Entity createEntityFromRequest(HttpServletRequest request)
    {
        try
        {
            User user = new User();
            if(!RequestUtils.isNullParam(request, "id"))
            {
                System.out.println("id nula. NO pone id");
                
                user.setId(RequestUtils.getInt(request, "id"));
            }
            user.setEmail(RequestUtils.getString(request, "email"));
            user.setPassword(RequestUtils.getString(request, "password"));

            return user;
        } 
        catch (Exception ex)
        {
            return null;
        }
    }

}
