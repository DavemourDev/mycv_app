/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Country;
import model.EducationLevel;
import model.Language;
import model.LanguageLevel;
import model.Sector;
import model.Tag;
import model.User;

/**
 *
 * @author mati
 */
public class RequestUtils {

    private static final String NOT_LOGGED_URL = "welcome";

    public static int getSessionUserId(HttpServletRequest request)
    {
       return userSessionExists(request) ? getSessionUser(request).getId() : 0; 
    }
    
    private RequestUtils(){}
    
    /**
     * Redirige a una página JSP.
     * 
     * Si no existe una sesión de usuario activa, se llamaráa redirectToNotLogged.
     * 
     * Se aconseja que este método solamente sea llamado desde un servlet.
     */
    public static void redirect(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException
    {
        if(userSessionExists(request))
        {
            request.getRequestDispatcher(String.format("%s.jsp", url)).forward(request, response);
        }
        else
        {
            redirectToNotLogged(request, response);
        }
    }
    
    /**
     * Este método es llamado si al llamar a redirect no existe una sesión de usuario activa.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public static void redirectToNotLogged(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher(String.format("%s.jsp", NOT_LOGGED_URL)).forward(request, response);
    }
    
    /**
     * Permite acceder a los datos del usuario de la sesión actual.
     * @param request 
     * @return Referencia al objeto de usuario de sesión actual.
     */
    public static User getSessionUser(HttpServletRequest request)
    {
        return (User) request.getSession().getAttribute("user");
    }
    
    /**
     * Comprueba si existe una sesión de usuario activa.
     * @param request
     * @return True si existe un usuario de sesión. De lo contrario, false.
     */
    public static boolean userSessionExists(HttpServletRequest request)
    {
        return request.getSession().getAttribute("user") != null;
    }
    
    /**
     * Elimina el usuario de sesión actual.
     * @param request 
     */
    public static void quitUserSession(HttpServletRequest request)
    {
        request.getSession().removeAttribute("user");
    }
    
    /**
     * Obtiene la token de usuario de una petición.
     * 
     * Laa token de usuario es usada para evitar problemas relacionados con 
     * robo de sesión. El valor inicialmente se genera de la instancia de
     * usuario de la sesión, con lo cual cualquier tipo de envío de datos
     * entre páginas en una sesión debe tener una correspondencia entre 
     * el atributo u-token y el hashcode del usuario.
     * 
     * @param request Objeto request de la petición
     * @return 
     */
    public static int getUserToken(HttpServletRequest request)
    {
        int utoken;
        
        try
        {
            utoken = Integer.parseInt(request.getParameter("u-token"));
        }
        catch(Exception ex)
        {
            //Seguro que no coincide
            utoken = 0;
        }
        
        return utoken;
    }
    
    public static boolean isNullParam(HttpServletRequest request, String param)
    {
        return request.getParameter(param) == null;
    }
    
    public static int getInt(HttpServletRequest request, String param)
    {
        return isNullParam(request, param) ? 0 : Integer.parseInt(getString(request, param));
    }
    
    public static String getString(HttpServletRequest request, String param)
    {
        return request.getParameter(param);
    }
    
    
    public static List<Tag> getExpTags(HttpServletRequest request)
    {
        return Tag.findAllOfType(RequestUtils.getSessionUserId(request), "experience");
    }
    
    public static List<Tag> getEduTags(HttpServletRequest request)
    {
        return Tag.findAllOfType(RequestUtils.getSessionUserId(request), "education");
    }
    
    public static List<Tag> getOtherTags(HttpServletRequest request)
    {
        return Tag.findAllOfType(RequestUtils.getSessionUserId(request), "other");
    }
    
    /**
     * Almacena en sesión la lista de países de la aplicación si no lo ha hecho y la devuelve.
     * Esto presenta la ventaja de reducir notablemente el acceso a la base de datos por parte de la aplicación, haciéndola más eficiente.
     * @param request
     * @return Lista completa de países de la BD
     */
    public static List<Country> getCountries(HttpServletRequest request)
    {
        if(request.getSession().getAttribute("countries") == null  || ((List<Country>) request.getSession().getAttribute("countries")).isEmpty())
        {
            request.getSession().setAttribute("countries", Country.findAll());
        }
        return (List<Country>) request.getSession().getAttribute("countries");
    }
    
    /**
     * Almacena en sesión la lista de idiomas de la aplicación si no lo ha hecho y la devuelve.
     * Esto presenta la ventaja de reducir notablemente el acceso a la base de datos por parte de la aplicación, haciéndola más eficiente.
     * @param request
     * @return Lista completa de idiomas de la BD
     */
    public static List<Language> getLanguages(HttpServletRequest request)
    {
        if(request.getSession().getAttribute("languages") == null || ((List<Language>) request.getSession().getAttribute("languages")).isEmpty())
        {
            request.getSession().setAttribute("languages", Language.findAll());
        }
        return (List<Language>) request.getSession().getAttribute("languages");
    }
    
    public static List<LanguageLevel> getLanguageLevelsPartial(HttpServletRequest request)
    {
        if(request.getSession().getAttribute("languageLevelsPartial") == null || ((List<LanguageLevel>) request.getSession().getAttribute("languageLevelsPartial")).isEmpty())
        {
            request.getSession().setAttribute("languageLevelsPartial", LanguageLevel.findAll());
        }
        return (List<LanguageLevel>) request.getSession().getAttribute("languageLevelsPartial");
    }
    
    /**
     * Almacena en sesión la lista de sectores de la aplicación si no lo ha hecho y la devuelve.
     * Esto presenta la ventaja de reducir notablemente el acceso a la base de datos por parte de la aplicación, haciéndola más eficiente.
     * @param request
     * @return Lista completa de sectores de la BD
     */
    public static List<Sector> getSectors(HttpServletRequest request)
    {
        if(request.getSession().getAttribute("sectors") == null || ((List<Sector>) request.getSession().getAttribute("sectors")).isEmpty())
        {
            request.getSession().setAttribute("sectors", Sector.findAll());
        }
        return (List<Sector>) request.getSession().getAttribute("sectors");
    }
    
    public static List<EducationLevel> getEducationLevels(HttpServletRequest request)
    {
        if(request.getSession().getAttribute("educationLevels") == null || ((List<EducationLevel>) request.getSession().getAttribute("educationLevels")).isEmpty())
        {
            request.getSession().setAttribute("educationLevels", EducationLevel.findAll());
        }
        return (List<EducationLevel>) request.getSession().getAttribute("educationLevels");
    }
    
}
