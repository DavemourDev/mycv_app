package model;

import helpers.DatabaseUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.interfaces.Entity;
import model.interfaces.TaggableUserEntity;

/**
 *
 * @author JuanRamón
 */
public class Tag extends Entity
{
    private String tagtext;
    
    /**
     * Nombre de la tabla anexada a la instancia de tag. Puesto que esta clase por el momento se utiliza para objetos etiqueta de los tipos experience, 
     * education y otherinfo, este campo es el que distingue un tipo de otro.
     * 
     * Si fuere necesario, en un futuro se crearán clases individuales para cada tipo de tag.
     */
    private String tablename;
    
    public Tag(){}
    
    public Tag(String tablename)
    {
        this.tablename = tablename;
    }
 
    public String getTagtext()
    {
        return tagtext;
    }

    public void setTagtext(String tagtext)
    {
        this.tagtext = tagtext;
    }

    public String getTablename()
    {
        return tablename;
    }

    public void setTablename(String tablename)
    {
        this.tablename = tablename;
    }
    
    public static List<Tag> findOfType(int id, String type) 
    {
        List<Tag> list = new ArrayList<>();
        
        try 
        {
            ResultSet rs = DatabaseUtils.selectAllWhere(type + "_tag", type + "_id", id);
            
            while(rs.next())
            {
                Tag tag = instantiateFromCurrentResult(rs);
                
                list.add(tag);
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return list;
    }
    
    public static List<Tag> findAllOfType(int id, String type) 
    {
        List<Tag> list = new ArrayList<>();
        
        try 
        {
            ResultSet rs = DatabaseUtils.selectAllWhere("all_" + type + "_tags", "user_id", id);
            
            while(rs.next())
            {
                Tag tag = instantiateFromCurrentResult(rs);
                boolean tagExists = false;
                for(Tag t : list)
                {
                    if(tagExists = tag.getTagtext().equals(t.getTagtext()))
                    {
                        break;
                    }
                }
                
                if(!tagExists)
                {
                    list.add(tag);
                }
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return list;
    }
    
    public static Tag instantiateFromCurrentResult(ResultSet rs) throws SQLException
    {
        Tag tag = new Tag();
        
        tag.setId(rs.getInt("id"));
        tag.setTagtext(rs.getString("tagtext"));

        return tag;
    }
    
    @Override
    public HashMap<String, String> toHashMap()
    {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(this.getId()));
        params.put("tagtext", this.getTagtext());
        
        return params;
    }
    
    public boolean insert(TaggableUserEntity item) throws Exception
    {
        String table = item.getTableName();
        HashMap<String, String> params = this.toHashMap();
        
        int item_id = item.getId() == 0 ? DatabaseUtils.getLastId(table): item.getId();
        
        params.put(table + "_id", String.valueOf(item_id));
        
        return DatabaseUtils.insert(table + "_tag", params);
    }
    
    @Override
    public boolean update()
    {
        //Los elementos de las tablas Tag no se actualizan, por tanto este método en esta clase no se utiliza por el momento.
        return true;
    }
    
    /**
     * Busca todas las tags asociadas a un ítem etiquetable y las elimina.
     * @param item
     * @return 
     */
    public static boolean deleteAllForItem(TaggableUserEntity item)
    { 
        String type = item.getTableName();
        
        try
        {
            //No hagáis esto en casa
            List<Tag> tags = Tag.findOfType(item.getUser_id(), type);
            for(Tag t : tags)
            {
                t.setTablename(type);
                t.delete();
            }
            
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    
    @Override
    public String getTableName()
    {
        return this.tablename + "_tag";
    }
    
    @Override
    public String toString()
    {
        return this.getTagtext();
    }
}
