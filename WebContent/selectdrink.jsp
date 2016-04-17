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
					<li><a href="about.html">About</a></li>
					<li><a href="add.html">Add A Cocktail</a></li>
					<li><a href="select.html">Search Cocktails</a></li>
					<li><a href="#"></a></li>
				</ul>
			</span> </nav>
			<form action="getDrink.pattern" method="GET">
			<select name="drink">
					<c:forEach var="cocktail" items="${Cocktails}">
				<option value="${cocktail.name}">
				${cocktail.name}
		</option>
					</c:forEach>
					</select>
					<span class= "form_button">
				<input type= "submit" name= "submit" value= "submit">
				</span>
					</form>
		</div>


		<footer></footer>
</body>
</html>
