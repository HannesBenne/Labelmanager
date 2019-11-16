<%@ page import="java.util.*, de.hannesbenne.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html;"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<link type = "text/css" rel = "stylesheet" href = "CSS/add-label.css">
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
			<h3>Label ändern</h3>
			<form action="LabelControllerServlet" method="GET">
			<input type="hidden" name = "command" value = "UPDATE"/>
			<input type="hidden" name = "id" value = "${label.id}"/>
			"${label.id}"
			<table>
				<tbody>
					<tr>
						<td><label>Artikelnummer</label></td>
						<td><input type = "text" name = "artikelnummer" value = "${label.artikelnummer}"></td>
					</tr>
					<tr>
						<td><label>Sortiment (10/20/...)</label></td>
						<td><input type = "text" name = "sortiment" value = "${label.sortiment}"></td>
					</tr>
					<tr>
						<td><label>Produktbezeichnung</label></td>
						<td><input type = "text" name = "produktbezeichnung" value = "${label.produktname}"></td>
					</tr>
					<tr>
						<td><label>Namenszusatz</label></td>
						<td><input type = "text" name = "namenszusatz" value = "${label.namenszusatz}"></td>
					</tr>
					
					<tr>
						<td><label>Zutatenliste</label></td>
						<td><textarea rows="5" cols="30" name = "zutatenliste"> ${label.zutatenliste} </textarea></td>
					</tr>
					<tr>
						<td><label>Grammatur</label></td>
						<td><input type = "text" name = "grammatur" value = "${label.grammatur}"></td>
					</tr>
					<tr>
						<td><label>Barcode</label></td>
						<td><input type = "text" name = "barcode" value = "${label.barcode}"></td>
					</tr>
					</tbody>
			</table>
			<h4>Nährwertangaben</h4>
			<table>
				<tbody>		
					<tr>
						<td><label>Energie in Joule</label></td>
						<td><input type = "text" name = "energie_joule" value = "${label.nutritionFacts.energieJule}"></td>
					</tr>
					<tr>
						<td><label>Energie in Kalorien</label></td>
						<td><input type = "text" name = "energie_kalorien" value = "${label.nutritionFacts.energieKalorien}"></td>
					</tr>
					<tr>
						<td><label>Fettmenge</label></td>
						<td><input type = "text" name = "fett" value = "${label.nutritionFacts.anteilFett}"></td>
					</tr>
					<tr>
						<td><label>Davon gesättigte Fettsäuren</label></td>
						<td><input type = "text" name = "gesaettigte_fettsaeuren" value = "${label.nutritionFacts.anteilGesaettigteFettsaeure}"></td>
					</tr>
					<tr>
						<td><label>Kohlenhydrate</label></td>
						<td><input type = "text" name = "kohlenhydrate" value = "${label.nutritionFacts.kohlenhydrate}"></td>
					</tr>
					<tr>
						<td><label>Zucker</label></td>
						<td><input type = "text" name = "zucker" value = "${label.nutritionFacts.zuckerAnteil}"></td>
					</tr>
					<tr>
						<td><label>Eiweiß</label></td>
						<td><input type = "text" name = "eiweiss" value = "${label.nutritionFacts.eiweissAnteil}"></td>
					</tr>
					<tr>
						<td><label>Salz</label></td>
						<td><input type = "text" name = "salz" value = "${label.nutritionFacts.salzAnteil}"></td>
					</tr>
				</tbody>
			</table>
			<input type = "submit" value="Speichern" class="save" >
			</form>
			<p><a href="LabelControllerServlet">Zurück zur Übersicht</a></p>
		</div>
	</div>
</body>
</html> 