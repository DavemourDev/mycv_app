package controller;

import controller.abstraction.EntityController;
import javax.servlet.annotation.WebServlet;
import model.factory.LanguageSkillFactory;

/**
 *
 * @author David
 */
@WebServlet(name = "languages", urlPatterns = {"/languages"})
public class LanguageSkillEntityController extends EntityController 
{
    {
        this.setEntityName("Idioma");
        this.setView("languages");
        this.setFactory(new LanguageSkillFactory());
    }
}
