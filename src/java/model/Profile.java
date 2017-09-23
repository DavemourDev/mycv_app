package model;

import helpers.DataUtils;
import helpers.RequestUtils;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.interfaces.UserEntity;

public class Profile extends UserEntity
{

    private int id, user_id, personalOrder, picture_display, experienceOrder, educationOrder, languageOrder, otherinfoOrder;
    private List<Tag> experienceTags, educationTags, otherinfoTags; 
    private String personalMark;
    
    @Override
    public void setUser_id(int id)
    {
        this.user_id = id;
    }

    @Override
    public int getUser_id()
    {
        return this.user_id;
    }

    public int getPersonalOrder()
    {
        return personalOrder;
    }

    public void setPersonalOrder(int personalOrder)
    {
        this.personalOrder = personalOrder;
    }

    public int getPicture_display()
    {
        return picture_display;
    }

    public void setPicture_display(int picture_display)
    {
        this.picture_display = picture_display;
    }

    public int getExperienceOrder()
    {
        return experienceOrder;
    }

    public void setExperienceOrder(int experienceOrder)
    {
        this.experienceOrder = experienceOrder;
    }

    public int getEducationOrder()
    {
        return educationOrder;
    }

    public void setEducationOrder(int educationOrder)
    {
        this.educationOrder = educationOrder;
    }

    public int getLanguageOrder()
    {
        return languageOrder;
    }

    public void setLanguageOrder(int languageOrder)
    {
        this.languageOrder = languageOrder;
    }

    public int getOtherinfoOrder()
    {
        return otherinfoOrder;
    }

    public void setOtherinfoOrder(int otherinfoOrder)
    {
        this.otherinfoOrder = otherinfoOrder;
    }

    public List<Tag> getExperienceTags()
    {
        return experienceTags;
    }

    public void setExperienceTags(List<Tag> experienceTags)
    {
        this.experienceTags = experienceTags;
    }

    public List<Tag> getEducationTags()
    {
        return educationTags;
    }

    public void setEducationTags(List<Tag> educationTags)
    {
        this.educationTags = educationTags;
    }

    public List<Tag> getOtherinfoTags()
    {
        return otherinfoTags;
    }

    public void setOtherinfoTags(List<Tag> otherinfoTags)
    {
        this.otherinfoTags = otherinfoTags;
    }

    public String getPersonalMark()
    {
        return personalMark;
    }

    public void setPersonalMark(String personalMark)
    {
        this.personalMark = personalMark;
    }

    @Override
    public HashMap toHashMap()
    {
        HashMap<String,String> params = new HashMap<>(); 
        
        return params;
    }

    @Override
    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public int getId()
    {
        return this.id;
    }
    
    public static Profile instantiateFromRequest(HttpServletRequest request)
    {
        Profile profile = new Profile();
        
        //Obtener parametros de la request
        profile.setId(RequestUtils.getInt(request, "id"));
        profile.setUser_id(RequestUtils.getInt(request, "user_id"));
        
        profile.setPersonalOrder(RequestUtils.getInt(request, "personal-order"));
        profile.setEducationOrder(RequestUtils.getInt(request, "education-order"));
        profile.setExperienceOrder(RequestUtils.getInt(request, "experience-order"));
        profile.setLanguageOrder(RequestUtils.getInt(request, "language-order"));
        profile.setOtherinfoOrder(RequestUtils.getInt(request, "otherinfo-order"));
        
        profile.setPersonalMark(RequestUtils.getString(request, "personal-mark"));
        profile.setPicture_display(RequestUtils.getInt(request, "picture-display"));
        
        profile.setEducationTags(DataUtils.createTagListFromStringArray(request.getParameterValues("education-tags")));
        profile.setExperienceTags(DataUtils.createTagListFromStringArray(request.getParameterValues("experience-tags")));
        profile.setOtherinfoTags(DataUtils.createTagListFromStringArray(request.getParameterValues("otherinfo-tags")));
        
        return profile;
    }
    
    public static Profile instantiateFromCurrentResult(ResultSet rs) throws Exception
    {
        Profile profile = new Profile();
        
        //Obtener parametros del resultSet
        
        profile.setId(rs.getInt("id"));
        profile.setUser_id(rs.getInt("user_id"));
        
        profile.setPersonalOrder(rs.getInt("personal-order"));
        profile.setEducationOrder(rs.getInt("education-order"));
        profile.setExperienceOrder(rs.getInt("experience-order"));
        profile.setLanguageOrder(rs.getInt("language-order"));
        profile.setOtherinfoOrder(rs.getInt("otherinfo-order"));
        
        profile.setPersonalMark(rs.getString("personal-mark"));
        profile.setPicture_display(rs.getInt("picture-display"));
        
        profile.setEducationTags(Tag.findAllOfType(profile.getUser_id(), "education"));
        profile.setExperienceTags(Tag.findAllOfType(profile.getUser_id(), "experience"));
        profile.setOtherinfoTags(Tag.findAllOfType(profile.getUser_id(), "otherinfo"));
        
        return profile;
    }
    
    public List<Experience> getAllExperiencesMatchingTags()
    {
        List<Experience> list = new ArrayList<>();
        
        return list;
    }
    //Listas para las demás
}
