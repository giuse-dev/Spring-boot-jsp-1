<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding Page</title>
</head>
<body>
	<form action="/add" method="post">
		Insert customer id: <input type="number" name="cid"> <br>
		Insert customer name: <input type="text" name="cname"><br>
		Insert customer email: <input type="email" name="cemail"><br>
		<button>Submit</button>
	</form>
</body>
</html>