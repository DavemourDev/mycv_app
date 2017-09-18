 <div class="form-group">
        <div class="row">
            <div class="col-lg-1 ">
                <label>Tags</label>
            </div>
            <div class="col-lg-3">
                <div class="form-field"><!--Inicio-->
                    <input list="datalist" id="current-tag" data-toggle="tooltip" title="Una tag debe empezar con una letra y puede contener letras, números, guiones y guiones bajos.">
                    <datalist id="datalist">
                        
                    </datalist>
                    <input id="tags" type="hidden" name="tags"/>
                    <button id="add-tag-btn" type="button">AddTag</button>
                </div>
            </div>
            <div class="col-lg-8">
                <div id="tag-list" class="well"></div>
            </div>
        </div>
    </div>