/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import helpers.RequestUtils;
import helpers.ValidationUtils;
import helpers.ViewUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Personal;
import model.User;

/**
 *
 * @author mati
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try
        {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            
            if(ValidationUtils.validateUser(user))
            {
                if(!user.exists() && user.register())
                {
                    Personal personal = Personal.instantiateFromRequest(request, User.findBy("email", email).get(0).getId());

                    if(ValidationUtils.validatePersonal(personal) && personal.insert())
                    {
                        System.out.println("Personal insertado");
                        //Info personal actualizada
                        ViewUtils.setNotificationSuccess(request, "Success in user registering!!!");
                    }
                    else
                    {
                        System.out.println("Personal NO insertado");
                    }
                }
                else
                {
                    throw new Exception("El email introducido ya existe...");
                } 
            }
            
        }
        catch(Exception ex)
        {
            ViewUtils.setNotificationError(request, "Error de registro de usuario: " + ex.getMessage());
        }

        RequestUtils.redirect(request, response, "welcome");
    }

            
            
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
