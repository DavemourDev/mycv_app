$(function(){

//Este script se carga siempre

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