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
class Sector 
{
    public static Sector findById(int id)
    {
        Sector sector = new Sector();
        //Completar con db como los demás
        return sector;
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

