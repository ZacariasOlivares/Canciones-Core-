<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Canciones</title>
	</head>
	<body>

		<table>
			<tr>
				<th>
					Titulo
				</th>
				<th>
					Artista 
				</th>
				<th>
					Detalle
				</th>
			</tr>
			<c:forEach var="cancion" items="${listaCanciones}">
				<tr>
					<td>${cancion.titulo}</td>
					<td>${cancion.artista.nombre} ${cancion.artista.apellido}</td>
					<td><a href="/canciones/detalle/${cancion.id}">Detalle</a></td>
				</tr>
		</c:forEach>
		</table>

		<a href="/canciones/formulario/agregar">
			<button>Agregar Cancion</button>
		</a>
		<a href="/artistas">
			<button>Ir a artistas</button>
		</a>
	</body>
</html>