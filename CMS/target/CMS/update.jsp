<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update the customer</title>
</head>
<body>

<form action="update.do" method="post">
	<input type="hidden" name="id" value="${theCustomer.id }" />
	Name:<input type="text" name="name" value="${theCustomer.name}"/><br></br>
	Gender: <input type="radio" name="gender" value="male" id="male"/>
            <label for="male">男</label>
            <input type="radio" name="gender" value="female" id="female"/>
            <label for="female">女</label>
            <br></br>
    Email:<input type="email" name="email" value="${theCustomer.email}" /><br></br>
    Phone:<input type="tel" id="phone" name="phone"
           value="${theCustomer.phone }"
           pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
           required /><br></br>
    Description:<input type="text" name="description" value="${theCustomer.description}" /><br></br>
    <input type="submit" value="SUBMIT" />
</form>
</body>
</html>