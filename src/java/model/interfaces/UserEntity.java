package model.interfaces;

/**
 * Una entidad de usuario es como una entidad base, 
 * pero además contiene una asociación a un usuario.
 * 
 * Cualquier entidad atribuible a un usuario concreto es de este tipo.
 * 
 * @author David
 */
public abstract class UserEntity extends Entity
{
    public int user_id;
    
    public void setUser_id(int id)
    {
        this.user_id = id;
    }
    
    public int getUser_id()
    {
        return this.user_id;
    }
}
