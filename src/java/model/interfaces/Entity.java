package model.interfaces;

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
    /**
     * Crea un hashMap a partir de una instancia de entidad, el cual guarda los valores de la entidad
     * con claves que se relacionan de forma directa con campos de las tablas de la base de datos de la aplicación.
     * @return 
     */
    public HashMap toHashMap();
    
    
}
