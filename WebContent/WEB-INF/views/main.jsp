<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JPA</title>
</head>
<body>
	<h2>Usuarios</h2>
	<table>
		<tr>
			<th>Codigo:</th>
			<th>Name:</th>
			<th>Apellido:</th>
			<th>Age:</th>
			<th>Estado:</th>
		</tr>
		<c:forEach items="${students}" var="student">
			<tr>
				<td>${student.cStudent}</td>
				<td>${student.sName}</td>
				<td>${student.lName}</td>
				<td>${student.sAge}</td>
				<td>${student.activoDelegate}</td>
			</tr>
		</c:forEach>
	</table>
	<h3>Insertar un usuario:</h3>
	<form:form action="${pageContext.request.contextPath}/save"
		method="post">
		<input type="submit" value="Agregar un nuevo usuario">
	</form:form>

	<h3>Eliminar un usuario</h3>
	<form:form action="${pageContext.request.contextPath}/delete"
		method="post">
		<label>Ingrese el nombre del estudiante que quiere eliminar: </label>
		<input type="text" name="cStudent" />
		<input type="submit" value="Eliminar">
	</form:form>
</body>
</html>