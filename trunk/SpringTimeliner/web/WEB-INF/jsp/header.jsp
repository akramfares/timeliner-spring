<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style type="text/css">
			#conteneur{
				margin-left: auto; margin-right: auto; width: 50%; border: 1px solid black
			}	
			#header{
				background:black; color:white; padding: 12px; text-align: center; height: 150px;	
			}
			#contenu{
				padding: 12px	
			}
			a{
				text-decoration: none; color: red;
			}
			a:hover{
				color: blue;
			}

			ul {padding:0; margin:0; list-style-type:none;}
			li { margin-left:5px; float:left; /*pour IE*/ }
			ul li a { display:block; float:left;    width:100px; background-color:#6495ED; color:black; text-decoration:none; text-align:center; padding:5px; border:2px solid; /*pour avoir un effet "outset" avec IE :*/ border-color:#DCDCDC #696969 #696969 #DCDCDC; }
			ul li a:hover { background-color:#D3D3D3; border-color:#696969 #DCDCDC #DCDCDC #696969; } 
			
		</style>
	</head>
	<body>
		<div id="conteneur">
                    <div id="header">
				<h1>Réseau Social</h1>
                                <c:choose>
                                    <c:when test="${connecte}">
                                        <ul>
                                            <li><a href="/SpringTimeliner">Accueil</a></li>
                                            <li><a href="/SpringTimeliner/mur.htm">Mon mur</a></li>
                                        </ul>
                                    </c:when>

                                    <c:otherwise>
                                        Non connecte
                                    </c:otherwise>
                              </c:choose>
				
                                 
			</div>
