<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customer</title>
</head>
<body>

<c:forEach items="${listCustomer}" var="customer">
	${customer.id}&nbsp;
	${customer.name}&nbsp;
	${customer.gender}&nbsp;
	${customer.email}&nbsp;
	${customer.phone}&nbsp;
	${customer.description}&nbsp;&nbsp;
	<a href="loadCustomer.do?id=${customer.id}">Update</a>&nbsp;
	<a href="delete.do?id=${customer.id }" onclick="return confirm('Delete ${emp.name }?')">Delete</a><br></br>
	
</c:forEach>
<a href="add.jsp">Add a new customer</a>
<br></br>
<a href="search.jsp">Advanced Search</a>
	



	

</body>
</html>