package model.interfaces;

import helpers.DatabaseUtils;
import java.util.HashMap;

/**
 * Una entidad es una clase de modelo que representan al menos parcialmente una
 * tabla de la base de datos, en términos de manipulación de sus datos.
 * 
 * Las operaciones están relacionadas con la inserción, visualización, edición y el borrado de datos.
 * 
 * 
 * @author David
 */
public interface Entity
{
    
    public static final String TABLE_NAME = "entity";
    
    /**
     * Crea un hashMap a partir de una instancia de entidad, el cual guarda los valores de la entidad
     * con claves que se relacionan de forma directa con campos de las tablas de la base de datos de la aplicación.
     *
     * @return 
     */
    public HashMap toHashMap();
    
    /**
     * Fija la ID del objeto entidad.
     * 
     * La ID identifica inequívocamente al objeto en la base de datos.
     * 
     * @param id 
     */
    public void setId(int id);
    
    /**
     * Obtiene la ID del objeto entidad.
     * @return 
     */
    public int getId();
    
    /**
     * Obtiene el valor de la constante TABLE_NAME de la tabla de entidad que lo implementa.
     * 
     * Se admite sobrecarga de este método para obtener de otro modo el nombre de la tabla.
     * En caso de hacerlo, la constante estática TABLE_NAME es opcional.
     * 
     * @return 
     */
    public default String getTableName()
    {
        return TABLE_NAME;
    }
    
    /**
     * Inserta la instancia actual del objeto en la base de datos.
     * 
     * Requiere de una implementación de toHashMap para mapear la instancia con la base de datos.
     * 
     * @return
     * @throws Exception 
     */
    public default boolean insert() throws Exception
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
    public default boolean update() throws Exception
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
    public default boolean delete() throws Exception
    {
        return DatabaseUtils.deleteById(this.getTableName(), this.getId());
    }
}
