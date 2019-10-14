$("#form_subscripcion").submit(function(ev){
	
	console.log("Testing");
	
	ev.preventDefault();
	
	var data = {
			subscribe:$("#subscribe").attr("value"),
			nickname:$("#nickname").attr("value"),
			canal_nombre:$("#canal_nombre").attr("value"),
	}
	
	$.ajax({
		url:"seguir",
		type:"post",
		data:data,
		success:function(resp){
			if($("#subscripcion").text()=="Subscribirse"){
				$("#subscribe").val("false");
				$("#subscripcion").text("Dejar de seguir");
				alert(resp)
			}else{
				$("#subscribe").val("true");
				$("#subscripcion").text("Subscribirse");
				alert(resp)
			}
		}
	})
})

$("#form_comentario").submit(function(event){
	event.preventDefault();
	var data = {
		comentario:$("#comentario").attr("value"),	
	};
	
	var com_append = '<div class="media"><h5>Tom Brown</h5><div class="media-left"><a href="#"> </a></div><div class="media-body"><p>Maecenas ultricies rhoncus tincidunt maecenas imperdietipsum id ex pretium hendrerit maecenas imperdiet ipsum id expretium hendrerit</p><span>View all posts by :<a href="#"> Admin </a></span></div></div>';
	$.ajax({
		url:"comentar",
		type:"post",
		data:data,
		success:function(resp){
			$("#comentario-box").append(com_append)
		}
	})
})

$(document).ready(function(){
  $("#like").click(function(){
    var a = parseInt($("#like_number").text());
    $("#like_number").text(++a);
    $("#like").css("color","#3a9df3");
    $("#dislike").css("color","#a94442");
  });
});

$(document).ready(function(){
	  $("#dislike").click(function(){
	    var a = parseInt($("#dislike_number").text());
	    $("#dislike_number").text(++a);
	    $("#dislike").css("color","#e03835");
	    $("#like").css("color","#337ab7");
	  });
	});
