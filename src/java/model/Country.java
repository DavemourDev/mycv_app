/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Config;
import core.Database;
import helpers.DatabaseUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mati
 */
public class Country 
{
    private int id;
    private String name;
    
    public Country(){};
    
    public Country(int id, String name)
    {
        this.setId(id);
        this.setName(name);
    }
    
    public static List<Country> findAll()
    {
        List<Country> list = new ArrayList<>();
        
        try 
        {
            ResultSet rs = DatabaseUtils.selectAll("country");
            
            while(rs.next())
            {
                list.add(instantiateFromResultSet(rs));
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return list;
    }
    
    public static List<Country> findBy(String attr, String value)
    {
        List<Country> list = new ArrayList<>();
        
        try 
        {
            ResultSet rs = DatabaseUtils.selectAllWhere("country", attr, value);
            
            while(rs.next())
            {
                list.add(instantiateFromResultSet(rs));
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return list;
    }
    
    public static Country findById(int id)
    {
        Country country = null;
        
        try 
        {
            ResultSet rs = DatabaseUtils.selectById("country", id);
            
            if(rs.next())
            {
                country = instantiateFromResultSet(rs);
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return country;
    }
    
    public static Country instantiateFromResultSet(ResultSet rs) throws SQLException
    {
        return new Country(rs.getInt("id"), rs.getString(String.format("name_%s", Config.LANGUAGE)));
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
