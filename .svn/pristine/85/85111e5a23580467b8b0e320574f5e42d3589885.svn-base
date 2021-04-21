
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<script type="text/javascript" src="resources/js/empresa/formSubEmpresa.js"></script>

<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">Registro de Sub Empresas</h1>
</div>
<div class="container-fluid shadow-lg bg-light">
	<div class="row tarjetas">
		<div class="col-12  col-sm-12 col-md-12">
			<div class="card">
				<div class="card-body m-4">
					<h5 class="card-title">Datos de Sub Empresa</h5>
					<p class="card-text"></p>
					<form action="#" id="form-sub-empresa">
						<div class="row">
							
							<div class="form-group">
		                        <label>Empresa:</label>
								<div class="form-group row pr-2">
									<label for="empresa" class="col-form-label"><i class="fas fa-list-alt fa-2x"></i></label>
									<div class="col">
										<select class="form-control" id="empresa" name="empresa" style="width:150px">
											<option selected value="-1">--</option>
											<logic:present name="listEmpresaRequest" scope="request">
												<logic:iterate id="empresas" name="listEmpresaRequest">
												<option value="<bean:write  name='empresas' property='idEmpresa'/>">
													<bean:write  name="empresas" property="nombre"/>
												</option>
												</logic:iterate>
											</logic:present>
										</select> <small id="empresa-error"
											class="form-text text-danger ml-3 invisible"></small>
									</div>
								</div>
							</div>
							<div class="form-group row pt-4">
								<label for="filtro" class="col-form-label"></label>
								<div class="col pt-2">
									<input type="text" class="form-control" id="filtro" placeholder="Filtro">
								</div>
							</div>
							
							
						</div>
						<div class="form-group">
	                        <label>Nombre Sub Empresa:</label>
							<div class="form-group row">
								<label for="nombre" class="col-form-label"><i class="fas fa-file-alt fa-2x"></i></label>
								<div class="col">
									<input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre de Sub Empresa">
									<small id="nombre-error" class="form-text text-danger ml-3 invisible"></small>
								</div>
							</div>
						</div>
						<button id="btn-guardar-subEmpresa" class="btn btn-md btn-primary" type="button">Guardar</button>
						<button id="btn-guardar-subEmpresa-cargar" class="btn btn-primary hide waves-effect waves-light" type="button" disabled="">
							<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Cargando...
						</button>
					</form>
					<p></p>
				</div>
			</div>
		</div>
	</div>
</div>