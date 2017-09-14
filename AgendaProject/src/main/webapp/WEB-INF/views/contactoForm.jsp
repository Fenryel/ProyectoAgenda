<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">


		<style> <%@include file="/resources/css/bootstrap.css" %> </style>
        <style> <%@include file="/resources/css/custom.css" %> </style> 
        
<title>FORMULARIO DE USUARIOS</title>
</head>
<body>
	<div class="container contenedor">
	<h1>Formulario de ingreso</h1>
	<form action="save" method="post" modelAttribute="user">
		<div class="form-group">
		  <label for="nombre">Nombre</label>
		  <input type="text" class="form-control" id="nombre" path="nombre">
		</div>
		<div class="form-group">
		  <label for="appellido1">Apellido1</label>
		  <input type="text" class="form-control" id="apellido1" path="apellido1">
		</div>
		<div class="form-group">
		  <label for="appellido2">Apellido2</label>
		  <input type="text" class="form-control" id="apellido1" path="apellido2">
		</div>
		<div class="form-group">
		  <label for="dni">DNI</label>
		  <input type="text" class="form-control" id="apellido1" path="dni">
		</div>
		<div class="form-group">
		  <label for="fnacimiento">Fecha nacimiento</label>
		  <input type="date" class="form-control" id="fnacimiento" path="fechaNacimiento">
		</div>
		<div class="form-group">
		  <label for="idpersona">ID persona</label>
		  <input type="text" class="form-control" id="idpersona" path="idEmpleado">
		</div>
		<button type="submit" class="btn btn-default">Agregar contacto</button>
		</form>
</div>
</body>
</html>