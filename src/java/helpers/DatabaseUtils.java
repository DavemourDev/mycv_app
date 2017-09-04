/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import core.Database;
import java.sql.ResultSet;

/**
 *
 * @author mati
 */
public class DatabaseUtils 
{
    private DatabaseUtils(){};
    
    public static ResultSet selectAll(String table)
    {
        ResultSet rs = null;
        
        try
        {
            rs = Database.getInstance().query("select * from `" + table + "`;"); 
        }
        catch(Exception ex)
        {
            System.err.println("Error con la base de datos....");
        }
        
        return rs;
    }
  
    public static ResultSet selectAllWhere(String table, String attr, int value)
    {
        return selectAllWhere(table, attr, String.valueOf(value));
    }
    
    public static ResultSet selectAllWhere(String table, String attr, double value)
    {
        return selectAllWhere(table, attr, String.valueOf(value));
    }
    
    public static ResultSet selectAllWhere(String table, String attr, boolean value)
    {
        return selectAllWhere(table, attr, String.valueOf(value));
    }
            
    public static ResultSet selectAllWhere(String table, String attr, String value)
    {
        ResultSet rs = null;
        
        try
        {
            rs = Database.getInstance().query("select * from `" + table + "` where `" + attr + "`='" + value + "';"); 
        
        }
        catch(Exception ex)
        {
            System.err.println("Error con la base de datos....");
        }
        
        return rs;
        
    }
    
    public static ResultSet selectById(String table, int id)
    {
        ResultSet rs = null;
        
        try
        {
            rs = Database.getInstance().query("select * from `" + table + "` where `id`=" + String.valueOf(id) +";"); 
        }
        catch(Exception ex)
        {
            System.err.println("Error con la base de datos....");
        }
        
        return rs;
        
    }
}
