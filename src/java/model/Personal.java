/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import helpers.ValidationUtils;
import java.util.HashMap;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import model.factory.PersonalFactory;
import model.abstraction.Entity;
import model.factory.abstraction.EntityFactory;

/**
 *
 * @author David
 */
public class Personal extends Entity
{
    
    protected static EntityFactory factory = new PersonalFactory();
    private String name, lastname, birthdate, telephone1, telephone2, picture;
    private Gender gender;
    private Location location;

    public static EntityFactory getFactory()
    {
        return Personal.factory;   
    }
    
    
    public static Personal withId(int id)
    {
        return (Personal) getFactory().findById(id);
    }
    
    public static Personal oneWhere(String attr, String value)
    {
        return (Personal) getFactory().findOneBy(attr, value);
    }
    
    public boolean exists()
    {
        return getFactory().findById(this.getId()) != null;
    }
  
    
    public boolean insertOrUpdate()
    {
        try{
            if(this.exists())
            {
                //Si existe un registro con la misma id de usuario, lo modifica
                return this.update();
            }
            else
            {
                //De lo contrario, crea uno nuevo usando la implementación de Entity para insert
                return super.insert();
            }
        }
        catch(Exception ex)
        {
            System.err.println("Error al insertar/modificar info personal");
            return false;
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Gender getGender() 
    {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }
    

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPicture()
    {
        return picture;
    }

    public void setPicture(String picture)
    {
        this.picture = picture;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.getId();
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.lastname);
        hash = 41 * hash + Objects.hashCode(this.birthdate);
        hash = 41 * hash + Objects.hashCode(this.gender);
        return hash;
    }

    public String getFullName()
    {
        return this.getName() + " " + this.getLastname();
    }

    @Override
    public HashMap toHashMap()
    {
        HashMap<String, String> params = new HashMap<>();
            
        if(this.getId()>0)
        {
            params.put("id", String.valueOf(this.getId()));
        }
    
        params.put("name", this.getName());
        params.put("lastname", this.getLastname());
        
        if(this.getGender() != null)
        {
            params.put("gender_id", String.valueOf(this.getGender().getId()));
        }
        
        params.put("country_id", String.valueOf(this.getLocation().getCountry().getId()));
        params.put("city", this.getLocation().getCity());
        params.put("telephone1", this.getTelephone1());
        params.put("telephone2", this.getTelephone2());
        params.put("birthdate", this.getBirthdate());
        
        return params;
    }
    
    public static Personal instantiateFromRequest(HttpServletRequest request)
    {
        return (Personal) getFactory().createEntityFromRequest(request);
    }
    
    @Override
    public boolean validate()
    {
        try
        {
            return ValidationUtils.validatePersonal(this);
        } 
        catch (Exception ex)
        {
            return false;
        }
    }
    
}
