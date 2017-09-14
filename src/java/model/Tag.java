/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import helpers.DataUtils;
import helpers.DatabaseUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuanRamón
 */
public class Tag
{
    private int id;
    private String tagtext;
    
    public int getId()
    {
        return id;
    }

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
    
    
    public static List<Tag> findAllOfType(int id, String type) 
    {
        List<Tag> list = new ArrayList<>();
        
        try 
        {
            ResultSet rs = DatabaseUtils.selectAllWhere(type +" _tag_view", "user_id", id);
            
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
        tag.setId(rs.getInt("id"));
        tag.setTagtext(rs.getString("tagtext"));

        return tag;
    }
}
