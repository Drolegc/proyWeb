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