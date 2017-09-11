/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import helpers.RequestUtils;
import helpers.ViewUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Personal;

/**
 *
 * @author mati
 */
@WebServlet(name = "PersonalData", urlPatterns = {"/PersonalData"})
public class PersonalData extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try
        {
            //Comprobar si el formulario se ha enviado (coger token y comparar)
            
            //if(RequestUtils.getUserToken(request) == RequestUtils.getSessionUser(request).hashCode())
            //{
            //    System.out.println("User token verified success");
            //}
            //if(RequestUtils.getUserToken(request) == RequestUtils.getSessionUser(request).hashCode())
            //{
                //Personal personal = Personal.findBy("user_id", String.valueOf(user.getId())).get(0);
                    //-Actualizar registro de personal en la BD utilizando la id de sesión.
                    //-Atribuir a request un parámetro de notificación exitosa "Personal information successfully updated".
             
            //}
           //Coger datos de personal de la bd con id de sesión
            //Renderizar atributos como valor por defecto
            
            
            Personal personal = Personal.findById(RequestUtils.getSessionUser(request).getId());
     
            RequestUtils.redirect(request, response, "personal-edit");
            
        }
        catch(Exception ex)
        {
            ViewUtils.setNotificationError(request, "Ha habido un error: " + ex.getMessage());
            RequestUtils.redirect(request, response, "index");
            //rd = request.getRequestDispatcher("index.jsp");
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
