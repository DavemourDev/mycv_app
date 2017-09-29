package model.abstraction;

import helpers.DatabaseUtils;
import java.util.ArrayList;
import java.util.List;
import model.Tag;

/**
 * Esta interfaz es usada por las clases de modelo que contienen un campo de etiquetas.
 * 
 * Un etiquetable debe tener un campo que represente una lista de etiquetas que se atribuyen a él.
 * La interfaz le confiere operaciones relacionadas con dicho campo.
 * 
 * @author David
 */
public abstract class TaggableUserEntity extends UserEntity
{
    
    private List<Tag> tags = new ArrayList<Tag>();
    
    /**
     * Obtiene una lista con todas las tags asociadas a ese objeto.
     * @return 
     */
    public List<Tag> getTags()
    {
        return this.tags;
    }
    
    /**
     * Asigna un objeto tag al objeto etiquetable.
     * @param tag 
     * @return  
     */
    public boolean addTag(Tag tag)
    {
        if(!this.hasTag(tag.getTagtext()))
        {
            return this.getTags().add(tag);
        }
        
        return false;
    }
    
    /**
     * Elimina una etiqueta de la lista.
     * @param tag
     * @return 
     */
    public boolean removeTag(Tag tag)
    {
        for(Tag t : this.getTags())
        {
            if(t.getTagtext().equals(tag.getTagtext()))
            {
                return this.getTags().remove(t);
            }
        }
        return false;
    }
    
    /**
     * Asigna una lista de etiquetas como lista de etiquetas del objeto implementador.
     * @param tags 
     */
    public void setTags(List<Tag> tags)
    {
        this.tags = tags;
    }
    
    /**
     * Verifica si existe una etiqueta con el texto pasado como atributo en la lista de etiquetas del objeto.
     * @param tagText
     * @return 
     */
    public boolean hasTag(String tagText)
    {
        return this.getTags().stream().anyMatch( tag -> tag.getTagtext().equals(tagText));
    }
    
    /**
     * Inserta la instancia actual del objeto en la base de datos.
     * 
     * Requiere de una implementación de toHashMap para mapear la instancia con la base de datos.
     * 
     * @return
     * @throws Exception 
     */
    @Override
    public boolean insert() throws Exception
    {
        return DatabaseUtils.insert(this.getTableName(), this.toHashMap()) && this.updateTags(false);
    }

    /**
     * Reemplaza los datos del registro relativos a esta instancia con los campos de la misma.
     * 
     * Requiere de una implementación de toHashMap para mapear la instancia con la base de datos.
     * 
     * Esta implementación contempla las etiquetas.
     * 
     * @return
     * @throws Exception 
     */
    @Override
    public boolean update() throws Exception
    {
        return DatabaseUtils.update(this.getTableName(), this.toHashMap()) && this.updateTags(true);
    }
    
    /**
     * Inserta tags para este item en la base de datos. Si el parámetro es true, previamente borra las que hubiera antes para él.
     * @param replace
     * @return 
     */
    public boolean updateTags(boolean replace)
    {
        try
        {
            List<Tag> list = this.getTags();

            if(replace)
            {
                //Elimina todas las tags referidas a este item.
                Tag.deleteAllForItem(this);
            }
            
            //Y ahora las reasocia
            for(Tag t: list)
            {
                t.insert(this);
            }

            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    
    
}
