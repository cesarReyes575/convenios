
$( document ).ready(function() {
	
	$('#btn-update-campana').click(validacionesCampana);
	
	$('#btn-campana').click(updateCampana);
	
	$( "#btn-campana-no" ).click(function() {
		$('#btn-update-campana').removeClass('hide');
		$('#btn-update-campana-cargar').addClass('hide');
		});
});


function validacionesCampana() {
	
	$('#btn-update-campana').addClass('hide');
	$('#btn-update-campana-cargar').removeClass('hide');
	
	if($('#fecha-inicio').val() == ''){
		$('#fecha-inicio').removeClass('is-valid');
		$('#fecha-inicio').addClass('is-invalid');
		$('#fecha-inicio-error').removeClass('invisible');
		if($('#fecha-inicio').val() == ''){
			$('#fecha-inicio-error').html('El campo no debe estar vac&iacuteo!');
		}else{
			$('#fecha-inicio-error').html('El campo debe ser de 10 caracteres!');	
		}
		setTimeout(function() {
			$('#fecha-inicio-error').addClass('invisible');
			$("#fecha-inicio-error").empty();
		},3000);

		$('#btn-update-campana').removeClass('hide');
		$('#btn-update-campana-cargar').addClass('hide');
		$('#fecha-inicio').focus();
		return false;

	}else{
		$('#fecha-inicio').removeClass('is-invalid');
		$('#fecha-inicio').addClass('is-valid');
	}
	
	if($('#fecha-vigencia').val() == '' || !CompararFechas( $('#fecha-inicio').val(), $('#fecha-vigencia').val() ) ==0 ){
		$('#fecha-vigencia').removeClass('is-valid');
		$('#fecha-vigencia').addClass('is-invalid');
		$('#fecha-vigencia-error').removeClass('invisible');
		if($('#fecha-vigencia').val() == ''){
			$('#fecha-vigencia-error').html('El campo no debe estar vac&iacuteo!');
		}else{
			$('#fecha-vigencia-error').html('Fecha Vigencia no debe ser menor a fecha Inicio!');
		}
		
		setTimeout(function() {
			$('#fecha-vigencia-error').addClass('invisible');
			$("#fecha-vigencia-error").empty();
		},3000);

		$('#btn-update-campana').removeClass('hide');
		$('#btn-update-campana-cargar').addClass('hide');
		$('#fecha-vigencia').focus();
		return false;

	}else{
		$('#fecha-vigencia').removeClass('is-invalid');
		$('#fecha-vigencia').addClass('is-valid');
	}

    if ( $('#montoMinimo').val() == '' || $('#montoMinimo').val() < 0 || $('#montoMinimo').val() % 1 != 0 ){
    	$('#montoMinimo').removeClass('is-valid');
		$('#montoMinimo').addClass('is-invalid');
		$('#monto-minimo-error').removeClass('invisible');
		if($('#montoMinimo').val() == ''){
			$('#monto-minimo-error').html('El campo no debe estar vac&iacuteo!');
		}else if($('#montoMinimo').val() < 1){
			$('#monto-minimo-error').html('El campo no debe ser negativo!');
		}else{
			$('#monto-minimo-error').html('El campo debe ser entero!');
		}
		setTimeout(function() {
			$('#monto-minimo-error').addClass('invisible');
			$("#monto-minimo-error").empty();
		},3000);

		$('#btn-update-campana').removeClass('hide');
		$('#btn-update-campana-cargar').addClass('hide');
		$('#compraMinima').focus();
		return false;
    }else{
    	$('#montoMinimo').removeClass('is-invalid');
		$('#montoMinimo').addClass('is-valid');
    }
    
    if ($('#cantidad-monederos').val() == '' || $('#cantidad-monederos').val() < 0 || $('#cantidad-monederos').val() % 1 != 0 ){
    	$('#cantidad-monederos').removeClass('is-valid');
		$('#cantidad-monederos').addClass('is-invalid');
		$('#cantidad-monederos-error').removeClass('invisible');
		$('#cantidad-monederos-error').html('El campo no debe estar vac&iacuteo!');
		
		if($('#cantidad-monederos').val() == ''){
			$('#cantidad-monederos-error').html('El campo no debe estar vac&iacuteo!');
		}else if($('#cantidad-monederos').val() < 1){
			$('#cantidad-monederos-error').html('El campo no debe ser negativo!');
		}else{
			$('#cantidad-monederos-error').html('El campo debe ser entero!');
		}
		setTimeout(function() {
			$('#cantidad-monederos-error').addClass('invisible');
			$("#cantidad-monederos-error").empty();
		},3000);

		$('#btn-update-campana').removeClass('hide');
		$('#btn-update-campana-cargar').addClass('hide');
		$('#cantidad-monederos').focus();
		return false;
    }else{
    	$('#cantidad-monederos').removeClass('is-invalid');
		$('#cantidad-monederos').addClass('is-valid');
    }
    
    if ( parseInt($('#cantidad-monederos').val()) < parseInt($('#cantidad-monederos-anterior').val()) ){
    	$('#cantidad-monederos').removeClass('is-valid');
		$('#cantidad-monederos').addClass('is-invalid');
		$('#cantidad-monederos-error').removeClass('invisible');
		$('#cantidad-monederos-error').html('No puede ser menor a los Monederos ya generados!');
		setTimeout(function() {
			$('#cantidad-monederos-error').addClass('invisible');
			$("#cantidad-monederos-error").empty();
		},3000);

		$('#btn-update-campana').removeClass('hide');
		$('#btn-update-campana-cargar').addClass('hide');
		$('#cantidad-monederos').focus();
		return false;
    }else{
    	$('#cantidad-monederos').removeClass('is-invalid');
		$('#cantidad-monederos').addClass('is-valid');
    }
  
    if( parseInt($('#monto').val()) > parseInt($('#montoMinimo').val()) ){
    	$('#modal-monto-compraMinima').modal('show');
    }else{
    	updateCampana();
    }
	
}

function updateCampana(){
	var campana = $('#form-campana');
	console.log('campana: ',campana);
	$('#btn-update-campana').addClass('hide');
	$('#btn-update-campana-cargar').removeClass('hide');
	$.post("updateCampana.do", 
			campana.serializeArray(), 
			function(response) {
		console.log('response: ',response);
		if(response.respuesta==1){	
			
			$('#modal-general').html('<div class="alert alert-success" role="alert">'+ response.mensaje + ' </div>');	
			$('#form-campana')[0].reset();
			setTimeout(function() {
				window.location = "listCampana.do";
			},2000);
			
		}else{
			$('#modal-general').html('<div class="alert alert-danger" role="alert">'+ response.mensaje + ' </div>');	
		}
		$("#btn-update-campana").removeClass("hide");
		$("#btn-update-campana-cargar").addClass("hide");

	});
}

function CompararFechas(fechaI,fechaF){

	console.log('fechaI ',fechaI);
	console.log('fechaF ',fechaF);
	var fecha_aux = fechaI.split("/");
 	var Fecha1 = new Date(parseInt(fecha_aux[2]),parseInt(fecha_aux[1]-1),parseInt(fecha_aux[0]));
 	var fecha_aux2 = fechaF.split("/");
 	var Fecha2 = new Date(parseInt(fecha_aux2[2]),parseInt(fecha_aux2[1]-1),parseInt(fecha_aux2[0]));
	if(Fecha1.getTime() > Fecha2.getTime()){
	   return 1;
	}
	return 0;
}
