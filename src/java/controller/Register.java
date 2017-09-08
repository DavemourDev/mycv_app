/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import helpers.DatabaseUtils;
import helpers.RequestUtils;
import helpers.ValidationUtils;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Personal;
import model.User;
import model.Location;
import model.enums.Gender;

/**
 *
 * @author mati
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet 
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher rd;
        
        try
        {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            //Luego añadimos los otros datos, vale? :)
            
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
                
            if(!ValidationUtils.isEmail(email))
            {
                throw new Exception("Formato de email erróneo.");
            }
            
            if(!ValidationUtils.stringLength(password, 6, 20))
            {
                throw new Exception("Longitud errónea de contraseña (debe tener entre 6 y 20 caracteres).");
            }
            if(!user.exists())
            {
                DatabaseUtils.startTransaction();
                
                if(user.register())
                {
                    try{
                        int id = User.findBy("email", email).get(0).getId();
                        //Personal personal = Personal.findBy("user_id", id).get(0);
                        
                        Personal personal = new Personal();
                        
                        personal.setUser_id(id);

                        personal.setName(request.getParameter("name"));

                        if(!ValidationUtils.stringLength(personal.getName(), 3, 255))
                        {
                            throw new Exception("Longitud errónea de nombre (debe tener entre 3 y 255 caracteres).");
                        }
                        
                        personal.setLastname(request.getParameter("lastname"));
                        if(!ValidationUtils.stringLength(personal.getLastname(), 3, 255))
                        {
                            throw new Exception("Longitud errónea de apellidos (debe tener entre 3 y 255 caracteres).");
                        }
                        
                        personal.setBirthdate(request.getParameter("birthdate"));

                        if(!ValidationUtils.isValidDate(personal.getBirthdate()))
                        {
                            throw new Exception("Fecha no válida.");
                        }
                        
                        personal.setGender(Gender.findById(Integer.parseInt(request.getParameter("gender"))));

                        personal.setLocation(Location.create(Integer.parseInt(request.getParameter("country")), request.getParameter("city")));
                        
                        //Comprobar si los datos son correctos y si no, lanzar una excepción.
                        
                        personal.insert();
                        
                        DatabaseUtils.commitTransaction();
                        
                        request.setAttribute("notification-success", "Success in user register!!!");
                    }    
                    catch(Exception ex)
                    {
                        DatabaseUtils.cancelTransaction();
                        request.setAttribute("notification-error", "Error in user registering...");
                    }
                }
                
                RequestUtils.redirect(request, response, "welcome");
            }
            else
            {
                request.setAttribute("notification-error", "User already exists...");
                RequestUtils.redirect(request, response, "welcome");
            }
        }
        catch(Exception ex)
        {
            RequestUtils.redirect(request, response, "welcome");
        }
        
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
