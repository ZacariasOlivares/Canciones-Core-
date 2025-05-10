<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Formulario Agregar cancion</title>
    </head>
    <body>
        <form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
            <div>
                <form:label path="titulo">Titulo</form:label>
                <form:input path="titulo"/>
                <span><form:errors path="titulo"/></span>   
            </div>
            <div>
                <form:label path="autor">Autor</form:label>
                <form:input path="autor"/>
                <span><form:errors path="autor"/></span>   

            </div>
            <div>
                <form:label path="artista">Artista</form:label>
                <form:input path="artista"/>
                <span><form:errors path="artista"/></span>   
            </div>
            <div>
                <form:label path="album">Album</form:label>
                <form:input path="album"/>
                <span><form:errors path="album"/></span>   
            </div>
            <div>
                <form:label path="genero">Género</form:label>
                <form:input path="genero"/>
                <span><form:errors path="genero"/></span>   
            </div>
            <div>
                <form:label path="idioma">Idioma</form:label>
                <form:input path="idioma"/>
                <span><form:errors path="idioma"/></span>   
            </div>
            <button>Agregar cancion</button>
        </form:form>
        <a href="/canciones">Volver a lista de canciones</a>
    </body>
</html>