package model;

import helpers.ValidationUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.factory.OtherInfoFactory;
import model.abstraction.TaggableUserEntity;
import model.factory.abstraction.UserEntityFactory;

/**
 *
 * @author David
 */
public class OtherInfo extends TaggableUserEntity
{
    
    protected static UserEntityFactory factory = new OtherInfoFactory();
    private String title, description;
    
    public static UserEntityFactory getFactory()
    {
        return OtherInfo.factory;
    }
    
    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public static OtherInfo withId(int id) 
    {
        return (OtherInfo) getFactory().findById(id);
    }
    
    public static OtherInfo oneWhere(String key, String value) 
    {
        return (OtherInfo) getFactory().findOneBy(key, value);
    }

    public static List<OtherInfo> all() 
    {
        List<OtherInfo> list = new ArrayList<>();
        
        getFactory().findAll().forEach(
            (e) -> list.add((OtherInfo) e)
        );
        
        return list;
    }

    public static List<OtherInfo> allWhere(String attr, String value) 
    {
        List<OtherInfo> list = new ArrayList<>();
        
        getFactory().findBy(attr, value).forEach(
            (e) -> list.add((OtherInfo) e)
        );
        
        return list;
    }

    public static List<OtherInfo> whereUserId(int user_id) 
    {
        List<OtherInfo> list = new ArrayList<>();
        
        getFactory().findByUserId(user_id).forEach(
            (e) -> list.add((OtherInfo) e)
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
        if(this.getUser_id()>0)
        {
            System.out.println("UserId de otherinfo");
            params.put("user_id", String.valueOf(this.getUser_id()));
        }
        params.put("title", this.getTitle());
        params.put("description", this.getDescription());
        
        return params;
    }
    
    
    @Override
    public boolean validate()
    {
        return ValidationUtils.validateOtherInfo(this);
    }
    
}
