package controller.abstraction;

import helpers.RequestUtils;
import helpers.ViewUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class Controller extends HttpServlet
{
    private String view;
    private HttpServletRequest request;
    private HttpServletResponse response;
   
    /**
     * Procesa una petición http y genera y envía una respuesta.
     * 
     * El núcleo de acción de un controlador se encuentra aquí.
     * 
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected abstract void handle() throws ServletException, IOException;
    
    public HttpServletRequest getRequest()
    {
        return this.request;
    }
    
    public void setRequest(HttpServletRequest request)
    {
        this.request = request;
    }
    
    public HttpServletResponse getResponse()
    {
        return this.response;
    }
    
    public void setResponse(HttpServletResponse response)
    {
        this.response = response;
    }
    
    
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
            throws ServletException, IOException
    {
        this.setRequest(request);
        this.setResponse(response);
        handle();
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
            throws ServletException, IOException
    {
        this.setRequest(request);
        this.setResponse(response);
        handle();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Controlador.";
    }
    
        public void setSuccessNotification(String message)
    {
        ViewUtils.setNotificationSuccess(this.getRequest(), message);
    }
    
    public void setWarningNotification(String message)
    {
        ViewUtils.setNotificationWarning(this.getRequest(), message);
    }
    
    public void setErrorNotification(String message)
    {
        ViewUtils.setNotificationError(this.getRequest(), message);
    }

    public String getView()
    {
        return this.view;
    }
    
    public void setView(String view)
    {
        this.view = view;
    }

    public void redirect() throws ServletException, IOException
    {
        RequestUtils.redirect(this.getRequest(), this.getResponse(), this.getView());
    }
}
