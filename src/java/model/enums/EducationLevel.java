package model.enums;

/**
 *
 * @author mati
 */
public class EducationLevel implements Comparable<EducationLevel> 
{
    private int id, value;
    private String name;

    
    public EducationLevel()
    {
        //NADA
    }
    
    public EducationLevel(int id, String name)
    {
        this.setId(id);
        this.setName(name);
    }
    
    public EducationLevel(int id, String name, int value)
    {
        this(id, name);
        this.setValue(value);
    }
    
    @Override
    public int compareTo(EducationLevel el) {
        return this.getValue() - el.getValue();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
