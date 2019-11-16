<%@ page import="java.util.*, de.hannesbenne.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html;"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<link type = "text/css" rel = "stylesheet" href = "CSS/style.css">
<title>Label Manager</title>
</head>
<body>

	<div id = "list-wrapper">
		<div id = "wrapper">
			<div id = "header">
				<h2>Label für Salatproduktion</h2>
			</div>
		</div>
	</div>
	
	<div id = "container">
		<div id = "content">
			<!-- add search bar-->
			
			<form>
			<input type = "button" value = "Label hinzufügen" onClick = "window.location.href='add-label.jsp';return false;">
			</form>
			
			<table>
				<tr>
					<th>Artikelnummer</th>
					<th>Sortiment</th>
					<th>Produktname</th>
					<th>Aktion</th>
				</tr>
				
				<c:forEach var = "label" items = "${labelList}">
					<!-- add url tags -->
					<tr>
						<td>${label.artikelnummer}</td>
						<td>${label.sortiment}</td>
						<td>${label.produktname} ${label.namenszusatz}</td>						
						<td><a href= "">Ändern</a> | 
						<a href= "">Löschen</a></td>						
					</tr>
				</c:forEach>
				
			</table>
			
		</div>
	</div>
</body>
</html>