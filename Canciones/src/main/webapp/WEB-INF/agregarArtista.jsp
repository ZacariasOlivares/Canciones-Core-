<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Formulario Agregar Artista</title>
	</head>
<body>
      <form:form action="/artistas/procesa/agregar" method="POST" modelAttribute="artista">
            <div>
                <form:label path="nombre">Nombre</form:label>
                <form:input path="nombre"/>
                <span><form:errors path="nombre"/></span>   
            </div>
            <div>
                <form:label path="apellido">Apellido</form:label>
                <form:input path="apellido"/>
                <span><form:errors path="apellido"/></span>   
            </div>
            <div>
                <form:label path="biografia">Biografia</form:label>
                <form:input path="biografia"/>
                <span><form:errors path="biografia"/></span>   
            </div>
            <button>Agregar artista</button>
        </form:form>
        <a href="/artistas">Volver a lista de artistas</a>
</body>
</html>