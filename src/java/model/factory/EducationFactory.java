package model.factory;

import helpers.DataUtils;
import helpers.RequestUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import model.Education;
import model.EducationLevel;
import model.Location;
import model.Sector;
import model.Tag;
import model.abstraction.Entity;
import model.factory.abstraction.UserEntityFactory;

public class EducationFactory extends UserEntityFactory
{
    {
        modelClass = Education.class;
    }
    
    @Override
    public Entity createEntityFromCurrentResult(ResultSet rs)
    {
        try
        {
            Education education = new Education();
            education.setId(rs.getInt("id"));
            education.setUser_id(rs.getInt("user_id"));
            education.setTitlename(rs.getString("titlename"));
            education.setCenter(rs.getString("center"));
            education.setDescription(rs.getString("description"));
            education.setStartdate(rs.getString("startdate"));
            education.setEnddate(rs.getString("enddate"));
            education.setLevel(EducationLevel.findById(rs.getInt("education_level_id")));
            education.setLocation(Location.create(rs.getInt("country_id"), rs.getString("city")));
            education.setSector(Sector.findById(rs.getInt("sector_id")));
            
            education.setTags(Tag.findOfType(education.getId(), education.getTableName()));
            
            return education;
        } 
        catch (SQLException ex)
        {
            return null;
        }
    }

    @Override
    public Entity createEntityFromRequest(HttpServletRequest request)
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
        education.setTitlename(request.getParameter("titlename"));
        
        if(!RequestUtils.isNullParam(request, "tags"))
        {
            education.setTags(DataUtils.createTagListFromSpacedString(request.getParameter("tags")));
        }
        
        return education;
    }
    
}
