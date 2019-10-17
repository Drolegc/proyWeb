<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="uytube.models.Lista"%>
<%@ page import="uytube.models.Categoria"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UyTube | Sube tu video</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body class="uploadvideo">
	<jsp:include page="sideBar.jsp"></jsp:include>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<div class="col-sm-8 single-left">
			<h1 style="margin-bottom: 40px;">UyTube | Coloca los datos de tu
				video</h1>
			<form class="uploadvideo" action="subirVideoYT" method="post">
				<table class="uploadvideo table-bordered">
					<tbody>
						<tr>
							<td>Título</td>
							<td>Descripción</td>
							<td>Categoria  (Opcional)</td>
						</tr>
						<tr>

							<td><input type="text" name="titulo_video" required=" " /></td>
							<td><input type="text" name="descripcion" required=" " /></td>
							<td><select name="categoria">
									<option selected value="Sin Categoria">Sin Categoria</option>
									<%
										for (Categoria c : (List<Categoria>) request.getSession().getAttribute("categorias")) {
									%>
									<option value=<%=c.getNombre()%>>
										<%=c.getNombre()%></option>
									<%
										}
									%>
							</select></td>
						</tr>
						<tr>
							<td>URL Video</td>
							<td>Privacidad</td>
						</tr>
						<tr>
							<td><input type="text" name="url" required=" " /></td>
							<td><select name="privacidad">
									<option selected value="privado">Privado</option>
									<option value="publico">Público</option>
						</tr>
					</tbody>
				</table>
				<input class="submit" type="submit" value="Sube tu video" />

			</form>
		</div>
	</div>
</body>
</html>