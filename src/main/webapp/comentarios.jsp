<%@ page import="uytube.models.Comentario"%>
<%@ page import="java.util.List"%>
<div class="all-comments">
	<%
		if (request.getSession().getAttribute("usuarioLogueado") != null) {
	%>
	<div class="all-comments-info">

		<div class="box">
			<form id="form_comentario">
				<textarea placeholder="Message" name="comentario" id="comentario"
					required=" "></textarea>
				<input type="submit" value="COMENTAR">
				<div class="clearfix"></div>
			</form>
		</div>

	</div>
	<%
		}
	%>
	<div class="media-grids" id="comentario-box">
		<ul id="level-0">
			<%
				for (Comentario c : (List<Comentario>) request.getAttribute("comentarios")) {
			%>
			<li>
				<div class="media">
					<h5><%=c.getUsuario().getNickname()%></h5>
					<div class="media-left">
						<a href="#"> </a>
					</div>
					<div class="media-body">
						<p><%=c.getComentario()%></p>
					</div>
					<div>
						<%
							if (request.getSession().getAttribute("usuarioLogueado") != null) {
						%>
						<label for="responder">Responder <input type="checkbox"
							class="responder" value="<%=c.getId()%>"></label>
						<%
							}
						%>
					</div>
				</div> <!-- Si tiene respuestas --> <%
 	if (c.getRespuestas() != null) {
 %> <%
 	for (Comentario r : c.getRespuestas()) {
 %>
				<ul id="respuesta">
					<li>
						<div class="media">
							<h5><%=r.getUsuario().getNickname()%></h5>
							<div class="media-left">
								<a href="#"> </a>
							</div>
							<div class="media-body">
								<p><%=r.getComentario()%></p>
							</div>
							<div><!-- 
								<%
									if (request.getSession().getAttribute("usuarioLogueado") != null) {
								%>
								<label for="responder">Responder <input type="checkbox"
									class="responder" value="<%=c.getId()%>"></label>
								<%
									}
								%>
								 -->
							</div>
						</div>
					</li>
				</ul> <%
 	}
 %> <%
 	}
 %> <!-- Si tiene respuestas -->
			<li>
				<%
					}
				%>
			
		</ul>

	</div>
</div>