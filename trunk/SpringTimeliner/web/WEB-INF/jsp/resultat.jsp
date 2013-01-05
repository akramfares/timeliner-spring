<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/SpringTimeliner/css/style2.css" rel=stylesheet type="text/css">
	</head>
	<body>

            <c:choose>
                                    <c:when test="${connecte}">
                                            <p>${resultat}</p>
                                            <br/>
                                            <a href="mur.htm">Retour à mon mur</a>
                                    </c:when>

                                    <c:otherwise>
                                            <p>${resultat}</p>
                                            <br/>
                                            <a href="index.htm">Retour à l'accueil</a>
                                    </c:otherwise>
                              </c:choose>
                        
        </body>
</html>