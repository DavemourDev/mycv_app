package model.interfaces;

import helpers.DatabaseUtils;
import java.util.HashMap;
import model.factory.EntityFactory;

/**
 * Una entidad es una clase de modelo que representan al menos parcialmente una
 * tabla de la base de datos, en términos de manipulación de sus datos.
 * 
 * Las operaciones están relacionadas con la inserción, visualización, edición y el borrado de datos.
 * 
 * 
 * @author David
 */
public abstract class Entity
{
    private int id;
    private static EntityFactory factory;
    
    /**
     * Crea un hashMap a partir de una instancia de entidad, el cual guarda los valores de la entidad
     * con claves que se relacionan de forma directa con campos de las tablas de la base de datos de la aplicación.
     *
     * @return 
     */
    public abstract HashMap toHashMap();
    
    /**
     * Fija la ID del objeto entidad.
     * 
     * La ID identifica inequívocamente al objeto en la base de datos.
     * 
     * @param id 
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Obtiene la ID del objeto entidad.
     * @return 
     */
    public int getId()
    {
        return this.id;
    }
    
    /**
     * Fija el objeto "fábrica de entidades" para dicho tipo de entidad.
     * 
     * Una fábrica de entidades almacena la lógica de creación de instancias de
     * entidad a partir de diversas fuentes de datos.
     * 
     */
    public static void setFactory(EntityFactory f)
    {
        factory = f;
    }
    
    public static EntityFactory getFactory()
    {
        return factory;
    }
    
    /**
     * Obtiene el nombre de la tabla de entidad.
     * 
     * Por defecto, el nombre obtenido es el de la clase que lo llama en minúscula.
     * 
     * Si fuera necesaria otra implementación, sobrecarga el método.
     * 
     * @return 
     */
    public String getTableName()
    {
        return this.getClass().getSimpleName().toLowerCase();
    }
    
    /**
     * Inserta la instancia actual del objeto en la base de datos.
     * 
     * Requiere de una implementación de toHashMap para mapear la instancia con la base de datos.
     * 
     * @return
     * @throws Exception 
     */
    public boolean insert() throws Exception
    {
        return DatabaseUtils.insert(this.getTableName(), this.toHashMap());
    }

    /**
     * Reemplaza los datos del registro relativos a esta instancia con los campos de la misma.
     * 
     * Requiere de una implementación de toHashMap para mapear la instancia con la base de datos.
     * 
     * @return
     * @throws Exception 
     */
    public boolean update() throws Exception
    {
        return DatabaseUtils.update(this.getTableName(), this.toHashMap());
    }
    
    /**
     * Elimina un registro de la base de datos en base a la identificación con esta instancia.
     * 
     * Requiere de una implementación de toHashMap para mapear la instancia con la base de datos.
     * 
     * @return
     * @throws Exception 
     */
    public boolean delete() throws Exception
    {
        return DatabaseUtils.deleteById(this.getTableName(), this.getId());
    }
}
