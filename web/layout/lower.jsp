        <footer>
            <p>&copy;2017 Fundaci� L'Esplai - Programa Enfoca't</p>
        </footer>
        <script>
            $(function(){
                
                var fadeOutAlert = function(){
                    $(".alert").fadeOut();
                };
                
                $(document).on("click", ".alert", fadeOutAlert);
                setInterval(fadeOutAlert, 10000);
                
                var newItemFormToggle = function(){
                    $(".nuevoItem").children("div").click(function(){
                        $("form").slideToggle();
                    });
                };
                
            });
        </script>
    </body>
</html>
