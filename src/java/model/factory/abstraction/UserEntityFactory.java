package model.factory.abstraction;

import helpers.DatabaseUtils;
import java.sql.ResultSet;
import java.util.List;
import model.abstraction.Entity;

/**
 * @author David
 */
public abstract class UserEntityFactory extends EntityFactory
{

    public List<Entity> findByUserId(int id)
    {
        List<Entity> list;

        try
        {
            System.out.println(getTable() == null ? "Tabla nula" : getTable());
            
            ResultSet rs = DatabaseUtils.selectAllWhere(this.getTable(), "user_id", id);
            list = this.createEntitiesFromResultSet(rs);
        } 
        catch (Exception ex)
        {
            list = null;
        }

        return list;
    }

    public List<Entity> findByUserId(String id)
    {
        return findByUserId(Integer.parseInt(id));
    }
    
}
