<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/SpringTimeliner/css/style.css" rel=stylesheet type="text/css">
                <link href="/SpringTimeliner/css/templates.css" rel=stylesheet type="text/css">
	</head>
	<body>
                    
                    <!-- Header and Nav -->

                    <div class="row">
                      <div class="twelve columns">
                        <div class="panel header">
                           <c:choose>
                                    <c:when test="${connecte}">
                                        <ul class="nav cf">
                                            <li><a href="/SpringTimeliner/mur.htm">Accueil</a></li>
                                            <li><a href="/SpringTimeliner/membres.htm" class="new" attr-new="2">Amis</a></li>
                                            <li><a href="/SpringTimeliner/notifications.htm" class="new" attr-new="3">Notifications</a></li>
                                            <!--<li><a href="/SpringTimeliner/membres.htm" class="new" attr-new="${count_amis}">Amis</a></li>
                                            <li><a href="/SpringTimeliner/notifications.htm" class="new" attr-new="${count_notifications}">Notifications</a></li> -->
                                            <li><a href="/SpringTimeliner/profile.htm?user=${userConnecte.id}">Mon profile</a></li>
                                            <li><a href="/SpringTimeliner/deconnexion.htm">Déconnexion</a></li>
                                          </ul>
                                    </c:when>

                                    <c:otherwise>
                                        <ul class="nav cf">
                                            <li><a href="/SpringTimeliner">Accueil</a></li>
                                            <li><a href="#"> Vous n'êtes pas connecté</a></li>
                                          </ul>
                                    </c:otherwise>
                              </c:choose>
                        </div>
                      </div>
                    </div>

                    <!-- End Header and Nav -->


                    <div class="row">

                      <!-- Main Feed -->
                      <!-- This has been source ordered to come first in the markup (and on small devices) but to be to the right of the nav on larger screens -->
                      <div class="six columns push-three" style="width:70%">