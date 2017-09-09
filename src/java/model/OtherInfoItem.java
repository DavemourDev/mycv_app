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
import java.util.List;

/**
 *
 * @author mati
 */
public class OtherInfoItem 
{
    private String title, description, category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
    public static OtherInfoItem findById(int id) 
    {
        OtherInfoItem info = null;

        try 
        {
            ResultSet rs = DatabaseUtils.selectById("otherinfo", id);
       
            if (rs.next()) 
            {
                info = instantiateFromCurrentResult(rs);
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }

        return info;
    }

    public static List<OtherInfoItem> findAll() 
    {
        List<OtherInfoItem> list = new ArrayList<>();
        
        try 
        {
            
            ResultSet rs = DatabaseUtils.selectAll("otherinfo");
       
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

    public static List<OtherInfoItem> findBy(String attr, String value) 
    {
        List<OtherInfoItem> list = new ArrayList<>();
        
        try {
            
            ResultSet rs = DatabaseUtils.selectAllWhere("otherinfo", attr, value);
       
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

    public static OtherInfoItem instantiateFromCurrentResult(ResultSet rs) throws SQLException
    {
        OtherInfoItem info = new OtherInfoItem();
        info.setCategory(rs.getString("category"));
        info.setTitle(rs.getString("title"));
        info.setDescription(rs.getString("description"));
        return info;
    }
}
