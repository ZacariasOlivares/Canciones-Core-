<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Formulario editar cancion</title>
	</head>
	<body>
        <!-- <p>ID: ${cancion.id}</p> -->
		<form:form action="/canciones/procesa/editar/${cancionActual.id}" method="POST" modelAttribute="cancionActual">
		  	<input type="hidden" name="_method" value="PUT"/>
            <div>
                <form:label path="titulo">Titulo</form:label>
                <form:input path="titulo" type="text"/>
                <span><form:errors path="titulo"/></span>   
            </div>
            <div>
            	<form:label path="artista">Artista</form:label>
			    <form:select path="artista">
			        <form:options items="${listaArtistas}" itemValue="id" itemLabel="nombreCompleto" />
			    </form:select>
			    <span><form:errors path="artista"/></span>   
            </div>
            <div>
                <form:label path="album">Album</form:label>
                <form:input path="album" type="text"/>
                <span><form:errors path="album"/></span>   
            </div>
            <div>
                <form:label path="genero">Género</form:label>
                <form:input path="genero" type="text"/>
                <span><form:errors path="genero"/></span>   
            </div>
            <div>
                <form:label path="idioma">Idioma</form:label>
                <form:input path="idioma" type="text"/>
                <span><form:errors path="idioma"/></span>   
            </div>
            <button>Editar cancion</button>
        </form:form>
        <a href="/canciones">Volver a lista de canciones</a>
	</body>
</html>