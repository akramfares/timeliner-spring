<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/SpringTimeliner/css/style.css" rel=stylesheet type="text/css">
	</head>
	<body>
		<div id="conteneur">
                    <div id="header">
				
                                <c:choose>
                                    <c:when test="${connecte}">
                                        <ul class="nav cf">
                                            <li><a href="/SpringTimeliner">Accueil</a></li>
                                            <li><a href="/SpringTimeliner/membres.htm" class="new" attr-new="1">Amis</a></li>
                                            <li><a href="#" class="new" attr-new="4">Messages</a></li>
                                            <li><a href="#" class="new" attr-new="3">Notifications</a></li>
                                            <li><a href="/SpringTimeliner/mur.htm">Mon profile</a></li>
                                            <li><a href="#">Déconnexion</a></li>
                                          </ul>
                                    </c:when>

                                    <c:otherwise>
                                        <ul class="nav cf">
                                            <li><a href="/SpringTimeliner">Accueil</a> | Non connecté</li>
                                          </ul>
                                    </c:otherwise>
                              </c:choose>
				
                                 
			</div>
