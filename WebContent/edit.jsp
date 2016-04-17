<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
			<nav>
				<span id="list">
					<ul>
						<li><a href="index.jsp">Home</a></li>
						<li><a href="about.html">About</a></li>
						<li><a href="add.html">Add A Cocktail</a></li>
						<li><a href="select.html">Search Cocktails</a></li>
						<li><a href="#"></a></li>
					</ul>
				</span>
			</nav>
		</div>
	</div>
	<div>
	<div class="form">
		<form action="changeDrink.pattern" method="GET"> 
			<div class="form_content">
				<input type="hidden" name="name" value= "${Cocktail.name}"></input>
				<p>
				${Cocktail.name}
				</p>
				<br>
				<c:forEach var= "ingredient" items= "${Cocktail.ingredients}">
				<input type="text" name="ingredient" value="${ingredient}"/> 
				<br> 
				</c:forEach> 
				<span class= "form_button">
				<input type="text" name="ingredient"/>
				<input type="text" name="ingredient"/>
				<input type= "submit" name= "submit" value= "submit">
				</span>
					</div>
			<div class="instructions">
				<label><b>Instructions:</b></label><br />
				<textarea name="Text1" value= "${Cocktail.instructions}" cols="30" rows="20"... >${Cocktail.instructions}</textarea>
			</div>
		</form>
		</div>
	</div>
	<footer></footer>
</body>
</html>