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
@WebServlet(name = "Profiles", urlPatterns = {"/Profiles"})
public class Profiles extends HttpServlet {

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
        
        
        String action = request.getParameter("_action");
        String pageUrl = "";
        
        try
        {
            if(action != null)
            {
                switch(action)
                {
                    case "insert":
                        this.insert(request);
                        break;
                    case "edit":
                        this.update(request);
                        break;
                    case "delete":
                        this.delete(request);
                        break;
                    case "view":
                        this.view(request);
                        break;
                    case "download":
                        this.download(request);
                        break;
                    default:
                        //Acción no existe
                }
            }
        }
        catch(Exception ex)
        {
            ViewUtils.setNotificationError(request, "Error: " + ex.getMessage());
        }
        
        RequestUtils.redirect(request, response, pageUrl);
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

    public boolean insert(HttpServletRequest request)
    {
        return true;
    }

    public boolean update(HttpServletRequest request)
    {
        return true;
    }
    
    public boolean delete(HttpServletRequest request)
    {
        return true;
    }
    
    public boolean view(HttpServletRequest request)
    {
        return true;
    }
    
    public boolean download(HttpServletRequest request)
    {
        return true;
    }
    
    
    
}
