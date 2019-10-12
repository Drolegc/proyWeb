<div class="published">
<div class="banner">
	<img class="rounded-circle" width="20%"
		src="/web/resources/images/c2.jpg" />
	<div class="user signin">
		<p><%=request.getAttribute("canal_nombre") %></p>
		<form method="post" action="seguir?id_video=<%= request.getParameter("id_video") %>">
		<input type="hidden" value="<%=request.getAttribute("nickname")%>" name="nickname" id="nickname">
		<input type="hidden" value="<%= request.getAttribute("canal_nombre") %>" name="canal_nombre">
		<% if(request.getAttribute("siguiendo").equals("false")){ %>
		<input type="hidden" value="true" name="subscribe" id="subscribe">
		<button type="submit">Subscribirse</button>
		<%}else{ %>
		<input type="hidden" value="false" name="subscribe" id="subscribe">
		<button type="submit" class="btn btn-outline">Dejar de seguir</button>
		<%} %>
		
		</form>
	</div>
</div>
</div>