<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shaken not stirred!</title>
<link rel="stylesheet" href="./StyleSheet.css">
<link rel="stylesheet" href="./test.css">
</head>
<body>
	<div class="text">
		<div id="container">
			<header>
			<h1>
				<span id="shaken">SHAKEN</span> <span id="stirred">notstirred</span>
			</h1>
			</header>
			<nav> <span id="list">
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="add.html">Add A Cocktail</a></li>
					<li><a href="select.html">Search Cocktails</a></li>
					<li><a href="#"></a></li>
				</ul>
			</span> </nav>
			</div></div>
			<div class= "colleft">
				<h2>${Cocktail.name}</h2>
			<div class="col2">
				<img src="${Cocktail.image}" />
			</div>
			<div class="col1">
				<ul><b>Ingredients</b>
				<p></p>
				<c:forEach var="ingredient" items="${Cocktail.ingredients}">
				<li>
				${ingredient}</li>
				</c:forEach>
				</ul>
				<p>${Cocktail.instructions}</p>
			</div>
				<div class= "editbutton"> <!-- In line block styling -->
				<form action= "editDrink.pattern" method="POST">
				<input type= "submit" name= "submit" value= "Edit">
				<input type= "hidden" name= "delete" value="${Cocktail.name}">
				</form>
				<form action= "deleteDrink.pattern" method="POST">
				<input type= "submit" name= "submit" value= "Delete">
				<input type= "hidden" name= "delete" value="${Cocktail.name}">
				</div>
				</form>
				</div>
			
			<footer></footer>
</body>
</html>
