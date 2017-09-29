package model;

import helpers.ValidationUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.factory.ExperienceFactory;
import model.abstraction.TaggableUserEntity;
import model.factory.abstraction.UserEntityFactory;

/**
 *
 * @author David
 */
public class Experience extends TaggableUserEntity
{
    
    protected static UserEntityFactory factory = new ExperienceFactory();
    private String job, enterprise, startdate, enddate, description;
    private Sector sector;
    private Location location;

    public static UserEntityFactory getFactory()
    {
        return Experience.factory;
    }
    
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
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
    
    public static Experience withId(int id) 
    {
        return (Experience) getFactory().findById(id);
    }

    public static List<Experience> all() 
    {
        List<Experience> list = new ArrayList<>();
        
        getFactory().findAll().forEach(
            (e) -> list.add((Experience) e)
        );
        
        return list;
    }

    public static Experience oneWhere(String key, String value) 
    {
        return (Experience) getFactory().findOneBy(key, value);
    }
    
    public static List<Experience> allWhere(String attr, String value) 
    {
        List<Experience> list = new ArrayList<>();
        
        getFactory().findBy(attr, value).forEach(
            (e) -> list.add((Experience) e)
        );
        
        return list;
    }

    public static List<Experience> whereUserId(int user_id) 
    {
        List<Experience> list = new ArrayList<>();
        
        getFactory().findByUserId(user_id).forEach(
            (e) -> list.add((Experience) e)
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
        params.put("enterprise", this.getEnterprise());
        params.put("description", this.getDescription());
        params.put("startdate", this.getStartdate());
        params.put("enddate", this.getEnddate());
        params.put("country_id", String.valueOf(this.getLocation().getCountry().getId()));
        params.put("city", this.getLocation().getCity());
        params.put("sector_id", String.valueOf(this.getSector().getId()));
        params.put("job", String.valueOf(this.getJob()));
        
        System.out.println("HashMap creado");
        return params;
    }
    
    @Override
    public boolean validate()
    {
        try
        {
            return ValidationUtils.validateExperience(this);
        } 
        catch (Exception ex)
        {
            return false;
        }
    }
    
}
