
$( document ).ready(function() {

	$('#btn-guardar-campana').click(validacionesCampana);

	$('#filtroEmpresa').keyup(function () {
	      var valthis = $(this).val().toLowerCase();
	      var bandera = 1;
	      $('select#empresa>option').each(function () {
	          var text = $(this).text().toLowerCase();
	          if(text.indexOf(valthis) !== -1)  {
	        	  $(this).show(); 
	              $(this).prop('selected',true);
	              bandera = 0;
	          }
	          else{
	        	  $(this).hide();}
	           }
	      );
	      if(bandera){
	    	  $('#empresa').val(-1);
	      }else{
	    	  $('#empresa').change();
	      }
	      $('#filtroSubEmpresa').val('');
	      $('#subEmpresa').val(-1);
	});
	
	$('#filtroSubEmpresa').keyup(function () {
	      var valthis = $(this).val().toLowerCase();
	      var bandera = 1;
	      $('select#subEmpresa>option').each(function () {
	          var text = $(this).text().toLowerCase();
	          if(text.indexOf(valthis) !== -1 && $(this).attr('hijo') == 1 )  
	              {$(this).show(); 
	              $(this).prop('selected',true);
	              bandera = 0;
	              }
	          else{$(this).hide();}
	           });
	      if(bandera){
	    	  $('#subEmpresa').val(-1);
	      }
	});
	
	$('#btn-campana').click(saveCampana);
	
	$('#empresa').change(function(){ 
	    var idEmpresa = $(this).val();
	    $('#filtroSubEmpresa').val('');
	    $('select#subEmpresa>option').each(function () {	
          var idPadre = $(this).attr('padre');
          if(idPadre == idEmpresa)  
              {
        	  $(this).attr('hijo', '1'); //agregar otro atributo temporal 
        	  $(this).show(); 
        	  $(this).prop('selected',true);
              }
          else{
        	  $(this).hide();
        	  $(this).attr('hijo', '0');
          }
          
           });
	    
	});
	
	$( "#btn-campana-no" ).click(function() {
		$('#btn-guardar-campana').removeClass('hide');
		$('#btn-guardar-campana-cargar').addClass('hide');
		});

});

