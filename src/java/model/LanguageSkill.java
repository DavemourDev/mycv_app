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
import model.enums.Language;
import model.enums.LanguageLevel;

/**
 *
 * @author mati
 */
public class LanguageSkill 
{
    private Language language;
    private int speech, comprehension, writing;
    LanguageLevel level;

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getSpeech() {
        return speech;
    }

    public void setSpeech(int speech) {
        this.speech = speech;
    }

    public int getComprehension() {
        return comprehension;
    }

    public void setComprehension(int comprehension) {
        this.comprehension = comprehension;
    }

    public int getWriting() {
        return writing;
    }

    public void setWriting(int writing) {
        this.writing = writing;
    }

    public LanguageLevel getLevel() {
        return level;
    }

    public void setLevel(LanguageLevel level) {
        this.level = level;
    }
    
    
    public static LanguageSkill findById(int id) 
    {
        LanguageSkill ls = null;

        try {
            
            ResultSet rs = DatabaseUtils.selectById("languageskill", id);
            
            if (rs.next()) 
            {
                ls = instantiateFromCurrentResult(rs);
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }

        return ls;
    }

    public static List<LanguageSkill> findAll() 
    {
        List<LanguageSkill> list = new ArrayList<>();
        
        try 
        {
            ResultSet rs = DatabaseUtils.selectAll("languageskill");
            
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

    public static List<LanguageSkill> findBy(String attr, String value) 
    {
        List<LanguageSkill> list = new ArrayList<>();
        
        try {
            ResultSet rs = DatabaseUtils.selectAllWhere("languageskill", attr, value);
            
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

    public static LanguageSkill instantiateFromCurrentResult(ResultSet rs) throws SQLException
    {
        LanguageSkill ls = new LanguageSkill();
        ls.setLanguage(Language.findById(rs.getInt("language_id")));
        ls.setComprehension(rs.getInt("comprehension"));
        ls.setSpeech(rs.getInt("speech"));
        ls.setWriting(rs.getInt("writing"));
        ls.setLevel(LanguageLevel.findById(rs.getInt("global_level")));
        return ls;
    }
    
    
}
