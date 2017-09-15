//Maneja la conducta del panel de control
$(function(){
    
    //Definición de cosas
    var activeControlPanelSection= "#home";
    var showControlPanelSection = function(section)
    {
        //Oculta todas las secciones y muestra la actual
        $(".panel-section:not("+ section +")").slideUp();
        $(section).slideDown();
        
    };
    
    var panelSectionSwitch = function()
    {
        let section = $(this).attr("href");
        
        if(section !== activeControlPanelSection)
        {
            $(".nav-tabs-hidden").fadeIn();
            
            //Si no es la sección activa
            activeControlPanelSection = section;
            
            showControlPanelSection(activeControlPanelSection);
            
            $("#control-panel>li").removeClass("active");
            $("#control-panel>li>a[href='"+section+"']").parent().addClass("active");
            
        }
    };
    
  //  $(document).on("click", "#control-panel > li > a", panelSectionSwitch);
    $(document).on("click", ".panel-link", panelSectionSwitch);
    
    //Código a ejecutar
    showControlPanelSection(activeControlPanelSection);
    
});