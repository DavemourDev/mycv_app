/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import helpers.DataUtils;
import helpers.DatabaseUtils;
import helpers.RequestUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.interfaces.TaggableUserEntity;

/**
 *
 * @author David
 */
public class OtherInfoItem extends TaggableUserEntity
{
    private static final String TABLE_NAME = "otherinfo";
    
    private String title, description;
    
    public String getTitle() 
    {
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
    
    public static OtherInfoItem findById(int id) 
    {
        OtherInfoItem info = null;

        try 
        {
            ResultSet rs = DatabaseUtils.selectById(TABLE_NAME, id);
       
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
            
            ResultSet rs = DatabaseUtils.selectAll(TABLE_NAME);
       
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
            
            ResultSet rs = DatabaseUtils.selectAllWhere(TABLE_NAME, attr, value);
       
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
        info.setId(rs.getInt("id"));
        info.setUser_id(rs.getInt("user_id"));
        info.setTitle(rs.getString("title"));
        info.setDescription(rs.getString("description"));
        
        info.setTags(Tag.findOfType(info.getId(), info.getTableName()));
        
        return info;
    }
        
    public static OtherInfoItem instantiateFromRequest(HttpServletRequest request)
    {
        OtherInfoItem item = new OtherInfoItem();
        item.setUser_id(RequestUtils.getSessionUserId(request));
        item.setId(RequestUtils.getInt(request, "id"));
        item.setTitle(RequestUtils.getString(request, "title"));
        item.setDescription(RequestUtils.getString(request, "description"));
        
        if(!RequestUtils.isNullParam(request, "tags"))
        {
            item.setTags(DataUtils.createTagListFromSpacedString(request.getParameter("tags")));
        }
        
        return item;
    }

    @Override
    public HashMap toHashMap()
    {
        HashMap<String, String> params = new HashMap<>();
        
        if(this.getId()>0)
        {
            params.put("id", String.valueOf(this.getId()));
        }
        if(this.getUser_id()>0)
        {
            params.put("user_id", String.valueOf(this.getUser_id()));
        }
        params.put("title", this.getTitle());
        params.put("description", this.getDescription());
        
        return params;
    }
    
    
    @Override
    public String getTableName()
    {
        return "otherinfo";
    }
}
