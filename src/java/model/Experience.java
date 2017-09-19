/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class Experience extends TaggableItem
{
    private static final String TABLE_NAME = "experience";
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
            
            ResultSet rs = DatabaseUtils.selectById(TABLE_NAME, id);
            
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

    public static List<Experience> findBy(String attr, String value) 
    {
        List<Experience> list = new ArrayList<>();
        
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
        
        params.put("user_id", String.valueOf(this.getUser_id()));
        params.put("enterprise", this.getEnterprise());
        params.put("description", this.getDescription());
        params.put("startdate", this.getStartdate());
        params.put("enddate", this.getEnddate());
        params.put("country_id", String.valueOf(this.getLocation().getCountry().getId()));
        params.put("city", this.getLocation().getCity());
        params.put("sector_id", String.valueOf(this.getSector().getId()));
        //params.put("hours", String.valueOf(this.getHours()));
        params.put("job", String.valueOf(this.getJob()));
        params.put("tags", DataUtils.joinBySpaces(this.tags));
        System.out.println("HashMap creado");
        return params;
    }
    
    public static Experience instantiateFromCurrentResult(ResultSet rs) throws SQLException
    {
        Experience experience = new Experience();
        experience.setId(rs.getInt("id"));
        experience.setUser_id(rs.getInt("user_id"));
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
        experience.setId(RequestUtils.getInt(request, "id"));
        experience.setUser_id(RequestUtils.getSessionUserId(request));
        experience.setEnterprise(request.getParameter("enterprise"));
        experience.setDescription(request.getParameter("description"));
        experience.setStartdate(request.getParameter("startdate"));
        experience.setEnddate(request.getParameter("enddate"));
        experience.setLocation(Location.create(request.getParameter("country"), request.getParameter("city")));
        experience.setSector(Sector.findById(RequestUtils.getInt(request, "sector")));
        experience.setHours(RequestUtils.getInt(request, "hours"));
        experience.setJob(request.getParameter("job"));
        
        if(!RequestUtils.isNullParam(request, "tags"))
        {
            experience.setTags(DataUtils.splitBySpaces(request.getParameter("tags")));
        }
        
        return experience;
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
