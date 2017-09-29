package controller;

import controller.abstraction.EntityController;
import helpers.RequestUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import model.Personal;
import model.User;
import model.factory.UserFactory;

/**
 *
 * Este controlador de entidades es el que controla el registro y logueo de usuarios,
 * y el punto de entrada a la aplicación.
 * 
 * @author David
 */

@WebServlet(name = "Home", urlPatterns = {"/home"})
public class HomeController extends EntityController
{
    {
        this.setEntityName("User");
        this.setView("index");
        this.setFactory(new UserFactory());
    }
    
    @Override
    protected void handle() throws ServletException, IOException
    {
        
        try
        {
            String action = this.getRequest().getParameter("_action");

            if(action != null)
            {
                switch(action)
                {
                    case "login":
                        if(!this.login())
                        {
                            this.setWarningNotification("Credenciales de inicio de sesión no válidas.");
                        }
                        break;
                        
                    case "register":
                        if(this.register())
                        {
                            this.setSuccessNotification("Registro de usuario exitoso.");
                        }
                        break;
                        
                    case "logout":
                        this.logout();
                        break;
                    
                    default:
                        //No hacer nada
                        break;
                }
            }
        }
        catch(Exception ex)
        {
            this.setErrorNotification("Ha ocurrido un error: "+ ex.getMessage());
        }
        this.redirect();
    }
    
    /**
     * Comprueba el email y la contraseña introducidos y si corresponden ambos a un usuario, inicia una sesión con él.
     * 
     * @return 
     */
    public boolean login()
    {
        try
        {
            User user = User.instantiateFromRequest(this.getRequest());
            
            if(user.authentication())
            {
                System.out.println("Usuario autentificado: " +  user.getEmail());
                user = User.withEmail(user.getEmail());
                
                System.out.println("Usuario para crear sesion: " + user.getId());            
                RequestUtils.createUserSession(this.getRequest(), user);
     
                
                return true;
            }
            else
            {
                throw new Exception("Email/Contraseña incorrectos.");
            }
        } 
        catch (Exception ex)
        {
            return false;
        }
        
    }
    
    public boolean register()
    {
        boolean registered;
        
        if(this.insert())
        {
            User user = User.withEmail(this.getRequest().getParameter("email"));
            
            System.out.println("ID:"+user.getId());
            
            Personal personal = Personal.instantiateFromRequest(this.getRequest());
            
            personal.setId(user.getId());
            
            try
            {
                registered = personal.insertOrUpdate();
            } 
            catch (Exception ex)
            {
                registered = false;
            }
        }
        else
        {
            registered = false;
        }
        
        return registered;

    }
    
    public boolean logout()
    {
        RequestUtils.quitUserSession(this.getRequest());
        return true;
    }
}
