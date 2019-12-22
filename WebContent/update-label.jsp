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
	<div id = "border-box">
	<div id = "list-wrapper">
		<div id = "wrapper">
			<div id = "header">
				<h2>Label ändern</h2>
			</div>
		</div>
	</div>
	
	<div id = "container">
		<div id = "content">
			<h3>Allgemeine Angaben</h3>
			<form action="LabelControllerServlet" method="GET">
			<input type="hidden" name = "command" value = "UPDATE"/>
			<input type="hidden" name = "id" value = "${label.id}"/>
			<table>
				<tbody>
					<tr>
						<td><label>Artikelnummer</label></td>
						<td><input type = "text" name = "artikelnummer" value = "${label.artikelnummer}" pattern="[0-9]{1,10}" title="Zahl mit 3 Ziffern, bspw. 224" required></td>
					</tr>
					<tr>
						<td><label>Sortiment (10/20/...)</label></td>
						<td><input type = "text" name = "sortiment" value = "${label.sortiment}" pattern="[0-9]{1,10}" title="Zahl mit 3 Ziffern, bspw. 20" required></td>
					</tr>
					<tr>
						<td><label>Layout ID</label></td>
						<td><input type = "text" name = "layout"value = "${label.layout}" required></td>
					</tr>
					<tr>
						<td><label>Produktbezeichnung</label></td>
						<td><input type = "text" name = "produktbezeichnung" value = "${label.produktname}" required></td>
					</tr>
					<tr>
						<td><label>Namenszusatz</label></td>
						<td><input type = "text" name = "namenszusatz" value = "${label.namenszusatz}" required></td>
					</tr>
					<tr>
						<td><label>Bodentext</label></td>
						<td><input type = "text" name = "bodentext" value = "${label.bodentext}" required></td>
					</tr>
					<tr>
						<td><label>Zutatenliste</label></td>
						<td><textarea rows="15" cols="31" name = "zutatenliste" required>${label.zutatenliste}</textarea></td>
					</tr>
					<tr>
						<td><label>Grammatur</label></td>
						<td><input type = "text" name = "grammatur" value = "${label.grammatur}" pattern="[0-9]{1,10}" title="Zahl mit 1 bis 10 Ziffern, bspw. 220" required></td>
					</tr>
					<tr>
						<td><label>Barcode</label></td>
						<td><input type = "text" name = "barcode" value = "${label.barcode}" required></td>
					</tr>
					</tbody>
			</table>
			<h3>Nährwertangaben</h3>
			<table>
				<tbody>		
					<tr>
						<td><label>Energie in Joule</label></td>
						<td><input type = "text" name = "energie_joule" value = "${label.nutritionFacts.energieJule}" pattern="[0-9]{1,10}[.]{0,1}[0-9]{0,10}" title="Dezimalzahl mit Punkt als Trennzeichen, bspw. 12.5" required></td>
					</tr>
					<tr>
						<td><label>Energie in Kalorien</label></td>
						<td><input type = "text" name = "energie_kalorien" value = "${label.nutritionFacts.energieKalorien}" pattern="[0-9]{1,10}[.]{0,1}[0-9]{0,10}" title="Dezimalzahl mit Punkt als Trennzeichen, bspw. 12.5" required></td>
					</tr>
					<tr>
						<td><label>Fettmenge</label></td>
						<td><input type = "text" name = "fett" value = "${label.nutritionFacts.anteilFett}" pattern="[0-9]{1,10}[.]{0,1}[0-9]{0,10}" title="Dezimalzahl mit Punkt als Trennzeichen, bspw. 12.5" required></td>
					</tr>
					<tr>
						<td><label>Davon gesättigte Fettsäuren</label></td>
						<td><input type = "text" name = "gesaettigte_fettsaeuren" value = "${label.nutritionFacts.anteilGesaettigteFettsaeure}" pattern="[0-9]{1,10}[.]{0,1}[0-9]{0,10}" title="Dezimalzahl mit Punkt als Trennzeichen, bspw. 12.5" required></td>
					</tr>
					<tr>
						<td><label>Kohlenhydrate</label></td>
						<td><input type = "text" name = "kohlenhydrate" value = "${label.nutritionFacts.kohlenhydrate}" pattern="[0-9]{1,10}[.]{0,1}[0-9]{0,10}" title="Dezimalzahl mit Punkt als Trennzeichen, bspw. 12.5" required></td>
					</tr>
					<tr>
						<td><label>Zucker</label></td>
						<td><input type = "text" name = "zucker" value = "${label.nutritionFacts.zuckerAnteil}" pattern="[0-9]{1,10}[.]{0,1}[0-9]{0,10}" title="Dezimalzahl mit Punkt als Trennzeichen, bspw. 12.5" required></td>
					</tr>
					<tr>
						<td><label>Eiweiß</label></td>
						<td><input type = "text" name = "eiweiss" value = "${label.nutritionFacts.eiweissAnteil}" pattern="[0-9]{1,10}[.]{0,1}[0-9]{0,10}" title="Dezimalzahl mit Punkt als Trennzeichen, bspw. 12.5" required></td>
					</tr>
					<tr>
						<td><label>Salz</label></td>
						<td><input type = "text" name = "salz" value = "${label.nutritionFacts.salzAnteil}" pattern="[0-9]{1,10}[.]{0,1}[0-9]{0,10}" title="Dezimalzahl mit Punkt als Trennzeichen, bspw. 12.5" required></td>
					</tr>
				</tbody>
			</table>
			<input type = "submit" value="Speichern" class="save" >
			</form>
			<p><a href="LabelControllerServlet">Zurück zur Übersicht</a></p>
		</div>
	</div>
	</div>
</body>
</html> 