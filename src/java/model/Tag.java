/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Tag implements Entity
{
    private int id;
    private String tagtext;
    
    @Override
    public int getId()
    {
        return id;
    }

    @Override
    public void setId(int id)
    {
        this.id = id;
    }

    public String getTagtext()
    {
        return tagtext;
    }

    public void setTagtext(String tagtext)
    {
        this.tagtext = tagtext;
    }
    
    public static List<Tag> findOfType(int id, String type) 
    {
        List<Tag> list = new ArrayList<>();
        
        try 
        {
            ResultSet rs = DatabaseUtils.selectAllWhere(type + "_tag", type + "_id", id);
            
            while(rs.next())
            {
                list.add(instantiateFromCurrentResult(rs));
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
                list.add(instantiateFromCurrentResult(rs));
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
        
        if(tag.getId() > 0)
        {
            tag.setId(rs.getInt("id"));
        }
        
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
        String tablename = item.getTableName();
        HashMap<String, String> params = this.toHashMap();
        
        int item_id = item.getId() == 0 ? DatabaseUtils.getLastId(tablename): item.getId();
        
        params.put(tablename + "_id", String.valueOf(item_id));
        
        return DatabaseUtils.insert(tablename + "_tag", params);
    }
    
    @Override
    public boolean update()
    {
        return true;
    }
    
    /**
     * Busca todas las tags asociadas a un ítem etiquetable y las elimina.
     * @param item
     * @return 
     */
    public static boolean deleteAllForItem(TaggableUserEntity item)
    { 
        try
        {
            //No hagáis esto en casa
            List<Tag> tags = Tag.findAllOfType(item.getUser_id(), item.getTableName());
            for(Tag t : tags)
            {
                t.delete();
            }
            
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    
    public String toString()
    {
        return this.getTagtext();
    }
}
