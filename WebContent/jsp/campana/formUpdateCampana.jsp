
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<script type="text/javascript" src="resources/js/campana/formUpdateCampana.js"></script>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h1 class="h2">Editar de Campañas</h1>
</div>
<div class="container-fluid shadow-lg bg-light">
    <div class="row tarjetas">
        <div class="col-12  col-sm-12 col-md-12">
            <div class="card">
                <div class="card-body m-4">
                    <h5 class="card-title">Datos de Campaña</h5>
                    <p class="card-text"></p>
                    <br>
                    <logic:present name="campanaConvenioRequest" scope="request">
	                    <form action="#" id="form-campana">
	                        <div class="form-group row">
	                        	<input type="hidden" id="idCampana" name="idCampana" value='<bean:write  name="campanaConvenioRequest" property="idCampana"/>' />
								<label for="nombre" class="col-form-label font-weight-bold">Campaña:</label>
								<div class="col col-form-label"><bean:write  name="campanaConvenioRequest" property="nombre"/></div>
							</div>
	                        <div class="row">
								<div class="row col-6 pl-4">
									<div class="form-group row pr-2">
										<label for="empresa" class="col-form-label font-weight-bold">Empresa:</label>
										<div class="col col-form-label"><bean:write  name="campanaConvenioRequest" property="catEmpresa.nombre"/></div>
									</div>
								</div>		
								<div class="row col">
									<div class="form-group row pr-2">
										<label for="subEmpresa" class="col-form-label font-weight-bold">Sub Empresa:</label>
										<div class="col col-form-label"><bean:write  name="campanaConvenioRequest" property="catSubEmpresa.nombre"/></div>
									</div>
								</div>
							</div>
	                        <div class="row">
	                        
	                        	<div class="form-group col">
	                        		<label>Fecha Inicio:</label>
									<div class="form-group row">
										<label for="fecha-inicio" class="col-form-label"><i class="fas fa-calendar-alt fa-2x" aria-hidden="true"></i></label>
										<div class="col">
											<input type="text" class="form-control datepicker" id="fecha-inicio" value='<bean:write  name="campanaConvenioRequest" property="fechaInicio" format="dd/MM/yyyy"/>' name="fechaInicio"> 
											<small id="fecha-inicio-error" class="form-text text-danger ml-3 invisible"></small>
										</div>
									</div>
								</div>
								
								<div class="form-group col">
	                        		<label>Fecha Vigencia:</label>
									<div class="form-group row">
										<label for="fecha-vigencia" class="col-form-label"><i class="fas fa-calendar-alt fa-2x" aria-hidden="true"></i></label>
										<div class="col">
											<input type="text" class="form-control datepicker" placeholder="Vigencia de Campaña" id="fecha-vigencia" value='<bean:write  name="campanaConvenioRequest" property="fechaVigencia" format="dd/MM/yyyy"/>' name="fechaVigencia"> 
											<small id="fecha-vigencia-error" class="form-text text-danger ml-3 invisible"></small>
										</div>
									</div>
								</div>
							</div>
	                        <div class="row">
	                        
	                        	<div class="form-group col-6">
	                       	 		<label>Monto Minimo:</label>
									<div class="form-group row">
										<label for="compraMinima" class="col-form-label"><i class="fas fa-file-alt fa-2x"></i></label>
										<div class="col">
											<input type="hidden" id="monto" name=montoMonedero value="${saldoRequest}" />
											<input type="text" class="form-control" onsubmit="return false;" value='<bean:write  name="campanaConvenioRequest" property="montoMinimo"/>' onfocus="(this.type='number')" id="montoMinimo" name="montoMinimo" placeholder="Monto compra minima">
											<small id="monto-minimo-error" class="form-text text-danger ml-3 invisible"></small>
										</div>
									</div>
								</div>
					
								<div class="form-group col pt-4 m-0">
									<div class="form-check pt-3">	
										<input class="form-check-input" type="checkbox" id="capturaDatos" name="capturaDatos" ${campanaConvenioRequest.capturaDatos == true ? 'checked' : ''}/> 
										<label class="form-check-label" for="capturaDatos">Requiere captura de datos?</label>
									</div>
								</div>
							</div>
	                        <hr>
							<h5 class="card-title">Datos de Monederos</h5>
							
							<div class="row" id="monedero">
								<div class="row pb-4 col-4">
									<div class="pr-4 pt-2">Tipo Monedero:</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio" name="tipoMonedero" id="inlineRadio-1" value="F" ${campanaConvenioRequest.tipoMonedero.toString() == 'F' ? 'checked' : ''} disabled> 
										<label class="form-check-label" for="inlineRadio-1">F&iacutesico</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio" name="tipoMonedero" id="inlineRadio-2" value="V" ${campanaConvenioRequest.tipoMonedero.toString() == 'V' ? 'checked' : ''} disabled> 
										<label class="form-check-label" for="inlineRadio-2">Virtual</label>
									</div>
								</div>
								
								<div class="form-group col-4">
		                         	<label>Cantidad de Monederos:</label>
									<div class="form-group row">
										<label for="cantidad-monederos" class="col-form-label">
										<i class="fas fa-sort-amount-up-alt fa-2x"></i></label>
										<div class="col">
											<input type="hidden" id="cantidad-monederos-anterior" value="${campanaConvenioRequest.monederos}" />
											<input type="text" class="form-control" onsubmit="return false;" onfocus="(this.type='number')" value="${campanaConvenioRequest.monederos}" maxlength="8" onfocus="(this.type='number')" id="cantidad-monederos" name="cantidadMonedero" placeholder="Cantidad de Monederos"> 
											<small id="cantidad-monederos-error" class="form-text text-danger ml-3 invisible"></small>
										</div>
									</div>
								</div>
								
								<div class="form-group row col-4 pt-4">
									<label for="monto" class="col-form-label font-weight-bold pt-3">Monto del Monedero:</label>
									<div class="col col-form-label pt-3">
										${saldoRequest}
									</div>
								</div>
								<div class="col">
								</div>
							</div>
	                        <button id="btn-update-campana" class="btn btn-md btn-primary" type="button">Editar</button>
	                        <button id="btn-update-campana-cargar" class="btn btn-primary hide waves-effect waves-light" type="button" disabled="">
	                            <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
	                            Cargando...
	                        </button> 
	                  </form>
                  </logic:present>
                  
                  <p></p>
                </div>
            </div>
        </div>                 
    </div>
</div>

<!-- modal-->
    <div class="modal fade" id="modal-monto-compraMinima" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">El monto del monedero es mayor a la compra minima </h5>
                    <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">¿Estas seguro que deseas continuar?</div>
                <div class="modal-footer">
                    <button type="button" id="btn-campana-no" class="btn btn-secondary" data-dismiss="modal">No</button>
                    <button type="button" id="btn-campana" class="btn btn-primary">S&iacute</button>
                </div>
            </div>
        </div>
    </div>
