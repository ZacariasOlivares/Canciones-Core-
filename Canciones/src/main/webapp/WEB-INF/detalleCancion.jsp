<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Detalle cancion</title>
	</head>
	<body>
		<p>Titulo : ${cancionActual.titulo}</p>
		<p>Autor  : ${cancionActual.autor}</p>
		<p>Artista: ${cancionActual.artista}</p>
		<p>Album  : ${cancionActual.album}</p>
		<p>Genero : ${cancionActual.genero}</p>
		<p>Idioma : ${cancionActual.idioma}</p>
		<p>Fecha de insercion     : ${cancionActual.fechaCreacion}</p>
		<p>Fecha de actualizacion : ${cancionActual.fechaActualizacion}</p>
		<a href="/canciones">Volver a lista de canciones</a>
	</body>
</html>