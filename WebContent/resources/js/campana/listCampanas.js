
$( document ).ready(function() {

	$("#cancelar-campana").on("click", function() {
	   
	});

});

function editCampana(idCampana){
	console.log('entro a editCampana');
	window.location = 'formUpdateCampana.do?idCampana='+idCampana;
	
}

function modalCancelarCampana(idCampana){
	 $('#modal-campana').modal('show');
	 $("#btn-cancelar-campana").remove();
	 $('#contendor-button').append(
			 "<button type='button' id='btn-cancelar-campana' onclick='cancelarCampana("+idCampana+")' class='btn btn-primary'>S&iacute</button>"
	 );
	 
}

function cancelarCampana(idCampana){
	$.post("cancelarCampana.do", 
			{
				'idCampana' : idCampana
			}, 
			function(response) {
		console.log('response: ',response);
		if(response.respuesta==1){
			$('#cancelar-'+idCampana).html("<span class='align-middle text-danger'>Cancelado</span>");
			$('#modal-general').html('<div class="alert alert-success" role="alert">'+ response.mensaje + ' </div>');
			$('#edit-'+idCampana).removeAttr("onclick");
		}else{
			$('#modal-general').html('<div class="alert alert-danger" role="alert">'+ response.mensaje + ' </div>');	
		}
	});
	$('#modal-campana').modal('hide');
}