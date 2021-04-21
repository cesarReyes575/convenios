<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; ISO-8859-1">
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="resources/css/login/login.css">

<script type="text/javascript" src="resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="resources/js/bootstrap/bootstrap.min.js"></script>

<!--  Licencia FONT AWESOME -->
<script src="https://kit.fontawesome.com/e6e666248b.js" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function(){
	$('#nombre').focus();
});
</script>
<title>Login Convenios</title>
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<div class="fadeIn first" style="background: #016f7e;">
				<img src="resources/images/devlyn_logo.png" alt="" class="img-fluid" width="200">
			</div>
			<div class="p-4">
				<div>
					<html:form action="/login.do?method=login" method="post">
						<div class="form-group">
							<i class="fas fa-user"></i>
							<html:text styleClass="form-control fadeIn second" property="nombreUsuario" styleId="nombre" />
						</div>
						<div class="form-group">
							<i class="fas fa-key"></i>
							<html:password styleClass="form-control fadeIn third" property="contrasena" />
						</div>
						<div class="p-4">
							<html:submit styleClass="btn btn-secondary">Enviar</html:submit>
						</div>
					</html:form>
					<div class="tarjetas p-3">
						<html:errors property="errors" />
					</div>
				</div>
			</div>
			<div id="formFooter">
				<a class="underlineHover">Cupones Digitales</a>
			</div>
		</div>
	</div>
</body>
</html>
