/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import core.Database;
import helpers.DataUtils;
import helpers.DatabaseUtils;
import helpers.RequestUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mati
 */
public class Experience extends TaggableItem
{
    private int id, hours, user_id;
    private String job, enterprise, startdate, enddate, description;
    private List<String> tags = new ArrayList<String>();
    private Sector sector;
    private Location location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags)
    {
        this.tags=tags;
    }
    
    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public int getUser_id()
    {
        return user_id;
    }

    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }
    
    public static Experience findById(int id) 
    {
        Experience experience = null;

        try {
            
            ResultSet rs = DatabaseUtils.selectById("experience", id);
            
            if (rs.next()) 
            {
                experience = instantiateFromCurrentResult(rs);
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }

        return experience;
    }

    public static List<Experience> findAll() 
    {
        List<Experience> list = new ArrayList<>();
        
        try 
        {
            ResultSet rs = DatabaseUtils.selectAll("experience");
            
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

    public static List<Experience> findBy(String attr, String value) 
    {
        List<Experience> list = new ArrayList<>();
        
        try {
            ResultSet rs = DatabaseUtils.selectAllWhere("experience", attr, value);
            
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

    public static Experience instantiateFromCurrentResult(ResultSet rs) throws SQLException
    {
        Experience experience = new Experience();
        experience.setEnterprise(rs.getString("enterprise"));
        experience.setDescription(rs.getString("description"));
        experience.setStartdate(rs.getString("startdate"));
        experience.setEnddate(rs.getString("enddate"));
        experience.setLocation(Location.create(rs.getInt("country_id"), rs.getString("city")));
        experience.setSector(Sector.findById(rs.getInt("sector_id")));
        experience.setHours(rs.getInt("hours"));
        experience.setJob(rs.getString("job"));
        experience.setTags(DataUtils.splitBySpaces(rs.getString("tags")));
        return experience;
    }
    
    public static Experience instantiateFromRequest(HttpServletRequest request)
    {
        Experience experience = new Experience();
        experience.setUser_id(RequestUtils.getSessionUserId(request));
        experience.setId(RequestUtils.getInt(request, "id"));
        experience.setEnterprise(request.getParameter("enterprise"));
        experience.setDescription(request.getParameter("description"));
        experience.setStartdate(request.getParameter("startdate"));
        experience.setEnddate(request.getParameter("enddate"));
        experience.setLocation(Location.create(request.getParameter("country"), request.getParameter("city")));
        experience.setSector(Sector.findById(RequestUtils.getInt(request, "sector")));
        experience.setHours(RequestUtils.getInt(request, "hours"));
        experience.setJob(request.getParameter("job"));
        experience.setTags(DataUtils.splitBySpaces(request.getParameter("tags")));
        
        return experience;
    }

    public boolean insert() throws Exception
    {
        String query = String.format("insert into `experience`(`user_id`,`enterprise`, `description`, `startdate`, `enddate`, `country_id`, `city`, `sector_id`, `hours`, `job`, `tags`) values ('%d', %s', '%s','%s','%s', '%d', '%s', '%d','%d','%s','%s')",
            this.getUser_id(),
            this.getEnterprise(),    
            this.getDescription(),    
            this.getStartdate(),    
            this.getEnddate(),    
            this.getLocation().getCountry().getId(),    
            this.getLocation().getCity(),
            this.getSector().getId(),
            this.getHours(),
            this.getJob(),
            DataUtils.joinBySpaces(this.getTags())
                );
            
        return Database.getInstance().queryUpdate(query) > 0;
    }
    
}
