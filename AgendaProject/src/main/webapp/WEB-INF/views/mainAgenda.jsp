<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">

        <style> <%@include file="/resources/css/bootstrap.css" %> </style>
        <style> <%@include file="/resources/css/custom.css" %> </style>    

<title>LISTADO DE USUARIOS</title>
</head>
<body>
	<div align="center">
		<h1>EMPLEADOS</h1>
		<h3>
			<a href="new">CREAR NUEVO EMPLEADO</a>
		</h3>

		<table border="1" class="table table-hover">
		<thead class="encabezado">
		<tr>
			<th>ID</th>
			<th>ID persona</th>
			<th>Nombre</th>
			<th>Fecha nacimiento</th>
			<th>Acciones</th>
		</tr>
		</thead>
			<c:forEach var="user" items="${userList}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${user.idpersonas}</td>
					<td>${user.nombre}</td>
					<td>${user.fechaNacimiento}</td>
					<td><a href="edit?id=${user.idpersonas}">Modificar</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=${user.idpersonas}">Eliminar</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>