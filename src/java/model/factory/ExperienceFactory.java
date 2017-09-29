package model.factory;

import model.factory.abstraction.UserEntityFactory;
import helpers.DataUtils;
import helpers.RequestUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import model.Experience;
import model.Location;
import model.Sector;
import model.Tag;
import model.abstraction.Entity;

public class ExperienceFactory extends UserEntityFactory 
{
    {
        modelClass = Experience.class;
    }
    
    
    @Override
    public Entity createEntityFromCurrentResult(ResultSet rs)
    {
        try
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
            experience.setJob(rs.getString("job"));
            
            experience.setTags(Tag.findOfType(experience.getId(), experience.getTableName()));
            
            return experience;
        } 
        catch (SQLException ex)
        {
            return null;
        }
    }

    @Override
    public Entity createEntityFromRequest(HttpServletRequest request)
    {
        Experience experience = new Experience();
        
        if(!RequestUtils.isNullParam(request, "id"))
        {
            experience.setId(RequestUtils.getInt(request, "id"));
        }
        
        experience.setUser_id(RequestUtils.getSessionUserId(request));
        experience.setEnterprise(request.getParameter("enterprise"));
        experience.setDescription(request.getParameter("description"));
        experience.setStartdate(request.getParameter("startdate"));
        experience.setEnddate(request.getParameter("enddate"));
        experience.setLocation(Location.create(request.getParameter("country"), request.getParameter("city")));
        experience.setSector(Sector.findById(RequestUtils.getInt(request, "sector")));
        experience.setJob(request.getParameter("job"));
        
        if(!RequestUtils.isNullParam(request, "tags"))
        {
            experience.setTags(DataUtils.createTagListFromSpacedString(request.getParameter("tags")));
        }
        
        return experience;
    }
    
}
