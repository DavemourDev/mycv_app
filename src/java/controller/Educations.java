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
import model.Education;

/**
 *
 * @author mati
 */
@WebServlet(name = "Educations", urlPatterns = {"/Educations"})
public class Educations extends HttpServlet {

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
        try
        {
            //Procesar atributos si hay form enviado
            String action = request.getParameter("_action");

            if(action != null)
            {
                switch(action)
                {
                    case "insert":
                        //insertar
                        if(this.insert(request))
                        {
                            ViewUtils.setNotificationSuccess(request, "Educación añadida con éxito.");
                        }
                        break;
                    case "edit":
                        //editar
                        if(this.update(request))
                        {
                            ViewUtils.setNotificationSuccess(request, "Educación editada con éxito.");
                        }
                        break;
                    case "delete":
                        //Borrar
                        if(this.delete(request))
                        {
                            ViewUtils.setNotificationSuccess(request, "Educación eliminada con éxito.");
                        }
                        break;
                    default:
                        //La acción no existe
                }
            }
        }
        catch(Exception ex)
        {
                ViewUtils.setNotificationError(request, "Ha ocurrido un error: "+ ex.getMessage());
        }
        RequestUtils.redirect(request, response, "education");
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
    private boolean insert(HttpServletRequest request) throws Exception
    {
        try
        {
            Education education = Education.instantiateFromRequest(request);
            if(ValidationUtils.validateEducation(education))
            {
                return education.insert();
            }
            else
            {
                throw new Exception("Educación no válida");
            }
        }
        catch(Exception ex)
        {
            throw ex;
        }
        
    }

    private boolean delete(HttpServletRequest request) throws Exception
    {
        try
        {
            Education education = Education.findById(RequestUtils.getInt(request, "id"));
            if(education.getUser_id() != RequestUtils.getSessionUserId(request))
            {
                throw new Exception("Operación no autorizada.");
            }
            else
            {
                return education.delete();
            }
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }
    
    private boolean update(HttpServletRequest request) throws Exception
    {
        try
        {
            Education education = Education.instantiateFromRequest(request);
            if(ValidationUtils.validateEducation(education))
            {
                return education.update();
            }
            else
            {
                throw new Exception("Educación no válida.");
            }
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }
}
