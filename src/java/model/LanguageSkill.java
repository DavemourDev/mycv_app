package model;

import helpers.ValidationUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.abstraction.UserEntity;
import model.factory.LanguageSkillFactory;
import model.factory.abstraction.UserEntityFactory;

/**
 *
 * @author David
 */
public class LanguageSkill extends UserEntity
{
    
    protected static UserEntityFactory factory = new LanguageSkillFactory();
    private Language language;
    private int speech, comprehension, writing, level;
    private String description;

    public static UserEntityFactory getFactory()
    {
        return LanguageSkill.factory;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    
    
    public static LanguageSkill withId(int id) 
    {
        return (LanguageSkill) getFactory().findById(id);
    }

    public static List<LanguageSkill> all() 
    {
        List<LanguageSkill> list = new ArrayList<>();
        
        getFactory().findAll().forEach(
            (e) -> list.add((LanguageSkill) e)
        );
        
        return list;
    }

    public static LanguageSkill oneWhere(String key, String value) 
    {
        return (LanguageSkill) getFactory().findOneBy(key, value);
    }
    
    public static List<LanguageSkill> allWhere(String attr, String value) 
    {
        List<LanguageSkill> list = new ArrayList<>();
        
        getFactory().findBy(attr, value).forEach(
            (e) -> list.add((LanguageSkill) e)
        );
        
        return list;
    }

    public static List<LanguageSkill> whereUserId(int user_id) 
    {
        List<LanguageSkill> list = new ArrayList<>();
        
        getFactory().findByUserId(user_id).forEach(
            (e) -> list.add((LanguageSkill) e)
        );
        
        return list;
    }
    
    @Override
    public HashMap toHashMap()
    {
        HashMap<String, String> params = new HashMap<>();
        
        if(this.getId() > 0)
        {
            params.put("id", String.valueOf(this.getId()));
        }
        
        if(this.getUser_id() > 0)
        {
            params.put("user_id", String.valueOf(this.getUser_id()));
        }
        
        params.put("language_id", String.valueOf(this.getLanguage().getId()));
        params.put("speech", String.valueOf(this.getSpeech()));
        params.put("comprehension", String.valueOf(this.getComprehension()));
        params.put("writing", String.valueOf(this.getWriting()));
        params.put("language_global_level_id", String.valueOf(this.getLevel()));
        params.put("description", this.getDescription());
        
        
        return params;
    }    

    @Override
    public boolean validate()
    {
        return ValidationUtils.validateLanguageSkill(this);
    }
    
}
