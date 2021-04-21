
$( document ).ready(function() {
	
	$('.datepicker').datepicker({
		format : "dd/mm/yyyy",
		language : "es",
		daysOfWeekHighlighted : "0",
		weekStart : 0
	});
    
	$('.nav-link').click(function(){
	
	     $(".nav-link").each(function(index) {
	          
	          $('#'+$(this).attr('id')).removeClass('hover-menu');
	      });
	    
	    var id = $(this).attr("id");
	    if( $('#'+id).attr('aria-expanded') == 'true' ){
	           $('#'+($(this).attr('id')) +'> .fa-caret-up' ).addClass('fa-caret-down').removeClass('fa-caret-up'); 
	    }else if( $('#'+id).attr('aria-expanded') == 'false' ){
	       $('#'+($(this).attr('id')) +'> .fa-caret-down' ).addClass('fa-caret-up').removeClass('fa-caret-down');
	    }else{
	        $('#'+($(this).attr('id')) +'> .fa-caret-down' ).addClass('fa-caret-up').removeClass('fa-caret-down');
	    }
	    $('#'+$(this).attr('id')).addClass('hover-menu');
	 }); 
	 
	 

 });
 
 function logout(){
	window.location = 'login.do?method=logout';
}

function limpiarResult() {
	$("#div-resultado .mensaje").html("");
	$("#div-resultado .contenido").html("");
}

function showMessage(idMessage, message, typeMessage) {
	$("#modal-general").html("");
	var classMessage = "";
	var tache = "x";
	switch (typeMessage) {
	case "success":
		classMessage = "alert-success";
		$("#modal-general").append(
				"<div id='" + idMessage + "' class='alert alert-dismissible " + classMessage + "'>"
						+ "<button id='btn-success' type='button' class='close' data-dismiss='alert'>" + tache + "</button>"
						+ message + "</div>");
		
		break;
	case "error":
		classMessage = "alert-danger";
		$("#modal-general").addClass("dialog-open");
		$("#modal-general").append(
				"<div id='"+idMessage+"' class='alert alert-dismissible " + classMessage + "'>"
						+ "<button id='error-button' type='button' class='close' data-dismiss='alert'>" + tache + "</button>"
						+ "<div class='message-content'>" + message + "</div>" + "</div>");

		$('#modal-general').on('click', function() {
			$(this).removeClass("dialog-open");
			$(this).find(".alert.alert-danger").alert("close");
		});
		break;
	case "pregunta":
		classMessage = "alert-info";
		$("#modal-general").addClass("dialog-open");
		$("#modal-general").append(
				"<div id='idMessage' class='alert alert-dismissible " + classMessage + "'>"
						+ "<div class='icon-message'><i class='fa fa-question-circle-o'></i></div>"
						+ "<div class='message-content'> " + message + " <br/><a class='btn btn-primary' id='"
						+ classMessage + "_cancelar'>Cancelar</a> " + "<a class='btn btn-raised btn-primary' id='"
						+ classMessage + "_aceptar'>Aceptar</a></div>" + "</div>");
		break;
	default:
		classMessage = "alert-info";
		$("#modal-general").append(
				"<div id='" + idMessage + "' class='alert alert-dismissible " + classMessage + "'>"
						+ "<button type='button' class='close' data-dismiss='alert'>" + tache + "</button>" + message + "</div>");
		break;
	}

}


