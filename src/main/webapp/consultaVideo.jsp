<%@ page import="uytube.models.Lista"%>
<%@ page import="uytube.models.Video"%>
<%@ page import="java.util.List"%>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<div class="show-top-grids">
		<div class="col-sm-8 single-left">
			<div class="song">
				<div class="song-info">
					<h3><%=request.getAttribute("titulo")%></h3>
				</div>
				<div class="video-grid">
					<iframe
						src="https://www.youtube.com/embed/<%=request.getAttribute("link")%>"
						allowfullscreen></iframe>
				</div>
			</div>
			<div class="song-grid-right">
				<div class="share">
					<h5>Share this</h5>
					<ul>
						<li><a href="#" class="icon fb-icon">Facebook</a></li>
						<li><a href="#" class="icon dribbble-icon">Dribbble</a></li>
						<li><a href="#" class="icon twitter-icon">Twitter</a></li>
						<li><a href="#" class="icon pinterest-icon">Pinterest</a></li>
						<li><a href="#" class="icon whatsapp-icon">Whatsapp</a></li>
						<li><a href="#" class="icon like">Like</a></li>
						<li><a href="#" class="icon comment-icon">Comments</a></li>
						<li class="view">200 Views</li>
					</ul>
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="published">
				<script src="jquery.min.js"></script>
				<script>
					$(document).ready(function() {
						size_li = $("#myList li").size();
						x = 1;
						$('#myList li:lt(' + x + ')').show();
						$('#loadMore').click(function() {
							x = (x + 1 <= size_li) ? x + 1 : size_li;
							$('#myList li:lt(' + x + ')').show();
						});
						$('#showLess').click(function() {
							x = (x - 1 < 0) ? 1 : x - 1;
							$('#myList li').not(':lt(' + x + ')').hide();
						});
					});
				</script>
				<h4>Published on 15 June 2015</h4>
				<p><%=request.getAttribute("descripcion")%></p>
				<div class="">
					<label class="text-primary" id="like"
						<%if (request.getAttribute("accion").equals("like")) {%>
						value="true" <%} else {%> value="false" <%}%>>Me gusta <label
						id="like_number"><%=request.getAttribute("likes")%></label></label>| <label
						class="text-danger" id="dislike"
						<%if (request.getAttribute("accion").equals("dislike")) {%>
						value="true" <%} else {%> value="false" <%}%>>No me gusta
						<label id="dislike_number"><%=request.getAttribute("dislikes")%></label>
					</label>
							
				</div>
				<jsp:include page="bannerChannel.jsp"></jsp:include>
			</div>
			<jsp:include page="comentarios.jsp"></jsp:include>
		</div>
		<%
			if (request.getSession().getAttribute("usuarioLogueado") != null) {
		%>
		<div class="col-md-4 single-right">
		<div class="agregar-quitar-lista">
		<h3>Agregar a </h3>
		<form id="formAgregar">
		<select id="agregarLista">
		<% for(Lista l:(List<Lista>)request.getSession().getAttribute("listas")) {%>
		<option value="<%=l.getId()%>" ><%=l.getNombre()%></option>
		<%} %>
		</select>
		<input type="submit" value="Agregar">
		</form>
		</div>
		
		<div class="agregar-quitar-lista">
		<h3>Quitar de</h3>
		<form id="formQuitar">
		<select id="quitarLista">
		<% for(Lista l:(List<Lista>)request.getSession().getAttribute("listas")) {%>
		<option value="<%=l.getId()%>"><%=l.getNombre()%></option>
		<%} %>
		</select>
		<input type="submit" value="quitar">
		</form>
		</div>
	
			<h3>
				Videos privados de
				<%=request.getSession().getAttribute("usuarioLogueado")%></h3>
			<div class="single-grid-right">
				<!-- Videos en la lista -->

				<%
					for (Video v : (List<Video>) request.getAttribute("lista_videos")) {
				%>
				<div class="single-right-grids">
					<div class="col-md-4 single-right-grid-left">
					<% String[] url = v.getUrl().split("/"); %>
						<a href="ver?id_video=<%=v.getId()%>"><img
							src="https://i.ytimg.com/vi/<%=url[url.length-1]%>/hqdefault.jpg" alt="" /></a>
							
					</div>
					<div class="col-md-8 single-right-grid-right">
						<a href="ver?id_video=<%=v.getId()%>" class="title"><%=v.getNombre()%></a>
						<p class="author">
							<a href="#" class="author"><%=v.getCanal().getNombre()%></a>
						</p>
						<p class="views">2,114,200 views</p>
					</div>
					<div class="clearfix"></div>
				</div>
				<%
					}
				%>
			</div class="single-grid-right">
			<h3>Actividad</h3>
			<% for(String val: (List<String>)request.getAttribute("valoraciones")){ %>
			<p><%=val %></p>
			<% } %>
			<div>
			</div>
			<%
				}
			%>
		</div>

		<div class="clearfix"></div>
	</div>