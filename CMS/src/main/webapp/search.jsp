<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Advanced Search</title>
</head>
<body>

<form action="search.do" method="post">
	Name:<input type="text" name="name" /><br></br>
	
    Email:<input type="email" name="email" /><br></br>
    Phone:<input type="tel" id="phone" name="phone"
           placeholder="123-123-1234"
           pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
           required /><br></br>
    <input type="submit" value="SUBMIT" />
</form>

</body>
</html>