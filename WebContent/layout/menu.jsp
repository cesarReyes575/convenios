

<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
	<div class="sidebar-sticky pt-3">
	
		<ul class="nav flex-column">
           <li class="nav-item">
               <a class="nav-link text-truncate status-collapsed cursor" id="1" data-toggle="collapse" data-target="#submenu1">
                   <i class="fas fa-building"></i>
                   <span class="d-none d-sm-inline">Empresas</span>
                   <i class="fa fa-caret-down" aria-hidden="true"></i>
               </a>
               <div class="collapse" id="submenu1" aria-expanded="false">  
                   <ul class="flex-column pl-2 nav">
                       <li class="nav-item">
                           <a class="nav-link text-truncate" id="2" href="formEmpresa.do">
                               <span class="d-none d-sm-inline">Registro de Empresas</span>
                           </a>
                       </li>
                       <li class="nav-item">
                           <a class="nav-link text-truncate" id="3" href="formSubEmpresa.do">
                               <span class="d-none d-sm-inline">Registro de Sub Empresa</span>
                           </a>
                       </li>
                       <li class="nav-item">
                           <a class="nav-link text-truncate" id="4" href="listEmpresa.do">
                               <span class="d-none d-sm-inline">Lista de Empresas</span>
                           </a>
                       </li> 
                   </ul>
               </div>
           </li>
          <li class="nav-item">
               <a class="nav-link text-truncate status-collapsed cursor" id="5" data-toggle="collapse" data-target="#submenu2">
                  <i class="fad fa-bell"></i>
                  <span class="d-none d-sm-inline">Campañas</span>
                   <i class="fa fa-caret-down" aria-hidden="true"></i>
               </a>
               <div class="collapse" id="submenu2" aria-expanded="false">  
                   <ul class="flex-column pl-2 nav">
                       <li class="nav-item">
                           <a class="nav-link text-truncate" id="6" href="formCampana.do">
                               <span class="d-none d-sm-inline">Registro de Campaña</span>
                           </a>
                       </li>
                       <li class="nav-item">
                           <a class="nav-link text-truncate" id="7" href="listCampana.do">
                               <span class="d-none d-sm-inline">Lista de Campañas</span>
                           </a>
                       </li>
                   </ul>
               </div>
           </li>
           <!-- <li class="nav-item">
               <a class="nav-link text-truncate status-collapsed cursor" id="8" data-toggle="collapse" data-target="#submenu3">
                  <i class="fas fa-user"></i>
                  <span class="d-none d-sm-inline">Reporteria</span>
                   <i class="fa fa-caret-down" aria-hidden="true"></i>
               </a>
               <div class="collapse" id="submenu3" aria-expanded="false">  
                   <ul class="flex-column pl-2 nav">
                       <li class="nav-item">
                           <a class="nav-link text-truncate" id="9" href="descuento.do?method=getListCatTipoDescuento">
                               <span class="d-none d-sm-inline">Reporte General de la Empresa</span>
                           </a>
                       </li>
                       <li class="nav-item">
                           <a class="nav-link text-truncate" id="10" href="grupoDescuento.do?method=getGrupoDescuento">
                               <span class="d-none d-sm-inline">Reporte Monederos Asignados</span>
                           </a>
                       </li>
                       <li class="nav-item">
                           <a class="nav-link text-truncate" id="11" href="grupoDescuento.do?method=getGrupoDescuento">
                               <span class="d-none d-sm-inline">Reporte Redencion</span>
                           </a>
                       </li>
                   </ul>
               </div>
           </li> -->
           <li class='nav-item d-md-none'>
				<a class='nav-link text-truncate cursor' onclick='logout()'>Cerrar Sesi&oacuten</a>
			</li>
       </ul>
		
	</div>
</nav>