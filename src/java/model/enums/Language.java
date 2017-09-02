/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.enums;

import config.Config;
import core.Database;
import java.sql.ResultSet;
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

    public static List<Language> findAll() {
        List<Language> list = new ArrayList<>();

        try {
            ResultSet rs = Database.getInstance().query("select * from `language`");

            while (rs.next()) {
                Language language = new Language(rs.getInt("id"), rs.getString(String.format("name_%s", Config.LANGUAGE)));
                list.add(language);
            }
        } catch (Exception ex) {
            System.err.println("Error de conexión con la base de datos.");
        }

        return list;
    }

    public static Gender findById(int id) {
        Gender gender = null;

        try {
            ResultSet rs = Database.getInstance().query("select * from `country` where `id`='" + id + "'");

            if (rs.next()) {
                gender = new Gender(rs.getInt("id"), rs.getString(String.format("name_%s", Config.LANGUAGE)));
            }
        } catch (Exception ex) {
            System.err.println("Error de conexión con la base de datos.");
        }

        return gender;
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
