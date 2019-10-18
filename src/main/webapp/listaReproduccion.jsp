<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="uytube.models.Lista"%>
<%@ page import="uytube.models.Video"%>
<%@ page import="uytube.models.Usuario"%>
<%@ page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>


<!DOCTYPE html>
<html>
<head class="listaReproduccion">
<meta charset="UTF-8">
<title>Lista de Reproducción</title>
</head>
<body class="listaReproduccion">
	<jsp:include page="sideBar.jsp"></jsp:include>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<div class="single-grid-right">
			<h1 class="listaReproduccion">
				UyTube&nbsp;<span style="color: black;">| <%=request.getAttribute("nombreLista")%></span>&nbsp;<span
					style="color: black; font-size: 100%;">| <%=request.getSession().getAttribute("usuarioLogueado")%>
				</span>
			</h1>
			<p style="font-size: 20px; padding-left: 20px; color: grey;">Lista
				de reproducción</p>
			<%
				for (Video v : (List<Video>) request.getAttribute("listaRepro")) {
			%>
			<div class="animated-grids">
				<div style="padding-left: 10px; padding-bottom: 10px;"
					class="col-md-3 resent-grid recommended-grid slider-first">
					<div class="resent-grid-img recommended-grid-img">
						<a href="ver?id_video=<%=v.getId()%>"><img
							src="https://i.ytimg.com/vi/<%=v.getUrl()%>/hqdefault.jpg" alt="" /></a>
						<div class="time small-time slider-time">
							<p>--:--</p>
						</div>
						<div class="clck small-clck">
							<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
						</div>
					</div>
					<div class="resent-grid-info recommended-grid-info">
						<h5>
							<a href="ver?id_video=<%=v.getId()%>" class="title"><%=v.getNombre()%></a>
						</h5>
						<div class="slid-bottom-grids">
							<div class="slid-bottom-grid">
								<p class="author">
									<a href="#" class="author"><%=v.getCanal().getNombre()%></a>
								</p>
							</div>
							<div class="slid-bottom-grid slid-bottom-right">
								<p class="views views-info">----- views</p>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
</body>
</html>
