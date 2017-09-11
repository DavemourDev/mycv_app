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

/**
 *
 * @author mati
 */
@WebServlet(name = "Experience", urlPatterns = {"/Experience"})
public class Experience extends HttpServlet {

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
            throws ServletException, IOException 
    {
        //Procesar atributos si hay form enviado
        String action = request.getParameter("_action");
        
        if(action != null)
        {
            switch(action)
            {
                case "insert":
                    //insertar
                    this.insert(request);
                    
                    ViewUtils.setNotificationSuccess(request, "Insertar");
                    break;
                case "edit":
                    //editar
                    ViewUtils.setNotificationSuccess(request, "Editar");
                    break;
                case "delete":
                    //Borrar
                    ViewUtils.setNotificationSuccess(request, "Borrar: "+ request.getParameter("id"));
                default:
                    //La acción no existe
            }
        }
        
        
        RequestUtils.redirect(request, response, "experience");
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

    /**
     * Inserta un nuevo item de experiencia a la bd si los datos son correctos...
     */
    private boolean insert(HttpServletRequest request)
    {
        return true;
    }

}