function validacionesCampana() {
	
	$('#btn-guardar-campana').addClass('hide');
	$('#btn-guardar-campana-cargar').removeClass('hide');
	
	if($('#nombre').val() == ''){
		$('#nombre').removeClass('is-valid');
		$('#nombre').addClass('is-invalid');
		$('#nombre-error').removeClass('invisible');
		$('#nombre-error').html('El campo no debe estar vac&iacuteo!');
		setTimeout(function() {
			$('#nombre-error').addClass('invisible');
			$('#nombre-error').empty();
		},3000);

		$('#btn-guardar-campana').removeClass('hide');
		$('#btn-guardar-campana-cargar').addClass('hide');
		$('#nombre').focus();
		return false;

	}else{
		$('#nombre').removeClass('is-invalid');
		$('#nombre').addClass('is-valid');
	}
	
	if($('#empresa').val() == -1){
		$('#empresa').removeClass('is-valid');
		$('#empresa').addClass('is-invalid');
		$('#empresa-error').removeClass('invisible');
		$('#empresa-error').html('El campo no debe estar vac&iacuteo!');
		setTimeout(function() {
			$('#empresa-error').addClass('invisible');
			$("#empresa-error").empty();
		},3000);

		$('#btn-guardar-campana').removeClass('hide');
		$('#btn-guardar-campana-cargar').addClass('hide');
		$('#empresa').focus();
		return false;

	}else{
		$('#empresa').removeClass('is-invalid');
		$('#empresa').addClass('is-valid');
	}
	
	if($('#subEmpresa').val() == -1){
		$('#subEmpresa').removeClass('is-valid');
		$('#subEmpresa').addClass('is-invalid');
		$('#subEmpresa-error').removeClass('invisible');
		$('#subEmpresa-error').html('El campo no debe estar vac&iacuteo!');
		setTimeout(function() {
			$('#subEmpresa-error').addClass('invisible');
			$("#subEmpresa-error").empty();
		},3000);

		$('#btn-guardar-campana').removeClass('hide');
		$('#btn-guardar-campana-cargar').addClass('hide');
		$('#subEmpresa').focus();
		return false;

	}else{
		$('#subEmpresa').removeClass('is-invalid');
		$('#subEmpresa').addClass('is-valid');
	}
	
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

		$('#btn-guardar-campana').removeClass('hide');
		$('#btn-guardar-campana-cargar').addClass('hide');
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

		$('#btn-guardar-campana').removeClass('hide');
		$('#btn-guardar-campana-cargar').addClass('hide');
		$('#fecha-vigencia').focus();
		return false;

	}else{
		$('#fecha-vigencia').removeClass('is-invalid');
		$('#fecha-vigencia').addClass('is-valid');
	}

    if ( $('#compraMinima').val() == '' || $('#compraMinima').val() < 0 || $('#compraMinima').val() % 1 != 0 ){
    	$('#compraMinima').removeClass('is-valid');
		$('#compraMinima').addClass('is-invalid');
		$('#compra-minima-error').removeClass('invisible');
		if($('#compraMinima').val() == ''){
			$('#compra-minima-error').html('El campo no debe estar vac&iacuteo!');
		}else if($('#compraMinima').val() < 1){
			$('#compra-minima-error').html('El campo no debe ser negativo!');
		}else{
			$('#compra-minima-error').html('El campo debe ser entero!');
		}
		setTimeout(function() {
			$('#compra-minima-error').addClass('invisible');
			$("#compra-minima-error").empty();
		},3000);

		$('#btn-guardar-campana').removeClass('hide');
		$('#btn-guardar-campana-cargar').addClass('hide');
		$('#compraMinima').focus();
		return false;
    }else{
    	$('#compraMinima').removeClass('is-invalid');
		$('#compraMinima').addClass('is-valid');
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

		$('#btn-guardar-campana').removeClass('hide');
		$('#btn-guardar-campana-cargar').addClass('hide');
		$('#cantidad-monederos').focus();
		return false;
    }else{
    	$('#cantidad-monederos').removeClass('is-invalid');
		$('#cantidad-monederos').addClass('is-valid');
    }
    if ( $('#monto').val() == '' || $('#monto').val() < 0 || $('#monto').val() % 1 != 0 ){
    	$('#monto').removeClass('is-valid');
		$('#monto').addClass('is-invalid');
		$('#monto-error').removeClass('invisible');
		if($('#monto').val() == ''){
			$('#monto-error').html('El campo no debe estar vac&iacuteo!');
		}else if($('#monto').val() < 0){
			$('#monto-error').html('El campo no debe ser negativo!');
		}else{
			$('#monto-error').html('El campo debe ser entero!');
		}
		setTimeout(function() {
			$('#monto-error').addClass('invisible');
			$("#monto-error").empty();
		},3000);

		$('#btn-guardar-campana').removeClass('hide');
		$('#btn-guardar-campana-cargar').addClass('hide');
		$('#monto').focus();
		return false;
    }else{
    	$('#monto').removeClass('is-invalid');
		$('#monto').addClass('is-valid');
    }

    if( parseInt($('#monto').val()) > parseInt($('#compraMinima').val()) ){
    	$('#modal-monto-compraMinima').modal('show');
    }else{
    	saveCampana();
    }
	
}

function saveCampana(){
	console.log('entro a saveCampana');
	var campana = $('#form-campana');
	console.log('campana: ',campana);
	$('#btn-guardar-campana').addClass('hide');
	$('#btn-guardar-campana-cargar').removeClass('hide');
	$.post("saveCampana.do", 
			campana.serializeArray(), 
			function(response) {
		console.log('response: ',response);
		if(response.respuesta==1){	
			
			$('#modal-general').html('<div class="alert alert-success" role="alert">'+ response.mensaje + ' </div>');	
			$('#form-campana')[0].reset();
		}else{
			$('#modal-general').html('<div class="alert alert-danger" role="alert">'+ response.mensaje + ' </div>');	
		}
		$("#btn-guardar-campana").removeClass("hide");
		$("#btn-guardar-campana-cargar").addClass("hide");

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