/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mati
 */
public class Location 
{
    private Country country;
    private String city;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public static Location create(String country_id, String city)
    {
        return create(Integer.parseInt(country_id), city);
    }
    
    public static Location create(int country_id, String city)
    {
        Location location = new Location();
        location.setCountry(Country.findById(country_id));
        location.setCity(city);
        
        return location;
    }
}
