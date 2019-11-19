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

<div id = "border-box">

	<div id = "list-wrapper">
		<div id = "wrapper">
			<div id = "header">
				<h2>Label für Salatproduktion</h2>
			</div>
		</div>
	</div>
	
	<div id = "container">
		<div id = "content">
			<form>
				<input type = "hidden" name="command" value="SEARCH">
				<input type = "text" name ="searchValue">
				<input type = "submit" value="Suchen" class = "add-label-button">
			</form>
			
			
			<form>
			<input type = "button" value = "Label hinzufügen" class = "add-label-button" onClick = "window.location.href='add-label.jsp';return false;">
			</form>
			
			<table>
				<tr>
					<th>Artikelnummer</th>
					<th>Sortiment</th>
					<th>Produktname</th>
					<th>Aktion</th>
				</tr>
				
				<c:forEach var = "label" items = "${labelList}">
					<c:url var = "updateLink" value = "LabelControllerServlet" >
						<c:param name = "command" value ="LOAD"/>
						<c:param name = "id" value ="${label.id }"/>
					</c:url>	
					<c:url var = "deleteLink" value = "LabelControllerServlet" >
						<c:param name = "command" value ="DELETE"/>
						<c:param name = "id" value ="${label.id }"/>
					</c:url>
					<tr>
						<td>${label.artikelnummer}</td>
						<td>${label.sortiment}</td>
						<td>${label.produktname} ${label.namenszusatz}</td>						
						<td><a href= "${updateLink }">Ändern</a> | 
						<a href= "${deleteLink }" onclick="if(!(confirm('Möchtest du dieses Label wirklich löschen?'))) return false">Löschen</a></td>						
					</tr>
				</c:forEach>
				
			</table>
			
		</div>
	</div>
	
</div>
</body>
</html>