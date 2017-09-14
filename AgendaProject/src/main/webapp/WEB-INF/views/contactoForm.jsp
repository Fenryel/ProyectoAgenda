<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">


		<spring:url value="/resources/css/bootstrap.css" var="estilos1" />
		<link href="${estilos1}" rel="stylesheet" />
		
		<spring:url value="/resources/css/custom.css" var="estilos3" />
		<link href="${estilos3}" rel="stylesheet" />		
	
		<spring:url value="css/bootstrap.css" var="estilos2" />
		<link href="${estilos2}" rel="stylesheet" />	
		
        <link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
<title>FORMULARIO DE USUARIOS</title>
</head>
<body>
	<div align="center">
		<h1>FORMULARIO DE CONTACTO</h1>
		<table>
			<form:form action="save" method="post" modelAttribute="user">
				<form:hidden path="idpersonas" />
				<tr>
					<td>Nombre:</td>
					<td><form:input path="nombre" /></td>
				</tr>
				<tr>
					<td>Primer apellido:</td>
					<td><form:input path="apellido1" /></td>
				</tr>
				<tr>
					<td>Segundo apellido:</td>
					<td><form:input path="apellido2" /></td>
				</tr>
				<tr>
					<td>DNI:</td>
					<td><form:input path="dni" /></td>
				</tr>
				<tr>
					<td>Fecha nacimiento:</td>
					<fmt:formatDate value="${user.fechaNacimiento}" var="dateString" pattern="dd/MM/yyyy" />
					<td><form:input path="fechaNacimiento" value="${dateString}" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Guardar Registro" />
					</td>
				</tr>
			</form:form>
		</table>
	</div>

</body>
</html>