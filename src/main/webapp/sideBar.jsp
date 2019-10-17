<%@ page import="uytube.models.Lista"%>
<%@ page import="java.util.List"%>
<%@ page import="uytube.models.Categoria" %>

<div class="col-sm-3 col-md-2 sidebar">
	<div class="top-navigation">
		<div class="t-menu">MENU</div>
		<div class="t-img">
			<img src="/web/resources/images/lines.png" alt="" />
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="drop-navigation drop-navigation">
		<ul class="nav nav-sidebar">
			<li class="active"><a href="index.html" class="home-icon"><span
					class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>

			<li><a href="#" class="user-icon"><span
					class="glyphicon glyphicon-home glyphicon-blackboard"
					aria-hidden="true"></span>Videos</a></li>
			<ul class="">
				<li><a href="movies.html">Subir video</a></li>
				<li><a href="movies.html">Ver videos</a></li>
			</ul>
			<li><a href="#" class="user-icon menu1"><span
					class="glyphicon glyphicon-home glyphicon-blackboard"
					aria-hidden="true"></span>Listas <span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span></a></li>
			<ul class="cl-effect-1">
							<jsp:include page="modalCrearLista.jsp"></jsp:include>
			
				<li>
				<a href="#small-dialog8" class="play-icon popup-with-zoom-anim">+ Crear lista</a>
				</li>
				<li><a href="movies.html">Ver mas tarde</a></li>
				<li><a href="movies.html">Me gusta</a></li>
				<%
					if (request.getSession().getAttribute("usuarioLogueado") != null) {
				%>
				<%
					for (Lista l : (List<Lista>) request.getSession().getAttribute("listas")) {
				%>
				<li><a href="movies.html"><%=l.getNombre()%></a></li>
				<%
					}
				%>
				<%
					}
				%>
			</ul>
			<!-- script-for-menu -->
						<script>
							$( "li a.menu1" ).click(function() {
							$( "ul.cl-effect-1" ).slideToggle( 300, function() {
							// Animation complete.
							});
							});
						</script>
			<li><a href="#" class="user-icon menu2"><span
					class="glyphicon glyphicon-home glyphicon-blackboard"
					aria-hidden="true"></span>Categorias <span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span></a></li>
			<ul class="cl-effect-2">
			<% for(Categoria c:(List<Categoria>) request.getSession().getAttribute("categorias")){ %>
			<li><a href="someServletURL"><%=c.getNombre()%></a></li>
			<%} %>
			</ul>
			<!-- script-for-menu -->
						<script>
							$( "li a.menu2" ).click(function() {
							$( "ul.cl-effect-2" ).slideToggle( 300, function() {
							// Animation complete.
							});
							});
						</script>
		</ul>
	</div>
</div>
</div>