
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<script type="text/javascript" src="resources/js/campana/listCampanas.js"></script>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h1 class="h2">Lista de Campañas</h1>
</div>

<logic:present name="listCampanaConvenioRequest" scope="request">

		<div class="table-responsive">
		    <table class="table table-striped  table-sm">
		        <thead>
		            <tr>
		                <th>Nombre</th>
		                <th>Editar</th>
		                <th>Cancelar Campaña</th>
		            </tr>
		        </thead>
		        <tbody>
		        	<logic:iterate id="campanasConvenio" name="listCampanaConvenioRequest">
		        		<tr>
		                <td>
		                	<bean:write  name='campanasConvenio' property='nombre'/>
		                </td>
		                
		                	<logic:equal name="campanasConvenio" property="status" value="A" >
		                		<td>
				                    <i class="fas fa-edit fa-lg btn" id="edit-<bean:write  name='campanasConvenio' property='idCampana'/>" data-toggle="modal" aria-hidden="true" onclick='editCampana("<bean:write  name='campanasConvenio' property='idCampana'/>")'></i>
				                </td>
		                		<td id="cancelar-<bean:write  name='campanasConvenio' property='idCampana'/>"><a class="btn btn-md btn-danger" id="cancelar-campana" onclick='modalCancelarCampana("<bean:write  name='campanasConvenio' property='idCampana'/>")'>Cancelar</a></td>
		                	</logic:equal>
		                	<logic:equal name="campanasConvenio" property="status" value="C" >
		                		<td>
				                    <i class="fas fa-edit fa-lg btn" id="edit-<bean:write  name='campanasConvenio' property='idCampana'/>" data-toggle="modal" aria-hidden="true"></i>
				                </td>
		                		 <td id="cancelar-<bean:write  name='campanasConvenio' property='idCampana'/>"><span class="align-middle text-danger">Cancelado</span></td>
		                	</logic:equal>        
		            </tr>
		        	</logic:iterate>
		        </tbody>
		    </table>
		</div>
</logic:present>

<!-- modal-->
   <div class="modal fade" id="modal-campana" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">
                	Estas seguro que deseas Cancelar la Campaña
                </h5>
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">¿Al cancelar la campaña no podra recuperarla nuevamente?</div>
            <div class="modal-footer" id="contendor-button">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                
            </div>
        </div>
    </div>
</div>

