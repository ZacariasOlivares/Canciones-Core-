<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					Autor 
				</th>
				<th>
					Detalle
				</th>
			</tr>
			<c:forEach var="cancion" items="${listaCanciones}">
				<tr>
					<td>${cancion.titulo}</td>
					<td>${cancion.autor}</td>
					<td><a href="/canciones/detalle/${cancion.id}">Detalle</a></td>
				</tr>
		</c:forEach>
		</table>

		<a href="/canciones/formulario/agregar">
			<button>Agregar Cancion</button>
		</a>
	</body>
</html>