//Este script sirve para alertar al usuario si intenta salir de un formulario que estaba rellenando sin guardar.

$(function(){
    window.evitaMarxar=false;
            
    window.onbeforeunload = function(){
        if (window.evitaMarxar)
        {
            return "Si sales sin guardar tu datos los perderas.";
        }
    };

    $(document).on("click", "form *", function()
    {
        //Se activa cuando el usuario clica dentro del formulario al menos una vez
        
        window.evitaMarxar = true;
        //Desactiva este evento. Solamente nos interesa que se accione una vez.
        $(document).off("click", "form *");
    });


    //Asumiendo que queremos que esta conducta se produzca con todos los formularios de la página, podemos prescindir del id
    $('form').submit(function(e) {
        window.evitaMarxar=false;
    });
});
