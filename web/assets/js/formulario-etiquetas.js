//Incluir en todos los formularios que usen campos para etiquetas

    //Métodos extra para arrays:
    Array.prototype.removeString = function (str) {
        let indexOfItem = this.indexOf(str);
        
        if (indexOfItem > -1)
        {
            this.splice(indexOfItem, 1);
        }
    };

    //inicialización de cosas
    var tagInputs = [];

    var updateTagList = function () {

        let tagString = "";
        let numTags = this.tagArray.length;
        let i = 0;

        if (numTags) {
            while (true) {
                tagString += this.tagArray[i++];

                if (i === numTags) {
                    //Recorrido terminado. No hay siguiente elemento, así que no hay que añadir espacio y salimos del bucle.
                    break;
                }
                //Recorrido no terminado aún. Agrega un espacio para separar el elemento actual del siguiente
                tagString += " ";
            }
        }
        this.tagsField.val(tagString);

        console.log(this.namespace + ": Lista de etiquetas actualizada.");

    };

    //Añade la etiqueta si se cumplen las condiciones
    var addTag = function () 
    {
        if (this.tagArray.length >= this.maxTags) 
        {
            console.log("No se pueden añadir más etiquetas");
        }
        else {
            let textTag = this.tagEditField.val();

            if (textTag.match(/^[a-zA-Z][a-zA-Z\-\_\d]*$/) && this.tagArray.indexOf(textTag) < 0) {
                this.tagArray.push(textTag);
                this.renderTag(textTag);
                this.tagEditField.val("");
                this.updateTagList();
                console.log(this.namespace + ": Etiqueta creada: " + textTag);
            }
            else {
                alert("Una tag no puede contener espacios y debe comenzar por una letra.");
            }
            
        }

    };

    //Renderiza una etiqueta
    var renderTag = function(text)
    {
        this.tagList.append("<span class='tag tag" + this.namespace + "'><span class='tag-text'>" + text + "</span> <i class='fa fa-remove remove-tag'></i></span>");
    };

    var removeTag = function (caller) 
    {
        let tag = caller.parent();

        //console.log(tag);

        let tagText = tag.children(".tag-text").text();

        //console.log(tagText);

        this.tagArray.removeString(tagText);
        tag.remove();
        this.updateTagList();

        console.log(this.namespace + ": Etiqueta eliminada: " + tagText);
    };

    //Inicializa las etiquetas del objeto en la vista.
    var initializeTags = function()
    {
        let scope = this;

        this.tagArray.forEach(function(tag)
        {
            scope.renderTag(tag);
        });

        this.updateTagList();
    };

    //Definición del constructor de TagInput (Definiciones en cada instancia individual)
    var TagInput = function (namespace, initialTags = [], maxTags = 5) 
    {
        this.namespace = namespace;//Se añade después de cada id para que js los distinga
        this.tagList = $("#tag-list" + this.namespace);
        this.tagEditField = $("#current-tag" + this.namespace);
        this.tagDataList = $("#datalist" + this.namespace);
        this.tagsField = $("#tags" + this.namespace);
        this.addTagButton = $("#add-tag-btn" + this.namespace);
        this.tagArray = initialTags;
        this.maxTags = maxTags;
        this.initializeTags();

        //Necesitamos guardar una referencia del objeto actual para poder acceder a él desde las callbacks de eventos,
        //ya que en su contexto 'this' toma el valor del elemento causante de la llamada.
        let scopeTagInput = this;

        console.log("Nueva instancia de TagInput creada: " + this.namespace);

        //Asignar eventos
        $(document).on("click", "#add-tag-btn" + this.namespace, function () {
            scopeTagInput.addTag();
        });

        $(document).on("click", ".tag" + this.namespace + ">.remove-tag", function () {
            console.log("This: ");
            console.log(this);
            scopeTagInput.removeTag($(this));
        });
    };

    //Asignar funciones al prototipo de TagInput (Definiciones que afectan a todos los objetos creados con el constructor TagInput)
    TagInput.prototype = {
        initializeTags: initializeTags,
        updateTagList: updateTagList,
        renderTag: renderTag,
        addTag: addTag,
        removeTag: removeTag
    };

//Esto debe hacerlo la página
  //  tagInputs.push(new TagInput("Exp", ['hosteleria', 'copas']));
  // tagInputs.push(new TagInput("Exp-1", ['quimica', 'analisis-inorganico', 'espectrometria-de-masas']));
