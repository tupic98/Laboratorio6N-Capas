
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Labo6</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/formData"
		method="POST" modelAttribute="student">
		<label>Ingrese un nombre: </label>
		<form:input type="text" name="name" path="sName" />

		<label>Ingrese el apellido: </label>
		<form:input type="text" name="lname" path="lName" />

		<label>Ingrese la edad: </label>
		<form:input type="number" name="age" path="sAge" />

		<label>Estado del estudiante: </label>
		<form:radiobutton name="status" path="bActivo" value="true" />
		<label>Activo</label>
		<br>
		<form:radiobutton name="status" path="bActivo" value="false" />
		<label>Inactivo</label>
		<br>

		<input type="submit"
			onclick="window.location.href = ${pageContext.request.contextPath}/"
			value="Agregar estudiante">
	</form:form>
</body>
</html>