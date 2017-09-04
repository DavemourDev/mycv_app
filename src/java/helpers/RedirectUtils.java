/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mati
 */
public class RedirectUtils {

    private static final String NOT_LOGGED_URL = "welcome";
    
    private RedirectUtils(){}
    
    /**
     * Redirige a una página si existe una sesión, de lo contrario, a la establecida...
     * 
     */
    public static void redirect(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException
    {
        if(request.getSession().getAttribute("user") != null)
        {
            request.getRequestDispatcher(String.format("%s.jsp", url)).forward(request, response);
        }
        else
        {
            redirectToNotLogged(request, response);
        }
    }
    
    public static void redirectToNotLogged(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher(String.format("%s.jsp", NOT_LOGGED_URL)).forward(request, response);
    }
}
