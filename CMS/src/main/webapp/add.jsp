<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add the new customer</title>
</head>
<body>

<h1>New Customer Information</h1>

<form action="add.do" method="post">
	Name:<input type="text" name="name" /><br></br>
	Gender: <input type="radio" name="gender" value="male" id="male"/>
            <label for="male">男</label>
            <input type="radio" name="gender" value="female" id="female"/>
            <label for="female">女</label>
            <br></br>
    Email:<input type="email" name="email" /><br></br>
    Phone:<input type="tel" id="phone" name="phone"
           placeholder="123-456-7890"
           pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
           required /><br></br>
    Description:<input type="text" name="description" /><br></br>
    <input type="submit" value="SUBMIT" />
</form>

</body>
</html>