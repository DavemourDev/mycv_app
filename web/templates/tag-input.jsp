<div class="row">
    <div class="col-lg-1 ">
        <label>Tags</label>
    </div>
    
    <div class="col-lg-3">
        <div class="form-field"><!--Inicio-->
            <input list="datalist<%=tagInputNS%>" id="current-tag<%=tagInputNS%>" data-toggle="tooltip" title="Una tag debe empezar con una letra y puede contener letras, números, guiones y guiones bajos.">

            <datalist id="datalist<%=tagInputNS%>">
                <%--
                <%for (String tag : tagsDatalist){%>
                    <option><%=tag%></option>
                <%}%>
                --%>
            </datalist>

            <input id="tags<%=tagInputNS%>" type="hidden" name="tags"/>
            <button id="add-tag-btn<%=tagInputNS%>" type="button">AddTag</button>
        </div>
    </div>
        
    <div class="col-lg-8">
        <div id="tag-list<%=tagInputNS%>" class="well"></div>
    </div>
    
    <script>
        tagInputs.push(new TagInput('<%=tagInputNS%>', [<%
            i = 0;
            n = tags.size();
            while (!tags.isEmpty())
            {
        %>'<%=tags.get(i++)%>'<%
            if (i == n)
            {
                break;
            }
        %>, <%
            }
        %>
        ]));
    </script>
</div>