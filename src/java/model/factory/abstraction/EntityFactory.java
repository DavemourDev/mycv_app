package model.factory.abstraction;

import helpers.DatabaseUtils;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.abstraction.Entity;

/**
 * La factoría de entidades dispone de métodos para generar objetos que implementan Entity.
 * 
 * Es creada para eliminar la responsabilidad de crear sus propios objetos de las clases de modelo,
 * delegando esas tareas a otra clase. De este modo, no es necesario implementar los mismos
 * métodos estáticos en todas las clases.
 * 
 * Por ahora aquí queda una abstracción de la idea. En futuras versiones del proyecto será implementada.
 * 
 * NOTA: Debido a las limitaciones que presenta Java con la herencia de miembros estáticos (o de mi conocimiento), por el momento se ha decidido
 * que las operaciones estáticas relacionadas con la base de datos (las que no dependen de una instancia) pertenezcan a esta clase, debido a que
 * la mayoría de estos métodos requieren un proceso posterior de creación de instancias con los datos obtenidos.
 * 
 * @author David
 */
public abstract class EntityFactory
{
    protected String table;
    protected Class modelClass = Entity.class;
    
    public String getTable()
    {
        return this.modelClass.getSimpleName().toLowerCase();
    }
    
    /**
     * Instancia una implementación de Entity a partir del resultado actual de un ResultSet.
     * 
     * Si no existe un resultado actual, se devolverá null.
     * 
     * Este método no sirve para recorrer un ResultSet. Si quieres recorrer un ResultSet, usa el método createEntitiesFromResultSet.
     * 
     * @param rs
     * @return 
     */
    public abstract Entity createEntityFromCurrentResult(ResultSet rs);
    
    /**
     * Instancia una implementación de Entity a partir de una petición a un servlet.
     * 
     * Útil para recoger datos mediante un formulario o una URL.
     * 
     * @param request
     * @return 
     */
    public abstract Entity createEntityFromRequest(HttpServletRequest request);
    
    /**
     * Crea una lista de implementaciones de Entity a partir de un ResultSet.
     * 
     * Si el ResultSet está vacío o terminado, devuelve una lista vacía.
     * 
     * Si se produce un error en medio del proceso, devuelve null.
     * 
     * @param rs
     * @return 
     */
    public List<Entity> createEntitiesFromResultSet(ResultSet rs)
    {
        List<Entity> list = new ArrayList<>();
        
        try
        {
            while(rs.next())
            {
                list.add(this.createEntityFromCurrentResult(rs));
            }   
        }
        catch(Exception ex)
        {
            list = null;
        }
        
        return list;
    }
   
    public Entity findById(int id) 
    {
        Entity e = null;

        try {
            ResultSet rs = DatabaseUtils.selectById(this.getTable(), id);

            if (rs.next()) {
                e = createEntityFromCurrentResult(rs);
            }
        } catch (Exception ex) {
            e = null;
        }

        return e;
    }

    public Entity findById(String id)
    {
        return findById(Integer.parseInt(id));
    }
    
    public List<Entity> findAll() 
    {
        List<Entity> list = new ArrayList<>();
        
        try {
            ResultSet rs = DatabaseUtils.selectAll(this.getTable());
            list = this.createEntitiesFromResultSet(rs);
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return list;
    }

    public Entity findOneBy(String attr, String value) 
    {
        Entity entity = null;
        
        try 
        {
            ResultSet rs = DatabaseUtils.selectAllWhere(this.getTable(), attr, value);
            
            if(rs.next())
            {
                entity = this.createEntityFromCurrentResult(rs);
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return entity;
    }
    
    public Entity findOneBy(String attr, int value)
    {
        return findOneBy(attr, String.valueOf(value));
    }
    
    public List<Entity> findBy(String attr, String value) 
    {
        List<Entity> list = new ArrayList<>();
        
        try {
            ResultSet rs = DatabaseUtils.selectAllWhere(this.getTable(), attr, value);
            list = this.createEntitiesFromResultSet(rs);
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return list;
    }
    
    
    public List<Entity> findBy(String attr, int value)
    {
        return findBy(attr, String.valueOf(value));
    }
}
