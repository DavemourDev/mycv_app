package model.factory;

import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import model.interfaces.Entity;

public class UserFactory extends EntityFactory
{

    @Override
    public Entity createEntityFromCurrentResult(ResultSet rs)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entity createEntityFromRequest(HttpServletRequest request)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
