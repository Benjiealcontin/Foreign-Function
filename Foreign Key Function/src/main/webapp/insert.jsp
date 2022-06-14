<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${id}</h1>

<form action="servlet" method="post">
    <label for="fname">ID</label>
<input type="hidden" id="fname" name="id" value="${id}"> 
	

    <label for="lname">Content</label>
    <input type="text" id="lname" name="content" placeholder="Your last name..">

  
    <input type="submit" value="Submit">
  </form>
</body>
</html>