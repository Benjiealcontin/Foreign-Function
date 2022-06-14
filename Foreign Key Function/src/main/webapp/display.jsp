<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>

<%String name = (String)request.getAttribute("id"); %>

<form action="servlet" method="post">
    <label for="fname">ID</label>
<input type="text" id="fname" name="id" value="<%= name%>"> 
	

    <label for="lname">Department</label>
    <input type="text" id="lname" name="name" placeholder="Your last name..">

  
    <input type="submit" value="Submit">
  </form>
<h2>HTML Table</h2>

<h1></h1>
	<table>
	
	  <tr>
	    <th>ID</th>
	    <th>Department</th>
	  </tr>
	  <%
try{
	final String url = "jdbc:mysql://localhost:3306/bb";
	final String users = "root";
	final String password = "";
	final String dbloader = "com.mysql.jdbc.Driver";
	final String sql = "SELECT employee.name,department.DepName FROM employee JOIN department ON employee.DepID = department.DepartID WHERE employee.DepID='"
			+ name + "'";
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	Class.forName(dbloader);
	con = DriverManager.getConnection(url,users,password);
	pst = con.prepareStatement(sql);
	rs =pst.executeQuery();
	
	while(rs.next()){
		
	
%>
	  <tr>
	    <td><%out.println(rs.getString("Name")); %></td>
	    <td><%out.println(rs.getString("DepName")); %></td>
	  </tr>
		<%} %>

	</table>
	
<%
}catch(Exception e){
	e.printStackTrace();
}

%>

</body>
</html>