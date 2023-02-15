<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- this line allows you to use everything abt jstl -->

<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Fruit Store</h1>

    <table class="table">
        <tr>
        	<th>Name</th>
        	<th>Price</th>       
        </tr>
        <c:forEach var="eachFruit" items="${fruits}">
        <tr>
        	<td>${eachFruit.name}</td>
        	<td>${eachFruit.price}</td>       
        </tr>
        </c:forEach>
         

    </table>

</body>
</html>