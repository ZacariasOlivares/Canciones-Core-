<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Detalle artista</title>
	</head>
	<body>
			<p>nombre : ${artistaActual.nombre}</p>
			<p>apellido  : ${artistaActual.apellido}</p>
			<p>biografia  : ${artistaActual.biografia}</p>
			
			<p>Fecha de creacion     : ${artistaActual.fechaCreacion}</p>
			<p>Fecha de actualizacion : ${artistaActual.fechaActualizacion}</p>
			
			<p>Lista canciones</p>
			<ul>
				<c:forEach var="cancion" items="${artistaActual.canciones}">
					<li>${cancion.titulo}</li>
				</c:forEach>
			</ul>
			<a href="/artistas">Volver a lista de artistas</a>
	</body>
</html>