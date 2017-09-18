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
import java.util.HashMap;
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
        //params.put("hours", String.valueOf(this.getHours()));
        params.put("titlename", String.valueOf(this.getTitlename()));
        params.put("education_level_id", String.valueOf(this.getLevel().getId()));
        params.put("tags", DataUtils.joinBySpaces(this.tags));
        System.out.println("HashMap creado");
        return params;
    }
    
    public boolean insert() throws Exception
    {
        return DatabaseUtils.insert("education", this.toHashMap());
    }

    public boolean update() throws Exception
    {
        return DatabaseUtils.update("education", this.toHashMap());
    }
    
    public boolean delete() throws Exception
    {
        return DatabaseUtils.deleteById("experience", this.getId());
    }
}
