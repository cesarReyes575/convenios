<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>

<html>
    <head>
        <meta http-equiv="Conztent-Type" content="text/html; charset=ISO-8859-1">  
        <tiles:insert name="include" />
        <title>
            <tiles:getAsString name="titulo" />
        </title>        
    </head>
    <body>
      <tiles:insert name="header"/>
      <div class="container-fluid">
        <div class="row">
      		<tiles:insert name="menu"/>
      		<div class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
      		<div id="modal-general" class="message-container" ></div>
      			<tiles:insert name="contenido"/>
      		</div>
      	</div>
      </div>
    </body>
</html>