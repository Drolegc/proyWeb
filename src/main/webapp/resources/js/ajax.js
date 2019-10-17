$("#form_subscripcion").submit(function(ev) {

	console.log("Testing");

	ev.preventDefault();

	var data = {
		subscribe : $("#subscribe").attr("value"),
		nickname : $("#nickname").attr("value"),
		canal_nombre : $("#canal_nombre").attr("value"),
	}

	$.ajax({
		url : "seguir",
		type : "post",
		data : data,
		success : function(resp) {
			if ($("#subscripcion").text() == "Subscribirse") {
				$("#subscribe").val("false");
				$("#subscripcion").text("Dejar de seguir");
				alert(resp)
			} else {
				$("#subscribe").val("true");
				$("#subscripcion").text("Subscribirse");
				alert(resp)
			}
		}
	})
})

$("#formAgregar").submit(
function(event){
	event.preventDefault();
	var data = {
			id_video: getUrlParameter("id_video"),
			id_lista: $("#agregarLista").val(),
			accion: "agregar"
	};
	
	$.ajax({
		url:"agregarQuitar",
		type:"post",
		data:data,
		success:function(res){
			alert(res);
		},
	})
	
	
}		
);

$("#formQuitar").submit(
		function(event){
			event.preventDefault();
			var data = {
					id_video: getUrlParameter("id_video"),
					id_lista: $("#quitarLista").val(),
			};
			
			$.ajax({
				url:"agregarQuitar",
				type:"post",
				data:data,
				success:function(res){
					alert(res);
				},
			})
			
			
		}		
		);

$("#form_comentario")
		.submit(
				function(event) {
					event.preventDefault();
					
					if(!$(".responder").is(":checked")){
						var data = {
							comentario : $("#comentario").val(),
							id_video : getUrlParameter("id_video")
						};
					}else{
						
						var data = {
								comentario : $("#comentario").val(),
								id_video : getUrlParameter("id_video"),
								id_comentario : $(".responder:checked").val(),
						}
						
					}
					var com_append = '<li><div class="media"><h5>Tu</h5><div class="media-left"><a href="#"></a></div><div class="media-body"><p>';
					com_append += data.comentario;
					com_append +='</p></div></div><li>';
					
					
					$.ajax({
						url : "comentar",
						type : "post",
						data : data,
						success : function(resp) {
							window.location.reload();
						}
					})
				})

				
				
var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
};
				
$(document).ready(function() {

	const a = parseInt($("#like_number").text());
	const b = parseInt($("#dislike_number").text());

	var a2 = a + 1;
	var b2 = b + 1;

	console.log("Preparando");

	$("#like").click(function() {
		if ($("#like").attr("value") != "true") {
			var a = parseInt($("#like_number").text());
			$("#like_number").text(a2);
			$("#dislike_number").text(b);
			$("#like").css("color", "#3a9df3");
			$("#dislike").css("color", "#a94442");
			$("#like").attr("value", "true");
			$("#dislike").attr("value","false");
			
			$.ajax({
				url:"valoracionVideo",
				type:"post",
				data:{
					valoracion:1,
					id_video:getUrlParameter('id_video'),
				},
				success:function(data){
					alert(data);
				}
			});
		}
	});

	$("#dislike").click(function() {
		if ($("#dislike").attr("value") != "true") {
			var a = parseInt($("#dislike_number").text());
			$("#dislike_number").text(b2);
			$("#like_number").text(a);
			$("#dislike").css("color", "#e03835");
			$("#like").css("color", "#337ab7");
			$("#dislike").attr("value", "true");
			$("#like").attr("value","false");
			
			$.ajax({
				url:"valoracionVideo",
				type:"post",
				data:{
					valoracion:-1,
					id_video:getUrlParameter('id_video'),
				},
				success:function(data){
					alert(data);
				}
			});
			
		}
	});

});

$(document).ready(function() {

	if ($("#like").attr("value") == "true") {
		$("#like").css("color", "#3a9df3");
	}

	if ($("#dislike").attr("value") == "true") {
		$("#dislike").css("color", "#e03835");
	}
})

