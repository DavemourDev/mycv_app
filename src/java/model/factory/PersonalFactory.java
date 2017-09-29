/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory;

import model.factory.abstraction.EntityFactory;
import helpers.RequestUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import model.Gender;
import model.Location;
import model.Personal;
import model.abstraction.Entity;

/**
 *
 * @author David
 */
public class PersonalFactory extends EntityFactory
{
    {
        modelClass = Personal.class;
    }
    
    @Override
    public Entity createEntityFromCurrentResult(ResultSet rs)
    {
        try
        {
            Personal personal = new Personal();
            personal.setId(rs.getInt("id"));
            personal.setName(rs.getString("name"));
            personal.setLastname(rs.getString("lastname"));
            personal.setBirthdate(rs.getString("birthdate"));
            personal.setGender(Gender.findById(rs.getInt("gender_id")));
            personal.setLocation(Location.create(rs.getInt("country_id"), rs.getString("city")));
            personal.setTelephone1(rs.getString("telephone1") == null? "" : rs.getString("telephone1"));   
            personal.setTelephone2(rs.getString("telephone2") == null? "" : rs.getString("telephone2"));
            return personal;
        } 
        catch (SQLException ex)
        {
            return null;
        }
    }

    @Override
    public Entity createEntityFromRequest(HttpServletRequest request)
    {
        Personal personal = new Personal();
        personal.setId(RequestUtils.getInt(request, "id"));
        personal.setName(request.getParameter("name"));
        personal.setLastname(request.getParameter("lastname"));
        personal.setGender(Gender.findById(RequestUtils.getInt(request, "gender")));
        personal.setBirthdate(request.getParameter("birthdate"));
        personal.setLocation(Location.create(RequestUtils.getInt(request,"country"), request.getParameter("city")));
        personal.setTelephone1(request.getParameter("telephone1") == null? "" : request.getParameter("telephone1"));
        personal.setTelephone2(request.getParameter("telephone2") == null? "" : request.getParameter("telephone2"));
        return personal;
    }
    
}
