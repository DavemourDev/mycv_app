/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory;

import helpers.RequestUtils;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import model.Experience;
import model.Language;
import model.LanguageSkill;
import model.abstraction.Entity;
import model.factory.abstraction.UserEntityFactory;

/**
 *
 * @author David
 */
public class LanguageSkillFactory extends UserEntityFactory
{
    {
        modelClass = LanguageSkill.class;
    }
    
    @Override
    public Entity createEntityFromCurrentResult(ResultSet rs)
    {
        try
        {
            LanguageSkill ls = new LanguageSkill();
            ls.setId(rs.getInt("id"));
            ls.setLanguage(Language.findById(rs.getInt("language_id")));
            ls.setUser_id(rs.getInt("user_id"));
            ls.setComprehension(rs.getInt("comprehension"));
            ls.setSpeech(rs.getInt("speech"));
            ls.setWriting(rs.getInt("writing"));
            ls.setLevel(rs.getInt("language_global_level_id"));
            ls.setDescription(rs.getString("description"));

            System.out.println("Instancia creada");

            return ls;
        }
        catch(Exception ex)
        {
            return null;
        }
    }

    @Override
    public Entity createEntityFromRequest(HttpServletRequest request)
    {
        LanguageSkill ls = new LanguageSkill();
        
        if(!RequestUtils.isNullParam(request, "id"))
        {
            ls.setId(RequestUtils.getInt(request, "id"));
        }
        
        ls.setLanguage(Language.findById(RequestUtils.getInt(request, "language")));
        ls.setUser_id(RequestUtils.getSessionUserId(request));
        ls.setSpeech(RequestUtils.getInt(request, "speech"));
        ls.setComprehension(RequestUtils.getInt(request, "comprehension"));
        ls.setWriting(RequestUtils.getInt(request, "writing"));
        ls.setLevel(RequestUtils.getInt(request, "level"));
        ls.setDescription(request.getParameter("description"));
        
        return ls;
    }
    
}
