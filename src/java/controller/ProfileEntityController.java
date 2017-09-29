package controller;

import controller.abstraction.EntityController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import model.factory.EducationFactory;

/**
 *
 * @author David
 */
@WebServlet(name = "profile", urlPatterns = {"/profile"})
public class ProfileEntityController extends EntityController
{
    {
        this.setEntityName("Profile");
        this.setView("profile-viewer");
        this.setFactory(new EducationFactory());
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
                    case "insert":
                        
                        if(this.insert())
                        {
                            this.setSuccessNotification("Nuevo perfil creado.");
                        }
                        break;
                        
                    case "edit":
                        
                        if(this.update())
                        {
                            this.setSuccessNotification("Perfil editado.");
                        }
                        break;
                        
                    case "delete":
                        if(this.delete())
                        {
                            this.setSuccessNotification("Perfil eliminado.");
                            this.setView("index");
                        }
                        break;
                        
                    case "view":
                        
                        this.view();
                        break;
                        
                    case "download":
                        
                        this.download();
                        break;
                        
                    default:
                        //No se ha seleccionado acción.
                        //Panel de control.
                        this.setView("index");
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

    
    public boolean download()
    {
        //POR IMPLEMENTAR
        return true;
    }
    
    /**
     * Envía una petición a profile-viewer con las características del perfil.
     * Acción por defecto.
     * @return 
     */
    public boolean view()
    {
        this.setView("profile-viewer");
        //POR IMPLEMENTAR
        return true;
    }
}
