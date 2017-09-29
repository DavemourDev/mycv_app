package model.factory;

import helpers.DataUtils;
import helpers.RequestUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import model.OtherInfo;
import model.Tag;
import model.abstraction.Entity;
import model.factory.abstraction.UserEntityFactory;

public class OtherInfoFactory extends UserEntityFactory
{
    {
        modelClass = OtherInfo.class;
    }
    
    @Override
    public Entity createEntityFromCurrentResult(ResultSet rs)
    {
        try
        {
            OtherInfo info = new OtherInfo();
            info.setId(rs.getInt("id"));
            info.setUser_id(rs.getInt("user_id"));
            info.setTitle(rs.getString("title"));
            info.setDescription(rs.getString("description"));
            
            info.setTags(Tag.findOfType(info.getId(), info.getTableName()));
            
            return info;
        } 
        catch (SQLException ex)
        {
            return null;
        }
    }

    @Override
    public Entity createEntityFromRequest(HttpServletRequest request)
    {
        OtherInfo item = new OtherInfo();
        
        if(!RequestUtils.isNullParam(request, "id"))
        {
            item.setId(RequestUtils.getInt(request, "id"));
        }
        
        item.setUser_id(RequestUtils.getSessionUserId(request));
        item.setTitle(RequestUtils.getString(request, "title"));
        item.setDescription(RequestUtils.getString(request, "description"));
        
        if(!RequestUtils.isNullParam(request, "tags"))
        {
            item.setTags(DataUtils.createTagListFromSpacedString(request.getParameter("tags")));
        }
        
        return item;
    }
    
}
