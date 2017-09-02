/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.enums;

import core.Database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mati
 */
public class Country 
{
    private String name;
    
    public Country(){};
    
    public Country(String name)
    {
        this.setName(name);
    }
    
    public static List<Country> findAll()
    {
        List<Country> list = new ArrayList<>();
        
        try 
        {
            ResultSet rs = Database.getInstance().query("select * from `country`");
            
            while(rs.next())
            {
                Country country = new Country(rs.getString("name"));
                list.add(country);
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
            ResultSet rs = Database.getInstance().query("select * from `country` where `id`='" + id + "'");
            
            if(rs.next())
            {
                country = new Country(rs.getString("name"));
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }
        
        return country;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
