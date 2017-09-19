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
public class LanguageLevel {
    
    
    public static final int LANGUAGE_LEVEL_PARTIAL = 0;
    public static final int LANGUAGE_LEVEL_GLOBAL = 1;
    private static final String TABLE_NAME_PARTIAL = "language_level";
    private static final String TABLE_NAME_GLOBAL = "language_global_level";
    private int id;
    private String name; 

    public LanguageLevel(int id, String name)
    {
        this.setId(id);
        this.setName(name);
    }
    
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    public static String getTableName(int type)
    {
        return type == LANGUAGE_LEVEL_PARTIAL ? TABLE_NAME_PARTIAL : TABLE_NAME_GLOBAL;
    }
    
    public static List<LanguageLevel> findAll(int type) 
    {
        List<LanguageLevel> list = new ArrayList<>();

        try 
        {
            ResultSet rs = DatabaseUtils.selectAll(getTableName(type));

            while (rs.next()) {
                list.add(instantiateFromCurrentResult(rs));
            }
        } catch (Exception ex) {
            System.err.println("Error de conexión con la base de datos.");
        }

        return list;
    }

    public static List<LanguageLevel> findBy(String attr, String value, int type) 
    {
        List<LanguageLevel> list = new ArrayList<>();

        try {
            ResultSet rs = DatabaseUtils.selectAllWhere(getTableName(type), attr, value);

            while (rs.next()) {
                list.add(instantiateFromCurrentResult(rs));
            }
        } catch (Exception ex) {
            System.err.println("Error de conexión con la base de datos.");
        }

        return list;
    }

    public static LanguageLevel findById(int id, int type) 
    {
        LanguageLevel languageLevel = null;
        try 
        {
            ResultSet rs = DatabaseUtils.selectById(getTableName(type), id);

            if (rs.next()) 
            {
                languageLevel = instantiateFromCurrentResult(rs);
            }
        } catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }

        return languageLevel;
    }
    
    public static LanguageLevel instantiateFromCurrentResult(ResultSet rs) throws SQLException
    {
       return new LanguageLevel(rs.getInt("id"), rs.getString("name_"+Config.LANGUAGE));
    }
    
}
