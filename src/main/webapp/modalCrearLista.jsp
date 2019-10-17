<%@ page import="java.util.List"%>
<%@ page import="uytube.models.Categoria" %>

<div class="signin">
    <div id="small-dialog8" class="mfp-hide">
        <h3>Crear lista de reproduccion</h3>
        <div class="signup">
            <form method="post" action="crearLista">
                <input type="text" placeholder="Nombre de la nueva lista" name="nombre_lista" id="privado" required="required" pattern="([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?"/>
                <label><input type="checkbox" name="privado" id="privado"/>Lista privada?</label>
                <select  id="categoria" name="categoria"><% for(Categoria c:(List<Categoria>) request.getSession().getAttribute("categorias")){ %>
                <option value="<%=c.getNombre()%>"><%=c.getNombre()%></option>
                <%} %></select>
                <input type="submit"  value="Crear lista"/>
            </form>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>