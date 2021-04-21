
$( document ).ready(function() {

	$('#btn-guardar-subEmpresa').click(saveSubEmpresa);
	
	
	$('#filtro').keyup(function () {
	      var valthis = $(this).val().toLowerCase();
	      var bandera = 1;
	      $('select#empresa>option').each(function () {
	          var text = $(this).text().toLowerCase();
	          if(text.indexOf(valthis) !== -1)  {
	        	  $(this).show(); 
	        	  $(this).prop('selected',true);
	              bandera = 0;
	              }
	          else{$(this).hide();}
	      });
	      if(bandera){
	    	  $('#empresa').val(-1);
	      }
	      
	});

});

function saveSubEmpresa() {
	
	$('#btn-guardar-subEmpresa').addClass('hide');
	$('#btn-guardar-subEmpresa-cargar').removeClass('hide');
	
	if($('#empresa').val() == -1){
		$('#empresa').removeClass('is-valid');
		$('#empresa').addClass('is-invalid');
		$('#empresa-error').removeClass('invisible');
		$('#empresa-error').html('El campo no debe estar vac&iacuteo!');
		setTimeout(function() {
			$('#empresa-error').addClass('invisible');
			$("#empresa-error").empty();
		},3000);

		$('#btn-guardar-subEmpresa').removeClass('hide');
		$('#btn-guardar-subEmpresa-cargar').addClass('hide');
		$('#empresa').focus();
		return false;

	}else{
		$('#empresa').removeClass('is-invalid');
		$('#empresa').addClass('is-valid');
	}
	
	if($('#nombre').val() == ''){
		$('#nombre').removeClass('is-valid');
		$('#nombre').addClass('is-invalid');
		$('#nombre-error').removeClass('invisible');
		$('#nombre-error').html('El campo no debe estar vac&iacuteo!');
		setTimeout(function() {
			$('#nombre-error').addClass('invisible');
			$('#nombre-error').empty();
		},3000);

		$('#btn-guardar-subEmpresa').removeClass('hide');
		$('#btn-guardar-subEmpresa-cargar').addClass('hide');
		$('#nombre').focus();
		return false;

	}else{
		$('#nombre').removeClass('is-invalid');
		$('#nombre').addClass('is-valid');
	}

	var nombre = $('#nombre').val();
	var idEmpresa = $('#empresa').val();
	console.log('nombre: ', nombre);
	console.log('idEmpresa: ',idEmpresa);
	$('#btn-guardar-subEmpresa').addClass('hide');
	$('#btn-guardar-subEmpresa-cargar').removeClass('hide');
	$.post("saveSubEmpresa.do", 
			{
				'nombre' : nombre,
				'idEmpresa' : idEmpresa
			}, 
			function(response) {
		console.log('response: ',response);
		if(response.respuesta==1){	
			$('#modal-general').html('<div class="alert alert-success" role="alert">'+ response.mensaje + ' </div>');
			$('#form-sub-empresa')[0].reset();
		}else{
			$("#modal-general").html('<div class="alert alert-danger" role="alert">'+ response.mensaje + ' </div>');	
		}
		$("#btn-guardar-subEmpresa").removeClass("hide");
		$("#btn-guardar-subEmpresa-cargar").addClass("hide");

	});

}