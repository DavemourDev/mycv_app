package model;

import helpers.DatabaseUtils;
import helpers.ValidationUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import model.factory.UserFactory;
import model.abstraction.Entity;
import model.factory.abstraction.EntityFactory;

/**
 *
 * @author David
 */
@SuppressWarnings("EqualsAndHashcode")
public class User extends Entity
{
    protected static EntityFactory factory = new UserFactory();
    
    public static EntityFactory getFactory()
    {
        return User.factory;
    }
    
    private String email, password;
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Personal getPersonal()
    {
        return Personal.withId(this.getId());
    }
    
    /**
     * Obtiene una lista con todas las experiencias de este usuario.
     * @return 
     */
    public List<Experience> getExperiences()
    {
        return Experience.whereUserId(this.getId());
    }
    
    /**
     * Obtiene una lista con todas las educaciones de este usuario.
     * @return 
     */
    public List<Education> getEducations()
    {
        return Education.whereUserId(this.getId());
    }
    
    /**
     * Obtiene una lista con todas las destrezas en idiomas de este usuario.
     * @return 
     */
    public List<LanguageSkill> getLanguageSkills()
    {
        return LanguageSkill.whereUserId(this.getId());
    }
    
    
    /**
     * Obtiene una lista con todas las otras informaciones de este usuario.
     * @return 
     */
    public List<OtherInfo> getOtherInfo()
    {
        return OtherInfo.whereUserId(this.getId());
    }
    
    /**
     * Obtiene una lista con todas las etiquetas de experiencia diferentes
     * para el usuario.
     * @return 
     */
    public List<Tag> getExperienceTags()
    {
        return Tag.findOfType(this.getId(), "experience");
    }
    
    /**
     * Obtiene una lista con todas las etiquetas de educación diferentes
     * para el usuario.
     * @return 
     */
    public List<Tag> getEducationTags()
    {
        return Tag.findOfType(this.getId(), "education");
    }
    
    /**
     * Obtiene una lista con todas las etiquetas de otros diferentes
     * para el usuario.
     * @return 
     */
    public List<Tag> getOtherInfoTags()
    {
        return Tag.findOfType(this.getId(), "otherinfo");
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.email);
        hash = 13 * hash + Objects.hashCode(this.password);
        return hash;
    }

    public static User withId(int id)
    {
        return (User) getFactory().findById(id);
    }

    public static User oneWhere(String attr, String value)
    {
        return (User) getFactory().findOneBy(attr, value);
    }
    
    public static User withEmail(String email)
    {
        return User.oneWhere("email", email);
    }
    
    public static User instantiateFromRequest(HttpServletRequest request)
    {
        System.out.println("crear usuario por peticion");
        return (User) getFactory().createEntityFromRequest(request);
    }
    
    /**
     * Comprueba si existe un usuario con el email de la instancia y su contraseña en la base de datos.
     * 
     * Se recomienda su uso para el login de usuario.
     * 
     * NOTA: debe adaptarse a lo nuevo. quizá no debería estar aquí...
     * 
     * @return true si en la tabla `user` existe un registro con el mismo email y contraseña que el objeto que llama. De lo contrario, false.
     */
    public boolean authentication() throws Exception
    {
        System.out.println("Llama a authentication");
        return DatabaseUtils.getUserRegister(this.getEmail(), this.getPassword()).next();
    }
    
    /**
     * Comprueba si existe un usuario con el mismo email de la instancia que llama en la base de datos.
     * 
     * Se recomienda su uso para el registro de usuario.
     * 
     * @return
     */
    public boolean exists()
    {
        System.out.println("Llama a Exists");
        
        return User.withEmail(this.getEmail()) != null;
    }
  
    @Override
    public HashMap toHashMap()
    {
        HashMap params = new HashMap();
        
        if(this.getId() > 0)
        {
            params.put("id", this.getId());
        }
        
        params.put("email", this.getEmail());
        params.put("password", this.getPassword());
        
        return params;        
    }

    @Override
    public boolean validate()
    {
        try
        {
            return ValidationUtils.validateUser(this);
        } 
        catch (Exception ex)
        {
            return false;
        }
    }
 
    
}
