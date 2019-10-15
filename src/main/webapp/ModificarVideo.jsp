<%@ page import="uytube.models.Lista"%>
<%@ page import="uytube.models.Video"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% for (Video V:(List<Video>)request.getAttribute("ListaConVideos")) {

%>
<p><%= V.getNombre() %></p>
<%
	
}
%>
Oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
<a href="logout">bye</a>
</body>
</html>


<jsp:include page="header.jsp"></jsp:include>
<body>
  <jsp:include page="sideBar.jsp"></jsp:include>
  <jsp:include page="consultaVideo.jsp"></jsp:include>
  <!-- My JS -->
<script src="/web/resources/js/ajax.js"></script>
</body>