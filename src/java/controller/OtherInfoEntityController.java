/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.abstraction.EntityController;
import javax.servlet.annotation.WebServlet;
import model.factory.OtherInfoFactory;

/**
 *
 * @author David
 */
@WebServlet(name = "otherinfo", urlPatterns = {"/otherinfo"})
public class OtherInfoEntityController extends EntityController 
{
    {
        this.setEntityName("otra información");
        this.setView("other-info");
        this.setFactory(new OtherInfoFactory());
    }


}
