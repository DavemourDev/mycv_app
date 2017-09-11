//Este script sirve para alertar al usuario si intenta salir de un formulario que estaba rellenando sin guardar.

$(function(){
    window.evitaMarxar=true;
            
    window.onbeforeunload = function(){
        if (window.evitaMarxar)
        {
            return "Si sales sin guardar tu datos los perderas.";
        }
    };

    //Asumiendo que queremos que esta conducta se produzca con todos los formularios de la página, podemos prescindir del id
    $('form').submit(function(e) {
        window.evitaMarxar=false;
    });
});
