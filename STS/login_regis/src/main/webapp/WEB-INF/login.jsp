<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Registration</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>

    <h1>Welcome!Join our community!</h1>
    	<h2>Register</h2>
        <form:form action="/register" method="POST" modelAttribute="newUser">
            	
    	<div>
       <form:label path="userName">userName:</form:label>
       <form:errors path="userName"/>
       <form:input path="userName"/>
        
    	</div>
    	
        <div>
       <form:label path="email">Email:</form:label>
       <form:errors path="email"/>
       <form:input path="email"/>
        
    	</div>
    	
    	<div>
       <form:label path="password">Password:</form:label>
       <form:errors path="password"/>
       <form:input path="password"/>
        
    	</div>
    	
       <div>
       <form:label path="confirm">Confirm PW:</form:label>
       <form:errors path="confirm"/>
       <form:input path="confirm"/>
        
    	</div>

           
       <button type="submit">Submit</button>
        </form:form>
        
        
        
        <h2>Login</h2>
        <form:form action="/login" method="POST" modelAttribute="newLoginUser">
            	
    	<div>
       <form:label path="email">Email:</form:label>
       <form:errors path="email"/>
       <form:input path="email"/>
        
    	</div>
    	
        <div>
       <form:label path="password">Password:</form:label>
       <form:errors path="password"/>
       <form:input path="password"/>
        
    	</div>
    	         
       <button type="submit">Submit</button>
 
        </form:form>

</body>
</html>