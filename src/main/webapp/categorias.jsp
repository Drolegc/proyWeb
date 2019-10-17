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
<body>
	</br>
	</br>
	</br>
	<div class="single-grid-right">
		<h2><%=request.getAttribute("Categoria")%></h2>
		<%for (Video v : (List<Video>) request.getAttribute("listaVideos")) {%>
			 <div class="animated-grids">
                  <div class="col-md-3 resent-grid recommended-grid slider-first">
                    <div class="resent-grid-img recommended-grid-img">
                      <a href="ver?id_video=<%=v.getId()%>"><img
				src="https://i.ytimg.com/vi/<%=v.getUrl()%>/hqdefault.jpg" alt="" /></a>
                      <div class="time small-time slider-time">
                        <p>7:34</p>
                      </div>
                      <div class="clck small-clck">
                        <span class="glyphicon glyphicon-time" aria-hidden="true"></span>
                      </div>
                    </div>
                    <div class="resent-grid-info recommended-grid-info">
                      <h5><a href="ver?id_video=<%=v.getId()%>" class="title"><%=v.getNombre()%></a></h5>
                      <div class="slid-bottom-grids">
                        <div class="slid-bottom-grid">
                          <p class="author"><a href="#" class="author"><%=v.getCanal().getNombre()%></a>				</p>
                        </div>
                        <div class="slid-bottom-grid slid-bottom-right">
                          <p class="views views-info">2,114,200 views</p>
                        </div>
                        <div class="clearfix"> </div>
                      </div>
                    </div>
                  </div>              
			
			
		
		<%
			}
		%>
	</div>
</body>
</html>

