<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%if(request.getParameter("experience-tags") != null){%>
        <p>Etiquetas de experiencia:</p>
        <ul>
            <%for(String tagtext : (String[]) request.getParameterValues("experience-tags")){%>
            <li><%=tagtext%></li>
            <%}%>
        </ul>
        <%}%>
        <%if(request.getParameter("education-tags") != null){%>
        <p>Etiquetas de educación:</p>
        <ul>
            <%for(String tagtext : (String[]) request.getParameterValues("education-tags")){%>
            <li><%=tagtext%></li>
            <%}%>
        </ul>
        <%}%>
        <%if(request.getParameter("otherinfo-tags") != null){%>
        <p>Etiquetas de otros:</p>
        <ul>
            <%for(String tagtext : (String[]) request.getParameterValues("otherinfo-tags")){%>
            <li><%=tagtext%></li>
            <%}%>
        </ul>
        <%}%>
        <h1>Próximamente...</h1>
        <a href="index.jsp">Volver</a>
    </body>
</html>
