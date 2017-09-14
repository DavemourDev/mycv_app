
//Incluir en todos los formularios que usen campos para etiquetas
$(function () {

    //Métodos extra para arrays:
    Array.prototype.removeString = function (str) {
        let indexOfItem = this.indexOf(str);
        if (indexOfItem > -1)
            this.splice(indexOfItem, 1);
    };

    //inicialización de cosas
    var scopeTagInput;

    var updateTagList = function ()
    {
        let tagString = "";
        let numTags = scopeTagInput.tagArray.length;
        let i = 0;

        if (numTags)
        {
            while (true)

            {
                tagString += scopeTagInput.tagArray[i++];

                if (i == numTags)
                {
                    break;
                }

                tagString += " ";
            }
        }
        scopeTagInput.tagsField.val(tagString);

        console.log(scopeTagInput.namespace + ": Lista de etiquetas actualizada.");

    };

    var addTag = function ()
    {
        console.log(scopeTagInput);

        if (scopeTagInput.tagArray.length >= scopeTagInput.maxTags)
        {
            console.log("No se pueden añadir más etiquetas");
        } 
        else
        {
            let textTag = scopeTagInput.tagEditField.val();

            if(textTag.match(/^[a-zA-Z][a-zA-Z\-\_\d]*$/) && scopeTagInput.tagArray.indexOf(textTag) < 0)
            {
                scopeTagInput.tagList.append("<span class='tag tag" + scopeTagInput.namespace + "'><span class='tag-text'>" + textTag + "</span> <i class='fa fa-remove remove-tag'></i></span>");
                scopeTagInput.tagEditField.val("");
                scopeTagInput.tagArray.push(textTag);
                scopeTagInput.updateTagList();
            }
            else
            {
                alert("Una tag no puede contener espacios y debe comenzar por una letra.");
            }
            console.log(this.namespace + ": Etiqueta creada: " + textTag);
        }

    };

    var removeTag = function (caller)
    {
        let tag = caller.parent();

        //console.log(tag);

        let tagText = tag.children(".tag-text").text();

        //console.log(tagText);

        scopeTagInput.tagArray.removeString(tagText);
        tag.remove();
        scopeTagInput.updateTagList();

        console.log(scopeTagInput.namespace + ": Etiqueta eliminada: " + tagText);
    };

    //Definición del constructor de TagInput (Definiciones en cada instancia individual)
    var TagInput = function (namespace)
    {
        this.namespace = namespace;
        this.tagList = $("#tag-list" + this.namespace);
        this.tagEditField = $("#current-tag" + this.namespace);
        this.tagDataList = $("#datalist" + this.namespace);
        this.tagsField = $("#tags" + this.namespace);
        this.addTagButton = $("#add-tag-btn" + this.namespace);
        this.tagArray = [];
        this.maxTags = 5; //Si hay que cambiar el número máximo de etiquetas, hacerlo aqui
        console.log("Nueva instancia de TagInput creada: " + this.namespace);

    };

    //Asignar funciones al prototipo de TagInput (Definiciones que afectan a todos los objetos creados con el constructor TagInput)
    TagInput.prototype.updateTagList = updateTagList;
    TagInput.prototype.addTag = addTag;
    TagInput.prototype.removeTag = removeTag;

    var expTagInput = new TagInput("Exp");
    var eduTagInput = new TagInput("Edu");
    var otherInfoTagInput = new TagInput("Other");

    $(document).on("click", "#add-tag-btnExp", function ()
    {
        scopeTagInput = expTagInput;
        scopeTagInput.addTag();
    });

    $(document).on("click", ".tagExp>.remove-tag", function ()
    {
        scopeTagInput = expTagInput;
        scopeTagInput.removeTag($(this));
    });

    $(document).on("click", "#add-tag-btnEdu", function ()
    {
        scopeTagInput = eduTagInput;
        scopeTagInput.addTag();
    });

    $(document).on("click", ".tagEdu>.remove-tag", function ()
    {
        scopeTagInput = eduTagInput;
        scopeTagInput.removeTag($(this));
    });

    $(document).on("click", "#add-tag-btnOther", function ()
    {
        scopeTagInput = otherInfoTagInput;
        scopeTagInput.addTag();
    });

    $(document).on("click", ".tagOther>.remove-tag", function ()
    {
        scopeTagInput = otherInfoTagInput;
        scopeTagInput.removeTag($(this));
    });


});