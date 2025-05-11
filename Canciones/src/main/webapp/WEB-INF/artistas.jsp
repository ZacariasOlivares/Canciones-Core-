<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Artistas</title>
    </head>
    <body>

        <ul>
            <c:forEach var="artista" items="${listaArtistas}">
                <li>
                	<a href="/artistas/detalle/${artista.id}">
                		${artista.nombre} ${artista.apellido}
               		</a>
               	</li>
		    </c:forEach>
        </ul>

		<a href="/canciones">
			<button>Ir a canciones</button>
		</a>
    </body>
</html>