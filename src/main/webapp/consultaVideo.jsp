<%@ page import="uytube.models.Lista"%>
<%@ page import="uytube.models.Video"%>
<%@ page import="java.util.List"%>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<div class="show-top-grids">
		<div class="col-sm-8 single-left">
			<div class="song">
				<div class="song-info">
					<h3><%= request.getAttribute("titulo") %></h3>
				</div>
				<div class="video-grid">
					<iframe src="https://www.youtube.com/embed/<%= request.getAttribute("link") %>"
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
				<p><%= request.getAttribute("descripcion") %></p>
				<div class="">
				<label class="text-primary" id="like" <% if(request.getAttribute("accion").equals("like")){%> value="true" <%}else{%>value="false"<%} %> >Me gusta <label id="like_number"><%=request.getAttribute("likes") %></label></label>|
				<label class="text-danger" id="dislike" <% if(request.getAttribute("accion").equals("dislike")){%> value="true" <%}else{%>value="false"<%} %>  >No me gusta <label id="dislike_number"><%=request.getAttribute("dislikes") %></label></label>
				</div>
				<jsp:include page="bannerChannel.jsp"></jsp:include>
			</div>
			<div class="all-comments">
				<div class="all-comments-info">
					<div class="box">
						<form id="form_comentario">
							<textarea placeholder="Message" name="comentario" id="comentario" required=" "></textarea>
							<input type="submit" value="COMENTAR">
							<div class="clearfix"></div>
						</form>
					</div>
				</div>
				<div class="media-grids" id="comentario-box">
					<div class="media">
						<h5>Tom Brown</h5>
						<div class="media-left">
							<a href="#"> </a>
						</div>
						<div class="media-body">
							<p>Maecenas ultricies rhoncus tincidunt maecenas imperdiet
								ipsum id ex pretium hendrerit maecenas imperdiet ipsum id ex
								pretium hendrerit</p>
							<span>View all posts by :<a href="#"> Admin </a></span>
						</div>
					</div>
					<div class="media">
						<h5>Peter Johnson</h5>
						<div class="media-left">
							<a href="#"> </a>
						</div>
						<div class="media-body">
							<p>Maecenas ultricies rhoncus tincidunt maecenas imperdiet
								ipsum id ex pretium hendrerit maecenas imperdiet ipsum id ex
								pretium hendrerit</p>
							<span>View all posts by :<a href="#"> Admin </a></span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-4 single-right">
		<% Lista lista = (Lista)request.getAttribute("lista_videos"); %>
			<h3><%=lista.getNombre_lista() %></h3>
			<div class="single-grid-right">
			<!-- Videos en la lista -->
			
			<% for(Video v:lista.getVideos()){ %>
				<div class="single-right-grids">
					<div class="col-md-4 single-right-grid-left">
						<a href="ver?id_video=<%= v.getId() %>&id_lista=<%= lista.getId()%>"><img src="https://i.ytimg.com/vi/<%=v.getUrl()%>/hqdefault.jpg" alt="" /></a>
					</div>
					<div class="col-md-8 single-right-grid-right">
						<a href="ver?id_video=<%= v.getId() %>&id_lista=<%= lista.getId()%>" class="title"><%=v.getNombre() %></a>
						<p class="author">
							<a href="#" class="author"><%=v.getCanal().getNombre() %></a>
						</p>
						<p class="views">2,114,200 views</p>
					</div>
					<div class="clearfix"></div>
				</div>
				<%} %>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>