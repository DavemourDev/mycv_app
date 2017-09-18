/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import helpers.DataUtils;
import helpers.DatabaseUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author mati
 */
public class LanguageSkill 
{
    private static final String TABLE_NAME = "languageskill";
    private Language language;
    private int id, user_id, speech, comprehension, writing;
    LanguageLevel level;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getUser_id()
    {
        return user_id;
    }

    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }

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
            
            ResultSet rs = DatabaseUtils.selectById(TABLE_NAME, id);
            
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

    public static List<LanguageSkill> findBy(String attr, String value) 
    {
        List<LanguageSkill> list = new ArrayList<>();
        
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
    
    /**
     * Traduce el objeto a un hashMap compatible con la base de datos.
     * @return HashMap que asocia campos de tablas a valores.
     */
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
        
        params.put("language_id", String.valueOf(this.getLanguage().getId()));
        params.put("speech", String.valueOf(this.getSpeech()));
        params.put("comprehension", String.valueOf(this.getComprehension()));
        params.put("writing", String.valueOf(this.getWriting()));
        params.put("global_level", String.valueOf(this.getLevel().getId()));
        
        return params;
    }    
    
    public boolean insert() throws Exception
    {
        return DatabaseUtils.insert(TABLE_NAME, this.toHashMap());
    }
    
    public boolean update() throws Exception
    {
        return DatabaseUtils.update(TABLE_NAME, this.toHashMap());
    }
    
    public boolean delete() throws Exception
    {
        return DatabaseUtils.deleteById(TABLE_NAME, this.getId());
    }
}
