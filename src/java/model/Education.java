/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import helpers.ValidationUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.abstraction.TaggableUserEntity;
import model.factory.EducationFactory;
import model.factory.abstraction.UserEntityFactory;

/**
 *
 * @author David
 */
public class Education extends TaggableUserEntity
{
    
    protected static UserEntityFactory factory = new EducationFactory();
    private String titlename, center, startdate, enddate, description;
    private Sector sector;
    private Location location;
    private EducationLevel level;
    
    public static UserEntityFactory getFactory()
    {
        return Education.factory;
    }
    
    public String getTitlename() {
        return titlename;
    }

    public void setTitlename(String titlename) {
        this.titlename = titlename;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public EducationLevel getLevel() {
        return level;
    }

    public void setLevel(EducationLevel level) {
        this.level = level;
    }

    public static Education withId(int id) 
    {
        return (Education) getFactory().findById(id);
    }

    public static List<Education> all() 
    {
        List<Education> list = new ArrayList<>();
        
        getFactory().findAll().forEach(
            (e) -> list.add((Education) e)
        );
        
        return list;
    }

    public static List<Education> allWhere(String attr, String value) 
    {
        List<Education> list = new ArrayList<>();
        
        getFactory().findBy(attr, value).forEach(
            (e) -> list.add((Education) e)
        );
        
        return list;
    }

    public static Education oneWhere(String attr, String value) 
    {
        return (Education) getFactory().findOneBy(attr, value);
    }
    

    public static List<Education> whereUserId(int user_id) 
    {
        List<Education> list = new ArrayList<>();
        
        getFactory().findByUserId(user_id).forEach(
            (e) -> list.add((Education) e)
        );
        
        return list;
    }
    
    @Override
    public HashMap toHashMap()
    {
        HashMap<String, String> params = new HashMap<>();
        
        if(this.getId()>0)
        {
            params.put("id", String.valueOf(this.getId()));
        }
        
        params.put("user_id", String.valueOf(this.getUser_id()));
        params.put("center", this.getCenter());
        params.put("description", this.getDescription());
        params.put("startdate", this.getStartdate());
        params.put("enddate", this.getEnddate());
        params.put("country_id", String.valueOf(this.getLocation().getCountry().getId()));
        params.put("city", this.getLocation().getCity());
        params.put("sector_id", String.valueOf(this.getSector().getId()));
        params.put("titlename", String.valueOf(this.getTitlename()));
        params.put("education_level_id", String.valueOf(this.getLevel().getId()));
        
        return params;
    }
 
    
    @Override
    public boolean validate()
    {
        try
        {
            return ValidationUtils.validateEducation(this);
        } 
        catch (Exception ex)
        {
            return false;
        }
    }
    
    public static void main(String[] args)
    {
        int user_id = 1;
        
        User user = User.withId(user_id);
        
        List<Education> educations = user.getEducations();
        System.out.println(user.getEducations().size());
    }
    
}
