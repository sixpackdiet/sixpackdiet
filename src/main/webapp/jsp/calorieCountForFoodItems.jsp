<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC -HelloWorld</title>
<script type="text/javascript">
	function submitForm(foodItemId) {
		var form = document.forms["foodItems"] ;
		document.foodItems.action="/ideas/foodItems/"+foodItemId;
		document.foodItems.submit();
	}
</script>

</head>
<body>
	<h2>${message1}</h2>

	<form name="foodItems" method="POST">

		<table border=1>
			<tr>
					<td>Name</td>
					<td>Quantity</td>
					<td>Measurement Unit</td>
					<td>Calories</td>
					<td>Protein</td>
					<td>Carbohydrate</td>
					<td>Fat</td>
					<td>Total Calories</td>
			</tr>
			<c:forEach items="${foodItems}" var="foodItem">
				<tr>
					<td><a href="/ideas/foodItems/${foodItem.id}">${foodItem.name}</a></td>
					<td>${foodItem.quantity}</td>
					<td>${foodItem.measurementUnit}</td>
					<td>${foodItem.calories}</td>
					<td>${foodItem.protein}</td>
					<td>${foodItem.carbohydrate}</td>
					<td>${foodItem.fat}</td>
					<td>&nbsp;</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>