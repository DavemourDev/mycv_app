<%@page import="helpers.ViewUtils"%>

        </div>
        <footer>
            <p>&copy;2017 Fundaci� L'Esplai - Programa Enfoca't</p>
        </footer>

<!--Aqu� van todas las cargas de scripts externos-->
        
        <!--JQuery-->
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
       <!--Script bootstrap-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        
<!--Script principal de nuestra p�gina-->
        <script src="/java_servlet/assets/js/principal.js" type="text/javascript"></script>
<!--Cargar aqu� todos los scripts usando el helper-->
        <%=ViewUtils.embedScripts(request)%>
    </body>
</html>
