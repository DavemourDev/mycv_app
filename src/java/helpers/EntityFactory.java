package helpers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.interfaces.Entity;

/**
 * La factoría de entidades dispone de métodos para generar objetos que implementan Entity.
 * 
 * Es creada para eliminar la responsabilidad de crear sus propios objetos de las clases de modelo,
 * delegando esas tareas a otra clase. De este modo, no es necesario implementar los mismos
 * métodos estáticos en todas las clases.
 * 
 * Por ahora aquí queda una abstracción de la idea. En futuras versiones del proyecto será implementada.
 * 
 * @author David
 */
public abstract class EntityFactory
{
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
}
