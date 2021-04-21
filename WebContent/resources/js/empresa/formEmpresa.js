
$( document ).ready(function() {

	$('#btn-guardar-empresa').click(saveEmpresa);

});


function saveEmpresa() {
	
	$('#btn-guardar-empresa').addClass('hide');
	$('#btn-guardar-empresa-cargar').removeClass('hide');
	
	if($('#nombre').val() == ''){
		$('#nombre').removeClass('is-valid');
		$('#nombre').addClass('is-invalid');
		$('#nombre-error').removeClass('invisible');
		$('#nombre-error').html('El campo no debe estar vac&iacuteo!');
		setTimeout(function() {
			$('#nombre-error').addClass('invisible');
			$('#nombre-error').empty();
		},3000);

		$('#btn-guardar-empresa').removeClass('hide');
		$('#btn-guardar-empresa-cargar').addClass('hide');
		$('#nombre').focus();
		return false;

	}else{
		$('#nombre').removeClass('is-invalid');
		$('#nombre').addClass('is-valid');
	}
	
	if($('#nombre-representante').val() == ''){
		$('#nombre-representante').removeClass('is-valid');
		$('#nombre-representante').addClass('is-invalid');
		$('#nombre-representante-error').removeClass('invisible');
		$('#nombre-representante-error').html('El campo no debe estar vac&iacuteo!');
		setTimeout(function() {
			$('#nombre-representante-error').addClass('invisible');
			$("#nombre-representante-error").empty();
		},3000);

		$('#btn-guardar-empresa').removeClass('hide');
		$('#btn-guardar-empresa-cargar').addClass('hide');
		$('#nombre-repredentante').focus();
		return false;

	}else{
		$('#nombre-representante').removeClass('is-invalid');
		$('#nombre-representante').addClass('is-valid');
	}
	
	if($('#direccion').val() == ''){
		$('#direccion').removeClass('is-valid');
		$('#direccion').addClass('is-invalid');
		$('#direccion-error').removeClass('invisible');
		$('#direccion-error').html('El campo no debe estar vac&iacuteo!');
		setTimeout(function() {
			$('#direccion-error').addClass('invisible');
			$("#direccion-error").empty();
		},3000);

		$('#btn-guardar-empresa').removeClass('hide');
		$('#btn-guardar-empresa-cargar').addClass('hide');
		$('#direccion').focus();
		return false;

	}else{
		$('#direccion').removeClass('is-invalid');
		$('#direccion').addClass('is-valid');
	}
	
	if($('#telefono').val() == '' || $('#telefono').val().replace(/\D+/g,"").length != 10){
		$('#telefono').removeClass('is-valid');
		$('#telefono').addClass('is-invalid');
		$('#telefono-error').removeClass('invisible');
		if($('#telefono').val() == ''){
			$('#telefono-error').html('El campo no debe estar vac&iacuteo!');
		}else{
			$('#telefono-error').html('El campo debe ser de 10 caracteres!');	
		}
		setTimeout(function() {
			$('#telefono-error').addClass('invisible');
			$("#telefono-error").empty();
		},3000);

		$('#btn-guardar-empresa').removeClass('hide');
		$('#btn-guardar-empresa-cargar').addClass('hide');
		$('#telefono').focus();
		return false;

	}else{
		$('#telefono').removeClass('is-invalid');
		$('#telefono').addClass('is-valid');
	}
	
	
	var caract = new RegExp(/^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/);

    if (caract.test($('#correo').val()) == false || $('#correo').val()==''){
    	$('#correo').removeClass('is-valid');
		$('#correo').addClass('is-invalid');
		$('#correo-error').removeClass('invisible');
		if($('#correo').val()==''){
			$('#correo-error').html('El campo no debe estar vac&iacuteo!');
			}else{
		$('#correo-error').html('El correo es incorrecto!');
			}
		setTimeout(function() {
			$('#correo-error').addClass('invisible');
			$("#correo-error").empty();
		},3000);

		$('#btn-guardar-empresa').removeClass('hide');
		$('#btn-guardar-empresa-cargar').addClass('hide');
		$('#correo').focus();
		return false;
    }else{
    	$('#correo').removeClass('is-invalid');
		$('#correo').addClass('is-valid');
    }
 	
	var empresa = $('#form-empresa');
	$('#btn-guardar-empresa').addClass('hide');
	$('#btn-guardar-empresa-cargar').removeClass('hide');
	$.post("saveEmpresa.do", 
			empresa.serializeArray(), 
			function(response) {
		console.log('response: ',response);
		if(response.respuesta==1){	
			
			$('#modal-general').html('<div class="alert alert-success" role="alert">'+ response.mensaje + ' </div>');	
			$('#form-empresa')[0].reset();
		}else{
			$('#modal-general').html('<div class="alert alert-danger" role="alert">'+ response.mensaje + ' </div>');	
		}
		$("#btn-guardar-empresa").removeClass("hide");
		$("#btn-guardar-empresa-cargar").addClass("hide");

	});

}