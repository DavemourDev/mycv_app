/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.enums;

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
public class Language 
{
    private int id;
    private String name, iso1, iso2;
    
    public Language() 
    {
    //NADA
    }

    public Language(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public static List<Language> findAll() 
    {
        List<Language> list = new ArrayList<>();

        try {
            ResultSet rs = DatabaseUtils.selectAll("language");

            while (rs.next()) {
                list.add(instantiateFromCurrentResult(rs));
            }
        } catch (Exception ex) {
            System.err.println("Error de conexión con la base de datos.");
        }

        return list;
    }

    public static List<Language> findBy(String attr, String value) 
    {
        List<Language> list = new ArrayList<>();

        try {
            ResultSet rs = DatabaseUtils.selectAllWhere("language", attr, value);

            while (rs.next()) {
                list.add(instantiateFromCurrentResult(rs));
            }
        } catch (Exception ex) {
            System.err.println("Error de conexión con la base de datos.");
        }

        return list;
    }

    public static Language findById(int id) 
    {
        Language language = null;
        try 
        {
            
            ResultSet rs = DatabaseUtils.selectById("language", id);

            if (rs.next()) 
            {
                language = instantiateFromCurrentResult(rs);
            }
        } catch (Exception ex) {
            System.err.println("Error de conexión con la base de datos.");
        }

        return language;
    }

    public static Language instantiateFromCurrentResult(ResultSet rs) throws SQLException
    {
        Language language = new Language();
        language.setId(rs.getInt("id"));
        language.setName(rs.getString(String.format("name_%s", Config.LANGUAGE)));
        language.setIso1(rs.getString("iso1"));
        language.setIso2(rs.getString("iso2"));
        return language;
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

    public String getIso1() {
        return iso1;
    }

    public void setIso1(String iso1) {
        this.iso1 = iso1;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    @Override
    public String toString()
    {
        return this.getName();
    }
    
    
}
