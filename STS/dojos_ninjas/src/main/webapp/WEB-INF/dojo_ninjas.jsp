<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Dojo page</title>
</head>
<body>

    <h1>${dojo.name} Ninjas</h1>

    <table class="table">
        <tr>
        	<th>First Name</th>
        	<th>Last Name</th> 
        	<th>Age</th>     
        </tr>
        <c:forEach var="eachNinja" items="${dojo.ninjas}">
        <tr>
        	<td>${eachNinja.firstName}</td>  
        	<td>${eachNinja.lastName}</td> 
        	<td>${eachNinja.age}</td> 
         
        </tr>
        </c:forEach>
    </table>

</body>
</html>