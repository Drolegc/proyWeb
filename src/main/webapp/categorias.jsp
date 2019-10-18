<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="uytube.models.Lista"%>
<%@ page import="uytube.models.Video"%>
<%@ page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categorias</title>
</head>
<body class="categorias">
	<jsp:include page="sideBar.jsp"></jsp:include>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="single-grid-right">
				<h1 class="categorias">
					UyTube&nbsp;<span style="color: black;">| <%=request.getAttribute("Categoria")%>
					</span>
				</h1>
				<p style="font-size: 20px; padding-left: 20px; color: grey;">Lista
					de reproducción</p>
				<!-- <h2><%=request.getAttribute("Categoria")%></h2> -->
				<%
					for (Video v : (List<Video>) request.getAttribute("listaVideos")) {
				%>
				<div class="animated-grids">
					<div style="padding-left: 10px; padding-bottom: 10px;" class="col-md-3 resent-grid recommended-grid slider-first">
						<div class="resent-grid-img recommended-grid-img">
							<a href="ver?id_video=<%=v.getId()%>"><img
								src="https://i.ytimg.com/vi/<%=v.getUrl()%>/hqdefault.jpg"
								alt="" /></a>
							<div class="time small-time slider-time">
								<p>7:34</p>
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
									<p class="views views-info">2,114,200 views</p>
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
