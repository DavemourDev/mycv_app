package model.enums;

import config.Config;
import core.Database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mati
 */
public class Gender {

    private int id;
    private String name;
    
    public Gender() 
    {
    //NADA
    }

    public Gender(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public static List<Gender> findAll() {
        List<Gender> list = new ArrayList<>();

        try {
            ResultSet rs = Database.getInstance().query("select * from `gender`");

            while (rs.next()) {
                Gender gender = new Gender(rs.getInt("id"), rs.getString(String.format("name_%s", Config.LANGUAGE)));
                list.add(gender);
            }
        } catch (Exception ex) {
            System.err.println("Error de conexión con la base de datos.");
        }

        return list;
    }

    public static Gender findById(int id) {
        Gender gender = null;

        try {
            ResultSet rs = Database.getInstance().query("select * from `country` where `id`='" + id + "'");

            if (rs.next()) {
                gender = new Gender(rs.getInt("id"), rs.getString(String.format("name_%s", Config.LANGUAGE)));
            }
        } catch (Exception ex) {
            System.err.println("Error de conexión con la base de datos.");
        }

        return gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return this.getName();
    }
    
}
