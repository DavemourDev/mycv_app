package model.interfaces;

import java.util.List;
import model.Tag;

/**
 * Esta interfaz es usada por las clases de modelo que contienen un campo de etiquetas.
 * 
 * Un etiquetable debe tener un campo que represente una lista de etiquetas que se atribuyen a él.
 * 
 * @author David
 */
public interface Taggable
{
    /**
     * Obtiene una lista con todas las tags asociadas a ese objeto.
     * @return 
     */
    public List<Tag> getTags();
    
    /**
     * Asigna un objeto tag al objeto etiquetable.
     * @param tag 
     */
    public void addTag(Tag tag);
    public boolean removeTag(Tag tag);
    public void setTags(List<Tag> tags);
    
    public boolean hasTag(String tag);
}
