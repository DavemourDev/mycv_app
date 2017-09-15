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
public class Education extends TaggableItem
{
    private int id, hours, user_id;
    private String titlename, center, startdate, enddate, description;
    private Sector sector;
    private Location location;
    private EducationLevel level;
    private List<String> tags;

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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    
    public static Education findById(int id) 
    {
        Education education = null;

        try 
        {
            ResultSet rs = DatabaseUtils.selectById("education",id);
       
            if (rs.next()) 
            {
                education = instantiateFromCurrentResult(rs);
            }
        } 
        catch (Exception ex) 
        {
            System.err.println("Error de conexión con la base de datos.");
        }

        return education;
    }

    public static List<Education> findAll() 
    {
        List<Education> list = new ArrayList<>();
        
        try 
        {
            
            ResultSet rs = DatabaseUtils.selectAll("education");
       
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

    public static List<Education> findBy(String attr, String value) 
    {
        List<Education> list = new ArrayList<>();
        
        try {
            
            ResultSet rs = DatabaseUtils.selectAllWhere("education", attr, value);
       
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

    public static Education instantiateFromCurrentResult(ResultSet rs) throws SQLException
    {
        Education education = new Education();
        education.setId(rs.getInt("id"));
        education.setUser_id(rs.getInt("user_id"));
        education.setCenter(rs.getString("center"));
        education.setDescription(rs.getString("description"));
        education.setStartdate(rs.getString("startdate"));
        education.setEnddate(rs.getString("enddate"));
        education.setLevel(EducationLevel.findById(rs.getInt("education_level_id")));
        education.setLocation(Location.create(rs.getInt("country_id"), rs.getString("city")));
        education.setSector(Sector.findById(rs.getInt("sector_id")));
        education.setHours(rs.getInt("hours"));
        return education;
    }
    
        
    public static Education instantiateFromRequest(HttpServletRequest request)
    {
        Education education = new Education();
        education.setUser_id(RequestUtils.getSessionUserId(request));
        education.setId(RequestUtils.getInt(request, "id"));
        education.setCenter(request.getParameter("center"));
        education.setDescription(request.getParameter("description"));
        education.setStartdate(request.getParameter("startdate"));
        education.setEnddate(request.getParameter("enddate"));
        education.setLocation(Location.create(request.getParameter("country"), request.getParameter("city")));
        education.setLevel(EducationLevel.findById(RequestUtils.getInt(request, "level")));
        education.setSector(Sector.findById(RequestUtils.getInt(request, "sector")));
        education.setHours(RequestUtils.getInt(request, "hours"));
        education.setTitlename(request.getParameter("titlename"));
        education.setTags(DataUtils.splitBySpaces(request.getParameter("tags")));
        
        return education;
    }

    public boolean insert() throws Exception
    {
        String query = String.format("insert into `education`(`user_id`,`center`, `description`, `startdate`, `enddate`, `country_id`, `city`, `sector_id`, `hours`, `titlename`, `level`,`tags`) values ('%d', '%s', '%s','%s','%s', '%d', '%s', '%d','%d','%s','%s')",
            this.getUser_id(),
            this.getCenter(),    
            this.getDescription(),    
            this.getStartdate(),    
            this.getEnddate(),    
            this.getLocation().getCountry().getId(),    
            this.getLocation().getCity(),
            this.getSector().getId(),
            this.getHours(),
            this.getTitlename(),
            this.getLevel(),
            DataUtils.joinBySpaces(this.getTags())
                );
            
        return Database.getInstance().queryUpdate(query) > 0;
    }
 

}
