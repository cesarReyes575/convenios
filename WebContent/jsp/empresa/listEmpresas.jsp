
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<script type="text/javascript" src="resources/js/empresa/listEmpresas.js"></script>

<style>
	.show {
    display: flex !important;
}	
</style>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">Lista de Empresas Registradas</h1>
</div>
<br>
<logic:present name="listEmpresaRequest" scope="request">
		<div class="table-responsive">
		    <table class="table table-striped table-sm">
		        <thead>
		            <tr>
		                <th scope="col">Nombre</th>
		                <th scope="col">Representante</th>
		                <th scope="col">Direcci&oacuten</th>
		                <th scope="col">Correo</th>
		                <th scope="col">Tel&eacutefono</th>
		            </tr>
		        </thead>
		        <tbody>
		        	<logic:iterate id="empresas" name="listEmpresaRequest">
			            <tr class="accordion-toggle collapsed" id="accordion-<bean:write  name='empresas' property='idEmpresa'/>" data-toggle="collapse" data-parent="#accordion-<bean:write  name='empresas' property='idEmpresa'/>" href="#collapse-<bean:write  name='empresas' property='idEmpresa'/>" style="cursor: pointer">
			                <td class="expand-button"><bean:write  name="empresas" property="nombre"/></td>
			                <td><bean:write  name="empresas" property="nombreRepresentante"/></td>
			                <td><bean:write  name="empresas" property="direccion"/></td>
			                <td><bean:write  name="empresas" property="correo"/></td>
			                <td><bean:write  name="empresas" property="telefono"/></td>
			            </tr>
			            <tr class="hide-table-padding">
			                <td colspan="5">
			                    <div id="collapse-<bean:write  name='empresas' property='idEmpresa'/>" class="row collapse in p-3">
		                    		<div class="col-7">
				                    	<div class="text-center border-bottom">Campañas</div>
				                    	<logic:notEmpty name="empresas" property="campanaConvenios" >
						                    <logic:iterate id="campanas" name="empresas" property="campanaConvenios">
						                        <div class="row">
						                            <div class="col-4"><bean:write  name="campanas" property="nombre"/></div>
						                            <div class="col-4"><bean:write  name="campanas" property="fechaVigencia" format="dd/MM/yy"/></div>
						                            <div class="col-4"><bean:write  name="campanas" property="montoMinimo"/></div>
						                        </div>
						                    </logic:iterate>
					                    </logic:notEmpty>
					                     <logic:empty name="empresas" property="campanaConvenios" >
					                        <div class="row">
					                            <div class="col-12 text-danger">No hay informaci&oacuten</div>
					                        </div>
							            </logic:empty>
						            </div>  
						            <div class="col-5">
						           	 <div class="text-center border-bottom">Sub Empresas</div>
				                    	<logic:notEmpty name="empresas" property="catSubEmpresas" >
						                    <logic:iterate id="subEmpresas" name="empresas" property="catSubEmpresas">
						                        <div class="row">
						                            <div class="col-10"><bean:write  name="subEmpresas" property="nombre"/></div>
						                        </div>
						                    </logic:iterate>
					                    </logic:notEmpty>
					                    <logic:empty name="empresas" property="catSubEmpresas" >
					                        <div class="row">
					                            <div class="col-12 text-danger">No hay informaci&oacuten</div>
					                        </div>
							            </logic:empty>
						            </div>    
			                    </div>
			                </td>
			            </tr>
		            </logic:iterate>
		        </tbody>
		    </table>
		</div>
</logic:present>

