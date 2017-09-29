/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.abstraction.EntityController;
import javax.servlet.annotation.WebServlet;
import model.factory.PersonalFactory;

/**
 *
 * @author mati
 */
@WebServlet(name = "personal", urlPatterns = {"/personal"})
public class PersonalData extends EntityController {

   {
        this.setEntityName("Personal");
        this.setView("personal-edit");
        this.setFactory(new PersonalFactory());
    }
}
