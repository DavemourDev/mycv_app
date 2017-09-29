package controller;

import controller.abstraction.EntityController;
import javax.servlet.annotation.WebServlet;
import model.factory.ExperienceFactory;


/**
 *
 * @author David
 */
@WebServlet(name = "experience", urlPatterns = {"/experience"})
public class ExperienceEntityController extends EntityController 
{
    {
        this.setEntityName("Experience");
        this.setView("experience");
        this.setFactory(new ExperienceFactory());
    }

    
}
