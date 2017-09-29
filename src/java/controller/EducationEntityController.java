package controller;

import controller.abstraction.EntityController;
import javax.servlet.annotation.WebServlet;
import model.factory.EducationFactory;

/**
 *
 * @author David
 */
@WebServlet(name = "education", urlPatterns = {"/education"})
public class EducationEntityController extends EntityController 
{
    {
        this.setEntityName("Education");
        this.setView("education");
        this.setFactory(new EducationFactory());
    }
    
}
