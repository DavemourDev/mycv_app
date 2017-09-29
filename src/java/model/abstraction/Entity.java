package model.abstraction;

import helpers.DatabaseUtils;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import model.factory.abstraction.EntityFactory;

/**
 * Una entidad es una clase de modelo que representan al menos parcialmente una
 * tabla de la base de datos, en términos de manipulación de sus datos.
 * 
 * Las operaciones están relacionadas con la inserción, visualización, edición y el borrado de datos.
 * 
 * @author David
 */
@SuppressWarnings("EqualsAndHashcode")
public abstract class Entity
{
    
    protected static EntityFactory factory;
    
    private int id;
    protected static String tablename;
    
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
        System.out.println("Nombre de la tabla a insertar: " + (this.getTableName() != null? this.getTableName() : "null"));
        
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
    
    /**
     * Compara esta entidad con otra. Cada entidad responde a una serie de comprobaciones para determinar su igualdad con otra.
     * 
     * En principio este método no debería sobrecargarse mientras no fuera estrictamente necesario.
     * 
     * @param e
     * @return 
     */
    public boolean equals(Entity e) 
    {
        if (this == e)
        {
            //Si es una referencia al mismo objeto, es verdadero.
            return true;
        }
        
        if (e == null || (getClass() != e.getClass()))
        {
            //Si es nulo o pertenece a otra clase, se considera falso sin comprobar nada.
            return false;
        }
        
        //Si llegamos a este punto, se consideran equivalentes si el hashcode de ambos coincide (Esto pasa si los atributos que distinguen un objeto de otro son iguales)...
        return this.hashCode() == e.hashCode();
    }

    /**
     * Genera un código identificador de la entidad.
     * 
     * Este código sirve para identificar al objeto al compararlo con otro, principalmente.
     * Cada subclase de Entity tendrá su propio criterio para definirlo.
     * 
     * Por defecto solamente tiene en cuenta la id. Si esto fuera suficiente, no es necesario sobrecargar.
     * 
     * @return 
     */
    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 97 * hash + this.getId();
        return hash;
    }
    
    /**
     *
     * @param request
     * @return
     */
    public static Entity instantiateFromRequest(HttpServletRequest request)
    {
        return getFactory().createEntityFromRequest(request);
    }
    
    public abstract boolean validate();

}
