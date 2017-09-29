package controller.abstraction;

import helpers.RequestUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import model.OtherInfo;
import model.factory.abstraction.EntityFactory;
import model.abstraction.Entity;
import model.abstraction.UserEntity;

public abstract class EntityController extends Controller
{
    private String entityName;
    private EntityFactory factory;
    
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
                            this.setSuccessNotification("Ítem de " + this.getEntityName() + " añadido con éxito.");
                        }
                        else
                        {
                            this.setWarningNotification("No se pudo insertar " + this.getEntityName() + ".");
                        }
                        break;
                        
                    case "edit":
                        
                        if(this.update())
                        {
                            this.setSuccessNotification("Ítem de " + this.getEntityName() + " editado con éxito.");
                        }
                        else
                        {
                            this.setWarningNotification("No se pudo editar " + this.getEntityName() + ".");
                        }
                        break;
                        
                    case "delete":
                        if(this.delete())
                        {
                            this.setSuccessNotification("Ítem de " + this.getEntityName() + " eliminado con éxito.");
                        }
                        else
                        {
                            this.setWarningNotification("No se pudo borrar " + this.getEntityName() + ".");
                        }
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
        RequestUtils.redirect(this.getRequest(), this.getResponse(), this.getView());
    }


    protected boolean insert()
    {
        try
        {
            Entity item = this.getFactory().createEntityFromRequest(this.getRequest());
            

            if(item.validate())
            {
                            
                System.out.println("Ítem valido: " + ((OtherInfo) item).getTitle());
            
                
                return item.insert();
            }
            else
            {
                this.setWarningNotification("Los datos enviados no son válidos.");
            }
        }
        catch(Exception ex)
        {
            this.setErrorNotification("Ha ocurrido un error en la operación de inserción.");
        }
        
        return false;
    }

    protected boolean delete()
    {
        try
        {
            UserEntity item = (UserEntity) this.getFactory().findById(RequestUtils.getInt(this.getRequest(), "id"));

            if(item.getUser_id() != RequestUtils.getSessionUserId(this.getRequest()))
            {
                this.setWarningNotification("Operación no autorizada...");
            }
            
            return item.delete();
            
        }
        catch(Exception ex)
        {
            this.setErrorNotification("Ha ocurrido un error en la operación de borrado.");
            
        }
        
        return false;
    }
    
    protected boolean update()
    {
        try
        {
            Entity item = this.getFactory().createEntityFromRequest(this.getRequest());
            
            if(item.validate())
            {
                return item.update();
            }
            else
            {
                this.setWarningNotification("Los datos enviados no son válidos.");
            }
        }
        catch(Exception ex)
        {
            this.setErrorNotification("Ha ocurrido un error en la operación de edición.");
        }
        
        return false;
    }
    
    public String getEntityName()
    {
        return entityName;
    }

    public void setEntityName(String entityName)
    {
        this.entityName = entityName;
    }
    
    public EntityFactory getFactory()
    {
        return factory;
    }

    public void setFactory(EntityFactory factory)
    {
        this.factory = factory;
    }
    
}
