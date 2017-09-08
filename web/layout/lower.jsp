        <footer>
            <p>&copy;2017 Fundació L'Esplai - Programa Enfoca't</p>
        </footer>
        <script>
            $(function(){
                
                var fadeOutAlert = function(){
                    $(".alert").fadeOut();
                };
                
                $(document).on("click", ".alert", fadeOutAlert);
                setInterval(fadeOutAlert, 10000);
                
                
                
            });
        </script>
    </body>
</html>
