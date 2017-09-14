 $(function(){
     //Muestra el formulario o lo oculta
     $(document).on("click", ".new-item-btn", function(){
        $("#new-item").slideToggle(); 
     });
     
     $(document).on("click", ".btn-edit-item", function(){
         //Muestra form de edicion
         let idEditedItem = $(this).first().attr("href");
         $(".form-hidden").slideUp();
         $(idEditedItem).slideDown();
     });
     
 });