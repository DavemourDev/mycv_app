package model.interfaces;

/**
 * Una entidad de usuario es como una entidad base, 
 * pero además contiene una asociación a un usuario.
 * 
 * Cualquier entidad atribuible a un usuario concreto es de este tipo.
 * 
 * @author David
 */
public interface UserEntity extends Entity
{
    public static final String TABLE_NAME = "userentity";
    
    public void setUser_id(int id);
    public int getUser_id();
}
