
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<script type="text/javascript" src="resources/js/campana/formCampana.js"></script>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">Registro de Campañas</h1>
</div>
<!--<h2>Cupones Vigentes</h2>-->
<div class="container-fluid shadow-lg bg-light">
	<div class="row tarjetas">
		<div class="col-12 col-sm-12 col-md-12">
			<div class="card">
				<div class="card-body m-4">
					<h5 class="card-title">Datos de Campaña</h5>
					<form action="#" id="form-campana">
						
						<div class="form-group">
	                        <label>Nombre de Campaña:</label>
							<div class="form-group row">
								<label for="nombre" class="col-form-label"><i class="fas fa-file-alt fa-2x"></i></label>
								<div class="col">
									<input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre de Campaña"> 
									<small id="nombre-error" class="form-text text-danger ml-3 invisible"></small>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="row col-6 pl-4">
								
								<div class="form-group">
		                        	<label>Empresa:</label>
									<div class="form-group row pr-2">
										<label for="empresa" class="col-form-label"><i class="fas fa-list-alt fa-2x"></i></label>
										<div class="col">
											<select class="form-control" id="empresa" name="idEmpresa" style="width:150px">
												<option selected value="-1">--</option>
												<logic:present name="listEmpresaRequest" scope="request">
													<logic:iterate id="empresas" name="listEmpresaRequest">
													<option value="<bean:write  name='empresas' property='idEmpresa'/>" id="<bean:write  name='empresas' property='idEmpresa'/>">
														<bean:write  name="empresas" property="nombre"/>
													</option>
													</logic:iterate>
												</logic:present>
											</select><small id="empresa-error"
											class="form-text text-danger ml-3 invisible"></small> 
										</div>
									</div>
								</div>
								
								
								<div class="form-group row pt-4">
									<label for="filtroEmpresa" class="col-form-label"></label>
									<div class="col pt-2">
										<input type="text" class="form-control" id="filtroEmpresa" placeholder="Filtro">
									</div>
								</div>
								
			
							</div>		
							<div class="row col">
								
								<div class="form-group">
		                        	<label>Sub Empresa:</label>
									<div class="form-group row pr-2">
										<label for="subEmpresa" class="col-form-label"><i class="fas fa-list-alt fa-2x"></i></label>
										<div class="col">
											<select class="form-control" id="subEmpresa" name="idSubEmpresa" style="width:150px">
												<option selected value="-1">--</option>
												<logic:present name="listEmpresaRequest" scope="request">
													<logic:iterate id="empresas" name="listEmpresaRequest">
														<logic:iterate id="subEmpresas" name="empresas" property="catSubEmpresas">
															<option value="<bean:write  name='subEmpresas' property='idSubEmpresa'/>" style="display: none;" id="<bean:write  name='subEmpresas' property='idSubEmpresa'/>" hijo="0"  padre="<bean:write  name='empresas' property='idEmpresa'/>">
															<bean:write  name="subEmpresas" property="nombre"/>
														</option>
														</logic:iterate>
													</logic:iterate>
												</logic:present>
											</select> <small id="subEmpresa-error"
												class="form-text text-danger ml-3 invisible"></small>
										</div>
									</div>
								</div>
								<div class="form-group row pt-4">
									<label for="filtroSubEmpresa" class="col-form-label"></label>
									<div class="col pt-2">
										<input type="text" class="form-control" id="filtroSubEmpresa" placeholder="filtro">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
						
							<div class="form-group col">
		                        <label>Fecha Inicio:</label>
								<div class="form-group row">
									<label for="fecha-inicio" class="col-form-label"><i class="fas fa-calendar-alt fa-2x" aria-hidden="true"></i></label>
									<div class="col">
										<input type="text" class="form-control datepicker" placeholder="Inicio de Campaña" id="fecha-inicio" name="fechaInicio"> 
										<small id="fecha-inicio-error" class="form-text text-danger ml-3 invisible"></small>
									</div>
								</div>
							</div>
							
							<div class="form-group col">
	                        	<label>Fecha Vigencia:</label>
								<div class="form-group row">
									<label for="fecha-vigencia" class="col-form-label"><i class="fas fa-calendar-alt fa-2x" aria-hidden="true"></i></label>
									<div class="col">
										<input type="text" class="form-control datepicker" placeholder="Vigencia de Campaña" id="fecha-vigencia" name="fechaVigencia"> 
										<small id="fecha-vigencia-error" class="form-text text-danger ml-3 invisible"></small>
									</div>
								</div>
							</div>
						</div>
				
						<div class="row">
							
							<div class="form-group col-6">
		                        <label>Monto Compra Minima:</label>
								<div class="form-group row">
									<label for="compraMinima" class="col-form-label"><i class="fas fa-file-alt fa-2x"></i></label>
									<div class="col">
										<input type="text" class="form-control" onsubmit="return false;" onfocus="(this.type='number')" id="compraMinima" name="montoMinimo" placeholder="Monto compra minima">
										<small id="compra-minima-error" class="form-text text-danger ml-3 invisible"></small>
									</div>
								</div>
							</div>
							
							<div class="form-group col pt-4 m-0">
								<div class="form-check pt-3">
									<input class="form-check-input" type="checkbox" id="capturaDatos" name="capturaDatos" checked/> 
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
									<input class="form-check-input" type="radio" name="tipoMonedero" id="inlineRadio-1" value="F" checked> 
									<label class="form-check-label" for="inlineRadio-1">F&iacutesico</</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="tipoMonedero" id="inlineRadio-2" value="V"> 
									<label class="form-check-label" for="inlineRadio-2">Virtual</label>
								</div>
							</div>
							
							
							<div class="form-group col-4">
		                        <label>Cantidad de Monederos:</label>
								<div class="form-group row">
									<label for="cantidad-monederos" class="col-form-label">
									<i class="fas fa-sort-amount-up-alt fa-2x"></i></label>
									<div class="col">
										<input type="text" class="form-control" onsubmit="return false;" onfocus="(this.type='number')" maxlength="8" onfocus="(this.type='number')" id="cantidad-monederos" name="cantidadMonedero" placeholder="Cantidad de Monederos"> 
										<small id="cantidad-monederos-error" class="form-text text-danger ml-3 invisible"></small>
									</div>
								</div>
							</div>
							
							<div class="form-group col-4">
		                        <label>Monto del Monedero:</label>
								<div class="form-group row">
									<label for="monto" class="col-form-label"><i class="fas fa-coins fa-2x"></i></label>
									<div class="col">
										<input type="text" class="form-control" onsubmit="return false;" onfocus="(this.type='number')" onfocus="(this.type='number')" id="monto" name="montoMonedero" placeholder="Monto del Monedero"> 
										<small id="monto-error" class="form-text text-danger ml-3 invisible"></small>
									</div>
								</div>
							</div>
							
							<div class="col">
							</div>
						</div>
						<button id="btn-guardar-campana" class="btn btn-md btn-primary" type="button">Guardar</button>
						<button id="btn-guardar-campana-cargar" class="btn btn-primary hide waves-effect waves-light" type="button" disabled="">
							<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Cargando...
						</button>
					</form>
				</div>
				<p></p>
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
                    <button type="button" class="btn btn-secondary" id="btn-campana-no" data-dismiss="modal">No</button>
                    <button type="button" id="btn-campana" class="btn btn-primary">S&iacute</button>
                </div>
            </div>
        </div>
    </div>

