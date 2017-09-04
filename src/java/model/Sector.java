/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Config;
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
    
    private int id;
    private String name;
    
    public Sector()
    {
        //--
    }
    
    public Sector(int id, String name)
    {
        this.setId(id);
        this.setName(name);
    }
    
    public static List<Sector> findAll() 
    {
        List<Sector> list = new ArrayList<>();
        
        try 
        {
            
            ResultSet rs = DatabaseUtils.selectAll("sector");
       
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

    public static List<Sector> findBy(String attr, String value) 
    {
        List<Sector> list = new ArrayList<>();
        
        try {
            
            ResultSet rs = DatabaseUtils.selectAllWhere("sector", attr, value);
       
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

    public static Sector findById(int id) 
    {
        Sector sector = null;
        
        try {
            
            ResultSet rs = DatabaseUtils.selectById("sector", id);
       
            if(rs.next())
            {
                sector = instantiateFromCurrentResult(rs);
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return sector;
    }

    public static Sector instantiateFromCurrentResult(ResultSet rs) throws SQLException
    {
        return new Sector(rs.getInt("id"), rs.getString(String.format("name_%s", Config.LANGUAGE)));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}

